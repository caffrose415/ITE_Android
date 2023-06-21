package com.example.myapplication2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication2.databinding.ActivityFragmentTestBinding
import com.example.myapplication2.databinding.FragmentMySecondBinding

class MySecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding =FragmentMySecondBinding.inflate(inflater,container,false)

        return binding.root
    }


}