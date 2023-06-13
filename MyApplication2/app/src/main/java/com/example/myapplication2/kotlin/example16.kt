package com.example.myapplication2.kotlin

fun main(){
    var sum:Int = 0

    for(i in 1..10){
        sum+=i
    }

    println(sum)

    var myArr = arrayOf<Int>(10,20,30,40,50)

    for(i in myArr.indices){
        println(myArr[i])
    }
}