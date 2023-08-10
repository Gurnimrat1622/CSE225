package com.example.cse225

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class ColorFragmentDemo1 : Fragment() {
    lateinit var buttonGreen: Button
    @SuppressLint("SuspiciousIndentation", "MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v:View= inflater.inflate(R.layout.fragment_color_demo1, container, false)
        buttonGreen=v.findViewById(R.id.frag1BtnGreen)
        buttonGreen.setOnClickListener{
            val mai=activity as ColorActivityDemo
            mai.newColor(Color.GREEN)
        }
        return  v
    }


}
