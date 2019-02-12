package webui.model.Ascendify.talentcommunity;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webui.model.Ascendify.AscendifyElements;
import webui.model.WebPage;

import static webui.model.Ascendify.Ascendify.waitForElementCss;

public class ForgotYourPassword extends WebPage{

    public ForgotYourPassword clickSignin() {
        waitForElementCss(AscendifyElements.tc_signin_button);
        tcsingin.click();
        return this;
    }

    public ForgotYourPassword confirmClickSignin() {
        waitForElementCss(AscendifyElements.tc_createacount_button);
        return this;
    }

    public ForgotYourPassword clickForgotPassword() {
        return this;
    }

    @FindBy(css = AscendifyElements.tc_signin_button)
    public WebElement tcsingin;

}


