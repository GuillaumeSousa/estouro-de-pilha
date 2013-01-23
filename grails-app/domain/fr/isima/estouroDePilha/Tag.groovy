package fr.isima.estouroDePilha

import fr.isima.estouroDePilha.Question;

class Tag {
	String tagname
	
	static hasMany = [questions:Question]
	static belongsTo =[Question]
}
