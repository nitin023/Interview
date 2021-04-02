package com.cracking.coding.interview.designpatterns.Singleton.SerialiseAndSingleton;

import com.cracking.coding.interview.designpatterns.Singleton.EagerInitialise.EagerInitializedSingleton;

import java.io.*;

/**
 * Sometimes in distributed systems, we need to implement Serializable interface in Singleton class so that
 * we can store its state in the file system and retrieve it at a later point of time.
 * Here is a small singleton class that implements Serializable interface also.
 * So it destroys the singleton pattern,
 * to overcome this scenario all we need to do it provide the implementation of readResolve() method.
 */
public class SerializedSingleton implements Serializable {

    private static final long serialVersionUID = -7604766932017737115L;

    private static final SerializedSingleton instance = new SerializedSingleton();

    private SerializedSingleton() {
    }

    public static SerializedSingleton getInstance() {
        return instance;
    }

    //override deserialization and give us back the current instance
    private Object readResolve() throws ObjectStreamException{
        return getInstance();
    }
}

class SerializedSingletonTest{
    public static void main(String[] args) throws Exception{
        SerializedSingleton s1 = SerializedSingleton.getInstance();
        print("s1",s1);
        SerializedSingleton s2 = SerializedSingleton.getInstance();
        print("s2",s2);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/tmp/nitin.ser"));
        oos.writeObject(s2);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/tmp/nitin.ser"));
        SerializedSingleton s3 = (SerializedSingleton) ois.readObject();
        print("s3",s3);
    }

    private static void print(String name , SerializedSingleton serializedSingleton){
        System.out.printf("Object :%s, HashCode : %d%n",name,serializedSingleton.hashCode());
    }
}
