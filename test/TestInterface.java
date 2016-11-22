interface ShapeInterface {
    public static final double PI = 3.1415926536;
    public abstract double area();
}
interface subShape extends ShapeInterface {
}
interface Strange {
    int var1 = 10;
    void fun();
}
interface Multi extends subShape, Strange {
    double PI = 3.0;
    void fun();
}
interface Second {
}
public class TestInterface implements Multi, Second {
    public void fun() {
        System.out.println("TestInterface use print to implement to");
    }
    public double area() {
        return PI;//ShapeInterface.PI.
    }
    public static void main(String[] argv) {
        TestInterface t = new TestInterface();
        System.out.println(t.area());
    }
}
