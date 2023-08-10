package com.example.cse225

import android.app.DatePickerDialog
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_date_time_picker.*
import kotlinx.android.synthetic.main.activity_shared_preferences_demo.*
import java.util.*

class SharedPreferencesDemo : AppCompatActivity() {
    lateinit var sharedprefrence:SharedPreferences
    val Name = "namekey"
    val Email="emailkey"
    val Password="passkey"
    val Phone="phonekey"
    val Date = "DateKey"
    val myfile="mypref"
    private var mYear:Int = 0
    private var mMonth:Int = 0
    private var mDay:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences_demo)
        sharedprefrence=getSharedPreferences(myfile, Context.MODE_PRIVATE)
        name.setText(sharedprefrence.getString(Name,""))
        email.setText(sharedprefrence.getString(Email,""))
        date.setOnClickListener {
            val c = Calendar.getInstance()
            mYear = c[Calendar.YEAR]
            mMonth = c[Calendar.MONTH]
            mDay = c[Calendar.DAY_OF_MONTH]
            val datePickerDialog = DatePickerDialog(this,{view,year,monthOfYear,dayOfMonth ->
                date.setText(dayOfMonth.toString() + "-" +
                        (monthOfYear+1)+ "-" + year
                )
            },
                mYear,mMonth,mDay
            )
            datePickerDialog.show()
        }
    }

    fun save(v: View)
    {
        val n = name.text.toString()
        val e=email.text.toString()
        val p = password.text.toString()
        val ph = mobileNumber.text.toString()
        val d = date.text.toString()
        val edit=sharedprefrence.edit()
        edit.putString(Name,n)
        edit.putString(Email,e)
        edit.putString(Password,p)
        edit.putString(Phone,ph)
        edit.putString(Date,d)
        edit.apply()
    }
    fun get(v:View)
    {
        sharedprefrence=getSharedPreferences(myfile,Context.MODE_PRIVATE)
        name.setText(sharedprefrence.getString(Name,""))
        email.setText(sharedprefrence.getString(Email,""))
    }
    fun clear(v:View)
    {
        name.setText("")
        email.setText("")
        password.setText("")
        mobileNumber.setText("")
        date.setText("")
    }
}