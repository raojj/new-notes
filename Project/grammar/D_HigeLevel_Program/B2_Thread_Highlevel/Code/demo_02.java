package grammar.D_HigeLevel_Program.B2_Thread_Highlevel.Code;

/**
 * @Description：线程同步--安全问题
 * @Version：V1.0
 * @JDK-Version:1.8
 * @SoftWare:IntelliJ-IDEA-2022.1
 * @Author:Joe
 * @CreateTime:2022/5/9/1800
 */
public class demo_02 {
    public static void main(String[] args) {
        Window1 w = new Window1();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        //t3.start();
    }
}


class Window1 implements Runnable{
    private int ticket = 100;
    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                //交替：唤醒
                notify();
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
                    ticket--;
                    //交替：等待
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}


class Window2 implements Runnable{
    private static int ticket = 100;
    @Override
    public void run() {
        while (ticket>0){
            show();
        }
    }
    private static synchronized void show(){
        if (ticket > 0){
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
            ticket--;
        }
    }
}