import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.String;
//import javax.swing.AbstractButton;

public class Mathtest1 extends JFrame implements ActionListener{
    int number[] = new int[2];
    int answer[] = new int[5];
    Button button[]=new Button[5];
    Label label[]=new Label[5];
    String operation[] = {"+","-","*","/","%"};
    String operations;
    private Mathtest1(){
        super("Math Test");
        this.setSize(400,200);
        this.getContentPane().setLayout(new GridLayout(2,5));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int S = (int)(Math.random()*5);
        operations = operation[S];
        switch(S)
        {
            case 0:
                answer[0]=number[0]+number[1];
                break;
            case 1:
                answer[1]=number[0]-number[1];
                break;
            case 2:
                answer[2]=number[0]*number[1];
                break;
            case 3:
                answer[3]=number[0]/number[1];
                break;
            case 4:
                answer[4]=number[0]%number[1];
                break;
        }


        number[0]=(int)(Math.random()*999+1);
        number[1]=(int)(Math.random()*999+1);
        label[0] = new Label(Integer.toString(number[0]), Label.CENTER);
        label[1] = new Label(operations, Label.CENTER);
        label[2] = new Label(Integer.toString(number[1]), Label.CENTER);
        label[3] = new Label("=", Label.CENTER);
        label[4] = new Label("?", Label.CENTER);
        for(int i=0;i<5;i++)
            this.add(label[i]);

        answer[0] = (int)(number[0]+number[1]);
        answer[1] = (int)(number[0]-number[1]);
        answer[2] = (int)(number[0]*number[1]);
        answer[3] = (int)(number[0]/number[1]);
        answer[4] = (int)(number[0]%number[1]);

        //方格中的符號
        button[0]= new Button(Integer.toString(answer[0]));
        button[1]= new Button(Integer.toString(answer[1]));
        button[2]= new Button(Integer.toString(answer[2]));
        button[3]= new Button(Integer.toString(answer[3]));
        button[4]= new Button(Integer.toString(answer[4]));


        button[0].setActionCommand("+");
        button[0].addActionListener(this);
        button[1].setActionCommand("-");
        button[1].addActionListener(this);
        button[2].setActionCommand("*");
        button[2].addActionListener(this);
        button[3].setActionCommand("/");
        button[3].addActionListener(this);
        button[4].setActionCommand("%");
        button[4].addActionListener(this);
        for(int i=0;i<5;i++)
            this.add(button[i]);
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        String cmd=e.getActionCommand();
        if(cmd == "+"&&number[0]+number[1]==answer[0]){
            JOptionPane.showMessageDialog(this,"冰崩冰崩!!","好棒棒喔!下一題!",JOptionPane.INFORMATION_MESSAGE);
            this.newGame();
        }else if(cmd == "+"&&number[0]+number[1]!=answer[0])
            JOptionPane.showMessageDialog(this,"答錯,哭惹","別灰心,再想一下",JOptionPane.INFORMATION_MESSAGE);
        if(cmd == "-"&&number[0]-number[1]==answer[1]){
            JOptionPane.showMessageDialog(this,"冰崩冰崩!!","好棒棒喔!下一題!",JOptionPane.INFORMATION_MESSAGE);
            this.newGame();
        }else if(cmd == "-"&&number[0]-number[1]!=answer[1])
            JOptionPane.showMessageDialog(this,"答錯,哭惹","別灰心,再想一下",JOptionPane.INFORMATION_MESSAGE);
        if(cmd == "*"&&number[0]*number[1]==answer[2]){
            JOptionPane.showMessageDialog(this,"冰崩冰崩!!","好棒棒喔!下一題!",JOptionPane.INFORMATION_MESSAGE);
            this.newGame();
        }else if(cmd == "*"&&number[0]*number[1]!=answer[2])
            JOptionPane.showMessageDialog(this,"答錯,哭惹","別灰心,再想一下",JOptionPane.INFORMATION_MESSAGE);
        if(cmd == "/"&&number[0]/number[1]==answer[3]){
            JOptionPane.showMessageDialog(this,"冰崩冰崩!!","好棒棒喔!下一題!",JOptionPane.INFORMATION_MESSAGE);
            this.newGame();
        }else if(cmd == "/"&&number[0]/number[1]!=answer[3])
            JOptionPane.showMessageDialog(this,"答錯,哭惹","別灰心,再想一下",JOptionPane.INFORMATION_MESSAGE);
        if(cmd == "%"&&number[0]%number[1]==answer[4]){
            JOptionPane.showMessageDialog(this,"冰崩冰崩!!","好棒棒喔!下一題!",JOptionPane.INFORMATION_MESSAGE);
            this.newGame();
        }else if(cmd == "%"&&number[0]%number[1]!=answer[4])
            JOptionPane.showMessageDialog(this,"答錯,哭惹","別灰心,再想一下",JOptionPane.INFORMATION_MESSAGE);
    }
    public void newGame()
    {
        number[0]=(int)(Math.random()*999+1);
        number[1]=(int)(Math.random()*999+1);
        int S = (int)(Math.random()*5);
        operations = operation[S];
        switch(S){
            case 0:
                answer[0]=number[0]+number[1];
                break;
            case 1:
                answer[1]=number[0]-number[1];
                break;
            case 2:
                answer[2]=number[0]*number[1];
                break;
            case 3:
                answer[3]=number[0]/number[1];
                break;
            case 4:
                answer[4]=number[0]%number[1];
                break;
        }
        label[0].setText(Integer.toString(number[0]));
        label[1].setText(operations);
        label[2].setText(Integer.toString(number[1]));
        label[4].setText("?");

        answer[0] = (int)(number[0]+number[1]);
        answer[1] = (int)(number[0]-number[1]);
        answer[2] = (int)(number[0]*number[1]);
        answer[3] = (int)(number[0]/number[1]);
        answer[4] = (int)(number[0]%number[1]);

        //方格中的符號
        button[0].setLabel(Integer.toString(answer[0]));
        button[1].setLabel(Integer.toString(answer[1]));
        button[2].setLabel(Integer.toString(answer[2]));
        button[3].setLabel(Integer.toString(answer[3]));
        button[4].setLabel(Integer.toString(answer[4]));


    }
    public static void main(String argv[]){
        new Mathtest1();
    }
}
