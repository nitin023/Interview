package com.cracking.coding.interview.designpatterns.Singleton;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public enum EnumSingleton {

    INSTANCE ;

    public String getConfiguration(){
        return "dummy";
    }
}


class TestEnumSingleton{

    static void useSingleton(){
        EnumSingleton safeSingleton = EnumSingleton.INSTANCE;
        print("singleton",safeSingleton);
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(TestEnumSingleton::useSingleton);
        executorService.submit(TestEnumSingleton::useSingleton);
        executorService.submit(TestEnumSingleton::useSingleton);
        executorService.submit(TestEnumSingleton::useSingleton);
        executorService.shutdown();
    }

    private static void print(String name ,EnumSingleton  threadSafeSingleton){
        System.out.printf("Object :%s, HashCode : %d%n",name,threadSafeSingleton.hashCode());
    }
}

