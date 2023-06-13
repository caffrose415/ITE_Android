package com.example.myapplication2.kotlin

//lateinit은 초기화를 미루기 위해 사용하는데
// 일단 var 키워드를 같이 사용해야 하고
// Int, Byte, Short, Long, Float, Double, Boolean에는 사용할 수 없음
//lateinit var name:Int ERROR

lateinit var name:String

fun main(){
    name="신사임당"
    println("이름은 $name")
}
