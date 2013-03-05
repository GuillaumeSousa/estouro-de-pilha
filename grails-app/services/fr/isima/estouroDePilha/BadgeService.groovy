package fr.isima.estouroDePilha

class BadgeService {

    def checkAutobiographerBadge(Long id){
		def user = User.get(id)
		if(!user.hasTheBadge("Autobiographer")){
			if(user.realName!=null && user.website != null && user.location != null && user.aboutMe != null){
				Badge autobiographer = Badge.find("from Badge as b where b.badgeName='Autobiographer'")
				user.addToBadges(autobiographer)
			}
		}
    }
	
	def checkSupporterBadge(User user)
	{
		if(user){
			def User completeUser = User.get(user.id) // To avoid lazily initialization
			if(!completeUser.hasTheBadge("Supporter")){
				Badge supporter = Badge.find { badgeName == "Supporter" }
				completeUser.addToBadges(supporter)
			}
		}
	}
	
	def checkCriticBadge(User user)
	{
		if(user){
			def User completeUser = User.get(user.id) // To avoid lazily initialization
			if(!completeUser.hasTheBadge("Critic")){
				Badge critic = Badge.find { badgeName == "Critic" }
				completeUser.addToBadges(critic)
			}
		}
	}
}
