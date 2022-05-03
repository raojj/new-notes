package grammar.C_FaceTo_Object;
/*
可变个数的形参：
1.JavaSE 5.0 中提供了varargs机制，允许直接定义能和多个实参相匹配的形参。从而，可以用一种更简单的方式，
来传递个数可变的实参
2.public void test(String ... books)  和 public void test(String[] books)是一样的
3.public void test(String ... books) 里依然是用数组来操作
4.可变个数的形参必须是最后一个参数Vararg parameter must be the last in the list且最多只能声明一个可变个数的形参
 */
public class C4_Varags_Object {
    public static void main(String[] args) {
        C4_Varags_Object test = new C4_Varags_Object();
        test.test("hello","world");
        //优先单个参数的
        test.test("hello");
        test.test();
    }
    public void test(String a ){
        System.out.println(a);
    }

    public void test(String ... books){
        System.out.println("我是可变参数方法");
        for (String book : books) {
            System.out.println(book);
        }
    }
}
