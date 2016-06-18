public class 九九乘法表 {
    // public static void main(String[] argv) { // Method Name首字小寫
    //     // argv: array of references to String object
    //     int myVariable; // 變數宣告
    //     int i, sum;
    //     for (i = 1, sum = 0; i <= 100; i++) {
    //         sum += i;
    //     }
    //     System.out.println("summation from 1 to 100 is "+sum);
    // }

    public static void main(String[] argv) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.print(j + "*" + i + "=" + (i * j) + " ");
            }
            System.out.println();
        }
    }
}
