package com.example.cse225

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_calculator.*

class Calculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        add.setOnClickListener() {
            val t1 = num1.text.toString()
            val t2 = num2.text.toString()
            if (t1.isEmpty() || t2.isEmpty()) {
                Toast.makeText(this, "Enter both values !!", Toast.LENGTH_SHORT).show()
            } else {
                val result = t1.toFloat() + t2.toFloat()
                ress.setText("Result :\n ${t1} + ${t2} = ${result}")
            }
        }
        sub.setOnClickListener() {
            val t1 = num1.text.toString()
            val t2 = num2.text.toString()
            if (t1.isEmpty() || t2.isEmpty()) {
                Toast.makeText(this, "Enter Both Values !!", Toast.LENGTH_SHORT).show()
            } else {
                val result = t1.toFloat() - t2.toFloat()
                ress.setText("Result :\n ${t1} - ${t2} = ${result}")
            }
        }
        mul.setOnClickListener() {
            val t1 = num1.text.toString()
            val t2 = num2.text.toString()
            if (t1.isEmpty() || t2.isEmpty()) {
                Toast.makeText(this, "Enter both values !!", Toast.LENGTH_SHORT).show()
            } else {
                val result = t1.toFloat() * t2.toFloat()
                ress.setText("Result :\n ${t1} * ${t2} = ${result}")
            }
        }
        div.setOnClickListener() {
            val t1 = num1.text.toString()
            val t2 = num2.text.toString()
            if (t1.isEmpty() || t2.isEmpty()) {
                Toast.makeText(this, "Enter both values !!", Toast.LENGTH_SHORT).show()
            } else {
                val result = t1.toFloat() / t2.toFloat()
                ress.setText("Result :\n ${t1} / ${t2} = ${result}")
            }
        }
    }
}