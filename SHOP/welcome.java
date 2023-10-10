
import javax.swing.*;

public class welcome {
    
    public welcome() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                showFrame();
            }
        });
    }
    
    JFrame f;
    JPanel mainP;
    JLabel name;
    
    void showFrame() {
        f = new JFrame("Register");
        mainP = new JPanel(new BorderLayout());

        

        f.setSize(400, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.add(mainP);
        f.setVisible(true);;
    }
}
