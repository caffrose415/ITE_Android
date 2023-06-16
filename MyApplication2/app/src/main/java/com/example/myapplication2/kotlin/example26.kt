package com.example.myapplication2.kotlin

class MyClass26{
    companion object{
        var data = 100
        fun myFunc(){
            println("HIHI")
        }
    }

}

fun main(){
    println(MyClass26.data) //당연히 안댐
    println(MyClass26.myFunc())
}