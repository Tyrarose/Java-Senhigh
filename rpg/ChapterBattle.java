import java.io.*;
public class ChapterBattle extends BattleSystem
{ //Charlene, Danica, Daniela, Michaela, Tyra
    public static Enemy enemyb;
    //dito nareread yung ENEMY,hindi nareread dito yung player        
    public void chapter1() throws IOException{
        enemy = new Enemy("Chayoterot",20,1,6);
        Dialogue.showIntro();
        Dialogue.showGameStory();
        Dialogue.showWorld();
        Dialogue.showGameWorld();
        Dialogue.showchap1();
        BattleSystem.battle(enemy);
        Dialogue.showIntoTheWoods();
    }
    public static void chapter2() throws IOException{
        enemy = new Enemy("Chickenchuckle",25,5,8);
        Dialogue.showCabin();
        Dialogue.showChap2();
        Dialogue.showBeach();
        Dialogue.showTunnel();
        Dialogue.showIntoTheTunnel();
        BattleSystem.battle(enemy);
    }
    //overload
    public static void chapter3() throws IOException{
        enemy = new Enemy("Moronion",30,10,10);
        enemyb = new Enemy("Galiclicer",30,10,10);
        Dialogue.showChap3();
        Dialogue.showFinalBattle();
        BattleSystem.battle(enemy, enemyb);
        endingchapter();
    }
    public static void continueStory() throws IOException{
        enemy = new Enemy("Chickenchuckle",25,5,8);
        Dialogue.showCabin();
        Dialogue.showChap2();
        Dialogue.showBeach();
        Dialogue.showTunnel();
        Dialogue.showIntoTheTunnel();
        BattleSystem.battle(enemy);
    }
    public static void endingchapter () throws IOException
    {
        Dialogue.showEnding();
        Dialogue.showLifeLesson();
    }
    //override
     @Override
    public void statusbar ()
    {
        super.statusbar();
        Display dis = new Display();
        System.out.print(Display.playerName+":\t\t");
        dis.enemyHealthbar(enemy);
        System.out.print(enemy.name+":\t");
        dis.playerHealthbar(player);
    }  
}