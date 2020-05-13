package com.wd.encryption

import java.io.ByteArrayOutputStream
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
    //每次最大加密的长度
    val ENCRYPT_MAX_SIZE=117
    //每次最大解密长度
    val DECRYPT_MAX_SIZE=256

    /**私钥加密
     * input  原文
     * privateKey  私钥
     */
    fun encryptBiPrivateKey(input:String,privateKey:PrivateKey): String {
        //将传入的input原文进行分段
        val byteArray = input.toByteArray()

        //1.创建cipher
         val cipher = Cipher.getInstance(transformation)
         //2.初始化cipher
         //val key: Key?=null
         cipher.init(Cipher.ENCRYPT_MODE,privateKey)
        //3.加密   分段加密
        //val encrypt = cipher.doFinal(input.toByteArray())

        //
        var temp:ByteArray?=null
        var offset=0  //当前偏移的位置
        val bos = ByteArrayOutputStream()

        while(byteArray.size -offset>0){ //说明没有加密完
            //每次最大加密的长度
            if(byteArray.size - offset >= ENCRYPT_MAX_SIZE){
                //说明 剩余部分 大于117
                //加密完整117长度的代码
                temp= cipher.doFinal(byteArray,offset, ENCRYPT_MAX_SIZE)
                //重新计算偏移的位置
                offset+= ENCRYPT_MAX_SIZE
            }else{
                //加密最后一块
                temp= cipher.doFinal(byteArray,offset, byteArray.size-offset)
                //重新计算偏移的位置
                offset= byteArray.size
            }
            //存储到临时的缓存区
            bos.write(temp)
        }
        //关流
        bos.close()
        return Base64.encode(bos.toByteArray())
    }

    /**公钥加密
     * input  原文
     * privateKey  私钥
     */
    fun encryptBiPublicKey(input:String,publicKey: PublicKey): String {
        //将传入的input原文进行分段
        val byteArray = input.toByteArray()

        //1.创建cipher
        val cipher = Cipher.getInstance(transformation)
        //2.初始化cipher
        //val key: Key?=null
        cipher.init(Cipher.ENCRYPT_MODE,publicKey)
        //3.加密/解密
        //val encrypt = cipher.doFinal(input.toByteArray())
        //
        var temp:ByteArray?=null
        var offset=0  //当前偏移的位置
        val bos = ByteArrayOutputStream()

        while(byteArray.size -offset>0){ //说明没有加密完
            //每次最大加密的长度
            if(byteArray.size - offset >= ENCRYPT_MAX_SIZE){
                //说明 剩余部分 大于117
                //加密完整117长度的代码
                temp= cipher.doFinal(byteArray,offset, ENCRYPT_MAX_SIZE)
                //重新计算偏移的位置
                offset+= ENCRYPT_MAX_SIZE
            }else{
                //加密最后一块
                temp= cipher.doFinal(byteArray,offset, byteArray.size-offset)
                //重新计算偏移的位置
                offset= byteArray.size
            }
            //存储到临时的缓存区
            bos.write(temp)
        }
        //关流
        bos.close()
        return Base64.encode(bos.toByteArray())
    }

    /**私钥解密
     * input  密文
     * privateKey  私钥
     */
    fun decryptBiPrivateKey(input:String,privateKey:PrivateKey): String {
        //将传入的input原文进行分段
        val byteArray = Base64.decode(input)

        //1.创建cipher
        val cipher = Cipher.getInstance(transformation)
        //2.初始化cipher
        //val key: Key?=null
        cipher.init(Cipher.DECRYPT_MODE,privateKey)
        //3.解密   分段解密

        //
        var temp:ByteArray?=null
        var offset=0  //当前偏移的位置
        val bos = ByteArrayOutputStream()

        while(byteArray.size -offset>0){ //说明没有加密完
            //每次最大解密长度 为256
            if(byteArray.size - offset >= DECRYPT_MAX_SIZE){
                temp= cipher.doFinal(byteArray,offset, DECRYPT_MAX_SIZE)
                //重新计算偏移的位置
                offset+= DECRYPT_MAX_SIZE
            }else{
                //加密最后一块
                temp= cipher.doFinal(byteArray,offset, byteArray.size-offset)
                //重新计算偏移的位置
                offset = byteArray.size
            }
            //存储到临时的缓存区
            bos.write(temp)
        }
        //关流
        bos.close()
        return String(bos.toByteArray())
    }

    /**公钥解密
     * input  密文
     * publicKey  私钥
     */
    fun decryptBiPublicKey(input:String,publicKey:PublicKey): String {
        //将传入的input原文进行分段
        val byteArray = Base64.decode(input)

        //1.创建cipher
        val cipher = Cipher.getInstance(transformation)
        //2.初始化cipher
        //val key: Key?=null
        cipher.init(Cipher.DECRYPT_MODE,publicKey)
        //3.解密   分段解密

        //
        var temp:ByteArray?=null
        var offset=0  //当前偏移的位置
        val bos = ByteArrayOutputStream()

        while(byteArray.size -offset>0){ //说明没有加密完
            //每次最大解密长度 为256
            if(byteArray.size - offset >= DECRYPT_MAX_SIZE){
                temp= cipher.doFinal(byteArray,offset, DECRYPT_MAX_SIZE)
                //重新计算偏移的位置
                offset+= DECRYPT_MAX_SIZE
            }else{
                //加密最后一块
                temp= cipher.doFinal(byteArray,offset, byteArray.size-offset)
                //重新计算偏移的位置
                offset = byteArray.size
            }
            //存储到临时的缓存区
            bos.write(temp)
        }
        //关流
        bos.close()
        return String(bos.toByteArray())
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
    //调用加密  加密有要求，不能超过117个字节（一个汉字三个字节）
    //这个时候 可以使用  分段加密
    val encrypt = RSACrypt.encryptBiPrivateKey(input, privateKey)
    println("RSA私钥加密="+encrypt)

    val encryption = RSACrypt.encryptBiPublicKey(input, publicKey)
    println("RSA公钥加密="+encryption)

    val decrypt = RSACrypt.decryptBiPrivateKey(encryption, privateKey)
    println("RSA私钥解密="+decrypt)

    val decryption = RSACrypt.decryptBiPublicKey(encrypt, publicKey)
    println("RSA公钥解密="+decryption)
}