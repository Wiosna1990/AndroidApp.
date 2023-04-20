package pl.sfi.warsztat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.net.toUri
import pl.sfi.warsztat.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainVm by viewModels<MainViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("TAG", "onCreate")

        binding.loginBtn.setOnClickListener {
            val login = binding.loginEt.text.toString()
            val password = binding.passEt.text.toString()

            Toast.makeText(applicationContext, "$login $password", Toast.LENGTH_LONG)
                .show()

            if (mainVm.tryLogin(login, password) != null) {
                openHomeActivity()
            }
        }
    }

    private fun openHomeActivity() {
        val sfiUrl = "https://sfi.pl/pl"
        val intent = Intent(Intent.ACTION_VIEW)
            .apply {
                data = sfiUrl.toUri()
            }
        startActivity(intent)
    }
}