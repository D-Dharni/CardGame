import java.util.ArrayList;

public class Deck {
    // Instance Variables
    private ArrayList<Card> deck = new ArrayList<Card>();
    private int cardsLeft;

    // Constructor
    public Deck(String[] rank, String[] suits, int[] points) {
        // creat the deck by making a card for each suit
        for (String suit: suits) {
            for (int i = 0; i < rank.length; i++) {
                Card added = new Card(rank[i], suit, points[i]);
                deck.add(added);
            }
        }
        // initialize the card size
        cardsLeft = deck.size();
        // shuffle the deck
        this.shuffle();
    }

    // Check if deck is empty
    public boolean isEmpty() {
        // just check if there are no cards left
        if (cardsLeft == 0) {
            return true;
        }
        return false;
    }

    // Dealing function
    public Card deal() {
        // check if null
        if (isEmpty()) {
            return null;
        }
        // subtract and return
        cardsLeft--;
        return deck.get(cardsLeft);
    }

    public void shuffle() {
        // starting point
        int i = deck.size()-1;
        while (i != 0) {
            int r = (int) (Math.random() * i);
            // variable to keep track
            Card swapped = deck.get(r);
            // swap the two cards
            deck.set(deck.indexOf(swapped), deck.get(i));
            deck.set(i, swapped);
            i-= 1;
        }
        // reset the cards left
        cardsLeft = deck.size();
    }

}
