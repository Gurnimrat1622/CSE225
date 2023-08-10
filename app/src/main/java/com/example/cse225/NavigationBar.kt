package com.example.cse225

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_navigation_bar.*

class NavigationBar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_bar)

        bottom_nav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.search->{
                    setContent("Search")
                    true
                }
                R.id.fav->{
                    setContent("Favorite")
                    true
                }
                R.id.audio->{
                    setContent("Audio")
                    true
                }
                else->false
            }
        }
    }
    fun setContent(s:String){
        textView9.setText(s)
    }
}