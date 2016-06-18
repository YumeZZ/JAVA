import java.util.Scanner;
public class Hello {
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        System.out.println("Hello World\n");
        System.out.println("power(3,5) = "+power(3,5));
    }
    public static int power(int x, int n) {
        int result = 1;
        for (int i = 1; i <= n; i++)
            result = result * x;
        return result;
    }
}