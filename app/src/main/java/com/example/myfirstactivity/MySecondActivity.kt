package com.example.myfirstactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MySecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_my_second)
    }

    override fun onResume() {
        super.onResume()

        Toast.makeText(this,"hola",Toast.LENGTH_LONG).show()
    }
}