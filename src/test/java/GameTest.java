import org.junit.*;
import static org.junit.Assert.*;

public class GameTest {
  @Test
  public void GameTest_shouldCheckIfAWinnerExists_true() {
    Game testGame = new Game();
    boolean expected = testGame.checkIfWinnerOrTie("rock", "scissors");
    assertEquals(expected, true);
  }

  @Test
  public void GameTest_shouldCheckPlayType() {
    Game testGame = new Game();
    String expected = testGame.parseWinner("rock", "scissors");
    assertEquals(expected, "Player One Wins");
  }

  @Test
  public void GameTest_shouldCheckPlayTypePlayerTwo() {
    Game testGame = new Game();
    String expected = testGame.parseWinner("scissors", "rock");
    assertEquals(expected, "Player Two Wins");
  }

  @Test
  public void GameTest_shouldRunGameRoundsForTwoPlayers_String() {
    Game testGame = new Game();
    String expected = testGame.runGame("paper", "rock");
    assertEquals(expected, "Player One Wins");
  }

  @Test
  public void GameTest_shouldRunGameRoundsForTwoPlayers_CheckForTie_String() {
    Game testGame = new Game();
    String expected = testGame.runGame("paper", "paper");
    assertEquals(expected, "this round is a tie");
  }
}
