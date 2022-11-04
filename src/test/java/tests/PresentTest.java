package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.*;

import Base.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PresentTest extends TestBase {

  @Test
  public void basicTest(){
    getDriver().get(BASE_URL +"tabulka.php");
    List<WebElement> rows = getDriver().findElements(By.xpath("//table/tbody/tr"));
    List<String> vendelinovia = new ArrayList<>();
//    for (WebElement row : rows) {
//      if("Vendelin".equals(getName(row))){
//        vendelinovia.add(getSurname(row));
//      }
//    }
//    rows.stream().filter(element -> getName(element).equals("Vendelin")).
//        forEach(element -> System.out.println(getSurname(element)));
  //  System.out.println(vendelinovia);

    vendelinovia = rows.stream().filter(element -> getName(element).equals("Vendelin")).map(element -> getSurname(element)).
        collect(Collectors.toList());
    System.out.println(vendelinovia);

  }
  private String getName(WebElement element){
    return element.findElement(By.xpath("./td[2]")).getText();
  }
  private String getSurname(WebElement element){
    return element.findElement(By.xpath("./td[3]")).getText();
  }
}
