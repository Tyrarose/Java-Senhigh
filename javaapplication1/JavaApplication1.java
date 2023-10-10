package JavaApplication1;

import java.sql.*;

public class JavaApplication1 {

    static final String jdbc_driver = "org.apache.derby.jdbc.ClientDriver";
    static final String dbUrl = "jdbc:derby://localhost:1527/try";
         
     static final String user = "try";
     static final String password = "try";
         
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        
        try{
            Class.forName(jdbc_driver);
            
            conn = DriverManager.getConnection(dbUrl,user,password);
            
            if(conn != null){
                System.out.println("Connected to the database!");
            }else{
                System.out.println("not not");
            }
            
            System.out.println("Retrieving records...");
            stmt = conn.createStatement();
            
            String sql = "SELECT * FROM tbl_user where user_id = 102";
            
            System.out.println(sql);
            
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString(""));
            }
            
            //System.out.println(rs.getString(""));
            
//            System.out.println("laman is ");
//            while(rs.next()){
//                System.out.println(rs.getString(""));
//            }
            
            conn.close();
        }catch(Exception e){
            System.err.println(e);
        }
    }
}