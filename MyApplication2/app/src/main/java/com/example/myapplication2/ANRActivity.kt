package com.example.myapplication2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import com.example.myapplication2.databinding.ActivityAnractivityBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

class ANRActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityAnractivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sumBtn.setOnClickListener {

            var channel = Channel<Int>()

            //Dispatchers.Main : main thread를 지칭
            //Dispatchers.IO : 파일처리하거나 network 처리에 최적화
            //Dispathcers,Default :  CPU를 많이 사용하는 백그라운드 작업
            var backgroundScope = CoroutineScope(Dispatchers.Default)
            backgroundScope.launch {
                var sum = 0L
                var time = measureTimeMillis {
                    for(i in 1..10000000000){
                        sum+=i
                    }
                }
                channel.send(sum.toInt())
            }

            GlobalScope.launch(Dispatchers.Main) {
                //View에 접근이 가능
                channel.consumeEach{
                    binding.sumTv.text="sum: $it"
                }
            }
//            var handler = object: Handler(){
//                override fun handleMessage(msg: Message) {
//                    super.handleMessage(msg)
//                    //나중에 핸들러한테 메세지가 오면 자동으로 이 메소드를 호출되서 메세지를 처리
//                    binding.sumTv.text="sum: ${msg.arg1}"
//                }
//            }
//
//            thread{
//                var sum = 0L
//                var time = measureTimeMillis {
//                    for(i in 1..10000000000){
//                        sum+=i
//                    }
//                }
//                var message = Message()
//                message.arg1 = sum.toInt()
//                handler.sendMessage(message)
//            }

        }
    }
}