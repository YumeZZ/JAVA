/*
* 學號:104213052
* 姓名:鍾家蓉
*/
import java.util.Scanner;
// 找出費式數列第n個數
public class Fibonacci {
    public static long fnum(long n) {
        if (n <= 1)
            return n;
        else
            return fnum(n - 1) + fnum(n - 2);
    }
    //算出費氏數列n個數的加總
    public static long sum(long n) {
        long answer = 0;

        for (long i = n; i > 0; i--) {
            answer += fnum(i);
        }
        return answer;
    }

    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        System.out.print("請輸入你要找的數： ");
        int n = input.nextInt();
        System.out.printf("第 %d 個數為 %d\n", n, fnum(n));
        //System.out.println("第" + n + "個數為" + fnum(n));
        System.out.println("總共的值：" + sum(n));
    }
}
