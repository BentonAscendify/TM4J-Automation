package webui.model.Ascendify.talentcommunity;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webui.model.Ascendify.Ascendify;
import webui.model.Ascendify.AscendifyElements;
import webui.model.WebPage;

import java.util.Iterator;
import java.util.Set;

import static webui.model.Ascendify.Ascendify.waitForElementCss;

public class SigninWithLI extends WebPage{

    /**
     * Action methods
     */
    public SigninWithLI clickSigninWithLI() {
        waitForElementCss(AscendifyElements.tc_signin_li);
        tcsigninli.click();
        return this;
    }

    public SigninWithLI swithToLI() {
        String parentWindowHandler = Ascendify.getDriver().getWindowHandle(); // Store your parent window
        String subWindowHandler = null;

        Set<String> handles = Ascendify.getDriver().getWindowHandles(); // get all window handles
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()){
            subWindowHandler = iterator.next();
        }
        Ascendify.getDriver().switchTo().window(subWindowHandler); // switch to popup window

// Now you are in the popup window, perform necessary actions here

        //Ascendify.getDriver().switchTo().window(parentWindowHandler);  // switch back to parent window

        return this;
    }

    public SigninWithLI inputLIEmail() {
        waitForElementCss(AscendifyElements.li_email_field);
        liemailfield.sendKeys("tatyana.linkedin@ascendify.com");
        return this;
    }

    public SigninWithLI inputLIPassword() {
        waitForElementCss(AscendifyElements.li_password_field);
        lipassowrdfield.sendKeys("Test135!");
        return this;
    }

    public SigninWithLI cickSignin() {
        waitForElementCss(AscendifyElements.li_singin_button);
        lisigninbutton.click();
        return this;
    }



    /**
     * UI elements
     */
    @FindBy (css = AscendifyElements.tc_signin_li)
    public WebElement tcsigninli;

    @FindBy (css = AscendifyElements.li_email_field)
    public WebElement liemailfield;

    @FindBy (css = AscendifyElements.li_password_field)
    public WebElement lipassowrdfield;

    @FindBy (css = AscendifyElements.li_singin_button)
    public WebElement lisigninbutton;

}
