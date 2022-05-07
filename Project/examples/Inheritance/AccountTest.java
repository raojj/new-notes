package examples.Inheritance;

import java.util.Scanner;

public class AccountTest {
    public static void main(String[] args) {
        Account c_1 = new Account(1,20000,0.05);
        Scanner in = new Scanner(System.in);
        System.out.println("请输入您想存入的钱数");
        double amount = in.nextDouble();
        c_1.deposit(amount);
        System.out.println("请输入您想取出的钱数");
        amount = in.nextDouble();
        c_1.withdraw(amount);
    }
}
