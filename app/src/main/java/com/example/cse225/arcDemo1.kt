package com.example.cse225

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class arcDemo1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val d = ArcDemo(this)
        super.onCreate(savedInstanceState)
        setContentView(d)
    }
}