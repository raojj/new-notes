package grammar.C_FaceTo_Object.B_Code;
/*
代码块（或初始化块）
    1.代码块的作用：用来初始化类、对象
    2.代码块如果有修饰的话，只能使用static
    3.静态代码块 vs 静态代码块
    静态代码块：
        >内部可以有输出语句
        >随着类的加载而执行,只执行一次
        >不可以调用非静态的结构
    非静态代码块：
        >内部可以有输出语句
        >随着对象的创建而执行
        >初始化对象
        >可以调用非静态的结构

对属性可以赋值的位置：
    1.默认初始化
    2.显示初始化
    3.构造器中初始化
    4.有了对象后可以用 对象.属性 或 对象.方法
    5.在代码块中赋值
    执行的先后顺序：1--2--3/5--4
 */
public class C20_Block_Object {
    public static void main(String[] args) {
        chinesePerson cp = new chinesePerson();
        chinesePerson cp1 = new chinesePerson();
    }
}


class chinesePerson{
    //属性
    String name;
    int age;
    static String desc = "我是中国人";
    //构造器
    public chinesePerson(){

    }

    public chinesePerson(int age,String name){
        this.age = age;
        this.name = name;
    }

    //代码块
    static{
        System.out.println("hello static block");
    }

    {
        System.out.println("hello block");
    }
    //方法
    public void eat(){
        System.out.println("中国人爱吃饺子");
    }

    @Override
    public String toString() {
        return "chinesePerson [name="+name+",age="+age+"]";
    }

    public static void info(){
        System.out.println("我是一个快乐的中国人");
    }
}