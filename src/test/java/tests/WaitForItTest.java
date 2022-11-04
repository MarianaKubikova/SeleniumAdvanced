package tests;

import java.time.Duration;

import Base.TestBase;
import categories.RegressionTest;
import com.google.code.tempusfugit.concurrency.ConcurrentTestRunner;
import org.junit.Assert;
import org.junit.ComparisonFailure;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(ConcurrentTestRunner.class)
public class WaitForItTest extends TestBase {

  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  @Test
  public void waitForInputText() {
    getDriver().get(BASE_URL + "waitforit.php");
    getDriver().findElement(By.id("startWaitForText")).click();
    new WebDriverWait(getDriver(), Duration.ofSeconds(10)).
        until(ExpectedConditions.attributeToBe(By.id("waitForTextInput"), "value", "dary !!!"));

    System.out.println(getDriver().findElement(By.id("waitForTextInput")).getAttribute("value"));
  }

  @Test
  public void waitForClass() {
    getDriver().get(BASE_URL + "waitforit.php");
    getDriver().findElement(By.id("startWaitForProperty")).click();
    new WebDriverWait(getDriver(), Duration.ofSeconds(10)).
        until(ExpectedConditions.attributeContains(By.id("waitForProperty"), "class", "error"));

    Assert.assertFalse(getDriver().findElement(By.id("startWaitForProperty")).isEnabled());
  }

  @Category(RegressionTest.class)
  @Test
  public void checkTitle() {
    getDriver().get(BASE_URL + "waitforit.php");
    expectedException.expect(ComparisonFailure.class);

    Assert.assertEquals("WAIT FOR IT !!", getDriver().findElement(By.xpath("//h1")).getText());
  }

  @Test
  @Ignore
  public void checkLegendary() {
    getDriver().get(BASE_URL + "waitforit.php");
    getDriver().findElement(By.id("startWaitForText")).click();

    Assert.assertEquals("dary !!!", getDriver().findElement(By.id("waitForTextInput")).getAttribute("value"));
  }
}
