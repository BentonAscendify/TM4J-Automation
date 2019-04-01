package webui.model.Ascendify.app.tabs.people;

import com.thoughtworks.selenium.webdriven.commands.SelectOption;
import org.apache.hadoop.hive.common.classification.InterfaceAudience;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.joda.time.Seconds;
import org.openqa.selenium.*;
import org.openqa.selenium.browserlaunchers.locators.GoogleChromeLocator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.ActionChainExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webui.model.Ascendify.Ascendify;
import webui.model.Ascendify.AscendifyElements;
import webui.model.Ascendify.app.tabs.people.People;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import java.util.List;
import webui.model.Ascendify.Ascendify;

public class People {

    public People clickPeople() {
        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"TODO\"]/i")).click();
        return this;
    }


   public People addObject() {
    Ascendify.getDriver().findElement(By.id("asc-objective")).click();
    return this;
   }

   public People addDescription() {
        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"asc_blurb\"]")).sendKeys("Hiral Selenium test");
        return this;
   }




















}

  //  @FindBy(css = AscendifyElements.requisition_chevronarrow)
  //  public WebElement requisitionchevron;