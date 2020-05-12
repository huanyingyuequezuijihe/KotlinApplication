package com.wd.encryption

import java.lang.StringBuilder

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/12 20:20
 * @classname :CaesarCrypt
 */
//凯撒加密
class CaesarCrypt{
    /**加密
     * input 原文
     * key 密钥
     */
    fun encrypt(input:String,key:Int):String{
        val charArray = input.toCharArray()
        return with(StringBuffer()){
            charArray.forEach {
                //遍历每一个字符，对ascii码进行加减乘除
                val c=it //->B
                //获取支付ascii
                var ascii=c.toInt()
                //移动
                ascii += key
                //转换字符
                val result = ascii.toChar()
                //println(result)
                append(result)
            }
            //返回结果
            toString()
        }
    }
    //解密
    /**input 解密的密文
     *
     */
    fun decrypt(input:String,key:Int):String{
        val charArray = input.toCharArray()
        return with(StringBuffer()){
            charArray.forEach {
                //遍历每一个字符，对ascii码进行加减乘除
                val c=it //->B
                //获取支付ascii
                var ascii=c.toInt()
                //反方向移动
                ascii -= key
                //转换字符
                val result = ascii.toChar()
                //println(result)
                append(result)
            }
            //返回结果
            toString()
        }
    }
}
fun main(args:Array<String>){
    //移动字符
    //命令加密
    val input="I love you"
    val key=1 //密钥
    //调用方法
    val encrypt = CaesarCrypt().encrypt(input, key)
    println("凯撒加密："+encrypt)
    val decrypt = CaesarCrypt().decrypt(encrypt, key)
    println("凯撒解密："+decrypt)
}