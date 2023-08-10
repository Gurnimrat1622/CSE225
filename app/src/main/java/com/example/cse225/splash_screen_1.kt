package com.example.cse225

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.os.postDelayed

class splash_screen_1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen1)

            /*  Handler().postDelayed(Runnable {
                  val i = Intent(this@MainActivity, SplashScreenExampleMain::class.java)
                  startActivity(i)
                  finish()
              }, 5000)
      */

            Handler(Looper.getMainLooper()).postDelayed({
                val i = Intent(this@splash_screen_1, splash_screen_2::class.java)
                startActivity(i)
                finish()
            }, 5000)
        }
}