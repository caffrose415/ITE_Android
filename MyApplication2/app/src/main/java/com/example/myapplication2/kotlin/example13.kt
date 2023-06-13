package com.example.myapplication2.kotlin

fun main(){

    var myList = listOf<Int>(10,20,30)
    println("list의 크기 : ${myList.size}")

    var myList1 = mutableListOf<Int>(100,200,300,400)
    println("myList1의 크기 : ${myList1.size}")

    myList1.add(4,500)


    var myMap1 = mapOf<String,String>(
        Pair("one","홍길동"),
        "two" to "신사임당",

    )

    println(myMap1.get("two"))

    var myMap2 = mutableMapOf<String,String>(
        Pair("one","홍길동"),
        "two" to "신사임당",

        )

    myMap2.put("three","강감찬")
    println(myMap2.get("three"))

    var mySet1 = mutableSetOf<String>("서울","부산","인천")
    println(mySet1)

    println("서울이 set안에 있나요?:  ${"서울" in mySet1}")
}