package com.cracking.coding.interview.system.snakeAndLadder;


import java.util.Objects;

public class Player {

    private String playerName;
    private long playerId;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return playerId == player.playerId && Objects.equals(playerName, player.playerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName, playerId);
    }

    public Player(){}

    public Player(String playerName, long playerId) {
        this.playerName = playerName;
        this.playerId = playerId;
    }
}
