package uy.com.vp.deckcard.model;

public enum Rank {
    ACE("Ace"),TWO("2"),THREE("3"),FOUR("4"),FIVE("5"),SIX("6"),SEVEN("7"),EIGHT("8"), 
    NINE("9"), TEN("10"), JACK("Jack"), QUEEN("Queen"), KING("King");

    private String rank;

    Rank(String rank){
        this.setRank(rank);
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
