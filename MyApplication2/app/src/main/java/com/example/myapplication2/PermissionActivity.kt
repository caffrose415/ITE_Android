package com.example.myapplication2

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.myapplication2.databinding.ActivityPermissionBinding

class PermissionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding = ActivityPermissionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startBtn.setOnClickListener{
            val permission = "com.example.permission.TEST_PERMISSION"

            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(permission), 1)

                Log.d("hong", "권한 요청!")

            } else {
                // 권한이 이미 부여되었을 때 액티비티를 시작

                Log.d("hong", "권한이 이미 부여되어있음")
                var intent = Intent()
                intent.setClassName("com.example.mysecondapp","com.example.mysecondapp.SecondActivity")
                startActivity(intent)
            }


        }
    }
}