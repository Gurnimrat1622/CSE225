package com.example.cse225

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager

class DynamicFragmentDemo : AppCompatActivity() {
    val fm:FragmentManager=supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dynamic_fragment_demo)

    }
    fun onClickFirst(v:View)
    {
         val ft=fm.beginTransaction()
         ft.add(R.id.frameLayout,BlankFragmentDynamic1())
        ft.addToBackStack(null)
        ft.commit()
    }
    fun onClickSecond(v: View)
    {
        val ft=fm.beginTransaction()
        ft.add(R.id.frameLayout,BlankFragmentDynamic2())
        ft.addToBackStack(null)
        ft.commit()

    }
}