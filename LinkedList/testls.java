import java.util.LinkedList;
public class testls {
    public static void main(String[] argv) {
        LinkedList<String> list = new LinkedList<String>();
        String[] array = {"This", "is", "an", "apple", " "};
        for (int i = 0; i < array.length; i++) {
            list.addLast(array[i]);
        }
        list.add(2, "hi");
        System.out.println(list);
        list.removeFirst();
        System.out.println("peek:"+list.peek());
        // while(!list.isEmpty()){
        //     System.out.println(list);
        // }
        if (list.contains(" ")) {
            list.removeFirst();
            System.out.println(list);
        }
    }
}
