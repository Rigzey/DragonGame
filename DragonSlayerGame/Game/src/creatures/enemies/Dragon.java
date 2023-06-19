package creatures.enemies;

public class Dragon extends Enemy{
    private boolean isEvolved = false;
    public Dragon(){
        this.baseHealth = 10000;
        this.currentHealth = 10000;
        this.armour = 50;
        this.damage = 100;
    }
    private void evolve(){
        this.currentHealth = 15000;
        this.armour = 80;
        this.damage = 120;
        this.isEvolved = true;
    }
    @Override
    public void die() {
        if(!this.isEvolved) {
            System.out.println("Congratulations! You have killed Spaska! But wait... why is the boss music still playing?...");
            evolve();
            System.out.println("Oh no! Spaska has evolved! The dragon`s new stats are as follows: ");
            printStats();
            System.out.println("Would you like to fight her now? 1 for yes, anything else for hell nah");
        }
        else{
            System.out.println("Congratulations! Spaska has officially been defeated!");
        }
    }

    public boolean isEvolved() {
        return isEvolved;
    }

    private void printStats(){
        System.out.println("Health: " + this.baseHealth);
        System.out.println("Armour: " + this.armour);
        System.out.println("Damage: " + this.damage);
    }
}
