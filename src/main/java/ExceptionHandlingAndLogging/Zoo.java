package ExceptionHandlingAndLogging;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private static final File file = new File("src/wrong/folder/animals.csv");

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>(readAnimals());
        for (Animal animal : animals) {
            System.out.println("Animal {}" + animal);
        }
    }

    private static List<Animal> readAnimals() {
        /*FileReader fileReader = new FileReader(file);
        return animalsReader(fileReader);*/
        return List.of();
    }
}
