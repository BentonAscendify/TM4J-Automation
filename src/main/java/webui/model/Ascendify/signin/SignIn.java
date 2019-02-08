package webui.model.Ascendify.signin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webui.model.Ascendify.Ascendify;
import webui.model.Ascendify.AscendifyElements;
import webui.model.WebPage;

import static webui.model.Ascendify.Ascendify.waitForElementClass;
import static webui.model.Ascendify.Ascendify.waitForElementCss;

public class SignIn extends WebPage {


    /**
     * Action methods
     */
    public SignIn inputEmail(String email) {
        waitForElementCss(AscendifyElements.signin_emailF);
        emailField.sendKeys(email);
        return this;
    }


    public SignIn inputPassword(String pass) {
        waitForElementCss(AscendifyElements.signin_passF);
        passField.sendKeys(pass);
        return this;
    }

    public SignIn clickSignin() {
        waitForElementCss(AscendifyElements.signin_button);
        signinButton.click();
        return this;
    }

    public SignIn confirmSignin() {
        waitForElementClass(AscendifyElements.profile_image);
        return this;

    }


    /**
     * UI elements
     */
    @FindBy(css = AscendifyElements.signin_emailF)
    public WebElement emailField;

    @FindBy(css = AscendifyElements.signin_passF)
    public WebElement passField;

    @FindBy(css = AscendifyElements.signin_button)
    public WebElement signinButton;


}
