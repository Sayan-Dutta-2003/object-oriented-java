package animalKingdom;

public abstract class Vertebrate implements Animal{
    protected String name;

    public Vertebrate(String name) {
        this.name = name;
    }

    @Override
    public boolean hasLungs() {
        return true;
    }

    @Override
    public boolean fourLimbBodyPlan() {
        return true;
    }
}
