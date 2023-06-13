package com.example.myapplication2.kotlin

class Member19 constructor(name:String,age:Int){

    var name:String
    var age:Int
    init{
        println("여기는 초기화 블럭입니다.")
        this.name = name
        this.age=age
    }
}

//주 생성자가 가지는 parameter에 val이나 var키워드를 사용하면
//이건 예외적으로 property로 만들어줘요
class Member20 constructor(var name:String,val age:Int){

    init{
        println("여기는 초기화 블럭입니다.")
    }
}


class Member21 constructor(name:String, age:Int){

    var name:String = name
    var age:Int = age
}
fun main(){
    var member:Member19=Member19("홍길동",20)
    var member20:Member20=Member20("홍길동",20)
    println(member20.name)
    println(member20.age)

    var member21:Member21=Member21("홍길동",20)
    println(member21.name)
    println(member21.age)
}