package loggingAndExceptionHandling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Zoo {
    private static final Logger logger = LoggerFactory.getLogger(Zoo.class);
    private static final File file = new File("src/main/java/loggingAndExceptionHandling/animals.csv");

    public static void main(String[] args) {
        try {
            List<Animal> animals = readAnimals(file);
            animals.set(3, null);
            int numberOfAnimals = animals.size();
            for (int index = 0; index < numberOfAnimals; index++) {
                logger.info("Animal {}", animals.get(index));
            }
        } catch (IOException exception) {
            logger.error("Could not read animals file", exception);
        }
    }

    private static List<Animal> readAnimals(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        return animalsReader(fileReader);
    }

    private static List<Animal> readAnimalsWithResources(File file) {
        try(FileReader fileReader = new FileReader(file)){
            return animalsReader(fileReader);
        } catch (FileNotFoundException e) {
            throw new ZooAnimalsFileNotFound("Could not find animals file: " + file, e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Animal> readAnimalsWithFinallyGotcha(File file) {
        try(FileReader fileReader = new FileReader(file)){
            return animalsReader(fileReader);
        } catch (FileNotFoundException e) {
            throw new ZooAnimalsFileNotFound("Could not find animals file: " + file, e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            return Collections.emptyList();
        }
    }

    private static List<Animal> animalsReader(FileReader fileReader) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList<Animal> animals = new ArrayList<>();
        String line = bufferedReader.readLine();
        while(line != null) {
            String[] split = line.split(",");
            animals.add(new Animal(split[0], split[1], Integer.parseInt(split[2]), split[3]));
            line = bufferedReader.readLine();
        }
        return animals;
    }
}
