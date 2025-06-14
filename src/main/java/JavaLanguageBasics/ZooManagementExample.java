package JavaLanguageBasics;
import java.lang.reflect.Method;
import java.util.*;

public class ZooManagementExample {
    public static void main(String[] args) throws Exception {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Lion", 5));
        animals.add(new Animal("Elephant", 10));
        animals.add(new Animal("Zebra", 3));

        Cage<Animal> cage = new Cage<>();
        animals.forEach(animal-> cage.addAnimal(animal));

        new ZooLogger().logFeeding();

        // Stream + Functional Interface
        FeedingStrategy strategy = animal -> animal.feed();
        cage.getAnimals().stream()
                .filter(animal -> !animal.isFed())
                .forEach(animal-> strategy.feed(animal));

        // Annotation usage
        Method logMethod = ZooLogger.class.getMethod("logFeeding");
        if (logMethod.isAnnotationPresent(Info.class)) {
            Info info = logMethod.getAnnotation(Info.class);
            System.out.println("Author: " + info.author() + ", Date: " + info.date()
                    + ", Description: " + info.description());
        }


    }
}
