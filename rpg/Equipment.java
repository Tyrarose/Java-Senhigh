public class Equipment { //Charlene, Danica, Daniela, Michaela, Tyra

   
    public String[] weaponName = {
        "Normal sword",
        "Knorr sword",
        "Sayote sword",
        "Chicken sword"
    };
    
    public int[] weaponDamage = {
        5,//Normal sword
        10,//Knorr sword
        15,//Sayote sword
        20,//Chicken sword
    };
    
    public String[] amuletName = {
        "Paminta bomb", //chap1
        "Chicken oil", //chap2
        "Garlic cubes", //chap3
        "Onion cubes" //chap4
    };
    
    public int[] amuletDef = {
        4, // paminta
        8, // chicken
        12, // garlic
        16, // onion
    };
    
    public String getWeaponName(int itemId){
    return this.weaponName[itemId];
    }
    
    public int getWeaponDamage(int itemId){
    return this.weaponDamage[itemId];
    }
    
    public String getAmuletName(int itemId){
    return this.amuletName[itemId];
    }
    
    public int getAmuletDef(int itemId){
    return this.amuletDef[itemId];
    }
    }