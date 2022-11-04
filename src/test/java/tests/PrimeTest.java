package tests;

import java.io.IOException;
import java.time.Duration;

import Base.TestBase;
import helpers.ExcelReader;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrimeTest extends TestBase {

  private static final String TEST_DATA_PATH = "src/test/resources/data.xlsx";
  private static final String SHEET = "prime";

  @Test
  public void testPrime() throws IOException {
    getDriver().get(BASE_URL + "primenumber.php");
    WebElement number = getDriver().findElement(By.xpath("//input[@type='number']"));
    WebElement button = getDriver().findElement(By.className("btn-default"));
    ExcelReader excelReader = new ExcelReader(TEST_DATA_PATH);
    Sheet sheet = excelReader.getSheetByName(SHEET);
    for (Row cells : sheet) {
      if (cells.getRowNum() == 0) {
        continue;
      }
      int numberFromCell = (int) cells.getCell(0).getNumericCellValue();
      boolean expectedPrime = cells.getCell(1).getBooleanCellValue();

      number.clear();
      number.sendKeys(String.valueOf(numberFromCell));
      button.click();

      verifyResult(expectedPrime);
    }
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
