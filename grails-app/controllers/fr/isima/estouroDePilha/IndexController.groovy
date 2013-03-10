package fr.isima.estouroDePilha

import fr.isima.estouroDePilha.Question

class IndexController {

	def index(){
		def questionList = Question.findAll().sort{it.postedDate}.reverse()
		if (questionList.size() > 5)
		{
			questionList = questionList[0..4]
		}
		
		def tagList = Tag.findAll().sort{it.questions.count}.reverse()
		if (tagList.size() > 10)
		{
			tagList = tagList[0..9]
		}
		[questionList: questionList, questionNumber: Question.count(), tagList:tagList]
	}
}
