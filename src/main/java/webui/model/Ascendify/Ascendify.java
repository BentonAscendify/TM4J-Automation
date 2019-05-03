package webui.model.Ascendify;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webui.controller.Driver;
import webui.model.Ascendify.app.tabs.mainmenutab.MainMenuTab;
import webui.model.Ascendify.app.signin.SignIn;
import webui.model.Ascendify.app.signout.SignOut;
import webui.model.Ascendify.app.tabs.people.People;
import webui.model.Ascendify.app.tabs.requisition.Requisition;
import webui.model.Ascendify.emails.GmailForgotPasswordEmail;
import webui.model.Ascendify.emails.GmailGlobal;
import webui.model.Ascendify.talentcommunity.ForgotYourPassword;
import webui.model.Ascendify.talentcommunity.SigninWithLI;
import webui.model.Ascendify.talentcommunity.SignupWithResume;

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
    public static Requisition requisition;
    public static People people;
    public static MainMenuTab hometab;
    public static SignOut signOut;
    public static ForgotYourPassword forgotYourPassword;
    public static GmailForgotPasswordEmail gmailForgotYourPasswordEmail;
    public static GmailGlobal gmailGlobal;
    public static SignupWithResume signupWithResume;
    public static SigninWithLI signinWithLI;

    public Ascendify() {
        Driver.setDriver("Chrome");
        driver = Driver.getDriver();

        Driver.setDriverWait(driver);
        waitElement = Driver.getDriverWait();

        signIn = new SignIn();
        requisition = new Requisition();
        people = new People();
        hometab = new MainMenuTab();
        signOut = new SignOut();
        forgotYourPassword = new ForgotYourPassword();
        gmailForgotYourPasswordEmail = new GmailForgotPasswordEmail();
        gmailGlobal = new GmailGlobal();
        signupWithResume = new SignupWithResume();
        signinWithLI = new SigninWithLI();

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
