//import static com.sun.xml.internal.ws.model.RuntimeModeler.capitalize;
import java.io.*;
public class Display { //Charlene, Danica, Daniela, Michaela, Tyra
    public static String playerName;
    public static int choice;
    public static BufferedReader get;
    public static Player player;
    public static Enemy enemy;
    public static int xp;
    public static int maxxp;
   
    public int enemyDamageTaken;
    public int playerDamageTaken;
   
    public static void titleScreen()
    {
        System.out.print("\n = = = = = = = = = = = = = = = ="
                + "\n||                             ||"
                + "\n||    Welcome to Mysterage     ||"
                + "\n||                             ||"
                + "\n = = = = = = = = = = = = = = = =");
    }
   public static void choices()
   {
       System.out.println( "\n[1] New Game\n"
                + "[2] Continue\n"
                + "[3] Exit\n");
       
   }
   public void playerStatus()
   {
       System.out.println(playerName+"|XP|");
   }

    public static void getName()throws IOException{
        BufferedReader get = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\n\nEnter name: ");
        String name = get.readLine();
        //String capName = capitalize(name);
        playerName = name;
        System.out.println("\nWelcome "+playerName+"!");
    }
   
    public static void displayBattleMenu(){
        System.out.println("\n[1] Attack\n"
                + "[2] Defend\n"
                + "[3] Run\n"
                + "[4] Items\n"
                + "[5] Status\n");
    }
    public static void itemMenu(Player player, Items item){
        int[] items = player.items;
        System.out.println("== Your items ==");
       
        for(int i = 1; i <= items.length; i+=1){
            if(items[i-1] == -1)
                System.out.println("Pocket ["+ i +"] No item.");
            else
                System.out.println("Pocket ["+ i +"] " + item.getItemName(items[i-1]));
        }
    }
    public void enemyHealthbar(Enemy enemy)
    {
        for(int eH=0;eH<enemy.xp;eH++)
        {
        System.out.print("♡");
        }
        System.out.print("\n");
    }
    public void enemyHealthbarb(Enemy enemyb)
    {
        for(int eHb=0;eHb<enemyb.xp;eHb++)
        {
        System.out.print("♡");
        }
        System.out.print("\n");
    }
    public void playerHealthbar(Player player)
    {
        for(int pH=0;pH<player.xp;pH++)
        {
        System.out.print("♡");
        }
        System.out.print("\n");
    }
    public static void chooseEatKeepIgn() {
        System.out.println("[1] Eat"
                + "\n[2] Ignore");
    }
    public static void dashes()
    {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    public static void presscontinue() throws IOException
    {
        BufferedReader get = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\n[Press enter to continue...]");
        get.readLine();
    }
    public static void gameover() {
        System.out.println(playerName + " Died!") ;
        System.out.println("GAME OVER!");
        System.exit(0);
    }
    
    public static void turnLoR(){
        Dialogue.twoPath();
        System.out.println("\n[1] Turn Left\n"
                + "[2] Turn Right");
    }
}
