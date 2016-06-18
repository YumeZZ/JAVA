public class Square extends Shape2D {
    private double width;
    private String name;
    //接收參數
    public Square(String name, double w) {
        this.name = name;
        width = w;
    }
    //回傳名字
    public String sayName() {
        return name;
    }
    //求面積並回傳面積
    public double area() {
        return Math.pow(width, 2.0);
    }
}
