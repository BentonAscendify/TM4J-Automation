package webui.model.Ascendify.app.tabs.requisition;

import com.thoughtworks.selenium.webdriven.commands.SelectOption;
import org.apache.hadoop.hive.common.classification.InterfaceAudience;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.joda.time.Seconds;
import org.openqa.selenium.*;
import org.openqa.selenium.browserlaunchers.locators.GoogleChromeLocator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.ActionChainExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webui.model.Ascendify.Ascendify;
import webui.model.Ascendify.AscendifyElements;
import webui.model.Ascendify.app.tabs.requisition.Requisition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class Requisition<var> {




    public Requisition goToRequisitionWorks() {
        Ascendify.getDriver().get("https://testcommunity.ascendify.works/requisitions");
        return this;
    }

    public Requisition goToRequisitionprod() {
        Ascendify.getDriver().get("https://testcommunity.ascendify.com/requisitions");
        return this;

    }

    public Requisition clickNew() throws InterruptedException {
        Ascendify.getDriver().findElement(By.id("asc-add-candidate")).click();
        /*Ascendify.waitForElementCss(AscendifyElements.requistion_new);
        requisitionnew.click();*/
        return this;
    }

    public Requisition confirmclickNew() {
        Ascendify.getDriver().findElement(By.id("asc-add-req-manually")).click();
        //Ascendify.waitForElementCss(AscendifyElements.requisition_addmanually);
        return this;
    }

    public Requisition selectOrg() throws InterruptedException {

        WebDriverWait orgselection = new WebDriverWait(Ascendify.getDriver(), 10);
        orgselection.until(ExpectedConditions.elementToBeClickable(By.linkText("Select Organization"))).click();
        Thread.sleep(5000);
        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"asc_organization_chosen\"]/div/ul/li[2]")).click();
        return this;
    }


    public Requisition addTitle() {
        Ascendify.getDriver().findElement(By.id("asc-title")).sendKeys("Selenium Req");
        return this;
    }

    public Requisition addPosting() {
        Ascendify.getDriver().findElement(By.id("asc-posting-title")).sendKeys("Selenium Req hiral");
        return this;
    }

    public Requisition addLocation() {
        Ascendify.getDriver().findElement(By.id("asc-job-location")).sendKeys("Fremont");
        WebElement clickbutton = Ascendify.getDriver().findElement(By.id("ui-id-6"));
        clickbutton.click();
        return this;
    }

    public Requisition addPrimaryhiring() throws InterruptedException {
        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"hiring_manager\"]")).sendKeys("Alex");
        Actions action = new Actions(Ascendify.getDriver());
        action.sendKeys(Keys.DOWN);
        action.sendKeys(Keys.ENTER);
        action.perform();
        Thread.sleep(2000);
        WebElement primarybutton = Ascendify.getDriver().findElement(By.xpath("//*[@id=\"ui-id-13\"]"));
        primarybutton.click();
        return this;
    }

    public Requisition clickButton() throws InterruptedException {
        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"asc-add-user-btn\"]")).click();
        Thread.sleep(15000);
        return this;

    }

    public Requisition editDescription() throws InterruptedException {
        Thread.sleep(10000);
        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"job-desc\"]/button")).click();
        return this;
    }

    public Requisition addDescription() {
        Ascendify.getDriver().switchTo().frame(Ascendify.getDriver().findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[2]/div[1]/div/div[2]/div/div/iframe")));
        Ascendify.getDriver().findElement(By.tagName("body")).sendKeys("This is selenium description");
        return  this;
    }

    public Requisition clickSave() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(Ascendify.getDriver(), 30);
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("asc-dynamic-save-button")));
        element1.click();
        return this;
    }

    public Requisition editResponsibilities() throws InterruptedException {
        Thread.sleep(10000);
        Ascendify.getDriver().findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div[3]/div[2]/div[2]/div[3]/div[2]/div/div[1]/button")).click();
        return this;
    }



    public Requisition addResponsibilities() {
        Ascendify.getDriver().switchTo().frame(Ascendify.getDriver().findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div[3]/div[2]/div[2]/div[3]/div[2]/div/div[2]/div[1]/div/div/div/div/iframe")));
        Ascendify.getDriver().findElement(By.tagName("body")).sendKeys("This is selenium responsbilities");
        return  this;
    }

    public Requisition clickSaveR() {
        Ascendify.getDriver().findElement(By.partialLinkText("Save")).click();
        //need to get unique id
        return this;
    }

    public Requisition clickTeam() throws InterruptedException {

        Thread.sleep(5000);
        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"tab-team\"]")).click();
        return this;
    }

    //need more info from developer public Requisition addSourcer() {
    // Ascendify.getDriver().findElement(By.xpath("//*[@id=\"asc-group-edit-aclg_c30c395360\"]/div[3]")).click();

    // return this;
    //}



    public Requisition clickQualifying() throws InterruptedException {
        Thread.sleep(10000);
        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"tab-questions\"]")).click();
        Thread.sleep(5000);
        return this;
    }

    public Requisition addNew() throws InterruptedException {

        WebDriverWait orgselection = new WebDriverWait(Ascendify.getDriver(), 10);
        orgselection.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"asc-job-qualifying-questions-select\"]/div[3]/a/span"))).click();
        Thread.sleep(5000);
        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"asc-job-qualifying-questions-select\"]/div[3]/div/ul/li[4]")).click();
        Thread.sleep(5000);
        return this;
    }

    public Requisition turnOn() throws InterruptedException {
        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"tsgn11\"]/label/div[2]")).click();
        Thread.sleep(5000);
        return this;
    }

    public Requisition selectDecline() throws InterruptedException{
        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"auto_reject_email_chosen\"]/a")).click();
        Thread.sleep(5000);
        WebDriverWait selectTemplate = new WebDriverWait(Ascendify.getDriver(), 20);
        selectTemplate.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"auto_status_update_chosen\"]"))).click();
        Thread.sleep(5000);
        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"auto_status_update_chosen\"]/div/ul/li[2]")).click();
        Thread.sleep(5000);
        return this;
    }

    public Requisition clickSaveQ() throws InterruptedException {

        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"knock-out-save-button\"]")).click();
        Thread.sleep(5000);
        return this;
    }

    public Requisition clickScreening() throws InterruptedException {
        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"tab-screening\"]")).click();
        Thread.sleep(5000);
        return this;
    }

    public Requisition addScreening() throws InterruptedException{
        WebDriverWait orgselection = new WebDriverWait(Ascendify.getDriver(), 10);
        orgselection.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"asc-job-screening-questions-select\"]/div[3]"))).click();
        Thread.sleep(5000);
        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"asc-job-screening-questions-select\"]/div[3]/div/ul/li[4]")).click();
        Thread.sleep(7000);
        return this;
    }

    public Requisition clickIntake() throws InterruptedException {
        Ascendify.getDriver().findElement(By.id("tab-intake")).click();
        Thread.sleep(5000);
        return this;
    }

    public Requisition editIntake() throws InterruptedException {
        Thread.sleep(5000);
        Ascendify.getDriver().findElement(By.id("wpilAmmwQF")).click();
        Thread.sleep(2000);
        return this;
    }

    public Requisition addIntake() throws InterruptedException {
        Thread.sleep(5000);
        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"asc-question-csvq_f8b1139791\"]")).sendKeys("Hiral Selenium Test");
        Thread.sleep(5000);
        return this;
    }

    public Requisition clickNotes() throws InterruptedException {
        Thread.sleep(5000);
        //WebElement element;
        // WebDriverWait wait = new WebDriverWait(Ascendify.getDriver(), 10);
        // element= wait.until(ExpectedConditions.elementToBeClickable(By.id("usrUtils")));
        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"tab-notes\"]")).click();
        Thread.sleep(5000);
        return this;
    }

    public Requisition addNotes() throws InterruptedException {
        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"asc-note-comment\"]")).sendKeys("Hiral Selenium test");
        Thread.sleep(5000);

        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"private\"]")).click();
        Thread.sleep(5000);
        return this;
    }

    public Requisition clickSavenotes() throws InterruptedException {
        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"asc-note-save-btn\"]")).click();
        Thread.sleep(10000);
        return this;
    }

    public Requisition clickWorkflow() throws InterruptedException {
        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"tab-workflows\"]")).click();
        Thread.sleep(10000);
        return this;
    }

    public Requisition addnewworkflow() throws InterruptedException {
        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"asc-workflow-holder\"]/div/i")).click();
        Thread.sleep(10000);
        return this;
    }

    public Requisition selectWorkflow() throws InterruptedException {
        Select workflow = new Select(Ascendify.getDriver().findElement(By.xpath("//*[@id=\"asc-workflow-select-form\"]/select")));
        workflow.selectByVisibleText("Interested Workflow 2 - Interested");
        Thread.sleep(10000);
        return this;
    }

    public Requisition saveWorkflow() throws InterruptedException {
        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"modal-dialog-replace-workflow\"]/button[1]")).click();
        Thread.sleep(10000);
        return this;
    }

    public Requisition clickApprovals() throws InterruptedException {
        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"tab-approvals\"]")).click();
        Thread.sleep(5000);
        return this;
    }

    public Requisition selectApproval() throws InterruptedException {
        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"add-approver\"]")).sendKeys("hiral myteam");
        Actions action = new Actions(Ascendify.getDriver());
        action.sendKeys(Keys.DOWN);
        action.sendKeys(Keys.ENTER);
        action.perform();
        WebElement approval = Ascendify.getDriver().findElement(By.xpath("//*[@id=\"cusr_d30ee100000001217520\"]"));
        approval.click();
        Thread.sleep(10000);
        Ascendify.getDriver().findElement(By.id("seq-routing-chk")).click();
        return this;

    }

    public Requisition beginRouting() throws InterruptedException {
        Ascendify.getDriver().findElement(By.id("asc-launch-approval-btn")).click();
        Thread.sleep(10000);
        return this;
    }

    public Requisition changeStatus() throws InterruptedException {
        Thread.sleep(5000);
        Ascendify.getDriver().findElement(By.id("asc-status-btn")).click();
        Thread.sleep(5000);
        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"asc-job-status-list\"]/li[3]/a")).click();
        Thread.sleep(5000);
        return this;
    }

    public Requisition viewAll() throws InterruptedException {

        Ascendify.getDriver().findElement(By.id("view_all")).click();
        Thread.sleep(5000);
        return this;

    }

    public Requisition Myrequisition() throws InterruptedException {
        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"fav-link\"]")).click();
        Thread.sleep(5000);
        return this;
    }

    public Requisition Recentviewd() throws InterruptedException {
        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"view_recently\"]")).click();
        Thread.sleep(5000);
        return this;
    }

    public Requisition Recentlyadded() throws InterruptedException {
        Ascendify.getDriver().findElement(By.id("view_added")).click();
        Thread.sleep(5000);
        return this;
    }

    public Requisition Recruiterlist() throws InterruptedException {
        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"recruiters\"]/div/ul/li[1]/a")).click();
        Thread.sleep(5000);
        return this;
    }

    public Requisition Openstatuses() throws InterruptedException {
        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"job-status-folder\"]/div/ul/li[3]/a")).click();
        Thread.sleep(5000);
        return this;
    }

    public Requisition Org() throws InterruptedException {
        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"job-organizations\"]/div/ul/li[1]/a")).click();
        Thread.sleep(5000);
        return this;
    }

    public Requisition Selectreq() throws InterruptedException {

        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"full-header-search-input\"]")).sendKeys("JY377");
        Thread.sleep(10000);
        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"job_d70e51000000000114035\"]")).click();
        //Ascendify.getDriver().findElement(By.xpath("//*[@id=\"asc-list-job_d70e51000000000114035-tile\"]/div/div/div[1]/div/div[1]")).click();
        Thread.sleep(10000);
        return this;
    }


    public Requisition CandidateReport() throws InterruptedException {
        Thread.sleep(2000);
        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"candidate-info-reg-job\"]/div/div[6]/a")).click();
        return this;
    }

    public Requisition Talentmatching() throws InterruptedException {
        Thread.sleep(5000);
        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"candidate-info-reg-job\"]/div/div[7]/a")).click();
        Thread.sleep(5000);
        return this;
    }
    public Requisition Totalcandidate() throws InterruptedException {
        Ascendify.getDriver().findElement(By.xpath("//*[@id=\"candidate-info-reg-job\"]/div/div[4]/a")).click();
        return this;
    }



    @FindBy(css = AscendifyElements.requistion_new)
    public WebElement requisitionnew;

    @FindBy(css = AscendifyElements.requisition_addmanually)
    public WebElement requisitionaddmanually;

    @FindBy(css = AscendifyElements.requisition_selectOrg)
    public WebElement selectOrg;

    @FindBy(css = AscendifyElements.requisition_selectTemplate)
    public WebElement selectTemplate;

    @FindBy(css = AscendifyElements.requisition_addTitle)
    public WebElement addTitle;

    @FindBy(css = AscendifyElements.requisition_addPosting)
    public WebElement addPosting;

    @FindBy(css = AscendifyElements.requisition_addLocation)
    public WebElement addLocation;

    @FindBy(css = AscendifyElements.requisition_selectIndustry)
    public WebElement selectIndustry;

    @FindBy(css = AscendifyElements.requisition_addPrimaryhiring)
    public WebElement addPrimaryhiring;

    @FindBy(css = AscendifyElements.requisition_clickButton)
    public WebElement clickButton;

    @FindBy(css = AscendifyElements.requisition_editDescription)
    public WebElement editDescrption;

    @FindBy(css = AscendifyElements.requisition_addDescription)
    public WebElement addDescrption;

    @FindBy(css = AscendifyElements.requisition_clickSave)
    public WebElement clickSave;

    @FindBy(css = AscendifyElements.requisition_editResponsbilities)
    public WebElement editRespnsibilities;

    @FindBy(css = AscendifyElements.requisition_addResponsbilities)
    public WebElement addResponsbilities;

    @FindBy(css = AscendifyElements.requisition_clickSaveR)
    public WebElement clickSaveR;

    @FindBy(css = AscendifyElements.requisition_clickTeam)
    public WebElement clickTeam;

    @FindBy(css = AscendifyElements.requisition_addSourcer)
    public WebElement addSourcer;


    @FindBy(css = AscendifyElements.requisition_clickQualifying)
    public WebElement clickQualifying;

    @FindBy(css = AscendifyElements.requisition_addQualifying)
    public WebElement addQualifying;

    @FindBy(css = AscendifyElements.requisition_turnOn)
    public WebElement turnOn;

    @FindBy(css = AscendifyElements.requisition_selectDecline)
    public WebElement selectDecline;

    @FindBy(css = AscendifyElements.requisition_clickSaveQ)
    public WebElement clickSaveQ;

    @FindBy(css = AscendifyElements.requisition_clickScreening)
    public WebElement clickScreening;

    @FindBy(css = AscendifyElements.requisition_addScreening)
    public WebElement addScreening;

    @FindBy(css = AscendifyElements.requisition_clickIntake)
    public WebElement clickIntake;

    @FindBy(css = AscendifyElements.requisition_clickNotes)
    public WebElement clickNotes;

    @FindBy(css = AscendifyElements.requisition_addnotes)
    public WebElement addnotes;

    @FindBy(css = AscendifyElements.requisition_clickSavenotes)
    public WebElement clickSavenotes;

    @FindBy(css = AscendifyElements.requisition_clickWorkflow)
    public WebElement clickWorkflow;

    @FindBy(css = AscendifyElements.requisition_selectworkflow)
    public WebElement selectworkflow;

    @FindBy(css = AscendifyElements.requisition_saveworkflow)
    public WebElement saveworkflow;

    @FindBy(css = AscendifyElements.requisition_clickApprovals)
    public WebElement clickApprovals;

    @FindBy(css = AscendifyElements.requisition_selectApproval)
    public WebElement requisition_selectApproval;

    @FindBy(css = AscendifyElements.requisition_beginRouting)
    public WebElement requisition_beginRouting;

    @FindBy(css = AscendifyElements.requisition_changeStatus)
    public WebElement requisition_changeStatus;

    @FindBy(css = AscendifyElements.requisition_viewAll)
    public WebElement requisition_viewAll;

    @FindBy(css = AscendifyElements.requisition_Myrequisition)
    public WebElement requisition_Myrequisition;

    @FindBy(css = AscendifyElements.requisition_Recentviewd)
    public WebElement requisition_Recentviewd;

    @FindBy(css = AscendifyElements.requisition_Recenlyadded)
    public WebElement requisition_Recentlyadded;

    @FindBy(css = AscendifyElements.requisition_Recruiterlist)
    public WebElement requisition_Recruiterlist;

    @FindBy(css = AscendifyElements.requisition_Openstatuses)
    public WebElement requisition_Openstatuses;

    @FindBy(css = AscendifyElements.requisition_Org)
    public WebElement requisition_Org;

    @FindBy(css = AscendifyElements.requisition_Selectreq)
    public WebElement requisition_Selectreq;

    @FindBy(css = AscendifyElements.requisition_CandidateReport)
    public WebElement requisition_CandidateReport;

    @FindBy(css = AscendifyElements.requisition_Talentmatching)
    public WebElement requisition_Talentmatching;

    @FindBy(css = AscendifyElements.requisition_Totalcandidate)
    public WebElement requisition_Totalcandidate;

}

