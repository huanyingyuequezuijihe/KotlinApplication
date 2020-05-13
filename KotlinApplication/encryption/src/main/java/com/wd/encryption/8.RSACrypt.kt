package com.wd.encryption

import java.security.Key
import java.security.KeyPairGenerator
import java.security.PrivateKey
import java.security.PublicKey
import javax.crypto.Cipher

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/13 14:51
 * @classname :RSACrypt
 */
object RSACrypt{
    //
    val transformation="RSA"

    /**私钥加密
     * input  原文
     * privateKey  私钥
     */
    fun encryptBiPrivateKey(input:String,privateKey:PrivateKey): String? {
        //1.创建cipher
         val cipher = Cipher.getInstance(transformation)
         //2.初始化cipher
         //val key: Key?=null
         cipher.init(Cipher.ENCRYPT_MODE,privateKey)
        //3.加密/解密
        val encrypt = cipher.doFinal(input.toByteArray())
        return Base64.encode(encrypt)
    }

    /**公钥加密
     * input  原文
     * privateKey  私钥
     */
    fun encryptBiPublicKey(input:String,publicKey: PublicKey): String? {
        //1.创建cipher
        val cipher = Cipher.getInstance(transformation)
        //2.初始化cipher
        //val key: Key?=null
        cipher.init(Cipher.ENCRYPT_MODE,publicKey)
        //3.加密/解密
        val encrypt = cipher.doFinal(input.toByteArray())
        return Base64.encode(encrypt)
    }
}
fun main(args:Array<String>){
    //如何生成密钥对
    //密钥对生成器
    val generator = KeyPairGenerator.getInstance("RSA")
    //通过生成器，生成密钥对
    val keyPair = generator.genKeyPair()
    val publicKey = keyPair.public   //公钥
    val privateKey = keyPair.private   //私钥
    //可以打印看看
    println("publicKey="+Base64.encode(publicKey.encoded))//取编码，可以借助base64
    println("privateKey="+Base64.encode(privateKey.encoded))
    //************非对接加密三部曲*************
    //1.创建cipher
   /* val cipher = Cipher.getInstance("RSA")
    //2.初始化cipher
    val key: Key?=null
    cipher.init(Cipher.ENCRYPT_MODE,key)*/
    //3.加密/解密

    val input="幻影月缺醉几何"
    //调用加密
    val encrypt = RSACrypt.encryptBiPrivateKey(input, privateKey)
    println("RSA私钥加密="+encrypt)

    val encryption = RSACrypt.encryptBiPublicKey(input, publicKey)
    println("RSA公钥加密="+encryption)
}