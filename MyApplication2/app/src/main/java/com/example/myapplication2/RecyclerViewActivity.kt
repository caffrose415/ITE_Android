package com.example.myapplication2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication2.databinding.ActivityRecyclerViewBinding
import com.example.myapplication2.databinding.ItemMainBinding


//각 항목에 해당하는 View 객체를 가지는 ViewHolder를 만들어야 해서 class를 defined
class MyViewHolder(val binding: ItemMainBinding): RecyclerView.ViewHolder(binding.root)

class MyAdapter(var myData:MutableList<String>):RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    //자동으로 호출되는 메서드
    //항목의 개수를 판단하기 위한 메서드
    //여기서 리턴되는 숫자만큰 onBindViewHolder가 호출
    override fun getItemCount(): Int {
       return myData.size
    }

    //ViewHolder에 데이터를 바인딩시킴
    //자동으로 호출
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        
        var binding = (holder as MyViewHolder).binding

        //textView에 List에 있는 값을 세팅
        binding.itemData.text = myData[position]

        binding.itemContainer.setOnClickListener{
            Log.d("hong","click click $position")
        }
        binding.deleteBtn.setOnClickListener {
            removeItem(position)
        }

    }

    fun addItem(item:String){
        myData.add(item)
        notifyDataSetChanged()
    }

    fun removeItem(position:Int){
        myData.removeAt(position)
        notifyDataSetChanged()
    }
    //자동으로 호출됨
    //항목을 표현하는 ViewHolder객체를 생성하기 위해 호출
    //이렇게 리턴된 viewHolder객체는 onBindViewHolder에 인자로 전달
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(ItemMainBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
}

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var myData = mutableListOf<String>()

        for(i in 1..3){
            myData.add("item $i")
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        var myAdapter = MyAdapter(myData)

        binding.recyclerView.adapter = myAdapter

        binding.addBtn.setOnClickListener {
            var str = binding.myEt.text.toString()

            myAdapter.addItem(str)
        }


    }
}