package com.wd.kotlinapplication

import com.wd.kotlinapplication.son.Son
import com.wd.kotlinapplication.wash.BigHeadSon
import com.wd.kotlinapplication.wash.SmallHeadFather
import java.util.*

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

    //Loop：循环    Range:区间
    var nums=1..30
    var nums2=1 until 100 //[1,100)
    nums2.reversed() //倒叙  反转
    for (n in nums step 2)
        print("${n},")

    //list  map  入门
    //list  .withIndex()有下标的取数据
    var lists= listOf("买冰激凌","买苹果","买零食")
    for(l in lists){
        println(l)
    }
    for((i,e) in lists.withIndex()){
        println("${i} ${e}")
    }
    //map   有键 有值
    var maps=TreeMap<String,String>()
    maps["s"]="good"
    maps["a"]="a"
    maps["b"]="b"
    maps["c"]="c"
    println(maps["s"])

    //函数  函数表达式
    fun add(x:Int,y:Int)=x+y  //可以省略{}，并直接赋值
    var i={x:Int,y:Int -> x+y}  //结果一样，格式不同
    //接收两个int类型的值   返回一个值
    var j:(Int,Int)->Int={x,y -> x+y}

    //默认参数   具名参数
    fun getSum(PI:Float,r:Float):Float{//圆的周长
        return 2*PI*r
    }
    val sum = getSum(3.14f, 5f)
    println("圆的周长为"+sum)

    //人机交互
    println("请输入第一个数字:")
    var num1str= readLine();
    println("请输入第二个数字:")
    var num2str= readLine();
    var toInt1 = num1str?.toInt()//加上问号，则是指该数据可以为空
    var toInt2 = num2str?.toInt()
    println("${toInt1}...."+toInt2)

    //递归  no递龟  如：5的阶乘：5*4*3*2*1
    //如果数大，越界，用BigInteger()方法
    num1=5
    fun fact(n:Int):Int{
        if(n==1){
            return 1
        }else{
            return n*fact(n-1)
        }
    }
    println("${num1}的阶乘为${fact(num1)}")

    //尾递归优化  tailrec
    //累加 操作 4的累加  4+3+2+1
    //注意 次数过多  会溢出 报错
    fun oldAdd(n:Int):Int{
        if(n==1){
            return 1
        }else{
            return n+oldAdd(n-1)
        }
    }
    println("累加结果：${oldAdd(5)}")
    tailrec fun newAdd(s:Int,result:Int):Int{
        println("计算机第${s}次运算，result=${result}")
        if(s==0){
            return 1
        }else{
            return newAdd(s-1,result+s)
        }
    }
    println("累加结果：${newAdd(5,0)}")

    //idea使用入门
    //面向对象
    class Rect(var height:Int,var width:Int)
    var rect01=Rect(10,20);
    println("矩形的高度是:${rect01.height}")
    println("矩形的宽度是:${rect01.width}")

    //封装   隐藏内部实现细节   加上private
    setMotorSpeed(50)

    //继承(open和override)
    val girl2 = Girl("萝莉","柔美");
    println("性格${girl2.chactor}")
    girl2.action()

    //定义抽象类 实现抽象类
    var person1=Man("拿破仑");
    person1.eat()
    var person2=Woman("爱丽丝");
    person2.eat()

    //多态  同种功能不同表现形式
    var person3=Man("华盛顿");
    var person4=Woman("艾莉莉");
    val houseList = listOf<Human>(person1, person2, person3, person4)
    for(h in houseList){
        h.pee()
    }

    //接口IMan 抽象类
    //接口是事物的能力  抽象类是事物的本质
    person1.xiaodidi()
    for(p in houseList){
        if(p is Man){
            p.eat()
        }
    }

    //委托和代理
    var son=BigHeadSon()
    son.washBow1()
    var father=SmallHeadFather()
    father.washBow1()

    //单例模式
    //密封类 sealed class
    var s1:Son=Son.xiaolv()
    var s2:Son=Son.xiaoluozi()
    var s3:Son=Son.xiaolv()
    var list= listOf<Son>(s1,s2,s3)
    for(v in list){
        if(v is Son.xiaolv){
            v.sayHello()
        }
    }

    //闭包  closure
    //函数式编程
    //图片处理  BufferedImage 参数:宽度，高度，图片类型
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
    var temple="今天要去${placeName}游玩，首先映入眼帘的是${placeName}这${numToChinese(placeName.length)}个鎏金大字"
   return temple
}
//数字 转换 汉字
fun numToChinese(num:Int):String{
    var result=when(num){
        1 ->"一"
        2 ->"二"
        3 ->"三"
        4 ->"四"
        5 ->"五"
        else ->"太长没记住"
    }
    return result
}
//封装
private fun setMotorSpeed(speed:Int){
    println("当前转速${speed}圈/秒")
}