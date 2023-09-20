import java.util.Scanner;

public class Game {
    Player player;
    Location location;
    Scanner scn=new Scanner(System.in);

    public void login() {
        System.out.println("Welcome to the Battle Game !");
        System.out.println("Please enter your name before starting the game  :  ");
        String playerName=scn.nextLine();
        player=new Player(playerName);
        player.selectCharacter();
        start();
    }
    public void start() {
        System.out.println();
        System.out.println("=======<<<<=========<<<<<==========<<<<========");
        System.out.println();
        System.out.println("Select a region to perform action: ");
        System.out.println("1-Magic Castle ---->It's your own safe place, there are never any enemies! ");
        System.out.println("2-Bat House ---->Be careful! You may encounter blood-sucking vampire bats!");
        System.out.println("3-Unicorn Forest---->Be careful! You may encounter zombie unicorns!");
        System.out.println("4-Emerald River----->Be careful when crossing the river! Water monsters may appear!");
        System.out.println("5-Magic Store---->You can buy enchantments and shields!");
        System.out.println("Please choose where you want to go!");
        System.out.print("Where you want to go:  ");
        int selectLocation = scn.nextInt();
        while (selectLocation < 0 || selectLocation > 5) {
            System.out.print("Please choose a valid location!  :");
            selectLocation = scn.nextInt();
        }
        switch (selectLocation) {
            case 1:
                location = new MagicCastle(player);
                break;
            case 2:
                location=new BatHouse(player);
                break;
            case 3:
                location=new UnicornForest(player);
                break;
            case 4:
                location=new EmeraldRiver(player);
                break;
            case 5:
                location=new ToolStore(player);
                break;
            default:
                location = new MagicCastle(player);
        }
        if (location.getClass().getName().equals("MagicCastle")) {
         if (player.getInv().isWarmingpotion() && player.getInv().isFood() &&
                 player.getInv().isMagicwater()) {
             System.out.println("Congratulations, you won the game!");
            return;
         }
        }
        if (!location.getLocation()) {
            System.out.println("Game over ! ");
           return;
        }
    }
    }


