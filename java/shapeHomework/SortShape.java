public class SortShape {
    public static void sort(Shape2D[] x) {
        Shape2D tmp;
        //將所有面積升冪排列，若面積比前一個大，把圖形類別交換
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length - i - 1; j++) {
                if (x[j].area() > x[j + 1].area()) {
                    tmp = x[j + 1];
                    x[j + 1] = x[j];
                    x[j] = tmp;
                }
            }
        }
    }
}
