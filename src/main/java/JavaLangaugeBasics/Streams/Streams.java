package JavaLangaugeBasics.Streams;

import java.util.*;

public class Streams {
    public static void main(String[] args) {
        Map<String, List<String>> animalMap = Map.of(
                "Carnivore", List.of("Lion", "Tiger", "Hyena"),
                "Herbivore", List.of("Elephant", "Giraffe", "Zebra")
        );

        animalMap.entrySet().stream()
                .filter(entry -> entry.getKey().equalsIgnoreCase("Herbivore"))
                .flatMap(entry -> entry.getValue().stream())
                .forEach(animal ->
                        System.out.println("Feeding " + animal + " some fresh plants!")
                );



//        animalMap.entrySet().stream()
//                .peek(entry -> System.out.println("Filtering key: " + entry.getKey()))
//                .filter(entry -> entry.getKey().equalsIgnoreCase("Herbivore"))
//                .peek(entry -> System.out.println("Preparing to flatten: " + entry.getKey()))
//                .flatMap(entry -> entry.getValue().stream());
//    .forEach(animal -> System.out.println("Feeding " + animal + " some fresh plants!"));

    }
}
