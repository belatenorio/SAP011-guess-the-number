
import java.util.Scanner;

public class HumanPlayer extends Player {
    Scanner scanner = new Scanner(System.in);

    @Override
    public int makeGuess() {
        //int humanGuess = scanner.nextInt();
        //return humanGuess;
        return scanner.nextInt();
    }
}
