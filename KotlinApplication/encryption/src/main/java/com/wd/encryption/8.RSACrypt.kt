package com.wd.encryption

import java.io.ByteArrayOutputStream
import java.security.*
import java.security.spec.PKCS8EncodedKeySpec
import java.security.spec.X509EncodedKeySpec
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

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
    /*val generator = KeyPairGenerator.getInstance("RSA")
    //通过生成器，生成密钥对
    val keyPair = generator.genKeyPair()
    val publicKey = keyPair.public   //公钥
    val privateKey = keyPair.private   //私钥
    //可以打印看看
    println("publicKey="+Base64.encode(publicKey.encoded))//取编码，可以借助base64
    println("privateKey="+Base64.encode(privateKey.encoded))
    //   ***********非对接加密三部曲*************
    //1.创建cipher
    val cipher = Cipher.getInstance("RSA")
    //2.初始化cipher
    //val key: Key?=null
    //cipher.init(Cipher.ENCRYPT_MODE,key)
    //3.加密/解密
*/
    //保存密钥对
    val publicKeyStr ="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiADQ7C3bh8qlkxoBgmPDGVd1V+dljHhKdPYAO/lbvq2kEpdlqk+ggqQrvgL6zVLEMaUTSSDnMq0rvt7RoZNdPiCzIrN/pgERXtMl69HT5nhHbBa1JLI9gTiGAICp2qCP2ODH8DeInJqzJHlvIKS0PdqFlYT6EIz5crXxbdHYla/Vdo97MYTr/rYf9YFWgu+E1o2Lx21ChYQeeEf/zTT/zCLaHbFPOPV2e2gO+ZC9LYkr0SugubtjMGFMeCjLcntQjgzY0v3h5c95Ia6RkngSSI8ch0OHZ7pzCMSTRFs50J3rhXz+JCvlVWU5rTVEAFDyh0f4Ry0WyzNA8RboPb8/VQIDAQAB"
    val privateKeyStr="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCIANDsLduHyqWTGgGCY8MZV3VX52WMeEp09gA7+Vu+raQSl2WqT6CCpCu+AvrNUsQxpRNJIOcyrSu+3tGhk10+ILMis3+mARFe0yXr0dPmeEdsFrUksj2BOIYAgKnaoI/Y4MfwN4icmrMkeW8gpLQ92oWVhPoQjPlytfFt0diVr9V2j3sxhOv+th/1gVaC74TWjYvHbUKFhB54R//NNP/MItodsU849XZ7aA75kL0tiSvRK6C5u2MwYUx4KMtye1CODNjS/eHlz3khrpGSeBJIjxyHQ4dnunMIxJNEWznQneuFfP4kK+VVZTmtNUQAUPKHR/hHLRbLM0DxFug9vz9VAgMBAAECggEAUORLX26XGFlLyga5xxgXPsdqH/Kdz8LsZky7LvDNxMf6wqQR8A6UZZ/H9KhJDD6iOvT4V5KecOHXFxvoi7Xey8kfQxCIZ/BSqJfmAjE3W+lGcd+/tifdtTItYbclT8gYRuLLiPE+7AaHbrZbhorwOanzsk75fUacR8I36x3ZOI4PIGObenjaRw8W1yvUvADoFYn586nmp2We7IfeMZL8aQxKVim7aXw47BAIMTCXdrChxaHSCEEu2m+82mQwd3LMoDT/jHh47EkR6PaOhpN699DTMwJkYgpXsIPKIfZJ4/kF3XofqJzqiCHLgEFX3fPo6F6Sidxvyzzbj5MhBiv6AQKBgQDgeSkdih4j9v4iLqZ76uYXNNOAWUA0fLgNN1eCgN5d8Fl5w2gw8tpoklRADcs2jNXiu3HyWy557PD+4bicVmkz683y5+BhjMRu6OkMyR+WUtcfHKvQxYIeQ+jBLTjdztbfnLKX884LZisFkGPgX2709afam0Q4vmqwJ5iuKBGwIQKBgQCbGsBrfAcZ/iXCu8cZfC4S/A4qBiXyXRhrMAeQElpgNbrn3OYmNmYQuC7P4ouzm0MH/98XdiVcdZjeUhp5D866p1TVx3DLQ7mkM9RqxZomFpVs2rO4md/lNVLOS8a7JEAw7vbQaAdZptoILQVZpohCk/eF4Zysgc++waxaVea4tQKBgQDNCt+btAZEI+GPp707hB4ZJI/ttZkIWMRmjh7Jfp2ggWO57dzGmY8X5lI/EFqHwa2+Jiq3jsKtbNnWeKkBZY1DeCnvsA8uDD+CcA4xN6Y60gDe0nm/giqRKsb5bi17ruxn5eLdGj8j+ndh5brVwVbBO4PQE/QFQSqDLigxLTi7AQKBgE/Z+e5cMBvFqBMVMW+BawcDFRe1ipu4KfYlB/+4MycNAmiUZTiPEQTSjecgruOMr3nS1Tvy61EqicULZ+2job6enyJgR0WeXFiZBmbhzHaHce5Uuenz7jzGsxbaFDoMc6+9lvu8Uuxo5h8HbpW1ErmUC/61JD/7pMSEWQM47ktxAoGASAgafK7bMNmyMRXqGW2pMyN/gjM7mTTRq1aqpM2pk3polNmk9+jF7q0am0tQZpNavEPOAbAeJtZtYqtmhbxZdURthk7RGtFoNYvL/qeO70ic0LVw0ywwQ/z9JA8hSauMZW/nBzJdC9SD+ur7gpX6nJOshA0UOpZjKIL8NtHmn+4="

    //要将字符串  转换为对象  密钥对对象
    val kf = KeyFactory.getInstance("RSA")//密钥工厂

    val privateKey:PrivateKey= kf.generatePrivate(PKCS8EncodedKeySpec(Base64.decode(privateKeyStr)))
    val publicKey:PublicKey=kf.generatePublic(X509EncodedKeySpec(Base64.decode(publicKeyStr)))

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