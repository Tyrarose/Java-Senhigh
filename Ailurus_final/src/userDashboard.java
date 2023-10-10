package Ailurus_final.src;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.*;

public class userDashboard implements ActionListener {

    public userDashboard(ResultSet rs1, Connection conn, int aInt) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                showFrame(rs1);
                elements();
                left();
                addActionListener();
                displayFrame();
                con1 = conn;
                rs = rs1;
                nu = aInt;
                System.out.println("account number in userdashboard: " + nu);
            }
        });
    }
    int nu;
    Connection con1;
    JButton out, in, save;
    JButton aSettings, users2, workers, managers, customers;
    JButton edit, addU, editU, delU, back;
    JButton purchase;
    JButton shop, cart, tnc, myCartB, edituser;
    String product;
    double priced;
    JFrame f;
    JPanel panel, panel2, panel3, panel1, panel5, panel7, panel70;
    JPanel mPanel, jp, jp0;
    Container con;
    JLabel items, price, qt, total, dt;
    JLabel[] newlabel, productName, productPrice, productName0, productPrice0;
    JPanel[] itemsArrayP, pictureP, panel4, panelq, itemsArrayP0, panelq0, pictureP0;
    JButton[] addCartB, detailsB, plus, minus, details, addCartB0, detailsB0, details0;
    JTextField[] useData;
    ArrayList[] names;
    int count;
    String name;
    Color babypink = new Color(245, 202, 195);
Statement st2; ResultSet rs2;
    ResultSet rs1;
    Connection conn;
    GridBagConstraints cst;
    JTextField n;
    String dtt;
    JTable jt;
    final String dbUrl = "jdbc:derby://localhost:1527/ailurus";
    JTable table;
    DefaultTableModel model;
    JPanel panel6 = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    GridBagConstraints c = new GridBagConstraints();
     GridBagConstraints gc = new GridBagConstraints();
    JScrollPane sp, scrollPane, js, js0;
    DefaultTableCellRenderer cellRenderer;
    JPanel panelMain = new JPanel(new BorderLayout());
    JPanel panelHead = new JPanel();
    JLabel lbl = new JLabel("Sige Edit");

    String[] utn = new String[]{"User", "Admin"};
    JLabel unl = new JLabel("Username: ");
    JTextField un = new JTextField();
    JLabel fnl = new JLabel("Fullname: ");
    JTextField fn = new JTextField();
    JLabel utl = new JLabel("UserType: ");
    JComboBox ut = new JComboBox(utn);
    JLabel pwl = new JLabel("Password: ");
    JTextField pw = new JPasswordField();
    int i, num, a, num0, i0;
    String ab; String b;
    Statement st, st3, stmt, st22, stmt0;
     ResultSet rs, rs3;
     ArrayList<String> prices, prices0;
     ArrayList<String> dts, dts0;
     ArrayList<String> nam;
    public void showFrame(ResultSet rs1) {

        mPanel = new JPanel(new BorderLayout());

        items = new JLabel("Items");
        //items.setBounds(10, 10, 10, 10);
        qt = new JLabel("Quantity");
        price = new JLabel("Price");
        total = new JLabel("Total");
        dt = new JLabel("Details");
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel70 = new JPanel();
         
    }

    public void userHeader(String username) {
        JPanel headerP = new JPanel();
        JLabel lbl = new JLabel("Welcome " + username);
        lbl.setFont(new Font("Consolas", Font.BOLD, 30));
        lbl.setForeground(Color.white);
        headerP.setBackground(Color.BLACK);
        headerP.add(lbl);
        mPanel.add(headerP, BorderLayout.PAGE_START);

    }

    public void elements() {
         save = new JButton("Save");
        out = new JButton("Log-out");
        in = new JButton("Log-in");
        users2 = new JButton("Users2");
        aSettings = new JButton("Settings");
        // aSettings.setBounds(50, 130, 100, 30);
        workers = new JButton("Workers");
        // workers.setBounds(50, 170, 100, 30);
        managers = new JButton("Managers");
        // managers.setBounds(50, 210, 100, 30);
        customers = new JButton("Customers");
        // customers.setBounds(50, 240, 100, 30);        
        edit = new JButton("Edit My Account");
        //edit.setBounds(50, 270, 100, 30);

        /////////////////////////////////////////////////////////////////////////////
        panel5 = new JPanel();
        table = new JTable();
        table.add(new JScrollPane(scrollPane));
        model = (DefaultTableModel) table.getModel();
        model.addColumn("Item");
        model.addColumn("Details");
        model.addColumn("Price");
        model.addColumn("Quantity");
        model.addColumn("Contact");

        model.addRow(new Object[]{"hey"});
        model.addRow(new Object[]{"hey", "jude", "begin", "you're", "waiting"});
        model.addRow(new Object[]{"better", "better", "better", "better", "ahhhhh"});

        model.addRow(new Object[]{"na", "na", "na", "hey", "jude"});
        table.setEnabled(false);
        /* model.addRow(new Object[0]);
         model.setValueAt(0, 0, 0);
         model.setValueAt("hi", 1, 1);
         model.setValueAt("hello", 2, 2);
         model.setValueAt("jude", 3, 3);
         model.setValueAt("jude2", 4, 4);*/

 /* for(int i = 0;i < 4; i++) {
         model.addRow(new Object[0]);
         model.setValueAt(i+1, i, 0);
         model.setValueAt("Hello", i, 1);
         model.setValueAt("Point", i, 2);
         model.setValueAt("@tutorialspoint.com", i, 3);
         model.setValueAt("123456789", i, 4);
      }*/
        table.getColumnModel().getColumn(0).setPreferredWidth(150);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);
        table.getColumnModel().getColumn(3).setPreferredWidth(150);
        table.setSize(475, 250);

        // table.setBounds(300, 100, 475, 250);
        ///////////////////////////////////////////////////////////////////////////////
        addU = new JButton("Add User");
        editU = new JButton("Edit User");
        delU = new JButton("Delete User");
        back = new JButton("Back");
        
        

        shop = new JButton("Shop");
        cart = new JButton("Cart");
        tnc = new JButton("Transactions");
        f = new JFrame("Ailurus");
        mPanel = new JPanel(new BorderLayout());

        items = new JLabel("Items");
        //items.setBounds(10, 10, 10, 10);
        qt = new JLabel("Quantity");
        price = new JLabel("Price");
        total = new JLabel("Total");
        dt = new JLabel("Details");
        n = new JTextField();
        n.setText("0");
        n.setPreferredSize(new Dimension(30, 30));
        
        panel70 = new JPanel(new BorderLayout());
        panel2 = new JPanel();
        panel3 = new JPanel(new GridBagLayout());

        purchase = new JButton("Purchase");
        purchase.setBounds(670, 460, 100, 30);

        con = f.getContentPane();
        panel = new JPanel();
        panel.setBounds(180, 10, 800, 520);
        panel.setBackground(Color.darkGray);
        mPanel.add(panel);
        con.add(panel);
        cst = new GridBagConstraints();
        cst.insets = new Insets(5, 0, 5, 5);
        cst.fill = GridBagConstraints.HORIZONTAL;

        String data[][] = {{"101", "Amit", "1", "P1000", "03-09-21"},
        {"102", "Jai", "1", "P1000", "03-02-21"},
        {"101", "Sachin", "1", "P1000", "03-01-21"}};
        String column[] = {"Order Number", "Product", "Number of Items", "Amount", "Date of Purchase"};
        jt = new JTable(data, column);
        jt.setPreferredSize(new Dimension(1100, 800));
        jt.setRowHeight(30);
        sp = new JScrollPane(jt);
       // jt.setBounds(300, 400, 500, 300);
        /////////////////////////////////////////////////////////////////////////////////
        edituser = new JButton("SAVE!");
        gbc.insets = new Insets(5, 2, 5, 5);
        //gc.insets = new Insets(5, 2, 5, 5);

        un.setPreferredSize(new Dimension(200, 25));
        fn.setPreferredSize(new Dimension(200, 25));
        pw.setPreferredSize(new Dimension(200, 25));
        
        panel7 = new JPanel();
     
        jp = new JPanel();
        js = new JScrollPane(jp,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jp0 = new JPanel();
        js0 = new JScrollPane(jp0,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    }

    public void addActionListener() {
        save.addActionListener(this);
        out.addActionListener(this);
        in.addActionListener(this);
        aSettings.addActionListener(this);
        workers.addActionListener(this);
        managers.addActionListener(this);
        customers.addActionListener(this);
        edit.addActionListener(this);
        addU.addActionListener(this);
        editU.addActionListener(this);
        delU.addActionListener(this);
        back.addActionListener(this);
        
       // details.addActionListener(this);
        purchase.addActionListener(this);
        cart.addActionListener(this);
        tnc.addActionListener(this);
        shop.addActionListener(this);
        

    }

    public void left() {
        out.setBounds(50, 290, 100, 30);
        shop.setBounds(50, 130, 100, 30);
        cart.setBounds(50, 170, 100, 30);
        tnc.setBounds(40, 210, 120, 30);
        aSettings.setBounds(50, 250, 100, 30);
        con.add(shop);
        con.add(cart);
        con.add(tnc);
        con.add(aSettings);
        //con.add(table);
        con.add(out);

    }

    public void shop() {

        //con.add(table);
        panel.remove(panel70);
        panel.remove(panelMain);
        panel.remove(panel1);
        panel.remove(panel3);
        panel.setBackground(Color.gray);
        panel2.setBackground(Color.gray);

        
        jp.setPreferredSize(new Dimension(800, 1000));      
        js.setPreferredSize(new Dimension(800, 500));
        panel2.add(js);
        try {
             st22 = con1.createStatement();
            rs3 = st22.executeQuery("SELECT * FROM TBL_PRODUCTS");

             num = 0;
            nam = new ArrayList<>(10);
            prices = new ArrayList<>(10);
            dts = new ArrayList<>();
            while (rs3.next()) {
                nam.add(rs3.getString("NAME_OF_PRODUCT"));
                prices.add(rs3.getString("PRICE"));
                dts.add(rs3.getString("Details"));
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

            for ( i = 0; i < num; i++) {
                
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

                productName[i] = new JLabel("" + nam.get(i));             
                gc.gridx = 0;
                gc.gridy = 2;
                
                panel4[i].add(productName[i], gc);
                itemsArrayP[i].add(panel4[i]);
                

                productPrice[i] = new JLabel("₱ " + prices.get(i));
                gc.gridx = 0;
                gc.gridy = 3;
                panel4[i].add(productPrice[i], gc);
                //itemsArrayP[i].add(productPrice[i]);

                addCartB[i] = new JButton("Add to Cart");
                addCartB[i].setPreferredSize(new Dimension(100, 25));
                
                 addCartB[i].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent c) {
                        for(i = 0; i<num; i++){
                        if (c.getSource() == addCartB[i]) {
                            System.out.println("hey jude 17");
                            product = "" + nam.get(i);
                            priced = Double.parseDouble(prices.get(i));
                            addedToCart(product, priced);} }}}
                );
  
                gc.gridx = 0;
                gc.gridy = 4;
                panel4[i].add(addCartB[i], gc);
                
                detailsB[i] = new JButton("Details");
                detailsB[i].setPreferredSize(new Dimension(100, 25));
                
                 detailsB[i].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent c) {
                        for(i = 0; i<num; i++){
                        if (c.getSource() == detailsB[i]) {
                            System.out.println("hey jude 18");
                            product = "" + nam.get(i);
                            dtt = dts.get(i);
                            details(product, dtt);} }}}
                );
                 gc.gridx = 0;
                gc.gridy = 5;panel4[i].add(detailsB[i], gc); 

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

        } catch (Exception e) {
            JOptionPane.showMessageDialog(f, e); System.out.println(e);
        }
        panel.add(panel2);
         
        //panel.add(panel5);
    }
    public void addedToCart(String product, double price) {
        try {
            st3 = con1.createStatement();

            //get price;                                                        '"+pid+"','"+tid+"','"+rid+"',"+tspent+",'"+des+"')");
            
            st3.executeUpdate("INSERT INTO TBL_CART(NAME_OF_PRODUCT,ACCOUNT_NUM,PRICE) VALUES('" + product + "',"+ nu +"," + price + ")"   );

            JOptionPane.showMessageDialog(f, product + " has been successfuly added to your cart!");

        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(f, e);
        }
    }
    
    public void details(String p, String d){
        try{
            JOptionPane.showMessageDialog(f,d);
        }
        catch(Exception e){}
    }
    
    public void detailss(String p){
        try{
            JOptionPane.showMessageDialog(f,"hello?");
        }
        catch(Exception e){}
    }

    public void myC() {
       // panel.remove(panel4[i]);
        //con.remove(table);
        // panel.removeAll();
        //panel2.remove(js);
      //  panel.remove(panelMain);
        panel.remove(panel3);
        panel.remove(panel2);
        panel.remove(panel5);
        panel.setBackground(Color.BLACK);
        panel.removeAll();
        panel1.add(sp);
        panel.add(panel1);
        
        

    }

    public void out() {
        f.dispose();
        new login();
    }

    public void aSettings() {
        //con.remove(table);
        //panel2.remove(js);
      //  panel.remove(panelMain);
              panel.remove(panel70);
        panel.remove(panel1);
        panel.remove(panel3);
        panel.remove(panel2);
        panel.remove(panel5);
        panel.setBackground(Color.white);
        panel3.setBackground(Color.white);

        cst.gridx = 0; cst.gridy = 1;
            panel3.add(unl,cst);
            un.setPreferredSize(new Dimension(200,25));
        cst.gridx = 1; cst.gridy = 1;
            panel3.add(un,cst);
        // panel3.add(customers, cst);

        cst.gridx = 0; cst.gridy = 2;
            panel3.add(pwl,cst);
            pw.setPreferredSize(new Dimension(200,25));
        //  panel3.add(users2, cst);

        cst.gridx = 1; cst.gridy = 2;
            panel3.add(pw,cst);
        // panel3.add(managers, cst);
            cst.gridx = 1; cst.gridy = 3;
            panel3.add(save,cst);
        try{
                st = con1.createStatement();

                    ab = rs.getString("username");
                    b = rs.getString("password");  
                    un.setText(ab);pw.setText(b); 
            }
            catch(Exception ex){ System.out.println("hey14");ex.printStackTrace();}
        panel.add(panel3);

    }
     public void save()
    {  
        try{  
            //input to register
        st2 = con1.createStatement();
        String check = "Select * from TBL_users";
        rs2 = st2.executeQuery(check);
        while(rs2.next()){
            if(!ab.equals(rs2.getString("username"))){
            st.executeUpdate("Update TBL_USERS set username = '"+un.getText()+"' , password = '"+pw.getText()+"' where username = '"+ab+"'");         
            JOptionPane.showMessageDialog(f,"Succesful");    
         }    
        left();
        displayFrame();
            break;         
        }
        }catch (Exception e){ 
        JOptionPane.showMessageDialog(f, "Username has already been taken \\n Try Again ");    
    }
        
        }

    public void displayFrame() {

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1000, 600);
        f.setLocationRelativeTo(null);
        f.add(mPanel);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        try {
            String action = ae.getActionCommand();
            switch (action) {
                case "Shop":
                    shop();
                    displayFrame();
                    break;
                case "Transactions":
                    myC();
                    displayFrame();
                    break;
                case "Settings":
                    aSettings();
                    displayFrame();
                    break;
                case "Log-out":
                    out();
                    break;
                case "+":
                    String number = n.getText();
                    int q = Integer.parseInt(number) + 1;
                    System.out.println(q);
                    String to = Integer.toString(q);
                    n.setText(to);
                    displayFrame();
                    break;
                case "-":

                    int text = Integer.parseInt(n.getText());
                    if (text <= 0) {
                        n.setText("0");
                    } else {
                        String number2 = n.getText();
                        int q2 = Integer.parseInt(number2) - 1;
                        System.out.println(q2);
                        String to2 = Integer.toString(q2);
                        n.setText(to2);
                    }
                    displayFrame();
                    break;
                case "Cart":
                    cart();
                    displayFrame();
                    break;
                case "Save":
                    save();
                    break;
                case "Purchase":
                    purchase();
                    break;

            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void purchase()
    {
        try{
            panel.remove(js0);
           Statement st223 = con1.createStatement();
            st223.executeUpdate("delete from TBL_CART where account_num ="+nu);
            Statement ss = con1.createStatement();
             ss.executeUpdate("INSERT INTO tbl_receipt(PRODUCTs,ACCOUNT_NUM,PRICE) VALUES('" + product + "',"+ nu +"," + price + ")"   );
             
           // ss.executeUpdate("Insert from TBL_CART where account_num ="+nu);

            }
   catch (Exception e) {
            System.out.println(e);
        }
    }
    public void detail()
    {
        String w = detailsB[i].getActionCommand();
       // for ( i = 0; i < num; i++)
        {
        if(w.equals("Details"))
        {
            System.out.println("hm?");
            int q = detailsB[i].getComponentCount();
            System.out.println(q);
        }
        }
    }
    public void cart ()
    {
        //panel2.remove(js);
        panel.remove(panelMain);
        panel.remove(panel1);
        panel.remove(panel3);
        panel.remove(panel2);
        panel.remove(panel5);        
        panel.setBackground(Color.CYAN);
        panel70.setBackground(Color.CYAN);
        panel70.add(purchase);
        
        jp0.setPreferredSize(new Dimension(800, 1000));      
        js0.setPreferredSize(new Dimension(800, 500));
        panel70.add(js0);
        try{
           // Statement st2 = con1.createStatement();
            stmt0 = con1.createStatement();
            ResultSet rs3 = stmt0.executeQuery("select * from TBL_CART where account_num = "+nu);  
            //rs3 = st22.executeQuery("SELECT * FROM TBL_PRODUCTS");
            
            ArrayList<String> names = new ArrayList<>();
            prices0 = new ArrayList<>(10);
            dts0 = new ArrayList<>();
            
            num0 =0;
            while (rs3.next()) {
                names.add(rs3.getString("NAME_OF_PRODUCT"));
                prices0.add(rs3.getString("PRICE"));
                num0 += 1; }  
            
            itemsArrayP0 = new JPanel[num0];
            panelq0 = new JPanel[num0];
            pictureP0 = new JPanel[num0];
            addCartB0 = new JButton[num0];
            details0 = new JButton[num0];
            detailsB0 = new JButton[num0];
           // plus0 = new JButton[num0];
           // minus0 = new JButton[num0];
            productName0 = new JLabel[num0];
            productPrice0 = new JLabel[num0];
            
            for ( i0 = 0; i0 < num0; i0++) {
                
                panelq0[i0] = new JPanel(new GridBagLayout());
                itemsArrayP0[i0] = new JPanel();
                itemsArrayP0[i0].setPreferredSize(new Dimension(250, 250));
                jp0.add(itemsArrayP0[i0], BorderLayout.CENTER);
                               
                pictureP0[i0] = new JPanel();
                pictureP0[i0].setPreferredSize(new Dimension(100, 100));
                pictureP0[i0].setBackground(babypink);
                //itemsArrayP[i].add(pictureP[i]); 
                c.gridx = 0;
                c.gridy = 0;
                panelq0[i0].add(pictureP0[i0], c);

                productName0[i0] = new JLabel("" + names.get(i0));             
                c.gridx = 0;
                c.gridy = 2;
                
                panelq0[i0].add(productName0[i0], c);
                itemsArrayP0[i0].add(panelq0[i0]);
                

                productPrice0[i0] = new JLabel("₱ " + prices0.get(i0));
                c.gridx = 0;
                c.gridy = 3;
                panelq0[i0].add(productPrice0[i0], c);
                //itemsArrayP[i].add(productPrice[i]);

               /* addCartB0[i0] = new JButton("Add to Cart");
                addCartB0[i0].setPreferredSize(new Dimension(100, 25));
                
                 addCartB0[i0].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent c) {
                        for(i0 = 0; i0<num0; i++){
                        if (c.getSource() == addCartB0[i0]) {
                            System.out.println("hey jude 17");
                            String product = "" + names.get(i);
                            double price = Double.parseDouble(prices0.get(i0));
                            addedToCart(product, price);} }}}
                );*/
  
                c.gridx = 0;
                c.gridy = 4;
                //panelq0[i].add(addCartB0[i0], c);
                
                detailsB0[i0] = new JButton("Details");
                detailsB0[i0].setPreferredSize(new Dimension(100, 25));
                
                 /*detailsB0[i0].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent c) {
                        for(i0 = 0; i0<num0; i0++){
                        if (c.getSource() == detailsB0[i0]) {
                            System.out.println("hey jude 18");
                            String product = "" + names.get(i0);
                            String dt = dts0.get(i0);
                            detailss(product);} }}}
                );
                 //c.gridx = 0;
                //c.gridy = 5;panelq0[i].add(detailsB0[i0], c); 

                plus[i] = new JButton("+");
                plus[i].setPreferredSize(new Dimension(50, 20));
                c.gridx = 0;
                c.gridy = 1;
                //panel4[i].add(plus[i], gc);
                
                minus[i] = new JButton("-");
                minus[i].setPreferredSize(new Dimension(50, 20));
                c.gridx = 1;
                c.gridy = 1;
               // panel4[i].add(minus[i], gc);*/

            }
            
        }
        catch(Exception e){JOptionPane.showMessageDialog(f, e);}
        panel.add(panel70);
    }
  

    public void edit() {
                panel.remove(panel70);
        panel.removeAll();
        panel.remove(panel2);
        panel.remove(panel3);
        panel.remove(panel5);
        panel.remove(panel1);

        panel.setBackground(Color.pink);
 
        Statement sta;
        ResultSet set;
        String a = null, b = null, c = null;
        int d = 0;

        System.out.println(a + b + c + d + " ");

        un.setText(a);
        fn.setText(c);
        pw.setText(b);
        if (d == 2) {
            ut.setSelectedIndex(0);
        } else if (d == 1) {
            ut.setSelectedIndex(1);
        }

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel6.add(unl, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel6.add(fnl, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel6.add(pwl, gbc);
        gbc.gridx = 2;
        gbc.gridy = 2;
        panel6.add(back, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel6.add(un, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel6.add(fn, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel6.add(pw, gbc);

        panelHead.add(lbl);
        panelMain.add(panel6, BorderLayout.CENTER);
        panelMain.add(panelHead, BorderLayout.PAGE_START);
        panelMain.add(edituser, BorderLayout.PAGE_END);

        this.panel.add(panelMain);

    }
}
