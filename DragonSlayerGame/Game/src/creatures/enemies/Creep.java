package creatures.enemies;

import creatures.Creature;
import items.Item;
import items.armour.*;
import items.weapons.CommonWeapon;
import items.weapons.EpicWeapon;
import items.weapons.RareWeapon;
import items.weapons.Weapon;

import java.util.Random;

public class Creep extends Creature {
    public void die(){
        System.out.println("WE SHALL MEET AGAIN IN THE UNDERWORLD!");
        this.currentHealth = this.baseHealth;
        this.dropItem();
    }
    public Item dropItem(){
        if(new Random().nextBoolean()){
            return this.dropWeapon();
        }
        return this.dropArmour();
    }
    private Weapon dropWeapon(){
        if(this instanceof WeakCreep){
            if(new Random().nextInt(100) > 20){
                return (new CommonWeapon());
            }
            else if(new Random().nextInt(100) < 2){
                return (new EpicWeapon());
            }
            else{
                return (new RareWeapon());
            }
        }
        if(this instanceof MediocreCreep){
            if(new Random().nextInt(100) > 50){
                return (new CommonWeapon());
            }
            else if(new Random().nextInt(100) < 10){
                return (new EpicWeapon());
            }
            else{
                return (new RareWeapon());
            }
        }
        return (new EpicWeapon());
    }
    private Armour dropArmour(){
        return switch(new Random().nextInt(4)){
            case 0 -> new Belt();
            case 1 -> new Chest();
            case 2 -> new Boot();
            default -> new Helmet();
        };
    }
}
