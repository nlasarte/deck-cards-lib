package uy.com.vp.deckcard;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import uy.com.vp.deckcard.exception.DeckCardsTypeException;
import uy.com.vp.deckcard.exception.DeckCardEmptyException;
import uy.com.vp.deckcard.model.Card;

public class DeckCardsTest {

    private DeckCardsInterface deckCards;
    private DeckCardsInterface deckCards2;
    
    @Before
    public void initialization(){
        deckCards = new DeckCards(true);
        deckCards2 = new DeckCards(true);
    }
    
    @After
    public void clenUp(){
        deckCards = null;
        deckCards2 = null;
    }
    
    
    @Test
    public void init(){
        
        assertTrue(((DeckCards)deckCards).getDeck().size() >0 );
    }

    @Test
    public void init2(){
        
        deckCards2 = new DeckCards(((DeckCards)deckCards).getDeck());
        assertTrue(((DeckCards)deckCards).getDeck().size() + ((DeckCards)deckCards2).getDeck().size() == ((DeckCards)deckCards).getDeck().size() *2);
    }

    @Test
    public void shuffle(){
        
        String initial = deckCards.toString();
        deckCards.shuffle();
        assertNotEquals(initial, deckCards.toString());
    }
    
    @Test
    public void TakeCard() throws DeckCardEmptyException{
        
        Card c = deckCards.TakeCard();
        assertTrue(c.equals(((DeckCards)deckCards).getDeck().get(0)));
        c = deckCards.TakeCard();
        assertTrue(c.equals(((DeckCards)deckCards).getDeck().get(1)));
    }
    

    @Test
    public void remainingCards() throws DeckCardEmptyException{
        assertEquals(deckCards.remainingCards(), 54);
        
        for (int i = 53; i>=0;i-- ){
            deckCards.TakeCard();
            assertEquals(deckCards.remainingCards(), i);
        }
        
    }

    @Test
    public void resetDeck() throws DeckCardEmptyException{
        deckCards.TakeCard();
        assertEquals(deckCards.remainingCards(), 53);
        deckCards.resetDeck();
        assertEquals(deckCards.remainingCards(), 54);     
    }

    

    @Test
    public void TakeCards() throws DeckCardEmptyException{
        deckCards.TakeCards(10);
        assertEquals(deckCards.remainingCards(), 44);     
        deckCards.TakeCards(10);
        assertEquals(deckCards.remainingCards(), 34); 
    } 
  
    @Test
    public void addJoker(){
        assertTrue(deckCards.addJoker());
        
    }
    
    @Test
    public void removeJoker(){
        assertTrue(deckCards.removeJoker());
        assertTrue(deckCards.removeJoker());
        assertFalse(deckCards.removeJoker());

    }
        
    
    @Test
    public void joinDeck() throws DeckCardsTypeException{
        
        deckCards2 = new DeckCards(((DeckCards)deckCards).getDeck()); 
        deckCards.joinDeck(deckCards2);
        assertTrue(((DeckCards)deckCards).getDeck().size() == ((DeckCards)deckCards2).getDeck().size() *2);
        
    }
}
