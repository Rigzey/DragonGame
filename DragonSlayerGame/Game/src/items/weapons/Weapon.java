package items.weapons;

import items.Item;

public abstract class Weapon extends Item {
    protected int damage;

    public int getDamage() {
        return damage;
    }
    public void printStats(){
        System.out.println("Damage: " + this.damage);
        System.out.println("Price:  " + this.price);
    }
}
