package src;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    //Random class
    Random random = new Random();
    int targetNumber = random.nextInt(100) + 1; // pesquisar método construtor

    public static void main(String[] args) {

        GuessTheNumberGame game = new GuessTheNumberGame();

        Player human = new HumanPlayer();

        Player computer = new ComputerPlayer();
        computer.setName("PC");

        //Scanner class
        Scanner scanner = new Scanner(System.in);

        System.out.println("Let's go guess!");
        System.out.println("Human player, please, write your name: ");

        String playerName = scanner.nextLine();
        human.setName(playerName);

        System.out.println("A number is chosen " + "between 1 to 100. " + " Guess the number " + "within 10 trials.");
        System.out.println("The number is: " + game.targetNumber);

        int trials = 5;
        int i;

        for (i = 0; i < 5; i++) {
            game.checkGuess(human);
        }
        if (i == trials) {
            System.out.println("You have exhausted" + " 5 trials.");
            //System.out.println("The number was " + game.targetNumber);
        }
    }

    public boolean checkGuess(Player player) {

        System.out.println(player.getName() + " enter your guess:");

        int guess = player.makeGuess();

        if (guess > this.targetNumber) {
            System.out.println("Too high!");
            return false;
        } else if (guess < this.targetNumber) {
            System.out.println("Too low!");
            return false;
        } else {
            System.out.println("Congratulations! " + player.getName() + " .You guessed the number.");
            return true;
        }
    }
}