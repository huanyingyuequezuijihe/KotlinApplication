package com.wd.encryption

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.FileReader
import java.io.FileWriter

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/13 14:20
 * @classname :CryptProject
 *
 * 对称加密 应用场景 解释
 */
class CryptProject {
}
fun main(args:Array<String>){
    //AES要求密钥 16位
    val key="1234567812345678"
    //获取联系人数据
    val json="我这也没啥数据呀，那就随便喽"
    //将QQ联系人缓存到本地，加密
    /*val br = BufferedWriter(FileWriter("UserInfo.db"))
    //加密
    val encrypt = AESCrypt.encrypt(json, key)
    br.write(encrypt) //最终存的是密文
    //关流
    br.close()*/

    //显示 解密
    val br = BufferedReader(FileReader("UserInfo.db"))
    val readLine = br.readLine()
    println("读取缓存数据="+AESCrypt.decrypt(readLine,key))
}