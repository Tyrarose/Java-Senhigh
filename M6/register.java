//m6

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class register implements ActionListener {

    public register() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                showFrame();
            }
        });
    }

    JFrame f;
    JPanel mainP;
    JLabel name;

    JTextField unameTF, fullnameTF;
    JPasswordField passPF, cpassPF;

    Color babypink = new Color(245, 202, 195);
    Font fonty = new Font("Cooper Black", Font.PLAIN, 30);

    public void showFrame() {
        f = new JFrame("Register");
        mainP = new JPanel(new BorderLayout());

        displayHeaderRegis();
        displayCenterRegis();
        threebuttons();

        f.setSize(400,500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.add(mainP);
        f.setVisible(true);
    }

    public void displayHeaderRegis() {
        JPanel getonP = new JPanel();
        getonP.setLayout(new GridBagLayout());
        getonP.setPreferredSize(new Dimension(200, 70));
        getonP.setBackground(babypink);

        JLabel getL = new JLabel("Get on board!");
        getL.setFont(fonty);
        getL.setForeground(Color.white);

        getonP.add(getL);

        mainP.add(getonP, BorderLayout.PAGE_START);
    }

    public void displayCenterRegis() {
        
        JPanel centerP = new JPanel(new GridBagLayout());
        centerP.setBackground(babypink);
        GridBagConstraints cst = new GridBagConstraints();
        cst.insets = new Insets(5,0,5,5);
        
        
        JButton backB = new JButton("Back");
        backB.setPreferredSize(new Dimension(100, 25));
        backB.addActionListener((ActionListener) this);
        
        JLabel regisL = new JLabel("Register");
        regisL.setFont(fonty);
        
        
        JLabel space = new JLabel(" ");
        JLabel unameL = new JLabel("Username");
        JLabel fullnameL = new JLabel("Fullname");
        JLabel passL = new JLabel("Password");
        JLabel cpassL = new JLabel("Confirm password");

        unameTF = new JTextField();
        fullnameTF = new JTextField();
        passPF = new JPasswordField();
        cpassPF = new JPasswordField();

        unameTF.setPreferredSize(new Dimension(200, 25));
        fullnameTF.setPreferredSize(new Dimension(200, 25));
        passPF.setPreferredSize(new Dimension(200, 25));
        cpassPF.setPreferredSize(new Dimension(200, 25));
        
        JButton clearB = new JButton("Clear");
        clearB.setPreferredSize(new Dimension(150, 50));
        clearB.addActionListener(this);

        //back button
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 0;
        centerP.add(backB, cst);
        
        //space
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 1;
        centerP.add(space, cst);
        
        //regis
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 2;
        centerP.add(regisL, cst);

        //username
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 3;
        centerP.add(unameL, cst);

        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 2;
        cst.gridy = 3;
        centerP.add(unameTF, cst);

        //fullname
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 4;
        centerP.add(fullnameL, cst);

        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 2;
        cst.gridy = 4;
        centerP.add(fullnameTF, cst);

        //password
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 5;
        centerP.add(passL, cst);

        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 2;
        cst.gridy = 5;
        centerP.add(passPF, cst);

        //confirm password
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 6;
        centerP.add(cpassL, cst);

        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 2;
        cst.gridy = 6;
        centerP.add(cpassPF, cst);

        mainP.add(centerP);
    }

    public void threebuttons() {
        JPanel buttonsP = new JPanel();
        buttonsP.setLayout(new FlowLayout());
        buttonsP.setBackground(babypink);

        JPanel firstSetB = new JPanel();
        firstSetB.setLayout(new FlowLayout());
        firstSetB.setBackground(babypink);

        GridBagConstraints cst = new GridBagConstraints();
        cst.insets = new Insets(5, 0, 5, 5);

        JButton clearB = new JButton("Clear");
        clearB.setPreferredSize(new Dimension(70, 50));
        clearB.addActionListener(this);
        

        JPanel secSetB = new JPanel();
        secSetB.setLayout(new FlowLayout());
        secSetB.setBackground(babypink);

        JButton submitB = new JButton("Submit");
        submitB.setPreferredSize(new Dimension(200, 50));
        submitB.addActionListener(this);

        firstSetB.add(clearB);
        secSetB.add(submitB);

        buttonsP.add(firstSetB);
        buttonsP.add(secSetB);

        mainP.add(buttonsP, BorderLayout.PAGE_END);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        switch (action) {
            case "Back":
                f.dispose();
                loginMain logback = new loginMain();
                break;
            case "Clear":
                unameTF.setText(null);
                fullnameTF.setText(null);
                passPF.setText(null);
                cpassPF.setText(null);
                break;
            case "Submit":
                JOptionPane.showMessageDialog(f, "For the next activity");
                break;
        }
    }
}