// Deven Dharni

// Card class that will take care of its ranks, suit, and value

public class Card {
    // Instance Variables
    private String rank;
    private String suit;
    private int value;

    // Constructor
    public Card(String rank, String suit, int value) {
        this.rank = rank;
        this.suit = suit;
        this.value = value;
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


    // To String Function
    public String toString()
    {
        return this.rank + " of " + this.suit;
    }
}
