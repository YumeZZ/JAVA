import java.util.*;
public class TestThread extends Thread implements Runnable {
    private String name;
    public TestThread(String name) {
        this.name = name;
    }
    public void run() {
        for (;;) {
            System.out.println("Hello "+name);
        }
    }
    public static void main(String[] argv) {

        Thread t1 = new TestThread("老俞");
        Thread t2 = new Thread(new TestThread("悅悅"));
        // t1.setPriority(Thread.NORM_PRIORITY);
        // t2.setPriority(Thread.NORM_PRIORITY);
        // Thread.currentThread.setPriority(Thread.NORM_PRIORITY);
        t1.start();
        t2.start();
        // for (;;) {
        //     System.out.println("我是main裡的Thread ");
        // }
    }
}

/*int long double char referance bollean float*/
