package cucumber.support;

public class Util {

    public static String getProperty(String name, String defaultValue) {
        if (System.getProperties().containsKey(name)) {
            return System.getProperty(name);
        } else if (System.getenv().containsKey(name)) {
            return System.getenv().get(name);
        } else {
            return defaultValue;
        }
    }
}
