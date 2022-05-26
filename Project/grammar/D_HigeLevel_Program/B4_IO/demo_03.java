package grammar.D_HigeLevel_Program.B4_IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description：标准的输入输出流
 * @Version：V1.0
 * @JDK-Version:1.8
 * @SoftWare:IntelliJ-IDEA-2022.1
 * @Author:Joe
 * @CreateTime:2022/5/201750
 */
public class demo_03 {
    public static void main(String[] args) {
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
            while (true) {
                String str = br.readLine();
                if ("exit".equalsIgnoreCase(str) || "e".equalsIgnoreCase(str)){
                    System.out.println("程序结束");
                    break;
                }
                System.out.println(str.toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br!=null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (isr!=null) {
                    isr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
