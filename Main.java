
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = scanner.nextLine();

        Player player = new Player(name);
        Yahtzee game = new Yahtzee(player);
        System.out.println("Welcome to Yahtzee, " + player.getName() + "!");

        while (true) {
            System.out.println("Press 'enter' to roll the dice or type 'quit' to exit.");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("quit")) {
                break;
            }

            game.playTurn();
        }

        System.out.println("Thanks for playing, " + player.getName() + "! Your final score is: " + player.getScore());
    }
}
