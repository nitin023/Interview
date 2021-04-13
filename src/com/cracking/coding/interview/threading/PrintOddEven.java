package com.cracking.coding.interview.threading;

public class PrintOddEven {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread t1 = new Thread(new TaskEvenOdd(10,printer,true));
        Thread t2 = new Thread(new TaskEvenOdd(10,printer,false));
        t1.start();
        t2.start();
    }
}

class TaskEvenOdd implements Runnable {
    private int max;
    private final Printer print;
    private final boolean isEvenNumber;

    public TaskEvenOdd(int max, Printer printer, boolean isEvenNumber) {
        this.max = max;
        this.isEvenNumber = isEvenNumber;
        this.print = printer;
    }

    @Override
    public void run() {
        int number = isEvenNumber ? 2 : 1;
        while (number <= max) {
            if (isEvenNumber) {
                print.printEven(number);
            } else {
                print.printOdd(number);
            }
            number += 2;
        }
    }
}

class Printer {
    private volatile boolean isOdd;
    synchronized void printEven(int number) {
        while (!isOdd) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + number);
        isOdd = false;
        notifyAll();
    }

    synchronized void printOdd(int number) {
        while (isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + number);
        isOdd = true;
        notifyAll();
    }
}
