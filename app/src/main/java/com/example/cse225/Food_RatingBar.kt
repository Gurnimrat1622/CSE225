package com.example.cse225

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_food_rating_bar.*
import kotlin.math.floor

class Food_RatingBar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_rating_bar)
        var x1 = ratingBar2.rating
        var x2 = ratingBar3.rating
        var x3 = ratingBar4.rating
        var x4 = ratingBar6.rating

        button3.setOnClickListener {
            val val1= ratingBar2.rating
            val val2= ratingBar3.rating
            val val3= ratingBar4.rating
            val val4= ratingBar6.rating
            var overall =  val1+ val2 + val3 + val4
            var avg = overall/4;
            ratingBar7.rating = avg
            Toast.makeText(this,"Overall Rating is:"+ avg ,Toast.LENGTH_SHORT).show()
        }

        ratingBar2.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
             x1 = ratingBar2.rating;
            var average = (x1 + x2 + x3 + x4 )/4
            ratingBar7.rating = average
            Toast.makeText(this,"you have given new overall rating $average \n",Toast.LENGTH_SHORT).show()
            if(fromUser){
                Toast.makeText(this,"change done by user",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this,"change not done by user",Toast.LENGTH_SHORT).show()
            }
        }
        ratingBar3.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            x2 = ratingBar2.rating;
            var average = (x1 + x2 + x3 + x4 )/4
            ratingBar7.rating = average
            Toast.makeText(this,"you have given new overall rating $average \n",Toast.LENGTH_SHORT).show()
            if(fromUser){
                Toast.makeText(this,"change done by user",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this,"change not done by user",Toast.LENGTH_SHORT).show()
            }
        }
        ratingBar4.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            x3 = ratingBar2.rating;
            var average = (x1 + x2 + x3 + x4 )/4
            ratingBar7.rating = average
            Toast.makeText(this,"you have given new overall rating $average \n",Toast.LENGTH_SHORT).show()
            if(fromUser){
                Toast.makeText(this,"change done by user",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this,"change not done by user",Toast.LENGTH_SHORT).show()
            }
        }
        ratingBar6.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            x4 = ratingBar2.rating;
            var average = (x1 + x2 + x3 + x4 )/4
            ratingBar7.rating = average
            Toast.makeText(this,"you have given new overall rating $average \n",Toast.LENGTH_SHORT).show()
            if(fromUser){
                Toast.makeText(this,"change done by user",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this,"change not done by user",Toast.LENGTH_SHORT).show()
            }
        }

        ratingBar7.setOnRatingBarChangeListener { ratingBar, fl, b ->
            if(b){
                Toast.makeText(this,"overall change done by user",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this,"overall change not done by user",Toast.LENGTH_SHORT).show()
            }
        }
    }
}