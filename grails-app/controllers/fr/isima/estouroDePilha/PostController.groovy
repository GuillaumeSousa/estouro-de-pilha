package fr.isima.estouroDePilha

class PostController {

    def index() { }
	
	def postService
	
	def incrVotes(Long id){
		postService.incrVotes(id) 
		render Post.get(id).nbVotes
	}
	
	def decrVotes(Long id){
		postService.decrVotes(id)
		render Post.get(id).nbVotes
	}
	
	def sortByDate(Long id){

	}
}
