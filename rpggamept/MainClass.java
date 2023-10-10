package rpggamept;

import java.io.IOException;
import java.util.*;

public class MainClass 
{
    public static Player player;
    public static Enemy enemy;
    public static Item item = new Item();
    
    public static Scanner sc;
    
    
    
    public static void main(String[] args) 
    {
        sc = new Scanner(System.in);
        TitleScreen.menu();
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        switch(choice)
        {
            case 1:
                newGame();
                break;
            case 2:
                continue_();
                break;
            case 3:
                System.exit(0);
                break;
                
        }
    }
    
     public static void newGame()
     {
         player = new Player("Zero", 0, 0, 100, 100, 20, 10, 15);
         String en;
        sc = new Scanner(System.in);
        Dialogue.showIntroStory();
        en = sc.nextLine();
        Dialogue.showNewGameStory();
        sc.nextLine();
        chapter1();
        sc.nextLine();
        chapter2();
        sc.nextLine();
        chapter3();
        sc.nextLine();
        chapter4();
        sc.nextLine();
     }
        
        public static void chapter1()
     {
         String en;
        sc = new Scanner(System.in);
        Dialogue.chapdl1();
        en = sc.nextLine();
        Dialogue.chapdl2();
        en = sc.nextLine();
        Dialogue.chapdl3();
        en = sc.nextLine();
        enemy = new Enemy ("STONE STATUE", 0, 10000, 110, 500, 50, 10000);
        BattleSystem.StatueBattle();
         
  
        
    }
        public static void continue_()
        {
            chapter2();
            sc.nextLine();
            chapter3();
            sc.nextLine();
            chapter4();
        }
        
        public static void chapter2()
        {
             String en;
             sc = new Scanner(System.in);
             player = new Player("Zero", 0, 0, 1500, 1500, 1250, 850, 100);
             enemy = new Enemy ("GOBLIN", 0, 800, 500, 70, 3500, 5);
             battle();
             en = sc.nextLine();
             Dialogue.s1();
             en = sc.nextLine();
             player = new Player("Zero", 0, 0, player.hp, 1800, 1350, 900, 150);
             enemy = new Enemy("GOBLING KING", 0 , 1500, 1500, 500, 5000, 15);
             battle();
             en = sc.nextLine();
             Dialogue.s2();
             player = new Player("Zero", 0, 0, player.hp, 4050, 2350, 1000, 750);
             en = sc.nextLine();
             vilInn();
             en = sc.nextLine();
             enemy = new Enemy("PACK OF WOLVES", 0, 1600, 600, 50, 3500, 10);
             battle();
             en = sc.nextLine();
             Dialogue.s3_1();
             en = sc.nextLine();
             Entrance();
             Dialogue.s3_4();
             en = sc.nextLine();
             player = new Player("Zero", 0, 0, player.hp, 5500, 3500, 1250, 1000);
             enemy = new Enemy("ARMY OF BATS", 0, 2500, 900, 100, 3500, 25);
             battle();
             en = sc.nextLine();
             Dialogue.s3_5();
             enemy = new Enemy("VAMPIRE LORD", 0, 9000, 3000, 2500, 3500, 56);
             battle();
             en = sc.nextLine();
             Dialogue.s3_6();
             en = sc.nextLine();
             player = new Player("Zero", 0, 0, player.hp, 14500, 12500, 4000, 9000);
             vilInn2();
             en = sc.nextLine();
             Dialogue.s3_f();
             en = sc.nextLine();  
             enemy = new Enemy("ARCH MAGE OF UNDEAD ZOMBIES", 0, 16500, 13000, 5000, 13000, 150);
             battle();
             
        }
        
        //CHAPTER 3
        public static void chapter3()
        {
            String en;
            sc = new Scanner(System.in);
            player = new Player("Zero", 0, 0, 145000, 145000, 120000, 100000, 90000);
            Dialogue.chapter3();
            en = sc.nextLine();
            enemy = new Enemy("THE BLACKLOCUST", 0, 155000, 130000, 50000, 130000, 190);
            battle();
            en = sc.nextLine();
            Dialogue.a1();
            en = sc.nextLine();
            player = new Player("Zero", 0, 0, player.hp, 250780, 249500, 249450, 249400);
            enemy = new Enemy("ZESUZHA THE BASILISK", 0, 230000, 302400, 165000, 130000, 350);
            battle();
            en = sc.nextLine();
            Dialogue.a2();
            en = sc.nextLine();
            Dialogue.a3();
            en = sc.nextLine();
            player = new Player("Zero", 0, 0, 565900, 565900, 563675, 5757500, 573765);
        }
        
        //CHAPTER 4
        public static void chapter4()
        {
            String en;
            sc = new Scanner(System.in);
            Dialogue.chapter4();
            en = sc.nextLine();
            player = new Player("Zero", 0, 0, 565900, 565900, 563675, 557500, 573765);
            enemy = new Enemy("INFERNAL CROWN", 0, 900000, 742400, 165000, 430000, 350);
            battle();
            en = sc.nextLine();
            player = new Player("Zero", 0, 0, 630900, 630900, 623675, 621500, 620765);
            Dialogue.f1();
            en = sc.nextLine();
            Path();
            Dialogue.f4();
            en = sc.nextLine();
            enemy = new Enemy("TWIN DEMON BEAST MAGE", 0, 850900, 1100675, 700500, 700765, 700);
            battle();
            en = sc.nextLine();
            Dialogue.f4_1();
            en = sc.nextLine();
            Dialogue.f5();
            player = new Player("Zero", 0, 0, 17500900, 17509000, 1745675, 1794050, 1794376);  
            enemy = new Enemy("DEMON GOD", 0, 49500700, 19000500, 1300500, 1900500, 999);
            en = sc.nextLine();
            BattleSystem.FinalBattle();
            en = sc.nextLine();
            Dialogue.f7();
            en = sc.nextLine();
            Dialogue.f8();
            en = sc.nextLine();
            player = new Player("Zero", 0, 0, 99999999, 99999999, 9999999, 9999999, 9999999);  
            enemy = new Enemy("DEMON GOD", 0, 49500700, 19000500, 1300500, 1900500, 999);
            battle();
            en = sc.nextLine();
            Dialogue.f9();
            en = sc.nextLine();
            Dialogue.f10();
            en = sc.nextLine();
            Dialogue.chapter5();
            en = sc.nextLine();
   
            
        }
        
        
        
        
            //********************BATTLE********************
    public static void battle()
    {
        int turn = 1;
        System.out.println("===== BATTLE START! =====");
        System.out.println(enemy.name + " Encountered!");
        System.out.println("Level: " + enemy.level + "\nHP: " + enemy.hp + "\nAttack: " + enemy.baseAtk
        + "\nDefense: " + enemy.baseDef);
        while(enemy.hp > 0){
            System.out.println("\nWhat do you want to do?");
            BattleSystem.displayBattleMenu();
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            System.out.println("\n");
            switch (choice) 
            {
                case 1:
                    enemy.hp = player.attack1(enemy, turn);
                    break;
                case 2:
                    break;
                case 3:
                    ;
                    player.skill1(enemy, turn);
                    break;
                    
                case 4:
                    items();
                    break;
            }
            // enemy attack
            if(enemy.hp > 0) 
            {
                player.hp = enemy.attackm1(player);
                if (player.hp <= 0) {
                    System.out.println("GAME OVER!");
                    System.exit(0);
                }
            }
            turn += 1;
        }
    }

    
    //********************ITEMS********************
     public static void items()
     {
        BattleSystem.itemMenu(player, item);
        while(true){
            System.out.print("Select an item to use [type 0 to exit]: ");
            int choice = sc.nextInt();
            if (choice != 0) {
                int itemId = player.items[choice - 1]; // get item id
                if(itemId != -1){ // check if pocket has item
                    String itemName = item.getItemName(itemId);
                    String itemType = item.getItemType(itemId);
                    switch (itemType) {
                        case "hp":
                            player.hp += item.getItemVal(itemId);
                            if (player.hp > player.maxHp) player.hp = player.maxHp;
                            System.out.println("You used: " + itemName);
                            System.out.println("Your HP is now: " + player.hp + "/" + player.maxHp);
                            player.items[choice - 1] = -1; // remove item
                            break;
                        case "armor":
                            player.baseDef += item.getItemVal(itemId);
                            System.out.println("You used: " + itemName);
                            System.out.println("Your Def is now: " + player.baseDef);
                            break;
                            
                        case "damage":
                            player.baseAtk += item.getItemVal(itemId);
                            System.out.println("You used: " + itemName);
                            System.out.println("Your Atk is now: " + player.baseAtk);
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
     
     
     
     
    //Village In
     public static void vilInn()
     {
         System.out.println("You saw a village!");
         System.out.println("What do you want to do?");
         System.out.println("[1]Continue Journey\n"
                 + "[2]Rest and replenish your health");
         System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            System.out.println("\n");
            switch (choice) 
            {
                case 1:
                    Dialogue.s3();
                    String en = sc.nextLine();
                    break;
                case 2:
                    System.out.println("You wake up and replenish your health!\nYOur HP is now: " + (player.hp = player.maxHp));
                    vilInn();
                    break;
            }
     }
     
     //Village 2
     public static void vilInn2()
     {
         System.out.println("You saw a village!");
         System.out.println("What do you want to do?");
         System.out.println("[1]Continue Journey\n"
                 + "[2]Rest and replenish your health");
         System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            System.out.println("\n");
            switch (choice) 
            {
                case 1:
                    Dialogue.s3_7();
                    String en = sc.nextLine();
                    break;
                case 2:
                    System.out.println("You wake up and replenish your health!\n Your HP is now: " + (player.hp = player.maxHp));
                    vilInn2();
                    break;
            }
     }
     
     public static void Entrance()
     {
         String en;
         System.out.println("Which way you want to go?");
         System.out.println("[1]1st Entrance\n"
                 + "[2]2nd Entrance");
         System.out.print("Enter your choice: ");;
            int choice = sc.nextInt();
            System.out.println("\n");
            switch (choice) 
            {
                case 1:
                    Dialogue.s3_2();
                    player = new Player("Zero", 0, 0, player.hp, 4500, 2600, 1000, 1500);
                    enemy = new Enemy("PACK OF WOLVES", 0, 1600, 600, 50, 3500, 10);
                    battle();
                    en = sc.nextLine();
                    System.out.println("The Wolf King heard the war cry of his pack of wolves, he suddenly rushes over to Zero\n"
                            + "[Press Enter to continue....]");
                    en = sc.nextLine();
                    player = new Player("Zero", 0, 0, player.hp, 4500, 2600, 1000, 1500);
                    enemy = new Enemy("WOLF KING", 0, 3500, 1500, 500, 5000, 35);
                    en = sc.nextLine();
                    battle();
                    en = sc.nextLine();
                    Dialogue.s3_3();
                    en = sc.nextLine();
                    break;
                case 2:
                    System.out.println("Zero found out that this entrance leads to the Wolf King\n"
                            + "[Press Enter to continue....]");
                    en = sc.nextLine();
                    player = new Player("Zero", 0, 0, player.hp, 4500, 2600, 1000, 1500);
                    enemy = new Enemy("WOLF KING", 0, 4500, 1500, 500, 5000, 35);
                    battle();
                    en = sc.nextLine();
                    Dialogue.s3_3();
                    en = sc.nextLine();
                    break;
            }
     }
     
      public static void Path()
     {
         String en;
         System.out.println("Which way you want to go?");
         System.out.println("[1]Left Path\n"
                 + "[2]Right Path");
         System.out.print("Enter your choice: ");;
            int choice = sc.nextInt();
            System.out.println("\n");
            switch (choice) 
            {
                case 1:
                    Dialogue.f2_l();
                    en = sc.nextLine();
                    enemy = new Enemy("ZOR'ATHIK", 0, 1050000, 742400, 165000, 130000, 400);
                    battle();
                    en = sc.nextLine();
                    Dialogue.f3_l();
                    en = sc.nextLine();
                    player = new Player("Zero", 0, 0, 950900, 950900, 945675, 940500, 943765);
                    break;
                case 2:
                    Dialogue.f2_r();
                    en = sc.nextLine();
                    enemy = new Enemy("GRIMFANGS", 0, 1050000, 742400, 165000, 130000, 400);
                    battle();
                    en = sc.nextLine();
                    Dialogue.f3_r();
                    en = sc.nextLine();
                    player = new Player("Zero", 0, 0, 950900, 950900, 945675, 940500, 943765);
                    break;
            }
     }
     
}
