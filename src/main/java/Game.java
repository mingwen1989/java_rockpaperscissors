import java.util.Map;
import java.util.HashMap;

public class Game {

  public static String runGame(String playerOneInput, String playerTwoInput) { String result = "";
    if(checkIfWinnerOrTie(playerOneInput, playerTwoInput)) {
      result = parseWinner(playerOneInput, playerTwoInput);
    } else if (!checkIfWinnerOrTie(playerOneInput, playerTwoInput)) {
      result = "this round is a tie";
    }

    return result;
  }
  public static String parseWinner(String playerOneInput, String playerTwoInput) {

    HashMap<String, String> playType = new HashMap<String, String>();
    playType.put("rock", "scissors");
    playType.put("paper", "rock");
    playType.put("scissors", "paper");

    String playerOne = playType.get(playerOneInput);
    String playerTwo = playType.get(playerTwoInput);
    String getWinner = "";
    String playerOneWinner = "Player One Wins";
    String playerTwoWinner = "Player Two Wins";
    if (playerOne.equals(playerTwoInput)) {
      getWinner = playerOneWinner;
    } else if (playerTwo.equals(playerOneInput)) {
      getWinner = playerTwoWinner;
    } else {};
    return getWinner;
  };

  public static boolean checkIfWinnerOrTie(String playerOneInput, String playerTwoInput) {
    boolean result = false;
    if(playerOneInput.equals(playerTwoInput)) {
      result = result;
    } else {
      result = true;
    }
    return result;
  }
}
