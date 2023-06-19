package Locations;

import creatures.Human;

import java.util.Scanner;

public class Inn {
    private int pricePerNight;

    public Inn(int pricePerNight){
        if(pricePerNight > 0){
            this.pricePerNight = pricePerNight;
        }
    }
    public void acceptTraveler(Human human){
        System.out.println("Welcome to the inn, traveler! What would you like to do here?");
        System.out.println("Type 1 to sell your goods. Your current inventory gold is " + human.getInventoryGold() + ".");
        System.out.println("Type 2 to rest (price per night is " + this.pricePerNight + ").");
        System.out.println("Type 3 to exit.");
        switch(new Scanner(System.in).nextInt()){
            case 1 -> human.sellInventory();
            case 2 -> human.rest(this.pricePerNight);
            case 3 -> System.out.println("See you soon!");
        }
    }
}
