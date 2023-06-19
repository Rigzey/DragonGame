package items.armour;

import items.Item;

public abstract class Armour extends Item {
    protected int health;
    protected  int armour;

    public int getHealth() {
        return health;
    }

    public int getArmour() {
        return armour;
    }
    public void printStats(){
        System.out.println("Health: " + this.health);
        System.out.println("Armour: " + this.armour);
    }
}
