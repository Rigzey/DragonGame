package items.armour;

import java.util.Random;

public class Belt extends Armour{
    public Belt(){
        this.health = (new Random().nextInt(150, 250));
        this.armour = (new Random().nextInt(10, 15));
        this.price = 15;
    }

    @Override
    public String getName() {
        return "Belt";
    }
}
