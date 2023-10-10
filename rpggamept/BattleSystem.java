
package rpggamept;

import java.util.Scanner;
import static rpggamept.MainClass.enemy;
import static rpggamept.MainClass.items;
import static rpggamept.MainClass.player;
import static rpggamept.MainClass.sc;


public class BattleSystem
{
    public static void displayBattleMenu()
    {
        System.out.println("[1]Attack\n"
                + "[2]Defend\n"
                + "[3]Skills\n"
                + "[4]Equipment");
    }
    
    public static void itemMenu(Player player, Item item){
        int[] items = player.items;
        System.out.println("== Your items ==");
        
        for(int i = 1; i <= items.length; i+=1){
            if(items[i-1] == -1)
                System.out.println("Pocket ["+ i +"] No item.");
            else
                System.out.println("Pocket ["+ i +"] " + item.getItemName(items[i-1]));
        }
        
        
    }
    
    public static void StatueBattle()
    {
        int turn = 1;
        System.out.println("===== BATTLE START! =====");
            System.out.println(enemy.name + " Encountered!");
            System.out.println("Level: " + enemy.level + "\nHP: " + enemy.hp + "\nAttack: " + enemy.baseAtk
            + "\nDefense: " + enemy.baseDef);
            System.out.println("\nWhat do you want to do?");
            BattleSystem.displayBattleMenu();
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) 
            {
                case 1:
                    enemy.hp = player.attack(enemy, turn);
                    break;
                case 2:
                    break;
                case 3:
                    player.skill(enemy, turn);
                    break;
                case 4:
                    items();
            }
            // enemy attack
            if(enemy.hp > 0) 
            {
                player.hp = enemy.attack(player);
            }
            if (player.hp >= 1) 
                {
                    Scanner sc = new Scanner(System.in);
                    Dialogue.chapdl4();
                    String en = sc.nextLine();
                    Promp();
                    en = sc.nextLine();
                    
                }
            turn += 1;
        
    }
    
    public static void FinalBattle()
    {
        int turn = 1;
        System.out.println("===== BATTLE START! =====");
            System.out.println(enemy.name + " Encountered!");
            System.out.println("Level: " + enemy.level + "\nHP: " + enemy.hp + "\nAttack: " + enemy.baseAtk
            + "\nDefense: " + enemy.baseDef);
            System.out.println("\nWhat do you want to do?");
            BattleSystem.displayBattleMenu();
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) 
            {
                case 1:
                    enemy.hp = player.attack1(enemy, turn);
                    break;
                case 2:
                    break;
                case 3:
                    player.skill1(enemy, turn);
                    break;
                case 4:
                    items();
            }
            // enemy attack
            if(enemy.hp > 0) 
            {
                player.hp = enemy.attack(player);
            }
            if (player.hp <= 6000000) 
                {
                    Scanner sc = new Scanner(System.in);
                    Dialogue.f6();
                    String en = sc.nextLine();
                }
            turn += 1;
        
    }
    
    public static void Promp()
    {
                    System.out.println("----------------------------");
                    System.out.println("DO YOU WANT TO BE A PLAYER\n"
                                       + "(YES OR NO)");
                    System.out.println("----------------------------");
                     Scanner sc = new Scanner(System.in);
                    System.out.print("Enter your choice: ");
                    String ch = sc.nextLine();
                    if(ch.equalsIgnoreCase("YES") || ch.equalsIgnoreCase("yes") || ch.equalsIgnoreCase("Yes"))
                     {
                         String en;
                         Dialogue.chapt2();
                         
                     } 
                     else 
                     {
                      System.out.println("You are Dead.");
                      System.exit(0);
                    }
    }
    

}
