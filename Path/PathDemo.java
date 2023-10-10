import java.nio.file.*;

public class PathDemo {
    public static void main(String[] args){   
       
        Path filePath = Paths.get("G:\\CP12A\\CP12A Activities\\ComputerProgramming12AAct3.docx"); 
        
        int count = filePath.getNameCount();
    
        System.out.println("Path is " + filePath.toString());
        System.out.println("Filename is " + filePath.getName(count-1));
        System.out.println("There are "  + count + " elements in the file path");
	
        for(int x = 0; x<count; x++){
            System.out.println("Element" + x + " is " + filePath.getName(x));
        }
        
    }
}
