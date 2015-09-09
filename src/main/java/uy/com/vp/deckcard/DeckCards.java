package uy.com.vp.deckcard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import uy.com.vp.deckcard.exception.DeckCardsTypeException;
import uy.com.vp.deckcard.exception.DeckCardEmptyException;
import uy.com.vp.deckcard.model.Card;
import uy.com.vp.deckcard.model.Rank;
import uy.com.vp.deckcard.model.Suit;

/*
 *This implementation define a List of card to model the deck of cards, it use ArrayList as implementation 
 *to provide the use of more than one Deck
 *Also currentCardIndex attribute indicate the index of the card on the top of the deck.      
 * */
public class DeckCards implements DeckCardsInterface {

    private List<Card> deck;
    private int currentCardIndex =0;



    private void init() {
        deck = new ArrayList<Card>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()){
                deck.add(new Card(suit,rank));
            }
        }
    }

    public DeckCards() {
        init();
    }

    public DeckCards(List<Card> cards) {
        deck = new ArrayList<Card>(cards);
    }

    public DeckCards(boolean addJokers) {

        init();
        if (addJokers){
            deck.add(new Card(true));
            deck.add(new Card(true));
        }
    }

    public void shuffle() {
        Collections.shuffle(deck, new Random());
    }

    public Card TakeCard() throws DeckCardEmptyException {
        if (deck.size()<currentCardIndex+1)
            throw  new DeckCardEmptyException("The deck of card is empty, cannot take more cards");
        return deck.get(currentCardIndex++);
    }

    public int remainingCards() {
        return deck.size()-currentCardIndex;
    }

    public void resetDeck() {
        currentCardIndex = 0;
    }

    public List<Card> TakeCards(int amount) throws DeckCardEmptyException {
        if (deck.size()<currentCardIndex +amount +1)
            throw  new DeckCardEmptyException("Cannot take more than "+deck.size()+"Cards");
        List<Card> subList = deck.subList(currentCardIndex, amount);
        currentCardIndex += amount;
        return subList;
    }

    public boolean addJoker() {
        return deck.add(new Card(true));

    }

    public boolean removeJoker() {
        return deck.remove(new Card(true));
    }

    public void joinDeck(DeckCardsInterface deck) throws DeckCardsTypeException {
        if (deck instanceof DeckCards )
            this.deck.addAll(((DeckCards)deck).deck);
        else
            throw  new DeckCardsTypeException("The deck of card should be instance of DeckCards");
    }

    public List<Card> getDeck() {
        return deck;
    }

    public int getCurrentCardIndex() {
        return currentCardIndex;
    }

    @Override
    public String toString() {
        String cards="Deck of cards:\n";
        for(int i=currentCardIndex; i < deck.size(); i++)
            cards += "\t"+deck.get(i)+"\n";
        return cards;
    }

    public int removeAllJokers() {
        boolean removed = false;
        int jokerCount = 0;
        do{
            removed= removeJoker();
            if(removed)
                jokerCount++;
        }while (removed);

        return jokerCount;
    }

}
