package fr.isima.estouroDePilha

import fr.isima.estouroDePilha.Question

class IndexController {

	def index = {
		[questionList: Question.findAll(), questionNumber:Question.count()] 
	}
}
