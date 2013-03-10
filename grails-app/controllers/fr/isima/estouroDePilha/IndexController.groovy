package fr.isima.estouroDePilha

import fr.isima.estouroDePilha.Question

class IndexController {

	def index(Integer max){
		def questionList = Question.findAll().sort{it.postedDate}.reverse()
		def questionNumber = questionList.size()
		def tagList = Tag.findAll().sort{it.questions.count}.reverse()
		if (tagList.size() > 10)
		{
			tagList = tagList[0..9]
		}
		[questionList: questionList, questionNumber: questionNumber, tagList:tagList]
	}
}
