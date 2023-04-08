import java.util.Scanner;

public class ToolStore extends NormalLoc{
    
    ToolStore(Player player) {
        super(player, "Shop");
    }

    public boolean getLocation(){
        System.out.println("Money: " + player.getMoney());
        System.out.println("1. Weapons");
        System.out.println("2. Armors");
        System.out.println("3. Exit");
        System.out.print("Your choice: ");
        int selTool = input.nextInt();
        int selItemID;
        switch (selTool) {
            case 1:
                selItemID = weaponMenu();
                buyWeapon(selItemID);
                break;
            case 2:
                selItemID = armorMenu();
                buyArmor(selItemID);
                break;
            default:
                break;
        } 

    
        return true;
    }

    public int armorMenu(){
        System.out.println("1. Light Armor\t <Price : 15 - Block: 1>");
        System.out.println("2. Medium Armor\t <Price : 25 - Block: 3>");
        System.out.println("3. Heavy Armor\t <Price : 40 - Block: 5>");
        System.out.println("4. Exit");
        System.out.print("Your choice: ");
        int selArmorID = input.nextInt();
        return selArmorID;
    }

    public int weaponMenu(){
        System.out.println("1. Pistol\t <Price : 25 - Damage: 2>");
        System.out.println("2. Sword\t <Price : 35 - Damage: 3>");
        System.out.println("3. Rifle\t <Price : 45 - Damage: 7>");
        System.out.println("4. Exit");
        System.out.print("Your choice: ");
        int selWeaponID = input.nextInt();
        return selWeaponID;
    }

    public void buyArmor(int itemID){
        int block = 0, price = 0;
        String aName=null;
        switch (itemID) {
            case 1:
                block = 1;
                aName = "Light";
                price = 15;
                break;
            case 2:
                block = 3;
                aName = "Medium";
                price = 25;
                break;
            case 3:
                block = 5;
                aName = "Heavy";
                price = 40;
                break;
            case 4:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid selection.");
                break;
        }

        if(price>0){
            if(player.getMoney() >= price){
                player.getInv().setArmor(block);
                player.getInv().setAName(aName);
                player.setMoney(player.getMoney() - price);
                System.out.println("You bought a " + aName +  ", Block: "+ player.getInv().getArmor());
                System.out.println("Remaining money: " + player.getMoney());
            }
            else{
                System.out.println("You do not have enough budget to buy this item.");
            }
        }}

    public void buyWeapon(int itemID){
        int damage = 0, price = 0;
        String wName=null;
        switch (itemID) {
            case 1:
                damage = 2;
                wName = "Pistol";
                price = 25;
                break;
            case 2:
                damage = 3;
                wName = "Sword";
                price = 35;
                break;
            case 3:
                damage = 7;
                wName = "Rifle";
                price = 45;
                break;
            case 4:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid selection.");
                break;
        }

        if(price>0){
            if(player.getMoney() >= price){
                player.getInv().setDamage(damage);
                player.getInv().setWName(wName);
                player.setMoney(player.getMoney() - price);
                System.out.println("You bought a " + wName +  ", Previous Damage: "+ player.getDamage() + ", New Damage: " + player.getTotalDamage());
                System.out.println("Remaining money: " + player.getMoney());
            }
            else{
                System.out.println("You do not have enough budget to buy this item.");
            }
        }
        
    }

    
    
    

}
