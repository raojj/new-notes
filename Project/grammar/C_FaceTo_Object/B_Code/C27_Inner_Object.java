package grammar.C_FaceTo_Object.B_Code;
/*
内部类：
一.概述
  当一个事物内部，还有一个部分需要一个完整的结构来描述，而这个内部的完整的结构又只为外部事物提供服务，那么这个内部的完整的结构最好使用内部类
  在Java中，允许一个类的定义在另一个类的内部，前者称为内部类，后者称为外部类
  Inner class一般用在定义它的类或语句块之内，在外部引用它时必须给出完整的名称，Inner class的名字不能与包含它的外部类类名相同

二.分类
  成员内部类（static成员内部类和非static成员内部类）
  局部内部类(方法内、代码块内、构造器内)（不谈修饰符）、匿名内部类

三.特点
  成员内部类
     一方面，作为外部类的成员：
          > 可以调用外部类的结构
          > 可以被static修饰
          > 可以被四种不同的权限修饰
     另一方面，作为一个类
          > 类内可以定义属性、方法、构造器、内部类等
          > 可以继承/被继承，可以被final修饰
          > 可以被abstract修饰

四.3个问题
  4.1 如何实例化内部类的对象
      静态成员内部类：外部类.静态成员内部类 对象名 = new 外部类.静态成员内部类();
      非静态成员内部类：先创建外部类的对象，外部类对象.非静态成员内部类来创建非静态成员内部类
          human h = new human();
          human.property pro = h.new property();
  4.2 如何在成员内部类中区分调用外部类机构
      方法的形参：  System.out.println(name);
      内部类的属性：System.out.println(this.name);
      外部内的属性：System.out.println(human.this.name);
  4.3 开发中局部内部类的使用情景
      创建一个有名的接口类
 */
public class C27_Inner_Object {
    public static void main(String[] args) {
        human.wife yuanyuan = new human.wife();
        human h = new human();
        human.property pro = h.new property();
    }
}
class human{
    String name;
    int age;
    double weight;
    double height;

    //成员内部类
    static class wife{

    }
    class property{
         int house_num;
         int car_num;
    }

    public void method(){
        //局部内部类
        class aa{

        }
    }
}
