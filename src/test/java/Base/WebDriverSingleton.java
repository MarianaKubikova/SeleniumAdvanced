package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class WebDriverSingleton {

  private static WebDriver driver;

  private static void initialize() {
    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
    driver = new ChromeDriver();
    //initizalizePhantomJSDriver();
  }

  public static WebDriver getWebDriverInstance() {
    if (driver == null) {
      initialize();
    } return driver;
  }

  private static void initizalizePhantomJSDriver() {
    // headless browser
    System.setProperty("phantomjs.binary.path", "src/test/resources/drivers/phantomjs.exe");
    driver = new PhantomJSDriver();

  }
}
