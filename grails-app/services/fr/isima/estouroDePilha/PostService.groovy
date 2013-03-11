package fr.isima.estouroDePilha

import org.springframework.context.i18n.LocaleContextHolder as LCH

class PostService {

	def badgeService
	def grailsApplication
	
	def incrVotes(Long idPost, Long idUser) {
		def currentPost = Post.get(idPost)
		User user = User.get(idUser)
		// If the user is not trying to vote to his own post
		if(user.id != currentPost.author.id){
			// If the user has never voted for this post
			if(!Vote.findByPostAndContributor(currentPost, user)){
				VoteUp voteUp = new VoteUp(post: currentPost, contributor: user)
				user.addToVotesUp(voteUp)
				log.info("user has " + user.votesUp.size() + " votesUp")
				currentPost.nbVotes++
				// Update reputation
				badgeService = new BadgeService()
				badgeService.incrReputationOfAuthor(idPost)
				badgeService.checkSupporterBadge(idUser)
				badgeService.checkNiceAnswerBadge(idPost)
			}
			else{
				log.info("User is trying to vote several times for a same post")
			}
		}
		else{
			log.info("User is trying to vote to his own post")
			
		}
	}
	
	def decrVotes(Long idPost, Long idUser){
		def currentPost = Post.get(idPost)
		User user = User.get(idUser)
		// If the user is not trying to vote to his own post
		if(user.id != currentPost.author.id){
			// If the user has never voted for this post
			if(!Vote.findByPostAndContributor(currentPost, user)){
				VoteDown voteDown = new VoteDown(post: currentPost, contributor: user)
				user.addToVotesDown(voteDown)
				log.info("user has " + user.votesDown.size() + " votesDown")
				currentPost.nbVotes--
				// Update reputation
				badgeService = new BadgeService()
				badgeService.decrReputationOfAuthor(idPost, idUser)
				badgeService.checkCriticBadge(idUser)
			}
			else{
				log.info("User is trying to vote several times for a same post")
			}
		}
		else{
			log.info("User is trying to vote to his own post")
		}
	}
	
}
