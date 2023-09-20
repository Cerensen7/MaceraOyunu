

public class ToolStore extends NormalLocation {


    ToolStore(Player player) {
        super(player, "Store");

    }

    @Override
    public boolean getLocation() {
        System.out.println("Money: "+player.getMoney());
        System.out.println("1-Shields");
        System.out.println("2-Magic");
        System.out.println("3-Exit");
        System.out.println("Your choice: ");
        int selTool= scn.nextInt();
        int selItemID;
        switch (selTool){
            case 1:
                selItemID=weaponMenu();
                buyWeapon(selItemID);
                break;
            case 2:
                selItemID=armorMenu();
                buyArmor(selItemID);
                break;
            default:
                break;
        }
        return true;
    }
    public int armorMenu(){
        System.out.println("1-Light\t <Money : 15 -Damage : 1>");
        System.out.println("2-Middle\t <Money : 25 -Damage : 3>");
        System.out.println("3-Heavy\t <Money : 40 -Damage : 5>");
        System.out.println("4-Exit");
        System.out.println("Please choose a weapon :");
        int selArmorID=scn.nextInt();
        return selArmorID;

    }
   public int weaponMenu(){
       System.out.println("1-Shield\t <Money : 25 -Damage : 2>");
       System.out.println("2-Ice Magic\t <Money : 35 -Damage : 3>");
       System.out.println("3-Ivy Poison\t <Money : 45 -Damage : 7>");
       System.out.println("4-Exit");
       System.out.println("Please choose a weapon :");
       int selWeaponID=scn.nextInt();
       return selWeaponID;

   }
   public void buyArmor(int itemID){
       int avoid = 0, priece = 0;
       String aName = null;
       switch (itemID) {
           case 1:
               avoid = 2;
               aName = "Slight Damage";
               priece =25;
               break;
           case 2:
               avoid = 3;
               aName = "Middle Damage";
               priece = 15;
               break;
           case 3:
               avoid = 5;
               aName = "Heavy Damage";
               priece = 45;
               break;
           case 4:
               System.out.println("Checking Out...");
               break;
           default:
               System.out.println("You entered an invalid transaction!");
               break;

       }
       if (priece > 0) {
           if (player.getMoney() >= priece) {
            player.getInv().setArmor(avoid);
            player.getInv().setaName(aName);
            player.setMoney(player.getMoney()-priece);
               System.out.println(aName+"You bought ,damage blocked : "+player.getInv().getArmor());
               System.out.println("Remaining money : " + player.getMoney());
           } else {
               System.out.println("Your balance is insufficient !");
           }

       }

   }
    public void buyWeapon(int itemID) {
        int damage = 0, priece = 0;
        String wName = null;
        switch (itemID) {
            case 1:
                damage = 2;
                wName = "Shield";
                priece = 25;
                break;
            case 2:
                damage = 3;
                wName = "Ice Magic";
                priece = 35;
                break;
            case 3:
                damage = 7;
                wName = "Ivy Poison";
                priece = 45;
                break;
            case 4:
                System.out.println("Checking Out...");
                break;
            default:
                System.out.println("You entered an invalid transaction!");
                break;

        }
        if (priece > 0) {
            if (player.getMoney() > priece) {
                player.getInv().setDamage(damage);
                player.getInv().setwName(wName);
                player.setMoney(player.getMoney() - priece);
                System.out.println(wName + " You bought the gun. <<<>>>> Previous damage:" + player.getDamage() +
                        " , New damage : "+player.getTotalDamage());
                System.out.println("Remaining money : " + player.getMoney());
            } else {
                System.out.println("Your balance is insufficient !");
            }

        }
    }


    }
