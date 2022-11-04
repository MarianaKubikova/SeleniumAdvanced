package tests;

import java.util.ArrayList;
import java.util.List;

import Base.TestBase;
import enumerators.SinType;
import models.Sin;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import pages.SinCityPage;
import pages.SpartaPage;

public class SinCityTest extends TestBase {

  @Test
  public void newSinTest() {
    //getDriver().manage().window().setSize(new Dimension(300, 400));
    SinCityPage sinCityPage = new SinCityPage();
    Sin spiderSin = new Sin("zabil som pavuka", "furby", "zabil som ho lopatou");
    //spiderSin.setTitle("zabil som dvoch pavukov");
    List<SinType> spiderTags = new ArrayList<SinType>();
    spiderTags.add(SinType.MURDER);
    spiderTags.add(SinType.ROBBERY);
    spiderSin.setTags(spiderTags);

    sinCityPage.openSinPage();
    sinCityPage.fillSinInformation(spiderSin);
    sinCityPage.markTag(spiderSin.getTags());
    sinCityPage.confessSin();
    sinCityPage.openDetails(spiderSin);
    sinCityPage.checkSinStatus(spiderSin);
    sinCityPage.openDetails(spiderSin);
    sinCityPage.checkDetails(spiderSin);
  }

  @Test
  public void testForgive(){
    Sin evaSin = new Sin("spievam", "eva.m", "spievam stale");
    SinCityPage sinCityPage = new SinCityPage();

    sinCityPage.openSinPage();
    sinCityPage.fillSinInformation(evaSin);
    sinCityPage.confessSin();

    SpartaPage spartaPage = new SpartaPage();
    spartaPage.openSpartaPage();
    spartaPage.forgiveSin(evaSin);

    sinCityPage.openSinPage();
    sinCityPage.checkSinStatus(evaSin);
  }
}
