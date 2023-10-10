import java.util.Scanner;
import java.nio.file.*;

public class PathDemo2 {
    public static void main(String[] args){
        String name;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter a filename: ");
        name = sc.nextLine();
        
        Path inputPath  = Paths.get(name);
        Path fullPath = inputPath.toAbsolutePath();
        
        System.out.println("The full path is " + fullPath.toString());
    }
}
