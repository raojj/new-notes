package grammar.C_FaceTo_Object.B_Code;
/*
抽象类（abstract）：
随着继承层次中一个个新子类的定义，类变得越来越一般，更通用。类的设计应该保证父类和子类能够共享特征。
有时将一个父类设计的非常抽象，以至于他没有具体的实例，这样的类叫做抽象类

abstract修饰一个类表明这个类为抽象类
    >不能创建此类的对象
    >类中仍然有构造器
    >实际工作中会提供抽象类的子类

abstract修饰一个方法表明这个方法为抽象方法
    >抽象方法没有方法体 public abstract void eat();
    >包含抽象方法的类一定是个抽象类
    >若子类重写了父类中所有的抽象方法后，子类才可以实例化，若没有，则此子类也是一个抽象类，需要使用abstract修饰

abstract的使用情景：
    >用于提醒子类需要重写方法

abstract的使用上的注意点：
    >不能用来修饰属性和构造器
    >不能用来修饰私有方法、静态方法

抽象类的匿名子类的使用：
    >
 */
public class C22_abstract_object {
}
abstract class abstractperson{
    String name;
    int age;
    double height;
    double weight;

}

class studentTest extends abstractperson{

}