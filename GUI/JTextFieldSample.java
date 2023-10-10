import javax.swing.*;
import java.awt.*;

public class JTextFieldSample {
    public static void main(String[] args){
        JFrame f = new JFrame("JTextField Sample");
        f.setLayout(new FlowLayout());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JTextField jt = new JTextField();
        jt.setPreferredSize(new Dimension(200,28));
        jt.setFont(new Font("Courier New",Font.ITALIC,28));
        jt.setBackground(Color.pink);
        jt.setForeground(Color.red);
        jt.setText("Full name:");
        //jt.setEnabled(false);
        jt.setEditable(false);
        
        f.add(jt);
        f.setSize(500,100);
        f.setVisible(true);
        
    }
}
