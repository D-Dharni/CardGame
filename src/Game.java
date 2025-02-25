import java.util.Scanner;
import java.util.ArrayList;

// Deven Dharni

public class Game {
    // Players
    private Player player1;
    private Player dealer;

    // Deck
    private Deck deck;

    // All attributes for cards
    private final String[] suit = {"Spades", "Hearts", "Diamonds", "Clubs"};
    private final String[] rank = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "Jack", "Queen", "King"};
    private final int[] points = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10};

    private boolean continueToDealer;

    // State of game
    private String state = "instructions";

    // Window object
    private GameViewer window;
    private int sum;
    private int sumDealer;
    private boolean continueGame;

    public Game() {
        // Set window
        window = new GameViewer(this);

        // Setting player 1
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name to begin:");
        String namePlayer1 = input.nextLine();

        // Initialize players
        this.player1 = new Player(namePlayer1);
        this.dealer = new Player("Dealer");

        // Initialize deck
        deck = new Deck(rank, suit, points);

        continueToDealer = true;
        continueGame = true;

        state = "game";
        this.sum = 0;
        this.sumDealer = 0;
    }
    // Play Game Function
    public void playGame() {
        Scanner input = new Scanner(System.in);
        String decision = "";


        while (continueGame)
        {
            // Reset variables
            player1.resetHand();
            dealer.resetHand();
            continueToDealer = true;
            deck.shuffle();
            sum = 0;
            sumDealer = 0;

            // Player's turn
            while (sum < 22) {
                System.out.println(player1.getName() + " do you want to hit (h) or stay (s) if you want to quit" +
                        " playing say exit (e)");
                decision = input.nextLine();
                // If they hit
                if (decision.equals("h")) {
                    // Add a card to their thing
                    player1.addCard(deck.deal());
                    // Print out hand for them
                    sum = sum(player1.getHand());
                    System.out.println("Here is the sum of your hand: \n" + sum + "\n");
                    // Change state and update screen
                    state = "game";
                    checkWin(sum, 0);
                    window.repaint();
                }
                // If they stay change the turn
                else if (decision.equals("s")) {
                    window.repaint();
                    break;
                }
                // Exit if they want to
                else if (decision.equals("e")){
                    continueToDealer = false;
                    continueGame = false;
                    break;
                }
            }

            // Print out change in turn
            if ((continueGame) && (continueToDealer)) {
                System.out.println("Dealer's turn");
            }
            // Dealers hand
            if (continueToDealer) {
                // Run while below 18
                while(sum(dealer.getHand()) < 18) {
                    // Add card and get hand
                    dealer.addCard(deck.deal());
                    sumDealer = sum(dealer.getHand());
                    // Print
                    System.out.println("Dealer's sum: " + sumDealer + "\n");
                    checkWin(sumDealer, 1);
                }
            }

            if (continueGame) {
                // Find out who won
                findWinner(sum, sumDealer);
            }
        }
    }

    public void checkWin (int sum, int type) {
        if (type == 1) {
            // Check if blackjack
            if (sum == 21) {
                state = "dealer";
                window.repaint();
                System.out.println("Blackjack! You lost");
            }
            // If over 21
            if (sum > 21 ) {
                state = "player";
                window.repaint();
                System.out.println("Dealer busted. You won!");
            }
        }
        else {
            // Check if bust or blackjack
            if (sum == 21) {
                state = "player";
                window.repaint();
                System.out.println("Blackjack! You won");
                continueToDealer = false;

                // Reset
                player1.resetHand();
                dealer.resetHand();
            }
            // Check if over
            else if (sum > 21) {
                state = "dealer";
                window.repaint();
                System.out.println("You busted");
                continueToDealer = false;
            }
        }
    }

    public int getSum() {
        return sum;
    }

    public String getState() {
        return state;
    }

    public void findWinner (int sum, int sumDealer) {
        // If player won
        if (sum > sumDealer && sum < 22) {
            state = "player";
            window.repaint();
            System.out.println("You won!");
        }
        // If dealer won
        else if (sum < sumDealer && sumDealer < 22) {
            state = "dealer";
            window.repaint();
            System.out.println("You lost!");
        }
        // If tie
        else if (sum == sumDealer && sumDealer<21){
            state = "tie";
            window.repaint();
            System.out.println("You tied!");
        }
    }

    public int sum (ArrayList<Card> arr) {
        // Variable to return and for getting array of points
        int sum = 0;
        int[] arrOfValues = new int[arr.size()];
        // Add points to array of points
        for (int i = 0; i < arr.size(); i++) {
            arrOfValues[i] = arr.get(i).getValue();
        }
        // Add points to the sum
        for (int number: arrOfValues) {
            sum += number;
        }
        // Return the value
        return sum;
    }

    public Player getPlayer1() {
        return player1;
    }

    // Main Function
    public static void main(String[] args) {
        // New game class
        Game play = new Game();

        // Run
        play.playGame();

    }
}

