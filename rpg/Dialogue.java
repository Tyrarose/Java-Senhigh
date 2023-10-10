import java.io.*;

public class Dialogue //Charlene, Danica, Daniela, Michaela, Tyra
{
    //public static BufferedReader get;
    public static void showIntroContinue() throws IOException
    {
        Display.dashes();
        System.out.print("You were sound asleep in your room "+Display.playerName +".");
        Display.dashes();
        Display.presscontinue();
    }

    public static void showIntro() throws IOException
    {
        Display.dashes();
        System.out.print("You were sound asleep in your room "+Display.playerName +".\n"
        + "Suddenly, you heard heavy steps approaching your room.\n"
        + "The door opened and a mysterious man appeared.\n"
        + "You were startled but he said with a calm voice:\n"
        + "\"Don't be afraid my child. I'm not going to hurt you.\"\n"
        + "\"Who are you and what do you want from me?\", you asked the man.");
        Display.dashes();
        Display.presscontinue();
    }
   
    public static void showGameStory() throws IOException
    {
        Display.dashes();
        System.out.print("\"I need your help "+Display.playerName +". My world is in a catastrophe.\"\n"
        + "\"World? What world? What do you mean? Earth?\"\n"
        + "\"No, not Earth. I am from Sayothěarth.\"\n"
        + "\"Come with me and I'll show you.\"\n"
        +"\n"
        + "As curious as ever, you got up out of bed and started following him.");
        Display.dashes();
        Display.presscontinue();
    }
   
    public static void showWorld() throws IOException
    {
        Display.dashes();
        System.out.print("In front of you was a huge portal.\n"
        + "In a blink of an eye, you found yourself in the same room.\n"
        + "\"What? Why are we here again?\"\n"
        + "\"No, this is not Earth. We are here in Sayothěarth.\"\n"
        + "\"Your world and my world just looks the same.\"\n"
        + "\"From this moment on, you will be on your own. It is up to you to discover"
        + "\n what is happening here.\"\n"
        + "\n"
        + "\"If you succeed in your mission, you will receive a great reward. \"");
        Display.dashes();
        Display.presscontinue();
    }
    public static void showGameWorld() throws IOException
    {
        Display.dashes();
        System.out.print("Then suddenly the man disappeared.\n"
        + "\n"
        + "\"Wait! Where are you going?!\"\n"
        + "Then killing silence filled the room. You roamed around your house, "
        + "\nfound a sword and picked it up.\n"
        + "You went out of your house. The sun is already setting.\n"
        + "You remembered that \"demons\" would appear during the night.\n"
        + "As you were walking in the woods, you heard a smirk.");
        Display.dashes();
    }
    public static void showchap1()
    {
        System.out.println("\n = = = = = = = = = = = = = = = ="
        + "\n||  CHAPTER 1: INTO THE WOODS  ||"
        + "\n = = = = = = = = = = = = = = = ="      
        + "\n\n\"Oh, look who it is,\" said a demon with a yellow glowing heart.\n"
        + "Then suddenly, he attacked you"+Display.playerName+".");  
    }
    public static void showIntoTheWoods()
   {
        //kill demon success stab hart
        //heard a sound and follow leads to cave
        //chicken demon battle
        Display.dashes();
        System.out.print("As the demon was dying, he uttered something you can't believe."
        + "\n\"You think you're no different from us?\"");
        Display.dashes();
    }
    //another method
    //alis cave //earn items
    //morninbg
    //continue
    // items  health or paminta bomb
    public static void showGains()
    {
        System.out.println("You successfully killed the demon. You earned 10 XP.");
    }
    ///////////////////////////////////////////extras
    public static void bonus1()
    {
        System.out.println("You saw a sayote...\n");
        Display.chooseEatKeepIgn();
    }
    public static void bonusEat()
    {
        System.out.println("You eat the sayote and gain \n"
                +"> HP increased by max\n"
                + "and you continued walking\n");
    }
    public static void bonusIgn()
    {
        System.out.println("You ignored the sayote...\n"
                + "and countinued walking\n");
    }
   
    public static void unluck()
    {
        System.out.println("You saw a bagoong\n");
        Display.chooseEatKeepIgn();
    }
    public static void unluckWaley()
    {
        System.out.println("You eat the bagoong and ... \n"
                +"> HP decreased by -10\n"
                + "and you realize what you've done and regret for a few second\n"
                +"and countinued walking\n");
    }
    ///////////////////////////////////////////end of extras
   public static void storyhere()
   {
       System.out.println("story");
   }
   public static void continueGameStory()
{
System.out.println("Balakajack");
}
public static void showCabin() throws IOException
{
System.out.println("­\nAt last, you saw the sun rays peaking through the trees.\n"
+ "Exhausted on running and escaping demons for the whole night,\n"
+ "you went inside a cabin you found in the outskirts of the forest and entered."
+ "\"Good morning dear, how may I help you?\n"
+ "\"I would like a room,\" you said. Then she gave you a key."
+ "You went to your room and slept...");
Display.presscontinue();
}
public static void showChap2()
{
    System.out.println(""
        + "\n = = = = = = = = = = = = = = = ="
        + "\n||  CHAPTER 2: INTO THE BEACH  ||"
        + "\n = = = = = = = = = = = = = = = =");  
System.out.println("­Then...you woke up because you heard some noise.\n"
+ "You looked out of the window and it is already dark.\n"
+ "You heard a group of demons talking about stealing something.\n"
+ "They said something about \"the recipe\" and going \"across the waters\" \n"
+ "You went out of the window and found yourself on a beach.");
}
public static void showChap3() throws IOException
{
System.out.println(""
        + "\n = = = = = = = = = = = = = = = ="
        + "\n||  CHAPTER 3: INTO THE TUNNEL  ||"
        + "\n = = = = = = = = = = = = = = = ="
        + "Now you entered the tunnel and saw another portal.\n"
        + "As you were entering the portal, you felt that the temperature was getting higher.\n"
        + "When you came out of the portal, you saw a huge volcano."
        + "You tried finding clues as to where you were and what you were supposed to do.\n"
        + "It was weird because you have not encountered any demons even if you already walked far."
        + "Then you found a castle.\n");
        Display.presscontinue();
}
public static void showFinalBattle() throws IOException
{
    System.out.println("You entered.\n"
    + "You can hear no sound of any demons.\n"
    + "But something feels off.\n"
    + "Then suddenly the door behind you shut.\n"
    + "A demon with a red glowing heart stood in front of you, ready to attack.");
}
public static void showBeach () throws IOException
    {
        System.out.println("You tried listening more to what the demons were discussing.\n"
        + "Demon 1: \"What should we do then?\n"
        + "Demon 2: \"We will leave at 9pm. Me and my troop will enter from the South. You will be on the ... \""
        + "...and so went the plan.\n"
        + "Then you heard something that caught your attention.\n"
        + "\" Poor humans. If only that boy is alive ha ha ha\"\n"
        + "\"But if by the slightest chance he is alive, he should never enter the tunnel.\"");
        Display.presscontinue();
       
    }
   public static void showLifeLesson()
   {
      System.out.println("We have different goals and dreams in life.\n"
      + "But accomplishing them would take more than a night.\n "
      + "And surely, true success would not just pop-out out of nowhere.\n"
      + "True success comes with hardships. Sometimes even demon-like.\n"
      + "But if we endure and persevere towards our goal, most likely, we will succeed.\n\n"
      + "Thank you for playing this game. You may now enjoy your TINOLA.");
   }
   public static void showTunnel() throws IOException
   {
      System.out.println("You realized that all answers would be found on \"the tunnel\", so you decided to find it."
      + "You walked discreetly so you would not be seen by any demons.\n"
      + "At the end of the sand bars, you saw a tunnel.\n"
      + "You entered it and found a portal in the end.\n");
      Display.presscontinue();
   }
   public static void showIntoTheTunnel()
   {
      System.out.println("At the entrance of the tunnel, a demon with a green glowing heart was posted as a guard.\n"
     
      + "You did not notice him immediately.\n"
      + "He attacked you as soon as he saw you.");
   }
   public static void showEnding()throws IOException
   {
       System.out.println("After defeating the demon, you felt dizzy.\n"
       + "It was like the world was spinning and your vision started to blur more and more.\n"
       + "Then you fell to the ground.\n\n"
       + "You slowly opened your eyes.\n"
       + "\"This place looks very familiar,\" you said to yourself.\n"
       + "You came into realization and came back to your senses.\n\n"
       + "You are back in your room.\n"
       + "You looked around you, and saw on your table a bowlful of some kind of soup.\n"
       + "Then beside it was a note from the mysterious man: ");
        Display.presscontinue();
   }
   public static void twoPath()
    {
        System.out.println("\nAs you were running you saw two pathways."
                + "\n One going to the right and the other to the left. ");
    }
    public static void enemyDying()
    {
        System.out.println("You've killed the demon and it turned to ashes.");
    }
   
   
}