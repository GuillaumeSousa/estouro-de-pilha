package fr.isima.estouroDePilha

class Answer extends Post{
	Boolean isBest
	
	static belongsTo = [question:Question]
	static hasMany = [comments:Comment]
}
