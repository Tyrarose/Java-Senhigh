package Ailurus_final.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Register implements ActionListener {

    final String jdbc_driver = "org.apache.derby.jdbc.ClientDriver";
    final String dbUrl = "jdbc:derby://localhost:1527/ailurusfinal";

    static final String user = "root";
    static final String pass = "root";
    String chees;

    public Register(Connection conn,String cheesu) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                chees = cheesu;
                showFrame();
                con = conn;
            }
        });
    }

    JFrame f;
    JPanel mainP;
    JLabel name;

    static JTextField unameTF, fullnameTF;
    JPasswordField passPF, cpassPF;
    JComboBox UTypebox;
    String[] utypes = {"Admin", "User"};

    Color babypink = new Color(245, 202, 195);
    
    
    Color brownorange = new Color(177,61,20);
    Color whiteyellow = new Color(252,231,210);
    Color brown = new Color(52,7,1);
    Color medjred = new Color(156,26,4);
    Color nude = new Color(219,135,88);
    
    Font fonty = new Font("Cooper Black", Font.PLAIN, 30);
    Font fonty1 = new Font("Cooper Black", Font.PLAIN, 50);
    Font fonty2 = new Font("Cooper Black", Font.PLAIN, 15);

    Connection con;
    Statement st;
    ResultSet rs = null;

    void showFrame() {
        f = new JFrame("Register");
        mainP = new JPanel(new BorderLayout());

        displayHeaderRegister();
        displayCenterRegister();
        threebuttons();

        f.setSize(400, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.add(mainP);
        f.setVisible(true);;
    }

    void displayHeaderRegister() {
        JPanel getonP = new JPanel();
        getonP.setLayout(new GridBagLayout());
        getonP.setPreferredSize(new Dimension(200, 70));
        getonP.setBackground(brownorange);

        JLabel getL = new JLabel("Get on board!");
        getL.setFont(fonty);
        getL.setForeground(Color.white);

        getonP.add(getL);

        mainP.add(getonP, BorderLayout.PAGE_START);
    }

    void displayCenterRegister() {
        JPanel centerP = new JPanel(new GridBagLayout());
        centerP.setBackground(whiteyellow);
        GridBagConstraints cst = new GridBagConstraints();
        cst.insets = new Insets(5, 0, 5, 5);

        JButton backB = new JButton("Back");
        backB.setPreferredSize(new Dimension(100, 40));
        backB.setBackground(nude);
        backB.addActionListener((ActionListener) this);

        JLabel regisL = new JLabel("Register");
        regisL.setFont(fonty);

        JLabel space = new JLabel(" ");
        JLabel unameL = new JLabel("Username");
        JLabel passL = new JLabel("Password");
        JLabel cpassL = new JLabel("Confirm password");

        unameTF = new JTextField();
        passPF = new JPasswordField();
        cpassPF = new JPasswordField();

        unameTF.setPreferredSize(new Dimension(200, 25));

        passPF.setPreferredSize(new Dimension(200, 25));
        cpassPF.setPreferredSize(new Dimension(200, 25));

        JButton clearB = new JButton("Clear");
        clearB.setBackground(medjred);
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
        //user type
        //password
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 4;
        centerP.add(passL, cst);
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 2;
        cst.gridy = 4;
        centerP.add(passPF, cst);

        //confirm password
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 5;
        centerP.add(cpassL, cst);
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 2;
        cst.gridy = 5;
        centerP.add(cpassPF, cst);

        mainP.add(centerP);
    }

    void threebuttons() {
        JPanel buttonsP = new JPanel();
        buttonsP.setLayout(new FlowLayout());
        buttonsP.setBackground(whiteyellow);

        JPanel firstSetB = new JPanel();
        firstSetB.setLayout(new FlowLayout());
        firstSetB.setBackground(whiteyellow);

        GridBagConstraints cst = new GridBagConstraints();
        cst.insets = new Insets(5, 0, 5, 5);

        JButton clearB = new JButton("Clear");
        clearB.setPreferredSize(new Dimension(100, 70));
        clearB.setBackground(nude);
        clearB.addActionListener(this);

        JPanel secSetB = new JPanel();
        secSetB.setLayout(new FlowLayout());
        secSetB.setBackground(whiteyellow);

        JButton submitB = new JButton("Submit");
        submitB.setPreferredSize(new Dimension(200, 70));
        submitB.setBackground(nude);
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
                if(chees.equals("kimbap")){
                    f.dispose();
                }else if(chees.equals("kek")){
                    f.dispose();
                    new login();}
                break;
            case "Clear":
                unameTF.setText(null);
                passPF.setText(null);
                cpassPF.setText(null);
                break;

            case "Submit":
                if (unameTF.getText().toString().isEmpty()
                        || passPF.getText().toString().isEmpty()
                        || cpassPF.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(f, "There is an error here.");
                } else {
                    register(unameTF.getText().toString(), passPF.getText().toString());
                }
                break;
        }
    }

    void register(String uname, String txtpword) {
        try {
            Class.forName(jdbc_driver);
            //JOptionPane.showMessageDialog(f, "Connecting to the database...");
            Connection conn = DriverManager.getConnection(dbUrl, user, pass);
            if (conn != null) {
                //JOptionPane.showMessageDialog(f, "Connected to the database!");
            } else {
                JOptionPane.showMessageDialog(f, "Could not connect to the database...");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(f, "Error in connecting to the database!");
        }

        try {
            st = con.createStatement();
            st.executeUpdate("INSERT INTO TBL_USERS(username, password, ustype) VALUES('" + uname + "', '" + txtpword + "', 4)");
            JOptionPane.showMessageDialog(f, "Successfully Registered !");
            f.dispose();
            new login();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(f, "Error in SQL Statement !" + e);
        }
    }
}
