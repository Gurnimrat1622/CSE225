package com.example.cse225

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import kotlinx.android.synthetic.main.activity_progress_bar.*

class Progress_Bar : AppCompatActivity() {
    private var i = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress_bar)
        progressBar.visibility = View.INVISIBLE

        button.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            i = progressBar2.progress
            Thread {
                while (i < 100){
                    i+=1
                    Handler(Looper.getMainLooper()).post{
                        progressBar2.progress = i
                        textView3.text = i.toString() + "/" + progressBar2.max
                        if(i==100) {
                            progressBar.visibility = View.INVISIBLE
                        }
                    }
                    try{
                        Thread.sleep(1000)
                    }catch (e:InterruptedException){
                        e.printStackTrace()
                    }
                }
            }.start()
        }
        button4.setOnClickListener {
            progressBar2.progress = 0
            textView3.text = 0.toString() + "/" + progressBar2.max
        }
    }
}