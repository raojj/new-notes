package grammar.D_HigeLevel_Program.B2_Thread_Highlevel.Code;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description：lock锁
 * @Version：V1.0
 * @JDK-Version:1.8
 * @SoftWare:IntelliJ-IDEA-2022.1
 * @Author:Joe
 * @CreateTime:2022/5/101450
 */
public class demo_03 {
    public static void main(String[] args) {
        ticketWindow ticketWindow = new ticketWindow();
        Thread t1 = new Thread(ticketWindow);
        Thread t2 = new Thread(ticketWindow);
        Thread t3 = new Thread(ticketWindow);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}


class ticketWindow implements Runnable{
    private static int ticket = 100;
    //实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock(true);
    @Override
    public void run() {
        while (true){
            try {

                lock.lock();
                if (ticket>0){

                    try {
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
                    ticket--;
                }else {
                    break;
                }
            }finally {
                lock.unlock();
            }

        }
    }
}