import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Empty extends JFrame {
    public Empty() {
        this.setTitle("空空");
        this.setSize(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    // public void actionPerformed(ActionEvent e) {
    //     String token = e.getActionCommand();
    //     }
    public static void main(String[] argv) {
        new Empty();
    }
}
