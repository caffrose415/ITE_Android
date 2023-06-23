package com.example.myapplication2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication2.databinding.ActivityDialBinding

class DialActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityDialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.dialBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel: 010-1234-5678"))

            startActivity(intent)
        }
    }
}