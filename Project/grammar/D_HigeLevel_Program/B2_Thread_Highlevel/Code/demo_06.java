package grammar.D_HigeLevel_Program.B2_Thread_Highlevel.Code;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description：线程池
 * @Version：V1.0
 * @JDK-Version:1.8
 * @SoftWare:IntelliJ-IDEA-2022.1
 * @Author:Joe
 * @CreateTime:2022/5/102206
 */
public class demo_06 {
    public static void main(String[] args) {
        //提供指定线程数的线程池
        @SuppressWarnings("unused")
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
        //设置线程池属性
        System.out.println(service.getClass());
        service1.setCorePoolSize(15);
        //execute方法只能用Runnable
        service.execute(new NumberThread());
        //适合使用Callable
        service.submit(new NumberThread1());
        //关闭线程池
        service.shutdown();
    }
}

class NumberThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i%2 == 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

class NumberThread1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i%2 != 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}