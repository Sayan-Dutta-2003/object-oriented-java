// 10.	Write a program in Java to implement package and interface with inheritance.

import animalKingdom.Animal;
import animalKingdom.Mammal;
import animalKingdom.Reptile;
import animalKingdom.Bird;

import java.util.Scanner;

public class MainAnimalKingdom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("\nAnimal Category Selection:");
            System.out.println("1. Mammals");
            System.out.println("2. Birds");
            System.out.println("3. Reptiles");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if(choice == 4) {
                System.out.println("Exiting program...");
                break;
            }

            if(choice < 1 || choice > 3) {
                System.out.println("Invalid choice!");
                continue;
            }

            String prompt = switch (choice) {
                case 1 -> "Enter the mammal name (e.g., Tiger, Dog): ";
                case 2 -> "Enter the bird name (e.g., Peacock, Eagle): ";
                case 3 -> "Enter the reptile name (e.g., Snake, Lizard): ";
                default -> "";
            };

            System.out.print(prompt);
            String name = scanner.nextLine();

            Animal animal = createAnimal(choice, name);
            displayAnimalInfo(animal, name);
        }

        scanner.close();
    }

    private static Animal createAnimal(int category, String name) {
        return switch(category) {
            case 1 -> new Mammal(name);
            case 2 -> new Bird(name);
            case 3 -> new Reptile(name);
            default -> null;
        };
    }

    private static void displayAnimalInfo(Animal animal, String name) {
        System.out.println("\n" + name + " Characteristics:");
        System.out.println("Warm Blooded: " + animal.warmBlooded());
        System.out.println("Feeds Milk: " + animal.feedMilk());
        System.out.println("Has Fur/Feathers: " + animal.hasFur());
        System.out.println("Has Lungs: " + animal.hasLungs());
        System.out.println("Four Limb Body Plan: " + animal.fourLimbBodyPlan());
        System.out.print("Movement: ");
        animal.move();
        System.out.print("Sound: ");
        animal.makeSound();
        System.out.print("Eating: ");
        animal.eat();
        System.out.print("Sleeping: ");
        animal.sleep();
    }
}
