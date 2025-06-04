package JavaLangaugeBasics.Interfaces.CustomFunctionalInterface;

public class Zoo {
    public void makeAnimalDo(String animal, AnimalAction action) {
        System.out.print(animal + ": ");
        action.perform(animal);
    }

    public static void main(String[] args) {
        Zoo customFunctionalInterface = new Zoo();

        customFunctionalInterface.makeAnimalDo("Lion", (name) -> System.out.println("Roars fiercely!"));

        customFunctionalInterface.makeAnimalDo("Elephant", (name) -> System.out.println("Sprays water with its trunk!"));

        customFunctionalInterface.makeAnimalDo("Monkey", (name) -> System.out.println("Swings from tree to tree!"));
    }
}
