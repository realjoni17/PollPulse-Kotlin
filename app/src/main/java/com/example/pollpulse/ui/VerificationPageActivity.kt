package com.example.pollpulse.ui

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.pollpulse.R
import com.chaos.view.PinView

class VerificationPageActivity : AppCompatActivity() {
    private lateinit var pinView: PinView
    private lateinit var verifyButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verification_page)

        pinView = findViewById(R.id.pinView)
        verifyButton = findViewById(R.id.button1)

        pinView.requestFocus()

        val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.toggleSoftInput(
            InputMethodManager.SHOW_FORCED,
            InputMethodManager.HIDE_IMPLICIT_ONLY
        )

        verifyButton.setOnClickListener(View.OnClickListener { showDialog() })

        pinView.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                // Remove showDialog() call here
            }

            override fun afterTextChanged(editable: Editable) {
            }
        })
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.custom_dialog)
        val button1 = dialog.findViewById<Button>(R.id.button) // Use dialog's view
        button1.setOnClickListener { navigate() }
        dialog.window!!.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.setCancelable(true)
        dialog.show()
    }

    private fun navigate() {
        val intent = Intent(
            this,
            DashboardActivity::class.java
        )
        startActivity(intent)
    }
}