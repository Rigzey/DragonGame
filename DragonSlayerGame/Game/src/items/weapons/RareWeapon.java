package items.weapons;

import java.util.Random;

public class RareWeapon extends Weapon{
    public RareWeapon(){
        this.damage = (new Random().nextInt(30, 50));
        this.price = 25;
    }

    @Override
    public String getName() {
        return "Rare weapon";
    }
}
