package com.example.myapplication2.kotlin

class Member22 constructor(name:String){

    constructor(name:String, age:Int) : this(name){
        println("이름은 $name, 나이는 $age 입니다.")
    }
}

fun main(){

}