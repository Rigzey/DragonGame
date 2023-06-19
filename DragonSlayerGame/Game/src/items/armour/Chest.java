package items.armour;

import java.util.Random;

public class Chest extends Armour{
    public Chest(){
        this.health = (new Random().nextInt(750, 1500));
        this.armour = (new Random().nextInt(20, 30));
        this.price = 50;
    }

    @Override
    public String getName() {
        return "Chest";
    }
}
