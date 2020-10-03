package com.cracking.coding.interview.StackAndQueues;

public class StackRunner {

    public static void main(String[] args) {
        SortStack sortStack = new SortStack();
        sortStack.push(10);
        sortStack.push(5);
        sortStack.push(15);
        sortStack.push(1);
        sortStack.push(12);
        System.out.println(sortStack.peek());
        sortStack.pop();
        System.out.println(sortStack.peek());
        sortStack.pop();
        System.out.println(sortStack.peek());
        sortStack.push(23);
        System.out.println(sortStack.peek());
    }
}
