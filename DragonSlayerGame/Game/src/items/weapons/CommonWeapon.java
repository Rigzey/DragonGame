package items.weapons;

import java.util.Random;

public class CommonWeapon extends Weapon{
    public CommonWeapon(){
        this.damage = (new Random().nextInt(10, 20));
        this.price = 15;
    }

    @Override
    public String getName() {
        return "Common weapon";
    }
}
