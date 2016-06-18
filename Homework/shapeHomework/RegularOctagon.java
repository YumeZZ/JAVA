public class RegularOctagon extends Shape2D {
    private double length;
    private String name;
    //接收參數
    public RegularOctagon(String name, double l) {
        this.name = name;
        length = l;
    }
    //回傳名字
    public String sayName() {
        return name;
    }
    //求面積並回傳面積
    public double area() {
        return (2 + 2 * Math.sqrt(2)) * length * length;
    }
}
