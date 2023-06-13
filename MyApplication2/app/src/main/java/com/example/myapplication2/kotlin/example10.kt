package com.example.myapplication2.kotlin

fun main():Unit{

    //val data10:Nothing = null   // 코드에러가 남!
    val data10:Nothing? = null
    
    //의미없는 값을 리턴하는 함수이기 때문에 함수용도에서 제약이 있음
    fun myFunc1():Nothing?{
        return null
    }

    fun handleException(error:String):Nothing{
        throw RuntimeException("오류에요!! $error")
    }

    fun calculate(value:Int):Int{
        if(value<0){
            handleException("value는 0보다 커야합니다.")
        }
        var sum = value +100
        return sum
    }


    try{
        var result1 = calculate(100)
        println("result1: $result1")
        var result2 = calculate(-100)
        println("result2 : $result2")
    }catch(e:java.lang.RuntimeException){
        println("Exception : $e")
    }finally{
        println("여기는 무조건 호출되요!")
    }

}
