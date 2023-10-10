
package rpggamept;


public class Item 
{
    
    public String[] itemName = 
    {
        "Hi-Potion (Restores 2500 HP)",
        "Valkyra Armor",
        "Super Hi-Potion (Restores 250000 HP)",
        "Divine Judgement Scythe"
    };
    
    public String[] itemType = 
    {
        "hp",
        "armor",
        "hp",
        "damage"
    };
    
    public int[] itemVal = 
    {
        2500,
        10000,
        250000,
        2000
    };
    
    public String getItemName(int itemId)
    {
        return itemName[itemId];
    }
    
    public String getItemType(int itemId)
    {
        return itemType[itemId];
    }
    
    public int getItemVal(int itemId)
    {
        return itemVal[itemId];
    }
}
