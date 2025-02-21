import javax.swing.*;
import java.awt.*;

// Deven Dharni

public class GameViewer extends JFrame {
    // Make variables for window
    private final int WINDOW_WIDTH = 1500;
    private final int WINDOW_HEIGHT = 844;

    // Game object
    private Game game;

    // Image arraylist for images used
    private Image[] images;

    public Image[] getImages() {
        return images;
    }

    public GameViewer(Game game) {
        // game = game
        this.game = game;

        // set up images list
        this.images = new Image[2];
        images[0] = new ImageIcon("Resources/GameBackdrop.png").getImage();
        images[1] = new ImageIcon("Resources/InstructionsBackdrop.png").getImage();

        // set up window like normal
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("BlackJack");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);


    }

    public void paint(Graphics g) {

        // if instructions
        if (game.getState().equals("instructions")) {
            g.drawImage(images[1], 0, 0, 1500, 844, this);
            paintInstructions(g);
        }
        else if (game.getState().equals("game")) {
            g.drawImage(images[0], 0, 0, 1500, 844, this);
            paintGame(g);
        }
        else {
            g.drawImage(images[0], 0, 0, 1500, 844, this);
            paintWinning(g);
        }
    }

    public void paintInstructions (Graphics g) {
        // set fonts
        g.setFont(new Font("Arial", Font.BOLD, 50));
        g.setColor(Color.WHITE);


        // Print the instructions
        g.drawString ("Instructions:", 100, 200);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("Blackjack is a card game where the goal is to have a hand value ", 100, 300);
        g.drawString("closer to 21 than the dealer without exceeding 21. ", 100, 350);
        g.drawString("Players are dealt two cards and can hit to take additional cards or ", 100, 400);
        g.drawString("stand to keep their current total aiming to ", 100, 450);
        g.drawString("maximize their score without going over. ", 100, 500);
        g.drawString("Cards 2-10 are worth their face value,", 100, 550);
        g.drawString("face cards count as 10 and Aces count as 1.", 100, 600);
        g.setFont(new Font("Arial", Font.BOLD, 48));
        g.drawString("Enter Your Name To Begin....", 100, 700);
    }

    public void paintGame (Graphics g) {
        g.drawImage(game.getPlayer1().getLastCard().getImage(), 625, 500, 150, 225, this);
        g.drawImage(new ImageIcon("Resources/DealerImage.png").getImage(), 600, 50, 200, 300, this);
        g.drawImage(new ImageIcon("Resources/DeckofCards.png").getImage(), 1100, 333, 300, 330, this);
        String sumOfCards = "Sum of hand: " + game.getSum();
        g.setFont(new Font("Georgia", Font.BOLD, 48));
        g.drawString(sumOfCards, 100, 420);
    }

    public void paintWinning (Graphics g) {
        if (game.getState().equals("player")) {
            g.drawImage(new ImageIcon("Resources/Won.png").getImage(), 200, 100, 950, 700, this);
        }
        else if(game.getState().equals("dealer")) {
            g.drawImage(new ImageIcon("Resources/Lost.png").getImage(), 200, 100, 950, 700, this);
        }
        else {
            g.drawImage(new ImageIcon("Resources/Tie.png").getImage(), 0, 0, 1500, 844, this);
        }
    }
}
