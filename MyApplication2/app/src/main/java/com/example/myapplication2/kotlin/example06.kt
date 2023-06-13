package com.example.myapplication2.kotlin

// var은 lazy를 사용할 수 없음

val myData:Int by lazy {
    println("이 변수가 초기화 됩니다!")
    println("실행 코드가 계속 나올 수 있어요!")
    100
}

fun main(){
    println("프로그램 시작!")
    println(myData +10)
    println(myData + 20)
}
