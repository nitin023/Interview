package com.cracking.coding.interview.designpatterns.Singleton.Threadsafe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Above implementation works fine and provides thread-safety but it reduces the performance because of the cost associated with the synchronized method,
 * although we need it only for the first few threads who might create the separate instances (Read: Java Synchronization).
 * To avoid this extra overhead every time, double checked locking principle is used.
 * In this approach, the synchronized block is used inside the if condition with an additional check to ensure that only one instance of a singleton class is created.
 *
 * Importance of volatile keyword in multithreaded environment
 *
 * if a thread enters code for creating the instance it may prepare half baked object
 * now when another thread enters the code it found that instance object is not null
 * and will return half baked object which will cause problem certainly to prevent this
 * we use volatile keyword which prepare complete object removing such problems
 */
public class DoubleLockingThreadSafe {

    private static volatile DoubleLockingThreadSafe instance;

    private DoubleLockingThreadSafe() {
    }

    public static DoubleLockingThreadSafe getInstance() {
        if (instance == null) {
            synchronized (DoubleLockingThreadSafe.class) {
                if (instance == null) {
                    instance = new DoubleLockingThreadSafe();
                }
            }
        }
        return instance;
    }
}

class DoubleLockingThreadSafeTest {

    static void useSingleton() {
        DoubleLockingThreadSafe safeSingleton = DoubleLockingThreadSafe.getInstance();
        print("singleton", safeSingleton);
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(ThreadSafeSingletonTest::useSingleton);
        executorService.submit(ThreadSafeSingletonTest::useSingleton);
        executorService.submit(ThreadSafeSingletonTest::useSingleton);
        executorService.submit(ThreadSafeSingletonTest::useSingleton);
        executorService.shutdown();
    }

    private static void print(String name, DoubleLockingThreadSafe doubleLockingThreadSafe) {
        System.out.printf("Object :%s, HashCode : %d%n", name, doubleLockingThreadSafe.hashCode());
    }
}
