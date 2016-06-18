import java.util.Scanner;
public class StringReverse {
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        String name = input.next();
        //將字串n個分成一群
        int n = input.nextInt();
        char[] data = new char[name.length()];
        //將字串輸入陣列
        for(int i = 0 ; i < name.length() ; i++) {
            data[i] = name.charAt(i);
        }
        //開始反轉
        reverse(data, n);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]);
        }
        System.out.println();
    }
    public static void reverse(char[] data, int n) {
        char tmp;
        //由每一群的首尾向內倆倆互換
        for (int i = 0; i < data.length; i++) {
            if ((i + 1) % n == 0) {
                int k = i;
                for (int j = k - n + 1; k > j; j++) {
                    tmp = data[k];
                    data[k] = data[j];
                    data[j] = tmp;
                    k--;
                }
            }
        }
        //無法分群的自成一群並反轉
        if (data.length % n != 0) {
            for (int i = data.length - (data.length % n), j = data.length - 1; i < j; i++, j--) {
                tmp = data[i];
                data[i] = data[j];
                data[j] = tmp;
            }
        }
    }
}
