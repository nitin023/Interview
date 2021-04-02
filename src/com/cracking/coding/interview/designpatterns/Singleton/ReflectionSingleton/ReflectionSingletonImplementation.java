package com.cracking.coding.interview.designpatterns.Singleton.ReflectionSingleton;

import java.lang.reflect.Constructor;

/**
 * Prevented object creation using reflection by handling object instance request in constructor
 */
public class ReflectionSingletonImplementation {

    private static ReflectionSingletonImplementation instance = null;

    private ReflectionSingletonImplementation(){
        if(instance !=null){
            throw new RuntimeException("Cannot create ,please use getInstance()");
        }
    }

    public static ReflectionSingletonImplementation getInstance(){
        if(instance ==null){
            instance = new ReflectionSingletonImplementation();
        }
        return instance;
    }
}

class ReflectionSingletonImplementationTest{
    public static void main(String[] args) throws Exception{

        System.out.println("using Reflection");
        ReflectionSingletonImplementation r1 = ReflectionSingletonImplementation.getInstance();
        print("r1",r1);
        Class clazz = Class.forName("com.cracking.coding.interview.designpatterns.Singleton.ReflectionSingleton.ReflectionSingletonImplementation");
        Constructor<ReflectionSingletonImplementation> reflectionSingletonImplementationConstructor = clazz.getDeclaredConstructor();
        reflectionSingletonImplementationConstructor.setAccessible(true);
        ReflectionSingletonImplementation r2 = reflectionSingletonImplementationConstructor.newInstance();
        print("r2",r2);
    }

    private static void print(String name , ReflectionSingletonImplementation reflectionSingletonImplementation){
        System.out.printf("Object :%s, HashCode : %d%n",name,reflectionSingletonImplementation.hashCode());
    }
}


