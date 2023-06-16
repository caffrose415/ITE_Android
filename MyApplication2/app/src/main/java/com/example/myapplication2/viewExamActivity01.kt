package com.example.myapplication2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication2.databinding.ActivityViewExam01Binding

class viewExamActivity01 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityViewExam01Binding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.myBtn.setOnClickListener{
            Log.d("hong", "버튼이 클릭클릭!")

        }


    }
}