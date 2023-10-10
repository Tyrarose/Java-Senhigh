package Database;

import java.io.*;

public class ScreenOut {
    public static void main(String[] args) {
        
        String s = "ABCDEF";
        byte[] data = s.getBytes();
        
        OutputStream output = null;
        try {
            
            output = System.out;
            output.write(data,0,1);
            output.write(data,3,1);
            output.write(data,5,1);
            output.flush();
            output.close();
        
        } catch (Exception e) {
            System.err.println("Message: " + e);
        }
        
    }  
}
