import java.util.Random;
import java.io.*;
public class Player //Charlene, Danica, Daniela, Michaela, Tyra
{
    public String name;
    public int xp;
    public int maxxp;
    public int attack;
    public int defense;
    public int baseAtk;
    public int baseDef;
    public int weaponId;
    public int amuletId;
    public Enemy enemy;
    public Enemy enemyb;
    public int enemyDamageTaken;
    public int[] items = new int[5];
   
    public Player(String name,int xp, int attack, int defense, int weaponId, int amuletId, int baseAtk, int baseDef) {
        this.name = name;
        this.baseAtk = 0;
        this.baseDef = 0;
        this.weaponId = weaponId;
        this.amuletId = amuletId;
        this.xp = xp;
        this.maxxp = 80;
        // items
        items[0] = 0; //"Sayote (Restores 5 XP)"
        items[1] = 1; // "Chicken oil (Restores 10 XP)"
        items[2] = 2; //  "Knorr cubes (Restores 15 XP)"
        items[3] = 3; // "Bagoong (Deals 5 damage to the player)"
        items[4] = 4; // "Suka (Deals 10 damage to the player)"
    }
//overload
    public int attack(Enemy enemy, int turn) throws IOException{
        Random rand = new Random();
        Equipment eqp = new Equipment();
        int roll = rand.nextInt(2);
        if(roll > 0){ // hit
            int playerDamageGiven = this.baseAtk + eqp.getWeaponDamage(this.weaponId);
            int enemyDamageTaken = enemy.baseDef - playerDamageGiven;
            if(enemyDamageTaken >= 0) playerDamageGiven = 0;
            enemy.xp = enemy.xp - Math.abs(enemyDamageTaken);
            System.out.println(Display.playerName+", you attacked with your " + eqp.getWeaponName(this.weaponId));
            System.out.println(enemy.name + " took " + Math.abs(enemyDamageTaken) + " damage.");
            if(enemy.xp <= 0){
                System.out.println("Enemy fell down!");
                System.out.println("VICTORY! Total number of turns: " + turn);
                System.out.println("Remaining XP: " + this.xp);
                Display.presscontinue();
            }
            else System.out.print("Enemy XP:" + enemy.xp+"\t");
            Display dis = new Display();
            dis.enemyHealthbar(enemy);
        }
        else{ // miss
            System.out.println("You attacked with your " + eqp.getWeaponName(this.weaponId) + " but missed!");
            System.out.print("Enemy XP:" + enemy.xp+"\t");
            Display dis = new Display();
            dis.enemyHealthbar(enemy);
        }
        return enemy.xp;
    }
    public int attack(Enemy enemy, Enemy enemyb, int turn) throws IOException{
        Random rand = new Random();
        Equipment eqp = new Equipment();
        int roll = rand.nextInt(2);
        if(roll > 0){ // hit
            int playerDamageGiven = this.baseAtk + eqp.getWeaponDamage(this.weaponId);
            int enemyDamageTaken = enemy.baseDef - playerDamageGiven;
            if(enemyDamageTaken >= 0) playerDamageGiven = 0;
            enemy.xp = enemy.xp - Math.abs(enemyDamageTaken);
            enemyb.xp = enemyb.xp - Math.abs(enemyDamageTaken);
            System.out.println(Display.playerName+", you attacked with your " + eqp.getWeaponName(this.weaponId));
            System.out.println(enemy.name + " took " + Math.abs(enemyDamageTaken) + " damage.");
            if(enemy.xp <= 0){
                System.out.println("Enemy fell down!");
                System.out.println("VICTORY! Total number of turns: " + turn);
                System.out.println("Remaining XP: " + this.xp);
                Display.presscontinue();
            }
            else System.out.print("Enemy XP:" + enemy.xp+"\t");
            Display dis = new Display();
            dis.enemyHealthbar(enemy);
            
            int enemyDamageTakenb = enemyb.baseDef - playerDamageGiven;
            if(enemyDamageTakenb >= 0) playerDamageGiven = 0;
            enemy.xp = enemy.xp - Math.abs(enemyDamageTakenb);
            enemyb.xp = enemyb.xp - Math.abs(enemyDamageTakenb);
            System.out.println(enemyb.name + " took " + Math.abs(enemyDamageTakenb) + " damage.");
            if(enemyb.xp <= 0){
                System.out.println("Enemy fell down!");
                System.out.println("VICTORY! Total number of turns: " + turn);
                System.out.println("Remaining XP: " + this.xp);
                Display.presscontinue();
            }
            else System.out.print("Enemy XP:" + enemyb.xp+"\t");
            dis.enemyHealthbar(enemyb);
        }
        else{ // miss
            System.out.println("You attacked with your " + eqp.getWeaponName(this.weaponId) + " but missed!");
            System.out.print("Enemy XP:" + enemy.xp+"\t");
            Display dis = new Display();
            dis.enemyHealthbar(enemy);
        }
        return enemy.xp;
    }
}

