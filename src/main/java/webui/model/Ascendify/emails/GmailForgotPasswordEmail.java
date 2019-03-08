package webui.model.Ascendify.emails;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webui.model.Ascendify.Ascendify;
import webui.model.Ascendify.AscendifyElements;
import webui.model.WebPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static webui.model.Ascendify.Ascendify.*;
import static webui.model.Ascendify.GlobalURLs.GmailLogin;

/**
 * Gmail is used for receiving Forgot Your Password email and for resetting the password from the link inside the email
 */
public class GmailForgotPasswordEmail extends WebPage {

    public GmailForgotPasswordEmail goToGmail() {
        Ascendify.getDriver().get(GmailLogin);
        return this;
    }

    public GmailForgotPasswordEmail confirmGoToGmail() {
        waitForElementCss(AscendifyElements.gmail_emailfield);
        return this;
    }

    public GmailForgotPasswordEmail insertEmail(String email) {
        waitForElementCss(AscendifyElements.gmail_emailfield);
        gmailEmailField.sendKeys(email);
        return this;
    }

    public GmailForgotPasswordEmail clickNext() {
        waitForElementCss(AscendifyElements.gmail_nextbutton);
        gmailNextButton.click();
        return this;
    }

    public GmailForgotPasswordEmail confirmClickNext() {
        waitForElementCss(AscendifyElements.gmail_passfield);
        return this;
    }

    public GmailForgotPasswordEmail insertPasswordAndClickEnter(String password) {
        gmailPasswordField.sendKeys(password);
        gmailPasswordField.sendKeys(Keys.ENTER);
        return this;
    }

    public GmailForgotPasswordEmail confirmSignin() {
        waitForElementCss(AscendifyElements.gmail_inboxfolder);
        return this;
    }

    public GmailForgotPasswordEmail waitForPasswordResetEmail() {
        for (int i = 0; i < 6; i++) {
            List<WebElement> elements = getDriver().findElements(By.xpath(AscendifyElements.gmail_passwordreset_email));
            if (elements.size() > 0) {
                gmailPasswordResetEmail.click();
                break;
            } else {
                getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                Ascendify.getDriver().navigate().refresh();
            }
        }
        return this;
    }

    public GmailForgotPasswordEmail confirmInsidePasswordResetEmail() {
        waitForElementXpath(AscendifyElements.gmail_moresettings);
        return this;
    }

    public GmailForgotPasswordEmail clickPasswordResetLinkProd() throws InterruptedException {
        Ascendify.getDriver().navigate().refresh();
        waitForElementXpath(AscendifyElements.gmail_passwordteset_link_prod);
        gmailPasswordResetLinkProd.click();
        Thread.sleep(2000);
        return this;
    }

    public GmailForgotPasswordEmail clickPasswordResetLinkWorks() throws InterruptedException {
        Ascendify.getDriver().navigate().refresh();
        waitForElementXpath(AscendifyElements.gmail_passwordteset_link_works);
        gmailPasswordResetLinkWorks.click();
        Thread.sleep(2000);
        return this;
    }

    public GmailForgotPasswordEmail clickMoreSettings() {
        waitForElementXpath(AscendifyElements.gmail_moresettings);
        gmailMoreSettings.click();
        return this;
    }

    public GmailForgotPasswordEmail clickMoreSettingsDelete() {
        waitForElementXpath(AscendifyElements.gmail_moresettings_delete);
        gmailMoreSettingsDelete.click();
        return this;
    }

    public GmailForgotPasswordEmail confirmNoEmails() {
        waitForElementCss(AscendifyElements.gmail_noemail_text);
        return this;
    }


    @FindBy(css = AscendifyElements.gmail_emailfield)
    public WebElement gmailEmailField;

    @FindBy(css = AscendifyElements.gmail_passfield)
    public WebElement gmailPasswordField;

    @FindBy(css = AscendifyElements.gmail_nextbutton)
    public WebElement gmailNextButton;

    @FindBy(xpath = AscendifyElements.gmail_passwordreset_email)
    public WebElement gmailPasswordResetEmail;

    @FindBy(xpath = AscendifyElements.gmail_passwordteset_link_prod)
    public WebElement gmailPasswordResetLinkProd;

    @FindBy(xpath = AscendifyElements.gmail_passwordteset_link_works)
    public WebElement gmailPasswordResetLinkWorks;

    @FindBy(xpath = AscendifyElements.gmail_moresettings)
    public WebElement gmailMoreSettings;

    @FindBy(xpath = AscendifyElements.gmail_moresettings_delete)
    public WebElement gmailMoreSettingsDelete;

}
