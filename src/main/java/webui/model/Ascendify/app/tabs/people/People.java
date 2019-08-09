package webui.model.Ascendify.app.tabs.people;

import com.gargoylesoftware.htmlunit.html.HtmlImageInput;
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
import java.util.concurrent.TimeUnit;

import webui.model.Ascendify.Ascendify;
import org.openqa.selenium.remote.RemoteWebElement;

import static webui.model.Ascendify.Ascendify.*;

public class People {



    public People clickPeople() {
        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"TODO\"]/i")).click();
        return this;
    }


    // public People addObject() {
    // waitForElementCss(AscendifyElements.people_addObject);

    // people_addObject.click();
    // return this;
    //}

    //public People addDescription() {

    // Ascendify.getDriver().findElement(By.xpath("//*[@id=\"asc_blurb\"]")).sendKeys("Hiral Selenium test");
    //return this;
    //}

    // public People Saveobject() throws InterruptedException {
    //  Ascendify.getDriver().findElement(By.xpath("//*[@id=\"asc-dynamic-save-button\"]")).click();
    //  Thread.sleep(5000);
    //return this;
    //}

    // public People addSummary() {

    //Ascendify.getDriver().findElement(By.xpath("//*[@id=\"asc-summary\"]/div[1]/button")).click();
    //return this;
    //}

    //public People addSummarydescription() {
    //  Ascendify.getDriver().findElement(By.id("asc-summary")).sendKeys("Hiral selenium test");
    //return this;
    //}

    //public People saveSummary() {
    //  Ascendify.getDriver().findElement(By.id("//*[@id=\"asc-dynamic-save-button\"]")).click();
    // return this;
    //}

    //public People addExperience() {
    //  Ascendify.getDriver().findElement(By.id("asc-add-exp")).click();
    // return this;
    //}

    // public People addObject() {
    // waitForElementCss(AscendifyElements.people_addObject);

    // people_addObject.click();
    // return this;
    //}

    public People addCert() throws InterruptedException {
        Ascendify.getDriver().findElement(By.id("asc-add-cert")).click();
        Thread.sleep(1000);
        Ascendify.getDriver().findElement(By.id("asc-title")).sendKeys("QA engineer");
        Select Month = new Select(Ascendify.getDriver().findElement(By.xpath("//*[@id=\"asc-add-certifications-form\"]/div[1]/div[2]/div[1]/select")));
        Month.selectByVisibleText("Feb");
        Thread.sleep(1000);
        Select Year = new Select(Ascendify.getDriver().findElement(By.xpath("//*[@id=\"asc-add-certifications-form\"]/div[1]/div[2]/div[2]/select")));
        Year.selectByVisibleText("2017");
        Thread.sleep(1000);
        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"asc-add-certifications-form\"]/div[2]/div[1]/div/div[1]/input")).isSelected();
        Thread.sleep(1000);
        Ascendify.getDriver().findElement(By.id("asc-add-certifications-btn")).click();
        return this;
    }

    public People addResume() throws InterruptedException {
        // waitForElementXpath(AscendifyElements.people_addResume);
        Thread.sleep(1000);
        Ascendify.getDriver().findElement(By.id("tab-resume")).click();
        // people_addResume.click();
        Thread.sleep(1000);
        return this;
    }

    public People uploadResume() throws InterruptedException {
        Thread.sleep(5000);
        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"asc-show-resume\"]/div/div[1]/button")).click();
        Thread.sleep(2000);
        WebElement resumeupload = Ascendify.getDriver().findElement(By.xpath("//*[@id=\"asc-add-resume-drop\"]"));
        resumeupload.click();
        Thread.sleep(3000);
        //JavascriptExecutor js
        // js.executeScript ("document.getElementById('x').focus()");
        // resumeupload.sendKeys("/Users/hiral/Downloads/Resumes/Amit-Anand.pdf");
        Actions actions = new Actions(Ascendify.getDriver());
        actions.moveToElement(Ascendify.getDriver().findElement(By.xpath("//*[@id=\"asc-add-resume-drop\"]"))).sendKeys("/Macintosh HD/Users/hiral/Downloads/Resumes/Amit-Anand.pdf");
        Thread.sleep(10000);
        // actions.sendKeys("/Macintosh HD/Users/hiral/Downloads/Resumes/Amit-Anand.pdf").click();
        //actions.build().perform();
        // WebElement uploadElement = Ascendify.getDriver().findElement(By.xpath("//*[@id=\"asc-add-resume-drop\"]"));

        // enter the file path onto the file-selection input field
        //uploadElement.sendKeys("/Downloads/Resumes/Harini-G.pdf");
        //Ascendify.getDriver().findElement(By.id("QQTLRqKnfn")).click();
        //Actions actions = new Actions(Ascendify.getDriver());
        //actions.moveToElement(Ascendify.getDriver().findElement(By.xpath("//*[@id=\"asc-add-resume-drop\"]")));
        //actions.click();
        // actions.sendKeys("/Macintosh HD/Users/hiral/Downloads/Resumes/Amit-Anand.pdf").click();
        // actions.build().perform();
        //  WebElement upload = Ascendify.getDriver().findElement(By.id("myfile"));
        // upload.sendKeys("/Users/sso/the/local/path/to/darkbulb.jpg");


        return this;
    }

    public People addNotes() {

        Ascendify.getDriver().findElement(By.id("tab-notes")).click();
        Ascendify.getDriver().findElement(By.id("asc-note-comment")).sendKeys("Hiral's Notes");
        Ascendify.getDriver().findElement(By.id("asc-note-save-btn")).click();
        return this;
    }

    public People clickEndorsements() {
        Ascendify.getDriver().findElement(By.id("tab-endorsements")).click();
        return this;
    }

    public People clickActivity() throws InterruptedException {
        Ascendify.getDriver().findElement(By.id("tab-activities")).click();
        Thread.sleep(2000);
        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"asc-user-expanded-tabs-sub\"]/li[3]/span")).click();
        Thread.sleep(2000);
        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"asc-user-expanded-tabs-sub\"]/li[5]/span")).click();
        Thread.sleep(2000);
        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"asc-user-expanded-tabs-sub\"]/li[7]/span")).click();
        Thread.sleep(2000);
        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"asc-user-expanded-tabs-sub\"]/li[9]/span")).click();
        Thread.sleep(2000);
        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"asc-user-expanded-tabs-sub\"]/li[11]/span")).click();
        Thread.sleep(2000);
        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"asc-user-expanded-tabs-sub\"]/li[13]/span")).click();
        Thread.sleep(2000);
        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"asc-user-expanded-tabs-sub\"]/li[15]")).click();
        Thread.sleep(2000);
        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"asc-user-expanded-tabs-sub\"]/li[17]/span")).click();
        Thread.sleep(2000);
        return this;
    }

    public People clickResponses() {
        Ascendify.getDriver().findElement(By.id("tab-staff-aboutme-one")).click();
        Select profile = new Select(Ascendify.getDriver().findElement(By.xpath("//*[@id=\"asc_question_csvq_7941132997_chosen\"]/ul/li/input")));
        profile.selectByVisibleText("Best");


        return this;
    }






    //  @FindBy(css = AscendifyElements.people_addObject)
    // public WebElement people_addObject;

    @FindBy(css = AscendifyElements.people_addResume)
    public WebElement people_addResume;

}