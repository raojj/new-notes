package grammar.E_JavaInternet.B3_Reflection;

/**
 * @Description：
 * @Version：V1.0
 * @JDK-Version:1.8
 * @SoftWare:IntelliJ-IDEA-2022.1
 * @Author:Joe
 * @CreateTime:2022/5/231955
 */
public class Person {
    int age;
    private String name;

    public Person() {}

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    private Person(String name) {
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
        return "Person{"+"name:"+this.name+",age:"+this.age+"}";
    }

    private void show(){
        System.out.println("你好，我是一个人");
    }

    public void showNation(){
        System.out.println("你好，我是一个中国人");
    }
}
