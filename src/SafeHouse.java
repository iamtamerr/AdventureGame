public class SafeHouse extends NormalLoc{

    public SafeHouse(Player player) {
        super(player, "Safe House");
    }
    
    public boolean getLocation(){
        player.setHealth(player.getRHealth());
        System.out.println("Your health is full.");
        System.out.println("You are in safe house right now.");
        return true;
    }

}
