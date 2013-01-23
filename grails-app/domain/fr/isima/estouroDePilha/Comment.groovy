package fr.isima.estouroDePilha

import fr.isima.estouroDePilha.Question;

class Comment extends Post{
	static belongsTo = [question:Question];
}
