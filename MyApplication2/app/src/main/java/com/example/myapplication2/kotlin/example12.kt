package com.example.myapplication2.kotlin

fun main(){
    //생성자의 첫번쨰 인자는 배열의 크기
    //두번째 인자는 초기값을 표현하는 함수가 나옴

    //{0} 람다 함수
    var myArr = Array<Int>(3,{0})


    //반복문을 이용 =>forEach
    myArr.forEach{
        num ->println(num)
    }
    
    //람다함수부터 알아보아요
    //일반적으로 함수는 fun 키워드로 저으이, 그런데 람다함수는 fun으로 정의하지 않음
    //람다함수는 익명함수
    //람다함수는 어떻게 만드나요? ==>{ }
    //코드블럭을 표현하는 { }와는 다름! 문맥으로 코드블럭인지 람다함수인지 판단
    // 1. 람다함수는 { }로 표현
    // 2. { } 안의 화살표가 있으면 화살표 왼쪽이 매개변수, 오른쪽이 함수 본문
    // 3. 람다 함수의 리턴값은 함수 본문의 마지막 표현식, 람다 함수는 return 키워드를 사용하지 않음


    //람다함수는 일반적으로 고차함수와 연관되어서 사용
    //고차함수는 다른 함수를 인자로 받아서 완성되어지는 함수를 의미
    //이렇게 고차함수에 인자로 들어가는 함수를 collback함수라고 표현
    //우리의 람다함수가 바로 callback함수로 사용되는것

    //2. 특정한 함수를 이용해서 문자열로 변형해서 출력
    var arrToString = myArr.joinToString(" ")
    println(arrToString)

    //3. 가장 쉬운 표준 API 이용방식
    println(myArr.contentToString())

    //배열 생성할 때 또 다른 방식으로
    var myArr1 = IntArray(3,{0})
    var myArr2 = DoubleArray(5,{3.14})

    //그러면 초기값은 항상 같은 값으로 모두 세팅해야하나요?
    //형태만 기억하시면 되요
    var myArr3 = arrayOf<Int>(20,30,40)

    println(myArr3[0])
    println(myArr3.get(2))
}