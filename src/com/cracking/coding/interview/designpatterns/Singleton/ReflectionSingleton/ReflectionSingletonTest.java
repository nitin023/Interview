package com.cracking.coding.interview.designpatterns.Singleton.ReflectionSingleton;

import com.cracking.coding.interview.designpatterns.Singleton.EagerInitialise.EagerInitializedSingleton;

import java.lang.reflect.Constructor;

/**
 * Reflection can be used to destroy all the above singleton implementation approaches.
 * Let’s see this with an example class.
 * When you run the above test class,
 * you will notice that hashCode of both the instances is not same that destroys the singleton pattern.
 * Reflection is very powerful and used in a lot of frameworks like Spring and Hibernate
 */
public class ReflectionSingletonTest {
    public static void main(String[] args) {
        EagerInitializedSingleton instanceOne = EagerInitializedSingleton.getInstance();
        EagerInitializedSingleton instanceTwo = null;
        try {
            Constructor[] constructors = EagerInitializedSingleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                //Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (EagerInitializedSingleton) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.printf("instanceOne %d" ,instanceOne.hashCode());
        System.out.printf("\ninstanceTne %d" ,instanceTwo.hashCode());
    }
}
