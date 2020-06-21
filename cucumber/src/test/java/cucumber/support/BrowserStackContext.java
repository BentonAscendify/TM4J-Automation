package cucumber.support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class BrowserStackContext extends AbstractContext {

    public static void initialize() throws MalformedURLException {
        loadConfig();

        BrowserStack browserStack = createBrowserStackFromProps();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        for(Map.Entry<String,String> entry: browserStack.getCapabilities().entrySet()) {
            capabilities.setCapability(entry.getKey(), entry.getValue());
        }

        driver = new RemoteWebDriver(new URL(browserStack.toUrl()), capabilities);
    }

    private static BrowserStack createBrowserStackFromProps() {
        BrowserStack browserStack = new BrowserStack();
        browserStack.setUsername(Util.getProperty("cucumber.browserstack.username", ""));
        browserStack.setPassword(Util.getProperty("cucumber.browserstack.password", ""));
        browserStack.setUrlScheme(Util.getProperty("cucumber.browserstack.url.scheme", ""));
        browserStack.setUrlHost(Util.getProperty("cucumber.browserstack.url.host", ""));
        browserStack.setUrlPath(Util.getProperty("cucumber.browserstack.url.path", ""));

        String[] capabilityKeys = Util.getProperty("cucumber.browserstack.capabilities.keys", "").split(",");
        for (String capabilityKey : capabilityKeys) {
            String keyName = String.format("cucumber.browserstack.capabilities.key.%s", capabilityKey);
            String value = Util.getProperty(keyName, "");
            browserStack.getCapabilities().put(capabilityKey, value);
        }

        return browserStack;
    }

}