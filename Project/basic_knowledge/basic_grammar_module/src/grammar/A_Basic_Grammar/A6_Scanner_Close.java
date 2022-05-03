package grammar.A_Basic_Grammar;/*
如何从键盘获取不同类型的变量
1.导包： import java.util.Scanner

 */

import java.util.Scanner;
public class A6_Scanner_Close {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("请输入你的分数和姓名：");
        int score = in.nextInt();
        String name = in.next();
        if (score>=90){
            System.out.println(name+",给你一辆玛莎拉蒂");
        }else if (score>=80){
            System.out.println(name+",给你100000");
        }else {
            System.out.println(name+",gun!!!");
        }
        in.close();
    }
}
