package fr.isima.estouroDePilha

class QuestionService {

	def incrViews(Long id){
		def question = Question.get(id)
		question.nbViews++
	}
	
	def addAnswer(Long id, String message){
		def question = Question.get(id)
		def answer = new Answer(question: question, author: question.author, message: message)
		question.addToAnswers(answer)
	}
}
