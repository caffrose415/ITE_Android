package com.example.myapplication2.kotlin

typealias MyInt = Int
typealias MyFuncType = (Int) -> Unit

fun main(){

    var myFunc1 = { no1:Int, no2:Int -> no1+no2}
    var myFunc2 = { println("안녕하세요")}

    var myFunc3:(Int,Int) ->Int = {no1,no2 ->no1+no2}

    var myFunc4 = {no1:Int -> println("입력된 값은 : $no1")}
    var myFunc5:(Int) ->Unit = { no1 -> println("입력된 값은 : $no1")}
    println(myFunc1(10,20))
    myFunc2()
    myFunc4(10)
}