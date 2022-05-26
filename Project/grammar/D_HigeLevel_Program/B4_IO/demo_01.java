package grammar.D_HigeLevel_Program.B4_IO;

import org.testng.annotations.Test;

import java.io.File;

/**
 * @Description：file类
 * @Version：V1.0
 * @JDK-Version:1.8
 * @SoftWare:IntelliJ-IDEA-2022.1
 * @Author:Joe
 * @CreateTime:2022/5/191024
 */
public class demo_01 {
    @Test
    public void testFileConstructor(){
        //构造器1:以pathname为路径创建File对象
        File file = new File("hello.txt");//相对路径
        File file1 = new File("D:/APPs/IDEA/Project/basic_knowledge/basic_grammar_module/src/grammar/D_HigeLevel_Program/B4_IO/hello.txt");//绝对路径

        //构造器2:以parent为父路径，child为子路径创建File对象
        File file2 = new File("D:/APPs/IDEA/Project/basic_knowledge/basic_grammar_module/src/grammar/D_HigeLevel_Program","B4_IO");

        //构造器3:根据一个父File对象和子文件路径创建File对象
        File file3 = new File(file2,"hello.txt");
    }

    @Test
    public void testFileMethods(){
        File file = new File("hello.txt");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.length());
        System.out.println(file.lastModified());
        File file1 = new File("D:/APPs/IDEA/Project/basic_knowledge/basic_grammar_module/src/grammar/D_HigeLevel_Program");
        String [] list = file1.list();
        for (String str:list){
            System.out.println(str);
        }

    }

    @Test
    public void teatBooleanMethods(){
        File file = new File("D:/APPs/IDEA/Project/basic_knowledge/basic_grammar_module/src/grammar/D_HigeLevel_Program/B4_IO/hello.txt");
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.exists());
        System.out.println(file.canWrite());
        System.out.println(file.canRead());
        System.out.println(file.isHidden());
        System.out.println(file.length());
    }
}
