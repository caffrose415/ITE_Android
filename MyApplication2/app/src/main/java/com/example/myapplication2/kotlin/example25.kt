package com.example.myapplication2.kotlin

open class MySuper25{
    open var data1:Int = 10
    var data2 = 20

    open fun myFunc() {
        println("여기는 myFunc() 입니다.")
    }
}

val obj = object:MySuper25(){

    override fun myFunc(){
        println("data : $data1")
    }
}

fun main(){
    //이렇게 access가 안되는 이유는 기본적으로 object class를 이용해서 객체를 생성하면 데이터 타입이 Any로 떨어짐
    println(obj.data1)
    obj.myFunc()
}
