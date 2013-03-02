package fr.isima.estouroDePilha

import fr.isima.estouroDePilha.Question

class IndexController {

	def index = {
		[questionList: Question.findAll().sort{it.postedDate}.reverse(), questionNumber:Question.count(), tagList:Tag.findAll()] 
	}
}
