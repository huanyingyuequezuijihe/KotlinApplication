package com.wd.kotlinapplication

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/12 10:51
 * @classname :Person
 */
open class Person {
    var chactor:String="性格内向"
    //加 open 允许被重写
    open fun action(){
        println("容易被忽视")
    }
}