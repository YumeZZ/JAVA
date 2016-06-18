public class Rectangle extends Shape2D {
    private double width, height;
    private String name;
    //接收參數
    public Rectangle(String name, double w, double h) {
        this.name = name;
        width = w;
        height = h;
    }
    //回傳名字
    public String sayName() {
        return name;
    }
    //求面積並回傳面積
    public double area() {
        return width * height;
    }
}
