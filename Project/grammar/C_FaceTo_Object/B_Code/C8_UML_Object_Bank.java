package grammar.C_FaceTo_Object.B_Code;

import grammar.C_FaceTo_Object.B_Code.C7_JavaBean_Object_Customer;

/*
      Bank                          //类名
-customers:Customer[]               //-代表private，类型是Customer对象数组
-numberOfCustomers:int
+Bank()                             //无参构造器，+代表public
+addCustomer(f:String,l:String)     //public方法，参数为两个String，名为f和l
+getNumberOfCustomers():int         //public方法，无参，返回类型为int
+getCustomer(index:int):Customer    // public方法，参数为int型的index，返回类型为Customer对象

 */
public class C8_UML_Object_Bank {
    private C7_JavaBean_Object_Customer[] customers;
    private int numberOfCustomer;

    public C8_UML_Object_Bank(){

    }

}
