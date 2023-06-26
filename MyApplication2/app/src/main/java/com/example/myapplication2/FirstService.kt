package com.example.myapplication2

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class FirstService : Service() {

    //기본적으로 Service는 Activity와 마찬가지로 여러개의 callback을 가지고 있음
    //필요하면 overriding해서 사용하면 되요
    //하지만 이 onBind라는 메소드는 필수로 존재해야함
    // 일반 서비스 컴포넌트는 이 메소드를 사용하지 않음
    override fun onBind(intent: Intent): IBinder? {
        return null
    }
    //서비스 객체가 생성되면 바로 onCreate가 호출
    override fun onCreate() {
        super.onCreate()
        Log.d("hong", "첫번째 서비스 생성!")
    }

    //이어서 연속적으로 다른 callback이 호출
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        //서비스가 동작하는 코드를 넣으시면 되요
        Log.d("hong","첫번쨰 서비스 시작")
        
        //return 값은 3가지중 하나를 선택
        //START_STICKY : 서비스가 예상치 못한 이유로 강제 종료되면 서비스를 다시 시작 ( Intent 객체가 사라짐)
        //START_NOT_STICKY : 서비스가 예상치 못한 이유로 강제 종료되어도 서비스를 다시 시작하지 않음
        //START_REDELIVERY_INTENT : START_STICKY와 같은데, 다시 살아났을때 마지막 사용했던 Intent 객체를 다시 전달
        return START_STICKY
        
    }

    //서비스가 종료될때 호출
    override fun onDestroy() {
        super.onDestroy()
        Log.d("hong","첫번째 서비스 종료")
    }
}