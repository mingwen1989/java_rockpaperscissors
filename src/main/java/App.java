import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (req, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/results", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/results.vtl");

      String player1 = request.queryParams("Player1");
      String player2 = request.queryParams("Player2");
      String humanPlayer = request.queryParams("HumanPlayer");

      Game newGame = new Game();

      if(player1 instanceof String && player2 instanceof String) {
        String results = newGame.runGame(player1, player2);

        model.put("results", results);
        model.put("player1", player1);
        model.put("player2", player2);
      } else if (humanPlayer instanceof String) {
        String results = newGame.runComputerGame(humanPlayer);

        model.put("results", results);
        model.put("humanPlayer", humanPlayer);
      }

      return new ModelAndView(model, layout);
     }, new VelocityTemplateEngine());
}
}
