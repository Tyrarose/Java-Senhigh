
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class mainclass {
    public static void main(String[] args) {
        JFrame f = new JFrame("POS");
        JPanel mainP = new JPanel(new BorderLayout());
        
        JButton button = new JButton("Shop");
        
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new shop();
            }
        }
        );
        mainP.add(button);
        
        f.setSize(400, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.add(mainP);
        f.setVisible(true);
        
    }

}
