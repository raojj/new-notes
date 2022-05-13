package grammar.C_FaceTo_Object.B_Code;
/*
面向对象的特征三：多态性
1.可以理解为一个事物的多种形态
Person p = new Man();
对象的多态性:父类的引用指向子类的对象

多态的使用：当调用子父类同名同参数的方法时，实际执行的是子类重写父类的方法————虚拟方法调用
编译的时候认为是父类的方法，所以不能在编译时调用子类特有的方法
执行的时候认为是子类的方法

多态性的使用前提;
类的继承关系
方法的重写

对象的多态性：只适用于方法，不适用于属性

向下转型：转换时可能会出现异常
父类----------------------------->子类
   向下转型，使用instanceof进行判断
父类<-----------------------------子类
   向上转型：多态

instanceof关键字的使用：
为了避免在向下转型的时候出现ClassCastException的异常，在转型前需要用instanceof判断一下
a instanceof A:判断对象a是否是类A 的实例，如果是返回true，如果不是返回false
类B是类A的父类
则如果 a instanceof A返回true，那么 a instanceof B 也返回true
 */
public class C14_Polymorphism_Object {
    public static void main(String[] args) {
        C14_Polymorphism_Object test = new C14_Polymorphism_Object();
        test.func(new dog());
        test.func(new cat());
        Animal animal = new dog();
        if (animal instanceof dog){
            dog do1 = (dog) animal;
            do1.run();
        }

    }









    public void func(Animal animal){
        animal.eat();
        animal.shout();
    }
}

class Animal{
    int height;
    int weight;
    String name;
    public void eat(){
        System.out.println("animal eat");
    }
    public void shout(){
        System.out.println("animal shout");
    }
}

class dog extends Animal{
    public void eat(){
        System.out.println("dog eat");
    }
    public void shout(){
        System.out.println("dog shout");
    }

    public void run(){
        System.out.println("dog run");
    }
}
class cat extends Animal{
    public void eat(){
        System.out.println("cat eat");
    }
    public void shout(){
        System.out.println("cat shout");
    }

    public void lie(){
        System.out.println("cat lie");
    }
}