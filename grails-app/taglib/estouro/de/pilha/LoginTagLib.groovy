package estouro.de.pilha

class LoginTagLib {
	
  def loginControl = {
    if(session.user){
      out << """${link(action:"logout", controller:"user"){"${message(code: 'loginTagLib.logout', default: 'Log out')}"}}"""
    } else {
      out << """${link(action:"login", controller:"user"){"${message(code: 'loginTagLib.login', default: 'Log in')}"}}"""      
    }
  }
  
  def profileControl = {
	  if(session.user){
		out << """${link(action:"accessProfile", controller:"user"){session.user.pseudo}}"""
    } else {  
	  // nothing to show if no user is connected  
	}
  }
  
  def editUserControl = { attrs, body ->
	  if(session.user){
		  if(session.user.id == attrs.shownUserId){ 
			  out << """${link(action:"edit", controller:"user", params:[id:session.user.id]){"${message(code: 'loginTagLib.edit', default: 'Edit')}"}}"""
		  }
	  } 
  }
	  
  def editQuestionControl = { attrs, body ->
	  if(session.user){
		  if(session.user.id == attrs.authorId || session.user.role == "admin"){
			  out << """${link(class:"edit", action:"edit", controller:"question", params:[id:attrs.questionId]){"${message(code: 'loginTagLib.edit', default: 'Edit')}"}}"""
		  } 
	  }
  }
  
  def deleteCommentControl = {attrs, body->
	  if(session.user){
		  if(session.user.role == "admin"){
			out << """${link(action:"deleteComment", controller:"question", params:[id:attrs.commentId]){"${message(code: 'loginTagLib.delete', default: 'Delete')}"}}"""
		  }
	  }
  }
  
  def deleteAnswerControl = {attrs, body->
	  if(session.user){
		  if(session.user.role == "admin"){
		out << """${link(action:"deleteAnswer", controller:"question", params:[id:attrs.answerId]){"${message(code: 'loginTagLib.delete', default: 'Delete')}"}}"""
		  }
	  }
  }
  
  def addTagControl = {attrs, body->
	  if(session.user){
		  if(session.user.role == "admin"){
			out << """${link(class: "create", action:"create", controller:"tag"){"${message(code: 'loginTagLib.newTag', default: 'New Tag')}"}}"""
		  }
	  }
  }
  
  def newUserControl = {attrs, body->
	  if(!session.user){
		out << """${link(action:"create", controller:"user"){"${message(code: 'loginTagLib.newUser', default: 'New User')}"}}"""
	  }
  }
  
  def changeAvatarControl = {attrs, body->
	  if(session.user){
		  if(session.user.id == attrs.profileUserId){
			  out << """${link(action:"choose_avatar", controller:"user", params:[id:session.user.id]){"${message(code: 'user.editAvatar', default: 'Change avatar')}"}}"""
		  }
		  
	  }
  }
  
  def editTagControl = {attrs, body->
	  if(session.user){
		  if(session.user.role == "admin"){
			  out << """${link(class:"edit", action:"edit", controller:"tag", params:[id:attrs.tagId]){"${message(code: 'defaut.button.edit.label', default: 'Edit')}"}}"""
		  }
	  }
  }
  
}