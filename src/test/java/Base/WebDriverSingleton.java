package Base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

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
//  private static void initializeSeleniumServer(){
//    URL url = null;
//    try {
//      url = new URL("http://localhost:4444/wd/hub");
//    } catch (MalformedURLException e) {
//      e.printStackTrace();
//    }
//    DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
//    driver = new RemoteWebDriver(url, desiredCapabilities);
//  }
}
