import org.fluentlenium.adapter.FluentTest;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Let's Play Rock, Paper, Scissors");
  }

  @Test
  public void runGameWinOne() {
    goTo("http://localhost:4567/");
    click("option", withText("rock"));
    click("option", withText("scissors"));
    submit("#button");

    assertThat(pageSource().contains("Player One Wins"));
  }

  @Test
  public void runGameWinTwo() {
    goTo("http://localhost:4567/");
    click("option", withText("scissors"));
    click("option", withText("rock"));
    submit("#button");

    assertThat(pageSource().contains("Player Two Wins"));
  }

  @Test
  public void runGameTie() {
    goTo("http://localhost:4567/");
    click("option", withText("rock"));
    click("option", withText("rock"));
    submit("#button");

    assertThat(pageSource().contains("this round is a tie"));
  }
}
