package webui.model.Ascendify;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webui.controller.Driver;
import webui.model.Ascendify.hometab.Hometab;
import webui.model.Ascendify.peopletab.PeopleTab;
import webui.model.Ascendify.signin.SignIn;
import webui.model.Ascendify.signout.SignOut;

import java.util.concurrent.TimeUnit;


/**
 * This is the main class in the project.
 * All modules are being initialized here.
 */
public class Ascendify {
    private static WebDriver driver;
    private static WebDriverWait waitElement;
    public static SignIn signIn;
    public static PeopleTab peopleTab;
    public static Hometab hometab;
    public static SignOut signOut;


    public Ascendify() {
        Driver.setDriver("Chrome");
        driver = Driver.getDriver();

        Driver.setDriverWait(driver);
        waitElement = Driver.getDriverWait();

        signIn = new SignIn();
        peopleTab = new PeopleTab();
        hometab = new Hometab();
        signOut = new SignOut();

    }

    public static void openAscendifyWorks() {
        //driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://testcommunity.ascendify.works/");
    }

    public static void openAscendifyProd() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://testcommunity.ascendify.com/");
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
