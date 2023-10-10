import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Datechooserdraft {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        
        final JFrame frame = new JFrame("Date Chooser");
                     
        String[] MONTH = {"1", "2", "3","4", "5", "6","7","8", "9","10","11","12"};
        final JComboBox MM = new JComboBox(MONTH);
      
        String[] DAY = {"1", "2", "3","4", "5", "6","7","8", "9","10","11","12","13","14","15","16", "17", "18","19", "20", "21","22", "23","24","25","26","27","28","29","30","31"};
        JComboBox DD = new JComboBox(DAY);
        
        String[] nothirtywan = {"1", "2", "3","4", "5", "6","7","8", "9","10","11","12","13","14","15","16", "17", "18","19", "20", "21","22", "23","24","25","26","27","28","29","30"};
        JComboBox NNN = new JComboBox(nothirtywan);
        
        
        String[] YEAR = {"1900","1901", "1902", "1903","1904", "1905", "1906","1907","1908", "1909","1910","1911","1912","1913","1914","1915","1916", "1917", "1918","1919", "1920", "1921","1922", "1923","1924","1925","1926","1927","1928","1929","1930","1931", "1932", "1933","1934", "1935", "1936","1937", "1938","1939","1940","1941","1942","1943","1944","1945","1946", "1947", "1948","1949", "1950", "1951","1952", "1953","1954","1955","1956","1957","1958","1959","1960","1961", "1962", "1963","1964", "1965", "1966","1967","1968", "1969","1970","1971","1972","1973","1974","1975","1976", "1977", "1978","1979", "1980", "1981","1982", "1983","1984","1985","1986","1987","1988","1989","1990","1991", "1992", "1993","1994", "1995", "1996","1997","1999", "1999","2000","2001","2002","2003","2004","2005","2006", "2007", "2008","2009", "2010", "2011","2012", "2013","2014","2015","2016","2017","2018","2019","2020","2021"};
        final JComboBox YY = new JComboBox(YEAR);
        
        
        
         String[] FEB = {"1", "2", "3","4", "5", "6","7","8", "9","10","11","12","13","14","15","16", "17", "18","19", "20", "21","22", "23","24","25","26","27","28"};
         final JComboBox FF = new JComboBox(FEB);
         
        
        JButton b1 = new JButton("Display");
          JLabel top = new JLabel("                          ");
          top.setFont(new Font ("Helvetica", Font.BOLD, 15));
          top.setForeground(Color.BLACK);
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          
          JLabel bot = new JLabel("MM/DD/YY");
          bot.setFont(new Font ("Helvetica", Font.BOLD, 15));
          bot.setForeground(Color.BLACK);
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
          frame.setSize(350,100);
          Container cont = frame.getContentPane();
          cont.setLayout(new FlowLayout(FlowLayout.CENTER));      
          
          cont.add(MM);
          cont.add(DD);
          cont.add(YY);
          cont.add(b1);
          
          
          
          frame.setVisible(true);
        
        MM.addActionListener( new ActionListener() {   
         @Override
        public void actionPerformed(ActionEvent e) {
         
         if ( MM.getSelectedItem() == MONTH [1]){
              cont.remove(DD);
              cont.remove(NNN);
              cont.remove(YY);
              cont.remove(bot);
              cont.remove(b1);
              
              cont.add(FF);
              cont.add(YY);
              cont.add(bot);
              cont.add(b1);
              
          }
         else if( MM.getSelectedItem() == MONTH [3] ){
              cont.remove(DD);
              cont.remove(FF);
              cont.remove(YY);
              cont.remove(bot);
              cont.remove(b1);
              
              cont.add(NNN);
              cont.add(YY);
              cont.add(bot);
              cont.add(b1);
         }
         
          else if( MM.getSelectedItem() == MONTH [5]){
              cont.remove(DD);
              cont.remove(FF);
              cont.remove(YY);
              cont.remove(bot);
              cont.remove(b1);
              
              cont.add(NNN);
              cont.add(YY);
              cont.add(bot);
              cont.add(b1);
         }
            
          else if( MM.getSelectedItem() == MONTH [5+3]){
              cont.remove(DD);
              cont.remove(FF);
              cont.remove(YY);
              cont.remove(bot);
              cont.remove(b1);
              
              cont.add(NNN);
              cont.add(YY);
              cont.add(bot);
              cont.add(b1);
         }
         
          else if( MM.getSelectedItem() == MONTH [5+5]){
              cont.remove(DD);
              cont.remove(FF);
              cont.remove(YY);
              cont.remove(bot);
              cont.remove(b1);
              
              cont.add(NNN);
              cont.add(YY);
              cont.add(bot);
              cont.add(b1);
         }
          
          else{
              cont.remove(NNN);
              cont.remove(FF);
              cont.remove(YY);
              cont.remove(bot);
              cont.remove(b1);
              
              cont.add(DD);
              cont.add(YY);
              cont.add(bot);
              cont.add(b1);
          }
          
          
      
        }
        });
        
        
        FF.addActionListener( new ActionListener() {   
         @Override
        public void actionPerformed(ActionEvent e) {
         
            FF.getSelectedItem();    
        }
        });
        
        NNN.addActionListener( new ActionListener() {   
         @Override
        public void actionPerformed(ActionEvent e) {
         
            NNN.getSelectedItem();    
        }
        
        });
        
        DD.addActionListener( new ActionListener() {   
         @Override
        public void actionPerformed(ActionEvent e) {
         
            DD.getSelectedItem();    
        }
        });
        
        
        YY.addActionListener( new ActionListener() {   
         @Override
        public void actionPerformed(ActionEvent e) {
         
              YY.getSelectedItem();    

          
          b1.addActionListener( new ActionListener() {   
         @Override
        public void actionPerformed(ActionEvent e) {
         
            if (MM.getSelectedItem() == MONTH[1]){
                  JOptionPane.showMessageDialog(frame,
         "DATE: " +
            MM.getSelectedItem() + " / "+ FF.getSelectedItem() + " / "+ YY.getSelectedItem()  .toString()); 
            }
            
            else if (MM.getSelectedItem() == MONTH[3]){
                JOptionPane.showMessageDialog(frame,
         "DATE: " +
            MM.getSelectedItem() + " / "+ NNN.getSelectedItem() + " / "+ YY.getSelectedItem()  .toString()); 
            }
            
              else if (MM.getSelectedItem() == MONTH[5]){
                JOptionPane.showMessageDialog(frame,
         "DATE: " +
            MM.getSelectedItem() + " / "+ NNN.getSelectedItem() + " / "+ YY.getSelectedItem()  .toString()); 
            }
            
              else if (MM.getSelectedItem() == MONTH[8]){
                JOptionPane.showMessageDialog(frame,
         "DATE: " +
            MM.getSelectedItem() + " / "+ NNN.getSelectedItem() + " / "+ YY.getSelectedItem()  .toString()); 
            }
            
              else if (MM.getSelectedItem() == MONTH[10]){
                JOptionPane.showMessageDialog(frame,
         "DATE: " +
            MM.getSelectedItem() + " / "+ NNN.getSelectedItem() + " / "+ YY.getSelectedItem()  .toString()); 
            }
              else {
                  
                   JOptionPane.showMessageDialog(frame,
         "DATE: " +
            MM.getSelectedItem() + " / "+ DD.getSelectedItem() + " / "+ YY.getSelectedItem()  .toString()); 
                  
              }
            
        
            
        }
        });     
        }
        });
          
        
          
         

    }
    }
    

