package com.example.myapplication2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication2.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var myIntent = intent

        //intent로부터 전달된 데이터를 꺼냄
        var name = myIntent.getStringExtra("name")
        var age = myIntent.getIntExtra("age",0)

        binding.MyTv.text = "전달된 데이터는 $name, $age 입니다."

        binding.closeBtn.setOnClickListener {
            //입력상자에 들어있는 데이터를 가져다가 이 Activity의 결과값으로 세팅하고 이 activity를 닫음

            var data = binding.myEt.text.toString()
            var resultIntent = Intent()
            resultIntent.putExtra("resultData",data)
            setResult(RESULT_OK,resultIntent)

            finish()

        }
    }
}