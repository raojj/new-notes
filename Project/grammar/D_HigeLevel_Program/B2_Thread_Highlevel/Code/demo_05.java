package grammar.D_HigeLevel_Program.B2_Thread_Highlevel.Code;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description：
 * @Version：V1.0
 * @JDK-Version:1.8
 * @SoftWare:IntelliJ-IDEA-2022.1
 * @Author:Joe
 * @CreateTime:2022/5/101615
 */
public class demo_05 {
    public static void main(String[] args) {
        //创建callable实现类的对象
        tiWindow tiWindow = new tiWindow();
        //将callable实现类的对象作为参数传入到FutureTask类的构造器中
        FutureTask futureTask = new FutureTask(tiWindow);
        //将FutureTask类作为参数传入到Thread类的构造器中
        new Thread(futureTask).start();

        try {
            //get方法的返回值即为FutureTask构造器参数Callable实现类重写的call方法的返回值
            Object sum = futureTask.get();
            System.out.println("总和为："+ sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}

class tiWindow implements Callable{
    //将此线程需要执行的操作声明在call()方法中，call()方法是可以有返回值的
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            if (i%2==0){
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(i);
                sum+=i;
            }
        }
        //自动装箱成Integer
        return sum;
    }
}