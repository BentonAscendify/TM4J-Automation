package webui.model.Ascendify.talentcommunity;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webui.model.Ascendify.AscendifyElements;
import webui.model.WebPage;

import java.util.concurrent.TimeUnit;

import static webui.model.Ascendify.Ascendify.getDriver;
import static webui.model.Ascendify.Ascendify.waitForElementClass;
import static webui.model.Ascendify.Ascendify.waitForElementCss;


public class ForgotYourPassword extends WebPage {

    public ForgotYourPassword clickSignin() {
        waitForElementCss(AscendifyElements.tc_signin_button);
        singinButton.click();
        return this;
    }

    public ForgotYourPassword confirmClickSignin() {
        waitForElementCss(AscendifyElements.tc_createaccount_button);
        return this;
    }

    public ForgotYourPassword clickForgotPassword() {
        waitForElementCss(AscendifyElements.tc_forgotyourpassowrd_link);
        fypLink.click();
        return this;
    }

    public ForgotYourPassword confirmClickForgotPassword() {
        waitForElementCss(AscendifyElements.tc_forgotyourpassword_emailfield);
        return this;
    }

    public ForgotYourPassword inputEmail(String email) {
        waitForElementCss(AscendifyElements.tc_forgotyourpassword_emailfield);
        fypEmailfield.sendKeys(email);
        return this;
    }

    public ForgotYourPassword clickRecoverPasword() {
        waitForElementCss(AscendifyElements.tc_recoverpassword_button);
        recoverpasswordButton.click();
        return this;
    }

    public ForgotYourPassword confirmClickRecoverPassword() throws InterruptedException {
        waitForElementCss(AscendifyElements.tc_forgotyourpassword_confirmation);
        getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return this;
    }

    public ForgotYourPassword resetNewPasswordProd(String password) throws InterruptedException {
        // Store the current window handle
        String winHandleBefore = getDriver().getWindowHandle();

        // Switch to a new window opened
        for (String winHandle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(winHandle);
        }

        // Perform the actions on a new window
        waitForElementCss(AscendifyElements.tc_newpassword_field);
        newPassword.sendKeys(password);
        confirmNewPassword(password);
        clickChangePassword();
        confirmSignin();
        // Switch back to the original window
        getDriver().switchTo().window(winHandleBefore);
        return this;
    }

    public ForgotYourPassword resetNewPasswordWorks(String password) throws InterruptedException {
        // Store the current window handle
        String winHandleBefore = getDriver().getWindowHandle();

        // Switch to a new window opened
        for (String winHandle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(winHandle);
        }

        // Perform the actions on a new window
        waitForElementCss(AscendifyElements.tc_newpassword_field);
        newPassword.sendKeys(password);
        confirmNewPassword(password);
        clickChangePassword();
        confirmAlertMessage();

        // Switch back to the original window
        getDriver().switchTo().window(winHandleBefore);
        return this;
    }

    public ForgotYourPassword confirmNewPassword(String password) {
        waitForElementCss(AscendifyElements.tc_confirmnewpassword_field);
        confirmNewPasswordField.sendKeys(password);
        return this;
    }

    public ForgotYourPassword clickChangePassword() {
        waitForElementCss(AscendifyElements.tc_changepassword_button);
        changePasswordButton.click();
        return this;
    }

    public ForgotYourPassword confirmSignin() {
        waitForElementCss(AscendifyElements.tc_menudropdown);
        return this;
    }

    public ForgotYourPassword confirmAlertMessage() {
        waitForElementCss(AscendifyElements.tc_alertmessage);
        return this;
    }


    @FindBy(css = AscendifyElements.tc_signin_button)
    public WebElement singinButton;

    @FindBy(css = AscendifyElements.tc_forgotyourpassowrd_link)
    public WebElement fypLink;

    @FindBy(css = AscendifyElements.tc_forgotyourpassword_emailfield)
    public WebElement fypEmailfield;

    @FindBy(css = AscendifyElements.tc_recoverpassword_button)
    public WebElement recoverpasswordButton;

    @FindBy(css = AscendifyElements.tc_newpassword_field)
    public WebElement newPassword;

    @FindBy(css = AscendifyElements.tc_confirmnewpassword_field)
    public WebElement confirmNewPasswordField;

    @FindBy(css = AscendifyElements.tc_changepassword_button)
    public WebElement changePasswordButton;


}


