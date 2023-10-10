package Ailurus_final.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class managerDashboard  implements ActionListener 
{
JButton out,in;
JButton users,users2,workers,managers,customers,admins;
JButton addU,editU,delU,back;
JButton add,minus;
JButton details,purchase;
JButton shop,cart,inventory;
JTable jt;
JScrollPane sp;
JFrame f;
JPanel panel; JPanel panel2; JPanel panel3;
JPanel mPanel;
Container con; 
JLabel items,price,qt,total,dt;

ResultSet rs1; 
Connection conn;     
GridBagConstraints cst;

    managerDashboard(ResultSet rs1, Connection conn)
{
    //addActionListener();
    elements();
    left();
    addActionListener();
    //shop();
    displayFrame();
    this.rs1 = rs1;
    this.conn = conn;
    
}
    
    
    public void elements()
    {
        System.out.println("you are in manager dashboard");
        out = new JButton("Log-out");      
        in = new JButton("Log-in");
        users2 = new JButton("Users2");
        users = new JButton("Users");
       // users.setBounds(50, 130, 100, 30);
        workers = new JButton("Workers");
       // workers.setBounds(50, 170, 100, 30);
        managers = new JButton("Managers");
       // managers.setBounds(50, 210, 100, 30);
        customers = new JButton("Customers");
       // customers.setBounds(50, 240, 100, 30);        
        admins = new JButton("Admins");
        //admins.setBounds(50, 270, 100, 30);
        
        addU = new JButton("Add User");
        editU = new JButton("Edit User");
        delU = new JButton("Delete User");
        back = new JButton("Back");
        add = new JButton("+");
        minus = new JButton("-");
        details = new JButton("Details");
        purchase = new JButton("Purchase");
        shop = new JButton("Shop");
        cart = new JButton("Cart");
        inventory = new JButton("Inventory Report");
        f = new JFrame("Ailurus");
        mPanel = new JPanel(new BorderLayout());
        
        items = new JLabel ("Items");
        qt = new JLabel ("Quantity");
        price = new JLabel ("Price");
        total = new JLabel ("Total");
        dt = new JLabel ("Details");
        
        panel2 = new JPanel();
        panel3 = new JPanel(new GridBagLayout());
        
        
        
        con = f.getContentPane();
        panel = new JPanel();
        panel.setBounds(180, 10, 390, 440);
        panel.setBackground(Color.darkGray);
        mPanel.add(panel);
        con.add(panel);
        cst = new GridBagConstraints();
        cst.insets = new Insets(5, 0, 5, 5);
        cst.fill = GridBagConstraints.HORIZONTAL;
        
    }
    public void addActionListener()
    {
        out.addActionListener(this);
        in.addActionListener(this);
        users.addActionListener(this);
        workers.addActionListener(this); 
        managers.addActionListener(this);
        customers.addActionListener(this);
        admins.addActionListener(this);
        addU.addActionListener(this);
        editU.addActionListener(this);
        delU.addActionListener(this);
        back.addActionListener(this);
        add.addActionListener(this);
        minus.addActionListener(this);
        details.addActionListener(this);
        purchase.addActionListener(this);
        shop.addActionListener(this);
        cart.addActionListener(this);
        inventory.addActionListener(this);
        
    }
    
    public void left()
    {
        shop.setBounds(50, 130, 100, 30);
        inventory.setBounds(50, 170, 100, 30);
        users.setBounds(50, 210, 100, 30);
        out.setBounds(50, 250, 100, 30);  
        con.add(shop);
        con.add(inventory);
        con.add(users);
        con.add(out);
    }
    
    
    public void inventory()
    { 
        panel.removeAll();  
        String data[][]={ {"101","Amit","670000"},    
                          {"102","Jai","780000"},    
                          {"101","Sachin","700000"}};    
        String column[]={"ID","NAME","SALARY"};
        jt=new JTable(data,column);   
        jt.setBounds(30,40,200,300); 
        sp =new JScrollPane(jt);    
        panel2.add(sp);
        panel.add(panel2);     
    }
    public void out()
    { 
        f.dispose();
        new login();

    }
    public void users()
    {  
        panel.removeAll();   
        panel3.setBackground(Color.white); 
        cst.gridx = 0;
        cst.gridy = 0;
        panel3.add(admins, cst);
        
        cst.gridx = 0;
        cst.gridy = 1;
        panel3.add(customers, cst);
        
        cst.gridx = 0;
        cst.gridy = 2;
        panel3.add(users2, cst);
        
        cst.gridx = 0;
        cst.gridy = 3;
        panel3.add(managers, cst);
         
        panel.add(panel3);
       
        
        
        //panel3.add(admins); 
       // panel3.add(users);
       // panel3.add(customers);
       // panel3.add(managers);
       // panel.add(panel3);
        //con.add(admins);

    }
    
    public void displayFrame()
    { 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1000, 600);
        f.setLocationRelativeTo(null);
        f.add(mPanel);
        f.setVisible(true);
    }
    public void actionPerformed (ActionEvent ae)
    {
        String action = ae.getActionCommand();
        switch(action){
            case "Shop":
             //   shop();
                displayFrame();
                break;
            case "Inventory Report":
                inventory();
                displayFrame();
                break;
            case "Users":
                users();
                displayFrame();
                break;
            case "Log-out":
                out();
                break;
        }
    }
     
    
    
}
