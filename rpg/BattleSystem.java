import java.io.IOException;
import java.io.*;

public class BattleSystem //Charlene, Danica, Daniela, Michaela, Tyra
{
    public static BufferedReader get;
    public static Enemy enemy;
    public static Player player;
    private static Items Items = new Items();    
    int choice;
    public int xp;
    public int maxxp;
    public int weaponId;
    public int amuletId;
    public int WeaponDamage;
    public int WeaponName;

    public int[] items = new int[5];
    public static void battle(Enemy enemy) throws IOException{
        //dito nareread yung PLAYER, hindi pwede yung enemy idkw
        player = new Player(Display.playerName,20,10,10,0,0,0,0);
        BufferedReader get = new BufferedReader(new InputStreamReader(System.in));
        int turn = 1;
        System.out.println("\n===== BATTLE START! =====");
        Display dis = new Display();
        System.out.print(Display.playerName+":\t\t");
        dis.enemyHealthbar(enemy);
        System.out.print(enemy.name+":\t");
        dis.playerHealthbar(player);
            //error here
            while(enemy.xp > 0){
            System.out.print("\n***Turn "+turn+"***");
            System.out.println("\nWhat do you want to do "+Display.playerName+"?");
            Display.displayBattleMenu();
            System.out.print("Enter your choice: ");
            Short choice = Short.parseShort(get.readLine());
            switch (choice) {
                case 1://attack
                    enemy.xp = player.attack(enemy, turn);
                    break;
                case 2://defend
                    break;
                case 3://run
                    Display.turnLoR(); //left or right
                    System.out.print("Enter your choice: ");
                    short RoL = Short.parseShort(get.readLine());
                    switch(RoL){
                        case 1: // turn left
                            Dialogue.bonus1(); //saw sayote
                            System.out.print("Enter your choice: ");
                            short bonusone = Short.parseShort(get.readLine());
                                switch(bonusone){
                                    case 1:
                                        Dialogue.bonusEat();//eat sayote
                                        break;
                                    case 2:
                                        Dialogue.bonusIgn(); //ignored sayote
                                        break;
                                    }
                            break;
                        case 2: //turn right
                            System.out.print("\n[#]"+enemy.name+" followed you.");
                            break;
                                }
                    break;
                case 4://Items;
                    item();
                    break;
                case 5://status error pa
                    status();
                    break;  
            }
            if(enemy.xp > 0) {
                player.xp = enemy.attack(player);
                if (player.xp <= 0) {
                    System.out.println("GAME OVER!");
                    System.exit(0);
                }
            }
            turn += 1;
        }
    }
    
   //overload
    public static void battle(Enemy enemy, Enemy enemyb) throws IOException{
        //dito nareread yung PLAYER, hindi pwede yung enemy idkw
        player = new Player(Display.playerName,20,10,10,0,0,0,0);
        BufferedReader get = new BufferedReader(new InputStreamReader(System.in));
        int turn = 1;
        System.out.println("\n===== BATTLE START! =====");
        Display dis = new Display();
        System.out.print(Display.playerName+":\t\t");
        dis.playerHealthbar(player);
        System.out.print(enemy.name+":\t");
        dis.enemyHealthbar(enemy);
        System.out.print(enemyb.name+":\t");
        dis.enemyHealthbarb(enemyb);
            //error here
            while(enemy.xp > 0){
            System.out.print("\n***Turn "+turn+"***");
            System.out.println("\nWhat do you want to do "+Display.playerName+"?");
            Display.displayBattleMenu();
            System.out.print("Enter your choice: ");
            Short choice = Short.parseShort(get.readLine());
            switch (choice) {
                case 1://attack
                    enemyb.xp = player.attack(enemy, enemyb, turn);
                    break;
                case 2://defend
                    break;
                case 3://run
                    Display.turnLoR(); //left or right
                    System.out.print("Enter your choice: ");
                    short RoL = Short.parseShort(get.readLine());
                    switch(RoL){
                        case 1: // turn left
                            Dialogue.bonus1(); //saw sayote
                            System.out.print("Enter your choice: ");
                            short bonusone = Short.parseShort(get.readLine());
                                switch(bonusone){
                                    case 1:
                                        Dialogue.bonusEat();//eat sayote
                                        break;
                                    case 2:
                                        Dialogue.bonusIgn(); //ignored sayote
                                        break;
                                    }
                            break;
                        case 2: //turn right
                            System.out.print("\n[#]"+enemy.name+" followed you.");
                            break;
                                }
                    break;
                case 4://Items;
                    item();
                    break;
                case 5://status error pa
                    status();
                    break;  
            }
            if(enemy.xp > 0) {
                player.xp = enemy.attack(player);
                if (player.xp <= 0) {
                    Display.gameover();
                    System.exit(0);
                }
            }
            turn += 1;
        }
    }
   public static void status() throws IOException{
        Display dis = new Display();
        System.out.println("= = = Status = = =");
        System.out.println("Player ");
        System.out.print(Display.playerName+":\t\t");
        dis.playerHealthbar(player);
        
        System.out.println("Enemy ");
        System.out.print(enemy.name+":\t");
        dis.enemyHealthbar(enemy);
        System.out.println();
    }
   
    public static void item() throws IOException{
        BufferedReader get = new BufferedReader(new InputStreamReader(System.in));
        Display.itemMenu(player, Items);
        while(true){
            System.out.print("Select an item to use [type 0 to exit]: ");
            short choice = Short.parseShort(get.readLine());
            if (choice != 0) //meaning 1-5
            {
                int itemId = player.items[choice - 1]; // get item id
                if(itemId != -1){ // check if pocket has item
                    String itemName = Items.getItemName(itemId);
                    String itemType = Items.getItemType(itemId);
                    switch (itemType) {
                        case "xp":
                            player.xp += Items.getItemVal(itemId);
                            if (player.xp > player.maxxp) player.xp = player.maxxp;
                            System.out.println("You used: " + itemName);
                            System.out.println("Your XP is now: " + player.xp + "/" + player.maxxp);
                            player.items[choice - 1] = -1; // remove item
                            break;
                        case "damage":
                            break;
                    }
                    break;
                }
                else
                    System.out.println("No item in pocket!");
            }
           
            else break;
        }
}
//override
    void statusbar() {
        Display dis = new Display();
        System.out.print(Display.playerName+":\t\t");
        dis.enemyHealthbar(enemy);
        System.out.print(enemy.name+":\t");
        dis.playerHealthbar(player);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}