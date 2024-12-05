import java.util.Scanner;
import java.util.ArrayList;

public class Game {
    public static Player player1;
    public static Player dealer;
    public static Deck deck;
    public static String[] suit = {"Hearts", "Diamonds", "Clubs", "Spades"};
    public static String[] rank = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "Jack", "Queen", "King"};
    public static int[] points = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10};

    public Game() {
        // Setting player 1
        Scanner input = new Scanner(System.in);
        System.out.println("What's your name?");
        String namePlayer1 = input.nextLine();
        // Initialize players
        this.player1 = new Player(namePlayer1);
        this.dealer = new Player("Dealer");
        // Initialize deck
        deck = new Deck(rank, suit, points);
    }
    // Instructions
    public static void printInstructions() {
        System.out.println("Blackjack is a card game where the goal is to have a hand value closer to 21 than the " +
                "dealer without exceeding 21.\nPlayers are dealt two cards and can \"hit\" to take additional " +
                "cards or \"stand\" to keep their current total,\naiming to maximize their score without going over. " +
                "Cards 2-10 are worth their face value, face cards count as 10,\nand Aces count as 1.\n\n");
    }
    // Play Game Function
    public static void playGame() {
        // Variables for sums
        int playerSum = 0;
        int dealerSum = 0;
        Scanner input = new Scanner(System.in);
        String decision = "";
        boolean continueToDealer = true;
        boolean continueGame = true;
        int sumDealer = 0;
        int sum = 0;


        while (continueGame)
        {
            // Reset variables
            player1.resetHand();
            dealer.resetHand();
            continueToDealer = true;
            deck.shuffle();

            // player's turn
            while (playerSum < 22) {
                System.out.println(player1.getName() + " do you want to hit (h) or stay (s) if you want to quit" +
                        " playing say exit (e)");
                decision = input.nextLine();
                // if they hit
                if (decision.equals("h")) {
                    // add a card to their thing
                    player1.addCard(deck.deal());
                    // print out hand for them
                    sum = sum(player1.getHand());
                    System.out.println("Here is the sum of your hand: \n" + sum + "\n");

                    // check if bust or blackjack
                    if (sum == 21) {
                        System.out.println("Blackjack! You won");
                        continueToDealer = false;
                        break;
                    }
                    else if (sum > 21) {
                        System.out.println("You busted");
                        continueToDealer = false;
                        break;
                    }
                }
                // if they stay change the turn
                else if (decision.equals("s")) {
                    break;
                }
                // exit if they want to
                else if (decision.equals("e")){
                    continueToDealer = false;
                    continueGame = false;
                    break;
                }
            }

            // print out change in turn
            if (continueGame == true && continueToDealer == true) {
                System.out.println("Dealer's turn");
            }
            // dealers hand
            if (continueToDealer) {
                while(sum(dealer.getHand()) < 18) {
                    dealer.addCard(deck.deal());
                    sumDealer = sum(dealer.getHand());
                    System.out.println("Dealer's sum: " + sumDealer + "\n");
                    // check if blackjack
                    if (sumDealer == 21) {
                        System.out.println("Blackjack! You lost");
                        break;
                    }
                    // if over 21
                    if (sumDealer > 21 ) {
                        System.out.println("Dealer busted. You won!");
                        break;
                    }
                }
            }

            if (continueGame) {
                // find out who won
                if (sum > sumDealer && sum < 22) {
                    System.out.println("You won!");
                }
                else if (sum < sumDealer && sumDealer < 22) {
                    System.out.println("You lost!");
                }
                else if (sum == sumDealer || !(sum>21)){
                    System.out.println("You tied!");
                }
            }

        }
    }

    public static int sum (ArrayList<Card> arr) {
        // variable to return and for getting array of points
        int sum = 0;
        int[] arrOfValues = new int[arr.size()];
        // add points to array of points
        for (int i = 0; i < arr.size(); i++) {
            arrOfValues[i] = arr.get(i).getValue();
        }
        // add points to the sum
        for (int number: arrOfValues) {
            sum += number;
        }
        // return the value
        return sum;
    }

    // Main Function
    public static void main(String[] args) {
        // print the instructions
        printInstructions();
        // new game class
        Game play = new Game();
        playGame();

    }
}

