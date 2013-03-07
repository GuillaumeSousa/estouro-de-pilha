package fr.isima.estouroDePilha

class PostService {

	def incrVotes(Long idPost, Long idUser) {
		def currentPost = Post.get(idPost)
		def message = ""
		User user = User.get(idUser)
		// If the user has never voted for this post
		if(!Vote.findByPostAndContributor(currentPost, user)){
			VoteUp voteUp = new VoteUp(post: currentPost, contributor: user)
			user.addToVotesUp(voteUp)
			log.info("user has " + user.votesUp.size() + " votesUp")
			currentPost.nbVotes++
		}
		else{
			message = "You cannot vote several times for a same post"
		}
		
		message
	}
	
	def decrVotes(Long idPost, Long idUser){
		def currentPost = Post.get(idPost)
		def message = ""
		User user = User.get(idUser)
		// If the user has never voted for this post
		if(!Vote.findByPostAndContributor(currentPost, user)){
			VoteDown voteDown = new VoteDown(post: currentPost, contributor: user)
			user.addToVotesDown(voteDown)
			log.info("user has " + user.votesDown.size() + " votesDown")
			currentPost.nbVotes--
		}
		else{
			message = "You cannot vote several times for a same post"
		}
		
		message
	}
	
}
