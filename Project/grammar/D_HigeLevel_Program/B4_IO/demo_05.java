package grammar.D_HigeLevel_Program.B4_IO;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @Description：
 * @Version：V1.0
 * @JDK-Version:1.8
 * @SoftWare:IntelliJ-IDEA-2022.1
 * @Author:Joe
 * @CreateTime:2022/5/202322
 */
public class demo_05 {
    @Test
    public void testRandomAccessFile() {
        RandomAccessFile raf = null;
        RandomAccessFile raf1 = null;
        try {
            raf = new RandomAccessFile(new File("D:\\APPs\\IDEA\\Project\\basic_knowledge\\basic_grammar_module\\src\\grammar\\D_HigeLevel_Program\\B4_IO\\hello.txt"),"rw");
            //从开头覆盖
            raf1 = new RandomAccessFile(new File("D:\\APPs\\IDEA\\Project\\basic_knowledge\\basic_grammar_module\\src\\grammar\\D_HigeLevel_Program\\B4_IO\\hello_write.txt"),"rw");
            raf1.seek(new File("D:\\APPs\\IDEA\\Project\\basic_knowledge\\basic_grammar_module\\src\\grammar\\D_HigeLevel_Program\\B4_IO\\hello_write.txt").length());//从角标为30的地方开始
            byte[] buffer = new byte[10];
            int len;
            while ((len=raf.read(buffer))!=-1){
                raf1.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (raf!=null) {
                    raf.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (raf1!=null) {
                    raf1.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
