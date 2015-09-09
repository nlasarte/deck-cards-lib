package uy.com.vp.deckcard.model;

/*
 * 
 * French Card model by couple if Suit and Rank and a boolean for the jokers. 
 * So if the joker flag is true, the suit and rank will be ignored
 * */

public class Card {

    private Suit suit;
    private Rank rank; 
    private boolean joker;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
        this.joker =  false;
        
    }

    public Card(boolean joker) {
        this.joker = joker;
    }

    @Override
    public String toString() {
        if (this.joker)
            return "Joker";
        return rank.getRank() + " of " + suit.getSuit();
        
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof Card))
            return false;
        
        Card c = (Card)obj;
        return (this.joker && c.joker) || (this.suit==c.suit && this.rank==c.rank );
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public boolean isJoker() {
        return joker;
    }

}

