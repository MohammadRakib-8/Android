package com.example.fragment_to_fragment_data_passing

import FirstFragment
import SecondFragment
import android.os.Bundle
import android.widget.Button
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
        val button2F: Button = findViewById(R.id.button2)
        val button1F: Button = findViewById(R.id.button1)



        button1F.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerViewMain,FirstFragment())
                .addToBackStack(null)
                .commit()
        }




        button2F.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerViewMain,SecondFragment())
                .addToBackStack(null)
                .commit()
        }

        if(savedInstanceState==null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerViewMain, FirstFragment())
                .commit() }
    }
}