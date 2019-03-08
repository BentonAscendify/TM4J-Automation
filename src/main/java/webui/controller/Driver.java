package webui.controller;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class instantiates the two main classes of the project: WebDriver and WebDriverWait.
 */
public class Driver {

    final private static String chromeDriver =
            System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver";
    private static WebDriver driver;
    private static WebDriverWait waitElement;

    /**
     * This constructor is set as 'private' to make sure only one instance of Driver is being used for the project.
     */
    private Driver() {
        driver = null;
    }

    /**
     * This method instantiates ChromeDriver Class.
     *
     * @param nameDriver
     */
    public static void setDriver(String nameDriver) {
        System.out.println("set Driver");

        switch (nameDriver) {
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", chromeDriver);
                driver = new ChromeDriver();
                break;
        }
    }

    /**
     * This method instantiates WebDriverWait Class which is used for waiting a web element to be available.
     *
     * @param driver
     */
    public static void setDriverWait(WebDriver driver) {
        waitElement = (new WebDriverWait(driver, 10));
    }

    /**
     * **************************
     * *********GETTERS**********
     * **************************
     */
    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriverWait getDriverWait() {
        return waitElement;
    }
}
