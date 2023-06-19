import Locations.Forest;
import Locations.Inn;
import creatures.Human;
import creatures.enemies.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Human human = new Human();
        Inn inn = new Inn(10);
        Dragon Spaska = new Dragon();
        Forest forest = new Forest();
        while(true){
            System.out.println("What would you like to do?");
            System.out.println("Press 1 to go to the forest.");
            System.out.println("Press 2 to go to the inn.");
            System.out.println("Press 3 to show your stats.");
            System.out.println("Press 4 to go fight the dragon.");
            switch(new Scanner(System.in).nextInt()){
                case 1 -> human.goToForest(forest);
                case 2 -> human.goToInn(inn);
                case 3 -> human.printStats();
                case 4 -> human.fightSpaska(Spaska);
            }
            System.out.println();
        }
    }
}