package grammar.A_Basic_Grammar;/*
变量的要求：
1.java中每个变量必须先声明，后使用
2.使用变量名来访问这块区域的数据
3.变量的作用域：其定义所在的一对{}
4.变量只能在作用域内使用
5.同一个作用域不能定义重名的变量
*/


/*
变量的分类：
基本数据类型（primitive type）
    数值型：
        整数类型（byte、short、int、long）
        浮点类型（float、double）
    非数值型：
        字符型（char）内部只能写一个字符,unicode编码类型
        布尔型（boolean）
引用数据类型（reference type）
    类（class）字符串属于类
    接口（interface）
    数组（array[]）
*/


/*
成员变量：
局部变量：
*/


/*
基本数据（boolean类型除外）类型之间的运算规则：

1.自动类型提升：
    从低范围的数据类型向高范围(表示数值的范围)的数据类型转换
    从整型向浮点型转换
    byte、char、short-->int-->long-->float-->double
    byte i = 4;
    int a = 129;
    int b = i + a;

2.强制类型转换：
    自动类型转换的逆运算
    注意强制类型转换可能会导致精度损失
*/
public class A4_Variable_Data {
    public static void main(String[] args){
        char i = '\u0043';//代表c
        long l = 3180530013L;
    }
}
