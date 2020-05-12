package com.wd.kotlinapplication

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/12 10:03
 * @classname :Girl
 */
class Girl(var chacyor:String,var voice:String) :Person(){
    fun smile(){
        println("妹子笑了一下，好甜呀")
    }
    fun cry(){
        println("呜呜呜，人家好伤心")
    }

    override fun action() {
        println("学习高等知识")
    }
}

fun main(arg:Array<String>) {
    val girl1 = Girl("御姐", "空灵")
    println("girl1这位妹子的长相:${girl1.chacyor},声音:${girl1.voice}")

    //静态属性  动态行为
    //静态指他的属性，动态指他的方法
    girl1.smile()
    girl1.cry()
}