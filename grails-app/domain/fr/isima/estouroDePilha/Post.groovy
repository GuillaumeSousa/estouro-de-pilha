package fr.isima.estouroDePilha

class Post {

	Date  	postedDate
	int 	nbVotes = 0
	String 	message
	
	static belongsTo = [author:User]
	
	static constraints = {
		message(maxSize:10000)
	}
}
