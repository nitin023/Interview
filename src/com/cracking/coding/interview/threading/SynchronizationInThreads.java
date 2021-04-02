package com.cracking.coding.interview.threading;


public class SynchronizationInThreads implements Runnable {

    public int PRINT_NUMBERS_UP_TO = 300;
    static int number = 1;
    int remainder;
    static Object lock = new Object();

    SynchronizationInThreads(int remainder) {
        this.remainder = remainder;
    }

    @Override
    public void run() {
        while (number < PRINT_NUMBERS_UP_TO - 1) {
            synchronized (lock) {
                while (number % 3 != remainder) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(Thread.currentThread().getName() + " ");
                if(remainder==0){
                    System.out.println();
                }
                number++;
                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) {

        SynchronizationInThreads runnable1 = new SynchronizationInThreads(1);
        SynchronizationInThreads runnable2 = new SynchronizationInThreads(2);
        SynchronizationInThreads runnable3 = new SynchronizationInThreads(0);

        Thread t1 = new Thread(runnable1, "Welcome");
        Thread t2 = new Thread(runnable2, "To");
        Thread t3 = new Thread(runnable3, "India");

        t1.start();
        t2.start();
        t3.start();
    }
}