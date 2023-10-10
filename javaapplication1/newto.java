
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class newto {

    public static void main(String[] args) {

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JButton) {
                    
                    //if(cartuu.getSource() == INDEX//NAME)
                    String text = ((JButton) e.getSource()).getText();
                    
                    JOptionPane.showMessageDialog(null, text);
                    
                }
            }
        };

        JPanel panel = new JPanel(new GridLayout(4, 3));

        JButton[] array = new JButton[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = new JButton(String.valueOf(i));
            array[i].addActionListener(listener);
            panel.add(array[i]);
        }

        JOptionPane.showMessageDialog(null, panel);

    }

}

//add to cart 
//get name 
//add cart db