package ExceptionHandlingAndLogging;
/**
 * Do not change this class
 * */
public class Animal {
    private final String name;
    private final String species;
    private final int age;
    private final String habitat;

    public Animal(String name, String species, int age, String habitat) {
        this.name = name;
        this.species = species;
        this.age = age;
        this.habitat = habitat;
    }

    @Override
    public String toString() {
        return name + " the " + species + " is " + age + " years old and lives in the " + habitat + ".";
    }
}
