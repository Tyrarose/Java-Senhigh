/*
Belgica, Charlene
Clemente, Tyra
De Guzman, Daniela
Garoy, Danicalyn
Yaban, Michaela
Dela Pena, Euan
Intalan, Derek
Balageo, Hubert
 */
package module9_atm;

import java.sql.*;
import java.io.*;

public class Module9_ATM {
    static final String JDBC_Driver = "org.apache.derby.jdbc.ClientDriver";
    static final String DB_URL = "jdbc:derby://localhost:1527/M9_Atm";
    static final String User = "admin1";
    static final String Pass = "hulaanmo";
    Connection conn = null;
    public static void main(String[] args) throws IOException
    {
        Connection conn = null;
        Statement stmt = null;
        Statement stmt1 = null;
        try{ 
        Class.forName(JDBC_Driver);
        conn = DriverManager.getConnection(DB_URL, User, Pass);
        if(conn!=null){
            System.out.println("Connected to DB");
        }
        System.out.println("Retrieveing records...");
        stmt = conn.createStatement();
        stmt1 = conn.createStatement();
        
        String sql1 = "Select * from Account";
        ResultSet rs1 = stmt.executeQuery(sql1);

        boolean u=true; 
        int pn = 0;
        int h = 1;
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        System.out.print("Enter Account number:");
        int accnum = Integer.parseInt(br.readLine());
        
        while(rs1.next()){ 
        if(accnum == rs1.getInt("Account_Number")){
          if(pn != 0){
            while(u){
            System.out.print("Enter Pin code:");
            int pin = Integer.parseInt(br.readLine());
            if(pin == rs1.getInt("Pin_Code")){
                Display(accnum);
                u=false;
                break;
            }
            else{
                int p = rs1.getInt("Login_Attempt_Left");
                pn = p - h;
                String csql = "Update Account "
                        + "Set Login_Attempt_Left = "+pn+"where account_number = "+accnum;
                stmt1.executeUpdate(csql);
                System.out.println(pn);
                h++;
                u=true;
                if (pn<=0){
                    System.out.println("No attempts left! Kindly contact the administrator.");
                    break;
                }
            }
            }
          }else{
              System.out.println("No attempts left! Kindly contact the administrator.");
          }
        }
        }
        conn.close();
        
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void Display(int accnum)throws IOException{
         BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
         System.out.println("Please enter a number!\n1.Deposit\n2.Withdraw\n3.Transfer Fund\n4.Exit");
         int ch = Integer.parseInt(br.readLine());
         switch (ch){
             case 1:
                 Deposit(accnum);
                 break;
             case 2:
                 Withdraw(accnum);
                 break;
             case 3:
                 Transfer(accnum);
                 break;
             case 4:    
                 System.out.println("Exiting...");
                 System.exit(0);
                 break;
         }
    }
    public static void Deposit(int accnum)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
        Statement stmt = null;     
        Connection conn = null;
        try{
            Class.forName(JDBC_Driver);
            conn = DriverManager.getConnection(DB_URL, User, Pass);
            stmt = conn.createStatement();
            String sql1 = "Select * from Account";
            ResultSet rs1 = stmt.executeQuery(sql1);
            System.out.println("Enter amount:");
            Double am = Double.parseDouble(br.readLine());
            double balance = 0;
            while(rs1.next()){
               if(accnum == rs1.getInt("Account_Number")){
                    balance = rs1.getDouble("Balance");
                    Double nm = balance + am;
                String csql = "Update Account "
                        + "Set BALANCE = "+nm+"where account_number = "+accnum;
                stmt.executeUpdate(csql);
                System.out.println("Account Balance : "+nm);
                System.out.println("Transaction was successful!");
                break;
                } 
            }conn.close();
            
        }
        catch(Exception e){
            e.printStackTrace();     
        }    
    }
    public static void Withdraw(int accnum)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
        Statement stmt = null;     
        Connection conn = null;
        try{
            Class.forName(JDBC_Driver);
            conn = DriverManager.getConnection(DB_URL, User, Pass);
            stmt = conn.createStatement();
            String sql1 = "Select * from Account";
            ResultSet rs1 = stmt.executeQuery(sql1);
            System.out.println("Enter amount:");
            Double am = Double.parseDouble(br.readLine());
            if(am <= rs1.getDouble("Balance") && am != 0){
            double balance = 0;
            while(rs1.next()){
               if(accnum == rs1.getInt("Account_Number")){
                    balance = rs1.getDouble("Balance");
                    Double nm = balance - am;
                String csql = "Update Account "
                        + "Set BALANCE = "+nm+"where account_number = "+accnum;
                stmt.executeUpdate(csql);
                System.out.println("Account Balance : "+nm);
                System.out.println("Transaction was successful!");
                break;
                }else{
                   System.out.println("Invalid amount");
               } 
            }conn.close();
           }
            
        }
        catch(Exception e){
            e.printStackTrace();     
        }    
    }
    public static void Transfer(int accnum)throws IOException{
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        Statement stmt = null;  
        Statement tr = null;
        Connection conn = null;
        try{
            Class.forName(JDBC_Driver);
            conn = DriverManager.getConnection(DB_URL, User, Pass);
            stmt = conn.createStatement();
            tr = conn.createStatement();
            String sql1 = "Select * from Account";
            String sql2 = "Select * from Transact";
            ResultSet rs1 = stmt.executeQuery(sql1);
            ResultSet p = tr.executeQuery(sql2);
            int newtn = 0;
            int plus=1;
            int trnum = 0;
            
         while(rs1.next()){   
            if(accnum == rs1.getInt("Account_Number")){    
            double balance = rs1.getDouble("Balance");
            System.out.println(balance);
                System.out.println("Which account would you like to transfer funds?");
                int rec = Integer.parseInt(br.readLine());
                ResultSet rs2 = stmt.executeQuery(sql1);
                 while(rs2.next()){
                     if(rec == rs2.getInt("Account_Number")){
                         double balance1 = rs2.getDouble("Balance");
                         System.out.println("Enter amount:");
                         double nm1 = Double.parseDouble(br.readLine());
                         if(nm1 <= rs1.getDouble("Balance") && nm1 != 0){
                         double nm2 = balance1 + nm1;
                        String csql = "Update Account "
                        + "Set BALANCE = "+nm2+"where account_number = "+rec;
                        stmt.executeUpdate(csql);
                        System.out.println("Account Balance of "+rec+": "+nm2);               
                        double nm3 = balance - nm1;
                        String csql1 = "Update Account "
                        + "Set BALANCE = "+nm3+"where account_number = "+accnum;
                        stmt.executeUpdate(csql1);   
                        System.out.println("Your New Balance: "+nm3);

                        while(p.next()){
                            trnum = p.getInt("Transaction_Number");
                            newtn = trnum + plus;
                        }
                        
                        String print = "Insert into transact values("+newtn+","+rec+","+accnum+","+nm1+")";
                        tr.executeUpdate(print);
                        System.out.println("Resipt TN:"+newtn+"\t SENDER:" +accnum+"\tReceiver:"+rec+"\tAm:"+nm1);
                        System.exit(0);
                     
                         }
                    }else{
                         System.out.println("Invalid amount!");
                 }
                 }
             }
    
         }
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();     
        }    
     
    }   
    
}
