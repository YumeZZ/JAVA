import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class GomokuHomework1 extends JFrame implements ActionListener {
    private Chess chessBoard;
    private GomokuHomework1() {
        super("黑白棋");
        Menu m;
        MenuBar mb;
        chessBoard = new Chess(this);
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
        new GomokuHomework1();
    }
}
class Chess extends Component implements MouseListener {
    //黑白棋、空值
    public static final byte EMPTY = 0;
    public static final byte BLACK = 1;
    public static final byte WHITE = 2;
    private byte[] board = new byte[100];
    private byte playing = BLACK;
    //設定視窗大小
    private Dimension mySize = new Dimension(750, 750);
    private Frame parent;
    public Chess(Frame p) {
        this.addMouseListener(this);
        parent = p;
    }
    public void mousePressed(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {
        // 邊界，外圍為-1
        for(int i = 0; i < 10; i++) {
            //上
            board[i] = -1;
            //下
            board[9 * 10 + i] = -1;
            //左
            board[i * 10] = -1;
            //右
            board[i * 10 + 9]= -1;
        }
        // 偵測點的範圍
        int Y = e.getY() / 75;
        int X = e.getX() / 75;
        // 超過邊界，不可下
        if (X >= 10|| Y >= 10)
            return;
        //此位置可以下
        if (board[Y * 10 + X] == EMPTY) {
            board[Y * 10 + X] = playing;
            repaint();
            // 誰贏了?從個方位找是否有連續五子
            boolean isWin = false;
            int[][] direction = {{-21, 21}, {-1, 1}, {20, -20}, {22, -22}};
            int count = 1;
            int location = (Y * 10 + X);
            // 二維
            for(int i = 0; i < 4 ; i++) {
                int k = location;
                for(int j = 0 ; j < 2 ; j++) {
                    while (board[k + direction[i][j]] == playing) {
                        k += direction[i][j];
                        count++;
                        if (count == 5) {
                            //isWin = true;
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
        for (int i = 0; i < 9; i++) {
            g.drawLine(75, 75 + (i * 75), 675, 75 + (i * 75));
            g.drawLine(75 + (i * 75), 75, 75 + (i * 75), 675);
        }
        // 判斷圈叉並畫出
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i * 10 + j] == BLACK) {
                    g.setColor(Color.BLACK);
                    g.fillOval(87 + (j - 1) * 75 , 87 + (i - 1) * 75 , 50, 50);
                } else if (board[i * 10 + j] == WHITE) {
                    g.setColor(Color.WHITE);
                    g.fillOval(87 + (j - 1) * 75 , 87 + (i - 1) * 75 , 50, 50);
                }
            }
        }
    }
    //產生新遊戲
    public void newGame() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++)
                board[i * 10 + j] = EMPTY;
        }
        // 外圍一圈直設-1
        for(int i = 0; i < 10; i++) {
            //上
            board[i] = -1;
            //下
            board[9 * 10 + i] = -1;
            //左
            board[i * 10] = -1;
            //右
            board[i * 10 + 9]= -1;
        }
        playing = BLACK;
        repaint();
        for (int i = 0; i < 100; i++) {
            System.out.printf("%2d", board[i]);
            if ((i + 1) % 10 == 0)
                System.out.println();
        }
    }
    public Dimension getPreferredSize() {
        return mySize;
    }
}
