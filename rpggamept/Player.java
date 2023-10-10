package rpggamept;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static rpggamept.MainClass.enemy;
import static rpggamept.MainClass.sc;

public class Player
{
    Random rand = new Random();
    int missRate = rand.nextInt(11);
    Equipment eqp = new Equipment();
   public String name;
    public int skillId;
    public int armorId;
    public int hp;
    public int maxHp;
    public int baseAtk;
    public int baseDef;
    public int hitRate;
    public int[] items = new int[5];
    public int[] skills = new int[5];
    
    //Level up 1
    public int hp1;
    public int maxHp1;
    public int baseAtk1;
    public int baseDef1;
    public int hitRate1;
    
    //Level up 2
    public int hp2;
    public int maxHp2;
    public int baseAtk2;
    public int baseDef2;
    public int hitRate2;
    
    public Player(String name, int skillId, int armorId, int hp, int maxHp, int baseAtk, int baseDef, int hitRate)
    {
        
        this.name = name;
        this.skillId = skillId;
        this.armorId = armorId;
        this.hp = hp;
        this.maxHp = maxHp;
        this.baseAtk = baseAtk;
        this.baseDef = baseDef;
        this.hitRate = hitRate;
        
        /*//Level up 1
        this.hp = hp;
        this.maxHp = maxHp;
        this.baseAtk = baseAtk;
        this.baseDef = baseDef;
        this.hitRate = hitRate;*/
        
        //Level up 2
        this.hp2 = 1500;
        this.baseAtk2 = 1250;
        this.baseDef2 = 850;
        this.hitRate2 = 100;
        
        // items
        items[0] = 0; // potion
        items[1] = 1; // Armor
        items[2] = 2; // Hi pots
        items[3] = 2; // Hi pots
        items[4] = 3; // Divine Judgement
        
        
        
    }
    
    
     
    
    public int attack(Enemy enemy, int turn)
    {
        Random rand = new Random();
        Equipment eqp = new Equipment();
        int missRate = rand.nextInt(11);
        if(hitRate > missRate){ // hit
            int playerDamage = this.baseAtk + eqp.getSkillDamage0();
            int enemyDamageTaken = enemy.baseDef - playerDamage;
            if(enemyDamageTaken >= 0) playerDamage = 0;
            enemy.hp -= Math.abs(enemyDamageTaken);
            System.out.println("You attacked with your " + eqp.getSkillName5());
            System.out.println(enemy.name + " took " + Math.abs(enemyDamageTaken) + " damage.");
            if(enemy.hp <= 0){
                System.out.println("Enemy fell down!");
                System.out.println("VICTORY! Total number of turns: " + turn);
                System.out.println("Remaining HP: " + this.hp);
                System.out.println("[Press enter to continue...]");
                String en = sc.nextLine();
            }
            else System.out.println("Enemy HP: " + enemy.hp);
        }
        else{ // miss
            System.out.println("You attacked with your " + eqp.getSkillName5() + " but missed!");
            System.out.println("Enemy HP: " + enemy.hp);
        }
        
        return enemy.hp;
    }
    
        public int skill(Enemy enemy, int turn)
    {
        
        System.out.println("====Your Skills====");
        System.out.println("[1]Firebolt\n"
                + "[2]None\n"
                + "[3]None\n"
                + "[4]None\n"
                + "[5]None");
        
        System.out.print("Choose skill: ");
        int choice = sc.nextInt();
        switch (choice)
        {
            case 1:
                
                if(hitRate > missRate){ // hit
                int playerDamage = this.baseAtk + eqp.getSkillDamage0();
                int enemyDamageTaken = enemy.baseDef - playerDamage;
            if(enemyDamageTaken >= 0) playerDamage = 0;
            enemy.hp -= Math.abs(enemyDamageTaken);
            System.out.println("You attacked with your " + eqp.getSkillName0());
            System.out.println(enemy.name + " took " + Math.abs(enemyDamageTaken) + " damage.");
            if(enemy.hp <= 0){
                System.out.println("Enemy fell down!");
                System.out.println("VICTORY! Total number of turns: " + turn);
                System.out.println("Remaining HP: " + this.hp);
                System.out.println("[Press enter to continue...]");
                String en = sc.nextLine();
            }
            else System.out.println("Enemy HP: " + enemy.hp);
        }
        else{ // miss
            System.out.println("You attacked with your " + eqp.getSkillName0() + " but missed!");
            System.out.println("Enemy HP: " + enemy.hp);
            
        }
            break;
                
            case 2:
                
        break;
                
            case 3:
                
        break;
                
            case 4:
                
        break;
                
            case 5:
                
        break;
        
    }
        
    return enemy.hp;
    
}
        
        
        
        
        
        
        
     public int attack1(Enemy enemy, int turn)
    {
        Random rand = new Random();
        Equipment eqp = new Equipment();
        int missRate = rand.nextInt(11);
        if(hitRate > missRate){ // hit
            int playerDamage = this.baseAtk + eqp.getSkillDamage5();
            int enemyDamageTaken = enemy.baseDef - playerDamage;
            if(enemyDamageTaken >= 0) playerDamage = 0;
            enemy.hp -= Math.abs(enemyDamageTaken);
            System.out.println("\nYou attacked with your " + eqp.getSkillName5());
            System.out.println(enemy.name + " took " + Math.abs(enemyDamageTaken) + " damage.");
            if(enemy.hp <= 0){
                System.out.println(enemy.name + " fell down!");
                System.out.println("Remaining HP: " + this.hp);
                System.out.println("[Press enter to continue...]");
                String en = sc.nextLine();
            }
            else System.out.println("Enemy HP: " + enemy.hp);
        }
        else{ // miss
            System.out.println("You attacked with your " + eqp.getSkillName5() + " but missed!");
            System.out.println("Enemy HP: " + enemy.hp);
        }
        
        return enemy.hp;
    }
    
     public int skill1(Enemy enemy, int turn)
    {
        
        System.out.println("====Your Skills====");
        System.out.println("[1]Firebolt\n"
                + "[2]Soul Breaker\n"
                + "[3]Mighty Five Runes Spin\n"
                + "[4]Trap of the Sage\n"
                + "[5]Break Individually");
        
        System.out.print("Choose skill: ");
        int choice = sc.nextInt();
        switch (choice)
        {
            case 1:
                
                if(hitRate > missRate){ // hit
                int playerDamage = this.baseAtk + eqp.getSkillDamage0();
                int enemyDamageTaken = enemy.baseDef - playerDamage;
            if(enemyDamageTaken >= 0) playerDamage = 0;
            enemy.hp -= Math.abs(enemyDamageTaken);
            System.out.println("\nYou attacked with your " + eqp.getSkillName0());
            System.out.println(enemy.name + " took " + Math.abs(enemyDamageTaken) + " damage.");
            if(enemy.hp <= 0){
                System.out.println(enemy.name + " fell down!");
                System.out.println("Remaining HP: " + this.hp);
                System.out.println("[Press enter to continue...]");
                String en = sc.nextLine();
            }
            else System.out.println("Enemy HP: " + enemy.hp);
        }
        else{ // miss
            System.out.println("You attacked with your " + eqp.getSkillName0() + " but missed!");
            System.out.println("Enemy HP: " + enemy.hp);
            
        }
            break;
                
            case 2:
                if(hitRate > missRate){ // hit
                int playerDamage = this.baseAtk + eqp.getSkillDamage1();
                int enemyDamageTaken = enemy.baseDef - playerDamage;
            if(enemyDamageTaken >= 0) playerDamage = 0;
            enemy.hp -= Math.abs(enemyDamageTaken);
            System.out.println("\nYou attacked with your " + eqp.getSkillName1());
            System.out.println(enemy.name + " took " + Math.abs(enemyDamageTaken) + " damage.");
            if(enemy.hp <= 0){
                System.out.println(enemy.name + " fell down!");
                System.out.println("Remaining HP: " + this.hp);
                System.out.println("[Press enter to continue...]");
                String en = sc.nextLine();
            }
            else System.out.println("Enemy HP: " + enemy.hp);
        }
        else{ // miss
            System.out.println("You attacked with your " + eqp.getSkillName1() + " but missed!");
            System.out.println("Enemy HP: " + enemy.hp);
            
        }
                
        break;
                
            case 3:
                if(hitRate > missRate){ // hit
                int playerDamage = this.baseAtk + eqp.getSkillDamage2();
                int enemyDamageTaken = enemy.baseDef - playerDamage;
            if(enemyDamageTaken >= 0) playerDamage = 0;
            enemy.hp -= Math.abs(enemyDamageTaken);
            System.out.println("\nYou attacked with your " + eqp.getSkillName2());
            System.out.println(enemy.name + " took " + Math.abs(enemyDamageTaken) + " damage.");
            if(enemy.hp <= 0){
                System.out.println(enemy.name + " fell down!");
                System.out.println("Remaining HP: " + this.hp);
                System.out.println("[Press enter to continue...]");
                String en = sc.nextLine();
            }
            else System.out.println("Enemy HP: " + enemy.hp);
        }
        else{ // miss
            System.out.println("You attacked with your " + eqp.getSkillName2() + " but missed!");
            System.out.println("Enemy HP: " + enemy.hp);
            
        }
                
        break;
                
            case 4:
                if(hitRate > missRate){ // hit
                int playerDamage = this.baseAtk + eqp.getSkillDamage3();
                int enemyDamageTaken = enemy.baseDef - playerDamage;
            if(enemyDamageTaken >= 0) playerDamage = 0;
            enemy.hp -= Math.abs(enemyDamageTaken);
            System.out.println("\nYou attacked with your " + eqp.getSkillName3());
            System.out.println(enemy.name + " took " + Math.abs(enemyDamageTaken) + " damage.");
            if(enemy.hp <= 0){
                System.out.println(enemy.name + " fell down!");
                System.out.println("Remaining HP: " + this.hp);
                System.out.println("[Press enter to continue...]");
                String en = sc.nextLine();
            }
            else System.out.println("Enemy HP: " + enemy.hp);
        }
        else{ // miss
            System.out.println("You attacked with your " + eqp.getSkillName3() + " but missed!");
            System.out.println("Enemy HP: " + enemy.hp);
            
        }
                
        break;
                
            case 5:
                if(hitRate > missRate){ // hit
                int playerDamage = this.baseAtk + eqp.getSkillDamage4();
                int enemyDamageTaken = enemy.baseDef - playerDamage;
            if(enemyDamageTaken >= 0) playerDamage = 0;
            enemy.hp -= Math.abs(enemyDamageTaken);
            System.out.println("\nYou attacked with your " + eqp.getSkillName4());
            System.out.println(enemy.name + " took " + Math.abs(enemyDamageTaken) + " damage.");
            if(enemy.hp <= 0){
                System.out.println(enemy.name + " fell down!");
                System.out.println("Remaining HP: " + this.hp);
                System.out.println("[Press enter to continue...]");
                String en = sc.nextLine();
            }
            else System.out.println("Enemy HP: " + enemy.hp);
        }
        else{ // miss
            System.out.println("You attacked with your " + eqp.getSkillName4() + " but missed!");
            System.out.println("Enemy HP: " + enemy.hp);
            
        }
                
        break;
        
    }
        
    return enemy.hp;
    
}
}

 