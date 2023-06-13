package com.example.myapplication2.kotlin

fun myFunc11_1(data1:Int):Int{

    return data1 * 10
}

fun main(){

    fun myFunc1(data1:Int,data2:Int):Int{
        return data1 * data2
    }
    
    //함수 인자에 초기값을 부여할 수 있음
    //이런경우에는 함수를 호출할 때 디폴트값을 이용해서 사용하는 경우가 있고
    // 그렇지 않고 디폴트값을 무시하고 사용해도 가능
    fun myFunc2(data1:Int,data2:Int=10):Int{
        return data1 * data2
    }

    fun myFunc3(data1:Int,data2:Int):Int{
        return data1 - data2
    }

    println(myFunc1(10,20)) //200
    println(myFunc2(100))    //100
    println(myFunc3(10,20))

}