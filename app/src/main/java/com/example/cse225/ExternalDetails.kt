package com.example.cse225

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_external_details.*
import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.IOException

class ExternalDetails : AppCompatActivity() {
    lateinit var fstream: FileInputStream
    private val filename = "SampleFile.txt"
    private val filepath = "MyFileStorage"
    lateinit var myExternalFile: File
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_external_details)

        try{
            myExternalFile = File(getExternalFilesDir(filepath),filename)
            fstream = FileInputStream(myExternalFile)
            val sbuffer = StringBuffer()
            var i: Int
            while (fstream.read().also { i=it } != -1) {
                sbuffer.append(i.toChar())
                }
                fstream.close()
                val details = sbuffer.toString().split("\n").toTypedArray()
                textView12.text = """
                    Name: ${details[0]}
                    Password: ${details[1]}
                    """.trimIndent()
        }
        catch (e:FileNotFoundException){
            e.printStackTrace()
        }
        catch (e:IOException){
            e.printStackTrace()
        }
        button12.setOnClickListener {
            intent = Intent(this,ExternalStorage::class.java)
            startActivity(intent)
        }
    }
}