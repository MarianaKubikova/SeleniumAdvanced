package tests;

import java.time.Duration;

import Base.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrestigeTest extends TestBase {

  @Test
  public void prestigeTest() {
    getDriver().get(BASE_URL + "prestige.php");
    getDriver().findElement(By.cssSelector("div.hat img")).click();

    new WebDriverWait(getDriver(), Duration.ofSeconds(5)).
        until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.hat img")));
    new WebDriverWait(getDriver(), Duration.ofSeconds(5)).
        until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.hat img")));
  }
}
