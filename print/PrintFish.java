/*
* File Name: PrintFish.java
* ID: 104213052
* Author: 鍾家蓉
* Since: 2015/2/28
* Toolkit: Sublime
*/
import java.util.Scanner;
public class PrintFish{
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        //魚的上半部
        for (int i = 1; i <= n; i++) {
            //印魚頭、魚身
            print(' ', 3 * (n - i));
            print('*', 3 * (2 * i - 1));
            //印魚尾
            print(' ', 3 * (n - i));
            print(' ', n - i);
            print('*', i - 1);
            System.out.println();
        }
        //魚的下半部
        for (int i = n - 1; i >= 1; i--) {
            //印魚頭、魚身
            print(' ', 3 * (n - i));
            print('*', 3 * (2 * i - 1));
            //印魚尾
            print(' ', 3 * (n - i));
            print(' ', n - i);
            print('*', i - 1);
            System.out.println();
        }
    } 
    //印出某字元的指定數量
    public static void print(char c, int len) {
        for (int i = 1; i <= len; i = i + 1) {
            System.out.print(c);
        }
    }   
}