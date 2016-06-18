/*
* 學號:104213052
* 姓名:鍾家蓉
*/
import java.lang.*;
import java.util.Scanner;
public class FractalPolygon {
    public static Pen p = new Pen();
    public static void fractalLine(int x, int y, double h, double r) {
        if (h <= 1) {
            p.flyTo(x, y);
            p.runTo(x, y);
            return;
        }
        //畫四個fractalLine，起點（x,y）
        //第一段，長度h/3,角度r
        fractalLine(x, y, h / 3, r);
        //第二段，起點＋h/3*(cos(r),sin(r))
        int nextX = x + (int)(h / 3 * Math.cos(Math.toRadians(r)));
        int nextY = y + (int)(h / 3 * Math.sin(Math.toRadians(r)));
        fractalLine(nextX, nextY, h/3.0 ,r - 60);
        //第三段，逆時針轉60度
        nextX = nextX + (int)(h / 3 * Math.cos(Math.toRadians(r - 60)));
        nextY = nextY + (int)(h / 3 * Math.sin(Math.toRadians(r - 60)));
        fractalLine(nextX, nextY, h / 3, r + 60);
        //第四段，起點＋h/3*(cos(r),sin(r))
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
            fractalLine(topX, topY, 邊長, (i + 0.5) * 等分角);
        }
    }
    public static void main(String[] argv) {
        //印出ｎ邊形碎形
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        polygon(300, 300, 270, n);
    }
}
