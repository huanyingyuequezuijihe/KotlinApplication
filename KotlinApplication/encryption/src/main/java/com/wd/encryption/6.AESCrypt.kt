package com.wd.encryption

import java.security.Key
import javax.crypto.Cipher
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.SecretKeySpec

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/13 10:58
 * @classname :AESCrypt
 */
//单例模式
object AESCrypt{
    //加密
    fun encrypt(input:String,password:String): String {
        //1.创建cipher对象
        val cipher = Cipher.getInstance("AES")
        //2.初始化cipher  告诉cipher要加密还是解密
        //通过密钥工厂生成密钥
        //val kf = SecretKeyFactory.getInstance("AES")
        val keySpec:SecretKeySpec?= SecretKeySpec(password.toByteArray(),"AES")
        //val key:Key?=kf.generateSecret(keySpec)
        cipher.init(Cipher.ENCRYPT_MODE,keySpec)
        //3.加密/解密
        val encrypt = cipher.doFinal(input.toByteArray())
        val result = Base64.encode(encrypt)
        return result
    }

    //解密
    fun decrypt(input:String,password:String): String {
        //1.创建cipher对象
        val cipher = Cipher.getInstance("AES")
        //2.初始化cipher  告诉cipher要加密还是解密
        //通过密钥工厂生成密钥
        //val kf = SecretKeyFactory.getInstance("AES")
        val keySpec:SecretKeySpec?= SecretKeySpec(password.toByteArray(),"AES")
        //val key:Key?=kf.generateSecret(keySpec)
        cipher.init(Cipher.DECRYPT_MODE,keySpec)
        //3.加密/解密
        val encrypt = cipher.doFinal(Base64.decode(input))
        val result = String(encrypt)
        return result
    }
}
fun main(args:Array<String>){
    val input="幻影月缺醉几何"
    val password="1234567812345678"//AES 加密 16位
    /*//1.创建cipher对象
    val cipher = Cipher.getInstance("AES")
    //2.初始化cipher  告诉cipher要加密还是解密
    //通过密钥工厂生成密钥
    //val kf = SecretKeyFactory.getInstance("AES")
    val keySpec:SecretKeySpec?= SecretKeySpec(password.toByteArray(),"AES")
    //val key:Key?=kf.generateSecret(keySpec)
    cipher.init(Cipher.ENCRYPT_MODE,keySpec)
    //3.加密/解密
    val encrypt = cipher.doFinal(input.toByteArray())
    val result = Base64.encode(encrypt)*/

    //加密
    val encrypt = AESCrypt.encrypt(input, password)
    println("AES加密："+encrypt)

    //解密
    val decrypt = AESCrypt.decrypt(encrypt, password)
    println("AES解密："+decrypt)
}