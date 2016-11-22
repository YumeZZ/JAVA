import java.lang.*;
public class TestPen {
    public static Pen p = new Pen();
    public static void fractalLine(int x, int y, double h, double r) {
        if (h <= 1) {
            p.flyTo(x, y);
            p.runTo(x, y);
            return;
        }
        //畫出四個小fractalLine
        //第一段，起點（x,y），長度h/3,角度r
        fractalLine(x, y, h/3.0, r);
        //第二段，起點（x,y）＋h/3*(cos(r),sin(r)),長度h/3，角度r+60
        int nextX = x + (int)(h/3.0 * Math.cos(Math.toRadians(r)));
        int nextY = y + (int)(h/3.0 * Math.sin(Math.toRadians(r)));
        fractalLine(nextX, nextY, h/3.0 ,r - 60);
        //第三段，起點....長度h/3，角度r-60
        nextX = nextX + (int)(h/3 * Math.cos(Math.toRadians(r - 60)));
        nextY = nextY + (int)(h/3 * Math.sin(Math.toRadians(r - 60)));
        fractalLine(nextX, nextY, h/3, r + 60);
        //第四段，起點....長度h/3，角度r
        nextX = x + (int)(h/3 * 2 * Math.cos(Math.toRadians(r)));
        nextY = y + (int)(h/3 * 2 * Math.sin(Math.toRadians(r)));
        fractalLine(nextX, nextY, h/3, r);
    }
    public static void polygon(int x, int y, int h, int n) {
        //中心（x,y）半徑為h的正n邊形
        double 等分角 = 360.0/n;
        // double 內角 = 180.0 - 等分角;
        double 邊長 = 2 * h * Math.sin(Math.toRadians(等分角/2));
        double r;
        int i;
        //算出n個頂點的座標
        for (i = 0; i < n; i++) {
            int topX = (int)(x + h * Math.cos(Math.toRadians(i * 等分角-90)));
            int topY = (int)(y + h * Math.sin(Math.toRadians(i * 等分角-90)));
            fractalLine(topX, topY, 邊長, (i+0.5)*等分角);
        }
    }
    public static void main(String[] argv) {
        polygon(300, 300, 270, 3);

    }
}


// 碎行三角形
// import java.lang.*;
// public class TestPen {
//     public static Pen p = new Pen();
//     public static void fractalTriangle(int x, int y, int h) {
//         if (h <= 1) {
//             p.flyTo(x, y);
//             p.runTo(x, y);
//             return;
//         }
//         fractalTriangle(x, y, h / 2);
//         fractalTriangle((int)(x + h / Math.sqrt(3) / 2 + 0.5), y + h / 2, h/2);
//         fractalTriangle((int)(x - h / Math.sqrt(3) / 2 + 0.5), y + h / 2, h/2);
//     }
//     public static void main(String[] argv) {
//         fractalTriangle(400, 50, 512);
//     }
// }

//碎行正方形
// import java.lang.*;
// public class TestPen {
//     public static Pen p = new Pen();
//     public static void fractalsquare(int x, int y, int h) {
//         if (h <= 3) {
//             p.flyTo(x, y);
//             p.runTo(x, y);
//             try {
//                 Thread.currentThread().sleep(500);
//             } catch(Exception err){
//             }
//             return;
//         }
//         fractalsquare(x, y, h / 3);
//         fractalsquare(x + h / 3, y, h/3);
//         fractalsquare(x + h / 3 * 2, y, h / 3);
//         fractalsquare(x, y + h / 3, h / 3);

//         fractalsquare(x + h/3*2, y + h / 3, h / 3);
//         fractalsquare(x, y + h/3*2, h / 3);
//         fractalsquare(x + h/3, y + 2 * h / 3, h / 3);
//         fractalsquare(x + 2*h/3, y + h/3*2, h / 3);
//     }
//     public static void main(String[] argv) {
//         fractalsquare(50, 50, 729);
//     }
// }



// 三角行
//     public class TestPen {
//     public static Pen p = new Pen();
//     public static void triangle(int x,int y, int h) {
//         p.flyTo(x, y);
//         p.runTo((int)(x + h / Math.sqrt(3) + 0.5), y + h);
//         p.runTo((int)(x - h / Math.sqrt(3) + 0.5), y + h);
//         p.runTo(x, y);
//     }
//     public static void main(String[] argv) {
//         triangle(300, 50, 128);
//     }
// }





// 正方形
// public class TestPen {
//     public static void main(String[] argv) {
//         Pen p = new Pen();
//         p.flyTo(50, 50);
//         p.runTo(50, 100);
//         p.runTo(150, 150);
//         p.runTo(50, 150);
//         p.runTo(50, 50);
//     }
// }
