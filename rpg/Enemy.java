import java.util.Random;

public class Enemy { //Charlene, Danica, Daniela, Michaela, Tyra
   
    public String name;
    public int xp;
    public int maxXp;
    public int baseAtk;
    public int baseDef;
    public int attack;
    public int playerDamageTaken;
    public Player player;
   
    public Enemy(String name, int xp, int defense, int attack){
        this.name = name;
        this.xp = xp;
        this.attack = attack;
    }
   //OVERLOAD
    public int attack(Player player){    
        Random rand = new Random();
        Equipment eqp = new Equipment();
        int roll = rand.nextInt();
        if(roll > 0){ // hit
            playerDamageTaken = this.baseAtk + attack;
            if(playerDamageTaken <= 0) playerDamageTaken = 0;
            player.xp -= Math.abs(playerDamageTaken);
            System.out.println(this.name + " attacked!");
            System.out.println("You took " + Math.abs(this.playerDamageTaken) + " damage.");
            System.out.print("Your HP:" + player.xp+"\t");
            Display dis = new Display();
            dis.playerHealthbar(player);
        }
        else{ // miss
            System.out.println("\n"+this.name + " attacked but missed!");
            System.out.print("Your XP:" + player.xp+"\t");
            Display dis = new Display();
            dis.playerHealthbar(player);
        }
        return player.xp;
    }
}