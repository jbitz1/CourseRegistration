package com.example.courseregistration

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ConfirmationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)

        val confirmationMessage: TextView = findViewById(R.id.confirmationMessage)
        val backButton: Button = findViewById(R.id.backButton)

        val course = intent.getStringExtra("course")
        val studentId = intent.getStringExtra("studentId")

        confirmationMessage.text = "✅ You have successfully registered for:\n\n$course\n\n📘 Student ID: $studentId"

        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
