public abstract class BattleLocation extends Location{
   protected Obstacle obstacle;
   protected String award;


    BattleLocation(Player player,String name,Obstacle obstacle,String award) {
        super(player);
        this.obstacle=obstacle;
        this.name=name;
        this.award=award;
    }

    @Override
    public boolean getLocation() {
        int obsCount = obstacle.count();
        System.out.println("You are here now : " + this.getName());
        System.out.println("Be careful ! " + obsCount + "\t"+ obstacle.getName() + " live here ");
        System.out.println("Fight or escape! <<<If you want to fight, choose 'A'." +
                " If you want to escape, choose 'E'.");
        String selCase = scn.nextLine();
        selCase = selCase.toUpperCase();
        if (selCase.equals("A")) {
            if (combat(obsCount)) {
                System.out.println("You have cleared all the enemies in the "
                        + this.getName() + " region!");
                if (this.award.equals("food") && player.getInv().isFood() == false) {
                    System.out.println(this.award + " you won!");
                    player.getInv().setFood(true);
                } else if (this.award.equals("water") && player.getInv().isMagicwater() == false) {
                    System.out.println(this.award + " you won!");
                    player.getInv().setMagicwater(true);
                }else if (this.award.equals("warmingpotion") && player.getInv().isWarmingpotion() == false) {
                    System.out.println(this.award + " you won!");
                    player.getInv().setWarmingpotion(true);
                }
                return true;
            }else {

            }
            if (player.getHealty()<= 0){
                System.out.println("You are dead !" );
                return false;
            }
        }
        return true;
    }
    public boolean combat(int obsCount){
        for (int i=0; i<obsCount; i++){
            int defObsHealth=obstacle.getHealth();
            playerStats();
            enemyStats();
            while (player.getHealty()>0 &&obstacle.getHealth()>0){
                System.out.println("Take action or escape! <<<If you want to fight, choose 'A'" +
                        ".If you want to escape, choose 'E'.");
                String selCase= scn.nextLine();
                selCase=selCase.toUpperCase();
                if (selCase.equals("A")){
                    System.out.println("You caused damage!");
                    obstacle.setHealth(obstacle.getHealth()-player.getTotalDamage());
                    afterHit();
                    if (obstacle.getHealth()>0) {

                        System.out.println();
                        System.out.println("The enemy caused damage!");
                        player.setHealty(player.getHealty() - (obstacle.getDamage() - player.getInv().getArmor()));
                        afterHit();
                    }
                }else {
                  return false;
                }
            }
            if (obstacle.getHealth()< player.getHealty()) {
                System.out.println("You have destroyed enemies!");
                player.setMoney(player.getMoney() + obstacle.getAward());
                System.out.println("Your current money: " + player.getMoney());
                obstacle.setHealth(defObsHealth);

            }else {
                return false;
            }
            System.out.println("-----<<<<>>>-----");

            }
        return true;
    }
    public void playerStats(){
        System.out.println("Player values\n -----<<>>-----");
        System.out.println("Remaining life: "+player.getHealty());
        System.out.println("Damage: "+player.getTotalDamage());
        System.out.println("Money: "+player.getMoney());
        if (player.getInv().getArmor()>0){
            System.out.println("Armor: "+player.getInv().getaName());
        }

    }
    public void enemyStats(){
        System.out.println("\n "+obstacle.getName()+" values\n ----<<>>-----");
        System.out.println("Remaining life: "+obstacle.getHealth());
        System.out.println("Damage: "+obstacle.getDamage());
        System.out.println("Award: "+obstacle.getAward());
    }
    public void afterHit(){
        System.out.println("Remaining player life: "+player.getHealty());
        System.out.println(obstacle.getName()+"remaining life "+obstacle.getHealth());
        System.out.println();
    }
}
