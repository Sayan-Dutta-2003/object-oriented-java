package animalKingdom;

public class Reptile extends Vertebrate{
    public Reptile(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(name + " is swallowing food");
    }
    @Override
    public void sleep() {
        System.out.println(name + " is basking");
    }
    @Override
    public void move() {
        System.out.println(name + " is crawling");
    }
    @Override
    public void makeSound() {
        System.out.println(name + " hisses");
    }
    @Override
    public boolean warmBlooded() {
        return false;
    }
    @Override
    public boolean feedMilk() {
        return false;
    }
    @Override
    public boolean hasFur() {
        return false;
    }
}
