package fr.isima.estouroDePilha

import org.springframework.web.servlet.ModelAndView

class PostController {
	
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() { }
	
	def postService
	def badgeService
	
	def incrVotes(Long id){
		log.info("incrVotes is called")
		
		// If user is connected, his vote is taken into account
		if(session.user){
			postService.incrVotes(id, session.user.id) 
		}
		// Else, his vote is not taken into account
		else{
			log.info("User not connected tries to vote")
		}
		render Post.get(id).nbVotes
	}
	
	def decrVotes(Long id){
		log.info("incrVotes is called")
		
		// If user is connected, his vote is taken into account
		if(session.user){
			postService.decrVotes(id, session.user.id)
		}
		// Else, his vote is not taken into account
		else{
			log.info("User not connected tries to vote")
		}
		render Post.get(id).nbVotes
	}
}
