package tests;

import Base.TestBase;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;

public class ThereAndBackAgainTest extends TestBase {

  private JavascriptExecutor js;

  @Test
  public void scrollTest() {
    getDriver().get(BASE_URL + "tabulka.php");
    js = (JavascriptExecutor) getDriver();
    for (int i = 0; i < 4; i++) {
      js.executeScript("window.scrollBy(0, 200)");
    }
  }

  @Test
  public void scrollToEndTest() {
    getDriver().get(BASE_URL + "tabulka.php");
    js = (JavascriptExecutor) getDriver();
    int max = Integer.parseInt(js.executeScript("return document.body.scrollHeight").toString());
    //long max1 = (long) js.executeScript("return document.body.scrollHeight");
    js.executeScript("window.scrollBy(0," + max + ")");
  }
}
