package animalKingdom;

import java.util.Set;

public class Mammal extends Vertebrate {
    public Mammal(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(name + " is chewing food");
    }

    @Override
    public void sleep() {
        System.out.println(name + " is sleeping");
    }

    @Override
    public void move() {
        System.out.println(name + " is walking/running");
    }

    @Override
    public void makeSound() {
        final Set<String> CANINE = Set.of(
                "dog", "wolf", "jackal", "fox"
        );
        if (CANINE.contains(name.toLowerCase())) {
            System.out.println(name + " says: Growl/Bark/Howl");
        }
        else {
            System.out.println(name + " says: Growl");
        }

    }

    @Override
    public boolean warmBlooded() {
        return true;
    }

    @Override
    public boolean feedMilk() {
        return !name.equalsIgnoreCase("platypus") && !name.equalsIgnoreCase("anteater");
    }

    @Override
    public boolean hasFur() {
        return true;
    }
}
