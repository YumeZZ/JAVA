/*
* 104213054
* 劉宇軒
*/

import java.util.*;
import java.lang.*;

public class Blender {

    private static String stuff;

    public static void main(String[] args) {

        System.out.print("請輸入指令 : ");

        Scanner in = new Scanner(System.in);

        stuff = "";

        Blender c = new Blender();

        while(true) {

            String command = in.nextLine();

            if (command.equals("insert")) {
                if (c.isEmpty(stuff)){
                    System.out.print("請放置物品 : ");
                    c.mount(stuff);
                    System.out.println("已放入果汁機 <3");
                    System.out.println();
                    System.out.print("請輸入指令 : ");
                }
                else if (c.isEmpty(stuff) == false) {
                    System.out.println("果汁機已有物品");
                    System.out.println();
                    System.out.print("請輸入指令 : ");
                }
            }

            if (command.equals("mix")) {
                System.out.print("請輸入強度 : ");
                int n = in.nextInt();
                c.blend(n);
                c.watch();
                System.out.println();
                System.out.print("請輸入指令 : ");
            }

            if (command.equals("drop")) {
                if (c.isEmpty(stuff) == false) {
                    c.unmount();
                    System.out.println();
                    System.out.print("請輸入指令 : ");
                }
                else if (c.isEmpty(stuff) == true) {
                    System.out.println("倒出來的東西 : null");
                    System.out.println();
                    System.out.print("請輸入指令 : ");
                }
            }
        }
    }

    //輸入字串
    public void mount(String something) {
        Scanner in = new Scanner(System.in);
        this.stuff = in.nextLine();
    }

    //清空字串
    public String unmount() {
        System.out.println("倒出來的東西");
        System.out.println(this.stuff);
        this.stuff = "";
        return this.stuff;
    }

    //打亂字串
    public void blend(int strength) {

        //用迴圈隨機N次
        for ( ; strength > 0; strength--) {
            char[] a = this.stuff.toCharArray();
            List<Character> l = new LinkedList<Character>();
            for(int i=0; i<a.length; i++){
                l.add(a[i]);
            }
            Collections.shuffle(l);
            this.stuff = l.toString().replaceAll("[\\[\\], ]","");
        }
    }

    //判斷字串是否為空
    public boolean isEmpty(String something) {
        boolean b = false;
        if (something.equals("")) {
            b = true;
        }
        return b;
    }

    //顯示打亂後的字串
    public String watch() {
        System.out.println(this.stuff);
        return this.stuff;
    }
}
