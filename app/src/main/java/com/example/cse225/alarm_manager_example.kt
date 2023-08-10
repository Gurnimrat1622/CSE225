package com.example.cse225

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_alarm_manager_example.*

class alarm_manager_example : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm_manager_example)
        var alarmManager:AlarmManager
        val i = Intent(this,MyBroadcastDemo::class.java)
        var pendingIntent=PendingIntent.getBroadcast(this,0,i,PendingIntent.FLAG_MUTABLE)
        start.setOnClickListener {
            var l=editTextTextPersonName.text.toString().toInt()
            alarmManager = getSystemService(Context.ALARM_SERVICE)as AlarmManager
            alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+(l*1000),pendingIntent)
            Toast.makeText(this,"Alarm set",Toast.LENGTH_LONG).show()
        }
        repeat.setOnClickListener {
            val e = editTextTextPersonName.toString().toInt()
            alarmManager=getSystemService(Context.ALARM_SERVICE)as AlarmManager
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),5000,pendingIntent)
            Toast.makeText(this,"Repeat Alarm is Set",Toast.LENGTH_LONG).show()
        }
    }
}