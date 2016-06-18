/*
* 學號:104213052
* 姓名:鍾家蓉
*/
import java.util.Scanner;
class Car {
    private String name;
    private int pointX = 0;
    private int pointY = 0;
    //設定車子名字
    public Car(String anyname) {
        this.name = anyname;
    }
    //取得點Ｘ及點Ｙ位置
    public int[] getPoints() {
        int[] answer = new int[2];
        answer[0] = pointX;
        answer[1] = pointY;
        return answer;
    }
    //設定點Ｘ及點Ｙ位置
    public void setPoints(int x, int y) {
        if (y > this.pointY) {
            System.out.println("向下走 走" + (y - this.pointY) + "步");
        } else if (y < this.pointY) {
            System.out.println("向上走 走" + (this.pointY - y) + "步");
        }
        if (x > this.pointX) {
            System.out.println("向右走 走" + (x - this.pointX) + "步");
        } else if (x < this.pointX){
            System.out.println("向左走 走" + (this.pointX - x) + "步");
        }
    }
     //回傳車子名子
    public String getName() {
        return this.name;
    }
     //車子移動到 X , Y
    public void go(int x, int y) {
        this.pointX = x;
        this.pointY = y;
    }
}
public class Play {
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);

        System.out.print("請輸入車名：");

        String anyname = input.next();
        Car bubu = new Car(anyname);

        for (;;) {
            System.out.print("請輸入指令：");
            String command = input.next();
            if (command.equals("go")) {
                int x = input.nextInt();
                int y = input.nextInt();

                if (x >= 0 && x<=10 && y >= 0 && y<=10) {
                    bubu.setPoints(x, y);
                    bubu.go(x, y);
                }  else
                    System.out.println("超出棋盤範圍");
            }
            else if (command.equals("list")) {
                int[] Answer = new int[2];
                Answer = bubu.getPoints();
                System.out.println(bubu.getName() + " 在 " + "(" + Answer[0] + "," + Answer[1]+ ")");
            }
            else if (command.equals("end")) {
                System.out.println("離開.....%");
                break;
            } else
                System.out.println("指令無效，重新數入");
        }
    }
}
