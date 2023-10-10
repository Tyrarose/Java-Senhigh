import javax.swing.*;
import java.awt.*;

public class SecondGUIProgram{
    public static void main(String[] args){
        JFrame frame = new JFrame("Nested Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //create the first sub-panel
        JPanel subPanel1 = new JPanel();
        subPanel1.setPreferredSize(new Dimension(150,100));
        subPanel1.setBackground(Color.green);
        JLabel label1 = new JLabel("One");
        subPanel1.add(label1);
        
        //create the second sub-panel
        JPanel subPanel2 = new JPanel();
        subPanel2.setPreferredSize(new Dimension(150,100));
        subPanel2.setBackground(Color.RED);
        JLabel label2 = new JLabel("Two");
        subPanel2.add(label2);
               
        //create the primary panel
        JPanel primary = new JPanel();
        primary.setBackground(Color.blue);
        primary.add(subPanel1);
        primary.add(subPanel2);
       
        frame.getContentPane().add(primary);
        frame.pack();
        frame.setVisible(true);
        
    }
}
