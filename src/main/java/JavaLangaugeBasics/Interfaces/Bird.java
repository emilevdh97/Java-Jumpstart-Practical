package JavaLangaugeBasics.Interfaces;

public class Bird implements Animal {
    @Override
    public void eat() {
        System.out.println("The bird eats seeds.");
    }

    @Override
    public void move() {
        System.out.println("The bird flies in the sky.");
    }

    @Override
    public void makeSound() {
        System.out.println("The bird chirps.");
    }
}
