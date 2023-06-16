package com.example.myapplication2.kotlin

//기본적으로 코틀린의 클래스는 상속할 수 없음
//특정 키워드를 이용해서 상속이 가능하다는걸 알려줘야함

open class MySuper(name:String){

    init{
        println("MySuper 주생성자가 호출 되었어요!")
    }
}

class MySub1(name:String):MySuper(name){
    init{
        println("MySUb1의 주 생성자가 호출되었어요!")
    }
}
class MySub2:MySuper{
    constructor(name:String):super(name){
        println("MySub2의 보조 생성자가 호출되었어요!")
    }
}
fun main(){
    var user1 =MySub1("홍길동")
    var user2 = MySub2("신사임당")
}