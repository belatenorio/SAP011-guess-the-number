import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Random;

public class GuessTheNumberGameTest {
    @Mock
    Random random;
    @Mock
    Random computerGuess;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test //equal it for Jest
    @DisplayName("Should return false because the player's guess is higher than the target number")
    //describe JavaScript
    public void shouldReturnFalseBecauseTooHighNumber() {
        Mockito.when(computerGuess.nextInt(100)).thenReturn(50);
        Player computerPlayer = new ComputerPlayer(computerGuess);
        computerPlayer.setName("Computer");
        Mockito.when(random.nextInt(100)).thenReturn(10);
        GuessTheNumberGame game = new GuessTheNumberGame(random);
        Boolean result = game.checkGuess(computerPlayer);

        Assertions.assertEquals(false, result);
    }

    @Test
    @DisplayName("Should return false because the player's guess is less than the target number")
    public void shouldReturnFalseBecauseTooLowNumber() {
        Mockito.when(computerGuess.nextInt(100)).thenReturn(10);
        Player computerPlayer = new ComputerPlayer(computerGuess);
        computerPlayer.setName("Computer");
        Mockito.when(random.nextInt(100)).thenReturn(50);
        GuessTheNumberGame game = new GuessTheNumberGame(random);
        Boolean result = game.checkGuess(computerPlayer);

        Assertions.assertEquals(false, result);
    }

    @Test
    @DisplayName("Should return true because the player's guess is equal the target number")
    public void mustReturnTrueBecauseTheGuessEqualsTheTargetNumber() {
        Mockito.when(computerGuess.nextInt(100)).thenReturn(50);
        Player computerPlayer = new ComputerPlayer(computerGuess);
        computerPlayer.setName("Computer");
        Mockito.when(random.nextInt(100)).thenReturn(50);
        GuessTheNumberGame game = new GuessTheNumberGame(random);
        Boolean result = game.checkGuess(computerPlayer);

        Assertions.assertEquals(true, result);
    }
}

//teste para quantidade de vezes de jogada