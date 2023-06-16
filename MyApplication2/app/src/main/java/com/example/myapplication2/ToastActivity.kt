package com.example.myapplication2

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.myapplication2.databinding.ActivityToastBinding

class ToastActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding = ActivityToastBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toastBtn1.setOnClickListener{

            var toast = Toast.makeText(this,"이것은 소리없는 아우성!!",Toast.LENGTH_SHORT)
            toast.show()
        }

        binding.toastBtn2.setOnClickListener{

            var customToast = Toast(this)
            customToast.duration = Toast.LENGTH_SHORT
            customToast.setText("두번째 Toast에요")
            customToast.show()

        }

        binding.toastBtn3.setOnClickListener{

            var toast = Toast.makeText(this,"callback이 실행되요",Toast.LENGTH_SHORT)

            toast.addCallback(
                object: Toast.Callback(){
                    override fun onToastHidden() {
                        super.onToastHidden()
                    }

                    override fun onToastShown() {
                        super.onToastShown()
                    }

                }
            )
            toast.show()
        }
    }
}