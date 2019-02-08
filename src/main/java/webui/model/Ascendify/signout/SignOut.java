package webui.model.Ascendify.signout;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webui.model.Ascendify.AscendifyElements;
import webui.model.Ascendify.signin.SignIn;
import webui.model.WebPage;

import static webui.model.Ascendify.Ascendify.waitForElementCss;

public class SignOut extends WebPage {


    public SignOut clickProfileDropdown() {
        waitForElementCss(AscendifyElements.profile_image_dropdown);
        profileImageDropdown.click();
        return this;
    }

    public SignOut clickSignout() {
        waitForElementCss(AscendifyElements.signout_button);
        signoutButton.click();
        return this;
    }

    public SignOut confirmSignout() {
        waitForElementCss(AscendifyElements.signin_button);
        return this;
    }


    @FindBy(css = AscendifyElements.signout_button)
    public WebElement signoutButton;

    @FindBy(css = AscendifyElements.profile_image_dropdown)
    public WebElement profileImageDropdown;

}
