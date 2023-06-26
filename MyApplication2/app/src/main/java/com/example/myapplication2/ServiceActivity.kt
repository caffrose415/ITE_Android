package com.example.myapplication2

import android.app.Service
import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import com.example.myapplication2.databinding.ActivityServiceBinding

class ServiceActivity : AppCompatActivity() {

    var connection : ServiceConnection = object : ServiceConnection{
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            //서비스 파라미터에 service 객체가 전달해 준 IBinder interface타입의 객체가 전달됨
            Log.d("hong","Activity쪽에서 실행되고, 서비스가 정상적으로 binding되었어요!")
            var serviceBinder = service as SecondService.MYBinder

            serviceBinder.myFunc1(100)

            var result = serviceBinder.myFunc2(100)

            Log.d("hong","처리된 결과는 $result")
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            TODO("Not yet implemented")
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding = ActivityServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startFirstServiceBtn.setOnClickListener {
            val intent = Intent(this,FirstService::class.java)
            startService(intent)
        }

        binding.stopFirstServiceBtn.setOnClickListener {
            val intent = Intent(this,FirstService::class.java)
            stopService(intent)
        }

        binding.startSecondServiceBtn.setOnClickListener {
            val intent = Intent(this,SecondService::class.java)
            bindService(intent,connection, BIND_AUTO_CREATE)
        }

        binding.stopSecondServiceBtn.setOnClickListener {

            unbindService(connection)
        }
    }
}