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
	Date registerDate = Calendar.instance.time
	int reputation = 0
	
	static hasMany = [badges : Badge]
	
    static constraints = {
		login(blank: false, email : true, unique:true)
		password(blank:false, minSize:8, nullable:false)
		pseudo(blank:false, unique:true)
		website(nullable:true)
		birthDate(max:new Date())
    }
}
