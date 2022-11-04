package pages;

import static Base.TestBase.BASE_URL;

import java.time.Duration;
import java.util.List;

import Base.WebDriverSingleton;
import enumerators.SinType;
import models.Sin;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SinCityPage {

  private WebDriver driver;

  private static final String PAGE_URL = "sincity.php";

  @FindBy(name = "title")
  private WebElement titleInput;

  @FindBy(name = "author")
  private WebElement authorInput;

  @FindBy(name = "message")
  private WebElement messageInput;

  @FindBy(xpath = "//button[@type='submit']")
  private WebElement confessButton;

  @FindBy(css = "div.sinsListArea")
  private WebElement sinArea;


  public SinCityPage() {
    driver = WebDriverSingleton.getWebDriverInstance();
    PageFactory.initElements(driver, this);
  }
  public void openSinPage(){
    driver.get(BASE_URL + PAGE_URL );
  }

  public void fillSinInformation(Sin sin) {
    titleInput.sendKeys(sin.getTitle());
    authorInput.sendKeys(sin.getAuthor());
    messageInput.sendKeys(sin.getMessage());
  }

  public void markTag(List<SinType> tags) {
    for (SinType tag : tags) {
      driver.findElement(By.xpath("//input[@value='" + tag.getXpathValue() + "']")).click();
    }
  }

  public void confessSin(){
    confessButton.click();
  }

  public void checkSinStatus(Sin spiderSin) {
    WebElement sins = getSinFromListElement(spiderSin);
    String status = sins.findElement(By.cssSelector("p")).getText().trim();

    if (spiderSin.isForgiven()){
      Assert.assertEquals("forgiven", status);
    } else
      Assert.assertEquals("pending", status);
  }

  private WebElement getSinFromListElement(Sin spiderSin) {
    WebElement listOfSins = driver.findElement(By.cssSelector("ul.list-of-sins"));
    WebElement sins = listOfSins.
        findElement(By.xpath("./li[contains(text(),'"+ spiderSin.getTitle()+"')]"));
    return sins;
  }

  public void openDetails(Sin spiderSin) {
    getSinFromListElement(spiderSin).click();
  }

  public void checkDetails(Sin spiderSin){
    WebElement sinDetail = driver.findElement(By.cssSelector("div.detail"));
    new WebDriverWait(driver, Duration.ofSeconds(10)).
        until(ExpectedConditions.textToBePresentInElement(sinDetail.findElement(By.cssSelector("p")),spiderSin.getMessage()));
    String actualTitle = sinDetail.findElement(By.cssSelector("h4")).getText();

    Assert.assertTrue(actualTitle.contains(spiderSin.getTitle()));
    Assert.assertTrue(actualTitle.contains(spiderSin.getAuthor()));
  }
}
