package fr.isima.estouroDePilha

import fr.isima.estouroDePilha.Question;

class Tag {
	String tagname
	String description
	
	static hasMany = [questions:Question]
	static belongsTo =[Question]
	
	static constraints = {
		description(maxSize:10000)
	}
}
