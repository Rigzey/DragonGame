package Locations;

import creatures.Human;
import creatures.enemies.MediocreCreep;
import creatures.enemies.StrongCreep;
import creatures.enemies.WeakCreep;

import java.util.Scanner;

public class Forest {
    public void humanJoins(Human human){
        System.out.println("You are now in the forest. What would you like to do?");
        loop: while(true) {
            System.out.println("Press 1 to fight a weak creep");
            System.out.println("Press 2 to fight a mediocre creep");
            System.out.println("Press 3 to fight a strong creep");
            System.out.println("Press 4 to exit");
            switch (new Scanner(System.in).nextInt()) {
                case 1 -> human.fightCreep(new WeakCreep());
                case 2 -> human.fightCreep(new MediocreCreep());
                case 3 -> human.fightCreep(new StrongCreep());
                case 4 -> {
                    System.out.println("You have exited the forest");
                    break loop;
                }
            }
        }
    }
}
