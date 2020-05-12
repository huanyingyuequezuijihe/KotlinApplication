package com.wd.kotlinapplication.son

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/12 14:34
 * @classname :Son
 */
//密封类 sealed class   子类类型有限的class
//公驴  公马  母驴
sealed class Son {
    fun sayHello(){
        println("大家好！")
    }
    class xiaolv():Son()
    class xiaoluozi():Son()
}