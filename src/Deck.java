import java.util.ArrayList;

public class Deck {
    // Instance Variables
    private ArrayList<Card> deck;
    private int cardsLeft;

    // Constructor
    public Deck(String[] rank, String[] suits, int[] points) {
        for (String suit: suits) {
            for (int i = 0; i < rank.length; i++) {
                Card added = new Card(rank[i], suit, points[i]);
                deck.add(added);
            }
        }
        cardsLeft = deck.size();
        this.shuffle();
    }

    // Check if deck is empty
    public boolean isEmpty() {
        if (cardsLeft == 0) {
            return true;
        }
        return false;
    }

    // Getter for cards left
    public int getCardsLeft() {
        return cardsLeft;
    }

    // Dealing function
    public Card deal() {
        if (isEmpty()) {
            return null;
        }
        cardsLeft--;
        return deck.get(cardsLeft);
    }

    public void shuffle() {
        int i = deck.size()-1;
        while (i != 0) {
            int r = (int) (Math.random() * i);
            Card swapped = deck.get(r);
            deck.set(deck.indexOf(swapped), deck.get(i));
            deck.set(i, swapped);
            i-= 1;
        }
        cardsLeft = deck.size();
    }

}
