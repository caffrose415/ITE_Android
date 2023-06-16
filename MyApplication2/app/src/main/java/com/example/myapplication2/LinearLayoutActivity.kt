package com.example.myapplication2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import com.example.myapplication2.databinding.ActivityLinearLayoutGravityBinding
import com.example.myapplication2.databinding.ActivityRelativeLayoutBinding
import java.util.zip.Inflater

class LinearLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityRelativeLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)




    }
}