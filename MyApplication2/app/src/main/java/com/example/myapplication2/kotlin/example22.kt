package com.example.myapplication2.kotlin

open class MySuper1{

    open var data1:Int = 10

    open fun myFunc(){
        println("상위 클래스의 메소드에요!")
    }
}

class MySub3:MySuper1(){
    //자바 같은 경우: field를 재정의할 수 있죠 =>shadow
    //              method를 재정의 하는 경우 =>overriding
    //코틀린 경우 : property와 method를 재정의 하는 경우 : 둘다 overriding이라고 함
    //                                              특수한 키워드를 사용해야함 => override

    override var data1 = 100
    override fun myFunc(){
        println("하위 클래스의 오버라이딩된 메소드")
    }
}

fun main(){
    var obj1 = MySub3()
    println(obj1.data1)
    println(obj1.myFunc())
}