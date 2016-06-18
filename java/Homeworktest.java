import java.util.Scanner;
public class Homeworktest {
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        String time = input.next();
        String[] tokens = time.split("-");

        //for (;;) {
            // System.out.print(token+" ");
            //System.out.print(" diff ");
            //System.out.println(Integer.parseInt(token));
        //}
            String[] compare = new String[2];
        for (int i = 0 ; i < tokens.length ; i++) {
            compare[0] += tokens[i];
            compare[1] = "20161231";


        }
        System.out.println(Integer.parseInt(compare[0]));

    }
}
