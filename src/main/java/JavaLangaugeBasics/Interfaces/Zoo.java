package JavaLangaugeBasics.Interfaces;

public class Zoo {
    public static void main(String[] args) {
        Animal lion = new Lion();
        Animal bird = new Bird();

        displayAnimalInfo(lion);
        displayAnimalInfo(bird);
    }

    public static void displayAnimalInfo(Animal animal) {
        animal.eat();
        animal.move();
        animal.makeSound();
        System.out.println("----------");
    }
}
