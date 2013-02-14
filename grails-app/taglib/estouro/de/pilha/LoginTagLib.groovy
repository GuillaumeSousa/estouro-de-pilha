package estouro.de.pilha

class LoginTagLib {
	
  def loginControl = {
    if(session.user){
      out << """${link(action:"logout", controller:"user"){"Logout"}}"""
    } else {
      out << """${link(action:"login", controller:"user"){"Login"}}"""      
    }
  }
  
}