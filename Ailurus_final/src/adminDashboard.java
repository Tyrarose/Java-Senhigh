package Ailurus_final.src;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class adminDashboard {
    //general sh**
    JFrame f;
    JPanel buttons, userP, inventoryP,addP,lolP, mPanel, idk,lol;
    JButton usP,invP,logP,adduser,newpro;
    JLabel head;
    String cheesu;

    ResultSet rs1; 
    Connection conn;     
    GridBagConstraints cst;

    adminDashboard(ResultSet rs1, Connection conn)
{
    adminDB();
    this.rs1 = rs1;
    this.conn = conn;
}
    
    public void adminDB(){
        f = new JFrame("Admin Dashboard");
        mPanel = new JPanel(new BorderLayout());
        buttons = new JPanel(new GridLayout(4,1,20,20));
        idk = new JPanel();
        lol = new JPanel();
        lol.setPreferredSize(new Dimension(850,480));
        lol.setBackground(Color.black);
        idk.add(lol);
        
        usP = new JButton("Users");buttons.add(usP);
        usP.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                users();
                toframe();
            }
        });
        invP = new JButton("Inventoy");buttons.add(invP);
        invP.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                invent();
                toframe();

            }
        });
        newpro = new JButton("Add New Product");buttons.add(newpro);
        newpro.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                addproduct();
                toframe();
            }
        });
        logP = new JButton("Log-out");buttons.add(logP);
        logP.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                out();

            }
        });
        
        mPanel.add(buttons,BorderLayout.LINE_START);
        mPanel.add(idk,BorderLayout.CENTER);
        Container con = f.getContentPane();
        con.add(mPanel);
        toframe();
    }
    
    //users method
    JComboBox names,utypes;
    JLabel un,pw,ut;
    JTextField untf,pwtf;
    JButton confirm,delete,refresh;
    Statement sta,sta1;
    ResultSet set;
    String a,b,napili; int c;
    
    public void users(){  
        idk.removeAll();
        
        String[] utn = new String [] {"Administator", "Manager","Worker", "Customer"};
        names = new JComboBox();
        utypes = new JComboBox(utn);ut = new JLabel("USER TYPE : ");
        untf = new JTextField(); un = new JLabel("USERNAME : ");
        pwtf = new JTextField(); pw = new JLabel("PASSWORD : ");
        untf.setPreferredSize(new Dimension(200,25));
        pwtf.setPreferredSize(new Dimension(200,25));
        confirm = new JButton("CONFRIM");
        delete = new JButton("DELETE USER");
        adduser = new JButton("ADD USER");
        refresh = new JButton("Refresh");
        adduser.setPreferredSize(new Dimension(200,25));
        userP = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        userP.setBackground(new Color(166, 219, 224));
        gbc.insets = new Insets(5,2,5,5);
        
        gbc.gridx = -1; gbc.gridy = -1;
        userP.add(adduser,gbc);
        gbc.gridx = 2; gbc.gridy = 0;
        userP.add(delete,gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        userP.add(names,gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        userP.add(un,gbc);
        gbc.gridx = 1; gbc.gridy = 2;
        userP.add(pw,gbc);
        gbc.gridx = 1; gbc.gridy = 3;
        userP.add(ut,gbc);
        gbc.gridx = 2; gbc.gridy = 1;
        userP.add(untf,gbc);
        gbc.gridx = 2; gbc.gridy = 2;
        userP.add(pwtf,gbc);
        gbc.gridx = 2; gbc.gridy = 3;
        userP.add(utypes,gbc);
        gbc.gridx = 2; gbc.gridy = 4;
        userP.add(confirm,gbc);
        gbc.gridx = 3; gbc.gridy = 5;
        userP.add(refresh,gbc);
        
        refresh.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                f.dispose();
                adminDB();
            }
        });
        adduser.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                f.dispose();
                adminDB();
                f.dispose();
                cheesu = "kimbap";
                new Register(conn,cheesu);
                
            }
        });
        
        try{
        sta = conn.createStatement();
        String sq = "Select * from tbl_users";
        System.out.println("read");
        set = sta.executeQuery(sq);System.out.println("e");
            while(set.next()){
                System.out.println("r");
                String c = set.getString("username");
                names.addItem(c);
            }
        }catch(Exception ex){ex.printStackTrace();}
        
        names.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                napili = names.getSelectedItem().toString();
                try{
                sta = conn.createStatement();
                String sq = "Select * from tbl_users where username = '"+napili+"'";
                System.out.println("read");
                set = sta.executeQuery(sq);System.out.println("e");
                while(set.next()){
                    System.out.println("r");
                    a = set.getString("username");
                    b = set.getString("password");
                    c = set.getInt("ustype");
                }
                untf.setText(a);
                pwtf.setText(b);
                if(c==1){
                    utypes.setSelectedIndex(0);
                }else if(c==2){
                    utypes.setSelectedIndex(1);
                }else if(c==3){
                    utypes.setSelectedIndex(2);
                }else if(c==4){
                    utypes.setSelectedIndex(3);
                }
        }catch(Exception ex){ex.printStackTrace();}
            }
        });
        
        confirm.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                    String newun = untf.getText().toString();
                    String newpw = pwtf.getText().toString();
                    int newut = utypes.getSelectedIndex();
                    if(untf.getText().toString().isEmpty() || pwtf.getText().toString().isEmpty())
                        {JOptionPane.showMessageDialog(f,"Please fill out all textbox");
                    }else{
                    try{
                    editna(newun,newpw,newut);}catch(Exception lol){}      
            
        }}});
        delete.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{ 
                    sta1 = conn.createStatement();
                    String sq = "delete from tbl_users where username = '" + napili +"'";
                    System.out.println("read");
                    sta1.executeUpdate(sq);
                    JOptionPane.showMessageDialog(f,"Deleted Successfully");
                } 
                catch(Exception ex){ex.printStackTrace();}      
        }});
        
        userP.setPreferredSize(new Dimension(850,480));
        idk.add(userP);
    }
    public void out() {
        f.dispose();
        new login();
    }
    public void toframe(){
        //Container con = f.getContentPane();
        //con.add(mPanel);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1000, 600);
        f.setLocationRelativeTo(null);
        f.add(mPanel);
        f.setVisible(true);
    }
    int newutt;
    public void editna(String newun,String newpw,int newut){
        try{ 
            if(newut==0){
                newutt = 1;
            }else if(newut==1){
                newutt = 2;
            }else if(newut==2){
                newutt = 3;
            }else if(newut==3){
                newutt = 4;
            }
            sta1=conn.createStatement();
            String sq = "UPDATE tbl_users set username = '"+newun+"',password = '"+newpw+"',ustype ="+newutt+" where username = '" + napili +"'";
            System.out.println("read");
            sta1.executeUpdate(sq);System.out.println("updates!!");
            JOptionPane.showMessageDialog(f,"EDITED, pls refresh");
        } 
        catch(Exception ex){
            JOptionPane.showMessageDialog(f,"username has already been used\n\nTRY A DIFFERENT USERNAME");
            un.setText(null);}
    }
    

    //para sa invetory
 //para sa inventory
    JLabel hotdog;
    JComboBox prdcts;
    JButton cnfrm, dlete;
    JTextField stocks, price;
    
    public void invent()
    {
        idk.removeAll();               
        inventoryP = new JPanel (new GridBagLayout());
        inventoryP.setPreferredSize(new Dimension(850,480));
        
                         
        hotdog = new JLabel("Products: ");
        
        prdcts = new JComboBox();
        stocks = new JTextField();
        price = new JTextField();
        cnfrm = new JButton("Confirm");
        dlete = new JButton("Delete Product");

        prdcts.setPreferredSize(new Dimension(200,75));
        stocks.setPreferredSize(new Dimension(200,25));
        price.setPreferredSize(new Dimension(200,25));
       
        try{             
            sta1 = conn.createStatement();
            String sq = "select * from tbl_products";
            System.out.println("read");
            ResultSet rs = sta1.executeQuery(sq);System.out.println("updates!!");
            String y = "select stock from tbl_products";
            while(rs.next()){
                
                String c = rs.getString("name_of_product");
                prdcts.addItem(c);
                String k = rs.getString("stock");
                stocks.setText(k);
                String l = rs.getString("price");
                price.setText(l);
                
            }
        } 
        catch(Exception ex){
            
            ex.printStackTrace();
            
        }
        
        GridBagConstraints box = new GridBagConstraints();
        inventoryP.setBackground(new Color(166, 219, 224));
        box.insets = new Insets(5,2,5,5);
        
      
        box.gridx = 1; box.gridy = 1;
        inventoryP.add(hotdog,box);
        
        box.gridx = 2; box.gridy = 1;
        inventoryP.add(stocks,box);
        box.gridx = 2; box.gridy = 2;
        inventoryP.add(prdcts,box);
        box.gridx = 3; box.gridy = 3;
        inventoryP.add(price,box);
        
        box.gridx = 0; box.gridy = 0;
        inventoryP.add(cnfrm,box);
        
        box.gridx = 1; box.gridy = 1;
        inventoryP.add(dlete,box);  
        
        
        idk.add(inventoryP);
         


         
    }
    /*public void invent(){
        idk.removeAll();
        invetoryP = new JPanel(new GridBagLayout());
        invetoryP.setPreferredSize(new Dimension(850,480));
        idk.add(invetoryP);
    }*/
    
    JLabel proname,proprice,protype,prodet,prostock;
    JTextField nametf,dettf,pricetf,stocktf,typebox;
    JButton sushi;
    public void addproduct(){
        idk.removeAll();
        addP = new JPanel(new GridBagLayout());
        addP.setPreferredSize(new Dimension(850,480));
        proname = new JLabel("Product Name: ");     nametf = new JTextField();
        protype = new JLabel("Type : ");            typebox = new JTextField();
        prodet = new JLabel("Details : ");          dettf = new JTextField();
        proprice = new JLabel("Price (numbers): "); pricetf = new JTextField();
        prostock = new JLabel("No. of Stock : ");   stocktf = new JTextField();
        sushi = new JButton("ADD NEW PRODUCT");
        nametf.setPreferredSize(new Dimension(200,25));
        typebox.setPreferredSize(new Dimension(200,25));
        dettf.setPreferredSize(new Dimension(200,75));
        pricetf.setPreferredSize(new Dimension(200,25));
        stocktf.setPreferredSize(new Dimension(200,25));
        
        GridBagConstraints gbc = new GridBagConstraints();
        addP.setBackground(new Color(166, 219, 224));
        gbc.insets = new Insets(5,2,5,5);
        
        gbc.gridx = 1; gbc.gridy = 1;
        addP.add(proname,gbc);
        gbc.gridx = 1; gbc.gridy = 2;
        addP.add(protype,gbc);
        gbc.gridx = 1; gbc.gridy = 3;
        addP.add(prodet,gbc);
        gbc.gridx = 1; gbc.gridy = 4;
        addP.add(proprice,gbc);
        gbc.gridx = 1; gbc.gridy = 5;
        addP.add(prostock,gbc);
        
        gbc.gridx = 2; gbc.gridy = 1;
        addP.add(nametf,gbc);
        gbc.gridx = 2; gbc.gridy = 2;
        addP.add(typebox,gbc);
        gbc.gridx = 2; gbc.gridy = 3;
        addP.add(dettf,gbc);
        gbc.gridx = 2; gbc.gridy = 4;
        addP.add(pricetf,gbc);
        gbc.gridx = 2; gbc.gridy = 5;
        addP.add(stocktf,gbc);
        
        gbc.gridx = 0; gbc.gridy = 0;
        addP.add(sushi,gbc);
        
        idk.add(addP);
        sushi.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    if(nametf.getText().toString().isEmpty() || dettf.getText().toString().isEmpty() || typebox.getText().toString().isEmpty() || pricetf.getText().toString().isEmpty() || stocktf.getText().toString().isEmpty()){
                        JOptionPane.showMessageDialog(f,"Fill all fields");
                        System.out.println("lol");
                        nametf.setText(null);
                        typebox.setText(null);
                        dettf.setText(null);
                        pricetf.setText(null);
                        stocktf.setText(null);}
                    else{   String hatdog = nametf.getText();
                            String sausage = typebox.getText();
                            String footlong = dettf.getText();
                            double premium = Double.parseDouble(pricetf.getText());
                            int vip = Integer.parseInt(stocktf.getText());
                            System.out.println("pra");
                            sta = conn.createStatement();
                            String sq = "insert into tbl_products(name_of_product,product_type,details,price,stock) values('"+hatdog+"','"+sausage+"','"+footlong+"',"+premium+","+vip+")";
                            sta.executeUpdate(sq);
                            JOptionPane.showMessageDialog(f,"Product Successfully ADDED");
                        nametf.setText(null);
                        typebox.setText(null);
                        dettf.setText(null);
                        pricetf.setText(null);
                        stocktf.setText(null);
                    }
                }catch(SQLException ex){ex.printStackTrace();
                nametf.setText(null);
                typebox.setText(null);
                dettf.setText(null);
                pricetf.setText(null);
                stocktf.setText(null);
                }catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(f,"Please enter the asked inputs");
                }
     
                    
        }});

    }
    
  
    
}

    

