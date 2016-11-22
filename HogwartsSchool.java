import java.util.Scanner;
import java.util.Random;
public class HogwartsSchool{
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int[] girls = new int[10];

        for (int i = 0; i < girls.length; i++) {

            //System.out.println("Welcome to Hogwarts School\n");
            //System.out.println("What's your name?\n");
            //String name = input.next();
            System.out.println("Ummmmmm Let me think....\n");
            girls[i] = random.nextInt(10) + 1;
            for(int j = 0; j <= i; j++){

                if(i > 0 && girls[j] == girls[i]){

                    // girls[i] = random.nextInt(10) + 1;

                    i--;
                    break;
                } else
                    System.out.println(name + " you are classified into " + girls[i]);
                    break;

            }
        }
    }
    //         Gryffindor
    //         Hufflepuff
    //         Ravenclaw
    //         Slytherin
}
