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
 * This class is used for receiving Forgot Your Password email and for resetting the password from the link inside the email
 */
public class GmailForgotPasswordEmail extends WebPage {


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



    @FindBy(xpath = AscendifyElements.gmail_passwordreset_email)
    public WebElement gmailPasswordResetEmail;

    @FindBy(xpath = AscendifyElements.gmail_passwordteset_link_prod)
    public WebElement gmailPasswordResetLinkProd;

    @FindBy(xpath = AscendifyElements.gmail_passwordteset_link_works)
    public WebElement gmailPasswordResetLinkWorks;



}
