package webui.model;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import webui.model.Ascendify.Ascendify;

/**
 * This class instantiates Actions Class (for the standard mouse/keyboard actions) as well as PageFactory Class.
 */
public class WebPage {
    private Actions action;

    /**
     * PageFactory is used to initialize elements of a Page class without having to use ‘FindElement’ or ‘FindElements’.
     */
    public WebPage() {
        PageFactory.initElements(Ascendify.getDriver(), this);
        action = new Actions(Ascendify.getDriver());
    }

}
