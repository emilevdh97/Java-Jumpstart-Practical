package ExceptionHandlingAndLogging;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AnimalReader {
    static List<Animal> animalsReader(FileReader fileReader) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList<Animal> animals = new ArrayList<>();
        String line = bufferedReader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            animals.add(new Animal(
                            split[0],
                            split[1],
                            readInteger(split[2]),
                            split[3]
            ));
            line = bufferedReader.readLine();
        }
        return animals;
    }

    private static int readInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
