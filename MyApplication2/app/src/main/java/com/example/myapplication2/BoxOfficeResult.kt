package com.example.myapplication2

import com.google.gson.annotations.SerializedName

data class BoxOfficeResult (
    @SerializedName("dailyBoxOfficeList")
    var dailyBoxOfficeList:List<MovieDto> = arrayListOf()
)