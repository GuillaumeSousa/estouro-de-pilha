package fr.isima.estouroDePilha

import fr.isima.estouroDePilha.PostService;
import static org.junit.Assert.*

import grails.test.mixin.*
import grails.test.mixin.support.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
@TestFor(PostService)
@Mock(Post)
class PostServiceTests {

	def postService
	
    void setUp() {
        postService = new PostService()
    }

    void tearDown() {
        // Tear down logic here
    }

    void testIncrVotes() {
        def post = new Post(subject: "my subject", message: "my message")
		post.save(validate: false)
		assertEquals(post.nbVotes, 0)
		postService.incrVotes(post.id)
		assertEquals(post.nbVotes, 1)
    }
	
	void testDecrVotes() {
		def post = new Post(subject: "my subject", message: "my message")
		post.save(validate: false)
		assertEquals(post.nbVotes, 0)
		postService.decrVotes(post.id)
		assertEquals(post.nbVotes, -1)
	}
}
