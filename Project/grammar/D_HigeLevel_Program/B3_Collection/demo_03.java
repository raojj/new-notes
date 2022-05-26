package grammar.D_HigeLevel_Program.B3_Collection;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * @Description：
 * @Version：V1.0
 * @JDK-Version:1.8
 * @SoftWare:IntelliJ-IDEA-2022.1
 * @Author:Joe
 * @CreateTime:2022/5/172103
 */
public class demo_03 {

    @Test
    public void testMap(){
        Map map = new HashMap();
        map.put("rao","jian");
        map.put("liu","yuanyuan");
        System.out.println(map.entrySet());
    }

    @Test
    public void testProperties(){
        Properties pros = new Properties();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("D:\\APPs\\IDEA\\Project\\basic_knowledge\\basic_grammar_module\\src\\grammar\\D_HigeLevel_Program\\B3_Collection\\jdbc1.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            pros.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String user = pros.getProperty("password");
        System.out.println(user);
        try {
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(in.nextInt());
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -o1.compareTo(o2);
            }
        });
        System.out.println(list);
        in.close();
    }
}
