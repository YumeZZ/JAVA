/*
* 學號:104213052
* 姓名:鍾家蓉
*/
import java.util.Scanner;
public class Homework {
    private String name, time;
    private boolean state;

    public Homework(String name, String time) {
        this.name = name;
        this.time = time;
        state = false;
    }

    public void submit() {
        state = true;
    }

    public boolean compareDate(String deadline) {
    // 這邊使用 String.split 去將該 String 分割成一個陣列，並用 Integer.parseInt 將字串轉型態為整數去做大小比較
        String[] tokens = deadline.split("-");
        String[] tokens2 = time.split("-");
        String compare = "";
        String compare2 = "";
        for (int i = 0 ; i < tokens.length ; i++) {
            compare += tokens[i];
            compare2 += tokens2[i];
        }

        return (Integer.parseInt(compare) > Integer.parseInt(compare2));
    }

    public static void main(String[] argv) {
        Homework[] GG = new Homework[100];
        //Homework h = new Homework();
        Scanner input = new Scanner(System.in);
        System.out.println("請輸入功課總繳交時間：");
        String deadline = input.next();
        int count = 0;
        for (;;) {

            String command = input.next();
            if (command.equals("new")) {

                GG[count++] = new Homework(input.next(), input.next());

            } else if (command.equals("submit")) {
                String compareString = input.next();
                for (int i = 0; i < count; i++) {
                    if (compareString.equals(GG[i].name))
                        GG[i].submit();
                }

            } else if (command.equals("end")) {
                for (int i = 0; i < count; i++) {
                    if (GG[i].state == true) {
                        System.out.println(GG[i].name + " 已經繳交");
                    } else {
                        if (GG[i].compareDate(deadline) == true) {
                            System.out.println(GG[i].name + " 記得交作業喔！");
                        } else
                            System.out.println(GG[i].name + " 遲交囉");
                    }
                }
            }
        }
    }
}
