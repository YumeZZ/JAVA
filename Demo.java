import java.util.Random;

public class Demo {
    public static void main(String[] args) {
        int[] values = new int[20];
        Random random = new Random();
        // random different numbers in array
        for(int i = 0; i < values.length; i++){
            int number = random.nextInt(20) + 1;
            values[i] = number;
            for(int j = i - 1; j >= 0; j--) {
                if(values[i] == values[j]) {
                    i--;
                    break;
                }
            }
        }
        // print result
        for(int i = 0;i < values.length; i++){
            System.out.print(values[i] + "\t");
            if(( i + 1 ) % 10 == 0){
                System.out.println("\n");
            }
        }
    }
}
