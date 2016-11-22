import java.lang.*;
// import java.util.Scanner;
public class TestPen extends Thread {
    public static Pen p = new Pen();
    private int x, y;
    private double h, r;
    public TestPen(int x, int y, double h, double r) {
        this.x = x;
        this.y = y;
        this.h = h;
        this.r = r;
    }
    public void run() {
        fractalLine(x, y, h, r);
    }
    //synchronized
    public synchronized static void drawPoint(int x, int y) {
        p.flyTo(x, y);
        p.runTo(x, y);
    }
    public static void fractalLine(int x, int y, double h, double r) {
        if (h <= 1) {
            drawPoint(x, y);
            try {
                Thread.currentThread().sleep(10);
            } catch(Exception err) {
            }
            return;
        }
        fractalLine(x, y, h / 3, r);
        int nextX = x + (int)(h / 3 * Math.cos(Math.toRadians(r)));
        int nextY = y + (int)(h / 3 * Math.sin(Math.toRadians(r)));
        fractalLine(nextX, nextY, h / 3 ,r - 60);
        nextX = nextX + (int)(h / 3 * Math.cos(Math.toRadians(r - 60)));
        nextY = nextY + (int)(h / 3 * Math.sin(Math.toRadians(r - 60)));
        fractalLine(nextX, nextY, h / 3, r + 60);
        nextX = x + (int)(h / 3 * 2 * Math.cos(Math.toRadians(r)));
        nextY = y + (int)(h / 3 * 2 * Math.sin(Math.toRadians(r)));
        fractalLine(nextX, nextY, h / 3, r);
    }
    //畫正ｎ邊形
    public static void polygon(int x, int y, int h, int n) {
        //中心（x,y）半徑h
        double 等分角 = 360.0 / n;
        double 邊長 = 2 * h * Math.sin(Math.toRadians(等分角 / 2));
        double r;
        int i;
        //算出n個頂點的座標
        for (i = 0; i < n; i++) {
            int topX = (int)(x + h * Math.cos(Math.toRadians(i * 等分角 - 90)));
            int topY = (int)(y + h * Math.sin(Math.toRadians(i * 等分角 - 90)));
            Thread t = new TestPen(topX, topY, 邊長, (i + 0.5) * 等分角);
            t.start();
        }
    }
    public static void main(String[] argv) {
        polygon(300, 300, 270, 3);
    }
}
/*
        long start = System.currentTimeMillis();
        long stop = System.currentTimeMillis();
        System.out.println("used "+(stop - start)+ " ms");
        int i, n = 10012;
        for(i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                System.out.println(n+" is not a prime");
                break;
            }
            if ( i *i > n){
                System.out.println(n+" is a prime");
*/
