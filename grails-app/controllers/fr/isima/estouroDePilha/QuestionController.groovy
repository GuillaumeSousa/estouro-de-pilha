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
		questionService = new QuestionService()
		questionService.incrViews(id)
		if(questionInstance.answers)
		{
			questionInstance.answers.sort{it.postedDate}.reverse()
		}
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
			if(questionInstance.answers)
			{
				questionInstance.answers.clear()
			}
			if(questionInstance.comments)
			{
				questionInstance.comments.clear()
			}
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
		questionService = new QuestionService()
		questionService.addAnswer(id, params.get("messageAnswer"),session.user.id)
		redirect(action: "show", id: id)
	}
	
	def sortAnswersByDate(Long id){
		render template: '/answer/listAnswers', var: 'answer', collection: Answer.findAllByQuestion(Question.get(id), [sort: 'postedDate', order:'asc'])
	}
	
	def sortAnswersByVotes(Long id){	
		render template: '/answer/listAnswers', var: 'answer', collection: Answer.findAllByQuestion(Question.get(id), [sort: 'nbVotes', order:'desc'])
	}
	
	def deleteComment(Long id){
		def comment = Comment.get(id)
		def post = comment.post
		comment.delete(flush: true)
		
		if(comment.post.getClass() == Question.class)
		{
			redirect(controller:"question", action: "show", id: post.id)
		}
		else if (comment.post.getClass() == Answer.class)
		{
			redirect(controller:"question", action: "show", id: post.question.id)
		}
	}
	
	def deleteAnswer(Long id){
		def answer = Answer.get(id)
		def question = answer.question
				
		answer.comments.clear()
		answer.delete(flush: true)
		redirect(action: "show", id: question.id)
	}
}
