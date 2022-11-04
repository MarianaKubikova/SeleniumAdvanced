package tests;

import java.time.Duration;

import Base.TestBase;
import categories.ReleaseTest;
import categories.SmokeTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InceptionTest extends TestBase {

  @Test
  @Category({SmokeTest.class, ReleaseTest.class})
  public void deeperTest() {
    getDriver().get(BASE_URL + "inception.php");
    String parentWindow = getDriver().getWindowHandle();
    getDriver().findElement(By.id("letsGoDeeper")).click();

    new WebDriverWait(getDriver(), Duration.ofSeconds(10)).
        until(ExpectedConditions.numberOfWindowsToBe(2));

    for (String windowHandle : getDriver().getWindowHandles()) {
      getDriver().switchTo().window(windowHandle);
    }

    getDriver().findElement(By.xpath("//input[1]")).sendKeys("adam sangala");
    getDriver().close();

    getDriver().switchTo().window(parentWindow);
  }
}
