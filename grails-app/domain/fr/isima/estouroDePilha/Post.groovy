package fr.isima.estouroDePilha

class Post {

	Date  	postedDate = Calendar.instance.time
	int 	nbVotes = 0
	String 	message
	
	static belongsTo = [author:User]
	
	static constraints = {
		message(maxSize:10000, nullable:false)
	}
}
