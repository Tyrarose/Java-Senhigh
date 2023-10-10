package GenericDatePicker;

//GenericDatePicker.java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class GenericDatePicker extends JPanel{
    private JButton cmdButNEXT;
    private JComboBox<String> comboBoxYear;
    private JComboBox<String> comboBoxMonth;

    public GenericDatePicker() {
        //construct preComponents
        String[] comboBoxYearItems = new String[123];
        
        for (int iLoop=122; iLoop>=0; iLoop--)
        {
               comboBoxYearItems[122-iLoop] =  (new Integer(iLoop+1900)).toString();
        }      

        String[] comboBoxMonthItems = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        //construct components
        cmdButNEXT = new JButton ("NEXT >>>");
        comboBoxYear = new JComboBox<String> (comboBoxYearItems);
        comboBoxMonth = new JComboBox<String> (comboBoxMonthItems);

        //adjust size and set layout
        setPreferredSize (new Dimension (499, 82));
        setLayout (null);

        //add components
        add (cmdButNEXT);
        add (comboBoxYear);
        add (comboBoxMonth);

        //set component bounds (only needed by Absolute Positioning)
        cmdButNEXT.setBounds (375, 20, 95, 20);
        comboBoxYear.setBounds (20, 20, 110, 25);
        comboBoxMonth.setBounds (175, 20, 165, 25);


        cmdButNEXT.addActionListener(
                                          new ActionListener() 
                                          {
                                               public void actionPerformed(ActionEvent e) 
                                               {
                                                    String selectedMonth = (String) comboBoxMonth.getSelectedItem();
                                                    String selectedYear = (String) comboBoxYear.getSelectedItem();
                                                   
                                                    String args[] = new String[2];
                                                    args[0] = new String(selectedMonth);
                                                    args[1] = new String(selectedYear);  
                                                       
                                                    DaySelection.main(args);      
                                                        
                                               }
                                          }
                                     );

    }


    public static void main (String[] args) {
        JFrame frame = new JFrame ("GenericDatePicker");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new GenericDatePicker());
        frame.pack();
        frame.setVisible (true);
    }
}