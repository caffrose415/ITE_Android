package com.example.myapplication2

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class SecondService : Service() {

    class MYBinder: Binder() {
        fun myFunc1(arg: Int){
            Log.d("hong","입력된 값은 : $arg")
        }
        fun myFunc2(arg: Int):Int{
            return arg + 100
        }
    }
    override fun onBind(intent: Intent): IBinder {
        Log.d("hong","두번째 서비스가 시작되었어요")
        return MYBinder()
    }

}