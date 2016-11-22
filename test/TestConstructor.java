// super
class Parent {
    public int y = 20;
    public Parent(int y) {
        this.y = (int)(y*1.5);
    }
    public Parent() {
    }
 }
public class TestConstructor extends Parent {
    private int x = 10;
    public TestConstructor(int v) {
        super(v/10);//呼叫父類別
        x = y * 3;
    }
    public void fun() {
        super.fun();
    }
    public static void main(String[] argv) {
        TestConstructor t = new TestConstructor(100);
        System.out.println(t.x);
    }
}
/*
set default(for all class)
call parent's constructor
parent's var declaration

*/
