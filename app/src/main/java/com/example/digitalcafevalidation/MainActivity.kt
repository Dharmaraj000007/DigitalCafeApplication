package com.example.digitalcafevalidation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)
        val validateBtn = findViewById<Button>(R.id.validateBtn)

        validateBtn.setOnClickListener {

            val emailText = email.text.toString().trim()
            val passwordText = password.text.toString().trim()

            // Empty validation
            if (emailText.isEmpty() || passwordText.isEmpty()) {
                Toast.makeText(this,
                    "Fields cannot be empty",
                    Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // College email validation
            if (!emailText.endsWith("@college.edu")) {
                Toast.makeText(this,
                    "Enter valid college email",
                    Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Password validation
            val pattern =
                Regex("^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=!]).{12,}$")

            if (!pattern.matches(passwordText)) {
                Toast.makeText(this,
                    "Password must contain Uppercase, Number, Special Symbol & 12 characters",
                    Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            Toast.makeText(this,
                "Validation Successful ✅",
                Toast.LENGTH_LONG).show()
        }
    }
}