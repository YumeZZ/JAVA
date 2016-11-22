/*
* 學號:104213052
* 姓名:鍾家蓉
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class GomokuHomework extends JFrame implements ActionListener {
    private Chess chessBoard;
    private GomokuHomework() {
        super("五子棋");
        Menu m;
        MenuBar mb;
        chessBoard = new Chess();
        this.add(chessBoard);
        this.setMenuBar(mb = new MenuBar());
        mb.add(m = new Menu("遊戲")).add(new MenuItem("新遊戲")).addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.pack();
        this.setVisible(true);
    }
    // 按新遊戲時，產生新遊戲
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("新遊戲")) {
            chessBoard.newGame();
        }
    }
    public static void main(String argv[]) {
        new GomokuHomework();
    }
}
class Chess extends Component implements MouseListener {
    //黑白棋、空值
    public static final byte EMPTY = 0;
    public static final byte BLACK = 1;
    public static final byte WHITE = 2;
    private byte[] board = new byte[441];
    private byte playing = BLACK;
    //設定視窗大小
    private Dimension mySize = new Dimension(525, 525);

    public Chess() {
        this.addMouseListener(this);
        newGame();
        // 邊界，外圍為-1
    }
    public void mousePressed(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {

        // 偵測點的範圍
        int Y = e.getY() / 24;
        int X = e.getX() / 24;
        // 超過邊界，不可下
        if (X >= 21|| Y >= 21)
            return;
        //此位置可以下
        if (board[Y * 21 + X] == EMPTY) {
            board[Y * 21 + X] = playing;
            repaint();
            // 誰贏了?從個方位找是否有連續五子
            boolean isWin = false;
            int[][] direction = {{-21, 21}, {-1, 1}, {20, -20}, {22, -22}};
            int count = 1;
            int location = (Y * 21 + X);
            // 二維
            for(int i = 0; i < 4 ; i++) {
                int k = location;
                for(int j = 0 ; j < 2 ; j++) {
                    while (board[k + direction[i][j]] == playing) {
                        k += direction[i][j];
                        count++;
                        if (count == 5){
                            isWin = true;
                            break;
                        }
                    }
                    if (isWin == true) {
                       break;
                    }
                }
                if (isWin == true) {
                   break;
                }
                count = 1;
            }
            // 一維
            // for (int i = 0; i < direction.length; i++) {
            //     if (i % 2 == 0) {
            //         count = 1;
            //     }
            //     int j = location;
            //     while ( board[ j + direction[i] ] == playing) {
            //         count++;
            //         j += direction[i];
            //         if (count == 5){
            //             isWin = true;
            //             break;
            //         }
            //     }
            //     if (isWin == true) {
            //         break;
            //     }
            // }
            // 找到連續五子後，判斷誰贏，並開始新遊戲
            if (isWin == true) {
                if (playing == BLACK) {
                    JOptionPane.showMessageDialog(this, "黑棋贏了", "黑棋贏了", JOptionPane.INFORMATION_MESSAGE);
                } else if(playing == WHITE) {
                    JOptionPane.showMessageDialog(this, "白旗贏了", "白旗贏了", JOptionPane.INFORMATION_MESSAGE);
                }
                this.newGame();
                return;
            }
            // 攻守互換
            if (playing == BLACK) {
                playing = WHITE;
            } else {
                playing = BLACK;
            }
        }
    }
    // 畫線
    public void paint(Graphics g) {
        for (int i = 0; i < 20; i++) {
            g.drawLine(25, 25 + (i * 25), 500, 25 + (i * 25));
            g.drawLine(25 + (i * 25), 25, 25 + (i * 25), 500);
        }
        // 判斷圈叉並畫出
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                if (board[i * 21 + j] == BLACK) {
                    g.setColor(Color.BLACK);
                    g.fillOval(25 + (j - 1) * 25 - 10, 25 + (i - 1) * 25 - 10, 20, 20);
                } else if (board[i * 21 + j] == WHITE) {
                    g.setColor(Color.WHITE);
                    g.fillOval(25 + (j - 1) * 25 - 10, 25 + (i - 1) * 25 - 10, 20, 20);
                }
            }
        }
    }
    //產生新遊戲
    public void newGame() {
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++)
                board[i * 21 + j] = EMPTY;
        }
        // 外圍一圈直設-1
        for(int i = 0; i < 21; i++) {
            //上
            board[i] = -1;
            //下
            board[20 * 21 + i] = -1;
            //左
            board[i * 21] = -1;
            //右
            board[i * 21 + 20]= -1;
        }
        playing = BLACK;
        repaint();
    }
    public Dimension getPreferredSize() {
        return mySize;
    }
}
