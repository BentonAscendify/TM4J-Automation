package webui.model.Ascendify.emails;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webui.model.Ascendify.Ascendify;
import webui.model.Ascendify.AscendifyElements;
import webui.model.WebPage;

import java.util.List;

import static webui.model.Ascendify.Ascendify.getDriver;
import static webui.model.Ascendify.Ascendify.waitForElementCss;
import static webui.model.Ascendify.Ascendify.waitForElementXpath;
import static webui.model.Ascendify.GlobalURLs.GmailLogin;

public class GmailGlobal extends WebPage {

    public GmailGlobal goToGmail() {
        Ascendify.getDriver().get(GmailLogin);
        return this;
    }

    public GmailGlobal confirmGoToGmail() {
        waitForElementCss(AscendifyElements.gmail_emailfield);
        return this;
    }

    public GmailGlobal insertEmail(String email) {
        waitForElementCss(AscendifyElements.gmail_emailfield);
        gmailEmailField.sendKeys(email);
        return this;
    }

    public GmailGlobal clickNext() {
        waitForElementCss(AscendifyElements.gmail_nextbutton);
        gmailNextButton.click();
        return this;
    }

    public GmailGlobal confirmClickNext() {
        waitForElementCss(AscendifyElements.gmail_passfield);
        return this;
    }

    public GmailGlobal insertPasswordAndClickEnter(String password) {
        gmailPasswordField.sendKeys(password);
        gmailPasswordField.sendKeys(Keys.ENTER);
        return this;
    }

    public GmailGlobal confirmSignin() {
        waitForElementCss(AscendifyElements.gmail_inboxfolder);
        return this;
    }

    public GmailGlobal clickMoreSettings() {
        waitForElementXpath(AscendifyElements.gmail_moresettings);
        gmailMoreSettings.click();
        return this;
    }

    public GmailGlobal clickMoreSettingsDelete() {
        waitForElementXpath(AscendifyElements.gmail_moresettings_delete);
        gmailMoreSettingsDelete.click();
        return this;
    }

    public GmailGlobal confirmNoEmails() {
        waitForElementCss(AscendifyElements.gmail_noemail_text);
        return this;
    }

    public GmailGlobal deleteAllInbox() {
//        waitForElementXpath(AscendifyElements.gmail_selectcheckbox);
//        gmailSelectCheckbox.click();

        List<WebElement> emailList = getDriver().findElements(By.cssSelector(AscendifyElements.gmail_noemail_text));

        if (emailList.size() > 0) {
            System.out.println("no Inbox");
        }
        else {
            waitForElementXpath(AscendifyElements.gmail_selectcheckbox);
            gmailSelectCheckbox.click();
            waitForElementXpath(AscendifyElements.gmail_selecttrashcan);
            gmailSelectTrashcan.click();
        }

        return this;
    }


    @FindBy(css = AscendifyElements.gmail_emailfield)
    public WebElement gmailEmailField;

    @FindBy(css = AscendifyElements.gmail_passfield)
    public WebElement gmailPasswordField;

    @FindBy(css = AscendifyElements.gmail_nextbutton)
    public WebElement gmailNextButton;

    @FindBy(xpath = AscendifyElements.gmail_moresettings)
    public WebElement gmailMoreSettings;

    @FindBy(xpath = AscendifyElements.gmail_moresettings_delete)
    public WebElement gmailMoreSettingsDelete;

    @FindBy(css = AscendifyElements.gmail_noemail_text)
    public WebElement gmailNoemailText;

    @FindBy(xpath = AscendifyElements.gmail_selectcheckbox)
    public WebElement gmailSelectCheckbox;

    @FindBy(xpath = AscendifyElements.gmail_selecttrashcan)
    public WebElement gmailSelectTrashcan;
}
