package fr.isima.estouroDePilha

class Tag {
	String tagname
	
	static hasMany = [questions:Question]
}
