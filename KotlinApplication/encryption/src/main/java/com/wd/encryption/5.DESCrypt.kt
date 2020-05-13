package com.wd.encryption

import java.security.Key
import javax.crypto.Cipher
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.DESKeySpec

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/13 8:56
 * @classname :DESCrypt
 */
object DESCrypt{
    //加密
    fun encrypt(input:String,password:String): String {
        val cipher=Cipher.getInstance("DES")

        //2.初始化cipher 参数1：加密/解密的模式
        //密钥 工厂
        val kf = SecretKeyFactory.getInstance("DES")
        val keySpec=DESKeySpec(password.toByteArray())
        val generateSecret = kf.generateSecret(keySpec)

        val key:Key?=generateSecret  //允许为空
        cipher.init(Cipher.ENCRYPT_MODE,key)//加密模式

        //3.加密/解密
        val encrypt = cipher.doFinal(input.toByteArray())
        println("加密后字节数组长度="+encrypt.size)
        //base64编码  通过base64 解决乱码
        return Base64.encode(encrypt)
    }

    //解密
    fun decrypt(input:String,password:String): ByteArray {
        val cipher=Cipher.getInstance("DES")

        //2.初始化cipher 参数1：加密/解密的模式
        //密钥 工厂
        val kf = SecretKeyFactory.getInstance("DES")
        val keySpec=DESKeySpec(password.toByteArray())
        val generateSecret = kf.generateSecret(keySpec)

        val key:Key?=generateSecret  //允许为空
        cipher.init(Cipher.DECRYPT_MODE,key)//解密模式

        //3.加密/解密
        //val encrypt = cipher.doFinal(input.toByteArray())
        //base64 解码
        val encrypt = cipher.doFinal(Base64.decode(input))
        println("解密后字节数组长度="+encrypt.size)
        return encrypt
    }
}

fun main(args:Array<String>) {
    //要传入  原文
    val input="幻影月缺醉几何"
    val password="12345678"//密钥 DES密钥长度8位

    //1.创建cipher对象:学习查看api文档
    /*val cipher=Cipher.getInstance("DES")

    //2.初始化cipher 参数1：加密/解密的模式
    //密钥 工厂
    val kf = SecretKeyFactory.getInstance("DES")
    val keySpec=DESKeySpec(password.toByteArray())
    val generateSecret = kf.generateSecret(keySpec)

    val key:Key?=generateSecret  //允许为空
    cipher.init(Cipher.ENCRYPT_MODE,key)

    //3.加密/解密
    val encrypt = cipher.doFinal(input.toByteArray())*/

    val array = input.toByteArray()
    array.forEach {
        println(it)//it代表变量的每一个元素
    }

    val encrypt = DESCrypt.encrypt(input, password)
    println("DES加密:"+encrypt)  //1返回一个byte数组
                                //2string  加密后会乱码

    val decrypt = DESCrypt.decrypt(encrypt, password)
    println("DES解密:"+ String(decrypt))//转换为字符串
}