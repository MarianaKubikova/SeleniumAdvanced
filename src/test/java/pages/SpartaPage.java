package pages;

import java.time.Duration;

import Base.TestBase;
import Base.WebDriverSingleton;
import models.Sin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SpartaPage extends TestBase {

  private WebDriver driver;

  private static final String PAGE_URL = "sparta.php";

  public SpartaPage() {
    driver = WebDriverSingleton.getWebDriverInstance();
    PageFactory.initElements(driver, this);
  }
  public void openSpartaPage(){
    driver.get(BASE_URL + PAGE_URL);
  }
  public WebElement getMainSinElement(Sin sin){
    return driver.findElement(By.xpath("//article[p[text()='"+sin.getMessage()+"']]"));
  }
  public void forgiveSin(Sin evaSin){
    WebElement window = getMainSinElement(evaSin);
    window.findElement(By.cssSelector("button")).click();

    new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.id("confirm")));
    driver.findElement(By.id("confirm")).click();

    evaSin.setForgiven(true);
  }
}
