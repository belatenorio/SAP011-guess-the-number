import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    private String name;
    private List<Integer> guesses;

    public Player() {
        guesses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getGuesses() {
        return guesses;
    }

    public abstract int makeGuess();
}