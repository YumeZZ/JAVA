/**
* Homework1.java
* Author: Chung
*         The first sample in course of
*/
import java.util.Scanner;
public class HomeworkHello {
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String a = "eee";
        for(int i = 1; i <= n; i = i + 1) {
            print('*', i);
            System.out.println("d"+a);
        }
    }
    public static void print(char c, int len) {
        for (int i = 1; i <= len; i++)
            System.out.print(c);
        //System.out.print(""+c);
        //System.out.printf("%c", c);

    }
}