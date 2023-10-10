package Ailurus_final.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;

public class login implements ActionListener {

    final String jdbc_driver = "org.apache.derby.jdbc.ClientDriver";
    final String dbUrl = "jdbc:derby://localhost:1527/ailurusfinal";

    static final String user = "root";
    static final String pass = "root";

    JFrame f;
    JPanel mainP;
    JTextField tfUname;
    JPasswordField tfPword;
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs1 = null;
    String sql = "";
    String uname = "";
    String pword = "",cheesu;
    boolean chk = false;

    Color babypink = new Color(245, 202, 195);
    
    Color brownorange = new Color(177,61,20);
    Color whiteyellow = new Color(252,231,210);
    Color brown = new Color(52,7,1);
    Color medjred = new Color(156,26,4);
    Color nude = new Color(219,135,88);
    
    Font fonty = new Font("Cooper Black", Font.PLAIN, 30);
    Font fonty1 = new Font("Cooper Black", Font.PLAIN, 50);
    Font fonty2 = new Font("Cooper Black", Font.PLAIN, 15);
    
    int aInt;
    
    public login() {
        f = new JFrame("Login");
        mainP = new JPanel(new FlowLayout());
        mainP.setBackground(whiteyellow);
        welcomeAilurus();
        displayCenterLogin();
        showFrame();
        dBConn();
    }
    
    public void welcomeAilurus() {
        JPanel welcomeP = new JPanel();
        welcomeP.setLayout(new GridBagLayout());
        welcomeP.setPreferredSize(new Dimension(400, 490));
        welcomeP.setBackground(brownorange);

        JLabel welcomeL = new JLabel("<html><br>WELCOME<br>TO<br>AILURUS</html>");
        welcomeL.setHorizontalAlignment(JLabel.CENTER);
        welcomeL.setFont(fonty1);
        welcomeL.setForeground(Color.white);

        welcomeP.add(welcomeL);
        mainP.add(welcomeP);
    }

    public void displayCenterLogin() {

        JLabel loginL = new JLabel("Login");
        loginL.setFont(fonty);

        JPanel centerP = new JPanel(new GridBagLayout());
        centerP.setBackground(whiteyellow);
        GridBagConstraints cst = new GridBagConstraints();
        cst.insets = new Insets(5, 0, 5, 5);

        JLabel lblUname = new JLabel("Username");
        JLabel lblPword = new JLabel("Password");
        tfUname = new JTextField();
        tfPword = new JPasswordField();
        
//        tfUname.setText("c11");
//        tfPword.setText("4");

        tfUname.setPreferredSize(new Dimension(200, 30));
        tfPword.setPreferredSize(new Dimension(200, 30));

        JLabel notyetL = new JLabel("<html><br>----------------------------------------------------------------------" + "<br><br><br>Don't have an account yet?" + "<br><br>   </html>");
        notyetL.setFont(fonty2);

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
        loginB.setBackground(nude);
        loginB.setForeground(Color.white);
        loginB.setPreferredSize(new Dimension(100, 45));
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
        regB.setBackground(nude);
        regB.setForeground(Color.white);
        regB.setPreferredSize(new Dimension(100, 75));
        
        regB.addActionListener(this);
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 5;
        centerP.add(regB, cst);

        mainP.add(centerP);
    }

    public void showFrame() {
        f.setSize(730, 550);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        //f.setResizable(false);
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
        dbStmt("Select * from TBL_USERS Where username='" + tfUname.getText() + "' AND password= '" + tfPword.getText() + "'");
        try {
            if (rs1.next()) {
                f.dispose();
                if (rs1.getInt("ustype") == 1) {
                    aInt = rs1.getInt("account_num");
                    System.out.println("account number in login: " + aInt);
                    new adminDashboard(rs1, conn);
                } if (rs1.getInt("ustype") == 2) {
                    new managerDashboard(rs1, conn);
                    aInt = rs1.getInt("account_num");
                    System.out.println("account number in login: " + aInt);
                }
                  if (rs1.getInt("ustype") == 3) {
                      aInt = rs1.getInt("account_num");
                    System.out.println("account number in login: " + aInt);
                    new workerDashboard(rs1, conn);System.out.println("hey jude 15");}    
                 if(rs1.getInt("ustype") == 4){
                     aInt = rs1.getInt("account_num");
                    System.out.println("account number in login: " + aInt);
                    new userDashboard(rs1, conn, aInt);
                }
            } else {
                JOptionPane.showMessageDialog(f, "Login Failed");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(f, e);
        }
    }

    public void register() {
        f.dispose();
        cheesu = "kek";
        new Register(conn,cheesu);
    }

    void dBConn() {
        try {
            Class.forName(jdbc_driver);
            //JOptionPane.showMessageDialog(f, "Connecting to the database...");
            conn = DriverManager.getConnection(dbUrl, user, pass);
            if (conn != null) {
                //JOptionPane.showMessageDialog(f, "Connected to the database!");
            } else {
                JOptionPane.showMessageDialog(f, "Could not connect to the database...");
            }
        } catch (Exception e) {
           // JOptionPane.showMessageDialog(f, "Error in connecting to the database!");
        }
    }

    ResultSet dbStmt(String sql) {
        try {
            stmt = conn.createStatement();
            rs1 = stmt.executeQuery(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(f, "Error in SQL Statement!" + e);
        }
        return rs1;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new login();
            }
        });
    }
}