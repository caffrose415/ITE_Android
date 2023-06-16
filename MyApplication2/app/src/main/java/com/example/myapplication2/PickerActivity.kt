package com.example.myapplication2

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.widget.TimePicker
import com.example.myapplication2.databinding.ActivityPickerBinding

class PickerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding = ActivityPickerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pickerBtn1.setOnClickListener{

            DatePickerDialog(this,object:DatePickerDialog.OnDateSetListener{
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                    Log.d("hong","선택한 날짜는 $year 년,${month+1} 월, $dayOfMonth 일")
                }
            },2023,5,16).show()
        }

        binding.pickerBtn2.setOnClickListener{
            TimePickerDialog(this,object:TimePickerDialog.OnTimeSetListener{
                override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {

                }
            },15,0,true).show()
        }
    }
}