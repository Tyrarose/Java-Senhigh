package rpggamept;


public class Equipment 
{
    
public String[] SkillName = 
{
        "Firebolt",
        "Soul Breaker",
        "Mighty Five Runes Spin",
        "Trap of the Sage",
        "Break Individually",
        "Normal Attack"

    };
    
    
    public int[] SkillDamage = 
    {
        30, // Firebolt
        2500, // Soul Breaker
        1000, // Mighty Five Runes Spin
        1500, // Trap of the Sage
        500, // Break Individually
        10, //Normal Attack

    };
    
    public String[] armorName = 
    {
        "Valkyry Armor",
        "Shadow Manteu",
        "Goblin Set"
    };
    
    public int[] armorDef = 
    {
        40, // Valkyry Armor
        45, // Shadow Manteu
        50 // Goblin Set
    };
    
    public String getSkillName0()
    {
        return this.SkillName[0];
    }
    public String getSkillName1()
    {
        return this.SkillName[1];
    }
    public String getSkillName2()
    {
        return this.SkillName[2];
    }
    public String getSkillName3()
    {
        return this.SkillName[3];
    }
    public String getSkillName4()
    {
        return this.SkillName[4];
    }
    public String getSkillName5()
    {
        return this.SkillName[5];
    }
    
    public int getSkillDamage0()
    {
        return this.SkillDamage[0];
    }
    public int getSkillDamage1()
    {
        return this.SkillDamage[1];
    }
     public int getSkillDamage2()
    {
        return this.SkillDamage[2];
    }
     public int getSkillDamage3()
    {
        return this.SkillDamage[3];
    }
     public int getSkillDamage4()
    {
        return this.SkillDamage[4];
    }
     public int getSkillDamage5()
    {
        return this.SkillDamage[5];
    }
    
    public String getArmorName(int itemId)
    {
        return this.armorName[itemId];
    }
    
    public int getArmorDef(int itemId){
        return this.armorDef[itemId];
    }
    
}
