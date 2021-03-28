package com.cracking.coding.interview.system.deckcard;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    private List<Card> deckCardList;

    public List<Card> getDeckCardList() {
        return deckCardList;
    }

    public void setDeckCardList(List<Card> deckCardList) {
        this.deckCardList = deckCardList;
    }

    public Deck() {
        this.deckCardList = new ArrayList<>();

        for (int value = 1; value < 14; value++) {
            for (Suit suit : Suit.values()) {
                deckCardList.add(new Card(value, suit));
            }
        }
    }
}
