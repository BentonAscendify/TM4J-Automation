package cucumber.support;

import groovy.util.ConfigObject;
import org.openqa.selenium.WebDriver;

import java.io.File;

public abstract class AbstractContext {

    protected static WebDriver driver;
    protected static ConfigObject config;

    protected static File downloadDir;

    public static WebDriver getDriver() {
        return driver;
    }

    public static ConfigObject getConfig() {
        return config;
    }

    public static File getDownloadDir() {
        return downloadDir;
    }

    protected static String getProperty(String name, String defaultValue) {
        if (System.getProperties().containsKey(name)) {
            return System.getProperty(name);
        } else if (System.getenv().containsKey(name)) {
            return System.getenv().get(name);
        } else {
            return defaultValue;
        }
    }

}
