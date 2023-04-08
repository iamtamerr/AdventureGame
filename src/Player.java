import java.util.Scanner;

public class Player {
    private int damage,health,money,rHealth;
    private String name,charName;
    private Inventory inv;
    Scanner input = new Scanner(System.in);


    public Player(String name) {
        this.name = name;
        this.inv = new Inventory();
    }

    public void selectCha(){
        switch (chaMenu()) {
            // Samurai
            case 1:
                initPlayer("Samurai",5,21,15);
                break;
            case 2:
                initPlayer("Archer",7,18,20);
                break;
            case 3:
                initPlayer("Chevalier",8,24,5);
                break;
            default:
                initPlayer("Samurai",5,21,15);
                break;
        };
        System.out.println("Character: " + getCharName() + "\t Damage: " + getDamage() + "\t Health: " + getHealth() + "\t Money: " + getMoney());
    }

    public void initPlayer(String charName, int dmg, int hlty, int mny){
        setCharName(charName);
        setDamage(dmg);
        setHealth(hlty);
        setMoney(mny);
        setRHealth(health);
    }

    public int chaMenu(){
        System.out.println("Choose a character: ");
        System.out.println("1- Samurai \t Damage: 5 \t Health: 21 \t Money: 15");
        System.out.println("2- Archer \t Damage: 7 \t Health: 18 \t Money: 20");
        System.out.println("3- Chevalier \t Damage: 8 \t Health: 24 \t Money: 5");
        System.out.print("Choice: ");
        int chaID = input.nextInt();

        while(chaID<1 || chaID>3){
            System.out.print("Please choose a valid character id: ");
            chaID = input.nextInt();
        }
        return chaID;
    }

    public int getTotalDamage(){
        return this.getDamage()+this.getInv().getDamage();
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return this.charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInv() {
        return this.inv;
    }

    public void setInv(Inventory inv) {
        this.inv = inv;
    }

    public int getRHealth() {
        return this.rHealth;
    }

    public void setRHealth(int rHealth) {
        this.rHealth = rHealth;
    } 
}
