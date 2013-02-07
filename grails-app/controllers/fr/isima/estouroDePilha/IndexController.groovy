package fr.isima.estouroDePilha

class IndexController {

	def index = {
		[questionList: Question.findAll()] 
	}
}
