package com.example.design_interaction

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var submitBtn = findViewById<Button>(R.id.submitBtn)
        var cancelBtn = findViewById<Button>(R.id.cancelBtn)
        var radio1 = findViewById<RadioButton>(R.id.radio1)
        var radio2 = findViewById<RadioButton>(R.id.radio2)
        var radio3 = findViewById<RadioButton>(R.id.radio3)
        var textView0 = findViewById<TextView>(R.id.textView0)
        var radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        submitBtn.setOnClickListener {

            val selectedID = radioGroup.checkedRadioButtonId

            if (selectedID == -1) {
                Toast.makeText(this, "Please Select One First", Toast.LENGTH_LONG).show()
            } else if (selectedID == radio1.id) {
                Toast.makeText(this,"You Selected Travel",Toast.LENGTH_LONG).show()
            } else if (selectedID == radio2.id) {
               Toast.makeText(this,"You Selected Reading",Toast.LENGTH_SHORT).show()
            } else if (selectedID == radio3.id) {
                Toast.makeText(this,"You Selected Gym",Toast.LENGTH_LONG).show()
            }

        }
        cancelBtn.setOnClickListener {

            radioGroup.clearCheck()
            Toast.makeText(this, "Cleared Selected Option :)", Toast.LENGTH_LONG).show()


        }
    }
}