package com.example.cse225

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Touch : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val d = TouchDemo(this)
        super.onCreate(savedInstanceState)
        setContentView(d)
    }
}