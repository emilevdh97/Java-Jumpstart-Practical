package AdvancedTopics;

public class ZooFeeding {

    //Shared food supply counter
    static int foodSupply = 10;

    //Lock object for thread safety
    static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {

        /* TODO: 1. create a Runnable using a lambda to feed the:
         -lions for 2 seconds
         -giraffes for 1.5 seconds
         -monkeys for 1 second
         */

        Runnable lionFeeder = () -> {
            System.out.println("Feeding the lions");
            try {
                Thread.sleep(2000);
//                feedAnimal("Lions", 2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Lions are fed");
        };

        Runnable giraffeFeeder = () -> {
            System.out.println("Feeding the giraffes");
            try {
                Thread.sleep(1500);
//                feedAnimal("Giraffes", 1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Giraffes are fed");
        };

        Runnable monkeyFeeder = () -> {
            System.out.println("Feeding the monkeys");
            try {
                Thread.sleep(1000);
//                feedAnimal("Monkeys", 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Monkeys are fed");
        };

        //TODO: 2. create and start threads for each feeder
        Thread lionFeederThread = new Thread(lionFeeder);
        Thread giraffeFeederThread = new Thread(giraffeFeeder);
        Thread monkeyFeederThread = new Thread(monkeyFeeder);

        //Todo: 3. Add .join() and notice how the order of feeding-completion changes
        lionFeederThread.start();
//        lionFeederThread.join();
        giraffeFeederThread.start();
//        giraffeFeederThread.join();
        monkeyFeederThread.start();
//        monkeyFeederThread.join();


    }

    //TODO: 4. Create a synchronized method or use
    // synchronized block to safely decrement the food supply
    public static void feedAnimal(String animal, int timeToFeed) {
        synchronized (lock) {
            if (foodSupply > 0) {
                System.out.println("Feeding the " + animal + "...");
                foodSupply--;
                try {
                    Thread.sleep(timeToFeed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(animal + " are fed! Remaining food: " + foodSupply);
            } else {
                System.out.println("No food left for the " + animal + "!");
            }
        }
    }
}