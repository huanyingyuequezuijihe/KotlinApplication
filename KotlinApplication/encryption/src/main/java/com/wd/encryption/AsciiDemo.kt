package com.wd.encryption

import java.lang.StringBuilder

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/12 20:10
 * @classname :AsciiDemo
 */
//ascii 加密
fun main(args:Array<String>){
    //获取字符的ascii编码
    val c:Char='a'
    //转成int值 十进制
    val value:Int=c.toInt()
    println(value)

    //获取字符串的ascii编码
    val str="I love you"
    //遍历获取 每一个字符的ascii码
    val array = str.toCharArray()
    val stringBuilder = StringBuilder()
    val result=with(stringBuilder){
        for(ch in array){
            //println(ch)
            val result = ch.toInt()
            stringBuilder.append(result.toString()+" ")
            //println(result)
        }
        stringBuilder.toString()
    }
    println(result)
}