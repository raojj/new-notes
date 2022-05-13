package grammar.C_FaceTo_Object.B_Code;
/*
final:最终的,可以用来修饰类、方法、变量
final用来修饰一个类，表明这个类不能被继承（比如String类、System类、StringBuffer）
final用来修饰一个方法，表明这个方法不能被重写（比如Object类中getClass()）
final用来修饰一个变量，说明这个变量就称为一个常量，不能再做改变
    final若用来修饰属性，可以考虑赋值的位置有：显示初始化、代码块中初始化、构造器中初始化
    final修饰局部变量
        尤其是使用final修饰形参时，表明此形参是一个常量，也就是说在调用方法时给形参赋一个实参，
        在方法内不可以对该形参进行赋值和修改
static final 用来修饰属性、方法
    属性：全局变量
    方法：这个方法只能在内部调，不能被重写
 */
public class C21_Final_keywords {
    public static void main(String[] args) {
        System.out.println("hello java");
    }
}
