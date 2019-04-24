package webui.model.Ascendify.talentcommunity;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import webui.model.Ascendify.Ascendify;
import webui.model.Ascendify.AscendifyElements;
import webui.model.WebPage;

import static webui.model.Ascendify.Ascendify.waitForElementCss;
import static webui.model.Ascendify.Ascendify.waitForElementXpath;

/**
 * This class contains methods for signing up with Resume
 */
public class SignupWithResume extends WebPage {

    final String currentTime = String.valueOf(System.currentTimeMillis());
    final String uniqueEmail = "tatyana+" + currentTime + "@ascendify.com";

    /**
     * Action methods
     */

    public SignupWithResume clickJoinOurTeam() {
        waitForElementXpath(AscendifyElements.tc_joinourteam_button);
        tcjoingourteambuton.click();
        return this;
    }

    public SignupWithResume clickDragResumeIcon() {

        waitForElementCss(AscendifyElements.tc_dragresume_icon);
        DropFile(tcdragresume, (System.getProperty("user.dir") + "/src/main/resources/data/test_resume.pdf").toString());
        return this;
    }

    /**
     *
     * @param target
     * @param filePath
     * @return
     */
    public SignupWithResume DropFile(WebElement target, String filePath) {
        double offsetX = 0;
        double offsetY = 0;
        JavascriptExecutor jse = (JavascriptExecutor) Ascendify.getDriver();

        String JS_DROP_FILE =
                "var target = arguments[0]," +
                        "    offsetX = arguments[1]," +
                        "    offsetY = arguments[2]," +
                        "    document = target.ownerDocument || document," +
                        "    window = document.defaultView || window;" +
                        "" +
                        "var input = document.createElement('INPUT');" +
                        "input.type = 'file';" +
                        "input.style.display = 'none';" +
                        "input.onchange = function () {" +
                        "  var rect = target.getBoundingClientRect()," +
                        "      x = rect.left + (offsetX || (rect.width >> 1))," +
                        "      y = rect.top + (offsetY || (rect.height >> 1))," +
                        "      dataTransfer = { files: this.files };" +
                        "" +
                        "  ['dragenter', 'dragover', 'drop'].forEach(function (name) {" +
                        "    var evt = document.createEvent('MouseEvent');" +
                        "    evt.initMouseEvent(name, !0, !0, window, 0, 0, 0, x, y, !1, !1, !1, !1, 0, null);" +
                        "    evt.dataTransfer = dataTransfer;" +
                        "    target.dispatchEvent(evt);" +
                        "  });" +
                        "" +
                        "  setTimeout(function () { document.body.removeChild(input); }, 25);" +
                        "};" +
                        "document.body.appendChild(input);" +
                        "return input;";

        WebElement input =  (WebElement)jse.executeScript(JS_DROP_FILE, target, offsetX, offsetY);
        input.sendKeys(filePath.toString());

        return this;
    }


    public SignupWithResume confirmDragResume() {
        waitForElementCss(AscendifyElements.tc_removeresume_button);
        return this;
    }

    public SignupWithResume inputFirstLastName() {
        waitForElementCss(AscendifyElements.tc_signup_firstname);
        tcsignupfirstname.clear();
        tcsignupfirstname.sendKeys("tatyana");

        waitForElementCss(AscendifyElements.tc_signup_lastname);
        tcsignuplastname.clear();
        tcsignuplastname.sendKeys(currentTime);
        return this;
    }

    public SignupWithResume inputEmail() {
        waitForElementCss(AscendifyElements.tc_signup_email);
        tcsignupemail.sendKeys(uniqueEmail);
        return this;
    }

    public SignupWithResume inputPassword() {
        waitForElementCss(AscendifyElements.tc_signup_password);
        tcsignuppassword.sendKeys("test12345");

        waitForElementCss(AscendifyElements.tc_signup_confirmpassword);
        tcsignupconfirmpassword.sendKeys("test12345");
        return this;
    }

    public SignupWithResume clickSubmit() {
        waitForElementCss(AscendifyElements.tc_signup_submit);
        tcsignupsubmitbutton.click();
        return this;
    }

    public SignupWithResume drawSignature() {


        Actions builder = new Actions(Ascendify.getDriver());
        Action drawAction = builder.moveToElement(tcsignupcanvas, 20, 20)
                .clickAndHold()
                .moveByOffset(50, 50)
                .release()
                .build();
        drawAction.perform();

        return this;
    }

    public SignupWithResume clickProfiletab() {
        waitForElementCss(AscendifyElements.tc_profile_tab);
        tcprofiletab.click();
        return this;
    }

    public SignupWithResume confirmClickProfiletab() {
        waitForElementCss(AscendifyElements.tc_profiletab_skills);
        return this;
    }

    public SignupWithResume clickDocumentstab() {
        waitForElementCss(AscendifyElements.tc_documents_tab);
        tcdocumentstab.click();
        return this;
    }

    public SignupWithResume confirmClickDocumentstab() {
        waitForElementCss(AscendifyElements.tc_documentstab_resumebuttons);
        return this;
    }

    public SignupWithResume clickPersonaltab() {
        waitForElementCss(AscendifyElements.tc_personalinfo_tab);
        tcpersonalinfotab.click();
        return this;
    }

    public SignupWithResume confirmClickPersonaltab() {
        waitForElementCss(AscendifyElements.tc_contactdata_section);
        return this;
    }


    /**
     * UI elements
     */
    @FindBy(xpath = AscendifyElements.tc_joinourteam_button)
    public WebElement tcjoingourteambuton;

    @FindBy(css = AscendifyElements.tc_dragresume_icon)
    public WebElement tcdragresume;

    @FindBy(css = AscendifyElements.tc_signup_firstname)
    public WebElement tcsignupfirstname;

    @FindBy(css = AscendifyElements.tc_signup_lastname)
    public WebElement tcsignuplastname;

    @FindBy(css = AscendifyElements.tc_signup_email)
    public WebElement tcsignupemail;

    @FindBy(css = AscendifyElements.tc_signup_password)
    public WebElement tcsignuppassword;

    @FindBy(css = AscendifyElements.tc_signup_confirmpassword)
    public WebElement tcsignupconfirmpassword;

    @FindBy(css = AscendifyElements.tc_signup_submit)
    public WebElement tcsignupsubmitbutton;

    @FindBy(css = AscendifyElements.tc_signup_canvas)
    public WebElement tcsignupcanvas;

    @FindBy(css = AscendifyElements.tc_profile_tab)
    public WebElement tcprofiletab;

    @FindBy(css = AscendifyElements.tc_documents_tab)
    public WebElement tcdocumentstab;

    @FindBy(css = AscendifyElements.tc_personalinfo_tab)
    public WebElement tcpersonalinfotab;

}
