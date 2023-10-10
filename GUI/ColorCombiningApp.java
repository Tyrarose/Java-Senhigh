//Clemente, Tyra
//Garoy, Danicalyn

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ColorCombiningApp implements ActionListener {
    JFrame f;
    JCheckBox red,blue,green;
    
    public ColorCombiningApp(){
        f = new JFrame("Color Combining App");
 
        colorCombine();
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300, 150);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    
    public void colorCombine(){
    
        red = new JCheckBox("Red");
        green = new JCheckBox("Green");
        blue = new JCheckBox("Blue");
        
        JPanel colorBoxP = new JPanel(new java.awt.GridLayout(3,1,0,0));
        colorBoxP.add(red);
        colorBoxP.add(green);
        colorBoxP.add(blue);
        
        JButton evalB = new JButton("Evaluate");
        evalB.setPreferredSize(new Dimension(180,100));
        JPanel evalP = new JPanel();
        evalP.add(evalB);
        
        evalB.addActionListener(this);  
        
        f.getContentPane().add(colorBoxP, BorderLayout.LINE_START);
        f.getContentPane().add(evalP, BorderLayout.CENTER);
    
    }
    
    public void actionPerformed(ActionEvent e){  
        String color = "";
         if(red.isSelected() && green.isSelected() && blue.isSelected()){  
            color = "White";
        }
         else if(red.isSelected()){  
                if(green.isSelected()){
                    color = "Yellow";
                }  
                else if(blue.isSelected()){
                    color = "Magenta";
                }else{
                    color = "Red";
                }
        }  
         else if(green.isSelected()){
                if(blue.isSelected()){
                    color = "Cyan";
                }  
                else{
                    color = "Green";
                }
         }
           else if(blue.isSelected()){
                color = "Blue";
        }  
        else{
            color = "Black";
            }
        JOptionPane.showMessageDialog(f,color);
        }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new ColorCombiningApp();
            }
        });
    }
}