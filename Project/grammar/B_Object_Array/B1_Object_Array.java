package grammar.B_Object_Array;

import java.util.Arrays;
import java.util.Scanner;

/*
数组的特点：
1.数组的本身是引用数据类型，其内部的数据可以是任意类型的数据
2.数组在内存中开阔一片连续的空间，数组的长度一旦确定就不能再改变了

数组的声明和初始化：
1.声明：
int[] ids;
2.静态初始化：数组的初始化和数组的元素赋值同时进行
ids = new int[]{1001,1002,1003,1004};
int[] ids = {1001,1002,1003,1004};
3.动态初始化：数组的初始化和数组的元素赋值分开操作
String[] names = new String[5];

数组的性质
1.array.length 输出数组的元素个数

数组工具类的使用
import java.util.Arrays;

数组使用中的常见的异常

 */
public class B1_Object_Array {
    public static void  main(String[] args){

        Scanner in = new Scanner(System.in);
        int[] nums = new int[5];
        System.out.println(nums.length);
        for (int index = 0; index<nums.length; index++){
            nums[index] = in.nextInt();
        }
        printArray(nums);
        System.out.println("max=" + maxValueInArrays(nums));
        System.out.println("min=" + minValueInArrays(nums));
        System.out.println("average=" + averageNums(nums));
        System.out.println("sum=" + sumArrays(nums));
        System.out.println("请输入你想要查找的数：");
        int data = in.nextInt();
        findData(data,nums);
        System.out.println("请输入你想要查找的位置：");
        int index = in.nextInt();
        findDataWithPosition(index,nums);
        System.out.println(Arrays.equals(nums,nums));
        in.close();
    }








    public static int randomNums(){
        int x = (int)(Math.random()*30+1);
        return x;
    }

    public static int maxValueInArrays(int[] array){
        int maxvalue = 0;
        for (int index = 0; index < array.length; index++){
            if (array[index]>maxvalue){
                maxvalue = array[index];
            }
        }
        return maxvalue;
    }

    public static int minValueInArrays(int[] array){
        int minvalue = array[0];
        for (int index = 0; index < array.length; index++){
            if (array[index]<minvalue){
                minvalue = array[index];
            }
        }
        return minvalue;
    }

    public static int sumArrays(int[] array){
        int sum = 0;
        for (int index = 0; index <array.length; index++){
            sum = sum+array[index];
        }
        return sum;
    }

    public static double averageNums(int[] array){
        double average = 0.0;
        int sumN = sumArrays(array);
        average = sumN/array.length;
        return average;
    }

    public static void printArray(int[] array) {
        for (int index = 0; index < array.length; index++) {
            System.out.println(array[index]);
        }
        return;
    }

    public  static void findData(int data,int[] array){
        int index = 0;
        for (index = 0; index < array.length; index++){
            if(data==array[index]){
                System.out.println("找到啦！位置是：" + (index+1));
            }else{
                System.out.println((index+1) + "号位置没有你要找的数");
            }
        }
        return;
    }

    public static void findDataWithPosition(int index, int[] array){
        if (index<0 || index>array.length+1){
            System.out.println("位置错误");
        }else{
            System.out.println(index + "号位置的数据为" + array[index-1]);
        }
        return;
    }

}