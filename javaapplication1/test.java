import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.awt.FlowLayout;

class Frame extends JFrame {
   
    Frame()
    {
        setTitle("JPanel with JScrollPane");
        setLayout(new FlowLayout());
        setJPanelandComponent();
        setSize(700,350);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void setJPanelandComponent()
    {
        JPanel jp = new JPanel();
        jp.setPreferredSize(new Dimension(800,400));
        for(int i=0;i<100;i++)
        {
            jp.add(new JButton("JButton"));
        }
        
        JScrollPane js = new JScrollPane(jp,
                                         JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                         JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        js.setPreferredSize(new Dimension(400,300));
        add(js);
    }
}

public class test {
   
    public static void main(String[] args) {
        
       Frame fr = new Frame();
    }
}