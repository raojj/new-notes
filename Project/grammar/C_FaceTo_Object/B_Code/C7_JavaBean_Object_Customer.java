package grammar.C_FaceTo_Object.B_Code;
/*
JavaBean是一种Java语言写成的可以重用组件

所谓JavaBean是指符合以下标准的Java类：
1.类是公共的
2.有一个无参的公共的构造器
3.有属性，且有对应的getter和setter方法

用户可以使用JavaBean将功能、处理、值、数据库访问和其他任何可以用Java代码创造的对象进行打包，并且其他的开发者可以通过内部的JSP
页面、Servlet、其他JavaBean、applet程序或者应用来使用这些对象。用户可以认为JavaBean提供了一种随时随地的复制粘贴的功能
而不用关心任何改变
 */
public class C7_JavaBean_Object_Customer {
    private String id;
    private String name;
    private int salary;

    public C7_JavaBean_Object_Customer(){

    }

    public C7_JavaBean_Object_Customer(String id,String name,int salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
