package com.wd.encryption.`4`

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/13 8:40
 * @classname :ByteAndBit
 */
//byte  bit
fun main(args:Array<String>) {
    val ch:Char='A'
    //转换字符ascii值
    val ascii = ch.toInt()
    println(ascii)
    //变成  二进制
    val binary = Integer.toBinaryString(ascii)
    println(binary)   //一共有8位，一个英文字符占一个字节byte
}