package fr.isima.estouroDePilha

import fr.isima.estouroDePilha.QuestionService;
import static org.junit.Assert.*

import grails.test.mixin.*
import grails.test.mixin.support.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
@TestFor(QuestionService)
@Mock(Question)
class QuestionServiceTests {

	def questionService
	
    void setUp() {
        questionService = new QuestionService()
    }

    void tearDown() {
        // Tear down logic here
    }

    void testIncrViews() {
		def question = new Question(subject: "my subject", message: "my message")
		question.save(validate: false)
		assertEquals(question.nbViews, 0)
		questionService.incrViews(question.id)
		assertEquals(question.nbViews, 1)
    }
	
	void testAddAnswer(){
		mockDomain(User)
		def user = new User(login:"admin@groovyrocks.com",
				password:"adminadmin",
				pseudo:"admin",
				realName:"Administrator",
				role:"admin",
				birthDate : Date.parse("yyyy-MM-dd", "2000-01-01"))
		user.save(validate:false)
		def question = new Question(subject: "my subject", message: "my message")
		question.save(validate:false)
		questionService.addAnswer(question.id,"my answer", user.id)
		assertEquals(question.answers.size(), 1)
	}
}
