package rpggamept;

import java.util.Random;


public class Enemy 
{
   public String name;
    public int weaponId;
    public int hp;
    public int baseAtk;
    public int baseDef;
    public int hitRate;
    public int level;
    
    public Enemy(String name, int weaponId, int hp, int baseAtk, int baseDef, int hitRate, int level){
        this.name = name;
        this.weaponId = weaponId;
        this.hp = hp;
        this.baseAtk = baseAtk;
        this.baseDef = baseDef;
        this.hitRate = hitRate;
        this.level = level;
    }
    
    public int attack(Player player)
    {
        Random rand = new Random();
        Equipment eqp = new Equipment();
        int missRate = rand.nextInt(11);
        if(hitRate > missRate){ // hit
            int playerDamageTaken = this.baseAtk - (player.baseDef + eqp.getArmorDef(player.armorId));
            if(playerDamageTaken <= 0) playerDamageTaken = 0;
            player.hp -= Math.abs(playerDamageTaken);
            System.out.println(this.name + " attacked!");
            System.out.println("You took " + Math.abs(playerDamageTaken) + " damage.");
            System.out.println("Your HP: " + player.hp);
        }
        else{ // miss
            System.out.println(this.name + " attacked but missed!");
            System.out.println("Your HP: " + player.hp);
        }
        
        return player.hp;
    }
    
    //level up 1
    public int attackm1(Player player)
    {
        Random rand = new Random();
        Equipment eqp = new Equipment();
        int missRate = rand.nextInt(11);
        if(hitRate > missRate){ // hit
            int playerDamageTaken = this.baseAtk - (player.baseDef + eqp.getArmorDef(player.armorId));
            if(playerDamageTaken <= 0) playerDamageTaken = 0;
            player.hp -= Math.abs(playerDamageTaken);
            System.out.println(this.name + " attacked!");
            System.out.println("You took " + Math.abs(playerDamageTaken) + " damage.");
            System.out.println("Your HP: " + player.hp);
        }
        else{ // miss
            System.out.println(this.name + " attacked but missed!");
            System.out.println("Your HP: " + player.hp);
        }
        
        return player.hp;
    }
    
    
}
