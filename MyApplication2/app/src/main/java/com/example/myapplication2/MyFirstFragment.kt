package com.example.myapplication2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication2.databinding.FragmentMyFirstBinding

class MyFirstFragment : Fragment() {

    //Fragment가 표현할 View를 리턴해줘야 화면에 나옴
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //XML에 있는 화면(Fragment)을 객체화 시켜서 리턴
        var binding = FragmentMyFirstBinding.inflate(inflater,container,false)

        return binding.root
    }
    
}