public class Items { //Charlene, Danica, Daniela, Michaela, Tyra
   
    public String[] itemName = {
        "Sayote (Restores 5 XP)",
        "Chicken oil (Restores 10 XP)",
        "Knorr cubes (Restores 15 XP)",
        "Bagoong (Deals 5 damage to the player)",
        "Suka (Deals 10 damage to the player)"

    };
   
    //"Bagoong (Deals 10 damage to the player)",
   
    public String[] itemType = {
        "xp",
        "xp",
        "xp",
        "damage",
        "damage"
    };
   
    public int[] itemVal = {
        5,
        10,
        15,
        5,
        10,
    };
   
    public String getItemName(int itemId){
        return itemName[itemId];
    }
   
    public String getItemType(int itemId){
        return itemType[itemId];
    }
   
    public int getItemVal(int itemId){
        return itemVal[itemId];
    }
}