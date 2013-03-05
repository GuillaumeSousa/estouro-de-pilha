package fr.isima.estouroDePilha

import fr.isima.estouroDePilha.Answer;
import fr.isima.estouroDePilha.Comment;
import fr.isima.estouroDePilha.Tag;

class Question extends Post{
	String 		subject
	int 		nbViews = 0
	
	static hasMany = [answers:Answer, comments : Comment, tags : Tag]
	
	static mapping = {
		answers cascade: "all-delete-orphan"
		comments cascade: "all-delete-orphan"
   }
}
