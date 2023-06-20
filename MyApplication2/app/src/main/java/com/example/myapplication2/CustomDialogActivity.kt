package com.example.myapplication2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.myapplication2.databinding.ActivityCustomDialogBinding
import com.example.myapplication2.databinding.DialogInputBinding

class CustomDialogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding = ActivityCustomDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.myDialogBtn.setOnClickListener {

            var dialogBinding = DialogInputBinding.inflate(layoutInflater)

            AlertDialog.Builder(this).run{
                setTitle("여기는 제목이에요!")
                setView(dialogBinding.root)
                setPositiveButton("확인",null)
                create()
            }.show()
        }
    }
}