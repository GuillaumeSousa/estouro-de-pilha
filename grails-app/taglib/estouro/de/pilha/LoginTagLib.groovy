package estouro.de.pilha

class LoginTagLib {
	
  def loginControl = {
    if(session.user){
      out << """${link(action:"logout", controller:"user"){"Logout"}}"""
    } else {
      out << """${link(action:"login", controller:"user"){"Login"}}"""      
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
			  out << """${link(action:"edit", controller:"user", params:[id:session.user.id]){"Edit"}}"""
		  }
	  } 
  }
	  
  def editQuestionControl = { attrs, body ->
	  if(session.user){
		  if(session.user.id == attrs.authorId || session.user.role == "admin"){
			  out << """${link(action:"edit", controller:"question", params:[id:attrs.questionId]){"Edit"}}"""
		  } 
	  }
  }
}