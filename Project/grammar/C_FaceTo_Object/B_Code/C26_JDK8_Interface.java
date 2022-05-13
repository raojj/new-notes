package grammar.C_FaceTo_Object.B_Code;
/*
JDK8：除了定义全局常量和抽象方法以外，还可以定义静态方法、默认方法
静态方法：接口中定义的静态方法只能通过接口来调用，不能通过实现类对象来调用（C26_JDK8_Interface.Method1）
默认方法：可以通过实现类创建的对象调用，如果实现类重写了接口中的方法，调用的时候调用的是重写后的方法

注意：
1. 如果子类（实现类）继承了父类，父类中有方法和接口中重名并且子类（实现类）没有重写该方法，会调用父类的方法-->类优先原则
2. 如果实现类继承的多个接口中有同名同参数的方法，并且实现类没有重写此方法，则编译报错---->接口冲突，因此需要我们重写此方法
 */
public interface C26_JDK8_Interface {
    //静态方法
    public static void method1(){
        System.out.println("C26_JDK8_Interface:beijing");
    }
    //默认方法
    public default void method2(){
        System.out.println("C26_JDK8_Interface:shanghai");
    }
    default void method3(){
        System.out.println("C26_JDK8_Interface:nanjing");
    }
}