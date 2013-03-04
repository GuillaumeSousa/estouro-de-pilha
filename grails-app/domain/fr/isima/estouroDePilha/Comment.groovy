package fr.isima.estouroDePilha

class Comment extends Post{
	static belongsTo = [post:Post];
}
