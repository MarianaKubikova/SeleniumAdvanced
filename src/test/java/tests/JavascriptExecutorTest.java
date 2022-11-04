package tests;

import java.util.List;

import Base.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavascriptExecutorTest extends TestBase {

  @Test
  public void testHighlight() {
    getDriver().get(BASE_URL + "/tabulka.php");
    List<WebElement> rows = getDriver().findElements(By.xpath("//table//tbody//tr"));

    for (WebElement row : rows) {
      if (row.getText().contains("Florian")) {
        hightLight(row);
      }
    }
  }

  private void hightLight(WebElement row) {
    ((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border = '3px solid red'", row);
  }
}
