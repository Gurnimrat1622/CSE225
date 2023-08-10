package com.example.cse225

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_custom_toast.*
import kotlinx.android.synthetic.main.custom_look_toast.*

class CustomToast : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_toast)

        button7.setOnClickListener {
            val vg:ViewGroup?=findViewById(R.id.cl)
            val inflater = layoutInflater
            val layout:View = inflater.inflate(R.layout.custom_look_toast,vg)
            val tv= layout.findViewById<TextView>(R.id.textView6)
            tv.setText("Draw a Custom Toast")
            val toast=Toast(applicationContext)
            toast.duration=Toast.LENGTH_LONG
            toast.setGravity(Gravity.CENTER_VERTICAL,0,100)
            toast.setView(layout)
            toast.show()
        }
    }
}