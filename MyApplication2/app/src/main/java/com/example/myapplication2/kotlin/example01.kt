package com.example.myapplication2.kotlin

//Kotlin 파일은 어떻게 구성되나요?

//변수
//var(variable)이라는 키워드
//val(value)이라는 키워드를 사용할 수 있음
// 코틀린의 모든 값은 객체(primitive value가 존재하지 않음)
//따라서 모든 변수는 reference변수
//만약 객체에 대한 reference를 고정시켜서 사용할 경우 ==> val
// 객체에 대한 reference가 바뀌는 경우에는 var을 사용

var data = 10;

//타입 유추가 안되는 경우에는 반드시 타입을 명시 해야함
//Unit의 의미는 java의 void
fun myFunc(inputData:String):String{
    return "입력 데이터는 $inputData, ${10 + 20}";
}

//class
class User{
    var name="홍길동"; //Property

    fun sayHello(){
        println("안녕하세요!! $name");
    }

}