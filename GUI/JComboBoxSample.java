import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class JComboBoxSample {
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("JComboBox Demo");
 
        String[] colorList = {"RED",
            "GREEN",
            "BLUE",
            "CYAN",
            "DARK GRAY",
            "MAGENTA",
            "ORANGE",
            "PINK"};
        
        JComboBox cbColor = new JComboBox(colorList);
        
        cbColor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //String a = cbColor.getSelectedItem().toString();
                JOptionPane.showMessageDialog(frame,"Color Selected: " + cbColor.getSelectedItem().toString());
                
            }
        });
 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        Container cont = frame.getContentPane();
        cont.setLayout(new FlowLayout());
        cont.add(cbColor);
        frame.setVisible(true);
    }
}
