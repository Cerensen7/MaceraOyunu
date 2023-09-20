public class MagicCastle extends NormalLocation{
    MagicCastle(Player player){
        super(player,"Magic Castle");
        this.name=name;

    }


    @Override
    public boolean getLocation() {
        player.setHealty(player.getHealty());
        System.out.println("You are healed...");
        System.out.println("You are now in the magical castle.");
        return false;
    }
}
