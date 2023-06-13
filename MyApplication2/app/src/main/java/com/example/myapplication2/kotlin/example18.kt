package com.example.myapplication2.kotlin

class User18 constructor(name:String){

    //자바할떄 좀 편하게 구현하기 위해서 lombok을 사용
    //하지만 kotlin에서는 lombok을 이용하지 않음
    // data class라는게 따로 존재

    override fun toString():String{
        return "User18의 class의 인스턴스에요!"
    }
}
//주 생성자의 constructor keyword는 생략이 가능
class User19(name:String, age:Int){

    override fun toString():String{
        return "User19의 class의 인스턴스에요!"
    }
}
// 주 생성자의 constructor에 인자가 없으면 다음과 같이 생성
class User20(){

    override fun toString():String{
        return "User20의 class의 인스턴스에요!"
    }
}

//주 생성자의 constructor에 인자가 없으면 괄호도 생략할 수 있음
//이런 경우에는 컴파일러가 자동으로 인자 없는 주 생성자를 추가
class User21{

    override fun toString():String{
        return "User21의 class의 인스턴스에요!"
    }
}
fun main(){
    var user18:User18 = User18("신사임당")
    println(user18);
    var user19:User19 = User19("홍길동",24)
    println(user19);

    var user20:User20 = User20()
    println(user20);
}