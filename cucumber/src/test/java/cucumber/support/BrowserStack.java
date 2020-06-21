package cucumber.support;

import java.util.HashMap;
import java.util.Map;

public class BrowserStack {

    private String username;
    private String password;
    private String urlScheme;
    private String urlHost;
    private String urlPath;

    private Map<String, String> capabilities = new HashMap<>();

    public BrowserStack() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrlScheme() {
        return urlScheme;
    }

    public void setUrlScheme(String urlScheme) {
        this.urlScheme = urlScheme;
    }

    public String getUrlHost() {
        return urlHost;
    }

    public void setUrlHost(String urlHost) {
        this.urlHost = urlHost;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    public Map<String, String> getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(Map<String, String> capabilities) {
        this.capabilities = capabilities;
    }

    public String toUrl() {
        String url = String.format("%s://%s:%s@%s/%s", urlScheme, username, password, urlHost, urlPath);
        return url;
    }
}
