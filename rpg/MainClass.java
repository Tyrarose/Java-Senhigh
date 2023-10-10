import java.io.*;
public class MainClass{ 
    //Charlene, Danica, Daniela, Michaela, Tyra 
    //ICT Ani 11b
   
    public static Enemy enemy;
    public static Player player;
    private static Items Items = new Items();
    public static void main(String[] args) throws IOException{
        BufferedReader get = new BufferedReader(new InputStreamReader(System.in));
        Display.titleScreen();
        Display.getName();
        Display.choices();
        System.out.print("Enter your choice: ");
        do{
        try{
        short choice = Short.parseShort(get.readLine());
        switch(choice){
            case 1:
                newGame();
                break;
            case 2:
                ChapterBattle.continueStory();
                break;
            case 3:
                System.exit(0);
            default:
                break;
        }
        }catch (Exception e)
        {
            System.out.print("Enter valid choice: ");
        }
        }while(true);
    }
    public static void newGame() throws IOException
    {
        ChapterBattle chapBat = new ChapterBattle();
        chapBat.chapter1();
        chapBat.chapter2();
        chapBat.chapter3();
    }
}
