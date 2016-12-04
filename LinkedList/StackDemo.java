import java.util.Scanner;
import java.util.LinkedList;
class Stack {
    int top = -1, max_size = 10;
    LinkedList<String> list = new LinkedList<String>();
    // public Stack() {
    //     list = new LinkedList<String>();
    // }
    public void push(String e) {
        if (top >= max_size - 1) {
            System.out.println("It's full, you can't push anything in~");
        } else {
            list.addFirst(e);
            top++;
        }
    }
    public void pop() {
        if(!list.isEmpty()) {
            System.out.println(" pop : "+ list.removeFirst() + " , in stack "+ top );
            top--;
        } else {
            System.out.println(" It's empty now, you pop nothing~");
        }
    }
}
public class StackDemo {
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        Stack stack = new Stack();
        System.out.println("you can input anything.\nIf you want to stop, input:quit");
        while(true) {
            System.out.print("command: ");
            String command = input.next();
            if (command.equals("quit"))
                break;
            else if(command.equals("push")) {
                System.out.print("*");
                stack.push(input.next());
            } else if(command.equals("pop")) {
                stack.pop();
            } else
                System.out.println("Sorry~error command, please try again.");
        }
    }
}
