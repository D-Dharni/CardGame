// Deven Dharni

// Card class that will take care of its ranks, suit, and value

//What data does the back-end manage? What data is shared with the front-end?
//How is everything constructed and initialized — and in what order? Why did you choose to initialize everything in that order?
//How do the back-end and front-end interact?


import java.awt.*;

public class Card {
    // Instance Variables
    private String rank;
    private String suit;
    private int value;
    private Image image;

    // Constructor
    public Card(String rank, String suit, int value, Image image) {
        this.rank = rank;
        this.suit = suit;
        this.value = value;
        this.image = image;
    }

    // Getter Methods
    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }


    // Setter Methods
    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Image getImage() {
        return image;
    }

    // To String Function
    public String toString()
    {
        return this.rank + " of " + this.suit;
    }
}
