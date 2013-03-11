package fr.isima.estouroDePilha



import org.junit.*

import fr.isima.estouroDePilha.BadgeController;
import grails.test.mixin.*

@TestFor(BadgeController)
@Mock(Badge)
class BadgeControllerTests {


    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        params["badgeName"] = 'Autobiographer'
		params["description"] = 'Completed all user profile fields'
    }

    void testIndex() {
		mockController(BadgeController)
        controller.index()
        assert "/badge/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.badgeInstanceList.size() == 0
        assert model.badgeInstanceTotal == 0
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/badge/list'

        populateValidParams(params)
        def badge = new Badge(params)

        assert badge.save(validate: false) != null

        params.id = badge.id

        def model = controller.show()

        assert model.badgeInstance == badge
    }

}
