package grammar.C_FaceTo_Object.B_Code;
/*
方法的重载：
1.定义：在同一个类中允许存在方法名相同但是传入参数不同的方法
2.通过对象调用方法（方法名————>参数列表）
 */
public class C3_Overload_Object {
    public static void main(String[] args) {
        C3_Overload_Object test = new C3_Overload_Object();
        test.getSum(2,3);
        test.getSum(5.6,16.8);
    }

    public void getSum(int a, int b){
        System.out.println("两数和为：" + (a+b));
    }

    public void getSum(double a, double b){
        System.out.println("两数和为：" + (a+b));
    }

    public void getSum(float a, float b){
        System.out.println("两数和为：" + (a+b));
    }
}
