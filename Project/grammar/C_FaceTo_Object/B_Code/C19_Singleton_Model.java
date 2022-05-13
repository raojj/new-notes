package grammar.C_FaceTo_Object.B_Code;
/*
单例（Singleton）设计模式：

设计模式：
是大量的实践中总结和理论化之后优选的代码结构、编程风格、以及解决问题的思考方式。设计模式免去我们
自己再思考和摸索。

类的单例设计模式：
就是采用一定的方法保证在整个的软件系统中，对某个类*只能存在一个对象实例*，并且该类只提供一个取得其对象实例的方法。如果我们
要让类在虚拟机中只产生一个对象：
    将类的构造器的访问权限设置为private，这样就不能用new操作符在类的外部产生类的对象，但在类内部仍可以产生该类的对象
    调用类的某个静态方法以返回类内部创建的对象
    该类对象的变量也必须定义为静态的

单例模式的懒汉式和饿汉式：
饿汉式：在类中直接创建好类，坏处：对象加载时间过长，好处：线程安全
懒汉式：用的时候再造对象，好处：节省内存空间，坏处：目前的写法，线程可能出错

单例模式的使用场景：
    网站的计数器
    应用程序的日志应用
    数据库连接池
    项目中读取配置文件的类
    Application也是单例的典型应用
    Windows的Task Manager（任务管理器）
    Windows的Recycle Bin（回收站）

book--《大话设计模式》
创建型模式：
    工厂方法模式
    抽象工厂模式
    单例模式
    建造者模式
    原型模式
结构型模式：
    适配器模式
    装饰器模式
    代理模式
    外观模式
    桥接模式
    组合模式
    享元模式
行为型模式：
    策略模式
    模板方法模式
    观察者模式
    迭代子模式
    责任链模式
    命令模式
    备忘录模式
    状态模式
    访问者模式
    中介者模式
    解释器模式
 */
public class C19_Singleton_Model {
    public static void main(String[] args) {

    }
}

//饿汉式，提前创建好对象
class bank{

    private String name;
    private int id;

    private bank(String name,int id){
        this.name=name;
        this.id=id;
    }

    private static bank instance = new bank("huahua",20);

    public static bank getInstance(){
        return instance;
    }

}
//懒汉式
class Order{
    private Order(){

    }

    private static Order instance = null;

    //方式一
    public static synchronized Order getInstance(){
        if (instance == null){
            instance = new Order();
        }
        return instance;
    }
    //方式二：效率很差
    public static  Order getInstance1() {
        synchronized (Order.class) {
            if (instance == null) {
                instance = new Order();
            }
            return instance;
        }
    }
    //方式三：比高效
    public static  Order getInstance2() {
        if (instance == null) {
            synchronized (Order.class) {
                if (instance == null) {
                    instance = new Order();
                }
            }
        }
        return instance;
    }
}