//矩陣相乘
import java.util.Scanner;
// class Array {
//     privat
//     public class Array(int m, int n) {

//     }
// }
public class 矩陣 {
    public static void mul(int[][] arrayA, int[][] arrayB, int[][] arrayC, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                for (int k = 0; k < n; k++) {
                    sum = sum + arrayA[i][k] * arrayB[k][j];
                }
                arrayC[i][j] = sum;
            }
        }
        System.out.println("Multiplication:");
        printarray(arrayC, n);
    }
    public static void add(int[][] arrayA, int[][] arrayB, int[][] arrayC, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arrayC[i][j] = arrayA[i][j] + arrayB[i][j];
            }
        }
        System.out.println("Addition:");
        printarray(arrayC, n);
    }
    public static void printarray(int[][] array, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j] + " ");
                if ((j + 1) % n == 0) {
                    System.out.println();
                }
            }
        }
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        System.out.print("input the size of array:");
        int n = input.nextInt();
        int[][] arrayA = new int[n][n];
        int[][] arrayB = new int[n][n];
        int[][] arrayC = new int[n][n];
        System.out.print("input array A:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arrayA[i][j] = input.nextInt();
            }
        }
        System.out.print("input array B:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arrayB[i][j] = input.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arrayC[i][j] = 0;
            }
        }
        add(arrayA, arrayB, arrayC, n);
        mul(arrayA, arrayB, arrayC, n);
    }
}
