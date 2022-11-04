package tests;

import Base.TestBase;
import categories.ReleaseTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ScrollToTest extends TestBase {

  @Test
  public void scrollTest() {
    getDriver().get(BASE_URL + "tabulka.php");
    WebElement lastRow = getDriver().findElement(By.xpath("//table//tbody//tr[last()]"));
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    js.executeScript("arguments[0].scrollIntoView()", lastRow);
  }

  @Category(ReleaseTest.class)
  @Test
  public void scrollToSpecificRow() {
    getDriver().get(BASE_URL + "tabulka.php");
    WebElement lastRow = getDriver().findElement(By.xpath("//table//tbody//tr[5]"));
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    // argument in scrollIntoView set to true - top alignment - found element on top of page
    js.executeScript("arguments[0].scrollIntoView(true)", lastRow);
  }
}
