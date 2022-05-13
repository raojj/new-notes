package grammar.C_FaceTo_Object.B_Code;
import org.testng.annotations.Test;
/*
java中的单元测试
1.创建java类，进行单元测试
2.此类是public的，此类提供公共的无参构造器
3.此类中声明单元测试方法
    此时的单元测试方法：权限是public，没有返回值，没有形参
4.此单元测试方法上需要声明注解：@Test，并在单元测试类中导入 org.testng.annotations.Test;
5.声明好单元测试方法以后，就可以在方法体内测试相关的代码
6.写完代码后，左键双击单元测试方法名，右键run as-junit

说明：
1. 如果执行过程中没有问题，那么是绿条反之红条
 */

public class C16_JUbitTest_Object {
    @Test
    public void testEqual(){
        String str = "123";
        String str1 = "123";
        System.out.println(str.equals(str1));
    }

}

