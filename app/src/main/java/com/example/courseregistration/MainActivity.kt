package com.example.courseregistration

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner: Spinner = findViewById(R.id.courseSpinner)
        val studentIdInput: EditText = findViewById(R.id.studentIdInput)
        val registerButton: Button = findViewById(R.id.registerButton)

        val courses = listOf(
            "Select a course",
            "Data Structures",
            "Database Systems",
            "Software Engineering",
            "Computer Architecture",
            "Computer Networks",
            "Distributed Systems",
            "Operating Systems",
            "Automata Theory",
            "Knowledge-Based Systems",
            "Business Intelligence and Analytics"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, courses)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        registerButton.setOnClickListener {
            val selectedCourse = spinner.selectedItem.toString()
            val studentId = studentIdInput.text.toString()

            val idPattern = Regex("^P15\\d{8}$")
            if (selectedCourse == "Select a course" || !idPattern.matches(studentId)) {
                Toast.makeText(
                    this,
                    "Please select a course and enter a valid Student ID (e.g., P1534567890)",
                    Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }

            val intent = Intent(this, ConfirmationActivity::class.java)
            intent.putExtra("course", selectedCourse)
            intent.putExtra("studentId", studentId)
            startActivity(intent)
        }
    }
}
