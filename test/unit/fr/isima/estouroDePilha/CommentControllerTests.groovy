package fr.isima.estouroDePilha



import org.junit.*
import grails.test.mixin.*

@TestFor(CommentController)
@Mock(Comment)
class CommentControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/comment/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.commentInstanceList.size() == 0
        assert model.commentInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.commentInstance != null
    }

    void testSave() {
		
		mockDomain(User)
		def user = new User(login:"admin@groovyrocks.com",
			password:"adminadmin",
			pseudo:"admin",
			realName:"Administrator",
			role:"admin",
			birthDate : Date.parse("yyyy-MM-dd", "2000-01-01"))
		user.save(validate:false)
		session.user = user
		
		
		mockDomain(Question)
		def post = new Question(subject: "my subject", message: "my message")
		user.addToQuestions(post)
        controller.save()

        assert model.commentInstance != null
        assert view == '/comment/create'

        response.reset()

        populateValidParams(params)
		post.addToComments(commentInstance)
        controller.save()

        assert response.redirectedUrl == '/question/show/1'
        assert controller.flash.message != null
        assert Comment.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/comment/list'

        populateValidParams(params)
        def comment = new Comment(params)

        assert comment.save(validate:false) != null

        params.id = comment.id

        def model = controller.show()

        assert model.commentInstance == comment
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/comment/list'

        populateValidParams(params)
        def comment = new Comment(params)

        assert comment.save(validate:false) != null

        params.id = comment.id

        def model = controller.edit()

        assert model.commentInstance == comment
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/comment/list'

        response.reset()

        populateValidParams(params)
        def comment = new Comment(params)

        assert comment.save(validate:false) != null

        // test invalid parameters in update
        params.id = comment.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/comment/edit"
        assert model.commentInstance != null

        comment.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/comment/show/$comment.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        comment.clearErrors()

        populateValidParams(params)
        params.id = comment.id
        params.version = -1
        controller.update()

        assert view == "/comment/edit"
        assert model.commentInstance != null
        assert model.commentInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/comment/list'

        response.reset()

        populateValidParams(params)
        def comment = new Comment(params)

        assert comment.save(validate:false) != null
        assert Comment.count() == 1

        params.id = comment.id

        controller.delete()

        assert Comment.count() == 0
        assert Comment.get(comment.id) == null
        assert response.redirectedUrl == '/comment/list'
    }
}
