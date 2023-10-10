//Clemente, Tyra
//Garoy, Danicalyn

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MythodologyQuiz implements ActionListener{
    
    JFrame f;
    JPanel [] quizP, whysP;
    JPanel mainP, slideP, whyP, titleP, titleP1, bottomP,scoreP, sourceP;
    JButton ansB, nextB;
     JLabel [] questions, whyL;
     JRadioButton [] choices;
     ButtonGroup[] buttonGroup;
     CardLayout quizCard, whyCard;
     int score;
    JLabel t1L, t2L, scoreL, why, sourceL;
    
    Color babypink = new Color(245, 202, 195);
    Color espresso = new Color(80, 57, 49);
    Color gold = new Color(246, 189, 96);
    Color kindawhite = new Color(247, 237, 226);
    Color darkgreen = new Color(132, 165, 157);
    Color peach = new Color(242, 132, 130);
    Font fonty = new Font("Cooper Black", Font.PLAIN, 30);
    

    public MythodologyQuiz(){
        f = new JFrame("Simple Quiz");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800, 550);
        f.setLocationRelativeTo(null);
        //f.setResizable(false);
        
        mainP = new JPanel();
        mainP.setLayout(new FlowLayout());
        mainP.setBackground(babypink);
        
        header();
        
        quizCard = new CardLayout();
        whyCard = new CardLayout();
        
        slideP=new JPanel();
        slideP.setLayout(quizCard);
        
        whyP=new JPanel();
        whyP.setLayout(whyCard);
        
        quiz();
        
        
        f.setVisible(true);
    }
    public void header(){
        titleP = new JPanel();
        titleP.setPreferredSize(new Dimension(800,100));
        titleP.setBackground(kindawhite);
        titleP1 = new JPanel();
        titleP1.setPreferredSize(new Dimension(8000,120));
        titleP1.setBackground(babypink);
        
        titleP1.add(titleP);
        mainP.add(titleP1);
        
        t1L = new JLabel("Can you pass this quiz?");
        t1L.setFont(new Font("Cooper Black", Font.PLAIN, 45));
        t2L = new JLabel("Let's see if how much you know about Greek Mythology");
        t2L.setFont(new Font("Courier", Font.PLAIN, 15));
        t1L.setForeground(gold);
        t2L.setForeground(darkgreen);
        titleP.add(t1L);
        titleP.add(t2L);
    }
    
    public void quiz(){
        quizP = new JPanel[10];
        for(int q=0;q<quizP.length;q++){
            quizP[q] = new JPanel();
            slideP.add(quizP[q], String.valueOf(q));
            quizP[q].setLayout(new GridLayout(0,1));
        }
        
        questions = new JLabel[10];

        for(int q=0;q<questions.length;q++){
        questions[q] = new JLabel();
        switch(q){
            case 0:questions[q].setText("1. Who's Aphrodite married to?");
                break;
            case 1:questions[q].setText("2. Zeus's father, Cronus, swallowed five of his offspring. Out of these options, who did he NOT swallow?");
                break;
            case 2:questions[q].setText("3. Which of these pairs of gods are twins?");
                break;
            case 3:questions[q].setText("4. Who's the heir to Poseidon's throne?");
                break;
            case 4:questions[q].setText("5. Who was told that she was prettier than Aphrodite?");
                break;
            case 5:questions[q].setText("6. What's Athena's sacred animal?");
                break;
            case 6:questions[q].setText("7. How did Persephone become Hades' wife?");
                break;
            case 7:questions[q].setText("8. What god doesn't have a different name for his Roman version?");
                break;
            case 8:questions[q].setText("9. Who was a god/goddess of the Moon that drove a silver chariot pulled by silver horses?");
                break;
            case 9:questions[q].setText("10. Which animal is NOT associated with the Greek monster, the Chimera?");
                break;
            }
        }
        
        choices = new JRadioButton[40];

        for(int c=0;c<choices.length;c++){
        choices[c] = new JRadioButton();
        switch(c){
            case 0:choices[c].setText("Hephaestus");//
                break;
            case 1:choices[c].setText("Ares");
                break;
            case 2:choices[c].setText("Poseidon");
                break;
            case 3:choices[c].setText("Dionysus");
                break;
                
            case 4:choices[c].setText("Ares");//
                break;
            case 5:choices[c].setText("Poseidon");
                break;
            case 6:choices[c].setText("Hera");
                break;
            case 7:choices[c].setText("Hades");
                break;
                
            case 8:choices[c].setText("Ares and Athena");
                break;
            case 9:choices[c].setText("Artemis and Apollo");//
                break;
            case 10:choices[c].setText("Aphrodite and Hephaestus");
                break;
            case 11:choices[c].setText("Hermes and Dionysus");
                break;
                
            case 12:choices[c].setText("Triton");//
                break;
            case 13:choices[c].setText("Percy Jackson");
                break;
            case 14:choices[c].setText("Kymopoleia");
                break;
            case 15:choices[c].setText("Kymopoleia");
                break;
                
            case 16:choices[c].setText("Artemis");
                break;
            case 17:choices[c].setText("Megara");
                break;
            case 18:choices[c].setText("Psyche");//
                break;
            case 19:choices[c].setText("Pallas");
                break;
                
            case 20:choices[c].setText("Peacock");
                break;
            case 21:choices[c].setText("Dove");
                break;
            case 22:choices[c].setText("Deer");
                break;
            case 23:choices[c].setText("Owl");//
                break;
                
            case 24:choices[c].setText("Aphrodite shipped them");
                break;
            case 25:choices[c].setText("Zeus and Demeter arranged their marriage");
                break;
            case 26:choices[c].setText("Hades kidnapped her");//
                break;
            case 27:choices[c].setText("She gave Cerberus his two extra heads");
                break;
                
            case 28:choices[c].setText("Dionysus");
                break;
            case 29:choices[c].setText("Hades");
                break;
            case 30:choices[c].setText("Hermes");
                break;
            case 31:choices[c].setText("Apollo");//
                break;
                
            case 32:choices[c].setText("Amphitrite");
                break;
            case 33:choices[c].setText("Selene");//
                break;
            case 34:choices[c].setText("Hebe");
                break;
            case 35:choices[c].setText("Persephone");
                break;
                
            case 36:choices[c].setText("Lion");
                break;
            case 37:choices[c].setText("Snake");
                break;
            case 38:choices[c].setText("Goat");
                break;
            case 39:choices[c].setText("Bird");//
                break;
            }
        }
        
        buttonGroup = new ButtonGroup[10];
        
        int i=0;
        for(int g=0;g<buttonGroup.length; g++){
            buttonGroup[g] = new ButtonGroup();
            
            buttonGroup[g].add(choices[i]);
            buttonGroup[g].add(choices[i+1]);
            buttonGroup[g].add(choices[i+2]);
            buttonGroup[g].add(choices[i+3]);
            
            i+=4;
        }
        
        bottomP = new JPanel();
        bottomP.setLayout(new FlowLayout());
        bottomP.setBackground(babypink);
        
        whysP = new JPanel[12];
        
        for(int d=0;d<whysP.length;d++){
            whysP[d] = new JPanel();
            whyP.add(whysP[d]);
        }
        
        whyL = new JLabel[12];

        for(int w=0;w<whyL.length;w++){
        whyL[w] = new JLabel();
        
        switch(w){
            case 0:whyL[w].setText("");
                break;
            case 1:whyL[w].setText("<html>1. The correct answer is:"+"<br><br>Hephaestus<br/><br/>"+"Aphrodite was married to Hephaestus – the god of fire, blacksmiths, and metalworking.<html/>");
                break;
            case 2:whyL[w].setText("<html>2. The Correct answer is:"+"<br><br>Ares<br/><br/>"+" Cronus ate Hestia, Demeter, Hera, Hades, and Poseidon at their birth because he was concerned they would be too powerful.<html/>");
                break;
            case 3:whyL[w].setText("<html>3. The Correct answer is:"+"<br><br>Artemis and Apollo<br/><br/>"+" They were the children of Zeus and Leto!<html/>");
                break;
            case 4:whyL[w].setText("<html>4. The Correct answer is:"+"<br><br>Triton<br/><br/>"+"He was the demi-god son of Poseidon and Amphitrite.<html/>");
                break;
            case 5:whyL[w].setText("<html>5. The Correct answer is:"+"<br><br>Psyche<br/><br/>"+"She's the Greek goddess of the soul who was born a mortal woman with beauty that rivaled Aphrodite's.<html/>");
                break;
            case 6:whyL[w].setText("<html>6. The Correct answer is:"+"<br><br>Owl<br/><br/>"+"The owl symbolizes knowledge and wisdom and accompanies Athena, the virgin goddess of wisdom.<html/>");
                break;
            case 7:whyL[w].setText("<html>7. The Correct answer is:"+"<br><br>Hades kidnapped her<br/><br/>"+"Once he got her to the Underworld, she was reluctant to stay, <br/>"+"but he tricked her into eating some pomegranate seeds which – with one bite – <br/>"+"made a person miss the Underworld so badly that she decided to marry Hades.<html/>");
                break;
            case 8:whyL[w].setText("<html>8. The Correct answer is:"+"<br><br>Apollo<br/><br/>"+"The Romans seemed to have adopted him rather late and there was no native Roman equivalent so he got to keep his name!<html/>");
                break;
            case 9:whyL[w].setText("<html>9. The Correct answer is:"+"<br><br>Selene<br/><br/>"+"She's the daughter of the Titans, Hyperion and Theia, and sister of the sun god, Helios, and Eos, goddess of the dawn.<html/>");
                break;
            case 10:whyL[w].setText("<html>10. The Correct answer is:"+"<br><br>Bird<br/><br/>"+"Birds are not associated with the Chimera <br/>"+"The Chimera is a lion with the head of a goat protruding from its back<br/>"+" and a tail that often ended with a snake's head.<html/>");
                break;
            }
        }
        
        ansB = new JButton("Answer");
        ansB.setPreferredSize(new Dimension(300,50));
        bottomP.add(ansB);
        ansB.addActionListener(this);
              
        
        nextB = new JButton("Next");
        nextB.setPreferredSize(new Dimension(300,50));
        bottomP.add(nextB);
        nextB.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            quizCard.next(slideP);
            nextB.setEnabled(true);
            nextB.setText("Next");
            ansB.setEnabled(true); 
            
            if(choices[0].isSelected()
                    || choices[4].isSelected()
                    || choices[9].isSelected()
                    || choices[12].isSelected()
                    || choices[18].isSelected()
                    || choices[23].isSelected()
                    || choices[26].isSelected()
                    || choices[31].isSelected()
                    || choices[33].isSelected()){
                    score+=10;
            }else if(choices[39].isSelected()){
                score+=10;
                String result = "Congrats! You got " + score + " points over 100";
                scoreL.setText(result);
                scoreL.setForeground(darkgreen);
                ansB.setEnabled(false); 
                nextB.setText("Quiz Over");
                nextB.setEnabled(false); 
            }else if(choices[36].isSelected() || choices[37].isSelected() || choices[38].isSelected()){
                String result = "Congrats! You got " + score + " points over 100 ";
                scoreL.setText(result);
                scoreL.setForeground(darkgreen);
                ansB.setEnabled(false); 
                nextB.setText("Quiz Over");
                nextB.setEnabled(false); 
            }
            else{
                String result = " ";
                scoreL.setText(result);
            }
            for (int i = 0; i < 10; i++) {
            buttonGroup[i].clearSelection();
        }
        }
        });
        
        scoreP = new JPanel();
        scoreP.setLayout(new GridBagLayout());
        scoreP.setBackground(babypink);
        
        scoreL = new JLabel(" ");
        scoreL.setFont(new Font("Cooper Black",Font.BOLD,30));
        scoreL.setForeground(Color.black);
        scoreP.add(scoreL);
        
        
        sourceP = new JPanel();
        sourceP.setLayout(new GridBagLayout());
        sourceP.setBackground(babypink);
        
        sourceL = new JLabel("Source: BuzzFeed Community Team. Posted on Dec 8, 2020");
        sourceL.setForeground(Color.black);
        sourceP.add(sourceL);
        
        int b=0;
        for(int p=0;p<10;p++){
            quizP[p].add(questions[p]);
            quizP[p].add(choices[b]);
            quizP[p].add(choices[b+1]);
            quizP[p].add(choices[b+2]);
            quizP[p].add(choices[b+3]);
            choices[b].setBackground(babypink);
            choices[b+1].setBackground(babypink);
            choices[b+2].setBackground(babypink);
            choices[b+3].setBackground(babypink);
            quizP[p].setBackground(babypink);
            b+=4;
        }

        for(int p=0;p<12;p++){
            whysP[p].add(whyL[p]);
            whysP[p].setBackground(peach);
        }

        mainP.add(slideP);
        mainP.add(whyP);
        mainP.add(bottomP);
        mainP.add(scoreP);
        mainP.add(sourceP, BorderLayout.PAGE_END);
        
        f.add(mainP);
        
        quizCard.show(slideP, "0");
        whyCard.show(whyP, "0");
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        whyCard.next(whyP);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new MythodologyQuiz();
            }
        });
    }
    
}

//Source:: BuzzFeed Community Team :: Posted on Dec 8, 2020
//https://www.buzzfeed.com/avengers_olympus/this-quiz-will-determine-how-much-you-know-about-g-7ld9ek3hoi?bfsource=bfocompareon
