package grammar.C_FaceTo_Object.B_Code;

import org.testng.annotations.Test;

/*
接口：
1.一方面，有时需要从几个类中派生出一个类，继承他们所有的属性和方法。但是，java不支持多重继承。有了接口就可以得到多重继承的效果
2.另一方面，有时需要从几个类中抽取出一些共同的行为特征，而他们之间有没有is-a（父子类）的关系，仅仅是几个相同的行为特征而已。例如鼠标、键盘、
打印机、扫描仪、摄像头、充电器、MP3机、手机、数码相机、移动硬盘等都支持USB链接
3.接口就是规范，定义的是一组规则，体现了现实世界中“如果你是/要···则必须能···”的思想。继承是一个“是不是”的关系，而接口实现的是
“能不能”的关系
4.接口的本质是契约，标准，规范，就像我们的法律一样。制定好后大家都要遵守

接口的使用：
1. 接口使用interface来定义
2. Java中，接口和类是并列的两个结构
3. 如何定义接口：定义接口中的成员
    3.1 JDK7及以前：只能定义全局常量和抽象方法
        >全局常量：public static final的（可以省略不写）
        >抽象方法：public abstract的
    3.2JDK8：除了定义全局常量和抽象方法以外，还可以定义静态方法、默认方法
        >详情见C26_JDK8_Interface
4.接口中不能定义构造器，接口不可以实例化
5.Java开发中，我们都是用类来实现接口 class B implements interface
  类链接接口后必须把所有的抽象方法重写后才能实例化
  允许多个接口：用 , 隔开--->弥补了Java不可以一次性继承多个父类的局限
6.接口和接口之间也可以继承，可以多个继承
7.接口的使用可以体现多态性
8.接口实际上可以看做是一种规范
9.如果既要继承类又要引用接口，先extends后implements
 */
public class C24_Interface_Object {
    public static void main(String[] args) {
        System.out.println(Flyable.MAX_SPEED);
        System.out.println(Flyable.MIDDLE_SPEED);
        System.out.println(Flyable.MIN_SPEED);
        Plane airplane = new Plane();
        }
    @Test
    public void Testairplane(){
        Plane airplane = new Plane();
        airplane.fly();
        airplane.stop();
    }
    }
interface Flyable{
    //全局变量
    public static final int MAX_SPEED = 7900;
    public static final int MIN_SPEED = 1;
    int MIDDLE_SPEED = 5000;
    //抽象方法
    public abstract void fly();
    void stop();
}

class Plane implements Flyable{
    @Override
    public void fly() {
        System.out.println("起飞，引擎up");
    }

    @Override
    public void stop() {
        System.out.println("降落，引擎down");
    }
}