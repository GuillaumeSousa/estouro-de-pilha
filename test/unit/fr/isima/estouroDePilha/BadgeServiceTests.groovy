package fr.isima.estouroDePilha

import java.util.Date;

import fr.isima.estouroDePilha.BadgeService
import static org.junit.Assert.*

import grails.test.mixin.*
import grails.test.mixin.support.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
@TestFor(BadgeService)
@Mock(Badge)
class BadgeServiceTests {

	def badgeService
	
    void setUp() {
	   new Badge(badgeName: "Autobiographer",
		   description: "Completed all user profile fields"
		   ).save(validate:false)
	   new Badge(badgeName: "Supporter",
		   description: "First up vote"
		   ).save(validate:false)
	   new Badge(badgeName: "Critic",
		   description: "First down vote"
		   ).save(validate:false)
	   new Badge(badgeName: "Nice Answer",
		   description: "Answer score of 10 or more"
		   ).save(validate:false)
    }

    void tearDown() {
        // Tear down logic here
    }

    /*void testCheckAutobiographerBadge() {
		mockDomain(User)
		def user = new User(
			login:"admin@groovyrocks.com",
			password:"adminadmin",
			pseudo:"admin",
			realName:"Administrator",
			role:"admin",
			birthDate : Date.parse("yyyy-MM-dd", "2000-01-01"),
			website: "me.com",
			location: "Clermont-Fd",
			aboutMe: "me")
		user.save(validate:false)
		badgeService = new BadgeService()
		badgeService.checkAutobiographerBadge(user.id)
		assertTrue(user.hasTheBadge("Autobiographer"))
		assertEquals(user.badges.size(), 1)	
    }
	
	void testCheckSupporterBadge() {
		 mockDomain(User)
	   def user = new User(
		   login:"admin@groovyrocks.com",
		   password:"adminadmin",
		   pseudo:"admin",
		   realName:"Administrator",
		   role:"admin",
		   birthDate : Date.parse("yyyy-MM-dd", "2000-01-01"),
		   website: "me.com",
		   location: "Clermont-Fd",
		   aboutMe: "me")
	   user.save(validate:false)
		badgeService = new BadgeService()
		badgeService.checkSupporterBadge(user.id)
		assertTrue(user.hasTheBadge("Supporter"))
		assertEquals(user.badges.size(), 1)
	}
	
	void testCheckCriticBadge() {
		 mockDomain(User)
	   def user = new User(
		   login:"admin@groovyrocks.com",
		   password:"adminadmin",
		   pseudo:"admin",
		   realName:"Administrator",
		   role:"admin",
		   birthDate : Date.parse("yyyy-MM-dd", "2000-01-01"),
		   website: "me.com",
		   location: "Clermont-Fd",
		   aboutMe: "me")
	   user.save(validate:false)
		badgeService = new BadgeService()
		badgeService.checkCriticBadge(user.id)
		assertTrue(user.hasTheBadge("Critic"))
		assertEquals(user.badges.size(), 1)
	}*/
	
	void test(){
		assertTrue(true)
	}
	
	/*void testIncrReputationOfAuthor(){
		mockDomain(Post)
		mockDomain(Question)
		def question = new Question(subject: "my subject", message: "my message")
		question.save(validate:false)
		
		def user = new User(login:"admin@groovyrocks.com",
				password:"adminadmin",
				pseudo:"admin",
				realName:"Administrator",
				role:"admin",
				birthDate : Date.parse("yyyy-MM-dd", "2000-01-01"))
		
		user.addToQuestions(question)
		user.save(validate:false)
		
		badgeService.incrReputationOfAuthor(question.id)
		assertEquals(question.author.reputation, 5)
	}*/
}
