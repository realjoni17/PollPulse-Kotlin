package com.example.pollpulse.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.pollpulse.R
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import com.example.pollpulse.data.AuthenticationRepositoryImpl
import com.example.pollpulse.ui.viewmodels.AuthenticationViewModel
import com.example.pollpulse.ui.viewmodels.AuthenticationViewModelFactory

class SignUpActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var signUpButton: Button


    private val viewModel: AuthenticationViewModel by viewModels {
        AuthenticationViewModelFactory(AuthenticationRepositoryImpl())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_page)

        emailEditText = findViewById(R.id.email_edt)
        passwordEditText = findViewById(R.id.password_edt)
        signUpButton = findViewById(R.id.signin)

        signUpButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()


            viewModel.signUp(email, password) { success ->
                if (success) {

                    val intent = Intent(this, VerificationPageActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {

                    Toast.makeText(this, "Sign-up failed. Please try again.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
