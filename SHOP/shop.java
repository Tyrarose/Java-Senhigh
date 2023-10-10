
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class shop implements ActionListener{

    public shop() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                showFrame();
            }
        });
    }

    JFrame f;
    JPanel mainP;

    void showFrame() {
        f = new JFrame("Shop");
        mainP = new JPanel(new FlowLayout());
        

        choose();
        product();
        selectedItems();

        f.setSize(1000, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.add(mainP);
        f.setVisible(true);;
    }

    void choose() {
        JPanel choose = new JPanel(new BorderLayout());
        choose.setPreferredSize(new Dimension(200, 500));
        choose.setBackground(Color.BLUE);
        
        JPanel chooseHeader = new JPanel();
        JLabel chooseL = new JLabel("Choose");
        chooseHeader.add(chooseL);

        JPanel buttonsP = new JPanel();
        

        JButton b1 = new JButton("Tower");
        JButton b2 = new JButton("Input pheripherals");
        JButton b3 = new JButton("Output pheripherals");

        buttonsP.add(b1);
        buttonsP.add(b2);
        buttonsP.add(b3);

        choose.add(chooseHeader, BorderLayout.PAGE_START);
        choose.add(buttonsP, BorderLayout.CENTER);
        mainP.add(choose);
    }

    void product() {
        JPanel product = new JPanel(new BorderLayout());
        product.setPreferredSize(new Dimension(500, 500));
        
        JPanel chooseHeader = new JPanel();
        chooseHeader.setBackground(Color.BLUE);
        JLabel prodcutL = new JLabel("Product");
        chooseHeader.add(prodcutL);

        JPanel products = new JPanel();
        products.setLayout(new FlowLayout());
        products.setBackground(Color.BLUE);
        
        JRadioButton rb1 = new JRadioButton();
        JRadioButton rb2 = new JRadioButton();
        JRadioButton rb3 = new JRadioButton();

        products.add(rb1);
        products.add(rb2);
        products.add(rb3);

        product.add(chooseHeader, BorderLayout.PAGE_START);
        product.add(products, BorderLayout.CENTER);
        mainP.add(product);
    }
    void selectedItems() {
        JPanel selected = new JPanel(new BorderLayout());
        selected.setPreferredSize(new Dimension(200, 500));
        
        JPanel itemsP = new JPanel();
        JLabel itemsL = new JLabel("Selected Items");
        itemsP.add(itemsL);
        
        JPanel buttonsP = new JPanel();
        buttonsP.setLayout(new FlowLayout());

        JButton b1 = new JButton("Submit");
        JButton b2 = new JButton("Remove");

        buttonsP.add(b1);
        buttonsP.add(b2);

        selected.add(itemsP, BorderLayout.PAGE_START);
        selected.add(buttonsP, BorderLayout.CENTER);
        mainP.add(selected);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

}
