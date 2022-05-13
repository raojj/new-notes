package grammar.D_HigeLevel_Program.B1_Exception_HighLevel.Code;

import javafx.scene.chart.PieChart;
import org.testng.annotations.Test;

import java.util.Scanner;

public class demo_02 {
    //NullPointerException
    @Test
    public void test1(){
        int[] nums = null;
        System.out.println(nums[0]);
    }
    //ArrayIndexOutOfBoundsException
    @Test
    public void test2(){
        int[] nums = new int[5];
        System.out.println(nums[5]);
    }
    //ClassCstException
    @Test
    public void test3(){
        Object obj = new PieChart.Data("",20);
        String str = (String) obj;
    }
    //NumberFormatException
    @Test
    public void test4(){
        String str = "abc";
        int num = Integer.parseInt(str);
    }

    @Test
    public void test5(){
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
    }
}
