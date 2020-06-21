package cucumber.support;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {

    @Before(order = 0)
    public void scenarioStart() throws Exception {
        boolean isBrowserStack = Boolean.valueOf(Util.getProperty("cucumber.browserstack.enabled", "false"));
        if (isBrowserStack) {
            BrowserStackContext.initialize();
            BrowserStackContext.getDriver().manage().deleteAllCookies();
        } else {
            TestContext.initialize();
            TestContext.getDriver().manage().deleteAllCookies();
        }
    }

    @After(order = 0)
    public void scenarioEnd(Scenario scenario) {
        boolean isBrowserStack = Boolean.valueOf(Util.getProperty("cucumber.browserstack.enabled", "false"));
        WebDriver driver = null;
        if (isBrowserStack) {
            driver = BrowserStackContext.getDriver();
        } else {
            driver = TestContext.getDriver();
        }

        if (scenario.isFailed()) {
            TakesScreenshot screenshotTaker = (TakesScreenshot) driver;
            byte[] screenshot = screenshotTaker.getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
        driver.quit();
    }

}
