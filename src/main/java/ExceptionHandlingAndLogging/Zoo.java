package ExceptionHandlingAndLogging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static ExceptionHandlingAndLogging.AnimalReader.animalsReader;

public class Zoo {
    private static final File file = new File("src/main/resources/animals.csv");
    private static final Logger logger = LoggerFactory.getLogger(Zoo.class);

    public static void main(String[] args) {
        List<Animal> animals;
        try {
            animals = new ArrayList<>(readAnimals());
        } catch (IOException e) {
            logger.error("Error occurred while trying to read animals!", e);
            animals = List.of();
        }

        for (Animal animal : animals) {
            logger.info("animal: {}", animal);
        }
    }

    private static List<Animal> readAnimals() throws IOException {
        try (FileReader fileReader = new FileReader(file)) {
            return animalsReader(fileReader);
        } catch (FileNotFoundException e) {
            logger.error("Error occurred while trying to open the animals file!", e);
            throw new AnimalFileNotFoundException("Use the correct file path", e);
        }
    }
}
