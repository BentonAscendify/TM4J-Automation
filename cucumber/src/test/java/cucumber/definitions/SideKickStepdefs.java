package cucumber.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

import static cucumber.support.TestContext.getDownloadDir;
import static cucumber.support.TestContext.getDriver;

public class SideKickStepdefs {
    @And("save a candidate's resume to pdf")
    public void saveACandidateSResumeToPdf() throws Throwable {
        getDriver().findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Jack Welch", Keys.ENTER);
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='name actor-name'][contains(text(),'Jack Welch')])[1]")));
        getDriver().findElement(By.xpath("(//span[@class='name actor-name'][contains(text(),'Jack Welch')])[1]")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'More')]")));
        getDriver().findElement(By.xpath("//span[contains(text(),'More')]")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Save to PDF')]")));
        getDriver().findElement(By.xpath("//span[contains(text(),'Save to PDF')]")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='artdeco-toast-item__message']")));
        Thread.sleep(2000);
    }

    @Then("I open Ascendify Sidekick Extension")
    public void iOpenAscendifySidekickExtension() throws Throwable {
        getDriver().get("chrome-extension://iallplkmolehjfdjjnjjolhikndeiehb/index.html");
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='web-address-input']")));
    }

    @And("I choose my file to be uploaded by clicking {string} button")
    public void iChooseMyFileToBeUploadedByClickingButton(String arg0) {
        try {
            Actions actions = new Actions(getDriver());
            actions.moveToElement(getDriver().findElement(By.xpath("//input[@type='file']")));
            File profilePdf = new File(getDownloadDir(), "Profile.pdf");
            getDriver().findElement(By.xpath("//input[@type='file']")).sendKeys(profilePdf.getAbsolutePath());
        } catch (Exception exp) {
            exp.printStackTrace();
        }

        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='first-name-input']")));
    }

    @And("I fill in the empty fields SK")
    public void iFillInTheEmptyFieldsSK() throws Throwable {
        getDriver().findElement(By.xpath("//div[@id='mui-component-select-Requisition*']")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("(//li[@class='MuiButtonBase-root MuiListItem-root MuiMenuItem-root MuiMenuItem-gutters MuiListItem-gutters MuiListItem-button'])[1]")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//div[@id='mui-component-select-Status']")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("(//li[@class='MuiButtonBase-root MuiListItem-root MuiMenuItem-root MuiMenuItem-gutters MuiListItem-gutters MuiListItem-button'])[1]")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//div[@id='mui-component-select-Source']")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("(//li[contains(@class,'MuiMenuItem-gutters MuiListItem-gutters MuiListItem-button')])[1]")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//input[@id='recruiter-autocomplete']")).sendKeys("Chandler Bing", Keys.DOWN, Keys.ENTER);
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//input[@id='tags-autocomplete']")).sendKeys("Tag");
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//input[@id='tags-autocomplete']")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//textarea[@id='notes-input']")).sendKeys("Executive Chairman, The Jack Welch Management Institute");
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//button//span[@class='MuiButton-label']")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button//span[contains(text(),'Create Record')]")));
    }

    @And("I clean up {string} candidate")
    public void iCleanUpCandidate(String arg0) throws Throwable {
        getDriver().findElement(By.xpath("//i[contains(@class,'fa fa-caret-down')]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//li[contains(text(),'Admin Console')]")).click();
        Thread.sleep(2000);
        try {
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='user-search']")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (getDriver().findElements(By.xpath("//input[@id='user-search']")).size() == 0) {
            getDriver().findElement(By.xpath("//div[@id='sections-toggle']")).click();
            while (getDriver().findElement(By.xpath("//div[@id='sections-dropdown']")).isDisplayed() == false) {
                getDriver().findElement(By.xpath("//div[@id='sections-toggle']")).click();
            }
            getDriver().findElement(By.xpath("//a[@href='/main_menu']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//i[contains(@class,'fa fa-caret-down')]")));
            getDriver().findElement(By.xpath("//i[contains(@class,'fa fa-caret-down')]")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(),'Admin Console')]")));
            getDriver().findElement(By.xpath("//li[contains(text(),'Admin Console')]")).click();
            try {
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='user-search']")));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (arg0.equalsIgnoreCase("LinkedIn")) {
            getDriver().findElement(By.xpath("//input[@id='user-search']")).sendKeys("Jack Welch", Keys.ENTER);
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Jack Welch')]/../..//i[@class='fa fa-chevron-down']")));
            getDriver().findElement(By.xpath("//th[contains(text(),'Created Date')]")).click();
            getDriver().findElement(By.xpath("//a[contains(text(),'Jack Welch')]/../..//i[@class='fa fa-chevron-down']")).click();
        } else if (arg0.equalsIgnoreCase("Website Bio")) {
            getDriver().findElement(By.xpath("//input[@id='user-search']")).sendKeys("Jeffrey Bezos", Keys.ENTER);
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Jeffrey Bezos')]/../..//i[@class='fa fa-chevron-down']")));
            getDriver().findElement(By.xpath("//th[contains(text(),'Created Date')]")).click();
            getDriver().findElement(By.xpath("//a[contains(text(),'Jeffrey Bezos')]/../..//i[@class='fa fa-chevron-down']")).click();
        }
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='action-call-deleteUser']")));
        getDriver().findElement(By.xpath("//a[@class='action-call-deleteUser']")).click();
        Alert alert = getDriver().switchTo().alert();
        alert.accept();
        Thread.sleep(2000);
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success']")));
    }

    @Given("I visit a website to find a bio to bring into Ascendify")
    public void iVisitAWebsiteToFindABioToBringIntoAscendify() {
        getDriver().get("https://ir.aboutamazon.com/officers-and-directors/default.aspx");
    }

    @When("I select the bio to bring into Ascendify")
    public void iSelectTheBioToBringIntoAscendify() throws Throwable {
        {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.postMessage('clicked_browser_action', '*')");
        }
        Thread.sleep(10000);
    }

    @And("I click on {string} button")
    public void iClickOnButton(String arg0) {
        getDriver().findElement(By.xpath("//span[@class='MuiButton-label']")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='first-name-input']")));
    }
}