package pl.sfi.warsztat

class Server {
    private val correctLogin = "John"
    private val correctPassword = "Wick"
    fun tryLogin(login:String, password:String): Boolean {
        return login ==correctLogin && password == correctPassword
    }

}