package fr.isima.estouroDePilha

class Comment extends Post{
	static belongsTo = [question:Question];
}
