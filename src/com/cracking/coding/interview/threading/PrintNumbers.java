package com.cracking.coding.interview.threading;

public class PrintNumbers {
    final static int MAX_NUMBERS = 10;

    public static void main(String[] args) {
        PrintNumbers obj = new PrintNumbers();
        Thread t1 = new Thread(new NumberRunnable(obj,0),"T1");
        Thread t2 = new Thread(new NumberRunnable(obj,1),"T2");
        Thread t3 = new Thread(new NumberRunnable(obj,2),"T3");
        t1.start();
        t2.start();
        t3.start();
    }
}

class NumberRunnable implements Runnable{

    final PrintNumbers obj;
    int threadNumber;
    static volatile int number = 0;

    public NumberRunnable(PrintNumbers obj ,int result){
        this.obj = obj;
        this.threadNumber = result;
    }

    @Override
    public void run() {
        synchronized(obj) {
            while (number < PrintNumbers.MAX_NUMBERS - 2) {
                while(number % 3 != threadNumber){
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " - " + ++number);
                obj.notifyAll();
            }
        }
    }
}
