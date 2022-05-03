package grammar.C_FaceTo_Object;
/*
一.package关键字的使用
1.为了更好地实现项目中的类的管理，提供包的概念
2.使用package声明类或接口所属的包，声明在源文件的首行
3.包属于标识符，遵循标识符的命名规则、规范（xxxyyyzzz）、“见名知意”
4.名字中每  . 一次就代表一层目录

补充：同一个包下不能命名重名的接口或者类

java.lang--包含一些Java语言的核心类，比如String、Math、Integer、System和Thread，提供常用的功能
java.net--包含执行与网络相关的操作的类和接口
java.io--包含提供多种输入/输出功能的类
java.util--包含一些实用工具类，如定义系统特性、接口的集合框架类、使用与日期日历相关的函数
java.text--包含了一些Java格式化相关的类
java.sql--包含了Java进行JDBC数据库编程的相关的类/接口
java.awt--包含了抽象窗口工具集（abstract window toolkits）的多个类，这些类被用来构建和管理应用程序的图形用户界面（GUI） B/S  C/S

 MVC设计模式：
 MVC是常用的设计模式之一，将整个程序分为三次层次：视图模型层，控制器层与数据模型层。这种将程序输入输出、数据处理，以及数据的展示
 分离开来的设计模式使程序结构变得灵活而且清晰，同时也描述了程序各个对象间的通信方式，降低了程序的耦合性。
 模型层：model 主要处理数据
     数据对象封装 model.bean/domain
     数据库操作 model.dao
     数据库 model.db
 控制层：controller 处理业务逻辑
     应用界面相关 controller.activity
     存放fragment controller.fragment
     显示列表的适配器 controller.adapter
     服务相关的 controller.service
     抽取的基类 controller.base
 视图层：view 显示数据
     相关工具类 view.utils
     自定义view view.ui
 */
public class C9_Package_Keywords {
    public static void main(String[] args) {
        System.out.println("I love you");
    }
}
