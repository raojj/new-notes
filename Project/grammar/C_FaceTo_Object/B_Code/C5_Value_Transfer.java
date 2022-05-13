package grammar.C_FaceTo_Object.B_Code;
/*


 */
public class C5_Value_Transfer {
    public static void main(String[] args) {
        int m = 10;
        int n = m;
        System.out.println("m=" +m+",n="+n);
        //对于基本数据类型，n=m是重新拿出来一个地址给n，并且value是m的value,因此对n重新赋值时不会改变m的值
        n = 20;
        System.out.println("m=" +m+",n="+n);

        test o1 = new test();
        o1.idNumber = 1001;
        //对于引用型参数，由于将o1赋值给o2时，两者指向堆空间的同一个地址，因此对o2.idNumber进行重新赋值的时候o1.idNumber的值也会改变
        test o2 = o1;
        System.out.println("o1.idNumber" +o1.idNumber+",o2.idNumber="+o2.idNumber);
        o2.idNumber = 1002;
        System.out.println("o1.idNumber" +o1.idNumber+",o2.idNumber="+o2.idNumber);
    }
}
class test{
    int idNumber;
}