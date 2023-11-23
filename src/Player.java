
public abstract class Player {
    private String name;
    private int[] guesses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getGuesses() {
        return guesses;
    }

    public abstract int makeGuess();
}
//usar método construtor