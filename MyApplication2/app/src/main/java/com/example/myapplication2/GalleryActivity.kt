package com.example.myapplication2

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import com.example.myapplication2.databinding.ActivityGalleryBinding

class GalleryActivity : AppCompatActivity() {

    lateinit var binding:ActivityGalleryBinding

    var requestGalleryLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        //결국 갤러리에서 선택한 이미지를 들고 오는데, 진짜 이미지를 가져오는것이 아닌, 포인터를 가져와서 InputStream을 열어서 데이터를 가져와서
        //이미지를 만들어야함
        try{
            //선택한 이미지가 큰(고용량) 이미지 일때 처리시 OOM문제가 발생할 수 있음
            //그래서 선택한 이미지에 대한 scaling을 해줘야함
            // 원래는 연산을 통해서 이 scaling값을 알아내야 하는데 지금은 그냥 ㄱㄱ
            //이 scaling값을 어딘가에 저장해 놔야함
            var option = BitmapFactory.Options()
            option.inSampleSize = 2

            var inputStream = contentResolver.openInputStream(it?.data?.data!!)
            var bitmap = BitmapFactory.decodeStream(inputStream,null,option)

            inputStream?.close()

            inputStream = null

            bitmap?.let{
                binding.galleryResult.setImageBitmap(bitmap)
            }
            //이미지를 로딩해야 해요 Stream을 통해서!!
        }catch(e:Exception){
            Log.d("hong","오류에요!")
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGalleryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.galleryBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media. EXTERNAL_CONTENT_URI )

            intent.type = "image/*"

            requestGalleryLauncher.launch(intent)
        }
    }
}