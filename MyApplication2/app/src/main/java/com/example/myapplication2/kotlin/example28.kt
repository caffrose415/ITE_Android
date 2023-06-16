package com.example.myapplication2.kotlin

//higher order function( 고차함수)
//함수의 파라미터로 다른 함수(callback)을 받아서 사용하는 함수 지정
fun hofFunc(arg: (Int) ->Boolean):() ->String{
    val result = if(arg(10)){
        "입력된 값은 0보다 커요"
    }else{
        "이볅된 값은 0보다 작아요"
    }
    return {"hofFunc의 결과 값은 : $result"}
}

fun main(){

    var result = hofFunc({no->no>0})
    println(result())
}