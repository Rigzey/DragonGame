package creatures;

public class Creature {
    protected int baseHealth;
    protected int currentHealth;
    protected int damage;
    protected int armour;
    public void hit(Creature creature){
        creature.currentHealth -= this.damage + this.armour;
    }
}
