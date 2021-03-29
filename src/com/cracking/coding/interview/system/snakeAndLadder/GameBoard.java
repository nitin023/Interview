package com.cracking.coding.interview.system.snakeAndLadder;

import java.util.*;

public class GameBoard {

    private Dice dice;
    private Queue<Player> nextTurn;
    private List<Jumper> snakes;
    private List<Jumper> ladders;
    private Map<Long, Integer> playerIdCurrentPositionMap;
    private int boardSize;

    private Map<Integer, Jumper> snakesPositionMap = new HashMap<>();
    private Map<Integer, Jumper> laddersPositionMap = new HashMap<>();

    public GameBoard(Dice dice, Queue<Player> nextTurn, List<Jumper> snakes, List<Jumper> ladders, Map<Long, Integer> playerIdCurrentPositionMap, int boardSize) {
        this.dice = dice;
        this.nextTurn = nextTurn;
        this.snakes = snakes;
        this.ladders = ladders;
        this.playerIdCurrentPositionMap = playerIdCurrentPositionMap;
        this.boardSize = boardSize;
    }

    private void initialiseSnakeAndLadderPositionSet() {
        List<Jumper> snakeList = this.snakes;
        List<Jumper> ladderList = this.ladders;

        for (Jumper jumper : snakeList) {
            snakesPositionMap.put(jumper.getStartPoint(), jumper);
        }

        for (Jumper jumper : ladderList) {
            laddersPositionMap.put(jumper.getStartPoint(), jumper);
        }
    }

    public void startGame() {
        initialiseSnakeAndLadderPositionSet();
        //until we have two players in a queue game continues
        while (nextTurn.size() > 1) {
            Player currentPlayer = nextTurn.poll();
            int currentPlayerPosition = playerIdCurrentPositionMap.get(currentPlayer.getPlayerId());
            int diceRollValue = dice.rollDice();
            int playerNextPosition = currentPlayerPosition + diceRollValue;

            if (playerNextPosition > boardSize) {
                nextTurn.offer(currentPlayer);
            } else if (playerNextPosition == boardSize) {
                System.out.println(currentPlayer.getPlayerName() + " has won the game ");
            } else {
                if (snakesPositionMap.containsKey(playerNextPosition)) {
                    Jumper snakeJumper = snakesPositionMap.get(playerNextPosition);
                    System.out.println(currentPlayer.getPlayerName() + " has been bitten by snake");
                    playerNextPosition = snakeJumper.getEndPoint();
                } else if (laddersPositionMap.containsKey(currentPlayerPosition)) {
                    Jumper ladderJumper = laddersPositionMap.get(currentPlayerPosition);
                    playerNextPosition = ladderJumper.getEndPoint();
                }
                if (playerNextPosition == boardSize) {
                    System.out.println(currentPlayer.getPlayerName() + " has won");
                } else {
                    nextTurn.offer(currentPlayer);
                }
                playerIdCurrentPositionMap.put(currentPlayer.getPlayerId(), playerNextPosition);
            }
        }
    }
}
