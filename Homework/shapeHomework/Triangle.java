public class Triangle extends Shape2D {
    private double base, height;
    private String name;
    //接收參數
    public Triangle(String name, double b, double h) {
        this.name = name;
        base = b;
        height = h;
    }
    //回傳名字
    public String sayName() {
        return name;
    }
    //求面積並回傳面積
    public double area() {
        return base * height / 2;
    }
}
