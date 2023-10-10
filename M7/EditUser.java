
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class EditUser implements ActionListener {

    public EditUser(ResultSet rs, Connection conn) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
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
    Font fonty = new Font("Cooper Black", Font.PLAIN, 30);

    Connection con;
    Statement st;
    ResultSet rs = null;

    void showFrame() {
        f = new JFrame("Edit User Information");
        mainP = new JPanel(new BorderLayout());

        displayCenterRegister();

        f.setSize(400, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.add(mainP);
        f.setVisible(true);;
    }

    void displayCenterRegister() {
        JPanel centerP = new JPanel(new GridBagLayout());
        centerP.setBackground(babypink);
        GridBagConstraints cst = new GridBagConstraints();
        cst.insets = new Insets(5, 0, 5, 5);

        JButton backB = new JButton("Back");
        backB.setPreferredSize(new Dimension(100, 25));
        backB.addActionListener((ActionListener) this);

        JLabel regisL = new JLabel("Edit User Information");
        regisL.setFont(fonty);

        JLabel space = new JLabel(" ");
        JLabel unameL = new JLabel("Username");
        JLabel fullnameL = new JLabel("Fullname");
        JLabel lblUType = new JLabel("Usertype");
        UTypebox = new JComboBox(utypes);
        JLabel passL = new JLabel("Password");
        JLabel cpassL = new JLabel("Confirm password");
        int us_type;

        unameTF = new JTextField();
        fullnameTF = new JTextField();
        passPF = new JPasswordField();
        cpassPF = new JPasswordField();

        unameTF.setPreferredSize(new Dimension(200, 25));
        fullnameTF.setPreferredSize(new Dimension(200, 25));
        passPF.setPreferredSize(new Dimension(200, 25));
        cpassPF.setPreferredSize(new Dimension(200, 25));

        try {
            unameL.setText(rs.getString("Username"));
            fullnameL.setText(rs.getString("Fullname"));
            lblUType.setText(rs.getString("Usertype"));
            passL.setText(rs.getString("Password"));
            us_type = rs.getInt("us_type");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(f, ex.getMessage());
        }

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

        //user type
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 5;
        centerP.add(lblUType, cst);

        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 2;
        cst.gridy = 5;
        centerP.add(UTypebox, cst);

        //password
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 6;
        centerP.add(passL, cst);
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 2;
        cst.gridy = 6;
        centerP.add(passPF, cst);

        //confirm password
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 7;
        centerP.add(cpassL, cst);
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 2;
        cst.gridy = 7;
        centerP.add(cpassPF, cst);

        mainP.add(centerP);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        String action = ae.getActionCommand();
        switch (action) {
            case "Back":
                f.dispose();
                new loginMain();
                break;
            case "Clear":
                unameTF.setText(null);
                fullnameTF.setText(null);
                passPF.setText(null);
                //cpassPF.setText(null);
                break;

            case "Submit":
                if (unameTF.getText().toString().isEmpty()
                        || fullnameTF.getText().toString().isEmpty()
                        || passPF.getText().toString().isEmpty()
                        || UTypebox.getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(f, "There is an error here.");
                } else {
                    register(unameTF.getText().toString(), fullnameTF.getText().toString(), passPF.getText().toString(), UTypebox.getSelectedIndex() + 1);
                }
                break;
        }
    }

    void register(String uname, String fullname, String txtpword, int utype) {
//        //Un - comment to check db connection
//        try {
//            Class.forName(jdbc_driver);
//            //JOptionPane.showMessageDialog(f, "Connecting to the database...");
//            Connection conn = DriverManager.getConnection(dbUrl,user,pass);
//            if (conn != null) {
//                JOptionPane.showMessageDialog(f, "Connected to the database!");
//            } else {
//                //JOptionPane.showMessageDialog(f, "Could not connect to the database...");
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(f, "dito 1 Error in connecting to the database!");
//        }
//        
//        try {
//            st = con.createStatement();
//            st.executeUpdate("INSERT INTO tbl_user(username, password, fullname, us_type) VALUES('" + uname + "', '" + txtpword + "'  ,'" + fullname + "'  ," + utype + "  )");
//            JOptionPane.showMessageDialog(f, "Successfully Registered !");
//            f.dispose();
//            new loginMain();
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(f, "dito 2 Error in SQL Statement !" + e);
//        }
    }

    public void theQuery(String query) {
        Connection con = null;
        Statement st = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/test_db", "root", "");
            st = con.createStatement();
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Query Executed");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void deleteuser() throws SQLException {
        try {
            theQuery("delete from users where id = " + unameTF.getText());
        } catch (Exception e) {
        }
    }

}
