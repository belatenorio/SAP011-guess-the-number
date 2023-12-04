
import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    //Random class
    Random random;
    int targetNumber;

    public GuessTheNumberGame(Random random) {
        this.random = random;
        this.targetNumber = random.nextInt(100) + 1;
    }

    public static void main(String[] args) {

        GuessTheNumberGame game = new GuessTheNumberGame(new Random());

        Player human = new HumanPlayer();

        Player computer = new ComputerPlayer(new Random());
        computer.setName("Computer");

        System.out.println("Welcome to Guess the Number! Let's go guess!\n");
        System.out.println("Human player, please, write your name: ");

        //Scanner class
        Scanner scanner = new Scanner(System.in);

        String playerName = scanner.nextLine();
        human.setName(playerName);

        System.out.println("The number was drawn from 1 to 100. There are 10 rounds. Try to get it right.\n");
        System.out.println("The computer is your opponent.");

        int attempts = 10;
        int i;

        for (i = 0; i < 10; i++) {

            boolean humanWins = game.checkGuess(human);

            if (humanWins) {
                break;
            }
            boolean computerWins = game.checkGuess(computer);

            if (computerWins) {
                break;
            }
        }
        if (i == attempts) {
            System.out.println("\nYou have exhausted 10 attempts.");
            System.out.println("The number was " + game.targetNumber);
        }

    }

    public boolean checkGuess(Player player) {

        System.out.println("\n" + player.getName() + ", enter your guess:");

        int guess = player.makeGuess();

        if (guess > this.targetNumber) {
            System.out.println("Too high!");
            return false;
        } else if (guess < this.targetNumber) {
            System.out.println("Too low!");
            return false;
        } else {
            System.out.println("Congratulations! " + player.getName() + ". You guessed the number.");
            System.out.println("Attempts: " + player.getGuesses());
            return true;
        }
    }
}