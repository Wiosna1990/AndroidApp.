package pl.sfi.warsztat
import androidx.lifecycle.ViewModel
class MainViewModel: ViewModel() {
    private val server = Server()

    fun tryLogin(login:String, password:String): User?{
        val success = server.tryLogin(login,password)
        return if (success) User ("Jan", "kowalski@wp.pl")
        else null

    }

}