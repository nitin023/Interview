package com.cracking.coding.interview.designpatterns.Singleton.LazyInitialisation;

/**
 * Lazy initialization method to implement Singleton pattern creates the instance in the global access method
 */
public class LazyInitializedSingleton {

    private static LazyInitializedSingleton instance;

    private LazyInitializedSingleton() {
    }

    public static LazyInitializedSingleton getInstance() {
        if (instance == null) {
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }
}

class LazyInitializedSingletonTest {

    public static void main(String[] args) {

        LazyInitializedSingleton object1 = LazyInitializedSingleton.getInstance();
        print("object1",object1);
        LazyInitializedSingleton object2 = LazyInitializedSingleton.getInstance();
        print("object2",object2);
    }

    private static void print(String name , LazyInitializedSingleton lazyInitializedSingleton){
        System.out.printf("Object :%s, HashCode : %d%n",name,lazyInitializedSingleton.hashCode());
    }
}
