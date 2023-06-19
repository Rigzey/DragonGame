package items.armour;

import java.util.Random;

public class Helmet extends Armour{
    public Helmet(){
        this.health = (new Random().nextInt(200, 300));
        this.armour = (new Random().nextInt(10, 15));
        this.price = 30;
    }

    @Override
    public String getName() {
        return "Helmet";
    }
}
