package grammar.D_HigeLevel_Program.B2_Thread_Highlevel.Code;

import org.testng.annotations.Test;

/**
 * @Description：枚举类、注解
 * @Version：V1.0
 * @JDK-Version:1.8
 * @SoftWare:IntelliJ-IDEA-2022.1
 * @Author:Joe
 * @CreateTime:2022/5/142058
 */
public class demo_11 {
    @Test
    public void testEnumeration(){
        System.out.println(season.AUTUMN.toString());
    }

    @Test
    public void testEnum(){
        System.out.println(season1.AUTUMN.toString());

        //values()
        season1 [] season1s = season1.values();
        for (int i = 0; i < season1s.length; i++) {
            System.out.println(season1s[i].toString());
        }

        //valueOf()
        try {
            season1 winter = season1.valueOf("WINTER");
            System.out.println(winter.toString());
            System.out.println(winter.getSeasonDesc());
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }
}

class season{
    //1. 声明season对象的属性：private final修饰
    private final String seasonName;
    private final String seasonDesc;

    //私有化类的构造器
    private season(String seasonName,String seasonDesc){
        this.seasonName =seasonName;
        this.seasonDesc =seasonDesc;
    }

    //提供当前枚举类的多个对象
    public static final season SPRING = new season("春天","春暖花开");
    public static final season SUMMER = new season("夏天","夏日炎炎");
    public static final season AUTUMN = new season("秋天","秋高气爽");
    public static final season WINTER = new season("冬天","冰天雪地");

    //其他述求：获取枚举类对象的属性

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "季节："+this.seasonName+", 描述："+this.seasonDesc;
    }
}


interface INFO{
    void show();
}
enum season1 implements INFO{
    // 提供当前枚举类的对象，多个对象之间用, 隔开
    SPRING ("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("春天的");
        }
    },
    SUMMER ("夏天","夏日炎炎"){
        @Override
        public void show() {
            super.show();
        }
    },
    AUTUMN ("秋天","秋高气爽"){
        @Override
        public void show() {
            super.show();
        }
    },
    WINTER ("冬天","冰天雪地"){
        @Override
        public void show() {
            super.show();
        }
    };

    // 声明season对象的属性：private final修饰
    private final String seasonName;
    private final String seasonDesc;

    //私有化类的构造器
    private season1(String seasonName,String seasonDesc){
        this.seasonName =seasonName;
        this.seasonDesc =seasonDesc;
    }

    //其他述求：获取枚举类对象的属性

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "季节："+this.seasonName+", 描述："+this.seasonDesc;
    }

    @Override
    public void show() {

    }
}