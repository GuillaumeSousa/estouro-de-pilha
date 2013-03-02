package fr.isima.estouroDePilha

import org.springframework.dao.DataIntegrityViolationException

class CommentController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def beforeInterceptor = [action:this.&auth, except:["create"]]
	
	def auth() {
		if(!session.user) {
		  redirect(controller:"user", action:"login")
		  return false
		}
	  }
	  
    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [commentInstanceList: Comment.list(params), commentInstanceTotal: Comment.count()]
    }

    def create(Long postId) {
		def idPost = postId
        [commentInstance: new Comment(params), postId : idPost]
    }

    def save() {
        def commentInstance = new Comment(params)
		commentInstance.author = User.findByPseudo(session.user.pseudo)
        if (!commentInstance.save(flush: true)) {
            render(view: "create", model: [commentInstance: commentInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'comment.label', default: 'Comment'), commentInstance.id])
		
		if(commentInstance.post.getClass() == Question.class)
		{
			redirect(controller:"question", action: "show", id: commentInstance.post.id)
		}
		else if (commentInstance.post.getClass() == Answer.class)
		{
			redirect(controller:"question", action: "show", id: commentInstance.post.question.id)
		}
        
    }

    def show(Long id) {
        def commentInstance = Comment.get(id)
        if (!commentInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'comment.label', default: 'Comment'), id])
            redirect(action: "list")
            return
        }

        [commentInstance: commentInstance]
    }

    def edit(Long id) {
        def commentInstance = Comment.get(id)
        if (!commentInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'comment.label', default: 'Comment'), id])
            redirect(action: "list")
            return
        }

        [commentInstance: commentInstance]
    }

    def update(Long id, Long version) {
        def commentInstance = Comment.get(id)
        if (!commentInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'comment.label', default: 'Comment'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (commentInstance.version > version) {
                commentInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'comment.label', default: 'Comment')] as Object[],
                          "Another user has updated this Comment while you were editing")
                render(view: "edit", model: [commentInstance: commentInstance])
                return
            }
        }

        commentInstance.properties = params

        if (!commentInstance.save(flush: true)) {
            render(view: "edit", model: [commentInstance: commentInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'comment.label', default: 'Comment'), commentInstance.id])
        redirect(action: "show", id: commentInstance.id)
    }

    def delete(Long id) {
        def commentInstance = Comment.get(id)
        if (!commentInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'comment.label', default: 'Comment'), id])
            redirect(action: "list")
            return
        }

        try {
            commentInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'comment.label', default: 'Comment'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'comment.label', default: 'Comment'), id])
            redirect(action: "show", id: id)
        }
    }
}
