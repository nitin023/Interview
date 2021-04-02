package com.cracking.coding.interview.designpatterns.Singleton;

/**
 * 1. Eager initialization
 * In eager initialization, the instance of Singleton Class is created at the time of class loading,
 * this is the easiest method to create a singleton class but it has a drawback that instance is created even though client application might not be using it.
 */
public class EagerInitializedSingleton {

    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();

    //private constructor to avoid client applications to use constructor
    private EagerInitializedSingleton() {
    }

    public static EagerInitializedSingleton getInstance() {
        return instance;
    }
}

class EagerInitializedSingletonTest {

    public static void main(String[] args) {

        EagerInitializedSingleton object1 = EagerInitializedSingleton.getInstance();
        print("object1",object1);
        EagerInitializedSingleton object2 = EagerInitializedSingleton.getInstance();
        print("object2",object2);
    }

    private static void print(String name , EagerInitializedSingleton eagerInitializedSingleton){
        System.out.printf("Object :%s, HashCode : %d%n",name,eagerInitializedSingleton.hashCode());
    }
}
