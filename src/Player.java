import java.util.ArrayList;

public class Player {
    // Instance Variables
    private String name;
    private ArrayList<Card> hand = new ArrayList<Card>();
    private int points;


    // Constructors
    public Player(String name) {
        this.name = name;
        this.points = 0;
    }

    public Player(String name, ArrayList<Card> hand) {
        this.name = name;
        this.hand = hand;
        this.points = 0;
    }


    // Getter Methods
    public String getName() {
        return name;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public int getPoints() {
        return points;
    }

    // Adding Points
    public void addPoints(int points) {
        this.points += points;
    }

    public void addCard(Card card) {
        this.hand.add(card);
    }

    public void resetHand() {
        hand.clear();
    }
    // toString Method
    public String toString() {
        return this.name + " has " + this.points + "\n" + this.name + "'s cards: " + this.hand;
    }

}
