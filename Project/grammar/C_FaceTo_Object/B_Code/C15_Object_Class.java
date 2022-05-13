package grammar.C_FaceTo_Object.B_Code;

import grammar.C_FaceTo_Object.B_Code.Animal;

/*
java.lang包下的Object类：
通过以下语句可以获得oder的父类
order.getClass().getSuperclass()

==和equals()的区别：
==是运算符
1. 可以使用在基本数据类型变量和引用数据类型变量中
2. 如果是基本数据类型，那么就是比较两个变量储存的数据是否相等
3. 如果比较的是引用数据类型，那么是比较两个引用数据类型的地址值是否相同
equals()是方法
1. equals()只能适用于引用数据类型
2. Object类中定义的equals()和==相同，也就是比较两个对象的地址值
public boolean equals(Object obj) {
        return (this == obj);
    }
3. 像String、Data、File、包装类等都重写了Object类中的equals()方法。重写以后，比较的不是两个引用地址是否相同
   而是比较两个对象的“实体内容”是否相同

toString()的使用
Object里的toString():
1. 当我们输出一个对象的引用时，实际上就是调用当前对象的toString()
public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
2. 像String、Data、File、包装类等都重写了toString()方法
   使得在调用对象的toString()方法时返回“实体信息”的内容
 */
public class C15_Object_Class {
    public static void main(String[] args) {
       //两个都可以进行垃圾回收，垃圾回收前会调用finalize方法
        System.gc();
        Runtime.getRuntime().gc();
        String str = "0123";
        String str1 = "0123";
        char[] charList = str.toCharArray();
        System.out.println(str.equals(str1));
        System.out.println("********************************");
        Animal u = new Animal();
        u.height = 10;
        u.weight = 20;
        u.name = "yuanyuan";
        System.out.println(u.toString());
    }
}
