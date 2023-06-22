package com.example.myapplication2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.myapplication2.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {

    lateinit var binding:ActivityFirstBinding

    val resultLauncher:ActivityResultLauncher<Intent> = registerForActivityResult(
        //Contract가 나와야함
        ActivityResultContracts.StartActivityForResult()

    ){
        //결과 처리하는 부분
        result ->
        if(result.resultCode==Activity.RESULT_OK){
            //만약 결과가 OK면 처리를 진행
            var intent: Intent? = result.data

            var returnStr = intent?.getStringExtra("resultData")
            binding.resultTv.text = returnStr
        }
    }
    //두번째 activity가 종료되고 결과가 돌려지면 아래의 callback이 호출
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        //requestCode : activity를 실행하기 위해서 사용한 요청 코드 =>10
//        //resultCOde : 두번째 activity가 설정해 노흥ㄴ 겨로가 코드 => RESULT_OK
//        //data : 두번째 activity가 결과를 저장해 놓은 Intent
//
//        if(requestCode==10 &&resultCode== Activity.RESULT_OK){
//            var result = data?.getStringExtra("resultData")
//
//            binding.resultTv.text = "받아온 데이터 $result"
//        }
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startActivityBtn.setOnClickListener {
            //새로운 activity를 호출
            //가장 일반적인 방법에 대해서
            //같은 app안에 있는 다른 Activity를 실행하는걸 요청하는 Intent
            var intent = Intent("android.intent.action.HELLO")

            //데이터도 같이 전달하려면 어떻게 하나요?
            intent.putExtra("name","홍길동")
            intent.putExtra("age",20)
            
            //android가 intent를 받아서 당연히 Intent안에 있는 Activity를 실행하면서 Intent를 전달
            //startActivity(intent)

            //만약 두번째 Activity에서 데이터를 결과로 전달받으려면 다른 메서드 이용
            //startActivityForResult(intent,10)

            resultLauncher.launch(intent)

        }
    }
}