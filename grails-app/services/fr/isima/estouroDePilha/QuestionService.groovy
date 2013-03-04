package fr.isima.estouroDePilha

class QuestionService {

	def incrViews(Long id){
		def question = Question.get(id)
		question.nbViews++
	}
	
	def addAnswer(Long id, String message, Long userId){
		def question = Question.get(id)
		def answer = new Answer(question: question, author: User.get(userId), message: message)
		question.addToAnswers(answer)
	}
}
