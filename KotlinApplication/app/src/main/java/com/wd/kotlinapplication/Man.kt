package com.wd.kotlinapplication

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/12 11:20
 * @classname :Man
 */
class Man(name:String) :Human(name) {
    override fun eat() {
        println("${name}大口的吃")
    }
    override fun pee() {
        println("${name}顶天立地")
    }
}