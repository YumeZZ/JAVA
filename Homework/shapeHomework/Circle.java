public class Circle extends Shape2D {
    private double radius;
    private String name;
    private static final double PI = 3.141592654;
    //接收參數
    public Circle(String name, double r) {
        this.name = name;
        radius = r;
    }
    //回傳名字
    public String sayName() {
        return name;
    }
    //求面積並回傳面積
    public double area() {
        return PI * Math.pow(radius, 2.0);
    }
}
