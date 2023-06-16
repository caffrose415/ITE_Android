package com.example.myapplication2.kotlin

class NonDataClass(val name:String, var age:Int)

data class DataClass(val name:String, var age:Int){

    lateinit var address:String

    constructor(name:String,age:Int,address:String):this(name,age){
        this.address = address
    }
}

fun main(){
    var non1 = NonDataClass("홍길동",20)
    var non2 = NonDataClass("홍길동",20)
    println("일반 클래스의 객체를 비교 : ${non1.equals(non2)}")

    var data1 = DataClass("신사임당",30)
    var data2 = DataClass("신사임당",30)

    println("data 클래스의 객체를 비교: ${data1.equals(data2)}")

    var data3 = DataClass("신사임당",30,"서울")
    var data4 = DataClass("신사임당",30,"부산")

    println("data 클래스의 객체를 비교 : ${data3.equals(data4)}")
}