package grammar.C_FaceTo_Object.B_Code;
/*
类的结构之三：构造器（constructor）的使用：
构造器的使用：
1.创建对象
2.初始化对象的信息

说明：
1.如果没有显示的定义类的构造器的话，则系统默认提供一个空参的构造器
2.定义构造器的格式：权限修饰符 类名(形参列表){}
3.一个类中定义的多个构造器彼此之间构成重载
4.一旦我们显示的定义了类的构造器之后，系统不再提供默认的空参构造器
5.一个类中至少会有一个构造器
 */
public class C6_Constructor_Object {
    public static void main(String[] args) {
        //创建对象：new + 构造器
        Person p = new Person();
        Person person1 = new Person("Tom",12);
        p.eatFood();
    }
}

class Person{
    //属性
    String name;
    int age;

    //构造器
    public Person(){
        System.out.println("构造器");
    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    //方法
    public void eatFood(){
        System.out.println("delicious");
    }
}