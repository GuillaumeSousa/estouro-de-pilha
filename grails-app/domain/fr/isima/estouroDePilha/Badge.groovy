package fr.isima.estouroDePilha

import fr.isima.estouroDePilha.User;

class Badge {
	String badgeName
	String description
	
	static hasMany = [users:User]
	static belongsTo = [User]
}
