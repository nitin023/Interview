package com.cracking.coding.interview.designpatterns.Singleton.Threadsafe;

import com.cracking.coding.interview.designpatterns.Singleton.EagerInitialise.EagerInitializedSingleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The easier way to create a thread-safe singleton class is to make the global access method synchronized,
 * so that only one thread can execute this method at a time.
 * Above implementation works fine and provides thread-safety
 * but it reduces the performance because of the cost associated with the synchronized method,
 */
public class ThreadSafeSingleton {

    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton() { }

    public synchronized  static ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
}

class ThreadSafeSingletonTest {

    static void useSingleton(){
        ThreadSafeSingleton safeSingleton = ThreadSafeSingleton.getInstance();
        print("singleton",safeSingleton);
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(ThreadSafeSingletonTest::useSingleton);
        executorService.submit(ThreadSafeSingletonTest::useSingleton);
        executorService.submit(ThreadSafeSingletonTest::useSingleton);
        executorService.submit(ThreadSafeSingletonTest::useSingleton);
        executorService.shutdown();
    }

    private static void print(String name , ThreadSafeSingleton threadSafeSingleton){
        System.out.printf("Object :%s, HashCode : %d%n",name,threadSafeSingleton.hashCode());
    }
}
