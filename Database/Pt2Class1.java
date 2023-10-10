package Database;

import java.util.ArrayList;
import java.io.*;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.*;
import java.util.List;

public class Pt2Class1 extends PerformanceTask2{
    Path filePath = Paths.get("C:\\Users\\Acer\\Documents\\credentials.csv");
    String[] array = new String[5];
    String pp = "";
    String oo;
    
    private static List<String> username = new ArrayList();
    private static List<String> password = new ArrayList();
    
    public String main1() throws IOException
    {
        System.out.println("1. Register\n2. Login\n3. Exit");
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        boolean u = true;
        while (u){ 
            System.out.print("Enter Choice: ");
            String ch1 = br.readLine();
            if (ch1.equals("1")){
                u = false;
                System.out.println();
                register();
            }else if (ch1.equals("2")){
                u = false;
                System.out.println();
                login();
            }else if (ch1.equals("3")){
                u = false;
                System.out.println();
                exit();
            }else{
                System.out.println("Kindly enter a valid choice: ");
                u = true;    
            }
        }
        return oo;
    }
    
    public void register()throws IOException{
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        System.out.print("1. First Name : ");
        String fn = br.readLine();
        System.out.print("2. Middle Name : ");
        String mn = br.readLine();
        System.out.print("3. Last Name : ");
        String ln = br.readLine();
        System.out.print("4. Date of Birth : ");
        String db = br.readLine();
        System.out.print("5. Email Address : ");
        String em = br.readLine();
        System.out.print("6. Username : ");
        String un = br.readLine();
        System.out.print("7. Password : ");
        String pw = br.readLine();
        boolean p = true;
        while (p){
            System.out.print("8. Confirm Password : ");
            String cpw = br.readLine();
            if (cpw.equals(pw)){
                p = false;
                //enter next method
            }else{
                System.out.println("Please input the same password: ");
                p = true;    
            }
        }
        String fullname = fn+" "+mn+" "+ln;
        String newcre = (fullname+","+db+","+em+","+un+","+pw+"\n");
        byte[] regis = newcre.getBytes();
        OutputStream output = null;
        try {
            System.out.println();
            System.out.println("Successfully Registered! ");
            main2();
            output = new BufferedOutputStream(Files.newOutputStream(filePath, WRITE, APPEND)); 
            //output.append(regis);
            output.write(regis);
            output.flush();
            output.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
      
    }
    
    public void main2()throws IOException{
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        System.out.println();
        System.out.println("1. Display Profile\n2. Reset Password\n3. Log-out");
        boolean l = true;
        while (l){
            System.out.print("Enter Choice: ");
            String ch2 = br.readLine();
            if (ch2.equals("1")){
                l = false;
                System.out.println();
                //enter method
            }else if (ch2.equals("2")){
                l = false;
                System.out.println();
                //enter method
            }else if (ch2.equals("3")){
                l = false;
                System.out.println();
                main1();
            }else{
                System.out.println("Kindly enter a valid choice: ");
                l = true;    
            }
        }
    }
    
    public void login()throws IOException{
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        boolean uc = true;
        boolean pc = true;
        
        try{
            InputStream input = new BufferedInputStream(Files.newInputStream(filePath,READ));
            BufferedReader reader = new BufferedReader (new InputStreamReader (input));
            String line = "";
            pp = reader.readLine();
            while(pp!=null){
                array = pp.split(",");
                //System.out.println(pp);
                pp = reader.readLine();
                username.add(array[3]);
                password.add(array[4]);  
            }
            while (uc){
            System.out.print("Username : ");
                String user = br.readLine();
                if (username.contains(user)){
                    uc = false;
                    while (pc){
                        System.out.print("Password : ");
                        String pass = br.readLine();
                        if(password.contains(pass)){
                            pc = false;
                            main2();
                            break;
                        }else{
                            System.out.println("~wrong password~");
                            pc = true;
                        }
                    }
                    pp = reader.readLine();
                }
                else{
                    System.out.println("~username doesn't exist~");
                    uc = true;
                }
            }
            
            reader.close();
        }catch (Exception e){
            System.out.println(e);
        } 
    }
    public void exit(){
        System.out.println("~~exit~~");

    }
}  
    
   /*System.out.print("Username : ");
                String user = br.readLine();
                if (user.equals(array[3])){
                    //uc = false;
                    while (pc){
                        System.out.print("Password : ");
                        String pass = br.readLine();
                        if(pass.equals(array[4])){
                            pc = false;
                            main2();
                            break;
                        }else{
                            System.out.println("~wrong password~");
                            pc = true;
                        }
                    }
                    pp = reader.readLine();
                    break;
                }
                else{
                    System.out.println("~username doesn't exist~");
                    //uc = true;
                }*/