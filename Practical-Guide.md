# Java Jumpstart Practical Guide

# Step 1: Understand the Goal
We want to:
Define a custom behavior for animals (like roaring, spraying water).
Pass this behavior as a function using a functional interface.
Let the Zoo class invoke this behavior dynamically.

# Step 2: Create a Functional Interface
A functional interface has exactly one abstract method.

Create a file choose (class>interface on the drop down) named AnimalAction.java:

@FunctionalInterface
public interface AnimalAction {
void perform(String animalName);
}

The @FunctionalInterface annotation is optional but recommended 
— it helps the compiler ensure you don’t accidentally add extra abstract methods.

perform(String animalName) is the one method that must be implemented.

# Step 3: Use the Interface in a Class
📄 In your Zoo.java file:


public class Zoo {

    public void makeAnimalDo(String animal, AnimalAction action) {
        System.out.print(animal + ": ");
        action.perform(animal);
    }

    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        zoo.makeAnimalDo("Lion", (name) -> System.out.println("Roars fiercely!"));
        zoo.makeAnimalDo("Elephant", (name) -> System.out.println("Sprays water with its trunk!"));
        zoo.makeAnimalDo("Monkey", (name) -> System.out.println("Swings from tree to tree!"));
    }
}
makeAnimalDo accepts:

The animal’s name
An AnimalAction (behavior)

We pass lambdas like (name) -> System.out.println("Roars fiercely!"), which match the interface method.

# Step 4: Compile and Run
Make sure your files are in the same directory, then compile and run them:


OutPut
Lion: Roars fiercely!
Elephant: Sprays water with its trunk!
Monkey: Swings from tree to tree!
