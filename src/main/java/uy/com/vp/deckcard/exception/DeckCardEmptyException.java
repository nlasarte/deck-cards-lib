package uy.com.vp.deckcard.exception;

public class DeckCardEmptyException extends Exception {

    
    private static final long serialVersionUID = 1L;

    /**
     * @param message
     */
    public DeckCardEmptyException(String message) {
       super(message);
    }

    /**
     * 
     */
    public DeckCardEmptyException() {
        super();
    }



}
