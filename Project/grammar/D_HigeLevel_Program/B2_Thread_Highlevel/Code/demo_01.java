package grammar.D_HigeLevel_Program.B2_Thread_Highlevel.Code;

/**
 * @Description  创建线程
 * @Author:Rao Jian
 * @CreateTime:2022/5/91207
 */
public class demo_01 {
    public static void main(String[] args) {
        minPrime minPrime = new minPrime();
        minPrime.start();
        for (int i = 0; i < 100; i++) {
            if (i%2 == 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
        runnableTest test = new runnableTest();
        Thread t = new Thread(test);
        t.setName("runnableTest");
        t.start();
    }
}

//继承Thread类
class minPrime extends Thread{

    //重写run()，将此线程执行的操作声明在run方法中
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2 == 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

class runnableTest implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2 == 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}