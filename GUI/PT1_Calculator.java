
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Carganilla, Joel
// Belgica, Charlene
// Clemente, Tyra
// Garoy, Danicalyn

public class PT1_Calculator {

    JFrame f;
    JPanel mainP, tfPanel, centerP, numPanel, bottomP, rightP;
    JTextField numTF;
    Font tfFont = new Font("Courier", Font.PLAIN, 30);
    Font bFont = new Font("Cooper Black", Font.PLAIN, 30);
    Color babypink = new Color(244, 194, 194);
    Color lightblush = new Color(245, 222, 210);
    Color pastelviolet = new Color(204, 169, 221);
    Color yellow = new Color(255, 241, 166);
    JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bPlus, bMin, bMul, bDiv, bDec, bClear, bEqs;
    
    String Ops, Ans;
    double num1,num2, num3;

    public PT1_Calculator() {
        f = new JFrame("Calculator");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainP = new JPanel(new FlowLayout());
        mainP.setBackground(babypink);

        calc();

        f.add(mainP);
        f.setSize(440, 480);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setVisible(true);
    }

    public void calc() {
        tfPanel = new JPanel(new GridBagLayout());
        tfPanel.setPreferredSize(new Dimension(440, 100));
        tfPanel.setBackground(babypink);

        numTF = new JTextField();
        numTF.setFont(tfFont);
        numTF.setPreferredSize(new Dimension(385, 70));
        numTF.setEditable(false);
        tfPanel.add(numTF);
        mainP.add(tfPanel);

        
        
        centerP = new JPanel(new BorderLayout());
        centerP.setBackground(babypink);

        
        
        numPanel = new JPanel(new GridLayout(3, 4, 5, 5));
        numPanel.setBackground(babypink);

        b7 = new JButton("7");
        b7.setPreferredSize(new Dimension(70, 70));
        b7.setBackground(lightblush);
        b7.setFont(bFont);
        b7.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		String EnterNumber = numTF.getText() + b7.getText();
		numTF.setText(EnterNumber);
	}
        });
        numPanel.add(b7);

        b8 = new JButton("8");
        b8.setPreferredSize(new Dimension(70, 70));
        b8.setBackground(lightblush);
        b8.setFont(bFont);
        b8.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		String EnterNumber = numTF.getText() + b8.getText();
		numTF.setText(EnterNumber);
	}
        });
        numPanel.add(b8);

        b9 = new JButton("9");
        b9.setPreferredSize(new Dimension(70, 70));
        b9.setBackground(lightblush);
        b9.setFont(bFont);
        b9.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		String EnterNumber = numTF.getText() + b9.getText();
		numTF.setText(EnterNumber);
	}
        });
        numPanel.add(b9);

        bPlus = new JButton("+");
        bPlus.setPreferredSize(new Dimension(70, 70));
        bPlus.setBackground(pastelviolet);
        bPlus.setFont(bFont);
        bPlus.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		num1 = Double.parseDouble(numTF.getText());
		numTF.setText("");
                                              Ops="+";
	}
        });
        numPanel.add(bPlus);

        b4 = new JButton("4");
        b4.setPreferredSize(new Dimension(70, 70));
        b4.setBackground(lightblush);
        b4.setFont(bFont);
        b4.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		String EnterNumber = numTF.getText() + b4.getText();
		numTF.setText(EnterNumber);
	}
        });
        numPanel.add(b4);

        b5 = new JButton("5");
        b5.setPreferredSize(new Dimension(70, 70));
        b5.setBackground(lightblush);
        b5.setFont(bFont);
        b5.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		String EnterNumber = numTF.getText() + b5.getText();
		numTF.setText(EnterNumber);
	}
        });
        numPanel.add(b5);

        b6 = new JButton("6");
        b6.setPreferredSize(new Dimension(70, 70));
        b6.setBackground(lightblush);
        b6.setFont(bFont);
        b6.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		String EnterNumber = numTF.getText() + b6.getText();
		numTF.setText(EnterNumber);
	}
        });
        numPanel.add(b6);

        bMin = new JButton("-");
        bMin.setPreferredSize(new Dimension(70, 70));
        bMin.setBackground(pastelviolet);
        bMin.setFont(bFont);
        bMin.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		num1 = Double.parseDouble(numTF.getText());
		numTF.setText("");
                                              Ops="-";
	}
        });
        numPanel.add(bMin);

        b1 = new JButton("1");
        b1.setPreferredSize(new Dimension(70, 70));
        b1.setBackground(lightblush);
        b1.setFont(bFont);
        b1.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		String EnterNumber = numTF.getText() + b1.getText();
		numTF.setText(EnterNumber);
	}
        });
        numPanel.add(b1);

        b2 = new JButton("2");
        b2.setPreferredSize(new Dimension(70, 70));
        b2.setBackground(lightblush);
        b2.setFont(bFont);
        b2.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		String EnterNumber = numTF.getText() + b2.getText();
		numTF.setText(EnterNumber);
	}
        });
        numPanel.add(b2);

        b3 = new JButton("3");
        b3.setPreferredSize(new Dimension(70, 70));
        b3.setBackground(lightblush);
        b3.setFont(bFont);
        b3.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		String EnterNumber = numTF.getText() + b3.getText();
		numTF.setText(EnterNumber);
	}
        });
        numPanel.add(b3);

        bMul = new JButton("x");
        bMul.setPreferredSize(new Dimension(70, 70));
        bMul.setBackground(pastelviolet);
        bMul.setFont(bFont);
        bMul.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		num1 = Double.parseDouble(numTF.getText());
		numTF.setText("");
                                              Ops="x";
	}
        });
        numPanel.add(bMul);

        
        centerP.add(numPanel, BorderLayout.CENTER);
        
        
        
        JPanel bottomP = new JPanel(new FlowLayout());
        bottomP.setBackground(babypink);

        b0 = new JButton("0");
        b0.setPreferredSize(new Dimension(150, 70));
        b0.setBackground(lightblush);
        b0.setFont(bFont);
        b0.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		String EnterNumber = numTF.getText() + b0.getText();
		numTF.setText(EnterNumber);
	}
        });
        bottomP.add(b0);

        bDec = new JButton(".");
        bDec.setPreferredSize(new Dimension(70, 70));
        bDec.setBackground(lightblush);
        bDec.setFont(bFont);
        bDec.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		String EnterNumber = numTF.getText() + bDec.getText();
		numTF.setText(EnterNumber);
	}
        });
        bottomP.add(bDec);

        bDiv = new JButton("/");
        bDiv.setPreferredSize(new Dimension(70, 70));
        bDiv.setBackground(pastelviolet);
        bDiv.setFont(bFont);
        bDiv.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		num1 = Double.parseDouble(numTF.getText());
		numTF.setText("");
                                              Ops="/";
	}
        });
        bottomP.add(bDiv);

        centerP.add(bottomP, BorderLayout.PAGE_END);

        
        
        rightP = new JPanel(new GridLayout(2, 1, 5, 5));
        rightP.setBackground(babypink);

        bClear = new JButton("C");
        bClear.setPreferredSize(new Dimension(70, 140));
        bClear.setBackground(yellow);
        bClear.setFont(bFont);
        bClear.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
                                   numTF.setText(null);
	}
        });
        rightP.add(bClear);

        bEqs = new JButton("=");
        bEqs.setPreferredSize(new Dimension(70, 148));
        bEqs.setBackground(yellow);
        bEqs.setFont(bFont);
        
        bEqs.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
	num2= Double.parseDouble(numTF.getText());
                       if(Ops == "+"){
		num3 = num1+num2;
		Ans = String.format("%.2f", num3);
		numTF.setText(Ans);
	}
	if(Ops == "-"){
		num3 = num1-num2;
		Ans = String.format("%.2f", num3);
		numTF.setText(Ans);
					
	}
	if(Ops == "x"){
		num3 = num1*num2;
		Ans = String.format("%.2f", num3);
		numTF.setText(Ans);
	}
	if(Ops == "/"){
		num3 = num1/num2;
		Ans = String.format("%.4f", num3);
		numTF.setText(Ans);
					
	}
				
				
            }
        });
        
        rightP.add(bEqs);

        
        
        mainP.add(centerP);
        mainP.add(rightP);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    new PT1_Calculator();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
