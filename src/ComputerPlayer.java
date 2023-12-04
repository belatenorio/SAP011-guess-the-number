
import java.util.Random;

public class ComputerPlayer extends Player {

    Random random;
    int computerGuess;

    public ComputerPlayer(Random random) {
        this.random = random;
        this.computerGuess = random.nextInt(100) + 1;
        this.getGuesses().add(computerGuess);
    }

    @Override
    public int makeGuess() {
        System.out.println(computerGuess);
        return computerGuess;
    }
}