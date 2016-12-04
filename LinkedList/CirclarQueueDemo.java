import java.util.Scanner;
import java.util.LinkedList;
class Queue {
    LinkedList<String> list = new LinkedList<String>();
    int max_size = 5, rear = 0, front = 0, size = 0;
    public void add(String e) {
        if (size != max_size) {
            if (rear / max_size >= 1 && list.contains(" ")) {
                list.remove(rear % max_size);
            }
            list.add(rear % max_size, e);
            rear++;
            size++;
        } else {
            System.out.println("Sorry~It's full.Please remove something.");
        }
    }
    public void removeQ() {
        if (size != 0) {
            list.remove(front);
            list.add(front++, " ");
            front %= max_size;
            size--;
        } else {
            System.out.println(" It's empty now, you remove nothing~");
        }
    }
    public void printQueue() {
        System.out.println(list + "");
    }
}
public class CirclarQueueDemo {
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        Queue q = new Queue();
        System.out.println("you can input anything.\nIf you want to stop, input:quit");
        while(true) {
            System.out.print("command: ");
            String command = input.next();
            if (command.equals("quit"))
                break;
            else if(command.equals("add")) {
                System.out.print("*");
                q.add(input.next());
                q.printQueue();
            } else if(command.equals("remove")) {
                q.removeQ();
                q.printQueue();
            } else
                System.out.println("Sorry~error command, please try again.");
        }
    }
}
