package fr.isima.estouroDePilha

import fr.isima.estouroDePilha.Question

class IndexController {

	def index(Integer max){
		def questionList = Question.findAll().sort{it.postedDate}.reverse()
		def questionNumber = questionList.size()
		[questionList: questionList, questionNumber: questionNumber, tagList:Tag.findAll().sort{it.questions.count}.reverse()]
	}
}
