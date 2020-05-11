package com.wd.kotlinapplication

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/11 14:16
 * @classname :KotlinText
 */

//main函数  程序入口  是计算机默认找的的一个运行的函数
fun main(args:Array<String>){
    println("hello world")

    //变量的声明及使用
    //第一次创建好空间后，是什么类型就固定了，不可更改
    var name="后羿";
    println(name)
    //再次赋值  会覆盖
    name="嫦娥"
    println(name)

    //kotlin 类型推断  type inference
    //注意 创建好后，是什么类型就固定了，不可更改
    var a=18;//int
    var c=121111111111111111//long
    var b="帝俊"//字符串
    //var 可更改      val不可更改（只读）
    val d=520

    //kotlin 函数
    //1.利用函数 打印菱形
    println("   *")
    println("  ***")
    print5star()//调用方法  效果一样
    println("  ***")
    println("   *")
    println(" ======== ")

    //kotlin Boolean 运算
    var num1=4
    var num2=6
    println(num1>num2)
    var num3=Math.sqrt(5.0)//根号5
    var num4=Math.sqrt(6.0)//根号6
    println(num4>num3)
    var num5=Math.pow(2.0,100.0)//2的100次方
    var num6=Math.pow(3.0,55.0)//3的55次方
    println(num5>num6)
    println("num5:"+num5)
    println("num6:"+num6)

    //kotlin 函数加强
    //函数的本质：一个或一组功能的组合
    /**
    fun 方法名(参数名:参数类型):返回值类型{
    函数体
    }
     */
    println("1314+520="+ plus(1314,520))
    println("1314-520="+ sub(1314,520))
    println("1314*520="+ mutl(1314,520))
    println("1314/520="+ devide(1314,520))

    //kotlin  字符串模板
    val diaryGenerater = diaryGenerater("紫荆宫")
    println(diaryGenerater)

    //kotlin  if else判断
    var score=90;
    if(score>=90){
        println("这是一个帅哥")
    }else{
        println("这是一个衰哥")
    }
    var aa=3
    var bb=7
    fun returnBig(aa:Int,bb:Int):Int{
        if(aa>bb)
            return aa
        else
            return bb

    }
    println("${aa}和${bb}中的最大值为"+returnBig(aa,bb))

    //kotlin 字符串比较
    var str1="张三"
    var str2="张三"
    //判断两个字符串是否相等
    println(str1==str2)//在java中，判断的是地址值
    println(str1.equals(str2))//在java中，用equals方法判断字符串
    println(str1.equals(str2,true))//第二个参数表示忽略字母的大小写

    //空值处理，null在计算器中也是值，表示没有数据
    //加上问号，代表参数可以为空
    fun heat(str:String?):String{
        return "热"+str
    }
    val heat = heat(null)
    println(heat)

    //when 使用
    score=10
    when(score){
        10 -> println("good")
        9 -> println("a")
        8 -> println("b")
        7 -> println("c")
        else -> println("d")
    }
}
fun print5star(){
    println(" *****")
}
fun plus(a:Int,b:Int):Int{
    return a+b;
}
fun sub(a:Int,b:Int):Int{
    return a-b;
}
fun mutl(a:Int,b:Int):Int{
    return a*b;
}
fun devide(a:Int,b:Int):Int{
    return a/b;
}
//12 - 作业  三个函数
fun sayHello(name:String):String{
    return "";
}
fun checkAge(age:Int):Boolean{
    return false;
}
fun saveLog(logLevel:Int):Unit{
}
//日记生成器，接收参数是地点，返回值是内容
fun diaryGenerater(placeName:String):String{
    var temple="今天要去${placeName}游玩，首先映入眼帘的是${placeName}这${placeName.length}个鎏金大字"
   return temple
}