package com.cracking.coding.interview.system.deckcard;

public class DeckGenerator {

    public static void main(String[] args) {
        Deck deck = new Deck();

        for(Card card : deck.getDeckCardList()){
            System.out.println(card.getSuit() + "-"+ card.getFaceValue());
        }
    }
}
