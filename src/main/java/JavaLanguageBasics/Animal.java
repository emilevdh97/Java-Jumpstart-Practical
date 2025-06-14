package JavaLanguageBasics;

public class Animal implements Feedable {
    private String name;
    private int age;
    private boolean isFed;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        this.isFed = false;
    }

    @Override
    public void feed() {
        isFed = true;
        System.out.println(name + " has been fed.");
    }

    public boolean isFed() {
        return isFed;
    }

    public String getName() {
        return name;
    }
}