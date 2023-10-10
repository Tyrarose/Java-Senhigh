//quiz malinis

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MythoQuiz{
    
    JFrame f;
    JPanel [] panels;
    JPanel main,p1,body,p2;
    JButton button;
     JLabel [] qs;
     JRadioButton [] truefalse;
     JRadioButton [] mutiplechoice;
     ButtonGroup[] truefalsegroup, multiplechoicegroup;
     CardLayout cl;
     int scr;
    JLabel title, score;
    
    public MythoQuiz(){
        f = new JFrame("Quiz");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400, 350);
        f.setLocationRelativeTo(null);
        
        main = new JPanel();
        main.setLayout(new FlowLayout());
        
        cl = new CardLayout();
        
        body=new JPanel();
        body.setPreferredSize(new Dimension(350,200));
        body.setLayout(cl);
        
        simpleQuiz();
        
        f.setVisible(true);
    }
    
    public void simpleQuiz(){
        p1 = new JPanel();
        p1.setPreferredSize(new Dimension(400,50));
        p2 = new JPanel();
        title = new JLabel("Quiz");
        
        panels = new JPanel[10];
        for(int q=0;q<panels.length;q++){
            panels[q] = new JPanel();
            body.add(panels[q], String.valueOf(q));
            panels[q].setLayout(new GridLayout(0,1));
        }
        
        qs = new JLabel[10];
        for(int i=0;i<qs.length;i++){
        qs[i] = new JLabel();
        switch(i){
            case 0:qs[i].setText("?");
                break;
            case 1:qs[i].setText("?");
                break;
            case 2:qs[i].setText("?");
                break;
            case 3:qs[i].setText("?");
                break;
            case 4:qs[i].setText("?");
                break;
            case 5:qs[i].setText("?");
                break;
            case 6:qs[i].setText("?");
                break;
            case 7:qs[i].setText("?");
                break;
            case 8:qs[i].setText("?");
                break;
            case 9:qs[i].setText("?");
                break;
            }
        }
        
        truefalse = new JRadioButton[10];
        for(int i=0;i<truefalse.length;i++){
        truefalse[i] = new JRadioButton();
        switch(i){
            case 0:truefalse[i].setText("true");
                break;
            case 1:truefalse[i].setText("false");
                break;
            case 2:truefalse[i].setText("true");
                break;
            case 3:truefalse[i].setText("");
                break;
            case 4:truefalse[i].setText("");
                break;
            case 5:truefalse[i].setText("");
                break;
            case 6:truefalse[i].setText("");
                break;
            case 7:truefalse[i].setText("");
                break;
            case 8:truefalse[i].setText("");
                break;
            case 9:truefalse[i].setText("");
                break;
        }
        }
        
        mutiplechoice = new JRadioButton[15];
        for(int k=0;k<mutiplechoice.length;k++){
        mutiplechoice[k] = new JRadioButton();
        switch(k){
            case 0:mutiplechoice[k].setText("a");
                break;
            case 1:mutiplechoice[k].setText("b");
                break;
            case 2:mutiplechoice[k].setText("c");
                break;
            case 3:mutiplechoice[k].setText("a");
                break;
            case 4:mutiplechoice[k].setText("");
                break;
            case 5:mutiplechoice[k].setText("");
                break;
            case 6:mutiplechoice[k].setText("");
                break;
            case 7:mutiplechoice[k].setText("");
                break;
            case 8:mutiplechoice[k].setText("");
                break;
            case 9:mutiplechoice[k].setText("");
                break;
            case 10:mutiplechoice[k].setText("");
                break;
            case 11:mutiplechoice[k].setText("");
                break;
            case 12:mutiplechoice[k].setText("");
                break;
            case 13:mutiplechoice[k].setText("");
                break;
            case 14:mutiplechoice[k].setText("");
                break;
            }
        }
        
        truefalsegroup = new ButtonGroup[5];
        int g=0;
        for(int a=0;a<truefalsegroup.length; a++){
            truefalsegroup[a] = new ButtonGroup();
            truefalsegroup[a].add(truefalse[g]);
            truefalsegroup[a].add(truefalse[g+1]);
            truefalsegroup[a].add(truefalse[g+2]);
            truefalsegroup[a].add(truefalse[g+3]);
            g+=3;
        }
        
        multiplechoicegroup = new ButtonGroup[5];
        int f=9;
        for(int a=0;a<multiplechoicegroup.length; a++){
            multiplechoicegroup[a] = new ButtonGroup();
            multiplechoicegroup[a].add(mutiplechoice[f]);
            multiplechoicegroup[a].add(mutiplechoice[f+1]);
            multiplechoicegroup[a].add(mutiplechoice[f+2]);
            multiplechoicegroup[a].add(mutiplechoice[f+3]);
            f+=2;
        }
        
        button = new JButton("Next");
        score = new JLabel("Score");
        
        button.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            cl.next(body);
            
            if(
                    //  INDEX NUNG TAMANG SAGOT truefalse
                    truefalse[0].isSelected()
                    || truefalse[4].isSelected()
                    || truefalse[9].isSelected()
                    || truefalse[12].isSelected()
                    || truefalse[18].isSelected()
                    
                    // INDEX NUNG TAMANG SAGOT mutiplechoice
                    || mutiplechoice[23].isSelected()
                    || mutiplechoice[26].isSelected()
                    || mutiplechoice[31].isSelected()
                    || mutiplechoice[33].isSelected()){
                    scr+=1;
            }else if(mutiplechoice[39].isSelected()){ //INDEX NUNG LAST CORRECT ANS mutiplechoice
                scr+=1;
                score.setText("You got " + scr + "!");
            }else if(mutiplechoice[36].isSelected() || mutiplechoice[37].isSelected() || mutiplechoice[38].isSelected()){ //INDEX NUNG LAST WRONG ANS mutiplechoice
                score.setText("You got " + scr + "!");
            }
            for (int h = 0; h < 5; h++) {
            multiplechoicegroup[h].clearSelection();
        }
            for (int j = 5; j < 10; j++) {
            truefalsegroup[j].clearSelection();
        }
        }
        });
        
        int b=0;
        for(int p=0;p<10;p++){
            panels[p].add(qs[p]);
            panels[p].add(truefalse[b]);
            panels[p].add(truefalse[b+1]);
            panels[p].add(truefalse[b+2]);
            panels[p].add(truefalse[b+3]);
            b+=2;
        }
        
        int c=9;
        for(int p=0;p<10;p++){
            panels[p].add(qs[p]);
            panels[p].add(mutiplechoice[c]);
            panels[p].add(mutiplechoice[c+1]);
            panels[p].add(mutiplechoice[c+2]);
            panels[p].add(mutiplechoice[c+3]);
            b+=3;
        }
        
        p2.add(button);
        p1.add(title);
        p2.add(score);
        main.add(p1);
        main.add(body);
        main.add(p2);
        f.add(main);
        cl.show(body, "0");
}
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new MythoQuiz();
            }
        });
    }
}
