package creatures;

import Locations.Forest;
import Locations.Inn;
import creatures.enemies.Creep;
import creatures.enemies.Dragon;
import creatures.enemies.StrongCreep;
import items.Item;
import items.armour.*;
import items.weapons.Weapon;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Human extends Creature {
    private int money;
    private int inventoryGold;
    private Helmet helmet;
    private Belt belt;
    private Chest chest;
    private Boot[] boots;
    private int freeBootSlots;
    private Weapon[] weapons;
    private int freeWeaponSlots;
    private int creepsKilled;
    private int nightsRested;
    ArrayList<Item> inventory = new ArrayList<>(100);
    public Human(){
        weapons = new Weapon[2];
        this.freeWeaponSlots = 2;
        boots = new Boot[2];
        this.freeBootSlots = 2;
        this.baseHealth = 100;
        this.currentHealth = 100;
        this.damage = 5;
        this.armour = 0;
        this.creepsKilled = 0;
        this.money = 0;
        this.nightsRested = 0;
    }
    public void fightCreep(Creep creep){
        while(this.currentHealth > 0 && creep.currentHealth > 0){
            if(creep instanceof StrongCreep){
                if(new Random().nextInt(100) > 30){
                    this.hit(creep);
                }
            }
            else{
                this.hit(creep);
            }
            creep.hit(this);
        }
        if(this.currentHealth <= 0){
            System.out.println("You have died. Game over.");
            System.exit(0);
        }
        else{
            this.creepsKilled++;
            creep.die();
            System.out.println("Current health left: " + this.currentHealth);
            receiveItem(creep.dropItem());
        }
    }
    private void receiveItem(Item item){
        System.out.println("Congratulations, you just earned a " + item.getName());
        if(item instanceof Weapon){
            System.out.println("It has " + ((Weapon) item).getDamage() + " damage and costs " + item.getPrice() + " gold!");
        }
        else{
            System.out.println("It has " + ((Armour) item).getArmour() + " armour, gives " + ((Armour) item).getHealth() + " health and costs " + item.getPrice() + " gold!");
        }
        System.out.println("Would you like to equip it?");
        System.out.println("Type 1 for yes and 2 for no.");
        Scanner sc = new Scanner(System.in);
        if(sc.nextInt() == 1){
            equipItem(item);
            System.out.println("Great choice! Your new stats are as follows: ");
            printStats();
        }
    }
    private void equipItem(Item item){
        if(item instanceof Weapon){
            equipWeapon((Weapon) item);
        }
        else if(item instanceof Chest){
            equipChest((Chest) item);
        }
        else if(item instanceof Helmet){
            equipHelmet((Helmet) item);
        }
        else if(item instanceof Belt){
            equipBelt((Belt) item);
        }
        else if(item instanceof Boot){
            equipBoot((Boot) item);
        }
    }
    private void equipBoot(Boot boot){
        if(this.freeBootSlots > 0){
            this.boots[2 - freeBootSlots] = boot;
            this.baseHealth += boot.getHealth();
            this.armour += boot.getArmour();
            this.currentHealth += boot.getArmour();
            this.freeBootSlots--;
        }
        else{
            replaceBoot(boot);
        }
    }
    private void replaceBoot(Boot boot){
        System.out.println("Which boot would you like to replace?");
        System.out.println("Boot 1:");
        this.boots[0].printStats();
        System.out.println("Boot 2:");
        this.boots[1].printStats();
        System.out.println("Type anything else for none.");
        if(new Scanner(System.in).nextInt() == 1){
            this.baseHealth += boot.getHealth() - this.boots[0].getHealth();
            this.armour += boot.getArmour() - this.boots[0].getArmour();
            this.currentHealth += boot.getHealth() - this.boots[0].getHealth();
            addToInventory(this.boots[0]);
            this.boots[0] = boot;
        }
        else if(new Scanner(System.in).nextInt() == 2){
            this.baseHealth += boot.getHealth() - this.boots[1].getHealth();
            this.armour += boot.getArmour() - this.boots[1].getArmour();
            this.currentHealth += boot.getHealth() - this.boots[1].getHealth();
            addToInventory(this.boots[1]);
            this.boots[1] = boot;
        }
        else{
            addToInventory(boot);
        }
    }
    private void equipBelt(Belt belt){
        if(this.belt == null){
            this.belt = belt;
            this.baseHealth += belt.getHealth();
            this.armour += belt.getArmour();
        }
        else{
            replaceBelt(belt);
        }
    }
    private void replaceBelt(Belt belt){
        System.out.println("Would you like to replace your current belt?");
        this.belt.printStats();
        System.out.println("Type 1 for yes and anything else for no.");
        if(new Scanner(System.in).nextInt() == 1){
            this.baseHealth += belt.getHealth() - this.belt.getHealth();
            this.currentHealth += belt.getHealth() - this.belt.getHealth();
            this.armour += belt.getArmour() - this.belt.getArmour();
            addToInventory(this.belt);
            this.belt = belt;
        }
        else{
            addToInventory(belt);
        }
    }
    private void equipHelmet(Helmet helmet){
        if(this.helmet == null){
            this.helmet = helmet;
            this.baseHealth += helmet.getHealth();
            this.armour += helmet.getArmour();
            this.currentHealth += helmet.getHealth();
        }
        else{
            replaceHelmet(helmet);
        }
    }
    private void replaceHelmet(Helmet helmet){
        System.out.println("Would you like to replace your current helmet?");
        this.helmet.printStats();
        System.out.println("Type 1 for yes and anything else for no.");
        if(new Scanner(System.in).nextInt() == 1){
            this.baseHealth += helmet.getHealth() - this.helmet.getHealth();
            this.armour += helmet.getArmour() - this.helmet.getArmour();
            this.currentHealth += helmet.getHealth() - this.helmet.getHealth();
            addToInventory(this.helmet);
            this.helmet = helmet;
        }
        else{
            addToInventory(helmet);
        }
    }
    private void equipChest(Chest chest){
        if(this.chest == null){
            this.chest = chest;
            this.baseHealth += chest.getHealth();
            this.armour += chest.getArmour();
            this.currentHealth += chest.getHealth();
        }
        else{
            replaceChest(chest);
        }
    }
    private void replaceChest(Chest chest){
        System.out.println("Would you like to replace your current chest?");
        this.chest.printStats();
        System.out.println("Type 1 for yes and anything else for no.");
        if(new Scanner(System.in).nextInt() == 1){
            this.baseHealth += chest.getHealth() - this.chest.getHealth();
            this.currentHealth += chest.getHealth() - this.chest.getHealth();
            addToInventory(this.chest);
            this.armour += chest.getArmour() + this.chest.getArmour();
            this.chest = chest;
        }
        else{
            addToInventory(chest);
        }
    }
    private void equipWeapon(Weapon weapon){
        if(this.freeWeaponSlots > 0){
            this.weapons[2 - freeWeaponSlots] = weapon;
            this.damage += weapon.getDamage();
            this.freeWeaponSlots--;
        }
        else{
            replaceWeapon(weapon);
        }
    }
    public void fightSpaska(Dragon dragon){
        while(this.currentHealth > 0 && dragon.currentHealth > 0){
            this.hit(dragon);
            dragon.hit(this);
        }
        if(this.currentHealth <= 0){
            System.out.println("You have died. Game over.");
            System.exit(0);
        }
        else if(!dragon.isEvolved()){
            dragon.die();
            Scanner sc = new Scanner(System.in);
            if(sc.nextInt() == 1){
                this.fightSpaska(dragon);
            }
            else{
                System.out.println("Pussy.");
            }
        }
        else{
            System.out.println("Congratulations! You have officially killed Spaska! You win!");
            System.exit(0);
        }
    }
    private void replaceWeapon(Weapon weapon){
        System.out.println("Which weapon would you like to replace it with?");
        System.out.println("Weapon 1:");
        this.weapons[0].printStats();
        System.out.println("Weapon 2:");
        this.weapons[1].printStats();
        System.out.println("Type anything else, if you do not wish to equip it.");
        Scanner sc = new Scanner(System.in);
        if(sc.nextInt() == 1){
            this.damage += weapon.getDamage() - this.weapons[0].getDamage();
            addToInventory(this.weapons[0]);
            this.weapons[0] = weapon;
        }
        else if(sc.nextInt() == 2){
            this.damage += weapon.getDamage() - this.weapons[1].getDamage();
            addToInventory(this.weapons[1]);
            this.weapons[1] = weapon;
        }
        else{
            addToInventory(weapon);
        }
    }
    private void addToInventory(Item item){
        System.out.println("Very well, then! The item shall be left in your inventory!");
        this.inventoryGold += item.getPrice();
        this.inventory.add(item);
    }

    public int getInventoryGold() {
        return inventoryGold;
    }
    public void sellInventory(){
        this.money += this.inventoryGold;
        this.inventoryGold = 0;
        System.out.println("Your new money is " + this.money + " gold!");
        this.inventory.clear();
    }
    public void rest(int price){
        if(money >= price) {
            this.money -= price;
            this.currentHealth = baseHealth;
            System.out.println("Rested.");
        }
        else{
            System.out.println("You do not have enough money to rest here.");
        }
    }
    public void goToForest(Forest forest){
        forest.humanJoins(this);
    }
    public void goToInn(Inn inn){
        inn.acceptTraveler(this);
    }
    public void printStats() {
        System.out.println(this.nightsRested + " nights rested");
        System.out.println(this.creepsKilled + " creeps killed");
        System.out.println(this.money + " gold");
        System.out.println(this.currentHealth + " / " + this.baseHealth + " health");
        System.out.println(this.damage + " damage");
        System.out.println(this.armour + " armour");
    }
}
