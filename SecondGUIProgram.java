import javax.swing.*;
import java.awt.*;

public class SecondGUIProgram {
    public static void main(String args[]) {
        JFrame frame = new JFrame("Tite");
        frame.setDefaultCloseOperation(0);

        JPanel subPanel1 = new JPanel();
        subPanel1.setPreferredSize(new Dimension(150, 100));
        subPanel1.setBackground(Color.lightGray);
        JLabel one = new JLabel("Light");
        subPanel1.add(one);

        JPanel subPanel2 = new JPanel();
        subPanel2.setBackground(Color.yellow);
        JLabel two = new JLabel("Dark");
        subPanel2.add(two);

        JPanel primary = new JPanel();
        primary.setBackground(Color.GRAY);
        primary.add(subPanel1);
        primary.add(subPanel2);

        frame.getContentPane().add(primary);
        frame.pack();
        boolean b = true;
        frame.setVisible(b);
    }
}