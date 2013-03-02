package fr.isima.estouroDePilha

import org.springframework.dao.DataIntegrityViolationException

class QuestionController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	def questionService
	
	def beforeInterceptor = [action:this.&auth, except:["index", "list", "show"]]
	
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
        [questionInstanceList: Question.list(params).sort{it.postedDate}.reverse(), questionInstanceTotal: Question.count()]
    }

    def create() {
        [questionInstance: new Question(params)]
    }

    def save() {
        def questionInstance = new Question(params)
		questionInstance.postedDate = Calendar.instance.time
		questionInstance.author = User.findByPseudo(session.user.pseudo)
        if (!questionInstance.save(flush: true)) {
            render(view: "create", model: [questionInstance: questionInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'question.label', default: 'Question'), questionInstance.id])
        redirect(action: "show", id: questionInstance.id)
    }

    def show(Long id) {
        def questionInstance = Question.get(id)
        if (!questionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'question.label', default: 'Question'), id])
            redirect(action: "list")
            return
        }
		questionService.incrViews(id)
        [questionInstance: questionInstance]
    }

    def edit(Long id) {
        def questionInstance = Question.get(id)
        if (!questionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'question.label', default: 'Question'), id])
            redirect(action: "list")
            return
        }

        [questionInstance: questionInstance]
    }

    def update(Long id, Long version) {
        def questionInstance = Question.get(id)
        if (!questionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'question.label', default: 'Question'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (questionInstance.version > version) {
                questionInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'question.label', default: 'Question')] as Object[],
                          "Another user has updated this Question while you were editing")
                render(view: "edit", model: [questionInstance: questionInstance])
                return
            }
        }

        questionInstance.properties = params

        if (!questionInstance.save(flush: true)) {
            render(view: "edit", model: [questionInstance: questionInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'question.label', default: 'Question'), questionInstance.id])
        redirect(action: "show", id: questionInstance.id)
    }

    def delete(Long id) {
        def questionInstance = Question.get(id)
        if (!questionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'question.label', default: 'Question'), id])
            redirect(action: "list")
            return
        }

        try {
            questionInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'question.label', default: 'Question'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'question.label', default: 'Question'), id])
            redirect(action: "show", id: id)
        }
    }
	

	def addAnswer(Long id){
		questionService.addAnswer(id, params.get("messageAnswer"))
		redirect(action: "show", id: id)
	}
	
	def sortAnswersByDate(Long id){
		render template: '/answer/listAnswers', var: 'answer', collection: Answer.findAllByQuestion(Question.get(id), [sort: 'postedDate', order:'desc'])
	}
	
	def sortAnswersByVotes(Long id){	
		render template: '/answer/listAnswers', var: 'answer', collection: Answer.findAllByQuestion(Question.get(id), [sort: 'nbVotes', order:'desc'])
	}
}
