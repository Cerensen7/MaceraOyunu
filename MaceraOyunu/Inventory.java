public class Inventory {
 private boolean magicwater,food,warmingpotion;
 private String wName,aName;
 private int damage,armor;

 Inventory(){
     this.magicwater=false;
     this.food=false;
     this.warmingpotion=false;
     this.damage=0;
     this.armor=0;
     this.wName=null;
     this.aName=null;
 }

    public boolean isMagicwater() {
        return magicwater;
    }

    public void setMagicwater(boolean magicwater) {
        this.magicwater = magicwater;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isWarmingpotion() {
        return warmingpotion;
    }

    public void setWarmingpotion(boolean warmingpotion) {
        this.warmingpotion = warmingpotion;
    }

    public String getwName() {
        return wName;
    }

    public void setwName(String wName) {
        this.wName = wName;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }
}
