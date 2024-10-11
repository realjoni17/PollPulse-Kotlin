package com.example.pollpulse.ui


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.pollpulse.R
import com.example.pollpulse.data.AuthenticationRepositoryImpl
import com.example.pollpulse.ui.viewmodels.AuthenticationViewModel
import com.example.pollpulse.ui.viewmodels.AuthenticationViewModelFactory

class LoginActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button


    private val viewModel: AuthenticationViewModel by viewModels {
        AuthenticationViewModelFactory(AuthenticationRepositoryImpl())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        emailEditText = findViewById(R.id.email_edt)
        passwordEditText = findViewById(R.id.password_edt)
        loginButton = findViewById(R.id.login)

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()


            viewModel.signIn(email, password) { success ->
                if (success) {

                    val intent = Intent(this, VerificationPageActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {

                    Toast.makeText(this, "Login failed. Please check your credentials.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}