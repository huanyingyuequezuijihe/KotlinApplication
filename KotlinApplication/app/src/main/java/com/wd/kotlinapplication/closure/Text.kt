package com.wd.kotlinapplication.closure

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/12 14:59
 * @classname :Text
 */
//闭包操作好处：1.可以在函数内声明函数
//2.函数的参数可以使=是函数
//3.函数的返回值也可以是函数
fun text():()->Unit{
    var i=3;
    return fun(){
        i++
        println(i)
    }
}
fun main(args:Array<String>) {
    var t=text()
    //这样 i这个值就会保存起来  每次++
    t()
    t()
    t()
}