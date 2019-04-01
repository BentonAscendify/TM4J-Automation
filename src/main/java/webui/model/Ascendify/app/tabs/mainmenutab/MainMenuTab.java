package webui.model.Ascendify.app.tabs.mainmenutab;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webui.model.Ascendify.Ascendify;
import webui.model.Ascendify.AscendifyElements;
import webui.model.WebPage;

import static webui.model.Ascendify.Ascendify.*;

public class MainMenuTab extends WebPage {

    /**
     * Action methods
     */
    public MainMenuTab goToHometabWorks() {
        Ascendify.getDriver().get("https://testcommunity.ascendify.works/main_menu");
        return this;
    }

    public MainMenuTab confirmGoToHometab() {
        waitForElementXpath(AscendifyElements.mainmenu_announcementitle);
        return this;
    }

    public MainMenuTab clickPeopletab() {
        waitForElementXpath(AscendifyElements.mainmenu_peopletab);
        hometabpeopletab.click();
        return this;
    }

    public MainMenuTab confirmClickPeopletab() {
        waitForElementCss(AscendifyElements.peopletab_selectall);
        waitForElementClass(AscendifyElements.peopletab_statusdropdown);
        waitForElementCss(AscendifyElements.peopletab_showingcount);
        return this;
    }

    public MainMenuTab clickRequisitionstab() {
        waitForElementXpath(AscendifyElements.mainmenu_requisitionstab);
        hometabrequisitionstab.click();
        return this;
    }

    public MainMenuTab confirmClickRequisitionstab() {
        waitForElementCss(AscendifyElements.requisitionstab_resetfilters);
        return this;
    }

    public MainMenuTab clickAssessmentstab() {
        waitForElementXpath(AscendifyElements.mainmenu_assessmentstab);
        hometabassessmentstab.click();
        return this;
    }

    public MainMenuTab confirmClickAssessmentstab() {
        waitForElementCss(AscendifyElements.assessmentstab_assessmentschart);
        return this;
    }


    // this method does not really work
    public MainMenuTab clickDropdown() {
        waitForClickableElementClass(AscendifyElements.mainmenu_dropdown);
        waitForElementClass(AscendifyElements.mainmenu_dropdown);
        hometabdropdown.click();
        return this;
    }

    /**
     * UI elements
     */
    @FindBy(xpath = AscendifyElements.mainmenu_peopletab)
    public WebElement hometabpeopletab;

    @FindBy(className = AscendifyElements.mainmenu_dropdown)
    public WebElement hometabdropdown;

    @FindBy(xpath = AscendifyElements.mainmenu_requisitionstab)
    public WebElement hometabrequisitionstab;

    @FindBy(xpath = AscendifyElements.mainmenu_assessmentstab)
    public WebElement hometabassessmentstab;


}
