package fr.isima.estouroDePilha

class PostService {

	def incrVotes(Long id) {
		def post = Post.get(id)
		post.nbVotes++
	}
	
	def decrVotes(Long id){
		def post = Post.get(id)
		post.nbVotes--
	}
	
}
