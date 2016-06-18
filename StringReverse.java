// 劉宇軒
import java.util.Scanner;
public class StringReverse {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int groupLen = 0;
        while (true) {

            String str = input.next();
            int n = input.nextInt();

            if (n == 0) {
                break;
            }
            if (str.length() % n == 0) {
                for (int i = 0; i < str.length(); i += n) {
                    for( int j = i + n - 1 ; j >= i ; j-- ) {
                        System.out.print(str.charAt(j));
                    }
                }
                System.out.println();
                break;
            }
            else if (str.length() % n != 0){
                for (int i = 0; i < (str.length() - str.length() % n); i += n) {
                    for( int j = i + n - 1; j >= i ; j-- ) {
                        System.out.print(str.charAt(j));
                    }
                }
                for (int i = str.length() - (str.length() % n), j = str.length() - 1; i <= j; j--) {
                    System.out.print(str.charAt(j));
                }
                System.out.println();
                break;
            }
        }
    }
}
