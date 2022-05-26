package grammar.E_JavaInternet.B3_Reflection;

import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @Description：Reflection
 * @Version：V1.0
 * @JDK-Version:1.8
 * @SoftWare:IntelliJ-IDEA-2022.1
 * @Author:Joe
 * @CreateTime:2022/5/222139
 */
public class demo_01 {

    @Test
    public void testReflection() throws Exception {
        //正常方式
        //实例化对象
        Person p1 = new Person(25,"zhangsan");
        //通过对象调用方法,私有方法除外
        p1.setAge(30);
        p1.setName("Tom");
        System.out.println(p1.toString());

        //反射方式
        //实例化对象
        Class clazz = Person.class;
        Constructor cons = clazz.getConstructor(int.class,String.class);
        Object obj = cons.newInstance(25,"Tony");
        Person p = (Person) obj;
        System.out.println(p.toString());
        //通过对象调用方法,包括私有方法
        Field age = clazz.getDeclaredField("age");
        age.set(p,99);
        System.out.println(p.toString());
        Method showNation = clazz.getDeclaredMethod("showNation");
        showNation.invoke(p);
        //私有构造器
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p2 = (Person) cons1.newInstance("Jerry");
        System.out.println(p2);
        //私有属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p2,"Li Lei");
        //私有方法
        Method show = clazz.getDeclaredMethod("show");
        show.setAccessible(true);
        show.invoke(p2);
    }

    @Test
    public void testGetClass() throws ClassNotFoundException{
        //方式一：调用运行时类的属性：.class
        Class clazz1 = Person.class;
        System.out.println(clazz1);
        //方式二：通过运行时类的对象：getClass()
        Person p1 = new Person();
        System.out.println(p1.getClass());
        //方式三：调用Class的静态方法：forName(String classPath)
        //Class class2 = Class.forName(Person);
    }

    @Test void testProperties() throws IOException {
        Properties pro = new Properties();
        //此时的文件默认在当前的module下
        //读取文件的方式一
//        FileInputStream fis = new FileInputStream("jdbc1.properties");
//        pro.load(fis);
        //方式二，使用classloader，文件默认识别为module下的src下
        ClassLoader classLoader = Person.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
        pro.load(is);
        String user = pro.getProperty("user");
        System.out.println(user);
        String password = pro.getProperty("password");
        System.out.println(password);
    }

    @Test
    public void testClass() throws IOException, InstantiationException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        /*
        newInstance()创建运行时类的对象，使用的是空参构造器，如果类中没有空参构造器则false，且空参构造器不能是private类型

        */
        Person obj = personClass.newInstance();
        System.out.println(obj);
    }
}