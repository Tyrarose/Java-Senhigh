package Ailurus_final.src;

//WORKER DASHBOARD

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class workerDashboard implements ActionListener {

    JButton out, in, back;
    JButton accountsettings;
    JButton sales, receipts, inventory;
    JButton save;
    JTable jt;
    JScrollPane sp, sw;
    JFrame f;
    JPanel panel;
    JPanel panel1;
    JPanel panel2;
    JPanel panel3;
    JPanel panel5;
    JLabel lbl = new JLabel("Sige Edit");
    JPanel mPanel;
    Container con;
    DefaultTableModel model;
    Statement st;
    Statement st2, st3;
    ResultSet rc = null;

    GridBagConstraints gbc;

    String a = null, b = null;

    JLabel unl = new JLabel("Username: ");
    JTextField un = new JTextField();
    JLabel pwl = new JLabel("Password: ");
    JTextField pw = new JPasswordField();

    String data[][];

    ResultSet rs;
    ResultSet rs2;
    ResultSet rs3;
    Connection conn;

    JPanel Receipt;
    JLabel rnl = new JLabel("Enter Receipt Number: ");
    JTextField rn;
    JButton rnb = new JButton("Enter");
    JPanel rpanel;
    JPanel panel51;
    JPanel jp;
    JScrollPane scrollPane, js;
    int i, num;
    Connection con1;
    JPanel[] itemsArrayP, pictureP, panel4;
    JButton[] addCartB, detailsB, plus, minus, details;
    JTextField[] useData;
    ArrayList[] names;
    Color babypink = new Color(245, 202, 195);
    JLabel[] newlabel, productName, productPrice;
    GridBagConstraints gc = new GridBagConstraints();
    String srn;

    workerDashboard(ResultSet rs1, Connection conn) {
        //addActionListener();
        elements();
        left();
        addActionListener();
        //shop();
        displayFrame();
        this.rs = rs1;
        this.conn = conn;

    }

    public void elements() {
        System.out.println("hey jude 16");
        out = new JButton("Log-out");
        in = new JButton("Log-in");
        accountsettings = new JButton("Account Settings");
        receipts = new JButton("Receipts");
        inventory = new JButton("Inventory Report");
        sales = new JButton("Sales Report");
        f = new JFrame("Ailurus");
        mPanel = new JPanel(new BorderLayout());
        back = new JButton("Back");
        panel51 = new JPanel();

        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel(new GridBagLayout());
        panel5 = new JPanel();

        con = f.getContentPane();
        panel = new JPanel();
        panel.setBounds(180, 10, 800, 500);
        panel.setBackground(Color.white);
        mPanel.add(panel);
        con.add(panel);

        save = new JButton("Save");

        jp = new JPanel();
        js = new JScrollPane(jp,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        panel5 = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        rn = new JTextField();
        rpanel = new JPanel(new BorderLayout());
    }

    public void addActionListener() {
        out.addActionListener(this);
        in.addActionListener(this);
        accountsettings.addActionListener(this);
        sales.addActionListener(this);
        receipts.addActionListener(this);
        inventory.addActionListener(this);
        save.addActionListener(this);
        rnb.addActionListener(this);

    }

    public void left() {
        receipts.setBounds(50, 90, 100, 30);
        inventory.setBounds(50, 130, 120, 30);
        sales.setBounds(50, 170, 120, 30);
        accountsettings.setBounds(50, 210, 100, 30);
        out.setBounds(50, 250, 100, 30);
        con.add(receipts);
        con.add(inventory);
        con.add(sales);
        con.add(accountsettings);
        con.add(out);
    }

    public void sale() {

        panel1.removeAll();
        panel2.removeAll();
        panel3.removeAll();
        panel5.removeAll();

        try {
            st2 = conn.createStatement();
            String check = "Select * from TBL_Products";
            rs3 = st2.executeQuery(check);
            jt = new JTable();
            model = new DefaultTableModel(new String[]{"Product Name", "Product Type", "Number of Sold", "Sold Price"}, 0);
            while (rs3.next()) {
                String np = rs3.getString("Name_of_product");
                String tp = rs3.getString("product_type");
                String ns = String.valueOf(rs3.getDouble("sold_price"));
                String sp = rs3.getString("num_of_sold");
                model.addRow(new Object[]{np, tp, sp, ns});
            }
            jt.setModel(model);
            jt.setEnabled(false);
            jt.setPreferredSize(new Dimension(1000, 800));
            sw = new JScrollPane(jt);
            panel3.add(sw);
            panel.add(panel3);

        } catch (SQLException ex) {
            System.out.println("hey1");
            Logger.getLogger(managerDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void inventory() {
        panel.remove(panel51);
        panel1.removeAll();
        panel2.removeAll();
        panel3.removeAll();
        panel5.removeAll();
        panel51.remove(js);

        try {
            st2 = conn.createStatement();
            String check = "Select * from TBL_Products";
            rs3 = st2.executeQuery(check);
            jt = new JTable();
            model = new DefaultTableModel(new String[]{"Product Name", "Product Type", "Price", "Stock"}, 0);
            while (rs3.next()) {
                String pn = rs3.getString("Name_of_product");
                String pt = rs3.getString("product_type");
                String pr = String.valueOf(rs3.getDouble("price"));
                String s = rs3.getString("stock");
                model.addRow(new Object[]{pn, pt, pr, s});
            }
            jt.setModel(model);
            jt.setEnabled(false);
            jt.setPreferredSize(new Dimension(1000, 800));
            sp = new JScrollPane(jt);
            panel3.add(sp);
            panel.add(panel3);
        } catch (SQLException ex) {
            System.out.println("hey12");
            Logger.getLogger(managerDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void prereceipt() {
        panel.remove(panel51);
        panel51.remove(js);
        panel.remove(panel1);

        panel1.removeAll();
        panel2.removeAll();
        panel3.removeAll();
        panel5.removeAll();

        panel.setBackground(Color.white);

        gbc.insets = new Insets(5, 2, 5, 5);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel5.add(rnl, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel5.add(rn, gbc);
        rn.setPreferredSize(new Dimension(200, 25));
        // srn = Integer.parseInt(rn.getText());
        

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 1;
        panel5.add(rnb, gbc);

        rpanel.add(panel5, BorderLayout.PAGE_START);

        panel.add(rpanel);

    }

    public void postreceipt() {
        // panel.remove(panel51);
        panel1.removeAll();
        panel2.removeAll();
        panel3.removeAll();
        panel5.removeAll();
        //panel51.remove(js);
        // panel51 = new JPanel();
        panel.remove(rpanel);
        panel.setBackground(Color.gray);
        ///panel51.setPreferredSize(new Dimension(800, 1000));
        jp.setPreferredSize(new Dimension(800, 1000));
        js.setPreferredSize(new Dimension(800, 500));
        panel51.add(js);
        try {
            Statement st2 = conn.createStatement();
            ResultSet rs3 = st2.executeQuery("SELECT * FROM TBL_PRODUCTS");

            ResultSetMetaData rsmd = rs3.getMetaData();

            num = 0;
            ArrayList<String> names = new ArrayList<>(10);
            ArrayList<String> price = new ArrayList<>(10);
            while (rs3.next()) {
                names.add(rs3.getString("NAME_OF_PRODUCT"));
                price.add(rs3.getString("PRICE"));
                num += 1;
            }

            itemsArrayP = new JPanel[num];
            panel4 = new JPanel[num];
            pictureP = new JPanel[num];
            addCartB = new JButton[num];
            details = new JButton[num];
            detailsB = new JButton[num];
            plus = new JButton[num];
            minus = new JButton[num];
            productName = new JLabel[num];
            productPrice = new JLabel[num];
            int i;

            for (i = 0; i < num; i++) {

                panel4[i] = new JPanel(new GridBagLayout());
                itemsArrayP[i] = new JPanel();
                itemsArrayP[i].setPreferredSize(new Dimension(250, 250));
                jp.add(itemsArrayP[i], BorderLayout.CENTER);

                pictureP[i] = new JPanel();
                pictureP[i].setPreferredSize(new Dimension(100, 100));
                pictureP[i].setBackground(babypink);
                //itemsArrayP[i].add(pictureP[i]); 
                gc.gridx = 0;
                gc.gridy = 0;
                panel4[i].add(pictureP[i], gc);

                productName[i] = new JLabel("" + names.get(i));
                gc.gridx = 0;
                gc.gridy = 2;

                panel4[i].add(productName[i], gc);
                itemsArrayP[i].add(panel4[i]);

                productPrice[i] = new JLabel("<html><br>" + price.get(i) + "<br>");
                gc.gridx = 0;
                gc.gridy = 3;
                panel4[i].add(productPrice[i], gc);
                //itemsArrayP[i].add(productPrice[i]);

                addCartB[i] = new JButton("Add to Cart");
                addCartB[i].setPreferredSize(new Dimension(100, 25));

                addCartB[i].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // for ( i = i; i < num; i++){
                        //for(i=i; i< num; i++)
                        //  JOptionPane.showMessageDialog(f, "Added to cartu" + i--);
                        //   }
                    }
                }
                );
                gc.insets = new Insets(0, 2, 0, 2);
                gc.gridx = 0;
                gc.gridy = 4;
                //gc.weighty = 2;
                panel4[i].add(addCartB[i], gc);
                // itemsArrayP[i].add(addCartB[i]);
                // for( i = 0; i < num; i++)
                {

                }
                detailsB[i] = new JButton("Details");
                detailsB[i].setPreferredSize(new Dimension(100, 25));
                detailsB[i].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // for(i=0; i<=num; i++)
                        //   JOptionPane.showMessageDialog(f, "Details" + i);
                    }
                }
                );
                /*  for( int a = 0; a < num; a++)
                {
                    detailsB[a].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                       // for(i=0; i<=num; i++)
                        JOptionPane.showMessageDialog(f, "Details" + i);
                    }
                    
                }
                );
                }*/
                gc.gridx = 0;
                gc.gridy = 5;
                panel4[i].add(detailsB[i], gc);

                //for(int n=1000; n) int n = 50;
                // jp.setPreferredSize(new Dimension(800, 1000));
                plus[i] = new JButton("+");
                plus[i].setPreferredSize(new Dimension(50, 20));
                gc.gridx = 0;
                gc.gridy = 1;
                //panel4[i].add(plus[i], gc);

                minus[i] = new JButton("-");
                minus[i].setPreferredSize(new Dimension(50, 20));
                gc.gridx = 1;
                gc.gridy = 1;
                // panel4[i].add(minus[i], gc);

            }
//            panel2.add(items);
//            panel2.add(dt);
//            panel2.add(qt);
//            panel2.add(plus);
//            panel2.add(n);
//            panel2.add(minus);
//            panel2.add(total);
//            panel2.add(purchase);
            Statement st3 = conn.createStatement();
            srn = rn.getText();
            System.out.println("HERE     " + srn  + " ditech");
            String check = "Select * from TBL_Receipt WHERE receipt_no = "+srn;
            rs2 = st3.executeQuery(check);
            jt = new JTable();
            model = new DefaultTableModel(new String[]{"Receipt_no", "ACCOUNT_NUM", "PRODUCTS", "PRICE", "CHECK_OUT", "STATUS", "ADDRESS", "CARD_NUM"}, 0);
            while (rs2.next()) {
                String rn = String.valueOf(rs2.getInt("Receipt_no"));
                String an = rs2.getString(rs2.getInt("ACCOUNT_NUM"));
                String pro = rs2.getString("PRODUCTS");
                String pr = String.valueOf(rs2.getDouble("price"));
                String chk = rs2.getString("Check_out");
                String stat = rs2.getString("status");
                String add = rs2.getString("address");
                String crd = String.valueOf(rs2.getInt("card_num"));
                model.addRow(new Object[]{rn, an, pro, pr, chk, stat, add, crd});
            }
            jt.setModel(model);
            jt.setEnabled(false);
            jt.setPreferredSize(new Dimension(1000, 800));
            sp = new JScrollPane(jt);
            panel3.add(sp);
            panel.add(panel3);

        } catch (Exception e) {
            System.out.println("hey13");
            JOptionPane.showMessageDialog(f, e);
        }
        //rpanel.add(panel51,BorderLayout.CENTER);
        panel.add(panel51);

    }

    public void out() {
        f.dispose();
        new login();

    }

    public void accountsettings() {
        panel.remove(panel51);
        panel51.remove(js);
        panel.remove(rpanel);
        panel1.removeAll();
        panel2.removeAll();
        panel3.removeAll();
        panel5.removeAll();

        panel.setBackground(Color.white);

        panel5 = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 2, 5, 5);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel5.add(unl, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel5.add(un, gbc);
        un.setPreferredSize(new Dimension(200, 25));

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel5.add(pwl, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel5.add(pw, gbc);
        pw.setPreferredSize(new Dimension(200, 25));

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel5.add(save, gbc);

        try {
            st = conn.createStatement();

            a = rs.getString("username");
            b = rs.getString("password");
            un.setText(a);
            pw.setText(b);
        } catch (Exception ex) {
            System.out.println("hey14");
            ex.printStackTrace();
        }

        this.panel.add(panel5);

    }

    public void save() {
        try {
            //input to register
            st2 = conn.createStatement();
            String check = "Select * from TBL_users";
            rs3 = st2.executeQuery(check);
            while (rs3.next()) {
                if (!a.equals(rs3.getString("username"))) {
                    st.executeUpdate("Update TBL_USERS set username = '" + un.getText() + "' , password = '" + pw.getText() + "' where username = '" + a + "'");
                    JOptionPane.showMessageDialog(f, "Succesful");
                }
                left();
                displayFrame();
                break;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(f, "Username has already been taken \\n Try Again ");
        }

    }

    public void displayFrame() {

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1000, 700);
        f.setLocationRelativeTo(null);
        f.add(mPanel);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        switch (action) {
            case "Receipts":
                prereceipt();
                displayFrame();
                break;
            case "Sales Report":
                sale();
                displayFrame();
                break;
            case "Inventory Report":
                inventory();
                displayFrame();
                break;
            case "Account Settings":
                accountsettings();
                displayFrame();
                break;
            case "Log-out":
                out();
                break;
            case "Save":
                save();
                break;
            case "Enter":
                postreceipt();
                break;
        }
    }

}
