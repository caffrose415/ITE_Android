package com.example.myapplication2.kotlin

fun main(){
    var data1 = 10

    when(data1){
        10 -> println("data1은 10이에요")
        20 -> println("data1는 20이에요")
        else -> {
            println("data1은 유효한 값이 아닙니다")
        }
    }

    var data2 = "Hello"

    when(data2){
        "helloo" -> println("data2은 hello이에요")
        "Hello" -> println("data2는 Hello이에요")
        else -> {
            println("data2은 유효한 값이 아닙니다")
        }
    }

    var data3:Any = 10

    when(data3){
        is String -> println("data3은 문자열이에요")
        20,30 -> println("data3은 20 아니면 30이에요")
        else ->{
            println("data3은 유효한 값이 아니에요")
        }
    }

    var data4:Int = 20

    when{
        data4<0 ->println("data4는 0 보다 작아요")
        data4>100 -> println("data4는 100보다 커요")
    }

    var result = when{
        data4 <0 ->"-100"
        data4>100 ->"100"
        else-> "300"
    }
}