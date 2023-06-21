package com.example.myapplication2

import com.google.gson.annotations.SerializedName

data class MovieResponse (
    @SerializedName("boxOfficeResult")
    var boxofficeResult:BoxOfficeResult?
)