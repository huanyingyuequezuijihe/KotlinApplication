package com.wd.kotlinapplication.wash

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/12 13:59
 * @classname :SmallHeadFather
 */
class SmallHeadFather :IWashBow1 by BigHeadSon(){
    //给儿子去洗
    /*override fun washBow1() {
        println("小头爸爸，在洗碗，一次10元")
    }*/
    override fun washBow1() {
        println("小头爸爸洗碗，一次10元")
        BigHeadSon().washBow1()
        println("我把任务交给了儿子")
    }
}