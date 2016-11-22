class Parent {
    private int y = 10;
    public Parent(int y) {
        this.y = y;
    }
    public Parent() {

    }
 }
public class TestConstructor extends Parent {
    private int x = 10;
    public TestConstructor(int v) {
        // super();//呼叫父類別
        x = v;
    }
    public static void main(String[] argv) {
        TestConstructor t = new TestConstructor(100);
        System.out.println(t.x);
    }
}
/*
set default(for all class)
call parent's constructor


*/
