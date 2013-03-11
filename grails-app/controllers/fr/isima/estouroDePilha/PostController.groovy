package fr.isima.estouroDePilha

import org.springframework.web.servlet.ModelAndView

class PostController {
	
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() { }
	
	def postService
	def badgeService
	
	def incrVotes(Long id){
		log.info("incrVotes is called")
		def messageToDisplay = ""
		// If user is connected, his vote is taken into account
		if(session.user){
			messageToDisplay = postService.incrVotes(id, session.user.id) 
		}
		// Else, his vote is not taken into account
		else{
			log.info("User not connected tries to vote")
			//flash.message = "${message(code: 'post.notconnected.trytovote.message', default: 'Error : not connected')}"
			//TODO : try to display this fucking message
		}
		render Post.get(id).nbVotes
		render messageToDisplay
	}
	
	def decrVotes(Long id){
		log.info("incrVotes is called")
		def messageToDisplay = ""
		// If user is connected, his vote is taken into account
		if(session.user){
			messageToDisplay = postService.decrVotes(id, session.user.id)
		}
		// Else, his vote is not taken into account
		else{
			log.info("User not connected tries to vote")
			//flash.message = "${message(code: 'post.notconnected.trytovote.message', default: 'Error : not connected')}"
			//TODO : try to display this fucking message
		}
		render Post.get(id).nbVotes
	}
	
	def sortByDate(Long id){

	}
}
