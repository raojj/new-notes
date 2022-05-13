package grammar.D_HigeLevel_Program.B2_Thread_Highlevel.Code;

import org.testng.annotations.Test;

/**
 * @Description：StringBuffer_&_StringBuilder
 * @Version：V1.0
 * @JDK-Version:1.8
 * @SoftWare:IntelliJ-IDEA-2022.1
 * @Author:Joe
 * @CreateTime:2022/5/122122
 */
public class demo_08 {
    @Test
    public void testStringBuffer(){
        //创建了一个长度为3+16的char[]
        StringBuffer stb1 = new StringBuffer("abc");
        //创建了一个长度为16的char型数组
        StringBuffer stb2 = new StringBuffer();
        StringBuilder stbd = new StringBuilder("hahaha");
        stb1.setCharAt(1,'m');
        stb1.append('o');
        //append超过了char[]数组的长度后，会自动扩容，默认扩容为原来的二倍+2，同时将原来的char[]复制到新的char[]
        stb1.append("oooooooooooooooooooooooooooo");
        System.out.println(stb1);
    }
}
