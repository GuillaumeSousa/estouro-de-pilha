package fr.isima.estouroDePilha

import java.util.Date;
import fr.isima.estouroDePilha.Badge;

class User {

	String pseudo
	String login
	String password
	String website
	String location
	Date birthDate
	Date registerDate
	int reputation
	
	//static hasMany = [badges : Badge]
	
    static constraints = {
    }
}
