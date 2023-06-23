package com.example.myapplication2

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import com.example.myapplication2.databinding.ActivityContactBinding
import com.example.myapplication2.databinding.ActivityGalleryBinding

class ContactActivity : AppCompatActivity() {

    lateinit var binding: ActivityContactBinding

    var requestContactLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        Log.d("hong","주소록의 항목을 선택했어요!")
        //사람을 한ㄴ명 선택해서 여기로 들어옴
        //선택한 사람이 누구이고 전화번호가 먼지 알아내자
        Log.d("hong","${it?.data?.data!!}")
        //content provider가 제공하는 데이터에 접근해야함
        var cursor = contentResolver.query(it?.data?.data!!,arrayOf<String>(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER),
            null,null,null)

        if(cursor!!.moveToFirst()){
            var name = cursor?.getString(0)
            var phone = cursor?.getString(1)

            Log.d("hong","이름은 $name, 전화번호는 $phone")
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)

        binding = ActivityContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.contactBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI)

            requestContactLauncher.launch(intent)
        }
    }
}