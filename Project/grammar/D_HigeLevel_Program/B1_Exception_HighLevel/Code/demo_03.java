package grammar.D_HigeLevel_Program.B1_Exception_HighLevel.Code;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class demo_03 {
    @Test
    public void test1(){
        String str = "abc";
        try {
            int num = Integer.parseInt(str);
            //抛出异常后，后面的代码就不再运行
            System.out.println("try....");
        }catch (NumberFormatException e){
            System.out.println("出现了数值转换异常，不要着急......");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }catch (NullPointerException e){
            System.out.println("出现了空指针异常，不要着急......");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        //catch后异常就被“处理”了，所以后面的代码可以继续执行
        System.out.println("after try...");
    }

    @Test
    public void test2(){
        try {
            File file = new File("hello.txt");
            FileInputStream fis = new FileInputStream(file);

            int data = fis.read();
            while (data!=-1){
                System.out.println((char)data);
                data = fis.read();
            }
            fis.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e ){
            e.printStackTrace();
        }
    }

    @Test
    public void test3(){
        int a = 10;
        int b = 0;
        try {
            System.out.println(a/b);
        }catch (ArithmeticException e){
            e.printStackTrace();
        }finally {
            System.out.println("Java好棒啊");
        }
    }

    @Test
    public int test4(){
        try {
            int[] nums = new int[10];
            System.out.println(nums[10]);
            return 1;
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            return 2;
        }finally {
            System.out.println("我一定会被执行");
            return 3;
        }
    }

    @Test
    public void test5(){
        FileInputStream fis = null;
        try {
            File file = new File("hello.txt");
            fis = new FileInputStream(file);

            int data = fis.read();
            while (data != -1) {
                System.out.println((char) data);
                data = fis.read();
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }





}
