import java.util.Scanner;

public class Player {
    private int damage, healty, money,rHealthy;
    private String name, cName;
    private Inventory inv;
    Scanner scn = new Scanner(System.in);

    public Player(String name){

        this.name=name;
        this.inv=new Inventory();
    }

    public void selectCharacter() {
        switch (characterMenu()) {
            case 1:
                initPlayer("Merida",5,21,15);
                break;
            case 2:
                initPlayer("Elsa",7,18,20);
                break;
            case 3:
                initPlayer("Anna",8,24,5);
                break;
        }
        System.out.println("Your character has been created! Character : "+getcName()+
                "\t Damage: " +getDamage()+
                "\t Health: "+getHealty()+
                "\t Money: "+getMoney());
    }

    public int characterMenu() {

        Scanner scn = new Scanner(System.in);
        System.out.println("Please enter your name before starting the game  :  ");
        System.out.println(" 1-Merida  \t Damage : 5 \t Health : 21 \t Money: 15");
        System.out.println(" 2-Elsa  \t Damage : 7 \t Health : 18 \t Money: 20  ");
        System.out.println("3-Anna  \t Damage : 8 \t Health : 24 \t Money: 5  ");
        System.out.println("Your character choice : ");
        int characterID = scn.nextInt();

        while (characterID < 1 || characterID > 3) {
            System.out.print("Please enter a valid character!");
             characterID = scn.nextInt();
        }
        return characterID;
    }
    public int getTotalDamage(){
        return  this.getDamage()+this.getInv().getDamage();
    }

    public void initPlayer(String cName,int damage,int healty,int money){
        setcName(cName);
        setDamage(damage);
        setHealty(healty);
        setMoney(money);
        setrHealthy(healty);

    }

    public int getDamage(){

        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealty() {
        return healty;
    }

    public void setHealty(int healty) {
        this.healty = healty;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Inventory getInv() {
        return inv;
    }

    public void setInv(Inventory inv) {
        this.inv = inv;
    }

    public int getrHealthy() {
        return rHealthy;
    }

    public void setrHealthy(int rHealthy) {
        this.rHealthy = rHealthy;
    }
}
