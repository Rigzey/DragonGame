package items.weapons;

import java.util.Random;

public class EpicWeapon extends Weapon{

    public EpicWeapon(){
        this.damage = (new Random().nextInt(80, 100));
        this.price = 50;
    }

    @Override
    public String getName() {
        return "Epic weapon";
    }
}
