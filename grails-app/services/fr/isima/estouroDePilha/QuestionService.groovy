package fr.isima.estouroDePilha

class QuestionService {

    def serviceMethod() {

    }
	
	def incrVotes(id) {
		def question = Question.get(id)
		question.nbVotes++
	}
	
	def decrVotes(id){
		def question = Question.get(id)
		question.nbVotes--
	}
	
	def incrViews(id){
		def question = Question.get(id)
		question.nbViews++
	}
	
	def addAnswer(id,message){
		
	}
}
