package com.example.myapplication2.kotlin

fun main(){

    var data1:String = "홍길동"

    var data2:String? = "홍길동"
    data2 = null

    println("data1의 길이는 : ${data1.length}")
    println("data2의 길이는 : ${data2?.length}")


    println("data2의 길이는 : ${data2?.length ?:-1}")
}