package com.example.cse225

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_remind_me.*

class RemindME : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_remind_me)
        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.one->{
                    Toast.makeText(this,"Enter Reg no",Toast.LENGTH_LONG).show()
                    true
                }
                R.id.two->{
                    Toast.makeText(this,"Enter Remarks",Toast.LENGTH_LONG).show()
                    true
                }
                R.id.three->{
                    Toast.makeText(this,"Enter Text",Toast.LENGTH_LONG).show()
                    true
                }
                else->false
            }
        }
    }
}

