package com.example.myapplication2

import android.app.DatePickerDialog
import android.graphics.Movie
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication2.databinding.ActivityMovieBinding
import com.example.myapplication2.databinding.MovieItemBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

object RetrofitBuilder {
    //baseUrl은 오픈 api의 서버 url을 넣는다.
    var baseUrl: String = "http://www.kobis.or.kr"
    var api: RetrofitMovieAPI

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            //json을 gson으로 파싱할거니까 GsonConverterFactory.create()로 gsonconverter를 가져온다.
            .addConverterFactory(GsonConverterFactory.create())
            .build() //Retrofit 객체 생성

        api = retrofit.create(RetrofitMovieAPI::class.java)
    }

}

//각 항목에 해당하는 View 객체를 가지는 ViewHolder를 만들어야 해서 class를 defined
class MovieViewHolder(val binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root)

class MovieAdapter(var myData:List<MovieDto>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    //자동으로 호출되는 메서드
    //항목의 개수를 판단하기 위한 메서드
    //여기서 리턴되는 숫자만큰 onBindViewHolder가 호출
    override fun getItemCount(): Int {
        return myData.size
    }

    fun setList(list:List<MovieDto>){
        myData=list
        notifyDataSetChanged()
    }

    //ViewHolder에 데이터를 바인딩시킴
    //자동으로 호출
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var binding = (holder as MovieViewHolder).binding
        binding.rank.text=myData[position].rank
        binding.name.text=myData[position].movieName
        binding.openDate.text=myData[position].openDt
    }
    //자동으로 호출됨
    //항목을 표현하는 ViewHolder객체를 생성하기 위해 호출
    //이렇게 리턴된 viewHolder객체는 onBindViewHolder에 인자로 전달
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MovieViewHolder(MovieItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
}

class MovieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var myData = mutableListOf<MovieDto>()

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        var myAdapter = MovieAdapter(myData)

        binding.recyclerView.adapter = myAdapter

        binding.pickerBtn1.setOnClickListener{

            DatePickerDialog(this,object: DatePickerDialog.OnDateSetListener{
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                    Log.d("hong","선택한 날짜는 $year 년,${month+1} 월, $dayOfMonth 일")
                    val calendar = Calendar.getInstance()
                    calendar.set(year, month, dayOfMonth)

                    val dateFormat = SimpleDateFormat("yyyyMMdd", Locale.getDefault())
                    val formattedDate = dateFormat.format(calendar.time)
                    RetrofitBuilder.api
                        .getMovieList("${formattedDate}", "4a57bb3d41223e66f8d8792dc6cb5c07")
                        .enqueue(object : Callback<MovieResponse> {
                            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                                //통신 실패한 경우
                            }

                            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                                val movieResponse = response.body()
                                var list : List<MovieDto> = movieResponse!!.boxofficeResult!!.dailyBoxOfficeList
                                Log.d("Hong", "$list")
                                myAdapter.setList(list)
                            }
                        })
                }
            },2023,5,20).show()
        }

    }
}