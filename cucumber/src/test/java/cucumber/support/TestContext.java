package cucumber.support;

import groovy.util.ConfigSlurper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class TestContext extends AbstractContext {

    public static void initialize() throws MalformedURLException {
        String cucumberHeadlessProp = Util.getProperty("cucumber.headless", "false");
        boolean isHeadless = Boolean.valueOf(cucumberHeadlessProp);
        System.out.println("Automation running in headless mode ? " + isHeadless);

        loadConfig();
        initialize("chrome", isHeadless);
    }


    public static void initialize(String browser, boolean isHeadless) {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                Map<String, Object> chromePreferences = new HashMap<>();
                chromePreferences.put("profile.default_content_settings.geolocation", 2);
                chromePreferences.put("download.prompt_for_download", false);
                chromePreferences.put("profile.default_content_settings.popups", 0);
                chromePreferences.put("download.directory_upgrade", true);
                downloadDir = getDefaultDownloadDirectoryForChrome(true);
                chromePreferences.put("download.default_directory", downloadDir.getAbsolutePath());
                chromePreferences.put("credentials_enable_service", false);
                chromePreferences.put("password_manager_enabled", false);
                chromePreferences.put("safebrowsing.enabled", "true");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.setExperimentalOption("prefs", chromePreferences);
                System.setProperty("webdriver.chrome.silentOutput", "true");
                File ascendifyCrx = getAscendifySidekickForChrome();
                if (ascendifyCrx != null) {
                    chromeOptions.addExtensions(ascendifyCrx);
                    System.out.println("Ascendify Sidekick crx added to chrome extensions");
                } else {
                    System.out.println("Ascendify Sidekick crx is not available");
                }
                if (isHeadless) {
                    chromeOptions.setHeadless(true);
                    chromeOptions.addArguments("--window-size=1920,1080");
                    chromeOptions.addArguments("--disable-gpu");
                }
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (isHeadless) {
                    FirefoxBinary firefoxBinary = new FirefoxBinary();
                    firefoxBinary.addCommandLineOptions("--headless");
                    firefoxOptions.setBinary(firefoxBinary);
                }
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            case "grid":
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setBrowserName(BrowserType.CHROME);
                capabilities.setPlatform(Platform.ANY);
                URL hubUrl = null;
                try {
                    hubUrl = new URL("http://localhost:4444/wd/hub");
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                driver = new RemoteWebDriver(hubUrl, capabilities);
                break;
            default:
                throw new RuntimeException("Driver is not implemented for: " + browser);
        }
    }

    private static File getDefaultDownloadDirectoryForChrome(boolean clean) {
        String downloadPath = Util.getProperty("cucumber.download.path", "downloads");
        File downloadDir = new File(downloadPath);
        if (clean) {
            try {
                FileUtils.forceDelete(downloadDir);
                downloadDir.mkdirs();
            } catch (IOException e) {
                System.err.println("Failed to delete download dir: " + downloadDir.getAbsolutePath());
                e.printStackTrace();
            }

        }

        System.out.println("Selected download dir: " + downloadDir.getAbsolutePath());
        return downloadDir;
    }

    private static File getAscendifySidekickForChrome() {
        URL u = TestContext.class.getClassLoader().getResource("chrome/extensions/Ascendify-Sidekick-2.0.1_0.crx");
        if (u != null) {
            File f = new File(u.getFile());
            return f;
        }
        return null;
    }

}
