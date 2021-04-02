package com.cracking.coding.interview.designpatterns.Singleton.staticBlockInitialise;

/**
 * Static block initialization implementation is similar to eager initialization,
 * except that instance of class is created in the static block that provides option for exception handling.
 */
public class StaticBlockSingleton {

    private static StaticBlockSingleton instance;

    private StaticBlockSingleton() {
    }

    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in creating Singleton instance");
        }
    }

    public static StaticBlockSingleton getInstance() {
        return instance;
    }
}

class StaticBlockSingletonTest {

    public static void main(String[] args) {

        StaticBlockSingleton object1 = StaticBlockSingleton.getInstance();
        print("object1", object1);
        StaticBlockSingleton object2 = StaticBlockSingleton.getInstance();
        print("object2", object2);
    }

    private static void print(String name, StaticBlockSingleton staticBlockSingleton) {
        System.out.printf("Object :%s, HashCode : %d%n", name, staticBlockSingleton.hashCode());
    }
}
