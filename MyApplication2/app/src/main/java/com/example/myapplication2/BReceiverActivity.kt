package com.example.myapplication2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication2.databinding.ActivityBreceiverBinding

class BReceiverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityBreceiverBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Receiver를 생성하고 등록
        val receiver = object : BroadcastReceiver(){
            override fun onReceive(context: Context?, intent: Intent?) {
                Log.d("hong","동적으로 생성한 Revceiver가 호출되었어요!")
            }
        }

        var myFilter = IntentFilter("android.intent.action.MY_BROADCAST")

        registerReceiver(receiver,myFilter)
        binding.broadcastBtn.setOnClickListener {

            //Explicit Intent
            //var intent = Intent(this,MyReceiver::class.java)

            //Implicit Intent
            //background 제약떄문에 작동 안함
            var intent = Intent("android.intent.action.MY_BROADCAST")
            sendBroadcast(intent)
        }


        val receiver1 = object : BroadcastReceiver(){
            override fun onReceive(context: Context?, intent: Intent?) {
                Log.d("hong","동적으로 생성한 Revceiver1가 호출되었어요!")
            }
        }

        var myFilter1 = IntentFilter("android.intent.action.MY_BROADCAST")

        registerReceiver(receiver1,myFilter1)
        binding.broadcastBtn.setOnClickListener {

            //Explicit Intent
            //var intent = Intent(this,MyReceiver::class.java)

            //Implicit Intent
            //background 제약떄문에 작동 안함
            var intent = Intent("android.intent.action.MY_BROADCAST")
            sendBroadcast(intent)
        }

        //화면 켜지고 꺼질때 발생하는 시스템 signal을 받는 Receiver를 만들어서 등록
        val screenReceiver = object:BroadcastReceiver(){
            override fun onReceive(context: Context?, intent: Intent?) {
                //화면이 켜지고 꺼지는 것을 구분
                //parameter intent에 세부적인 정보가 담겨서 전달
                when(intent?.action){
                    Intent.ACTION_SCREEN_ON -> Log.d("hong","화면이 켜졌어요!")
                    Intent.ACTION_SCREEN_OFF -> Log.d("hong","화면이 꺼졌어요!")
                }
            }
        }
        val screenFilter = IntentFilter(Intent.ACTION_SCREEN_ON).apply{
            addAction(Intent.ACTION_SCREEN_OFF)
        }
        registerReceiver(screenReceiver,screenFilter)
    }
}