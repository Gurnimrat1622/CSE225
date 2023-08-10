package com.example.cse225

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RatingBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_rating_bar.*

class RatingBar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rating_bar)

        button2.setOnClickListener {

            Toast.makeText(applicationContext,"Your rating ="+ratingBar5.rating,Toast.LENGTH_SHORT).show()
        }
      ratingBar.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
          Toast.makeText(this,"Rating $rating",Toast.LENGTH_SHORT).show()
      }

    }
}