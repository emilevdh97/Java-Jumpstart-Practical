package JavaLangaugeBasics.Interfaces;

public class Lion implements Animal {
    @Override
    public void eat() {
        System.out.println("The lion eats meat.");
    }

    @Override
    public void move() {
        System.out.println("The lion runs on four legs.");
    }

    @Override
    public void makeSound() {
        System.out.println("The lion roars.");
    }
}
