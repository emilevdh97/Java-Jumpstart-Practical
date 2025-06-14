package JavaLanguageBasics;

import java.util.ArrayList;
import java.util.List;

public class Cage<T extends Animal> {
    private List<T> animals = new ArrayList<>();

    public void addAnimal(T animal) {
        animals.add(animal);
    }

    public List<T> getAnimals() {
        return animals;
    }
}