package com.example.cse225

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class Fragment_1 : Fragment() {


    override fun onCreateView( inflater: LayoutInflater,   container: ViewGroup?,  savedInstanceState: Bundle? ): View? {
        return inflater.inflate(R.layout.fragment_1, container, false)
    }


}