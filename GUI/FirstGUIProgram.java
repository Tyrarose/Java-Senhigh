import javax.swing.*;

public class FirstGUIProgram {
    public FirstGUIProgram(){
        //Create a JFrame container
        JFrame jfrm = new JFrame("A simple Java Swing program");
        
        //Give the frame an initial size 
        jfrm.setSize(275,100);
        
        //Terminate the program when the user closes the application
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Create a text-based label
        JLabel lbl = new JLabel("Java Swing!");

        //add the label in the frame
        jfrm.add(lbl);
        
        //display the frame
        jfrm.setVisible(true);
    }
    
    public static void main(String[] args){
    //Create the frame on the event dispatching thread
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new FirstGUIProgram();
            }
        });
    }
}
