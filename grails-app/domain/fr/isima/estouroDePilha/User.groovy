package fr.isima.estouroDePilha

import java.util.Date;
import fr.isima.estouroDePilha.Badge;

class User {

	String pseudo
	String login
	String password
	String realName
	String website
	String location
	Date birthDate
	String aboutMe
	Date registerDate = Calendar.instance.time
	int reputation = 0
	String role= "author"
	
	static hasMany = [badges : Badge]
	
    static constraints = {
		login(blank: false, email : true, unique:true)
		password(blank:false, minSize:8, nullable:false,password:true)
		pseudo(blank:false, unique:true)
		realName(nullable:true)
		website(nullable:true)
		location(nullable:true)
		birthDate(max:new Date())
		aboutMe(nullable:true, maxSize:10000)
		role(inList:["author", "admin"])
    }
	
	def hasTheBadge(String badgeName) {
		def badgeList = badges.toList();
		def hasTheBadge = false;
		for(Badge badge : badgeList) {
			if(badge.badgeName.equals(badgeName)) {
				hasTheBadge = true;
				break;
			}
		}
		hasTheBadge
	}
}
