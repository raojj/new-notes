## public class需要放在同一个package里：

```java
public class student{
    String name;
    String number;
    String sex;
    //封装对象，age将无法被类外直接访问，private隐藏对象+public类内函数访问
    private int age;
    //定义age的public函数setAge提供赋值函数并判断age指是否为真
    public void setAge(int age){
        if(age<0 || age>100){
            System.out.println("error");
            return;
        }
        this.age=age;
    }
    //定义age的public函数getAge提供访问函数
    public int getAge(){
        return this.age;
    }
    //定义类内成员赋值函数
    void init( String name,String number,String sex,int age){
        this.name=name;
        this.number=number;
        this.sex=sex;
    }
    //类内定义输出函数
    void display(){
        System.out.println(name);
        System.out.println(number);
        Sysem.out.println(sex);
    }
}
```

