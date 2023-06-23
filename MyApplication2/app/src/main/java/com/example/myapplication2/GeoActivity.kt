package com.example.myapplication2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication2.databinding.ActivityGeoBinding

class GeoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityGeoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.geoBtn.setOnClickListener {
            //지도의 activity를 사용
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo: 37.5662952,126.9779451"))

            startActivity(intent)
        }
    }
}