package com.example.cse225


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
//import com.example.navigationbardemo.R

class FragmentChat: Fragment() {
    lateinit var v:View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?  ): View?
    {
        v = inflater.inflate(R.layout.fragment_chat,container,false)
        return  v
    }
}