package com.example.myapplication2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.example.myapplication2.databinding.ActivityFragmentTestBinding

class FragmentTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding = ActivityFragmentTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //FragmentManager 이 객체가 있어야 fragment에 대한 동적제어를 할 수 있음
        var fragmentManager: FragmentManager = supportFragmentManager
        
        binding.fragmentAddBtn.setOnClickListener {
            //새로운 Fragment를 내가 원하는 위치에 추가해야함
            //마치 데이터베이스의 transaction처리하는것 처럼 하면됌
            var transaction = fragmentManager.beginTransaction()

            var fragment = MyFirstFragment()
            transaction.add(R.id.fragment_content,fragment)
            transaction.commit()
        }

        binding.fragmentReplaceBtn.setOnClickListener {
            //새로운 Fragment를 내가 원하는 위치에 추가해야함
            //마치 데이터베이스의 transaction처리하는것 처럼 하면됌
            var transaction = fragmentManager.beginTransaction()

            var fragment = MySecondFragment()
            transaction.replace(R.id.fragment_content,fragment)
            transaction.commit()
        }

        binding.fragmentRemoveBtn.setOnClickListener {
            //새로운 Fragment를 내가 원하는 위치에 추가해야함
            //마치 데이터베이스의 transaction처리하는것 처럼 하면됌
            var transaction = fragmentManager.beginTransaction()

            //제거하려는 Fragment를 찾아
            var fragment = fragmentManager.findFragmentById(R.id.fragment_content)

            // 코틀린은 null을 검사하고 만약 null이 아니라면 간결하게 구문을 수행할 수 있는 특이한 let이라는 구문을 제공
            fragment?.let {
                transaction.remove(it)
            }
            transaction.commit()
        }
    }
}