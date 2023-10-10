
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dashboard implements ActionListener {

    final String jdbc_driver = "org.apache.derby.jdbc.ClientDriver";
    final String dbUrl = "jdbc:derby://localhost:1527/anadawan";

    static final String user = "root";
    static final String pass = "root";

    public Dashboard(ResultSet rs, Connection conn) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                showFrame(rs);
            }
        });
    }
    JFrame f;
    JPanel adminMP, userMP;
    JLabel name;
    JComboBox userListB;
    //users from db
    String[] usersList = {"Admin", "User"};

    Connection conn;
    Statement stmt;
    ResultSet rs = null;

    Color babypink = new Color(245, 202, 195);
    Font fonty = new Font("Cooper Black", Font.PLAIN, 30);

    public void showFrame(ResultSet rs) {
        try {
            //dapat lahat ng admin sql statement
            if (rs.getInt("us_type") == 1) {

                f = new JFrame("Admin Dashboard");
                adminMP = new JPanel(new BorderLayout());

                displayCenterAdmin(rs.getString("username"));

                f.setSize(500, 300);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setLocationRelativeTo(null);
                f.add(adminMP);
                f.setVisible(true);
            } else {
                f = new JFrame("User Dashboard");
                userMP = new JPanel(new BorderLayout());

                displayCenterUser(rs.getString("username"));

                f.setSize(500, 300);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setLocationRelativeTo(null);
                f.add(userMP);
                f.setVisible(true);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void displayCenterAdmin(String username) {
        JPanel panel = new JPanel();
        JLabel lbl = new JLabel("Welcome " + username);
        lbl.setFont(new Font("Consolas", Font.BOLD, 30));
        lbl.setForeground(Color.white);
        panel.setBackground(Color.BLACK);
        panel.add(lbl);
        adminMP.add(panel, BorderLayout.PAGE_START);

        JPanel admincenterP = new JPanel(new GridBagLayout());
        admincenterP.setBackground(babypink);
        GridBagConstraints cst = new GridBagConstraints();
        cst.insets = new Insets(5, 0, 5, 5);

        JButton addB = new JButton("Add User");
        addB.setPreferredSize(new Dimension(200, 50));
        addB.addActionListener(this);

        JButton updateB = new JButton("Update User");
        updateB.setPreferredSize(new Dimension(200, 50));
        updateB.addActionListener(this);

        //add
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 0;
        admincenterP.add(addB, cst);

        //uupdate
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 1;
        admincenterP.add(updateB, cst);

        adminMP.add(admincenterP);
    }

    public void displayCenterUser(String username) {
        JPanel panel = new JPanel();
        JLabel lbl = new JLabel("Welcome " + username);
        lbl.setFont(new Font("Consolas", Font.BOLD, 30));
        lbl.setForeground(Color.white);
        panel.setBackground(Color.BLACK);
        panel.add(lbl);
        userMP.add(panel, BorderLayout.PAGE_START);

        JPanel usercenterP = new JPanel(new GridBagLayout());
        usercenterP.setBackground(babypink);
        GridBagConstraints cst = new GridBagConstraints();
        cst.insets = new Insets(5, 0, 5, 5);

        JLabel hiL = new JLabel("Hi user!");
        hiL.setFont(fonty);
        usercenterP.add(hiL);

        userMP.add(usercenterP);
    }

//    public void adduser() {
//        f = new JFrame("Add User");
//        adminMP = new JPanel(new BorderLayout());
//
//        f.dispose();
//        new register(con2, st2);
//
//        f.setSize(500, 300);
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.setLocationRelativeTo(null);
//        f.add(adminMP);
//        f.setVisible(true);
//
//    }
//    void adduser() {
//        try {
//            Class.forName(jdbc_driver);
//            JOptionPane.showMessageDialog(f, "Connecting to the database...");
//            con2 = DriverManager.getConnection(dbUrl, user, pass);
//            if (con2 != null) {
//                JOptionPane.showMessageDialog(f, "Connected to the database!");
//            } else {
//                JOptionPane.showMessageDialog(f, "Could not connect to the database...");
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(f, "Error in connecting to the database!");
//        }
//    }  
    public void updateuser() throws SQLException {
        f = new JFrame("Update User");
        adminMP = new JPanel(new BorderLayout());

        JPanel updateP = new JPanel(new GridBagLayout());
        updateP.setBackground(babypink);
        GridBagConstraints cst = new GridBagConstraints();
        cst.insets = new Insets(5, 0, 5, 5);

        JLabel unameL = new JLabel("Username");
        userListB = new JComboBox();

        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/anadawan", "root", "root");
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select username from tbl_user");
        while (rs.next()) {
            userListB.addItem(rs.getString("username"));
        }
        rs.close();
        stmt.close();
        conn.close();

        JLabel space = new JLabel(" ");

        JButton editb = new JButton("Edit User");
        editb.setPreferredSize(new Dimension(200, 50));

        editb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    f.dispose();
                    new EditUser(rs, conn);
                } catch (Exception ex) {
                }
            }
        }
        );

        JButton deleteB = new JButton("Delete User");
        deleteB.setPreferredSize(new Dimension(200, 50));
        deleteB.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    //theQuery("delete from users where id = " + userListB.getSelected.getText());
                } catch (Exception ex) {
                }
            }
        }
        );

        //select user label
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 0;
        updateP.add(unameL, cst);

        //select user
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 1;
        updateP.add(userListB, cst);

        //space
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 2;
        updateP.add(space, cst);

        //edit
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 3;
        updateP.add(editb, cst);

        //delete
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 2;
        cst.gridy = 3;
        updateP.add(deleteB, cst);

        adminMP.add(updateP);

        f.setSize(500, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.add(adminMP);
        f.setVisible(true);

    }

//    public void edituser() throws SQLException {
//        try {
//            String users = (String) userListB.getSelectedItem();
//            String sql = "update username from tbl_users where username = " +;
//
//            stmt = conn.prepareStatement(sql);
//            stmt.setString(1, users);
//            rs = stmt.executeQuery();
//
//        } catch (Exception e) {
//        }
//    }
    public void theQuery(String query) {
        Connection con = null;
        Statement st = null;
        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/anadawan", "root", "root");
            st = con.createStatement();
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Query Executed");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        try {

            String action = ae.getActionCommand();
            switch (action) {

                case "Add User":
                    //add user back to regis but not adding may erroe null pointer due to connection
//                    f.dispose();
//                    register regis = new register(conn, stmt);
                    break;
                case "Update User":
                    //show data in regis with data
                    updateuser();
                    break;
                case "Edit User":
                    try {
                        theQuery("delete from users where id = " + register.unameTF.getText());
                    } catch (Exception ex) {
                    }
                    break;
                case "Delete User":
                    try {
                        theQuery("DELETE FROM ROOT.TBL_USER WHERE USER_ID = 12;");

                    } catch (Exception ex) {
                    }
                     {
//                try {
//                    stmt = conn.createStatement();
//                    ResultSet rs = stmt.executeQuery("select username from tbl_user");
//                    while (rs.next()) {
//                        userListB.addItem(rs.getString("username"));
//                    }
//                    rs.close();
//                    stmt.close();
//
//                    conn.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
//                }
                        break;
                    }

            }

        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
