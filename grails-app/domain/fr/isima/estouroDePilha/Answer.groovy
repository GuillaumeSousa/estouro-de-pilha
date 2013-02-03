package fr.isima.estouroDePilha

import fr.isima.estouroDePilha.Comment;
import fr.isima.estouroDePilha.Question;

class Answer extends Post{
	Boolean isBest = false
	
	static belongsTo = [question:Question]
	static hasMany = [comments:Comment]
}
