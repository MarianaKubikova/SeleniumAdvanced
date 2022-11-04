package tests;

import java.time.Duration;

import Base.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForMinionsTest extends TestBase {

  @Test
  public void waitForMinions() {
    getDriver().get(BASE_URL + "minions.php");
    int numberOfMinions = 5;
    getDriver().findElement(By.xpath("//input[@type='number']")).sendKeys(String.valueOf(numberOfMinions));
    getDriver().findElement(By.xpath("//button[contains(@class, 'btn-warning')]")).click();

    new WebDriverWait(getDriver(), Duration.ofSeconds(10)).
        withMessage("Number of minions should be " + numberOfMinions).
        until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[@class='minions']//img"), numberOfMinions));

    Assert.assertEquals(numberOfMinions, getDriver().findElements(By.xpath("//div[@class='minions']//img")).size());
  }
}
