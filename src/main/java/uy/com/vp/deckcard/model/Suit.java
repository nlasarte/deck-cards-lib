package uy.com.vp.deckcard.model;

public enum Suit {

    CLUB("Clubs"),DIAMONDS("Diamonds"), HEARTS("Hearts"), SPADES("Spades");

    private String suit;

    Suit(String suit){
        this.suit=suit;

    }

    public String getSuit() {
        return suit;
    }


}
