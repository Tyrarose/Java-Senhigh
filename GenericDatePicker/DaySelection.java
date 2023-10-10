package GenericDatePicker;

// DaySelection.java

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class DaySelection extends JPanel {
    private JButton cmdButOK;
    private JComboBox<String> comboBoxDay;

    protected String[] ProcessArgs(String args[]) {
        int numDays = 0;

        String strMonth = new String(args[0]);

        if ((strMonth.compareToIgnoreCase("September") == 0) ||
                (strMonth.compareToIgnoreCase("April") == 0) ||
                (strMonth.compareToIgnoreCase("June") == 0) ||
                (strMonth.compareToIgnoreCase("November") == 0)) {

            numDays = 30;
        } else if (strMonth.compareToIgnoreCase("February") == 0) {
            int iYear = Integer.parseInt(args[1]);

            if ((iYear % 4) == 0) {
                if ((iYear % 100) == 0) {
                    numDays = ((iYear % 400) == 0) ? 29 : 28;
                } else {
                    numDays = 29;
                }
            } else {
                numDays = 28;
            }
        } else {
            numDays = 31;
        }

        String strDays[] = new String[numDays];

        for (int iLoop = 0; iLoop < numDays; iLoop++) {
            strDays[iLoop] = (new Integer(iLoop + 1)).toString();

        }

        return (strDays);
    }

    public DaySelection(String args[]) {
        // construct preComponents
        String[] comboBoxDayItems = ProcessArgs(args);

        // construct components
        cmdButOK = new JButton("OK");
        comboBoxDay = new JComboBox<String>(comboBoxDayItems);

        // adjust size and set layout
        setPreferredSize(new Dimension(230, 65));
        setLayout(null);

        // add components
        add(cmdButOK);
        add(comboBoxDay);

        // set component bounds (only needed by Absolute Positioning)
        cmdButOK.setBounds(120, 15, 55, 35);
        comboBoxDay.setBounds(10, 20, 100, 25);

        cmdButOK.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String strDay = (String) comboBoxDay.getSelectedItem();

                        String strDate = new String(args[0] + " " + strDay + "," + args[1]);
                        JOptionPane.showMessageDialog(null, strDate);

                    }
                });

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("DaySelection");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new DaySelection(args));
        frame.pack();
        frame.setVisible(true);
    }
}
