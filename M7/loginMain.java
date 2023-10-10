/*
Belgica, Charlene
Clemente, Tyra
Garoy, Danicalyn
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class loginMain implements ActionListener {

    final String jdbc_driver = "org.apache.derby.jdbc.ClientDriver";
    final String dbUrl = "jdbc:derby://localhost:1527/anadawan";

    static final String user = "root";
    static final String pass = "root";

    JFrame f;
    JPanel mainP;
    JTextField tfUname;
    JPasswordField tfPword;
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    String sql = "";
    String uname = "";
    String pword = "";
    boolean chk = false;

    Color babypink = new Color(245, 202, 195);
    Font fonty = new Font("Cooper Black", Font.PLAIN, 30);

    public loginMain() {
        f = new JFrame("Login Form");
        mainP = new JPanel(new BorderLayout());
        displayHeaderLogin();
        displayCenterLogin();
        showFrame();
        dBConn();
    }

    public void displayHeaderLogin() {
        JPanel welcomeP = new JPanel();
        welcomeP.setLayout(new GridBagLayout());
        welcomeP.setPreferredSize(new Dimension(200, 70));

        JLabel welcomeL = new JLabel("Welcome back!");
        welcomeL.setFont(fonty);
        welcomeL.setForeground(Color.white);
        welcomeP.setBackground(babypink);

        welcomeP.add(welcomeL);
        mainP.add(welcomeP, BorderLayout.PAGE_START);
    }

    public void displayCenterLogin() {

        JLabel loginL = new JLabel("Login");
        loginL.setFont(fonty);

        JPanel centerP = new JPanel(new GridBagLayout());
        GridBagConstraints cst = new GridBagConstraints();
        cst.insets = new Insets(5, 0, 5, 5);

        JLabel lblUname = new JLabel("Username");
        JLabel lblPword = new JLabel("Password");
        tfUname = new JTextField();
        tfPword = new JPasswordField();

        tfUname.setPreferredSize(new Dimension(200, 25));
        tfPword.setPreferredSize(new Dimension(200, 25));

        JLabel notyetL = new JLabel("<html><br>----------------------------------------------------------------------" + "<br><br><br>Don't have an account yet?" + "<br><br>   </html>");
        loginL.setFont(fonty);

        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 0;
        centerP.add(loginL, cst);

        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 1;
        centerP.add(lblUname, cst);

        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 2;
        cst.gridy = 1;
        centerP.add(tfUname, cst);

        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 2;
        centerP.add(lblPword, cst);

        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 2;
        cst.gridy = 2;
        centerP.add(tfPword, cst);

        JButton loginB = new JButton("Login");
        loginB.addActionListener(this);
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 3;
        cst.gridwidth = 3;
        centerP.add(loginB, cst);

        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 4;
        centerP.add(notyetL, cst);

        JButton regB = new JButton("Register");
        regB.setPreferredSize(new Dimension(200, 50));
        regB.addActionListener(this);
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 5;
        centerP.add(regB, cst);

        mainP.add(centerP);
    }

    public void showFrame() {
        f.setSize(400, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.add(mainP);
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        switch (action) {
            case "Login":
                login();
                break;
            case "Register":
                f.dispose();
                register();
                break;
        }
    }

    public void login() {
        dbStmt("Select * from tbl_user Where username='" + tfUname.getText() + "' AND password= '" + tfPword.getText() + "'");
        try {
            if (rs.next()) {
                f.dispose();
                new Dashboard(rs, conn);
            } else {
                JOptionPane.showMessageDialog(f, "Login Failed");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(f, e);
        }
    }

    public void register() {
        f.dispose();
        new register(conn);
    }

    void dBConn() {
        try {
            Class.forName(jdbc_driver);
            JOptionPane.showMessageDialog(f, "Connecting to the database...");
            conn = DriverManager.getConnection(dbUrl, user, pass);
            if (conn != null) {
                JOptionPane.showMessageDialog(f, "Connected to the database!");
            } else {
                JOptionPane.showMessageDialog(f, "Could not connect to the database...");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(f, "Error in connecting to the database!");
        }
    }

    ResultSet dbStmt(String sql) {
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(f, "Error in SQL Statement!" + e);
        }

        return rs;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new loginMain();
            }
        });
    }
}
