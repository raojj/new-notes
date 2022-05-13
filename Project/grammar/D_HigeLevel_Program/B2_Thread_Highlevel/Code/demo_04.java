package grammar.D_HigeLevel_Program.B2_Thread_Highlevel.Code;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description：两个线程交替打印1-100
 * @Version：V1.0
 * @JDK-Version:1.8
 * @SoftWare:IntelliJ-IDEA-2022.1
 * @Author:Joe
 * @CreateTime:2022/5/101515
 */
public class demo_04 {
    public static void main(String[] args) {
        print print = new print();

        Thread t1 = new Thread(print);
        Thread t2 = new Thread(print);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}

class print implements Runnable{
    private static int printNums = 1;
    private ReentrantLock lock = new ReentrantLock(true);
    @Override
    public void run() {
        while (true){
            try {
                lock.lock();
                if (printNums<=100){
                    try {
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+":"+printNums);
                    printNums++;
                }else {
                    break;
                }
            }finally {
                lock.unlock();
            }
        }
    }
}