package ExceptionHandlingAndLogging;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private static final File file = new File("src/wrong/folder/animals.csv");

    public static void main(String[] args) {
        List<Animal> animals;
        animals = new ArrayList<>(readAnimals());
        for (Animal animal : animals) {

        }
    }

    private static List<Animal> readAnimals() {
        return List.of();
    }
}
