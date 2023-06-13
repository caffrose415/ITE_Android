package com.example.myapplication2.kotlin


class User17{
    var name = "홍길동"

    constructor(name:String){
        this.name=name
    }

    fun myFunc():Unit{
        println("name: $name")
    }

    class SomeClass{
        fun someFunc(){
            println("소리없는 아우성!")
        }
    }
}
fun main(){
    val user:User17 = User17("신사임당")
    user.myFunc()

    var some:User17.SomeClass = User17.SomeClass()
    some.someFunc()
}