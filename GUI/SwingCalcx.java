import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingCalcx implements ActionListener{
    
    JFrame f;
    JPanel mainP;
    JTextField tf1, tf2, tfTotal;
    JButton bPlus, bMinus, bTimes, bDivide, bClear;
    JLabel lblOp;
    
    public SwingCalcx(){
        f = new JFrame("Swing Calc 1.0");
        mainP = new JPanel(new BorderLayout());
        display();
        showFrame();
    }
    
    public void display(){
        JPanel headP = new JPanel();
        headP.setBackground(new Color(120,150,120));
        // setup header
        JLabel lblHeader = new JLabel("Swing Calc 1.0");
        lblHeader.setFont(new Font("Consolas",Font.BOLD,20));
        lblHeader.setForeground(Color.white);
        headP.add(lblHeader);
        // setup components
        setupCenter();
        
        mainP.add(headP,BorderLayout.PAGE_START);
    }
    
   
    public void setupCenter(){
        JPanel centerP = new JPanel();
        centerP.setLayout(null);
        // setup textfields
        tf1 = new JTextField();
        tf2 = new JTextField();
        tf1.setBounds(70, 20, 100, 25);
        tf2.setBounds(225, 20, 100, 25);
        tf1.setText("0");
        tf2.setText("0");
        centerP.add(tf1);
        centerP.add(tf2);
        // setup buttons
        bPlus = new JButton("+");
        bMinus = new JButton("-");
        bTimes = new JButton("*");
        bDivide = new JButton("/");
        bClear = new JButton("C");
        bPlus.setBounds(70,50,45,30);
        bMinus.setBounds(140,50,45,30);
        bTimes.setBounds(210,50,45,30);
        bDivide.setBounds(280,50,45,30);
        bClear.setBounds(280,140,45,30);
        bPlus.addActionListener(this);
        bMinus.addActionListener(this);
        bTimes.addActionListener(this);
        bDivide.addActionListener(this);
        bClear.addActionListener(this);
        centerP.add(bPlus);
        centerP.add(bMinus);
        centerP.add(bTimes);
        centerP.add(bDivide);
        centerP.add(bClear);
        // setup label for total
        tfTotal = new JTextField();
        tfTotal.setFont(new Font("Impact",Font.BOLD,30));
        tfTotal.setBounds(70,100,255,30);
        tfTotal.setText("0");
        tfTotal.setEditable(false);
        centerP.add(tfTotal);
        // setup operator label
        lblOp = new JLabel("+");
        lblOp.setFont(new Font("Courier New",Font.BOLD,25));
        lblOp.setBounds(189, 15, 30, 30);
        centerP.add(lblOp);
        mainP.add(centerP,BorderLayout.CENTER);
    }
    
    public void showFrame(){
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400, 250);
        f.setLocationRelativeTo(null);
        f.add(mainP);
        f.setResizable(false);
        f.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String ac = ae.getActionCommand();
        double num1 = Double.parseDouble(tf1.getText());
        double num2 = Double.parseDouble(tf2.getText());
        switch(ac){
            case "+":
                double sum = num1 + num2;
                tfTotal.setText(sum + "");
                lblOp.setText("+");
                break;
            case "-":
                double dif = num1 - num2;
                tfTotal.setText(dif + "");
                lblOp.setText("-");
                break;
            case "*":
                double prod = num1 * num2;
                tfTotal.setText(prod + "");
                lblOp.setText("*");
                break;
            case "/":
                double quo = num1 / num2;
                tfTotal.setText(quo + "");
                lblOp.setText("/");
                break;
            case "C":
                tfTotal.setText("0");
                tf1.setText("0");
                tf2.setText("0");
                lblOp.setText("+");
            default:
                break;
        }
    }
    
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new SwingCalcx();
            }
        });
    }

    
    
}
