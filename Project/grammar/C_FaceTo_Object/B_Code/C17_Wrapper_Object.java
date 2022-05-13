package grammar.C_FaceTo_Object.B_Code;
/*
基本数据类型          包装类
byte     ---------- Byte
short    ---------- Short
int      ---------- Integer
long     ---------- Long
float    ---------- Float
double   ---------- Double
boolean  ---------- Boolean
char     ---------- Character

JDK5.0:自动装箱和自动拆箱：
自动装箱：

自动拆箱：

 */

public class C17_Wrapper_Object {
    public static void main(String[] args) {
        Integer i = new Integer(9);
        System.out.println(i.getClass().getSuperclass());
        Character c = new Character('b');
        System.out.println(c.getClass().getSuperclass());
    }
}
