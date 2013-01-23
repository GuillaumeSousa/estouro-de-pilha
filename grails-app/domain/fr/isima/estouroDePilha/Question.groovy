package fr.isima.estouroDePilha

class Question extends Post{
	String 		subject
	int 		nbViews
	Date 		activationDate
	
	static hasMany = [answers:Answer, comments : Comment, tags : Tag]
}
