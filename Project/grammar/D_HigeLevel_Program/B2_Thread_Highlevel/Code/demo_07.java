package grammar.D_HigeLevel_Program.B2_Thread_Highlevel.Code;

import org.testng.annotations.Test;

/**
 * @Description：
 * @Version：V1.0
 * @JDK-Version:1.8
 * @SoftWare:IntelliJ-IDEA-2022.1
 * @Author:Joe
 * @CreateTime:2022/5/111811
 */
public class demo_07 {
    @Test
    public void testString1(){
        String s1 = "abc";
        String s2 = "abc";

        s1 = "hello";
        System.out.println(s1==s2);//比较的是两个字符串的地址值
        System.out.println(s1);
        System.out.println(s2);

        String s3 = new String("abc");
        s3 += "def";
        System.out.println(s3);

        String s4 = "abc";
        String s5 = s4.replace('a','m');
        System.out.println(s4);
        System.out.println(s5);

        System.out.println("1*************************************1");
        //赋值方式
        //通过字面量赋值，str此时存在方法区中的字符串常量池
        String str = "hello";
        String str1 = "hello";
        //通过new方法赋值，str1此时在堆空间中
        String str2 = new String("hello");
        String str3 = new String("hello");

        System.out.println(str == str1);//true
        System.out.println(str == str2);//false
        System.out.println(str2 == str3);//false
        System.out.println("2*************************************2");

        person p1 = new person("Tom",10);
        person p2 = new person("Tom",10);
        System.out.println(p1.name.equals(p2.name));//true
        System.out.println(p1.name == p2.name);//true
        System.out.println("3*************************************3");
    }

    @Test
    public void testString2(){
        String s1 = "ja";
        String s2 = "va";

        //字面量赋值
        String s3 = "java";
        //字面量的连接仍属于字面量赋值
        String s4 = "ja" + "va";
        //在堆空间中
        String s5 = s1 + "va";
        //在堆空间中
        String s6 = "ja" + s2;
        //intern()的返回值存储在常量池中
        String s7 = s3.intern();

        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//false
        System.out.println(s4 == s5);//false
        System.out.println(s4 == s6);//false
        System.out.println(s5 == s6);//false
        System.out.println(s3 == s7);//true
    }

    @Test
    public void testStringTest(){
        StringTest ex = new StringTest();
        ex.change(ex.str,ex.ch);
        System.out.println(ex.str);//good
        System.out.println(ex.ch);//best
    }
}

class person{
    String name;
    int age;

    public person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public person() {

    }
}

class StringTest{
    String str = new String("good");
    char[] ch = {'t','e','s','t'};

    public void change(String str, char ch[]){
        str = "test ok";
        ch[0] = 'b';
    }
}