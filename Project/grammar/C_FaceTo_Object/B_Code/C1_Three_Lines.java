package grammar.C_FaceTo_Object.B_Code;

/*
1.java类及类的成员：属性，方法，构造器，代码块，内部类
2.面向对象的三大特征：封装性，继承性，多态性（抽象性）
3.其他关键字public，private，this，final，super，abstract，interface，import，static

面向对象的两个要素
类（class）：是对一类事物的描述，是抽象的、概念上的定义
对象（object）：是实际存在的该类事物的每个个体，因而也称为实例（instance）

如果创建了一个类的多个对象，则每一个对象都独立有一套类的属性（非static）

对象的内存解析：
堆（heap）：此内存区域的唯一目的就是存放对象实例
栈（stack）：存储局部变量
方法区（method area）：用于存储已经被虚拟机加载的类信息、常量、静态变量、即时编译器编译后的代码

匿名对象的使用：
1.huahua和grade1都不是匿名对象
2.创建对象的时候没有取名字
3.匿名对象只能使用一次
4.使用：
 */
public class C1_Three_Lines {
    public static void main(String[] args){
        studentMessage huahua = new studentMessage();
        huahua.studentName = "huahua";
        huahua.setStudentNumber("3180530023");
        huahua.setStudentSex("male");
        huahua.printStudentMessage();
        studentMessage[] grade = new studentMessage[2];
        //对象数组需要提前赋值
        grade[0] = new studentMessage();
        grade[1] = new studentMessage();
        grade[0].setStudentMessage("huahua", "3180530023", "male");
        grade[1].setStudentMessage("yuanyuan", "3171448016", "female");
        grade[0].printStudentMessage();
        grade[1].printStudentMessage();
    }
}

class studentMessage{
    private String studentNumber;
    String studentName;
    private String studentSex;

    public void setStudentNumber(String studentNumber){
        this.studentNumber = studentNumber;
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        String male = "male";
        String female = "female";
        if (studentSex.equals(male) || studentSex.equals(female)){
            this.studentSex = studentSex;
        }else {
            System.out.println("请输入正确的性别");
        }
    }

    public void getStudentNumber(){
        System.out.println(this.studentNumber);
    }

    public void printStudentMessage(){
        System.out.println("姓名：" + this.studentName + "学号为：" + this.studentNumber + "性别为：" + this.studentSex);
    }

    public void setStudentMessage(String studentName,String studentNumber,String studentSex){
        this.studentName = studentName;
        this.setStudentNumber(studentNumber);
        this.setStudentSex(studentSex);
    }
}
