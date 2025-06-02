package JavaLangaugeBasics;

import java.util.ArrayList;
import java.util.List;

public class CollectionsLoopsFlowControl {
    public static void main(String[] args) {

        List<String> animals = new ArrayList<>();
        animals.add("Lion");
        animals.add("Elephant");
        animals.add("Snake");
        animals.add("Giraffe");
        animals.add("Tiger");

        for (String animal : animals) {
               if (animal.equals("Snake")) {
                System.out.println("Skipping the dangerous Snake!");
                continue;
            }
            System.out.println("Visiting the " + animal);
              if (animal.equals("Tiger")) {
                System.out.println("Reached the Tiger, ending the zoo tour.");
                break;
            }
        }
    }
}
