public class Inventory {
    private boolean water, food, firewood;
    private String wName, aName;
    private int damage, armor;

    Inventory(){
        this.water = false;
        this.food = false;
        this.firewood = false;
        this.damage = 0;
        this.armor = 0;
        this.wName = null;
        this.aName = null;
    }

    public boolean isWater() {
        return this.water;
    }

    public boolean getWater() {
        return this.water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isFood() {
        return this.food;
    }

    public boolean getFood() {
        return this.food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isFirewood() {
        return this.firewood;
    }

    public boolean getFirewood() {
        return this.firewood;
    }

    public void setFirewood(boolean firewood) {
        this.firewood = firewood;
    }

    public String getWName() {
        return this.wName;
    }

    public void setWName(String wName) {
        this.wName = wName;
    }

    public String getAName() {
        return this.aName;
    }

    public void setAName(String aName) {
        this.aName = aName;
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getArmor() {
        return this.armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }
    
}
