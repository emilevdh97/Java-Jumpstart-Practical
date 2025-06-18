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

        Runnable lionFeeder = null;

        Runnable giraffeFeeder = null;

        Runnable monkeyFeeder = null;

        //TODO: 2. create and start threads for each feeder


        //Todo: 3. Add .join() and notice how the order of feeding-completion changes

    }

    //TODO: 4. Create a synchronized method or use
    // synchronized block to safely decrement the food supply
    public static void feedAnimal(String animal, int timeToFeed) {

    }

}
