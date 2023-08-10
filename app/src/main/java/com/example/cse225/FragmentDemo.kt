package com.example.cse225

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class FragmentDemo : AppCompatActivity(),backPressInterface {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_demo)
    }


    override fun backPressClick(msg:String) {
        var obj1 = supportFragmentManager.findFragmentById(R.id.fragment2)as StaticFragmentTwoDemo
        obj1.onFragmentInteraction(msg)

    }
}