package com.example.myapplication2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication2.databinding.ActivityViewPagerBinding
import com.example.myapplication2.databinding.ItemPagerBinding

class MyPagerViewHolder(val binding : ItemPagerBinding) : RecyclerView.ViewHolder(binding.root)

//data를 가져다가 holder에 결합하는것이 adapter가 하는일
//당연히 data가 3개이면 holder도 3개
class MyPagerAdapter(private val myData: MutableList<String>): RecyclerView.Adapter<MyPagerViewHolder>(){
    override fun getItemCount(): Int {
        return myData.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPagerViewHolder {
        return MyPagerViewHolder(ItemPagerBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MyPagerViewHolder, position: Int) {
        val binding = holder.binding

        binding.itemPageTextView.text = myData[position]
    }


}
class ViewPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding = ActivityViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //마치 RecyclerView 만드는것 처럼 Adapter이런거 작업해서 붙여요!
        val myData = mutableListOf<String>()

        for(i in 1..3){
            myData.add("Item $i")
        }

        binding.viewpager.adapter = MyPagerAdapter(myData)
    }
}