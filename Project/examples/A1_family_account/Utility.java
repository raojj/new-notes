package examples.A1_family_account;

import java.util.Scanner;

public class Utility {
    private static Scanner in = new Scanner(System.in);

    public static char readMenuSelection(){
        char c;
        for (; ;){
            String str = readKeyBoard(1);
            c = str.charAt(0);
            if (c !='1' && c !='2' && c !='3' && c !='4'){
                System.out.println("选择错误，请重新输入：");
            }else break;
        }
        return c;
    }

    private static String readKeyBoard(int limit) {
        String line = "";
        while (in.hasNext()) {
            line = in.nextLine();
            if (line.length() < 1 || line.length() > limit) {
                System.out.print("输入长度(不大于" + limit + ")");
                continue;
            } else break;
        }
        return line;
    }

    public static int readNumber(){
        int n;
        for ( ; ;){
            String str = readKeyBoard(4);
            try{
                n = Integer.parseInt(str);
                break;
            }catch (NumberFormatException e){
                System.out.println("数字输入有误，请重新输入：");
            }
        }
        return n;
    }

    public static String readString(){
        String str = readKeyBoard(8);
        return str;
    }

    public static char readConfirmSelection(){
        char c;
        for ( ; ;){
            String str = readKeyBoard(1).toUpperCase();
            c = str.charAt(0);
            if (c=='Y' || c=='N'){
                break;
            }else{
                System.out.println("选择错误，请重新输入：");
            }
        }
        return c;
    }

}
