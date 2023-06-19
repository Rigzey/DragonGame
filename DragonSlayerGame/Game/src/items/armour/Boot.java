package items.armour;

import java.util.Random;

public class Boot extends Armour{
    public Boot(){
        this.health = (new Random().nextInt(200,250));
        this.armour = (new Random().nextInt(10, 15));
        this.price = 20;
    }

    @Override
    public String getName() {
        return "Boot";
    }
}
