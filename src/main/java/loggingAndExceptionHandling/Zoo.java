package loggingAndExceptionHandling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static loggingAndExceptionHandling.AnimalReader.animalsReader;

public class Zoo {
    private static final Logger logger = LoggerFactory.getLogger(Zoo.class);
    private static final File file = new File("src/main/resources/animals.csv");

    public static void main(String[] args) {
        List<Animal> animals;
        try {
            animals = new ArrayList<>(readAnimals());
        } catch (IOException e) {
            logger.error("Something went wrong with reading the file ", e);
            animals = List.of();
        } catch (Exception e) {
            logger.error("Something went wrong", e);
            animals = List.of();
        }
        for (Animal animal : animals) {
            logger.info("Animal {}", animal);
        }
    }

    private static List<Animal> readAnimals() throws IOException {
        try (FileReader fileReader = new FileReader(file)) {
            return animalsReader(fileReader);
        } catch (FileNotFoundException e) {
            throw new AnimalsFileNotFoundException("Could not locate the file to read", e);
        }
    }
}
