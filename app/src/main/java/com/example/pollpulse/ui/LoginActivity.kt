package com.example.pollpulse.ui


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.pollpulse.R

class LoginActivity : AppCompatActivity() {
    private lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        button = findViewById(R.id.login)
        button.setOnClickListener(View.OnClickListener { view: View? ->
            this.click(
                view
            )
        })
    }

    private fun click(view: View?) {
        val intent = Intent(
            this,
            VerificationPageActivity::class.java
        )
        startActivity(intent)
    }
}