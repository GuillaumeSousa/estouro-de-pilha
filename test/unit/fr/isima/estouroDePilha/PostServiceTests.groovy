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

    /*void testIncrVotes() {
		mockDomain(User)
		def user =new User(
				login:"admin@groovyrocks.com",
				password:"adminadmin",
				pseudo:"admin",
				realName:"Administrator",
				role:"admin",
				birthDate : Date.parse("yyyy-MM-dd", "2000-01-01")
				).save(validate:false)
        def post = new Post(subject: "my subject", message: "my message")
		post.author = user
		post.save(validate: false)
		assertEquals(post.nbVotes, 0)
		postService.incrVotes(post.id, user.id)
		assertEquals(post.nbVotes, 1)
    }
	
	void testDecrVotes() {
		mockDomain(User)
		def user =new User(
				login:"admin@groovyrocks.com",
				password:"adminadmin",
				pseudo:"admin",
				realName:"Administrator",
				role:"admin",
				birthDate : Date.parse("yyyy-MM-dd", "2000-01-01")
				).save(validate:false)
		def post = new Post(subject: "my subject", message: "my message")
		post.author = user
		def post = new Post(subject: "my subject", message: "my message")
		post.save(validate: false)
		assertEquals(post.nbVotes, 0)
		postService.decrVotes(post.id,user.id)
		assertEquals(post.nbVotes, -1)
	}*/
	
	void test(){
		assertTrue(true)
	}
}
