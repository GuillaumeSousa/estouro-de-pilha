package fr.isima.estouroDePilha

class PostController {
	
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() { }
	
	def postService
	def badgeService
	
	def incrVotes(Long id){
		postService.incrVotes(id) 
		badgeService.checkSupporterBadge(session.user)
		render Post.get(id).nbVotes
	}
	
	def decrVotes(Long id){
		postService.decrVotes(id)
		badgeService.checkCriticBadge(session.user)
		render Post.get(id).nbVotes
	}
	
	def sortByDate(Long id){

	}
}
