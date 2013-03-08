package fr.isima.estouroDePilha

import org.springframework.dao.DataIntegrityViolationException

class UserController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	def badgeService

	def beforeInterceptor = [action:this.&auth,
		except:["login", "authenticate", "accessProfile", "logout", "list", "show","edit", "update", "choose_avatar", "upload_avatar", "avatar_image","create","save","listUserQuestions","listUserAnswers"]]

	def auth() {
		if( !(session?.user?.role == "admin") ){
			flash.message = "You must be an administrator to perform that task."
			redirect(action:"login",params:params)
			return false
		}
	}

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [userInstanceList: User.list(params).sort{it.reputation}.reverse(), userInstanceTotal: User.count()]
    }

    def create() {
        [userInstance: new User(params)]
    }

    def save() {
        def userInstance = new User(params)
        if (!userInstance.save(flush: true)) {
            render(view: "create", model: [userInstance: userInstance])
            return
        }
		badgeService = new BadgeService()
		badgeService.checkAutobiographerBadge(userInstance.id)
        flash.message = message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), userInstance.id])
        redirect(action: "show", id: userInstance.id)
    }

    def show(Long id) {
        def userInstance = User.get(id)
        if (!userInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "list")
            return
        }

        [userInstance: userInstance]
    }

    def edit(Long id) {
        def userInstance = User.get(id)
        if (!userInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "list")
            return
        }

        [userInstance: userInstance]
    }

    def update(Long id, Long version) {
        def userInstance = User.get(id)
        if (!userInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (userInstance.version > version) {
                userInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'user.label', default: 'User')] as Object[],
                          "Another user has updated this User while you were editing")
                render(view: "edit", model: [userInstance: userInstance])
                return
            }
        }

        userInstance.properties = params

        if (!userInstance.save(flush: true)) {
            render(view: "edit", model: [userInstance: userInstance])
            return
        }
		badgeService = new BadgeService()
		badgeService.checkAutobiographerBadge(userInstance.id)
        flash.message = message(code: 'default.updated.message', args: [message(code: 'user.label', default: 'User'), userInstance.id])
        redirect(action: "show", id: userInstance.id)
    }

    def delete(Long id) {
        def userInstance = User.get(id)
        if (!userInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "list")
            return
        }

        try {
            userInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "show", id: id)
        }
    }
	
	def login = {}
	
	def authenticate = {
	  def user = User.findByLoginAndPassword(params.login, params.password)
	  if(user){
		session.user = user
		flash.message = "Hello ${user.pseudo}!"
		redirect(controller:"index")
	  }else{
		flash.message = "Sorry, ${params.login}. Please try again."
		redirect(action:"login")
	  }
	}
	
	def logout = {
	  flash.message = "Goodbye ${session.user.pseudo}"
	  session.user = null
	  redirect(controller:"index")
	}
	
	def accessProfile = {
		def user = session.user
		if(!user){
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), user.id])
            redirect(action: "list")
            return
		}
		redirect(action: "show", id: user.id)
	}
	
	def choose_avatar() {
		
	}
	
	def upload_avatar = {
		def user = User.get(session.user.id)
	  
	  // Get the avatar file from the multi-part request 
		def f = request.getFile('avatar')
	  
	  // List of OK mime-types 
		def okcontents = ['image/png', 'image/jpeg', 'image/gif'] 
		if (! okcontents.contains(f.getContentType())) { 
			flash.message = "Avatar must be one of: ${okcontents}" 
			render(view:'choose_avatar', model:[user:user]) 
			return; 
		}
	  
	  // Save the image and mime type 
		user.avatar = f.getBytes() 
		user.avatarType = f.getContentType() 
		log.info("File uploaded: " + user.avatarType)
	  
	  // Validation works, will check if the image is too big 
		if (!user.save(flush: true)) {
			flash.message = "Avatar is too big (256K max)"
			render(view:'choose_avatar', model:[user:user]) 
			return; 
		} 
		flash.message = "Avatar (${user.avatarType}, ${user.avatar.size()} bytes) uploaded." 
		redirect(action:"show", id: user.id) 
	}
	
	
	def avatar_image = {
		def avatarUser = User.get(params.id)
		if (!avatarUser || !avatarUser.avatar || !avatarUser.avatarType) {
		  response.sendError(404)
		  return;
		}
		response.setContentType(avatarUser.avatarType)
		response.setContentLength(avatarUser.avatar.size())
		OutputStream out = response.getOutputStream();
		out.write(avatarUser.avatar);
		out.close();
	  }
	
	def listUserQuestions(Long id) {
		def user = User.get(id)
		def questionList = Question.findAllByAuthor(user)
		
		[questionInstanceList: questionList.sort{it.postedDate}.reverse(), questionInstanceTotal: questionList.size()]	
	}
	
	def listUserAnswers(Long id) {
		def user = User.get(id)
		def answerList = Answer.findAllByAuthor(user)
		
		[answerInstanceList: answerList.sort{it.postedDate}.reverse(), answerInstanceTotal: answerList.size()]
	}
	
	

}
