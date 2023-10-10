//Clemente, Tyra
//Garoy, Danicalyn

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class DateChooser{
    JFrame f;
    JPanel p;
    JButton selB;
    JComboBox<String> yearB;
    JComboBox<String> monthB;
    
    Color babypink = new Color(245, 202, 195);
    Color peach = new Color(242, 132, 130);

    public DateChooser() {
        f = new JFrame("Date Chooser");
        
        p = new JPanel(new GridLayout(0,1));
        f.add(p);
        
        String[] yearsList = new String[101];
        
        for (int i=100; i>=0; i--)
        {
               yearsList[100-i] =  (new Integer(i+1900)).toString();
        }      

        String[] monthsList = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};

        selB = new JButton ("Select day");
        p.add(selB);
        yearB = new JComboBox<String> (yearsList);
        monthB = new JComboBox<String> (monthsList);
        
        selB.setPreferredSize(new Dimension(150,50));
        yearB.setPreferredSize(new Dimension(150,50));
        monthB.setPreferredSize(new Dimension(150,50));

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setSize(360, 160);
        
        Container cont = f.getContentPane();
        cont.setBackground(babypink);
        cont.setLayout(new FlowLayout());
        cont.add(monthB);
        cont.add(yearB);
        cont.add(p);
        
        f.setVisible(true);
        
        selB.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
                      String chosenMonth = (String) monthB.getSelectedItem();
                      String chosenYear = (String) yearB.getSelectedItem();
                                                   
                      String args[] = new String[2];
                       args[0] = new String(chosenMonth);
                       args[1] = new String(chosenYear);  
                                                       
                       datePicker(args);    
                       }
           });
    }

    
      public String[] monthstasdays(String args[])   {
       int numDays=0;

      String strMonth =  new String(args[0]);
     
      if((strMonth.compareToIgnoreCase("04")==0) ||
           (strMonth.compareToIgnoreCase("06")==0) ||
           (strMonth.compareToIgnoreCase("09")==0) ||
           (strMonth.compareToIgnoreCase("11")==0)
           ){

             numDays=30;
      }
      else if ( strMonth.compareToIgnoreCase("02")==0){
              int iYear = Integer.parseInt(args[1]);

              if ((iYear%4)==0){
                   if ((iYear%100)==0){
                       numDays = ((iYear%400)==0) ? 29 : 28;
                   }else{
                       numDays=29;
                   }    
               }else{
                    numDays=28;
               }
       }else{
            numDays=31;
        }

   
        String daysList[] = new String[numDays];

         for (int i=0; i<numDays; i++){           
              daysList[i] = (new Integer(i+1)).toString();
         }

      return(daysList);
   }

    public void datePicker(String args[])
    {
        f = new JFrame("Pick Days");
        f.setLayout (null);
        f.setLocationRelativeTo(null);
        f.setSize(270, 100);
        
        p = new JPanel();
        
        String[] result = monthstasdays(args);

        JButton date = new JButton ("DATE");
        JComboBox dayB = new JComboBox<String> (result);
        p.add(date);


        date.setPreferredSize(new Dimension(120,50));
        dayB.setPreferredSize(new Dimension(120,50));
        
        Container cont = f.getContentPane();
        cont.setBackground(peach);
        cont.setLayout(new FlowLayout());
        cont.add(dayB);
        cont.add(date);

        f.add(p);
        f.setVisible(true);

       date.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
                       String day = (String)dayB.getSelectedItem();
                                                      
                       String theDate = new String( args[0] + " / " + day + " / " + args[1]);
                       JOptionPane.showMessageDialog(f,theDate); 
                }
            });
    }
    
    public static void main (String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new DateChooser();
            }
        });
    }
}