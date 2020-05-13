package com.wd.encryption

import java.security.Key
import java.security.KeyPairGenerator
import javax.crypto.Cipher

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/13 14:51
 * @classname :RSACrypt
 */
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
}