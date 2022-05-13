package grammar.C_FaceTo_Object.B_Code;
/*
TemplateMethod模板方法设计模式：
    抽象类体现的就是一种模板模式的设计，抽象类作为多个子类的通用模板，子类在抽象类的基础上进行扩展、改造，但子类
    总体上会保留抽象类的行为模式。

解决的问题：
    1.当功能内部一部分实现是确定的，一部分实现是不确定的。这时可以把不确定的部分暴露出去，让子类去实现
    2.换句话说，在软件开发中实现一个算法时，整体步骤是很固定、通用，这些步骤已经在父类中写好了。但是某些部分易变，易变部分
    可以抽象出来，供子类实现。这就是一种模板模式
 */
public class C23_Template_Method {
    public static void main(String[] args) {
        System.out.println("example 2");
    }
}
