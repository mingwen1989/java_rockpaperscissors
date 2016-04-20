import java.util.Map;
import java.util.HashMap;
import java.util.Random;

public class Game {

  public static String runGame(String playerOneInput, String playerTwoInput) {
    String result = "";
    String playerOnePlay = playerOneInput.toLowerCase();
    String playerTwoPlay = playerTwoInput.toLowerCase();


    if(checkIfWinnerOrTie(playerOnePlay, playerTwoPlay)) {
      result = parseWinner(playerOnePlay, playerTwoPlay);
    } else if (!checkIfWinnerOrTie(playerOnePlay, playerTwoPlay)) {
      result = "this round is a tie";
    }


    System.out.println(playerOnePlay);
    System.out.println(result);
    return result;
  }

  public static String runComputerGame(String playerOneInput) {
    String computerChoice = computerChoose();

    String result = "";
    String playerOnePlay = playerOneInput.toLowerCase();

    if(checkIfWinnerOrTie(playerOnePlay, computerChoice)) {
      result = parseWinner(playerOnePlay, computerChoice);
    } else if (!checkIfWinnerOrTie(playerOnePlay, computerChoice)) {
      result = "this round is a tie";
    }

    System.out.println(playerOnePlay);
    System.out.println(result);
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

  public static String computerChoose() {
    Random turnGenerator = new Random();
    Integer computerTurn = turnGenerator.nextInt(4);
    if (computerTurn < 1) {
      return "rock";
    }
    if (computerTurn < 2 && computerTurn > 1) {
      return "paper";
    }
    if (computerTurn < 3 && computerTurn > 2) {
      return "scissors";
    }
      return "rock";
  }
}
