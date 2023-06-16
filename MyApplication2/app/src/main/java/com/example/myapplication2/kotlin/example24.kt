package com.example.myapplication2.kotlin

class User24(name:String,age:Int){
    var name:String = name
        get() = field
        set(value){
            field = value
        }
    private var age:Int=age

    var publicAge:Int
        get()=age
        set(value){
            age=value
        }
}

fun main(){
    var user = User24("신사입당", 30)

    println("이름은 : ${user.name}")

    user.publicAge = 30

    println("나이는 : ${user.publicAge}")
}