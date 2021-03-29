package com.cracking.coding.interview.system.snakeAndLadder;

public class Dice {

    private int numberOfDice;

    public int getNumberOfDice() {
        return numberOfDice;
    }

    public Dice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
    }

    public void setNumberOfDice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
    }

    public int rollDice() {
        return (int) Math.floor(Math.random() * (numberOfDice * 6 - 1) + 1);
    }
}
