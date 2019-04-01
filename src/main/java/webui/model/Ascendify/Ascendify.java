package webui.model.Ascendify;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webui.controller.Driver;
import webui.model.Ascendify.app.tabs.mainmenutab.MainMenuTab;
import webui.model.Ascendify.app.signin.SignIn;
import webui.model.Ascendify.app.signout.SignOut;
<<<<<<< HEAD
import webui.model.Ascendify.app.tabs.people.People;
import webui.model.Ascendify.app.tabs.requisition.Requisition;
=======
import webui.model.Ascendify.emails.GmailForgotPasswordEmail;
>>>>>>> master
import webui.model.Ascendify.talentcommunity.ForgotYourPassword;

import java.util.concurrent.TimeUnit;

import static webui.model.Ascendify.GlobalURLs.*;

/**
 * This is the main class in the project.
 * All modules are being initialized here.
 */
public class Ascendify {
    private static WebDriver driver;
    private static WebDriverWait waitElement;
    public static SignIn signIn;
<<<<<<< HEAD
    public static Hometab hometab;
    public static Requisition requisition;
    public static People people;
=======
    public static MainMenuTab hometab;
>>>>>>> master
    public static SignOut signOut;
    public static ForgotYourPassword forgotYourPassword;
    public static GmailForgotPasswordEmail gmailForgotYourPasswordEmail;

    public Ascendify() {
        Driver.setDriver("Chrome");
        driver = Driver.getDriver();

        Driver.setDriverWait(driver);
        waitElement = Driver.getDriverWait();

        signIn = new SignIn();
<<<<<<< HEAD
        hometab = new Hometab();
        requisition = new Requisition();
        people = new People();
=======
        hometab = new MainMenuTab();
>>>>>>> master
        signOut = new SignOut();
        forgotYourPassword = new ForgotYourPassword();
        gmailForgotYourPasswordEmail = new GmailForgotPasswordEmail();

    }

    public static void openAscendifyWorks() {
        //driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(AscendifyAppWorks);
    }

    public static void openAscendifyProd() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(AscendifyAppProd);
    }

    public static void openTalentCommunityWorks() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(AscendifyTalentCommunityWorks);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public static void openTalentCommunityWorksSingin() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(AscendifyTalentCommunityWorksSignin);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public static void openTalentCommunityProd() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(AscendifyTalentCommunityProd);
    }

    /**
     * **************************
     * *********GETTERS**********
     * **************************
     */
    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriverWait getWaitDriver() {
        return waitElement;
    }

    /**
     * Wait methods which are being used throughout the project.
     * Add more if needed.
     */
    public static void waitForElementCss(String element) {
        waitElement.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(element)));
    }

    public static void waitForElementXpath(String element) {
        waitElement.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));
    }

    public static void waitForElementClass(String element) {
        waitElement.until(ExpectedConditions.presenceOfElementLocated(By.className(element)));
    }

    public static void waitForClickableElementClass(String element) {
        waitElement.until(ExpectedConditions.elementToBeClickable(By.className(element)));
    }

}
