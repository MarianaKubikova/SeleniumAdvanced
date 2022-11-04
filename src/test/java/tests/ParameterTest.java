package tests;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import Base.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Parameterized.class)
public class ParameterTest extends TestBase {

  int numberFromCell;
  boolean expectedPrime;

  public ParameterTest(int numberFromCell, boolean expectedPrime) {
    this.numberFromCell = numberFromCell;
    this.expectedPrime = expectedPrime;
  }

  //  @Parameterized.Parameters
  //  public static List<Integer> getData(){
  //    return Arrays.asList(1,2,3,4,56,67);
  //  }

  @Parameterized.Parameters
  public static List<Object[]> getData() {
    return Arrays.asList(new Object[][]{{1, true}, {2, true}, {8, false}});
  }

  @Test
  public void optimusParameterTest() {
    getDriver().get(BASE_URL + "primenumber.php");
    WebElement number = getDriver().findElement(By.xpath("//input[@type='number']"));
    WebElement button = getDriver().findElement(By.className("btn-default"));

    number.clear();
    number.sendKeys(String.valueOf(numberFromCell));
    button.click();

    verifyResult(expectedPrime);
  }

  private void verifyResult(boolean expectedPrime) {
    if (expectedPrime) {
      new WebDriverWait(getDriver(), Duration.ofSeconds(5)).
          until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Optimus approves']")));
    } else
      new WebDriverWait(getDriver(), Duration.ofSeconds(5)).
          until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Optimus is sad']")));
  }
}

