package com.example.myapplication2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CompoundButton
import com.example.myapplication2.databinding.ActivityCheckBoxBinding

class CheckBoxActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityCheckBoxBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.myCheckBox.setOnCheckedChangeListener(object: CompoundButton.OnCheckedChangeListener{
//            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
//
//                Log.d("hong","체크박스의 상태를 변경했어요!")
//            }
//        })

        binding.myCheckBox.setOnCheckedChangeListener{
                p0,p1 ->Log.d("hong","체크박스가 체크 되었어요: $p1")

        }
    }
}