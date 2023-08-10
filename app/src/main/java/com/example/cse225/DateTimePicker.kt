package com.example.cse225

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_date_time_picker.*
import java.util.Calendar

class DateTimePicker : AppCompatActivity() {
    private var mYear:Int = 0
    private var mMonth:Int = 0
    private var mDay:Int = 0
    private var mHour:Int = 0
    private var mMinute:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_time_picker)

        btn_datePicker.setOnClickListener {
            val c = Calendar.getInstance()
            mYear = c[Calendar.YEAR]
            mMonth = c[Calendar.MONTH]
            mDay = c[Calendar.DAY_OF_MONTH]
            val datePickerDialog = DatePickerDialog(this,{view,year,monthOfYear,dayOfMonth ->
                txtDate.setText(dayOfMonth.toString() + "-" +
                        (monthOfYear+1)+ "-" + year
                )
            },
            mYear,mMonth,mDay
            )
            datePickerDialog.show()
        }
        btn_timePicker.setOnClickListener {
            val c = Calendar.getInstance()
            mHour = c[Calendar.HOUR]
            mMinute = c[Calendar.MINUTE]
            val timePickerDialog = TimePickerDialog(this, {view,hourOfDay,minute ->
                    var hourOfDay = hourOfDay
                    val AM_PM =
                        if(hourOfDay < 12){
                        "AM"
                    } else {
                        "PM"
                    }
                    if (AM_PM === "PM") hourOfDay -= 12
                    if (AM_PM === "AM") hourOfDay += 12
                    if(minute < 10)
                        txtTime.setText("$hourOfDay:0$minute $AM_PM")
                    else
                        txtTime.setText("$hourOfDay:$minute $AM_PM")
                },mHour,mMinute,false

            )
            timePickerDialog.show()
        }
    }
}