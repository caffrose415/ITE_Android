package com.example.myapplication2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.example.myapplication2.databinding.ActivityActionBarBinding

class ActionBarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding = ActivityActionBarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.newActivityBtn.setOnClickListener {
            var intent = Intent(this,ActionSecondActivity::class.java)

            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_item, menu)
//        val menuItem1: MenuItem? = menu?.add(0,0,0,"메뉴1")
//        val menuItem2: MenuItem? = menu?.add(0,1,0,"메뉴2")

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when(item.itemId){
        R.id.menu1->{
            Log.d("hong","메뉴1을 눌렀어요")
            true
        }
        R.id.menu2->{
            Log.d("hong","메뉴2를 눌렀어요")
            true
        }
        R.id.menu3->{
            Log.d("hong","메뉴3를 눌렀어요")
            true
        }
        else->true
    }
}