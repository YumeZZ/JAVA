import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class FC extends JFrame implements ActionListener {
    private OX oxBoard;
    private FC() {
        super("GomokuHomework");
        Menu m;
        MenuBar mb;
        oxBoard = new OX(this);
        this.add(oxBoard);
        this.setMenuBar(mb = new MenuBar());
        mb.add(m = new Menu("Game")).add(new MenuItem("New Game")).addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
    public static void main(String argv[]) {
        new FC();
    }
    // implements the ActionListener interface
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("New Game")) {
            oxBoard.newGame();
        }
    }
}
class OX extends Component implements MouseListener {
    public static final byte EMPTY = 0;
    public static final byte WHITE = 1;
    public static final byte BLACK = 2;
    private byte[] board = new byte[441];
    private byte playing = BLACK;
    private Dimension mySize = new Dimension(420,420);
    private Frame parent;
    public OX(Frame p) {
        this.addMouseListener(this);
        parent = p;
    }
    // The following 5 functions implement the MouseListener interface
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {
        for (int i = 0;i < 21; i++) {
            board[i] = -1;
            board[20*21+i] = -1;
            board[i*21+20] = -1;
            board[i*21] = -1;
        }
        int row = e.getY()/20;
        int col = e.getX()/20;
        if (board[row*21+col]==-1) return; 
        if (board[row*21+col] == EMPTY) { 
            board[row*21+col] = playing;
            repaint(); // notify Window Manager
            // Anyone Win?
            for(int i = 0;i < 441; i++) {
                if(board[i] == playing && board[i+1] == playing && board[i+2] == playing && board[i-1] == playing && board[i-2] == playing) {
                    if (playing == WHITE) {
                        JOptionPane.showMessageDialog(this, "White Win", "White Win", JOptionPane.INFORMATION_MESSAGE);
                    } else if(playing == BLACK) {
                        JOptionPane.showMessageDialog(this, "Black Win", "Black Win", JOptionPane.INFORMATION_MESSAGE);
                    }
                    this.newGame();
                    return;
                } else if(board[i] == playing && board[i+21] == playing && board[i+42] == playing && board[i-21] == playing && board[i-42] == playing) {
                    if (playing == WHITE) {
                        JOptionPane.showMessageDialog(this, "White Win", "White Win", JOptionPane.INFORMATION_MESSAGE);
                    } else if(playing == BLACK) {
                        JOptionPane.showMessageDialog(this, "Black Win", "Black Win", JOptionPane.INFORMATION_MESSAGE);
                    }
                    this.newGame();
                    return;
                } else if(board[i] == playing && board[i+22] == playing && board[i+44] == playing && board[i-22] == playing && board[i-44] == playing) {
                    if (playing == WHITE) {
                        JOptionPane.showMessageDialog(this, "White Win", "White Win", JOptionPane.INFORMATION_MESSAGE);
                    } else if(playing == BLACK) {
                        JOptionPane.showMessageDialog(this, "Black Win", "Black Win", JOptionPane.INFORMATION_MESSAGE);
                    }
                    this.newGame();
                    return;
                } else if(board[i] == playing && board[i+20] == playing && board[i+40] == playing && board[i-20] == playing && board[i-40] == playing) {
                    if (playing == WHITE) {
                        JOptionPane.showMessageDialog(this, "White Win", "White Win", JOptionPane.INFORMATION_MESSAGE);
                    } else if(playing == BLACK) {
                        JOptionPane.showMessageDialog(this, "Black Win", "Black Win", JOptionPane.INFORMATION_MESSAGE);
                    }
                    this.newGame();
                    return;
                }
            }
        }
            if(playing == WHITE) {
                playing = BLACK;
            } else {
                playing = WHITE;
            }
    }
    // override paint() defined in Component
    public void paint(Graphics g) {
        for(int i = 0;i <=18;i++) {
        g.drawLine(20,20+20*i,380,20+20*i); 
        g.drawLine(20+20*i,20,20+20*i,380);  
        }
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                if (board[i*21+j] == WHITE) {
                    g.setColor(Color.WHITE);
                    g.fillOval(j*20-7,i*20-7,15,15);
                } else if (board[i*21+j] == BLACK) {
                    g.setColor(Color.BLACK);
                    g.fillOval(j*20-7,i*20-7,15,15);
                }
            }
        }
    }
    public void newGame() {
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                board[i*21+j] = EMPTY;
            }
            board[i] = -1;
            board[20*21+i] = -1;
            board[i*21+20] = -1;
            board[i*21] = -1;
        } 
        playing = WHITE;
        repaint();
    }
    // override getPreferredSize defined in Component,
    // so that the Component has proper size on screen
        public Dimension getPreferredSize() {
        return mySize;
    }
}