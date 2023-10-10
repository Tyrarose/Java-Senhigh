//m6

import javax.swing.*;
import java.awt.*;

public class Dashboard {

    public Dashboard(String fname) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                showFrame(fname);
            }
        });
    }
    
    JFrame f;
    JPanel panelMain;
    JLabel name;

    public void showFrame(String fname) {
        f = new JFrame("Dashboard");
        panelMain = new JPanel(new BorderLayout());

        displayHeader(fname);

        f.setSize(500, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.add(panelMain);
        f.setVisible(true);
    }

    public void displayHeader(String fname) {
        JPanel panel = new JPanel();
        JLabel lbl = new JLabel("Welcome " + fname);
        lbl.setFont(new Font("Consolas", Font.BOLD, 30));
        lbl.setForeground(Color.white);
        panel.setBackground(Color.BLACK);
        panel.add(lbl);
        panelMain.add(panel, BorderLayout.PAGE_START);
    }

}
