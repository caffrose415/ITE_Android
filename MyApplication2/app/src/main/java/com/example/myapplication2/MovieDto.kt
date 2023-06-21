package com.example.myapplication2

import com.google.gson.annotations.SerializedName

data class MovieDto (
    @SerializedName("movieNm")
    var movieName:String?,
    @SerializedName("rank")
    var rank: String?,
    @SerializedName("openDt")
    var openDt:String?
)