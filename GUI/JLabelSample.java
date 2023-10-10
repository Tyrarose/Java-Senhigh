import javax.swing.*;
import java.awt.*;


public class JLabelSample {
    public static void main(String[] args){
        JFrame f = new JFrame("JLabel Sample");
        f.setLayout(new FlowLayout());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel jl = new JLabel("I am a label");
        jl.setFont(new Font("Century Gothic",Font.BOLD,20));
        jl.setForeground(Color.blue);
        
        f.add(jl);
        f.setSize(200,150);
        f.setVisible(true);
    }
}
