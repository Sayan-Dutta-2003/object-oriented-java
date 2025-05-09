package animalKingdom;

import java.util.Set;

public class Bird extends Vertebrate{
    public Bird(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(name + " is pecking food");
    }
    @Override
    public void sleep() {
        System.out.println(name + " is roosting");
    }
    @Override
    public void move() {
        final Set<String> FLIGHTLESS_BIRDS = Set.of(
                "ostriches", "emus", "cassowaries", "rheas", "kiwis"
        );
        if (FLIGHTLESS_BIRDS.contains(name.toLowerCase())) {
            System.out.println(name + " is walking/running");
        }
        else if(name.equalsIgnoreCase("penguin")) {
            System.out.println(name + " is swimming/walking/running");
        }
        else {
            System.out.println(name + " is flying");
        }
    }
    @Override public void makeSound() {
        System.out.println(name + " says: Chirp");
    }
    @Override public boolean warmBlooded() {
        return true;
    }
    @Override public boolean feedMilk() {
        return false;
    }
    @Override public boolean hasFur() {
        return false;
    }
}
