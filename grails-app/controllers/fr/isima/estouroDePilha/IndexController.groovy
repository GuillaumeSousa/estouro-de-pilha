package fr.isima.estouroDePilha

//import fr.isim.estouroDePilha.Question

class IndexController {

	def index = {
		[questionList: Question.findAll()] 
	}
}
