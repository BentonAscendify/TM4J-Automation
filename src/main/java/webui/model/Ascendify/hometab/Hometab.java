package webui.model.Ascendify.hometab;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webui.model.Ascendify.Ascendify;
import webui.model.Ascendify.AscendifyElements;
import webui.model.WebPage;

import java.util.concurrent.TimeUnit;

import static webui.model.Ascendify.Ascendify.*;

public class Hometab extends WebPage {

    /**
     * Action methods
     */

    public Hometab goToHometab() {
        Ascendify.getDriver().get("https://testcommunity.ascendify.works/main_menu");
        return this;
    }

    public Hometab confirmGoToHometab() {
        waitForElementXpath(AscendifyElements.hometab_announcementitle);
        return this;
    }

    public Hometab clickPeopletab() {
        waitForElementXpath(AscendifyElements.hometab_peopletab);
        hometabpeopletab.click();
        return this;
    }

    public Hometab confirmClickPeopletab() {
        waitForElementCss(AscendifyElements.peopletab_selectall);
        waitForElementClass(AscendifyElements.peopletab_statusdropdown);
        waitForElementCss(AscendifyElements.peopletab_showingcount);
        return this;
    }

    public Hometab clickRequisitionstab() {
        waitForElementXpath(AscendifyElements.hometab_requisitionstab);
        hometabrequisitionstab.click();
        return this;
    }

    public Hometab confirmClickRequisitionstab() {
        waitForElementCss(AscendifyElements.requisitionstab_resetfilters);
        return this;
    }

    public Hometab clickAssessmentstab() {
        waitForElementXpath(AscendifyElements.hometab_assessmentstab);
        hometabassessmentstab.click();
        return this;
    }

    public Hometab confirmClickAssessmentstab() {
        waitForElementCss(AscendifyElements.assessments_assessmentschart_);
        return this;
    }


    // this method does not really work
    public Hometab clickDropdown() {
        waitForClickableElementClass(AscendifyElements.hometab_dropdown);
        waitForElementClass(AscendifyElements.hometab_dropdown);
        hometabdropdown.click();
        return this;
    }

    /**
     * UI elements
     */


    @FindBy(xpath = AscendifyElements.hometab_peopletab)
    public WebElement hometabpeopletab;

    @FindBy(className = AscendifyElements.hometab_dropdown)
    public WebElement hometabdropdown;

    @FindBy(xpath = AscendifyElements.hometab_requisitionstab)
    public WebElement hometabrequisitionstab;

    @FindBy(xpath = AscendifyElements.hometab_assessmentstab)
    public WebElement hometabassessmentstab;


}
