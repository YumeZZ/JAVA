/*
* 學號:104213052
* 姓名:鍾家蓉
*/
import java.util.Scanner;
public class ShapeHomework {
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Shape2D[] x = new Shape2D[n];
        // 輸入n個圖形，找尋相同的圖形類別並給予暱稱和需要的參數
        for (int i = 0; i < n; i++) {
            String name = input.next();
            String nickname = input.next();

            if (name.equals("Circle")) {
                x[i] = new Circle(nickname, input.nextDouble());
            } else if (name.equals("Rectangle")) {
                x[i] = new Rectangle(nickname, input.nextDouble(), input.nextDouble());
            } else if (name.equals("Triangle")) {
                x[i] = new Triangle(nickname, input.nextDouble(), input.nextDouble());
            } else if (name.equals("Square")) {
                x[i] = new Square(nickname, input.nextDouble());
            } else if (name.equals("Trapezoid")) {
                x[i] = new Trapezoid(nickname, input.nextDouble(), input.nextDouble(), input.nextDouble());
            } else if (name.equals("RegularOctagon")) {
                x[i] = new RegularOctagon(nickname, input.nextDouble());
            }
        }
        //將所有面積升冪排列，並印出，最後印出總面積
        SortShape.sort(x);

        for (int i = 0; i < n; i++) {
            System.out.println( x[i].sayName() + " " + x[i].area() );
        }
        System.out.println();
        System.out.println(SumShape.sum(x));
    }
}
