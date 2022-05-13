package grammar.C_FaceTo_Object.B_Code;

import grammar.C_FaceTo_Object.B_Code.C7_JavaBean_Object_Customer;

/*
extends关键字
public class son extends father{
}

继承性的优点：
1.减少了代码的重复，提高了代码的复用性
2.便于功能的扩展
3.为之后多态的使用，提供了前提

格式：
class A extends B{}
A：子类、派生类、subclass
B：父类、超类、基类、superclass
子类A继承父类B后，子类就获取了父类中的结构：属性和方法
1.特别的，父类中的声明为private类型的属性和方法，子类继承父类后，任然认为继承了父类中的私有的结构
只是因为封装性的影响，使得子类不能直接调用父类的结构
2.子类继承父类以后还可以声明自己特有的属性和方法：实现功能的扩展，子类和父类的关系不是子集和集合的关系

java中关于继承性的规定：
1.java只支持单继承和多层继承：不允许多重继承
    一个子类只能有一个父类
    一个父类可以派生出多个子类

Object类
所有的java类除Object（java.lang）外,都直接或间接继承Object类

子类对象实例化的过程：
1.从结果上看：（继承性）
    子类继承父类以后，就获取了父类中声明的属性或方法
    创建子类的对象，在堆空间中就会加载所有父类中声明的属性
2.从过程上来看：
    当我们通过子类的构造器创建子类对象时，我们一定会直接或间接调用其父类的构造器，进而调用父类的父类的构造器，
    直到调用了java.lang.Object类中的空参构造器为止。正因为加载过所有父类的结构，所以才可以看到内存中有父类
    的结构，子类对象才可以考虑进行调用。

明确：虽然创建子类对象时，调用了父类的构造器，但是自始至终就创建过一个对象，即为new的子类对象
 */
public class C11_Inheritance_Object extends C7_JavaBean_Object_Customer {

    public int getMoney(int money){
        int tempt = this.getSalary() - money;
        setSalary(tempt);
        return tempt;
    }

    public int setMoney(int money){
        int tempt = this.getSalary() + money;
        setSalary(tempt);
        return tempt;
    }
}