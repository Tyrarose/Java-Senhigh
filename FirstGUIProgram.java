import javax.swing.*;

public class FirstGUIProgram {
    public FirstGUIProgram() {
        JFrame jframe = new JFrame("Title");
        jframe.setSize(500, 500);
        jframe.setDefaultCloseOperation(2);
        // JLabel label = new JLabel("laman");
        JLabel name = new JLabel("\nlets see");
        jframe.add(name);
        jframe.setVisible(true);
    }
    // public static void main(String[] args){
    // //Create the frame on the event dispatching thread
    // SwingUtilities.invokeLater(new Runnable(){
    // public void run(){
    // new FirstGUIProgram();
    // }
    // });
    // }

    // shorter dispatch thread???idk
    public static void main(String[] args) {
        SwingUtilities.invokeLater(FirstGUIProgram::new);
    }
}