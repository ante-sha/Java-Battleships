package game;
import player.*;
import java.util.Scanner;


public class GamePlan {
    private Player player1;
    private Player player2;

    public GamePlan() {
    }
    public void playGame() {
        this.player1 = new Player();
        this.player2 = new Player();
        player1.setName(enterName(1));
        System.out.println("Hello " + player1.getName());
    }

    private String enterName(int playerNumber) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player " + playerNumber + ", choose your name");
        return scanner.nextLine();
    }
}