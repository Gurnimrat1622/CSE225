package com.example.cse225

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class StaticFragmentOneDemo : Fragment() {
    lateinit var v2:View


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v2= inflater.inflate(R.layout.fragment_static_fragment_one_demo, container, false)
        init(container)
        return v2
    }
    lateinit var backPressLis:backPressInterface
    override fun onAttach(context: Context) {
        super.onAttach(context)
        backPressLis = try {
            activity as backPressInterface
        }
        catch(e:java.lang.ClassCastException)
        {
            throw ClassCastException("class must implement method")
        }
    }
    fun init(v1:ViewGroup?)
    {
        val b1:Button=v2.findViewById(R.id.send)
        val b2:Button=v2.findViewById(R.id.clear)
        b1.setOnClickListener {
            backPressLis.backPressClick("You clicked on Button")
        }
        b2.setOnClickListener {
            backPressLis.backPressClick("")
        }
    }
}