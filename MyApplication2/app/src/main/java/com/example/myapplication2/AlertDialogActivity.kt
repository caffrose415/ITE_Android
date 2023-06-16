package com.example.myapplication2

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.example.myapplication2.databinding.ActivityAlertDialogBinding

var eventHandler = object: DialogInterface.OnClickListener{
    override fun onClick(dialog: DialogInterface?, which: Int) {
        Log.d("hong","yeah")
    }
}



class AlertDialogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding = ActivityAlertDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.dialogBtn.setOnClickListener{
            var builder = AlertDialog.Builder(this)

//            builder.setTitle("제목입니다.")
//            builder.setIcon(android.R.drawable.ic_dialog_info)
//            builder.setMessage("여기가 내용 부분이에요")
//            builder.setPositiveButton("YES",null)
//            builder.setNegativeButton("NO",null)
//            builder.setNeutralButton("중립",null)
//
//            builder.create().show()

            AlertDialog.Builder(this).run {
                setTitle("제목입니다.")
                setIcon(android.R.drawable.ic_dialog_info)
                setMessage("여기가 내용")
                setPositiveButton("YES",eventHandler)
                setNegativeButton("NO",eventHandler)
                setNeutralButton("중립",eventHandler)
                create()
            }.show()
        }
    }
}