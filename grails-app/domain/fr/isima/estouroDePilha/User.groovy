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
	byte[] avatar
	String avatarType
	String role= "author"
	
	static hasMany = [answers:Answer, questions:Question, comments:Comment, badges : Badge]
	
    static constraints = {
		login(blank: false, email : true, unique:true)
		password(blank:false, minSize:8, nullable:false,password:true)
		pseudo(blank:false, unique:true)
		realName(nullable:true)
		website(nullable:true)
		location(nullable:true)
		birthDate(max:new Date())
		aboutMe(nullable:true, maxSize:10000)
		avatar(nullable:true, maxSize: 262144 /* 256K */)
		avatarType(nullable:true)
		role(inList:["author", "admin"])
    }
	
	def hasTheBadge(String badgeName) {
		def hasTheBadge = false
		if(badges)
		{
			def badgeList = badges.toList()
			
			for(Badge badge : badgeList) {
				if(badge.badgeName.equals(badgeName)) {
					hasTheBadge = true
					break
				}
			}
		}
		hasTheBadge
	}
}
