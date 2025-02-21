import javax.swing.*;
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
        // For the png
        int increment = 1;
        // For the value
        int point = 0;
        // Loop through ranks then suits
        for (String ranks: rank) {
            for (int i = 0; i < suits.length; i++) {
                // Put the string
                String fileName = "Resources/Cards/";
                // Make the card
                Card added = new Card(ranks, suits[i], points[point], new ImageIcon(fileName + increment + ".png").getImage());
                // Add to the deck increment the png
                deck.add(added);
                increment += 1;
            }
            // Increment the point
            point += 1;
        }
        // Shuffle the deck
        this.shuffle();
        // Initialize the card size
        cardsLeft = deck.size();
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
