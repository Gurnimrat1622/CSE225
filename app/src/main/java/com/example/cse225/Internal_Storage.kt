package com.example.cse225

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager.InvalidDisplayException
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Internal_Storage : AppCompatActivity() {
    lateinit var b1:Button
    lateinit var b2:Button
    lateinit var ed:EditText
    lateinit var tv:TextView
    lateinit var data:String
    lateinit var file:String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_internal_storage)

        b1=findViewById(R.id.button10)
        b2=findViewById(R.id.button11)
        ed=findViewById(R.id.editTextTextPersonName2)
        tv=findViewById(R.id.textView10)

        b1.setOnClickListener {
            data=ed.text.toString()
            try {
                val fout = openFileOutput(file, MODE_APPEND)
                fout.write(data.toByteArray())
                fout.close()
                Toast.makeText(this,"file saved",Toast.LENGTH_LONG).show()
            }
            catch (to:InvalidDisplayException){
                to.printStackTrace()
            }
        }
        b2.setOnClickListener {
            try {
                val fin=openFileInput(file)
                var c:Int
                var temp=""
                while(fin.read().also { c=it }!=-1)
                {
                    temp+=c.toChar().toString()

                }
                tv.text=temp
                Toast.makeText(this,"Read",Toast.LENGTH_LONG).show()
            }
            catch(e:java.lang.Exception){

            }
        }

    }
}