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
    public final Image[] images = {new ImageIcon("Resources/GameBackdrop.png").getImage(), new ImageIcon("Resources/InstructionsBackdrop.png").getImage()};

    public GameViewer(Game game) {
        // game = game
        this.game = game;

        // set up window like normal
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("BlackJack");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public void paint(Graphics g) {

        // if instructions
        if (game.state.equals("instructions")) {
            g.drawImage(images[1], 0, 0, 1500, 844, this);
            paintInstructions(g);
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

    }

}
