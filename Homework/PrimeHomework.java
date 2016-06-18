/*
* 學號:104213052
* 姓名:鍾家蓉
*/
import java.util.Scanner;
public class PrimeHomework {
    // 測試法
    public static boolean isPrime(int n) {
        // 找出範圍內的質數
        for ( int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
    // 是質數的話，count++
    public static long primes(int n) {
        long count = 0;
        for (int i = 2; i <= n; i++) {
            if(isPrime(i))
                count++;
        }
        return count;
    }
    // public static long primes(int n) {
    //     boolean[] test = new boolean[n + 1];
    //     long count = 0;
    //     for (int i = 2; i <= n; i++) {
    //         for (int j = 2; j < i; j++) {
    //             if (i % j == 0) {
    //                 test[i] = true;
    //             }
    //         }
    //         if (!test[i])
    //             count++;
    //     }
    //     return count;
    // }

    // 刪除法
    public static long primes2(int n) {
        boolean[] delete = new boolean[n + 1];
        long count = 0;
        // 找出範圍內的質數，是質數的話，count++
        for (int i = 2; i <= n; i++) {
            for (int j = 2 * i; j <= n; j+=i) {
                delete[j] = true;
            }
            if (!delete[i])
                count++;
        }
        return count;
    }

    // public static int p2(int n) {
    //     boolean[] delete = new boolean[n+1];
    //     int count = 0;
    //     for(int i = 2; i * i <= n; i++){
    //         if(!delete[i]) {
    //             count++;
    //             for(int j = 2 * i; j <= n; j += i) {
    //                 delete[j] = true;
    //             }
    //         }
    //     }
    //     return count;
    // }

    // public static long p2(long n) {
    //     long maxLen = 2000000000L;
    //     int index = 0;
    //     boolean[][] deleted = new boolean[(int)((n - 1)/2/maxLen+1)][];
    //     for (; (index+1) * 2 * maxLen <= n - 1; index++) {
    //         deleted[(int)index] = new boolean[(int)maxLen];
    //     }
    //     if (n- index*2*maxLen>0)
    //         deleted[index] = new boolean[(int)(n-index*2*maxLen)];
    //     long counter = 1;
    //     for (long i = 3; i <= n; i+=2) {
    //         if (!deleted[(int)(i/2/maxLen)][(int)(i/2%maxLen)]) {
    //             counter++;
    //             for (long j = 3 * i; j <= n; j += 2 * i) {
    //                 deleted[(int)(j/2/maxLen)][(int)(j/2%maxLen)] = true;
    //             }
    //         }
    //     }
    //     return counter;
    // }

    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        // 計算測試法用的時間
        long start = System.currentTimeMillis();
        primes(n);
        long end = System.currentTimeMillis();
        // 計算刪除法用的時間
        long start1 = System.currentTimeMillis();
        primes2(n);
        long end1 = System.currentTimeMillis();
        System.out.print("測試法 "+ primes(n) + "個");
        System.out.println(" " + (end - start) + " ms ");
        System.out.print("刪除法 "+ primes2(n) + "個");
        System.out.println(" " + (end1 - start1) + " ms ");
    }
}
