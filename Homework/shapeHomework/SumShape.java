public class SumShape {
    //求面積總和
    public static double sum(Shape2D[] list) {
        double total = 0;
        for (int i = 0; i < list.length; i++) {
            total = total + list[i].area();
        }
        return total;
    }
}
