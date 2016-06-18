/**
* Homework2.java
* Author: Zhung Jai Rong
*/
import java.util.Scanner;
public class Diamond {
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(int i = 1; i <= n; i = i + 1) {
            print(' ', n - i);
            print('\u00D5', 2 * i - 1);
            System.out.println();
        }
        for(int i = n - 1; i >= 1; i = i - 1) {
            print(' ', n - i);
            print('*', 2 * i - 1);
            System.out.println();
        }
    }
    public static void print(char c, int len) {
        for (int i = 1; i <= len; i++)
            System.out.print(c);
    }
}