
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class JavaSwingSQLSample implements ActionListener {

    final String jdbc_driver = "org.apache.derby.jdbc.ClientDriver";
    final String dbUrl = "jdbc:derby://localhost:1527/anada";
    
    static final String user = "root";
     static final String pass = "root";

    JFrame frm;
    JPanel panelMain;
    JTextField tfUname;
    JPasswordField tfPword;
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    String sql = "";
    String uname = "";
    String pword = "";
    boolean chk = false;

    public JavaSwingSQLSample() {
        frm = new JFrame("Login");
        panelMain = new JPanel(new BorderLayout());
        displayHeaderLogin();
        displayCenterLogin();
        showFrame();
        dBConn();

    }

    public void displayHeaderLogin() {
        JPanel panel = new JPanel();
        JLabel lbl = new JLabel("Login");
        lbl.setFont(new Font("Consolas", Font.BOLD, 20));
        lbl.setForeground(Color.yellow);
        panel.setBackground(new Color(72, 82, 29));
        panel.add(lbl);
        panelMain.add(panel, BorderLayout.PAGE_START);
    }

    public void displayCenterLogin() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cst = new GridBagConstraints();
        cst.insets = new Insets(5, 0, 5, 5);
        JLabel lblUname = new JLabel("Username");
        JLabel lblPword = new JLabel("Password");
        tfUname = new JTextField();
        tfPword = new JPasswordField();

        tfUname.setPreferredSize(new Dimension(200, 25));
        tfPword.setPreferredSize(new Dimension(200, 25));

        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 0;
        panel.add(lblUname, cst);

        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 1;
        cst.gridy = 0;
        panel.add(tfUname, cst);

        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 1;
        panel.add(lblPword, cst);

        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 1;
        cst.gridy = 1;
        panel.add(tfPword, cst);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(this);
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 2;
        cst.gridwidth = 2;
        panel.add(btnLogin, cst);

        panelMain.add(panel, BorderLayout.CENTER);
    }

    public void showFrame() {
        frm.setSize(400, 200);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLocationRelativeTo(null);
        frm.add(panelMain);
        frm.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        switch (action) {
            case "Login":
                login();
                break;
        }
    }

    public void login() {

        dbStmt("Select * from tbl_user Where username='" + tfUname.getText() + "' AND password= '" + tfPword.getText() + "'");

        try {
            if (rs.next()) {
                frm.dispose();
                new Dashboard(rs.getString("fullname"));
            } else {
                JOptionPane.showMessageDialog(frm, "Login Failed");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(frm, e);
        }
    }

    void dBConn() {

        try {
            Class.forName(jdbc_driver);
            JOptionPane.showMessageDialog(frm, "Connecting to the database...");
            conn = DriverManager.getConnection(dbUrl, user, pass);
            if (conn != null) {
                JOptionPane.showMessageDialog(frm, "Connected to the database!");
            } else {
                JOptionPane.showMessageDialog(frm, "Could not connect to the database...");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(frm, "Error in connecting to the database!");
        }

    }

    ResultSet dbStmt(String sql) {
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(frm, "Error in SQL Statement!"
                    + e);
        }

        return rs;
    }

    /* Boolean loginCred(String uname,String pw,ResultSet rs){

 try{
 if(uname.equals(rs1.getString("username")) &&
pw.equals(rs1.getString("password"))){
 chk = true;
 }


 }catch(Exception e){
 JOptionPane.showMessageDialog(frm,e);
 }
 return chk;
 }
     */
    //main() method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JavaSwingSQLSample();
            }
        });
    }
}

/*

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

        f.setSize(400, 450);
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
        
        //regis
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 1;
        centerP.add(regisL, cst);

        //username
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 2;
        centerP.add(unameL, cst);

        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 2;
        cst.gridy = 2;
        centerP.add(unameTF, cst);

        //fullname
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 3;
        centerP.add(fullnameL, cst);

        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 2;
        cst.gridy = 3;
        centerP.add(fullnameTF, cst);

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

*/




/*

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

        f.setSize(400, 500);
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
        
        //regis
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 1;
        centerP.add(regisL, cst);

        //username
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 2;
        centerP.add(unameL, cst);

        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 2;
        cst.gridy = 2;
        centerP.add(unameTF, cst);

        //fullname
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 3;
        centerP.add(fullnameL, cst);

        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 2;
        cst.gridy = 3;
        centerP.add(fullnameTF, cst);

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

    public void threebuttons() {
        JPanel buttonsP = new JPanel();
        buttonsP.setLayout(new FlowLayout());
        //buttonsP.setPreferredSize(new Dimension(500, 500));
        buttonsP.setBackground(babypink);

        JPanel firstSetB = new JPanel();
        firstSetB.setLayout(new FlowLayout());
        buttonsP.setPreferredSize(new Dimension(50, 130));
        firstSetB.setBackground(babypink);

        GridBagConstraints cst = new GridBagConstraints();
        cst.insets = new Insets(5, 0, 5, 5);

//        JButton backB = new JButton("Back");
//        backB.setPreferredSize(new Dimension(150, 50));
//        backB.addActionListener((ActionListener) this);

        JButton clearB = new JButton("Clear");
        clearB.setPreferredSize(new Dimension(150, 25));
        clearB.addActionListener(this);

        

        JPanel secSetB = new JPanel();
        secSetB.setLayout(new FlowLayout());
        secSetB.setBackground(babypink);

        JButton submitB = new JButton("Submit");
        submitB.setPreferredSize(new Dimension(305, 50));
        submitB.addActionListener(this);

        //firstSetB.add(backB);
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

*/


/*

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

        f.setSize(400, 500);
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
        cst.insets = new Insets(15, 0, 5, 5);

        JLabel regisL = new JLabel("Register");
        regisL.setFont(fonty);

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

        //regis
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 0;
        centerP.add(regisL, cst);

        //username
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 1;
        centerP.add(unameL, cst);

        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 2;
        cst.gridy = 1;
        centerP.add(unameTF, cst);

        //fullname
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 2;
        centerP.add(fullnameL, cst);

        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 2;
        cst.gridy = 2;
        centerP.add(fullnameTF, cst);

        //password
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 3;
        centerP.add(passL, cst);

        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 2;
        cst.gridy = 3;
        centerP.add(passPF, cst);

        //confirm password
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 4;
        centerP.add(cpassL, cst);

        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 2;
        cst.gridy = 4;
        centerP.add(cpassPF, cst);

        mainP.add(centerP);
    }

    public void threebuttons() {
        JPanel buttonsP = new JPanel();
        buttonsP.setLayout(new FlowLayout());
        //buttonsP.setPreferredSize(new Dimension(500, 500));
        buttonsP.setBackground(babypink);

        JPanel firstSetB = new JPanel();
        firstSetB.setLayout(new FlowLayout());
        buttonsP.setPreferredSize(new Dimension(50, 130));
        firstSetB.setBackground(babypink);

        GridBagConstraints cst = new GridBagConstraints();
        cst.insets = new Insets(5, 0, 5, 5);

        JButton backB = new JButton("Back");
        backB.setPreferredSize(new Dimension(150, 25));
        backB.addActionListener((ActionListener) this);

        JButton clearB = new JButton("Clear");
        clearB.setPreferredSize(new Dimension(150, 25));
        clearB.addActionListener(this);

        

        JPanel secSetB = new JPanel();
        secSetB.setLayout(new FlowLayout());
        secSetB.setBackground(babypink);

        JButton submitB = new JButton("Submit");
        submitB.setPreferredSize(new Dimension(305, 50));
        submitB.addActionListener(this);

        firstSetB.add(backB);
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

*/