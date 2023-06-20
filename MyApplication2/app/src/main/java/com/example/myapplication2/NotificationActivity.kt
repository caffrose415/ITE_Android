package com.example.myapplication2

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import androidx.core.app.NotificationCompat
import com.example.myapplication2.databinding.ActivityNotificationBinding
import kotlin.concurrent.thread

class NotificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityNotificationBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.notiBtn.setOnClickListener {

            // NotificationManager를 획득해요!
            // notification manager가 필요한데 그것에 대한 것을 주세요!
            // 자바와 다르게 AS라는 키워드를 통해서 캐스팅 진행!
            var manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

            // Notification Builder 변수 선언
            var builder : NotificationCompat.Builder

            // Notification은 Channel을 이용해서 만들어야 해요! => API Level 26부터 (오레오)
            // 만약 사용자가 사용하는 버전에 따라 분기문 작성 (API 레벨 가져온다)
            // 나름 자주 사용하는 코드
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                // API Level 26보다 크기 때문에 당연히 Channel을 사용해야 해요!
                // 일단 채널을 먼저 만들기
                // 채널을 구성하는 건 3가지 ID, 이름, 중요도
                var channelId = "one-Channel"
                // Name은 채널의 이름 -> 앱 정보에서 나오는 이름
                var channelName = "첫번째 채널 이예요!"
                // 이 채널에서 발생하는 알림의 중요도 => 정해져 있는 상수

                // 채널을 하나 생성해요!
                val channel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH)

                // 이렇게 만든 채널에 여러가지 설정이 붙어요!
                channel.description="첫번째 채널의 설명이예요!"
                channel.setShowBadge(true) // badge를 표현해요!
                // channel.setSound() // 소리까지 지정할 수 있어요!
                channel.enableVibration(true) // 진동와요!

                // NotificationManager에 채널에 등록
                manager.createNotificationChannel(channel)

                // 이제 Builder를 생성하면 되요!
                builder = NotificationCompat.Builder(this, channelId)

            }else{
                // Channel을 사용하지 않는 예전 버전으로 구현해야 함
                builder = NotificationCompat.Builder(this)

            }

            // Builder가 만들어줘요!
            // 이 빌더를 가지고 Notification을 만들어요!
            // Notification 설정해요! (화면에 Notification에 어떻게 나오는지)
            // 아이콘 - 시스템 리소스가 기본 제공해주는 아이콘
            builder.setSmallIcon(android.R.drawable.ic_notification_overlay)
            // notification 제목
            builder.setContentTitle("Notification 제목!")
            // notification 내용
            builder.setContentText("여기는 내용이예요!")
            // 발생 시간
            builder.setWhen(System.currentTimeMillis())

            //Notification을 touch했을 떄 새로운 activity를 실행하도록
            var intent = Intent(this,SecondNotificationActivity::class.java)

            //이 인텐트를 바로 사용하는게 아니라 Notification에 붙여놓고 나중에
            //특정 시점이 되면 그 떄 사용해야함
            //그래서 Intent를 이용해서 PendingIntent를 만들어서 Notificatino에 붙여야함
            var pendingIntent = PendingIntent.getActivity(this,30, intent,PendingIntent.FLAG_IMMUTABLE)

            builder.setContentIntent(pendingIntent)
            // 자 이제! Notification을 만들어서 실행해보아요!

//            var myActionBuilder = NotificationCompat.Action.Builder(android.R.drawable.stat_notify_call_mute,"action이에요",pendingIntent)
//
//            //이번에는 추가적으로 actino 버튼까지 붙여서 이벤트 처리까지 해봄
//            builder.addAction(myActionBuilder.build())


            builder.setProgress(100,40,false)
            manager.notify(100, builder.build())


            //thread를 만들어보아요
            thread(name="myThread",start=true,isDaemon = true,block={
                for(i in 1..100){
                    builder.setProgress(100,i,false)
                    manager.notify(100,builder.build())

                    SystemClock.sleep(1000)
                }
            })
        }
    }
}