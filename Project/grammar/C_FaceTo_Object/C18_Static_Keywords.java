package grammar.C_FaceTo_Object;
/*
static可以用来修饰属性、方法、代码块、内部类
当所有的对象都共享一个相同的属性的时候，例如所有中国人的country都是China
类中static修饰的属性不归属与对象，而是所有对象共享的
静态变量可以通过类.变量名来调用

静态方法中只能调用静态属性或方法
非静态的方法中，既可以调用静态的属性和方法，也可以调用非静态的

静态方法中不可以使用this和super关键字

>操作静态属性的方法，通常设置为static
>工具类中的方法，习惯上声明为static。比如：Math、Arrays、Collections
 */
public class C18_Static_Keywords {
    public static void main(String[] args) {
        chinesePeople p1 = new chinesePeople("姚明",20);
        chinesePeople p2 = new chinesePeople("马云",30);
        p1.country = "China";
        System.out.println(p2.country);
    }
}








class chinesePeople{
    static String country;
    private int age;
    String name;

    public chinesePeople() {

    }

    public chinesePeople(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age<0 || age>110){
            System.out.println("请输入正确的年龄");
        }else {
            this.age = age;
        }
    }
}