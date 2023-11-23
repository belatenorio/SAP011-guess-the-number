
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

        System.out.println("Let's go guess!");
        System.out.println("Human player, please, write your name: ");

        //Scanner class
        Scanner scanner = new Scanner(System.in);

        String playerName = scanner.nextLine();
        human.setName(playerName);

        System.out.println("A number is chosen " + "between 1 to 100. " + "Guess the number " + "within 10 trials.");

        int trials = 10;
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
        if (i == trials) {
            System.out.println("You have exhausted" + " 10 trials.");
            System.out.println("The number was " + game.targetNumber);
        }

    }

    public boolean checkGuess(Player player) {

        System.out.println(player.getName() + ", enter your guess:");

        int guess = player.makeGuess();

        if (guess > this.targetNumber) {
            System.out.println("Too high!");
            return false;
        } else if (guess < this.targetNumber) {
            System.out.println("Too low!");
            return false;
        } else {
            System.out.println("Congratulations! " + player.getName() + ". You guessed the number.");
            //colocar o array de suposições
            return true;
        }
    }
}