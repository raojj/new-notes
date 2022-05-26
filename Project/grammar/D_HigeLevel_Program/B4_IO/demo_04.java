package grammar.D_HigeLevel_Program.B4_IO;

import org.testng.annotations.Test;

import java.io.*;

/**
 * @Description：对象流
 * @Version：V1.0
 * @JDK-Version:1.8
 * @SoftWare:IntelliJ-IDEA-2022.1
 * @Author:Joe
 * @CreateTime:2022/5/202225
 */
public class demo_04 {
    @Test
    public void testObjectOutputStream() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("D:\\APPs\\IDEA\\Project\\basic_knowledge\\basic_grammar_module\\src\\grammar\\D_HigeLevel_Program\\B4_IO\\object.dat"));
            oos.writeObject(new person(12,"raojian"));
            oos.flush();//刷新操作
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos!=null) {
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testObjectInputStream(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("D:\\APPs\\IDEA\\Project\\basic_knowledge\\basic_grammar_module\\src\\grammar\\D_HigeLevel_Program\\B4_IO\\object.dat"));
            person p = (person) ois.readObject();
            System.out.println(p.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois!=null) {
                    ois.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class person implements Serializable {
    private static final long serialVersionUID = 475463534532L;
    private int age;
    private String name;

    public person() {}

    public person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "age:\t"+this.age+"\n"+"name:\t"+this.name;
    }
}