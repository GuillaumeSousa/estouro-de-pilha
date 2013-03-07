package fr.isima.estouroDePilha

class Vote {
    static belongsTo = [post:Post, contributor:User]
    static constraints = {
    }
}
