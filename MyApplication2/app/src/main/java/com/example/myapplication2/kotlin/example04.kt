package com.example.myapplication2.kotlin
// 여기가 일반적으로 최상위라고 불리는 위치

// 최상위에 변수를 선언할 때는 변수의 초기화를 진행해야함
// 코틀린은 기본 데이터타입(Primitive Data type)이 존재하지 않음
// 모든 데이터는 reference data type(객체)

var data4:String = "소리없는 아우성"

fun main(){
    //지역 변수
    var data3:Int
    //println("data3 : $data3")//ERROR 사용하기 전에 초기화가 진행되야함
}

class User04{
    //val data6:String  ERROR

    var data7:String="안녕"

}