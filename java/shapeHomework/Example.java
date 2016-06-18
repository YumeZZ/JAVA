public class Example {
    public static void main(String[] argv) {
        char[] data = {'1', '2', '3', '4'};
        reverse(data);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]+" ");
        }
    }
    public static void reverse(char[] data) {
        char tmp;
        for (int i = 0, j = data.length - 1; i < j; i++, j--) {
            tmp = data[i];
            data[i] = data[j];
            data[j] = tmp;
        }
    }
}
