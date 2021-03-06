import java.util.Scanner;
import java.lang.Math;

public class Blender {
    private String stuff;
    // 裝東西進去
    public void mount(String something) {
        this.stuff = something;
    }
    // 把東西倒出來，並清空
    public String unmount() {
        String tmp = this.stuff;
        this.stuff = null;
        return tmp;
    }
    // 攪拌，隨機選兩個交換
    public void blend(int strength) {
        char[] magic = this.stuff.toCharArray();
        char tmp;
        for (int i = strength; i > 0; i--) {
            int m1 = (int)(Math.random()* magic.length);
            int m2 = (int)(Math.random()* magic.length);
            tmp = magic[m1];
            magic[m1] = magic[m2];
            magic[m2] = tmp;
        }
        this.stuff = String.valueOf(magic);
    }
    // 確認是不是空的
    public boolean isEmpty() {
        boolean empty = false;
        if (this.stuff == null) {
            empty = true;
        }
        return empty;
    }
    // 偷偷看一下～
    public String watch() {
        return this.stuff;
    }

    public static void main(String[] argv) {
        Blender boom = new Blender();
        for (;;) {
            System.out.print("請輸入指令：");
            Scanner input = new Scanner(System.in);
            String command = input.next();
            // 指令是insert時，確認裡面是空的才能放入東西
            if (command.equals("insert")) {
                if (boom.isEmpty() == true) {
                    System.out.print("請放置物品：");
                    String something = input.next();
                    boom.mount(something);
                    System.out.println("已放入果汁機 <3 ");
                    System.out.println();
                } else {
                    System.out.println("果汁機已有物品!!");
                }
            // 指令是mix時，判斷是否有物品，否則不能攪拌，輸入攪拌強度。
            // 攪拌後要偷看一下攪拌的結果。
            } else if (command.equals("mix")) {
                if (boom.isEmpty() != true) {
                    System.out.print("請輸入強度：");
                    int n = input.nextInt();
                        boom.blend(n);
                        System.out.println("已打亂：" +boom.watch());
                        System.out.println();
                } else {
                    System.out.println("nothing to blend.");
                    System.out.println();
                }
            // 指令是drop時，倒出東西
            } else if (command.equals("drop")) {
                System.out.println("倒出來的東西：" + boom.unmount());
                System.out.println();
            }
        }
    }
}
