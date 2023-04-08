public abstract class BattleLoc extends Location{
    protected Obstacle obstacle;
    protected String award;

    BattleLoc(Player player,String name, Obstacle obstacle, String award) {
        super(player);
        this.obstacle = obstacle;
        this.name = name;
        this.award = award; 
    }

    public boolean getLocation(){
        int obsCount = obstacle.count();
        System.out.println("You are in " + this.getName());
        System.out.println("Be careful! There are " + obsCount + " " + obstacle.getName()+ " around here.");
        System.out.print("<F>ight or <R>un: ");
        String selCase = input.next();
        selCase = selCase.toUpperCase();
        if(selCase.equals("F")){
            if(combat(obsCount)){
                System.out.println("\n"+"You killed all the enemies in " + this.getName());
                if(this.award.equals("Food") && player.getInv().isFood() == false){
                    System.out.println("You achieve " + this.award);
                    player.getInv().setFood(true);
                }
                else if(this.award.equals("Water") && player.getInv().isWater() == false){
                    System.out.println("You achieve " + this.award);
                    player.getInv().setWater(true);
                }
                else if(this.award.equals("Firewood") && player.getInv().isFirewood() == false){
                    System.out.println("You achieve " + this.award);
                    player.getInv().setFirewood(true);
                }
                return true;
            }
            if(player.getHealth() <= 0){
                System.out.println("You are dead.");
                return false;
            }
        }
        return true;
    }
    
    public boolean combat(int obsCount){
        for(int i = 0; i < obsCount ; i++){
            int defObsHealth = obstacle.getHealth();
            playerStats();
            enemyStats();
            while(player.getHealth() > 0 && obstacle.getHealth() > 0){
                System.out.print("<H>it or <R>un: ");
                String selCase = input.next();
                selCase = selCase.toUpperCase();
                if(selCase.equals("H")){
                    System.out.println("You hit the target!");
                    obstacle.setHealth(obstacle.getHealth()-player.getTotalDamage());
                    afterHit();
                    if(obstacle.getHealth() <= 0){
                        System.out.println();
                        System.out.println("Enemy hit you!");
                        player.setHealth((player.getHealth()-(obstacle.getDamage()-player.getInv().getArmor())));
                        afterHit();
                    }           
                }
                else{
                    return false;
                }
            }
            if(obstacle.getHealth() < player.getHealth()){
                System.out.println("You defeated the enemy");
                player.setMoney((player.getMoney() + obstacle.getAward()));
                System.out.println("Current Money: " + player.getMoney());
                obstacle.setHealth(defObsHealth);
            }
            else{
                return false;
            }
            System.out.println("_______________");
            
        }
        return true;
    }

    public void afterHit(){
        System.out.println("Player Health: " + player.getHealth());
        System.out.println(obstacle.getName() + " Health: "+ obstacle.getHealth());
        System.out.println();
    }

    public void playerStats(){
        System.out.println("\n"+"Player Stats\n-----------");
        System.out.println("Health: " + player.getHealth());
        System.out.println("Damage: " + player.getTotalDamage());
        System.out.println("Money: " + player.getMoney());
        if(player.getInv().getDamage() > 0){
            System.out.println("Weapon: " + player.getInv().getWName());
        }
        if(player.getInv().getArmor() > 0){
            System.out.println("Armor: " + player.getInv().getAName());
        }
    }

    public void enemyStats(){
        System.out.println("\n"+obstacle.getName() + " Stats\n-----------");
        System.out.println("Health: " + obstacle.getHealth());
        System.out.println("Damage: " + obstacle.getDamage());
        System.out.println("Award: " + obstacle.getAward());
    }

}
