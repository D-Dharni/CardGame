import java.util.Scanner;


public class Game {
    private Player player1;
    private Player player2;
    private Deck deck;
    public Game() {
        // Setting player 1
        Scanner input = new Scanner(System.in);
        System.out.println("What is the first player's name?");
        String namePlayer1 = input.nextLine();
        // Setting player 2
        System.out.println("What is the second player's name?");
        String namePlayer2 = input.nextLine();
        // Initialize players
        this.player1 = new Player(namePlayer1);
        this.player2 = new Player(namePlayer2);
        // Make arrays for deck
        String[] suit = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] rank = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "Jack", "Queen", "King"};
        int[] points = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10};
        // Initialize deck
        this.deck = new Deck(rank, suit, points);
    }
    // Instructions
    public void printInstructions() {
        System.out.println("Blackjack is a card game where the goal is to have a hand value closer to 21 than the " +
                "dealer without exceeding 21. Players are dealt two cards and can \"hit\" to take additional " +
                "cards or \"stand\" to keep their current total, aiming to maximize their score without going over. " +
                "Cards 2-10 are worth their face value, face cards count as 10, and Aces count as 1.");
    }
    // Play Game Function
    public void playGame() {

    }

    // Main Function
    public static void main(String[] args) {

    }
}

