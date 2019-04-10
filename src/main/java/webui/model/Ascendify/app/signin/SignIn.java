package webui.model.Ascendify.app.signin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webui.model.Ascendify.AscendifyElements;
import webui.model.WebPage;

import static webui.model.Ascendify.Ascendify.waitForElementClass;
import static webui.model.Ascendify.Ascendify.waitForElementCss;

/**
 * This class contains methods for signing into the app.
 */
public class SignIn extends WebPage {

    /**
     * Action methods
     */
    public SignIn inputEmail(String email) {
        waitForElementCss(AscendifyElements.signin_emailfield);
        emailField.sendKeys(email);
        return this;
    }

    public SignIn inputPassword(String pass) {
        waitForElementCss(AscendifyElements.signin_passfield);
        passField.sendKeys(pass);
        return this;
    }

    public SignIn clickSignin() {
        waitForElementCss(AscendifyElements.signin_button);
        signinButton.click();
        return this;
    }

    public SignIn confirmSignin() {
        waitForElementClass(AscendifyElements.mainmenu_profileimage);
        return this;
    }

    public SignIn confirmSigninTC() {
        waitForElementCss(AscendifyElements.tc_menudropdown);
        return this;
    }


    /**
     * UI elements
     */
    @FindBy(css = AscendifyElements.signin_emailfield)
    public WebElement emailField;

    @FindBy(css = AscendifyElements.signin_passfield)
    public WebElement passField;

    @FindBy(css = AscendifyElements.signin_button)
    public WebElement signinButton;


}
