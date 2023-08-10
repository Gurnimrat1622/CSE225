package com.example.cse225

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.job.JobParameters
import android.app.job.JobService
import android.content.Context
import android.content.Intent
import android.util.Log


class MyJobService : JobService(){
    override fun onStartJob(params: JobParameters?): Boolean {
       // val i = Intent(this,alarm_manager_example::class.java)
        val i = Intent(this,MyBroadcastDemo::class.java)
        val pendingIntent= PendingIntent.getBroadcast(this,0,i, PendingIntent.FLAG_MUTABLE)
        val alarmManager = getSystemService(Context.ALARM_SERVICE)as AlarmManager
        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),pendingIntent)


        return true
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        Log.d("Job","Stopped")
        return true
    }


}