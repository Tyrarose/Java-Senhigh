
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dashboard implements ActionListener {

    public Dashboard(ResultSet rs1, Connection conn) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                showFrame(rs1);
                con = conn;
            }
        });
    }
    JFrame f;
    JPanel adminMP, userMP;
    JLabel name;
    JComboBox userListB;

    Connection con, con2;
    Statement stmt;
    ResultSet rs1;
    ResultSet rs;

    Color babypink = new Color(245, 202, 195);
    Font fonty = new Font("Cooper Black", Font.PLAIN, 30);

    public void showFrame(ResultSet rs1) {
        try {
            if (rs1.getInt("us_type") == 1) {
                f = new JFrame("Admin Dashboard");
                adminMP = new JPanel(new BorderLayout());

                displayCenterAdmin(rs1.getString("username"));

                f.setSize(500, 300);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setLocationRelativeTo(null);
                f.add(adminMP);
                f.setVisible(true);
            } else {
                f = new JFrame("User Dashboard");
                userMP = new JPanel(new BorderLayout());

                displayCenterUser(rs1.getString("username"));

                f.setSize(500, 300);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setLocationRelativeTo(null);
                f.add(userMP);
                f.setVisible(true);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(f, "Error in SQL Statement !" + ex);
        }
    }

    public void displayCenterAdmin(String username) {
        JPanel headerP = new JPanel();
        JLabel lbl = new JLabel("Welcome " + username);
        lbl.setFont(new Font("Consolas", Font.BOLD, 30));
        lbl.setForeground(Color.white);
        headerP.setBackground(Color.BLACK);
        headerP.add(lbl);
        adminMP.add(headerP, BorderLayout.PAGE_START);

        JPanel admincenterP = new JPanel(new GridBagLayout());
        admincenterP.setBackground(babypink);
        GridBagConstraints cst = new GridBagConstraints();
        cst.insets = new Insets(5, 0, 5, 5);

        JButton backB = new JButton("Back");
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 0;
        admincenterP.add(backB, cst);

        backB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new loginMain();
            }
        }
        );

        JButton addB = new JButton("Add User");
        addB.setPreferredSize(new Dimension(200, 50));
        addB.addActionListener(this);

        JButton updateB = new JButton("Update User");
        updateB.setPreferredSize(new Dimension(200, 50));
        updateB.addActionListener(this);

        //add
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 1;
        cst.gridy = 1;
        admincenterP.add(addB, cst);

        //uupdate
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 1;
        cst.gridy = 2;
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

        JButton backB = new JButton("Back");
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 0;
        usercenterP.add(backB, cst);

        JLabel space = new JLabel(" ");
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 1;
        cst.gridy = 1;
        usercenterP.add(space, cst);

        JLabel hiL = new JLabel("<html><br>Hi user!<br>");
        hiL.setFont(fonty);
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 5;
        cst.gridy = 1;
        usercenterP.add(hiL, cst);

        backB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new loginMain();
            }
        }
        );

        userMP.add(usercenterP);
    }

    public void updateuser(ResultSet rs1) throws SQLException {
        f.dispose();
        f = new JFrame("Update User");
        adminMP = new JPanel(new BorderLayout());

        JPanel updateP = new JPanel(new GridBagLayout());
        updateP.setBackground(babypink);
        GridBagConstraints cst = new GridBagConstraints();
        cst.insets = new Insets(5, 0, 5, 5);

        JButton backB = new JButton("Back");
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 0;
        updateP.add(backB, cst);

        backB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                 new loginMain();
                //try {
                    JOptionPane.showMessageDialog(f, "");
                    //displayCenterAdmin(rs1.getString("username"));
                //} catch (SQLException ex) {
                   // JOptionPane.showMessageDialog(f, "dito 6 Error in SQL Statement !" + ex);
                //}
            }
        }
        );

        JLabel unameL = new JLabel("Username");
        userListB = new JComboBox();

        stmt = con.createStatement();
        rs = stmt.executeQuery("select username from tbl_user");
        while (rs.next()) {
            userListB.addItem(rs.getString("username"));
        }

        JButton deleteB = new JButton("Delete User");
        deleteB.setPreferredSize(new Dimension(200, 50));
        deleteB.setEnabled(false);

        JButton editB = new JButton("Edit User");
        editB.setPreferredSize(new Dimension(200, 50));
        editB.setEnabled(false);

        JLabel slotL = new JLabel("PLEASE SELECT A USER FIRST");
        JButton selectB = new JButton("Select this user");
        selectB.setPreferredSize(new Dimension(100, 25));

        selectB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String slot = userListB.getSelectedItem().toString();

                slotL.setText("You have selected User:    " + slot);
                deleteB.setEnabled(true);
                editB.setEnabled(true);

                editB.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        f.dispose();
                        new EditUser(rs, con, slot);
                    }
                }
                );

                deleteB.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int dialogResult = JOptionPane.showConfirmDialog(f, "Are you sure you want to delete this account?", "Delete Account", 0);
                        if (dialogResult == JOptionPane.YES_OPTION) {
                            try {
                                stmt.executeUpdate("DELETE FROM tbl_user where username = '" + slot + "'");
                                JOptionPane.showMessageDialog(f, "Deleted!");
                                //jcombobox sana updated
                            } catch (Exception ex) {
                                System.out.println(ex);
                                JOptionPane.showMessageDialog(f, ex);
                            }
                        }
                    }
                }
                );

            }
        }
        );

        JLabel space = new JLabel(" ");
        JLabel space2 = new JLabel(" ");


        //title label
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 1;
        updateP.add(unameL, cst);

        //user combobox
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 2;
        updateP.add(userListB, cst);

        //select this user
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 2;
        cst.gridy = 2;
        updateP.add(selectB, cst);

        //space
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 3;
        updateP.add(space, cst);

        //selected user show Label
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 4;
        updateP.add(slotL, cst);

        //space
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 5;
        updateP.add(space2, cst);

        //edit
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 6;
        updateP.add(editB, cst);

        //delete
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 2;
        cst.gridy = 6;
        updateP.add(deleteB, cst);

        adminMP.add(updateP);

        f.setSize(500, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.add(adminMP);
        f.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {

            String action = ae.getActionCommand();
            switch (action) {
                case "Add User":
                    f.dispose();
                    new register(con);
                    break;
                case "Update User":
                    updateuser(rs);
                    break;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(f, "Error in SQL Statement !" + ex);
        }
    }
}