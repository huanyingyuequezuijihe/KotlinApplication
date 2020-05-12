package com.wd.kotlinapplication

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/12 11:22
 * @classname :Woman
 */
class Woman(name:String) :Human(name){
    override fun eat(){
        println("${name}小口的吃")
    }
}