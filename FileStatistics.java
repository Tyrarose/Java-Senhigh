//package filestatistics;
import java.io.*;
import java.util.*; 

public class FileStatistics
{   
    public static void main(String[] args)
    {
        //Scanner sc = new Scanner(System.in);
        //System.out.print("Enter File Path \n> ");
        
         try{
        //String filePath = sc.next();
             //System.out.println();
        
        //File location
        String x = "C:\\Users\\Tyra\\Documents\\Resignation Letter.docx";
        
        String filePath = x;
        File file = new File(filePath);
            System.out.println("File path\n> "+filePath);
        
        if(file.exists())
        {
        //file name
        String fileName = file.getName();
        
        //containing folder
        String parentPath = file.getParent();
        
        //file size
        long fileSize = file.length();
        
        //file last modified
        long lastModified = file.lastModified();
        Date date = new Date(lastModified);
        
        System.out.println("File name\t\t:"+fileName);
        System.out.println("Containing folder\t:"+parentPath);
        System.out.format("File size\t\t:%d bytes\n", fileSize);
        System.out.println("File was last modified\t:" + date);
        System.out.println();
        }
        else
        {
            System.out.println("\nFile not found");}
         } 
         catch(Exception e)
         {
             System.out.println("Error");
         }
         System.out.println();
    }
}