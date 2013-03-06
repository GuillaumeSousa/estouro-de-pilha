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
@Mock(User)
class BadgeServiceTests {

	def badgeService
    void setUp() {
       	badgeService = new BadgeService()
		mockDomain(Badge)
	   new Badge(badgeName: "Autobiographer",
		   description: "Completed all user profile fields"
		   ).save(failOnError: true)
	   new Badge(badgeName: "Supporter",
		   description: "First up vote"
		   ).save(failOnError: true)
	   new Badge(badgeName: "Critic",
		   description: "First down vote"
		   ).save(failOnError: true)
	   new Badge(badgeName: "Nice Answer",
		   description: "Answer score of 10 or more"
		   ).save(failOnError: true)
    }

    void tearDown() {
        // Tear down logic here
    }

    void testCheckAutobiographerBadge() {
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
		badgeService.checkAutobiographerBadge(user.id)
		assertTrue(user.hasTheBadge("Autobiographer"))
		assertEquals(user.badges.size(), 1)	
    }
	
	void testCheckSupporterBadge() {
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
		badgeService.checkSupporterBadge(user)
		assertTrue(user.hasTheBadge("Supporter"))
		assertEquals(user.badges.size(), 1)
	}
	
	void testCheckCriticBadge() {
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
		badgeService.checkCriticBadge(user)
		assertTrue(user.hasTheBadge("Critic"))
		assertEquals(user.badges.size(), 1)
	}
	
	/*void testIncrReputationOfAuthor(){
		mockDomain(Post)
		mockDomain(Question)
		def user = new User(login:"admin@groovyrocks.com",
				password:"adminadmin",
				pseudo:"admin",
				realName:"Administrator",
				role:"admin",
				birthDate : Date.parse("yyyy-MM-dd", "2000-01-01"))
		user.save(validate:false)
		def post = new Question(subject: "my subject", message: "my message")
		post.author = user
		post.save(validate:false)
		badgeService.incrReputationOfAuthor(post.id)
		assertEquals(post.author.reputation, 5)
	}*/
}
