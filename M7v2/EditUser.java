import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class EditUser implements ActionListener {

    public EditUser(ResultSet rs1, Connection conn, String slot) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                showFrame(slot);
                con = conn;
                rs = rs1;
                userslot = slot;
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
    Font fonty = new Font("Cooper Black", Font.PLAIN, 20);

    Connection con;
    Statement st;
    ResultSet rs = null;
    String userslot;

    void showFrame(String userslot) {
        f = new JFrame("Edit User Information");
        mainP = new JPanel(new BorderLayout());

        displayCenterRegister(userslot);

        f.setSize(500, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.add(mainP);
        f.setVisible(true);;
    }

    void displayCenterRegister(String userslot) {
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
            Connection con2 = DriverManager.getConnection("jdbc:derby://localhost:1527/anadawan", "root", "root");
            Statement st2 = con2.createStatement();
            ResultSet rs2 = st2.executeQuery("SELECT * FROM tbl_user where username = '" + userslot + "'");

            while (rs2.next()) {
                unameTF.setText(rs2.getString("Username"));
                fullnameTF.setText(rs2.getString("Fullname"));
                us_type = rs2.getInt("us_type");
                passPF.setText(rs2.getString("Password"));

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(f, ex);
        }

        JButton clearB = new JButton("Clear");
        clearB.setPreferredSize(new Dimension(150, 50));
        clearB.addActionListener(this);

        JButton updateB = new JButton("Update");
        updateB.setPreferredSize(new Dimension(150, 50));
        updateB.addActionListener(this);

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

        //edit user
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

        //clear
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 8;
        centerP.add(clearB, cst);

        //submit
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 2;
        cst.gridy = 8;
        centerP.add(updateB, cst);

        mainP.add(centerP);
    }

    ResultSet dbStmt(String sql) {
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(f, "Error in SQL Statement!" + e);
        }
        return rs;
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
                break;

            case "Update":
                if (unameTF.getText().toString().isEmpty()
                        || fullnameTF.getText().toString().isEmpty()
                        || passPF.getText().toString().isEmpty()
                        || UTypebox.getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(f, "There is an error here.");
                } else {
                    try {
                        
                        JOptionPane.showMessageDialog(f, userslot);
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate("Update tbl_user set username= '" + unameTF.getText() + "', fullname= '"
                                + unameTF.getText().toString() + "', password = '" + unameTF.getText().toString()
                                + "' where username = '" + userslot + "'");
                        JOptionPane.showMessageDialog(f, "Updated Successfully!");
                        f.dispose();
                        new loginMain();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(f, e);
                    }
                }

                break;
        }
    }
}
