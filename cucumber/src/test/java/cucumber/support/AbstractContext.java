package cucumber.support;

import groovy.util.ConfigObject;
import groovy.util.ConfigSlurper;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class AbstractContext {

    protected static WebDriver driver;
    protected static ConfigObject config;

    protected static File downloadDir;

    protected static void loadConfig() throws MalformedURLException {
        String environment = Util.getProperty("cucumber.config.env", "webdriverUat");
        String configPath = Util.getProperty("cucumber.config.path", "config.groovy");
        File configFile = new File(configPath);
        URL configFileUrl = null;
        if (!configFile.exists()) {
            System.out.println("Checking file in classpath as config object is missing in given path");
            configFileUrl = TestContext.class.getClassLoader().getResource("config.groovy");
            System.out.println("Checking file in classpath: " + configFileUrl);
        } else {
            configFileUrl = configFile.toURI().toURL();
        }

        config = new ConfigSlurper(environment).parse(configFileUrl);

    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static ConfigObject getConfig() {
        return config;
    }

    public static File getDownloadDir() {
        return downloadDir;
    }

    public static void teardown() {
        driver.quit();
    }

}
