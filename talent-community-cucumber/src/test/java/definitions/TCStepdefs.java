package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java8.Th;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.UUID;

import static support.TestContext.getDriver;

public class TCStepdefs<session> {
    @Given("I navigate to {string} page")
    public void iNavigateToPage(String arg0) {
        getDriver().get("https://master.ascendify.net/");
    }

    @When("I click on {string} button")
    public void iClickOnButton(String arg0) throws Throwable {
        if (arg0.equalsIgnoreCase("Join Our Team")) {
            getDriver().findElement(By.xpath("//a[contains(text(),'Join Our Team »')]")).click();
        } else if (arg0.equalsIgnoreCase("Submit")) {
            getDriver().findElement(By.xpath("//button[@id='asc-signup-main-button']")).click();
            Thread.sleep(2000);
            Thread.sleep(2000);
            Thread.sleep(2000);
            Thread.sleep(2000);
            Thread.sleep(2000);
            Thread.sleep(2000);
            Thread.sleep(2000);
        } else if (arg0.equalsIgnoreCase("Apply Now")) {
            new WebDriverWait(getDriver(), 200).until(ExpectedConditions.elementToBeClickable(By.id("asc-job-apply-btn")));
            getDriver().findElement(By.xpath("//button[@id='asc-job-apply-btn']")).click();
        } else if (arg0.equalsIgnoreCase("Submit Application")) {
            getDriver().findElement(By.xpath("//button[@id='asc-job-application-survey-btn']")).click();
            Thread.sleep(38000);
        } else if (arg0.equalsIgnoreCase("Upload Your Resume")){
            getDriver().findElement(By.xpath("//span[@class='browse-btn']")).click();
        }
    }

    @And("I click on link text {string}")
    public void iClickOnLinkText(String arg0) {
        if (arg0.equalsIgnoreCase("email address")) {
            getDriver().findElement(By.xpath("//*[contains(text(),'email address')]")).click();
        } else if (arg0.equalsIgnoreCase("Search Careers")) {
            getDriver().findElement(By.xpath("//*[contains(text(),'Search Careers')]")).click();
        } else if (arg0.equalsIgnoreCase("Tessy QA")) {
            new WebDriverWait(getDriver(), 200).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Tessy QA')]")));
            getDriver().findElement(By.xpath("//*[contains(text(),'Tessy QA')]")).click();
        } else if (arg0.equalsIgnoreCase("Sign In")) {
            getDriver().findElement(By.xpath("//a[@class='asc-signin']")).click();
        }
    }

    @Then("{string} page is displayed")
    public void pageIsDisplayed(String arg0) throws Throwable {
        if (arg0.equalsIgnoreCase("Application")){
            Thread.sleep(2000);
            getDriver().findElement(By.xpath("//h2[contains(text(),'Profile Information')]")).isDisplayed();}
        else if (arg0.equalsIgnoreCase("Dashboard")){
//            Thread.sleep(2000);
//            Thread.sleep(6000);
            new WebDriverWait(getDriver(), 200).until(ExpectedConditions.elementToBeClickable(By.id("tab-profile-dashboard")));
//            getDriver().findElement(By.xpath("//*[@id='tab-profile-dashboard']")).isDisplayed();
//            getDriver().findElement(By.id("tab-profile-dashboard")).isDisplayed();
            Thread.sleep(2000);}
        else if (arg0.equalsIgnoreCase("Sign In")){
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.id("asc-signin-container")));
        }
    }

    @And("I type {string} as {string}")
    public void iType(String arg0, String arg1) {
        if (arg0.equalsIgnoreCase("First Name")) {
            getDriver().findElement(By.xpath("//*[@id='asc-signup-firstname']")).sendKeys(arg1);
        } else if (arg0.equalsIgnoreCase("Last Name")) {
            getDriver().findElement(By.xpath("//*[@id='asc-signup-lastname']")).sendKeys(arg1);
        } else if (arg0.equalsIgnoreCase("email")) {
            getDriver().findElement(By.xpath("//input[@id='id_username']")).sendKeys(arg1);
        }
        else if (arg0.equalsIgnoreCase("Most Recent School")){
            getDriver().findElement(By.xpath("//input[@id='asc-signup-school']")).sendKeys(arg1);
        }
        else if (arg0.equalsIgnoreCase("Grad Year")){
            getDriver().findElement(By.xpath("//select[@id='asc-signup-grad-year']/option[contains(text(),'2000')]")).click();
        }
        else if (arg0.equalsIgnoreCase("Degree Type")){
            getDriver().findElement(By.xpath("//input[@id='asc-signup-degree-type']")).sendKeys(arg1);
        }
        else if (arg0.equalsIgnoreCase("Degree")){
            getDriver().findElement(By.xpath("//input[@id='asc-signup-degree']")).sendKeys(arg1);
        }
        else if (arg0.equalsIgnoreCase("Country or Region")){
            getDriver().findElement(By.xpath("//select[@id='asc-personal-country']/option[contains(text(),'India')]")).click();
        }
    }

    @And("I type an unused email")
    public void iTypeAnUnusedEmail() {
        final String randomEmail = randomEmail();
        getDriver().findElement(By.xpath("//input[@id='asc-signup-email2']")).sendKeys(randomEmail);
        getDriver().findElement(By.xpath("//input[@id='asc-signup-email1']")).sendKeys(randomEmail);
    }

    @And("I type password {string} on {string} page")
    public void iTypePasswordOnPage(String arg0, String arg1) throws Throwable {
        if (arg1.equalsIgnoreCase("Sign Up")) {
            Thread.sleep(2000);
            getDriver().findElement(By.xpath("//input[@id='password1']")).sendKeys(arg0);
            getDriver().findElement(By.xpath("//input[@id='password2']")).sendKeys(arg0);
        } else if (arg1.equalsIgnoreCase("Sign In")) {
            Thread.sleep(2000);
            getDriver().findElement(By.xpath("//input[@id='id_password']")).sendKeys(arg0);
        }
    }

    @And("I click and agree to Privacy Policy")
    public void iClickAndAgreeToPrivacyPolicy() throws Throwable {
        getDriver().findElement(By.xpath("//input[@id='asc-signup-disclosure-ck']")).click();
        Thread.sleep(2000);
    }

    private static String randomEmail() {
        return "tessymathew+" + UUID.randomUUID().toString() + "@gmail.com";
    }

    @When("I click on {string} button on {string} page")
    public void iClickOnButtonOnPage(String arg0, String arg1) throws Throwable {
        if (arg1.equalsIgnoreCase("Home")) {
            getDriver().findElement(By.xpath("//a[@id='menu_sign_in']")).click();
        } else if (arg1.equalsIgnoreCase("Sign In")) {
            getDriver().findElement(By.xpath("//button[@id='asc-signin-btn']")).click();
            Thread.sleep(2000);
            Thread.sleep(2000);
        }
    }

    @And("I search for {string} in search box")
    public void iSearchForInSearchBox(String arg0) throws Throwable {
        getDriver().findElement(By.xpath("//input[@id='asc-map-primary-search']")).click();
        getDriver().findElement(By.xpath("//input[@id='asc-map-primary-search']")).sendKeys(arg0);
        getDriver().findElement(By.xpath("//i[@class='header-search-action-btn fa fa-search header-icon highlight-bg fa fa-search']")).click();
        Thread.sleep(2000);
    }

    @And("I make sure I haven't applied to that job already")
    public void iMakeSureIHavenTAppliedToThatJobAlready() {
        try {
            if (getDriver().findElement(By.xpath("//a[@class='asc-withdraw pull-right link']")).isDisplayed()) {
                getDriver().findElement(By.xpath("//a[@class='asc-withdraw pull-right link']")).click();
            }
            else {
                System.out.println("Not applied to this job before");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("I sign to confirm")
    public void iSignToConfirm() {
        try {
            WebElement canvasElement = getDriver().findElement(By.id("asc-esign__canvas"));
            Actions builder = new Actions(getDriver());
//        int getTopLeftY = ((canvasElement.getSize().getHeight()/2) - canvasElement.getSize().getHeight());
//        int getTopLeftX =  (canvasElement.getSize().getWidth()/2) - canvasElement.getSize().getWidth();
            Action drawAction = builder.moveToElement(canvasElement, 20, 20)
                    .clickAndHold()
                    .moveByOffset(100, 100)
                    .moveByOffset(200, 200)
                    .release()
                    .build();
            drawAction.perform();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("success message is displayed")
    public void successMessageIsDisplayed() throws Throwable {
        getDriver().findElement(By.xpath("//li[contains(text(),'You have successfully submitted your information t')]")).isDisplayed();
    }

    @And("I choose my file to be uploaded by clicking {string} button")
    public void iChooseMyFileToBeUploadedByClickingButton(String arg0) throws AWTException, Throwable{
        Actions actions = new Actions(getDriver());
        actions.moveToElement(getDriver().findElement(By.id("asc-alt-upload-resume")));
        getDriver().findElement(By.id("asc-alt-upload-resume")).click();
        Thread.sleep(2000);

        Robot robot;
        try {
            robot = new Robot();
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_C);
            robot.keyRelease(KeyEvent.VK_C);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_SEMICOLON);
            robot.keyRelease(KeyEvent.VK_SEMICOLON);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_BACK_SLASH);
            robot.keyRelease(KeyEvent.VK_BACK_SLASH);
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_U);
            robot.keyRelease(KeyEvent.VK_U);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_S);
            robot.keyRelease(KeyEvent.VK_S);
            robot.keyPress(KeyEvent.VK_E);
            robot.keyRelease(KeyEvent.VK_E);
            robot.keyPress(KeyEvent.VK_R);
            robot.keyRelease(KeyEvent.VK_R);
            robot.keyPress(KeyEvent.VK_S);
            robot.keyRelease(KeyEvent.VK_S);
            robot.keyPress(KeyEvent.VK_BACK_SLASH);
            robot.keyRelease(KeyEvent.VK_BACK_SLASH);
            robot.keyPress(KeyEvent.VK_T);
            robot.keyRelease(KeyEvent.VK_T);
            robot.keyPress(KeyEvent.VK_E);
            robot.keyRelease(KeyEvent.VK_E);
            robot.keyPress(KeyEvent.VK_S);
            robot.keyRelease(KeyEvent.VK_S);
            robot.keyPress(KeyEvent.VK_S);
            robot.keyRelease(KeyEvent.VK_S);
            robot.keyPress(KeyEvent.VK_Y);
            robot.keyRelease(KeyEvent.VK_Y);
            robot.keyPress(KeyEvent.VK_PERIOD);
            robot.keyRelease(KeyEvent.VK_PERIOD);
            robot.keyPress(KeyEvent.VK_A);
            robot.keyRelease(KeyEvent.VK_A);
            robot.keyPress(KeyEvent.VK_N);
            robot.keyRelease(KeyEvent.VK_N);
            robot.keyPress(KeyEvent.VK_I);
            robot.keyRelease(KeyEvent.VK_I);
            robot.keyPress(KeyEvent.VK_C);
            robot.keyRelease(KeyEvent.VK_C);
            robot.keyPress(KeyEvent.VK_A);
            robot.keyRelease(KeyEvent.VK_A);
            robot.keyPress(KeyEvent.VK_T);
            robot.keyRelease(KeyEvent.VK_T);
            robot.keyPress(KeyEvent.VK_T);
            robot.keyRelease(KeyEvent.VK_T);
            robot.keyPress(KeyEvent.VK_U);
            robot.keyRelease(KeyEvent.VK_U);
            robot.keyPress(KeyEvent.VK_M);
            robot.keyRelease(KeyEvent.VK_M);
            robot.keyPress(KeyEvent.VK_A);
            robot.keyRelease(KeyEvent.VK_A);
            robot.keyPress(KeyEvent.VK_T);
            robot.keyRelease(KeyEvent.VK_T);
            robot.keyPress(KeyEvent.VK_H);
            robot.keyRelease(KeyEvent.VK_H);
            robot.keyPress(KeyEvent.VK_E);
            robot.keyRelease(KeyEvent.VK_E);
            robot.keyPress(KeyEvent.VK_W);
            robot.keyRelease(KeyEvent.VK_W);
            robot.keyPress(KeyEvent.VK_BACK_SLASH);
            robot.keyRelease(KeyEvent.VK_BACK_SLASH);
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_D);
            robot.keyRelease(KeyEvent.VK_D);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_E);
            robot.keyRelease(KeyEvent.VK_E);
            robot.keyPress(KeyEvent.VK_S);
            robot.keyRelease(KeyEvent.VK_S);
            robot.keyPress(KeyEvent.VK_K);
            robot.keyRelease(KeyEvent.VK_K);
            robot.keyPress(KeyEvent.VK_T);
            robot.keyRelease(KeyEvent.VK_T);
            robot.keyPress(KeyEvent.VK_O);
            robot.keyRelease(KeyEvent.VK_O);
            robot.keyPress(KeyEvent.VK_P);
            robot.keyRelease(KeyEvent.VK_P);
            robot.keyPress(KeyEvent.VK_BACK_SLASH);
            robot.keyRelease(KeyEvent.VK_BACK_SLASH);
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_P);
            robot.keyRelease(KeyEvent.VK_P);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_R);
            robot.keyRelease(KeyEvent.VK_R);
            robot.keyPress(KeyEvent.VK_O);
            robot.keyRelease(KeyEvent.VK_O);
            robot.keyPress(KeyEvent.VK_F);
            robot.keyRelease(KeyEvent.VK_F);
            robot.keyPress(KeyEvent.VK_I);
            robot.keyRelease(KeyEvent.VK_I);
            robot.keyPress(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_L);
            robot.keyPress(KeyEvent.VK_E);
            robot.keyRelease(KeyEvent.VK_E);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Thread.sleep(2000);
        Thread.sleep(2000);
    }
}