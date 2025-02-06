import java.util.ArrayList;

// Deven Dharni

public class Deck {
    // Instance Variables
    private ArrayList<Card> deck;
    private int cardsLeft;

    // Constructor
    public Deck(String[] rank, String[] suits, int[] points) {
        // Create the deck by making a card for each suit
        this.deck = new ArrayList<Card>();
        for (String suit: suits) {
            for (int i = 0; i < rank.length; i++) {
                Card added = new Card(rank[i], suit, points[i]);
                deck.add(added);
            }
        }
        // Initialize the card size
        cardsLeft = deck.size();
        // Shuffle the deck
        this.shuffle();
    }

    // Check if deck is empty
    public boolean isEmpty() {
        // Just check if there are no cards left
        if (cardsLeft == 0) {
            return true;
        }
        return false;
    }

    // Dealing function
    public Card deal() {
        // Check if null
        if (isEmpty()) {
            return null;
        }
        // Subtract and return
        cardsLeft--;
        return deck.get(cardsLeft);
    }

    public void shuffle() {
        // Starting point
        int i = deck.size()-1;
        while (i != 0) {
            int r = (int) (Math.random() * i);
            // Variable to keep track
            Card swapped = deck.get(r);
            // Swap the two cards
            deck.set(deck.indexOf(swapped), deck.get(i));
            deck.set(i, swapped);
            i-= 1;
        }
        // Reset the cards left
        cardsLeft = deck.size();
    }

}
