package fr.isima.estouroDePilha

import java.util.logging.Logger;

class BadgeService {

    def checkAutobiographerBadge(Long id){
		def user = User.get(id)
		if(!user.hasTheBadge("Autobiographer")){
			if(user.realName!=null && user.website != null && user.location != null && user.aboutMe != null){
				Badge autobiographer = Badge.find{ badgeName == "Autobiographer" }
				user.addToBadges(autobiographer)
			}
		}
    }
	
	def checkSupporterBadge(Long id)
	{
		def User completeUser = User.get(id) // To avoid lazily initialization
		if(!completeUser.hasTheBadge("Supporter")){
			Badge supporter = Badge.find { badgeName == "Supporter" }
			completeUser.addToBadges(supporter)
		}
	}
	
	def checkCriticBadge(Long id)
	{
		def User completeUser = User.get(id) // To avoid lazily initialization
		if(!completeUser.hasTheBadge("Critic")){
			Badge critic = Badge.find { badgeName == "Critic" }
			completeUser.addToBadges(critic)
		}
	}
	
	def incrReputationOfAuthor(Long postId)
	{
		Post post = Post.get(postId)
		User author = User.get(post.author.id)
		
		log.debug("Method setReputationOfAuthor")
		
		if(post instanceof Question){
			log.debug("Post is a question")
			author.reputation += 5
		}
		if(post instanceof Answer){
			log.debug("Post is an answer")
			author.reputation += 10
		}
		
	}
	
	def decrReputationOfAuthor(Long postId, Long voterId)
	{
		Post post = Post.get(postId)
		User author = User.get(post.author.id)
		User voter = User.get(voterId)
		
		author.reputation -= 2		
		voter.reputation -= 1
	}
	
	def checkNiceAnswerBadge(Long postId)
	{
		Post post = Post.get(postId)
		User author = User.get(post.author.id)
		if(post.nbVotes >= 10){
			if(!author.hasTheBadge("Nice Answer")){
				Badge niceanswer = Badge.find { badgeName == "Nice Answer" }
				author.addToBadges(niceanswer)
			}
		}
	}
}
