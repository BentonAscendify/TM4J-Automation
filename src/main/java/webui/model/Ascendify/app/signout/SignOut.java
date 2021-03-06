package webui.model.Ascendify.app.signout;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webui.model.Ascendify.AscendifyElements;
import webui.model.WebPage;

import static webui.model.Ascendify.Ascendify.waitForElementCss;

/**
 * This class contains methods for signing out from the app.
 */
public class SignOut extends WebPage {

    /**
     * Action methods
     */
    public SignOut clickProfileDropdown() {
        waitForElementCss(AscendifyElements.profileimage_dropdown);
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

    public SignOut clickTCProfileImage() {
        waitForElementCss(AscendifyElements.tc_profileimage_dropdown);
        tcprofileimagedropdown.click();
        return this;
    }

    /**
     * UI elements
     */
    @FindBy(css = AscendifyElements.signout_button)
    public WebElement signoutButton;

    @FindBy(css = AscendifyElements.profileimage_dropdown)
    public WebElement profileImageDropdown;

    @FindBy(css = AscendifyElements.tc_profileimage_dropdown)
    public WebElement tcprofileimagedropdown;

}
