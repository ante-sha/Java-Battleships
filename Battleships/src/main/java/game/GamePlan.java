package game;
import player.*;
import java.util.Scanner;


public class GamePlan {
    public GamePlan() {
    }

    public void playGame() {
        Player player1 = new Player();
        Player player2 = new Player();
        enterName();
    }

    private void enterName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player 1, choose your name");
        player1 = scanner.nextLine();
    }
}