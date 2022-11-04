package tests;

import java.time.Duration;

import Base.TestBase;
import categories.SmokeTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BlurTest extends TestBase {

  @Category(SmokeTest.class)
  @Test
  public void testBlur() {
    getDriver().get(BASE_URL + "waitforit.php");
    getDriver().findElement(By.id("waitForBlur")).sendKeys("brano ma nohy");
    ((JavascriptExecutor) getDriver()).executeScript("arguments[0].blur()", getDriver().findElement(By.id("waitForBlur")));
    new WebDriverWait(getDriver(), Duration.ofSeconds(10)).
        until(ExpectedConditions.attributeToBe(getDriver().findElement(By.id("waitForBlur")), "value", "blured!"));
  }

  @Test
  public void testClick() {
    getDriver().get(BASE_URL + "waitforit.php");
    ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click()", getDriver().findElement(By.id("startWaitForText")));
  }
}
