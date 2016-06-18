public class Trapezoid extends Shape2D {
    private double up, down, height;
    private String name;
    //接收參數
    public Trapezoid(String name, double u, double d, double h) {
        this.name = name;
        up = u;
        down = d;
        height = h;
    }
    //回傳名字
    public String sayName() {
        return name;
    }
    //求面積並回傳面積
    public double area() {
        return (up + down) * height / 2;
    }
}
