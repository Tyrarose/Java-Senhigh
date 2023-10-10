package Database;

/*Group Name : Damira Yemete
  Clemente, Tyra P.
  De Guman, Daniela F.
  Yaban, Michaela P.*/

import java.nio.file.*;
import java.io.*;
import static java.nio.file.StandardOpenOption.*;

public class ValidateCheckDigits {

    public static void main(String[] args) 
    {
        Path idfile = Paths.get("D:\\Documents\\cp12apt\\idnum.txt");
        Path outputfile = Paths.get("D:\\Documents\\cp12apt\\output.txt");
        String s = "";

        try {
            InputStream input = new BufferedInputStream(Files.newInputStream(idfile));
            BufferedReader br = new BufferedReader(new InputStreamReader(input));
            s = br.readLine(); 
            OutputStream output = new BufferedOutputStream(Files.newOutputStream(outputfile, CREATE));
            BufferedWriter wr = new BufferedWriter (new OutputStreamWriter(output));

            while (s != null) {
                char last =  s.charAt(5);
                int a = Integer.parseInt(String.valueOf(last));
                 
                char first =  s.charAt(0);
                int b = Integer.parseInt(String.valueOf(first));
                
                char second =  s.charAt(1);
                int c = Integer.parseInt(String.valueOf(second));
                 
                char third =  s.charAt(2);
                int d = Integer.parseInt(String.valueOf(third));
                
                char fourth =  s.charAt(3);
                int e = Integer.parseInt(String.valueOf(fourth));
                 
                char fifth =  s.charAt(4);
                int f = Integer.parseInt(String.valueOf(fifth));

                int sum = b+c+d+e+f;

                int quo = sum % 10;

                if (quo==a){
                        //System.out.println(s);
                        wr.write(s);
                        wr.newLine();
                    }
            s = br.readLine();  
            }
                //System.out.println("Done");
                br.close();
                wr.close();
        } catch (Exception e) {

            System.out.println("Message! " + e);
        }
        

    }

}
