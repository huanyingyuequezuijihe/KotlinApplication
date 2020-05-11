package com.wd.kotlinapplication

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/11 14:16
 * @classname :KotlinText
 */

//main函数  程序入口  是计算机默认找的的一个运行的函数
fun main(args:Array<String>){
    println("hello world")
    //变量的声明及使用
    //第一次创建好空间后，是什么类型就固定了，不可更改
    var name="后羿";
    println(name)
    //再次赋值  会覆盖
    name="嫦娥"
    println(name)
}