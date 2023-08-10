package com.example.cse225

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

class ColorFragmentDemo2 : Fragment() {
    lateinit var parent:LinearLayout
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v:View= inflater.inflate(R.layout.fragment_color_demo2, container, false)
        parent=v.findViewById(R.id.frag2parent)
        return  v
    }
    fun updateColor(c:Int)
    {
        parent.setBackgroundColor(c)
    }


}
