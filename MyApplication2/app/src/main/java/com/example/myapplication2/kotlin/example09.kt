package com.example.myapplication2.kotlin

var data09: Unit = Unit //이렇게 사용하는건 의미가 없음 사용하지 않음!

fun main(){
    //함수 안에 함수를 선언할 수 있음
    // 이런 함수를 local function이라고 함
    //편리한 경우가 있긴 한데 코드 자체가 복잡해지는 경향이 있어서
    //그리 추천하지는 않음

    fun myFunc09_1():Unit{
        
    }
    
    //Unit은 생략이 가능해요
    fun myFunc09_2(){
        
    }
}
