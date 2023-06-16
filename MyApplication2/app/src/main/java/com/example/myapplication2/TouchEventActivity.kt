package com.example.myapplication2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import com.example.myapplication2.databinding.ActivityTouchEventBinding

class TouchEventActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding = ActivityTouchEventBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.myTv.setOnTouchListener{
            v,event ->
            when(event.action){
                MotionEvent.ACTION_DOWN ->{
                    Log.d("hong","Text View터치-다운 이벤트가 발생했어요!"+
                            "View x좌표 : ${event.x}, 화면대상 x좌표 : ${event.rawX}")
                    true//이벤트 전파가 이루어지지 않음
                }
                else -> false
            }
        }
    }

    //true =  이벤트 전파가 이루어 지지 않음
    //false = 이벤트 전파가 이루어 짐
    override fun onTouchEvent(event: MotionEvent?):Boolean{
        when(event?.action){
            MotionEvent.ACTION_DOWN-> {
                Log.d("hong","터치-다운 이벤트가 발생했어요!"+
                "View x좌표 : ${event.x}, 화면대상 x좌표 : ${event.rawX}")
            }
            MotionEvent.ACTION_UP-> {
                Log.d("hong","터치-업 이벤트가 발생했어요!")
            }
        }
        Log.d("hong","터치가 발생 했어요!")
        return super.onTouchEvent(event)
    }
}