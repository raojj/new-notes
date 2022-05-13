package grammar.D_HigeLevel_Program.B2_Thread_Highlevel.Code;

import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description：
 * @Version：V1.0
 * @JDK-Version:1.8
 * @SoftWare:IntelliJ-IDEA-2022.1
 * @Author:Joe
 * @CreateTime:2022/5/122227
 */
public class demo_09 {
    @Test
    public void testSystemCurrentTimeMillis(){
        long time = System.currentTimeMillis();
        System.out.println(time);
    }

    @Test
    public void testUtilDate(){
        Date date = new Date();
        //以毫秒数创建日期
        System.out.println(new Date(189653615634l).toString());//Mon Jan 05 09:33:35 CST 1976
        //以年月日创建日期
        new Date(2022,10,31);
        //获取当前日期
        System.out.println(date.toString());//Thu May 12 22:30:51 CST 2022
        //获取当前的距离1970年的毫秒数
        System.out.println(date.getTime());//毫秒数
    }

    @Test
    public void testSqlDate(){
        java.sql.Date date = new java.sql.Date(189653615634l);
        //只打印年-月-日
        System.out.println(date);//1976-01-05
        //可以sql.Date--->util.Date
        Date date1 = (Date) date;
        System.out.println(date1.toString());
        //sql.Date<---util.Date
        java.sql.Date date2 = new java.sql.Date(new Date().getTime());
    }

    @Test
    public void testSimpleDateFormat(){
        //SimpleDateFormat类的使用：SimpleDateFormat 对日期Date类的格式化（日期---->字符串）和解析（字符串---->日期）
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd.hh:mm:ss");//按照指定的格式
        Date date = new Date();
        //输出毫秒数
        System.out.println(date.getTime());
        System.out.println(date);
        //格式化（format）
        String str = simpleDateFormat.format(date);
        System.out.println(str);
        //解析
        String str1 = "2022.21.13.06:21:51";
        try {
            Date parse = simpleDateFormat.parse(str1);
            System.out.println(parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCalender(){
        Calendar calendar = Calendar.getInstance();

        //get
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        //set
        calendar.set(Calendar.DAY_OF_MONTH,22);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        //getTime
        Date date = calendar.getTime();
        System.out.println(date);

        //setTime
        Date date1 = new Date();
        calendar.setTime(date1);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
    }
}
