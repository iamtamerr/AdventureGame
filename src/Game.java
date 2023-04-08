import java.util.Scanner;
public class Game {
    Player player;
    Location location;
    Scanner input = new Scanner(System.in);

    public void login(){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the adventure game ! ");
        System.out.print("Username: ");
        //String playerName = input.nextLine();
        player = new Player("tamerrkanak");
        player.selectCha();
        start();

    }

    public void start(){
        while(true){
            System.out.println();
        System.out.println("-------------");
        System.out.println();
        System.out.println("Please choose a location to action: ");
        System.out.println("1. House --> A safe place for you, no enemy !");
        System.out.println("2. Cave --> You may encounter zombies.");
        System.out.println("3. Forest --> You may encounter vampires.");
        System.out.println("4. River --> You may encounter bears.");
        System.out.println("5. Shop --> You can buy weapon or armor.");
        System.out.print("The place where you want to go: ");
        int selLoc = input.nextInt();
        while(selLoc < 0 ||selLoc >5){
            System.out.print("Please make a valid selection: ");
            selLoc = input.nextInt();
        }

        switch(selLoc){
            case 1:
                location = new SafeHouse(player);
                break;
            case 2:
                location = new Cave(player);
                break;
            case 3:
                location = new Forest(player);
                break;
            case 4:
                location = new River(player);
                break;
            case 5:
                location = new ToolStore(player);
                break;
            default:
                location = new SafeHouse(player);
            }
            if(location.getClass().getName().equals("SafeHouse")){
                if(player.getInv().isFirewood() && player.getInv().isFood() && player.getInv().isWater()){
                    System.out.println("Congrulations you won!");
                    break;
                }
            }
            if(!location.getLocation()){
                System.out.println("Game Over.");
                break;
            }
        }

    }
}
