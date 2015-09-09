package uy.com.vp.deckcard;

import java.util.List;

import uy.com.vp.deckcard.exception.DeckCardsTypeException;
import uy.com.vp.deckcard.exception.DeckCardEmptyException;
import uy.com.vp.deckcard.model.Card;
/** 
 * 
 * This interface allows manipulate a deck of cards. 
 * Some of the operation have restriction of the status of the deck, so for example 
 * if you are trying to take a card from an empty deck it throw an empty a DeckOfCardEmptyException. 
 * 
 *  
 * @author nlasarte
 * @see DeckCards
 * @see Card
 * @see DeckCardsTypeException
 * @see DeckCardEmptyException
 *  
*/

public interface DeckCardsInterface {
    
    public void shuffle();
    
    public void resetDeck();
    
    public Card TakeCard() throws DeckCardEmptyException; 
    
    public List<Card> TakeCards(int amount) throws DeckCardEmptyException; 
    
    public int remainingCards();
    
    public boolean addJoker();
    
    public boolean removeJoker();
    
    public int removeAllJokers();
    
    public void joinDeck(DeckCardsInterface decks) throws DeckCardsTypeException;
}
