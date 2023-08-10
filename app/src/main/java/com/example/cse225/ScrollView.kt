package com.example.cse225

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.custom_alert.view.*

class ScrollView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll_view)
        // setContentView(R.layout.activity_scroll_view)   // vertical
        setContentView(R.layout.horizontal_scrollview) // horizontal
    }
        override fun onBackPressed() {

            val customRating = LayoutInflater.from(this).inflate(R.layout.custom_alert, null)

            var builder = AlertDialog.Builder(this)
                .setTitle("Alert Message Dialog")
                .setMessage("This is alert message")
                .setCancelable(false)
                .setView(customRating)

            builder.setPositiveButton("Confirm") { dialogInterface, which ->
                super.onBackPressed()
                val ratingVal = customRating.rb2.rating
                Toast.makeText(this, "Rating is : ${ratingVal} ", Toast.LENGTH_SHORT).show()
                Toast.makeText(this,"Thank You ",Toast.LENGTH_SHORT).show()
            }
            builder.setNegativeButton("Exit") { dialogInterface, which ->
                Toast.makeText(this, "Negative Text Message", Toast.LENGTH_SHORT).show()
            }
            builder.setNeutralButton("Cancel") { dialogInterface, which ->
                Toast.makeText(this, "Neutral/cancel Text Message", Toast.LENGTH_SHORT).show()
            }
            builder.create().show()

        }

}