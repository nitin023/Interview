package com.cracking.coding.interview.StackAndQueues;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Medium
 * 3.4 Implement a queue using two stacks
 * Approach to solve problem
 * one stack is used to map all the elements
 * while second stack is used to reverse the elements
 * to make behavior of the queue using the stacks
 *
 * we on just adding used first stack to enqueue elements
 * when we pop/peek elements in a queue always it is done in FIFO order
 * so for this we look our second stack if our stack is empty then we fill it with all
 * elements of primary stack then we look on second stack for the element.
 */
public class QueueUsingTwoStacks {
    private static Stack<Integer> oldest = new Stack();
    private static Stack<Integer> newest = new Stack();

    public static void main(String[] args) throws Exception {
        //code
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int numOfQueries = Integer.parseInt(st.nextToken());

            while (numOfQueries > 0) {
                numOfQueries--;
                String inputLine = br.readLine();
                String[] inputList = inputLine.trim().split(" ");
                //dequeue or peek top
                if (inputList.length == 1) {
                    if (inputList[0].equals("2")) {
                        dequeue();
                    } else {
                        System.out.println(getFrontElement());
                    }
                } else {
                    newest.push(Integer.parseInt(inputList[1]));
                }
            }
        }
    }

    private static void dequeue() {
        shiftStacks();
        oldest.pop();
    }

    private static int getFrontElement() {
        shiftStacks();
        return oldest.peek();
    }

    private static void shiftStacks() {
        if (oldest.isEmpty()) {
            while (!newest.isEmpty()) {
                oldest.push(newest.pop());
            }
        }
    }
}
