package fr.isima.estouroDePilha

import org.springframework.context.i18n.LocaleContextHolder as LCH

class PostService {

	def badgeService
	def grailsApplication
	
	def incrVotes(Long idPost, Long idUser) {
		def currentPost = Post.get(idPost)
		def messageSource = grailsApplication.getMainContext()
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
				badgeService.incrReputationOfAuthor(idPost)
				badgeService.checkSupporterBadge(idUser)
			}
			else{
				log.info("User is trying to vote several times for a same post")
				//messageToDisplay = ${message(code: 'post.alreadyvoted.trytovote.message', default: 'You have already voted')}
				messageSource.getMessage('post.alreadyvoted.trytovote.message', null, LCH.getLocale())
			}
		}
		else{
			log.info("User is trying to vote to his own post")
			//messageToDisplay = message(code: 'post.userisauthor.trytovote.message', default: 'You cannot vote for your post')
			messageSource.getMessage('post.userisauthor.trytovote.message', null, LCH.getLocale())
			
		}
		
		messageSource
	}
	
	def decrVotes(Long idPost, Long idUser){
		def currentPost = Post.get(idPost)
		def message = ""
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
				badgeService.decrReputationOfAuthor(idPost, idUser)
				badgeService.checkCriticBadge(idUser)
			}
			else{
				log.info("User is trying to vote several times for a same post")
				message = "${message(code: 'post.alreadyvoted.trytovote.message', default: 'You have already voted')}"
			}
		}
		else{
			log.info("User is trying to vote to his own post")
			message = "${message(code: 'post.userisauthor.trytovote.message', default: 'You cannot vote for your post')}"
		}
		
		message
	}
	
}
