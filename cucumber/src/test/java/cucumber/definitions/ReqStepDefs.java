package cucumber.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.UUID;

import static cucumber.support.TestContext.getDriver;

public class ReqStepDefs {
    @Given("I navigate to {string} page REQ")
    public void iNavigateToPage(String arg0) {
        if (arg0.equalsIgnoreCase("Test Community login")) {
            getDriver().get("https://testcommunity.ascendify.com/");
        } else if (arg0.equalsIgnoreCase("TC Login")) {
            getDriver().get("https://master.ascendify.net/");
        }
    }

    @When("I sign in as super admin with credentials {string} and {string} REQ")
    public void iSignInAsSuperAdminWithCredentialsAnd(String arg0, String arg1) {
        getDriver().findElement(By.xpath("//input[@id='id_username']")).click();
        getDriver().findElement(By.xpath("//input[@id='id_username']")).sendKeys("tessy.anicattumathew@ascendify.com");
        getDriver().findElement(By.xpath("//input[@id='id_password']")).click();
        getDriver().findElement(By.xpath("//input[@id='id_password']")).sendKeys("Mac123q!");
        getDriver().findElement(By.xpath("//button[@id='asc-signin-btn']")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Main Menu tab')]")));
        getDriver().findElement(By.xpath("//span[contains(text(),'Main Menu tab')]")).isDisplayed();
    }

    @And("I create a person's profile with role Recruiter REQ")
    public void iCreateAPersonSProfile() throws Throwable {
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//div[contains(text(),'People')]")).click();
        getDriver().findElement(By.xpath("//span[@id='asc-add-candidate']")).click();
        getDriver().findElement(By.xpath("//a[@id='asc-add-candidate-manually']")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='asc-firstname']")));
        getDriver().findElement(By.xpath("//input[@id='asc-firstname']")).sendKeys("New");
        getDriver().findElement(By.xpath("//input[@id='asc-lastname']")).sendKeys("Recruiter");

        final String randomEmail = randomEmail();
        getDriver().findElement(By.xpath("//input[@id='asc-email']")).sendKeys(randomEmail);
        getDriver().findElement(By.xpath("//input[@id='asc-email']")).click();
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        getDriver().findElement(By.xpath("//input[@id='asc-cellphone']")).sendKeys("610-852-8288");
        getDriver().findElement(By.xpath("//input[@id='asc-phone']")).sendKeys("609-602-2709");
        getDriver().findElement(By.xpath("//input[@id='user-address1']")).sendKeys("4144");
        getDriver().findElement(By.xpath("//input[@id='user-address2']")).sendKeys("Filbert Street");
        getDriver().findElement(By.xpath("//input[@id='user-city']")).sendKeys("WILDWOOD");
        getDriver().findElement(By.xpath("//input[@id='user-state']")).sendKeys("New Jersey");
        getDriver().findElement(By.xpath("//input[@id='user-zipcode']")).sendKeys("08260");

        getDriver().findElement(By.xpath("//div[@id='asc_personal_country_chosen']//a[@class='chosen-single chosen-default']")).click();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        getDriver().findElement(By.xpath("//input[@id='asc-site-site_linkedin']")).sendKeys("https://www.linkedin.com/in/tessy-anicattu-mathew-4b407119a/");
        getDriver().findElement(By.xpath("//select[@id='asc-client-crm-status-field']")).click();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        getDriver().findElement(By.xpath("//div[@id='asc_group_select_chosen']//input")).click();
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        getDriver().findElement(By.xpath("//div[@id='asc_group_select_chosen']//input")).sendKeys("Recruiter");
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        getDriver().findElement(By.xpath("//select[@id='asc-basic-source-field']")).click();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        getDriver().findElement(By.xpath("//select[@id='asc-basic-recruiter-field']")).click();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        getDriver().findElement(By.xpath("//input[@id='asc-add-user-quick-comment']")).sendKeys("Note please");
        getDriver().findElement(By.xpath("//select[@class='asc-org-name-text asc-text']")).click();
        getDriver().findElement(By.xpath("//select[@class='asc-org-name-text asc-text']//option[contains(text(),'Test Community!')]")).click();
        getDriver().findElement(By.xpath("//a[@id='asc-add-new-org-text-box']")).click();
        getDriver().findElement(By.xpath("//select[@class='asc-org-name-text asc-text']")).click();
        getDriver().findElement(By.xpath("//select[@class='asc-org-name-text asc-text']//option[contains(text(),'Ascendify')]")).click();
        getDriver().findElement(By.xpath("//span[@class='trash-can']")).click();
        getDriver().findElement(By.xpath("//button[@class='btn btn-xs btn-danger asc-del-confirm']")).click();
        getDriver().findElement(By.xpath("//input[@id='asc-add-user-tag-input']")).sendKeys("Test Tag");
        getDriver().findElement(By.xpath("//button[@id='asc-asd-user-tag-btn']")).click();
        getDriver().findElement(By.xpath("//button[@id='asc-add-user-btn']")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'New user was added.')]")));
        new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='row asc-record-expanded-header-parent']")));

        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//li[@id='tab-personal']")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='asc-edit-icon btn btn-sm btn-primary']")));
        getDriver().findElement(By.xpath("//span[@class='asc-edit-icon btn btn-sm btn-primary']")).click();
        getDriver().findElement(By.xpath("//input[@id='new_password']")).sendKeys("Ascendify246!");
        getDriver().findElement(By.xpath("//input[@id='new_password2']")).sendKeys("Ascendify246!");
        getDriver().findElement(By.xpath("//button[@id='asc-dynamic-save-button']")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='asc-msg-pwd-success']")));
    }

    private String randomEmail() {
        return "tessymathew+" + UUID.randomUUID().toString() + "@gmail.com";
    }

    @Then("I sign in as the new Recruiter REQ")
    public void iSignOutAndSignInAsTheNewRecruiter() throws Throwable {
        getDriver().findElement(By.xpath("//input[@id='id_username']")).click();

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        Thread.sleep(2000);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_ENTER);
        getDriver().findElement(By.xpath("//input[@id='id_password']")).click();
        getDriver().findElement(By.xpath("//input[@id='id_password']")).sendKeys("Ascendify246!");
        getDriver().findElement(By.xpath("//button[@id='asc-signin-btn']")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Main Menu tab')]")));
        getDriver().findElement(By.xpath("//span[contains(text(),'Main Menu tab')]")).isDisplayed();
    }

    @And("I create a new requisition REQ")
    public void iCreateANewRequisition() throws Throwable, AWTException {
        getDriver().findElement(By.xpath("//div[@class='hovicon btn-primary']//a[@id='header-requisitions']")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='asc-add-candidate']")));
        getDriver().findElement(By.xpath("//span[@id='asc-add-candidate']")).click();
        getDriver().findElement(By.xpath("//a[@id='asc-add-req-manually']")).click();

        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='asc_pipeline_template_chosen']//a[@class='chosen-single']")));
        getDriver().findElement(By.xpath("//div[@id='asc_pipeline_template_chosen']//a[@class='chosen-single']")).click();
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        getDriver().findElement(By.xpath("//input[@id='asc-title']")).sendKeys("New Requisition");
        getDriver().findElement(By.xpath("//input[@id='asc-posting-title']")).sendKeys("Posting Title");
        getDriver().findElement(By.xpath("//input[@id='asc-job-req']")).sendKeys("FW1752");
        getDriver().findElement(By.xpath("//input[@id='asc-job-location']")).sendKeys("Location");
        getDriver().findElement(By.xpath("//span[@id='asc-job-location-add']")).click();
        getDriver().findElement(By.xpath("//div[@id='asc-job-location-div']//div[2]//input[1]")).sendKeys("SFO");

        getDriver().findElement(By.xpath("//div[@id='asc_job_cat_chosen']//a[@class='chosen-single']")).click();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        getDriver().findElement(By.xpath("//input[@id='hiring_manager']")).sendKeys("Hiral");
        Thread.sleep(4000);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        WebElement FN = getDriver().findElement(By.xpath("//input[@id='recruiter']"));
        String textInsideFN = FN.getAttribute("value");
        if (textInsideFN.isEmpty()) {
            String Name = getDriver().findElement(By.xpath("//div[@class='c70']")).getText();
            getDriver().findElement(By.xpath("//input[@id='recruiter']")).sendKeys(Name);
        }

        getDriver().findElement(By.xpath("//input[@id='asc_closedate']")).click();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        getDriver().findElement(By.xpath("//input[@id='asc_start_date']")).click();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        getDriver().findElement(By.xpath("//input[@id='asc_end_date']")).click();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        getDriver().findElement(By.xpath("//input[@id='asc_duration']")).sendKeys("2 years");

        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Select EEO Job Family')]")));
        getDriver().findElement(By.xpath("//span[contains(text(),'Select EEO Job Family')]")).click();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        getDriver().findElement(By.xpath("//span[contains(text(),'Select Type of Work')]")).click();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        getDriver().findElement(By.xpath("//input[@id='asc_target_fill_date']")).click();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        getDriver().findElement(By.xpath("//input[@id='asc-occupation']")).sendKeys("Occupation");
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        getDriver().findElement(By.xpath("//span[contains(text(),'Select FLSA Status')]")).click();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        getDriver().findElement(By.xpath("//span[contains(text(),'Select Travel Requirements')]")).click();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        getDriver().findElement(By.xpath("//span[contains(text(),'Select Security Clearance')]")).click();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        getDriver().findElement(By.xpath("//span[contains(text(),'Select Minimum Level of Education')]")).click();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        getDriver().findElement(By.xpath("//span[contains(text(),'Select Level of Experience')]")).click();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        getDriver().findElement(By.xpath("//div[@id='seniority_level_chosen']//a[@class='chosen-single']")).click();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        getDriver().findElement(By.xpath("//input[@id='parent-job-id']")).sendKeys("Test", Keys.ARROW_DOWN, Keys.ENTER);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        getDriver().findElement(By.xpath("//button[@id='asc-add-user-btn']")).click();
        new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='asc-record-expanded-header-parent row']")));
    }

    @And("I upload a {string} REQ")
    public void iUploadAREQ(String arg0) throws Throwable {
        if (arg0.equalsIgnoreCase("CSV file")) {
            getDriver().findElement(By.xpath("//div[@class='hovicon btn-primary']//a[@id='header-requisitions']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='asc-add-candidate']")));
            getDriver().findElement(By.xpath("//span[@id='asc-add-candidate']")).click();
            getDriver().findElement(By.xpath("//a[@id='asc-add-req-csv']")).click();

            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='asc-dropbox-outer-shell']")));
            Thread.sleep(2000);
            try {
                Actions actions = new Actions(getDriver());
                actions.moveToElement(getDriver().findElement(By.xpath("//div[@class='asc-dropbox-outer-shell']")));
                getDriver().findElement(By.xpath("//div[@class='asc-dropbox-outer-shell']")).click();
                Thread.sleep(2000);
                URL resumeUrl = getClass().getClassLoader().getResource("resumes/requisitions-import.csv");
                if (resumeUrl != null) {
                    File resumeFile = new File(resumeUrl.getFile());
                    uploadFile(resumeFile.getAbsolutePath());
                    Thread.sleep(2000);
                } else {
                    throw new Exception("Failed to find resume absolute path");
                }
                Thread.sleep(2000);
            } catch (Exception exp) {
                exp.printStackTrace();
            }
        } else if (arg0.equalsIgnoreCase("Document")) {
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-sm btn-primary add-document-btn']")));
            getDriver().findElement(By.xpath("//button[@class='btn btn-sm btn-primary add-document-btn']")).click();

            Thread.sleep(2000);
            try {
                Actions actions = new Actions(getDriver());
                actions.moveToElement(getDriver().findElement(By.xpath("//div[@class='asc-dropbox-outer-shell']")));
                getDriver().findElement(By.xpath("//div[@class='asc-dropbox-outer-shell']")).click();
                Thread.sleep(2000);
                URL resumeUrl = getClass().getClassLoader().getResource("resumes/RequisitionForm.png");
                if (resumeUrl != null) {
                    File resumeFile = new File(resumeUrl.getFile());
                    uploadFile(resumeFile.getAbsolutePath());
                    Thread.sleep(2000);
                } else {
                    throw new Exception("Failed to find resume absolute path");
                }
                Thread.sleep(8000);
            } catch (Exception exp) {
                exp.printStackTrace();
            }
        }
    }

    private static void setClipboardData(String string) {
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }

    private static void uploadFile(String fileLocation) {
        try {
            setClipboardData(fileLocation);
            Robot robot = new Robot();

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            Thread.sleep(2000);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    @And("I change status to Open REQ")
    public void iChangeStatusToOpen() throws Throwable {
        getDriver().findElement(By.xpath("//button[@id='asc-status-btn']")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//a[text()='Open']")).click();
        Thread.sleep(6000);
    }

    @And("I sign out REQ")
    public void iSignOut() throws Throwable {
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//div[@id='global-profile-dropdown-widget-container']")).click();
        Thread.sleep(1000);
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='asc-sign-out-button']")));
        getDriver().findElement(By.xpath("//li[@id='asc-sign-out-button']")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='id_username']")));
    }

    @And("I sign out from Talent Community REQ")
    public void iSignOutFromTalentCommunity() {
        getDriver().findElement(By.xpath("//a[@class='dropdown-toggle asc-user-menu-link']")).click();
        getDriver().findElement(By.xpath("//a[@class='btn btn-danger']")).click();
        new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-default safari_redirect_link']")));
    }

    @And("I search for that requisition REQ")
    public void iSearchForThatRequisition() throws Throwable {
        new WebDriverWait(getDriver(), 200).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Search Careers')]")));
        getDriver().findElement(By.xpath("//*[contains(text(),'Search Careers')]")).click();

        getDriver().findElement(By.xpath("//input[@id='asc-map-primary-search']")).click();
        getDriver().findElement(By.xpath("//input[@id='asc-map-primary-search']")).sendKeys("New Requisition");
        getDriver().findElement(By.xpath("//i[@class='header-search-action-btn fa fa-search header-icon highlight-bg fa fa-search']")).click();
        Thread.sleep(2000);

        if (getDriver().findElement(By.xpath("//*[contains(text(),'New Requisition')]")).isDisplayed()) {
            getDriver().findElement(By.xpath("//*[contains(text(),'New Requisition')]")).click();
            Thread.sleep(2000);
        } else {
            getDriver().navigate().refresh();
            getDriver().findElement(By.xpath("//input[@id='asc-map-primary-search']")).sendKeys("New Requisition");
            getDriver().findElement(By.xpath("//i[@class='header-search-action-btn fa fa-search header-icon highlight-bg fa fa-search']")).click();
            Thread.sleep(2000);
            new WebDriverWait(getDriver(), 200).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'New Requisition')]")));
            getDriver().findElement(By.xpath("//*[contains(text(),'New Requisition')]")).click();
            Thread.sleep(2000);
        }
    }

    final String randomEmail2 = randomEmail();

    @And("I apply for that requisition REQ")
    public void iApplyForThatRequisition() throws Throwable {
        try {
            if (getDriver().findElement(By.id("asc-job-apply-btn")).isDisplayed()) {
                getDriver().findElement(By.xpath("//button[@id='asc-job-apply-btn']")).click();
            } else {
                getDriver().findElement(By.xpath("//*[contains(text(),'Search Careers')]")).click();
                getDriver().findElement(By.xpath("//input[@id='asc-map-primary-search']")).click();
                getDriver().findElement(By.xpath("//input[@id='asc-map-primary-search']")).sendKeys("New Requisition");
                getDriver().findElement(By.xpath("//i[@class='header-search-action-btn fa fa-search header-icon highlight-bg fa fa-search']")).click();
                Thread.sleep(2000);
                getDriver().findElement(By.xpath("//*[contains(text(),'New Requisition')]")).click();
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        getDriver().findElement(By.xpath("//*[contains(text(),'email address')]")).click();

        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//h2[contains(text(),'Profile Information')]")).isDisplayed();

        WebElement FN = getDriver().findElement(By.xpath("//input[@id='asc-signup-firstname']"));
        String textInsideFN = FN.getAttribute("value");
        if (textInsideFN.isEmpty()) {
            getDriver().findElement(By.xpath("//input[@id='asc-signup-firstname']")).sendKeys("New");
        }
        WebElement LN = getDriver().findElement(By.xpath("//input[@id='asc-signup-lastname']"));
        String textInsideLN = LN.getAttribute("value");
        if (textInsideLN.isEmpty()) {
            getDriver().findElement(By.xpath("//input[@id='asc-signup-lastname']")).sendKeys("Applicant");
        }
        WebElement Email = getDriver().findElement(By.xpath("//input[@id='asc-signup-email2']"));
        String textInsideEmail = Email.getAttribute("value");
        if (textInsideEmail.isEmpty()) {
            getDriver().findElement(By.xpath("//input[@id='asc-signup-email2']")).sendKeys(randomEmail2);
            getDriver().findElement(By.xpath("//input[@id='asc-signup-email1']")).sendKeys(randomEmail2);
            getDriver().findElement(By.xpath("//input[@id='asc-signup-email2']")).click();
        }
        WebElement PWD = getDriver().findElement(By.xpath("//input[@id='password1']"));
        String textInsidePWD = PWD.getAttribute("value");
        if (textInsidePWD.isEmpty()) {
            getDriver().findElement(By.xpath("//input[@id='password1']")).sendKeys("Ascendify246!");
            getDriver().findElement(By.xpath("//input[@id='password2']")).sendKeys("Ascendify246!");
        }
        WebElement PN = getDriver().findElement(By.xpath("//input[@id='asc-signup-cellphonenumber']"));
        String textInsidePN = PN.getAttribute("value");
        if (textInsidePN.isEmpty()) {
            getDriver().findElement(By.xpath("//input[@id='asc-signup-cellphonenumber']")).sendKeys("610-852-8288");
        }
        WebElement Adrs = getDriver().findElement(By.xpath("//input[@id='asc-signup-address1']"));
        String textInsideAdrs = Adrs.getAttribute("value");
        if (textInsideAdrs.isEmpty()) {
            getDriver().findElement(By.xpath("//input[@id='asc-signup-address1']")).sendKeys("4144  Filbert Street");
        }
        WebElement City = getDriver().findElement(By.xpath("//input[@id='asc-signup-city']"));
        String textInsideCity = City.getAttribute("value");
        if (textInsideCity.isEmpty()) {
            getDriver().findElement(By.xpath("//input[@id='asc-signup-city']")).sendKeys("WILDWOOD");
        }
        WebElement State = getDriver().findElement(By.xpath("//input[@id='asc-signup-state']"));
        String textInsideState = State.getAttribute("value");
        if (textInsideState.isEmpty()) {
            getDriver().findElement(By.xpath("//input[@id='asc-signup-state']")).sendKeys("New Jersey");
        }
        WebElement zip = getDriver().findElement(By.xpath("//input[@id='asc-signup-postal_code']"));
        String textInsidezip = zip.getAttribute("value");
        if (textInsidezip.isEmpty()) {
            getDriver().findElement(By.xpath("//input[@id='asc-signup-postal_code']")).sendKeys("08260");
        }

        try {
            WebElement Sch = getDriver().findElement(By.xpath("//input[@id='asc-signup-school']"));
            String textInsideSch = Sch.getAttribute("value");
            if (textInsideSch.isEmpty()) {
                getDriver().findElement(By.xpath("//input[@id='asc-signup-school']")).sendKeys("Bellevue University");
            }
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='asc-signup-grad-year']")));
            WebElement Year = getDriver().findElement(By.xpath("//select[@id='asc-signup-grad-year']"));
            String textInsideYear = Year.getAttribute("value");
            if (textInsideYear.isEmpty()) {
                getDriver().findElement(By.xpath("//select[@id='asc-signup-grad-year']/option[contains(text(),'2000')]")).click();
            }
            WebElement DT = getDriver().findElement(By.xpath("//input[@id='asc-signup-degree-type']"));
            String textInsideDT = DT.getAttribute("value");
            if (textInsideDT.isEmpty()) {
                getDriver().findElement(By.xpath("//input[@id='asc-signup-degree-type']")).sendKeys("Management Information Systems");
            }
            WebElement Deg = getDriver().findElement(By.xpath("//input[@id='asc-signup-degree']"));
            String textInsideDeg = Deg.getAttribute("value");
            if (textInsideDeg.isEmpty()) {
                getDriver().findElement(By.xpath("//input[@id='asc-signup-degree']")).sendKeys("MBA");
            }
            getDriver().findElement(By.xpath("//input[@id='ct_sms']")).click();
            getDriver().findElement(By.xpath("//input[@name='ascendify[communication_preference][automated_sms_sys_msg]']")).click();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            int j = getDriver().findElements(By.xpath("//a[contains(@class,'chosen-single chosen-default')]")).size();
            for (int i = 1; i <= j; i++) {
                if (getDriver().findElement(By.xpath("(//a[contains(@class,'chosen-single chosen-default')])[" + i + "]")).isDisplayed()) {
                    getDriver().findElement(By.xpath("(//a[contains(@class,'chosen-single chosen-default')])[" + i + "]")).click();
                    getDriver().findElement(By.xpath("(//a[contains(@class,'chosen-single chosen-default')])[" + i + "]")).click();
                    getDriver().findElement(By.xpath("(//a[contains(@class,'chosen-single chosen-default')])[" + i + "]")).click();
                    Robot robot = new Robot();
                    robot.keyPress(KeyEvent.VK_DOWN);
                    robot.keyRelease(KeyEvent.VK_DOWN);
                    robot.keyPress(KeyEvent.VK_DOWN);
                    robot.keyRelease(KeyEvent.VK_DOWN);
                    robot.keyPress(KeyEvent.VK_ENTER);
                    robot.keyRelease(KeyEvent.VK_ENTER);
                    Thread.sleep(2000);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (getDriver().findElement(By.xpath("//input[contains(@class,'hasDatepicker')]")).isDisplayed()) {
                getDriver().findElement(By.xpath("//input[contains(@class,'hasDatepicker')]")).click();
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            WebElement canvasElement = getDriver().findElement(By.id("asc-esign__canvas"));
            Actions builder = new Actions(getDriver());
            Action drawAction = builder.moveToElement(canvasElement, 20, 20)
                    .clickAndHold()
                    .moveByOffset(100, 100)
                    .moveByOffset(200, 200)
                    .release()
                    .build();
            drawAction.perform();
        } catch (Exception e) {
            e.printStackTrace();
        }

        getDriver().findElement(By.xpath("//button[@id='asc-signup-main-button']")).click();
        Thread.sleep(2000);
        Thread.sleep(2000);
        Thread.sleep(2000);
        Thread.sleep(2000);
        Thread.sleep(2000);
        Thread.sleep(2000);
        Thread.sleep(2000);

        new WebDriverWait(getDriver(), 200).until(ExpectedConditions.elementToBeClickable(By.id("tab-profile-dashboard")));
        getDriver().findElement(By.xpath("//*[@id='tab-profile-dashboard']")).isDisplayed();
        getDriver().findElement(By.id("tab-profile-dashboard")).isDisplayed();
    }

    @And("I go to my new requisition REQ")
    public void iGoToMyRequisition() {
        getDriver().findElement(By.xpath("//div[@class='hovicon btn-primary']//a[@id='header-requisitions']")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='asc-add-candidate']")));
    }

    @And("make sure the new applicant is visible REQ")
    public void makeSureTheNewApplicantIsVisible() {
        getDriver().findElement(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Interested!!!')]")));
        getDriver().findElement(By.xpath("//a[contains(text(),'Interested!!!')]")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ascendicon-people']")));
        getDriver().findElement(By.xpath("//div[contains(text(),'New Applicant')]")).isDisplayed();
    }

    @Then("I delete the new requisition REQ")
    public void iDeleteTheRequisition() throws Throwable {
        getDriver().get("https://testcommunity.ascendify.com/requisitions");
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='right-panel-link link asc-list-name highlight']")));
        Actions actions = new Actions(getDriver());
        WebElement right = getDriver().findElement(By.xpath("(//i[contains(@class,'fa fa-chevron-circle-right asc-list-more-information-arrow')])[1]"));
        actions.moveToElement(right).perform();
        WebElement drop = getDriver().findElement(By.xpath("//div[@class='asc-list-right-expand-holder clearfix']//div[@class='asc-client-menu asc-dropdown-parent']"));
        drop.click();

        getDriver().findElement(By.xpath("//span[@class='asc-tile-menu-item asc-list-archive-job link']")).click();
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(6000);
    }

    @And("I delete the new applicant REQ")
    public void iDeleteTheNewApplicant() throws Throwable {
        getDriver().findElement(By.xpath("//i[contains(@class,'fa fa-caret-down')]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//li[contains(text(),'Admin Console')]")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='user-search']")));
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//input[@id='user-search']")).sendKeys(randomEmail2);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(6000);
        getDriver().findElement(By.xpath("//i[@class='fa fa-chevron-down']")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//a[@class='action-call-deleteUser']")).click();
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success']")));
    }

    @And("I delete the new Recruiter REQ")
    public void iDeleteTheNewRecruiter() throws Throwable {
        getDriver().findElement(By.xpath("//input[@id='user-search']")).click();
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        Thread.sleep(2000);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        Thread.sleep(2000);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(4000);
        getDriver().findElement(By.xpath("//i[@class='fa fa-chevron-down']")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//a[@class='action-call-deleteUser']")).click();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success']")));
    }

    @And("I check each tab on the new requisition REQ")
    public void iCheckEachTabOnTheNewRequisitionREQ() throws Throwable {
        getDriver().findElement(By.xpath("//li[@id='tab-info']")).click();
        getDriver().findElement(By.xpath("//form[@id='asc-job-mod']//div[@class='asc-edit-readonly']")).isDisplayed();
        getDriver().findElement(By.xpath("(//div[@id='job-desc'])[1]")).isDisplayed();
        getDriver().findElement(By.xpath("(//div[@id='job-desc'])[2]")).isDisplayed();
        getDriver().findElement(By.xpath("//div[@id='job-compensation']")).isDisplayed();
        getDriver().findElement(By.xpath("//div[@id='job-justification']")).isDisplayed();
        getDriver().findElement(By.xpath("//div[@id='asc-job-custom-data']")).isDisplayed();
        getDriver().findElement(By.xpath("//div[@id='asc-job-custom-data']//button[@class='btn btn-primary asc-edit-icon btn-sm'][contains(text(),'Edit')]")).click();

        getDriver().findElement(By.xpath("//li[@id='tab-documents']")).click();
        getDriver().findElement(By.xpath("//button[@class='btn btn-sm btn-primary add-document-btn']")).isDisplayed();

        getDriver().findElement(By.xpath("//li[@id='tab-team']")).click();
        getDriver().findElement(By.xpath("//ul[@id='asc-hiring-team-holder']")).isDisplayed();
        getDriver().findElement(By.xpath("(//div[@class='wrap team-member_info clearfix'])[1]")).isDisplayed();
        Thread.sleep(20000);
        getDriver().findElement(By.xpath("//div[@id='interview-team-holder']")).isDisplayed();
        getDriver().findElement(By.xpath("(//div[@class='wrap team-member_info clearfix'])[2]")).isDisplayed();
        getDriver().findElement(By.xpath("//button[@id='asc-interview-setup-btn']")).isDisplayed();

        getDriver().findElement(By.xpath("//li[@id='tab-capabilities']")).click();
        getDriver().findElement(By.xpath("//div[@class='form__component']//div[contains(@class,'form__component')]")).isDisplayed();
        getDriver().findElement(By.xpath("//div[@class='btn-detele-all-capabilities btn-primary']")).isDisplayed();
        getDriver().findElement(By.xpath("//div[@class='option-holder']")).isDisplayed();

        getDriver().findElement(By.xpath("//li[@id='tab-questions']")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//div[@class='tile-list__row-edit workflow_automation']")).isDisplayed();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//div[contains(@class,'asc-survey-qualifying-select')]")).isDisplayed();

        getDriver().findElement(By.xpath("//li[@id='tab-screening']")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//div[@id='asc-job-screening-questions-select']")).isDisplayed();

        getDriver().findElement(By.xpath("//li[@id='tab-intake']")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//div[@id='asc-intake']")).isDisplayed();

        getDriver().findElement(By.xpath("//li[@id='tab-activities']")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//ul[@id='asc-user-expanded-tabs-sub']")).click();
        getDriver().findElement(By.xpath("//div[@class='asc-list-middle-inner-div']")).isDisplayed();

        getDriver().findElement(By.xpath("//li[@id='tab-notes']")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//textarea[@id='asc-note-comment']")).isDisplayed();
        getDriver().findElement(By.xpath("//div[@id='asc-notes']/div[@id='asc-note-comment-holder']/div[1]")).isDisplayed();

        getDriver().findElement(By.xpath("//li[@id='tab-workflows']")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//div[@id='asc-workflow-holder']")).isDisplayed();
        getDriver().findElement(By.xpath("//div[@id='asc-workflows']/div[@id='asc-workflow-container']")).isDisplayed();

        getDriver().findElement(By.xpath("//li[@id='tab-approvals']")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//input[@id='add-approver']")).isDisplayed();
        getDriver().findElement(By.xpath("//form[@id='asc-launch-approval']")).isDisplayed();
    }

    @And("I map the fields and import the .CSV file REQ")
    public void iMapTheFieldsAndImportTheCSVFileREQ() throws Throwable {

        Thread.sleep(20000);
        getDriver().findElement(By.xpath("//h3[@class='asc-admin-header']")).isDisplayed();

        try {
            for (int i = 0; i <= 10; i++) {
                WebElement ONE = getDriver().findElement(By.xpath("//select[@name='mapfield[" + i + "]']"));
                String textInsideONE = ONE.getAttribute("value");
                if (textInsideONE.isEmpty()) {
                    String selBoxNAME = "'mapfield[" + i + "]'";
                    String partialText = getDriver().findElement(By.xpath("//div[@id='right-system-panel']//tr[" + (i + 2) + "]//td[1]")).getText();
                    getDriver().findElement(By.xpath("//select[@name=" + selBoxNAME + "]")).click();
                    getDriver().findElement(By.xpath("//select[@name=" + selBoxNAME + "]//option[" + (i + 2) + "]")).click();
                    Thread.sleep(1000);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//button[contains(text(),'Import')]")).click();

        Thread.sleep(4000);
        getDriver().findElement(By.xpath("//li[contains(text(),'Your file has been queued for processing.  You will get an email when the process is complete.')]")).isDisplayed();
    }

    @And("I clean up {string} REQ")
    public void iCleanUpPT(String arg0) throws Throwable {
        if (arg0.equalsIgnoreCase("CSV")) {
            getDriver().findElement(By.xpath("//input[@id='full-header-search-input']")).sendKeys("VP Marketing");
            Thread.sleep(154200);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(4000);

            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='right-panel-link link asc-list-name highlight']")));
            Actions actions = new Actions(getDriver());
            WebElement right = getDriver().findElement(By.xpath("(//i[contains(@class,'fa fa-chevron-circle-right asc-list-more-information-arrow')])[1]"));
            actions.moveToElement(right).perform();
            WebElement drop = getDriver().findElement(By.xpath("//div[@class='asc-list-right-expand-holder clearfix']//div[@class='asc-client-menu asc-dropdown-parent']"));
            drop.click();

            getDriver().findElement(By.xpath("//span[@class='asc-tile-menu-item asc-list-archive-job link']")).click();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(8000);

            getDriver().findElement(By.xpath("//input[@id='full-header-search-input']")).click();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_A);
            robot.keyRelease(KeyEvent.VK_A);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_BACK_SPACE);
            robot.keyRelease(KeyEvent.VK_BACK_SPACE);
            getDriver().findElement(By.xpath("//input[@id='full-header-search-input']")).sendKeys("Classroom Teacher and Teacher Assistant");
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(4000);
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='right-panel-link link asc-list-name highlight']")));
            WebElement right2 = getDriver().findElement(By.xpath("(//i[contains(@class,'fa fa-chevron-circle-right asc-list-more-information-arrow')])[1]"));
            actions.moveToElement(right2).perform();
            WebElement drop2 = getDriver().findElement(By.xpath("//div[@class='asc-list-right-expand-holder clearfix']//div[@class='asc-client-menu asc-dropdown-parent']"));
            drop2.click();

            getDriver().findElement(By.xpath("//span[@class='asc-tile-menu-item asc-list-archive-job link']")).click();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(8000);
        }
    }

    @And("I navigate to a requisition with Test Community! org REQ")
    public void iNavigateToARequisitionWithTestCommunityOrgREQ() throws Throwable {
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//div[contains(text(),'Requisitions')]")).click();
        getDriver().findElement(By.xpath("//a[@id='view_all']")).click();
        Thread.sleep(6000);
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Test Community!')]")));
        getDriver().findElement(By.xpath("(//div[contains(text(),'Test Community!')]/../../../..//i[contains(@class,'fa fa-chevron-circle-right')])[1]")).click();
    }

    @Then("I add and save custom requisition field questions' answers REQ")
    public void iAddAndSaveCustomRequisitionFieldQuestionsAnswers() {
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='asc-job-custom-data']//button[contains(text(),'Edit')]")));
        getDriver().findElement(By.xpath("//div[@id='asc-job-custom-data']//button[contains(text(),'Edit')]")).click();

        try {
            java.util.List<WebElement> radio = getDriver().findElements(By.xpath("//div[@class='asc-survey-question-answer-radio'][1]//input[@type='radio']"));
            for (WebElement element : radio) {
                element.click();
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            java.util.List<WebElement> text = getDriver().findElements(By.xpath("//input[@class='asc-survey-question-answer']"));
            for (WebElement element : text) {
                String uuid = UUID.randomUUID().toString();
                element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
                element.sendKeys(Keys.BACK_SPACE);
                element.sendKeys(uuid);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            int j = getDriver().findElements(By.xpath("//a[contains(@class,'chosen-single chosen-default')]")).size();
            for (int i = 1; i <= j; i++) {
                if (getDriver().findElement(By.xpath("(//a[contains(@class,'chosen-single chosen-default')])[" + i + "]")).isDisplayed()) {
                    getDriver().findElement(By.xpath("(//a[contains(@class,'chosen-single chosen-default')])[" + i + "]")).click();
                    Robot robot = new Robot();
                    robot.keyPress(KeyEvent.VK_BACK_SPACE);
                    robot.keyRelease(KeyEvent.VK_BACK_SPACE);
                    robot.keyPress(KeyEvent.VK_DOWN);
                    robot.keyRelease(KeyEvent.VK_DOWN);
                    robot.keyPress(KeyEvent.VK_DOWN);
                    robot.keyRelease(KeyEvent.VK_DOWN);
                    robot.keyPress(KeyEvent.VK_ENTER);
                    robot.keyRelease(KeyEvent.VK_ENTER);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            int l = 0;
            l = getDriver().findElements(By.xpath("//div[contains(@id,'asc_question_csvq_')]")).size();
            for (int k = 1; k <= l; k++) {
                getDriver().findElement(By.xpath("(//div[contains(@id,'asc_question_csvq_')])[" + k + "]")).click();
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_BACK_SPACE);
                robot.keyRelease(KeyEvent.VK_BACK_SPACE);
                robot.keyPress(KeyEvent.VK_DOWN);
                robot.keyRelease(KeyEvent.VK_DOWN);
                robot.keyPress(KeyEvent.VK_DOWN);
                robot.keyRelease(KeyEvent.VK_DOWN);
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (getDriver().findElement(By.xpath("//textarea[@class='asc-survey-question-answer']")).isDisplayed()) {
                int l = getDriver().findElements(By.xpath("//textarea[@class='asc-survey-question-answer']")).size();
                for (int k = 1; k <= l; k++) {
                    String uuid = UUID.randomUUID().toString();
                    getDriver().findElement(By.xpath("(//textarea[@class='asc-survey-question-answer'])[" + k + "]")).click();
                    getDriver().findElement(By.xpath("(//textarea[@class='asc-survey-question-answer'])[" + k + "]")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
                    getDriver().findElement(By.xpath("(//textarea[@class='asc-survey-question-answer'])[" + k + "]")).sendKeys(Keys.BACK_SPACE);
                    getDriver().findElement(By.xpath("(//textarea[@class='asc-survey-question-answer'])[" + k + "]")).sendKeys(uuid);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (getDriver().findElement(By.xpath("//input[@class='asc-survey-question-answer asc-survey-question-answer-date  hasDatepicker']")).isDisplayed()) {
                int g = getDriver().findElements(By.xpath("//input[@class='asc-survey-question-answer asc-survey-question-answer-date  hasDatepicker']")).size();
                for (int h = 1; h <= g; h++) {
                    getDriver().findElement(By.xpath("(//input[@class='asc-survey-question-answer asc-survey-question-answer-date  hasDatepicker'])[" + h + "]")).click();
                    Robot robot = new Robot();
                    robot.keyPress(KeyEvent.VK_ENTER);
                    robot.keyRelease(KeyEvent.VK_ENTER);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            int x = 0;
            x = getDriver().findElements(By.xpath("//div[contains(@id,'asc_question_csvq_')]")).size();
            for (int y = 1; y <= x; y++) {
                getDriver().findElement(By.xpath("(//div[contains(@id,'asc_question_csvq_')])[" + y + "]")).click();
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_BACK_SPACE);
                robot.keyRelease(KeyEvent.VK_BACK_SPACE);
                robot.keyPress(KeyEvent.VK_DOWN);
                robot.keyRelease(KeyEvent.VK_DOWN);
                robot.keyPress(KeyEvent.VK_DOWN);
                robot.keyRelease(KeyEvent.VK_DOWN);
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            int f = getDriver().findElements(By.xpath("//iframe[contains(@title,'Rich Text Editor')]")).size();
            for (int g = 1; g <= f; g++) {
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("(//iframe[contains(@title,'Rich Text Editor')])[" + g + "]")));
                String uuid = UUID.randomUUID().toString();
                getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
                Thread.sleep(1000);
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_BACK_SPACE);
                robot.keyRelease(KeyEvent.VK_BACK_SPACE);
                getDriver().findElement(By.cssSelector("body")).sendKeys(uuid);
                Thread.sleep(1000);
                getDriver().switchTo().defaultContent();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            getDriver().switchTo().defaultContent();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='asc-dynamic-save-button']")));
            getDriver().findElement(By.xpath("//button[@id='asc-dynamic-save-button']")).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("I delete the document REQ")
    public void iDeleteTheDocumentREQ() throws Throwable {
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'RequisitionForm.png')]")));
        getDriver().findElement(By.xpath("//div[contains(text(),'RequisitionForm.png')]/../..//div[@class='asc-trash']")).click();
        getDriver().findElement(By.xpath("//button[@class='btn btn-xs btn-danger asc-del-confirm']")).click();
        Thread.sleep(2000);
    }

    @And("I navigate to {string} tab of a requisition REQ")
    public void iNavigateToTabOfARequisitionREQ(String arg0) throws Throwable {
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//div[contains(text(),'Requisitions')]")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//a[@id='view_all']")).click();
        Thread.sleep(6000);
        new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")));
        getDriver().findElement(By.xpath("(//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow'])[1]")).click();
        if (arg0.equalsIgnoreCase("Documents")) {
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='tab-documents']")));
            getDriver().findElement(By.xpath("//li[@id='tab-documents']")).click();
            getDriver().findElement(By.xpath("//li[@id='tab-documents']")).click();
        } else if (arg0.equalsIgnoreCase("Team")) {
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='tab-team']")));
            getDriver().findElement(By.xpath("//li[@id='tab-team']")).click();
            getDriver().findElement(By.xpath("//li[@id='tab-team']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='asc-hiring-team-holder']")));
            try {
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='asc-del-confirm dropbtn']//i[@class='fa fa-times']")));
                while (getDriver().findElement(By.xpath("//button[@class='asc-del-confirm dropbtn']//i[@class='fa fa-times']")).isDisplayed()) {
                    getDriver().findElement(By.xpath("//button[@class='asc-del-confirm dropbtn']//i[@class='fa fa-times']")).click();
                    Thread.sleep(2000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (arg0.equalsIgnoreCase("Skills")) {
            new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='tab-capabilities']")));
            getDriver().findElement(By.xpath("//li[@id='tab-capabilities']")).click();
            getDriver().findElement(By.xpath("//li[@id='tab-capabilities']")).click();
            Thread.sleep(2000);
        } else if (arg0.equalsIgnoreCase("Qualifying Questions")) {
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='tab-questions']")));
            getDriver().findElement(By.xpath("//li[@id='tab-questions']")).click();
            getDriver().findElement(By.xpath("//li[@id='tab-questions']")).click();
            getDriver().findElement(By.xpath("//li[@id='tab-questions']")).click();
        } else if (arg0.equalsIgnoreCase("Screening Questions")) {
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='tab-screening']")));
            getDriver().findElement(By.xpath("//li[@id='tab-screening']")).click();
            getDriver().findElement(By.xpath("//li[@id='tab-screening']")).click();
        } else if (arg0.equalsIgnoreCase("Intake Form")) {
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='tab-intake']")));
            getDriver().findElement(By.xpath("//li[@id='tab-intake']")).click();
            getDriver().findElement(By.xpath("//li[@id='tab-intake']")).click();
        } else if (arg0.equalsIgnoreCase("Activity")) {
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='tab-activities']")));
            getDriver().findElement(By.xpath("//li[@id='tab-activities']")).click();
            getDriver().findElement(By.xpath("//li[@id='tab-activities']")).click();
        } else if (arg0.equalsIgnoreCase("Notes")) {
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='tab-notes']")));
            getDriver().findElement(By.xpath("//li[@id='tab-notes']")).click();
            getDriver().findElement(By.xpath("//li[@id='tab-notes']")).click();
            getDriver().findElement(By.xpath("//li[@id='tab-notes']")).click();
        } else if (arg0.equalsIgnoreCase("Workflow Statuses")) {
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='tab-workflows']")));
            getDriver().findElement(By.xpath("//li[@id='tab-workflows']")).click();
            Thread.sleep(4000);
            getDriver().findElement(By.xpath("//span[contains(text(),'Statuses')]")).click();
            try {
                while (!(getDriver().findElement(By.xpath("//i[@class='fa fa-times icon']"))).isDisplayed()) {
                    getDriver().findElement(By.xpath("//span[contains(text(),'Statuses')]")).click();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            Thread.sleep(4000);
        } else if (arg0.equalsIgnoreCase("Approvals")) {
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='tab-approvals']")));
            getDriver().findElement(By.xpath("//li[@id='tab-approvals']")).click();
            Thread.sleep(2000);
        }
    }

    @Then("I add and remove primary users REQ")
    public void iAddAndRemovePrimaryUsersREQ() throws Throwable {
        getDriver().findElement(By.xpath("//input[contains(@id,'primary-hiring-manager')]")).sendKeys("Jason Ball");
        Thread.sleep(5000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);
        getDriver().findElement(By.xpath("//input[contains(@id,'primary-recruiter')]")).sendKeys("Hiral Bhatt");
        Thread.sleep(5000);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);
        getDriver().findElement(By.xpath("//input[contains(@id,'primary-sourcer')]")).sendKeys("Alexa Hayward");
        Thread.sleep(5000);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);
        getDriver().findElement(By.xpath("//input[contains(@id,'txt')]")).sendKeys("Matthew Zulch");
        Thread.sleep(5000);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);

        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='asc-del-confirm dropbtn']//i[@class='fa fa-times']")));
        try {
            while (getDriver().findElement(By.xpath("//button[@class='asc-del-confirm dropbtn']//i[@class='fa fa-times']")).isDisplayed()) {
                getDriver().findElement(By.xpath("//button[@class='asc-del-confirm dropbtn']//i[@class='fa fa-times']")).click();
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("I add and delete skills and categories REQ")
    public void iAddAndDeleteAllSkillsAndCategories() throws AWTException, Throwable {
        try {
            if (getDriver().findElement(By.xpath("//div[@class='btn-detele-all-capabilities btn-primary']")).isDisplayed()) {
                getDriver().findElement(By.xpath("//div[@class='btn-detele-all-capabilities btn-primary']")).click();
                getDriver().findElement(By.xpath("//div[@class='tool__tip confirm show']//button[contains(text(),'Confirm')]")).click();
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Add Skill Category')]")));
        getDriver().findElement(By.xpath("//div[contains(text(),'Add Skill Category')]")).click();
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(4000);
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Add Skill')]")));
        getDriver().findElement(By.xpath("//div[text()='Add Skill']")).click();
        Thread.sleep(5000);
        Actions action = new Actions(getDriver());
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(3000);

        WebElement select = getDriver().findElement(By.xpath("//div[text()='Add Skill']"));
        Point point = select.getLocation();
        int xcord = point.getX();
        System.out.println("Position of the webelement from left side is "+xcord +" pixels");
        int ycord = point.getY();
        System.out.println("Position of the webelement from top side is "+ycord +" pixels");

//        Actions action = new Actions(getDriver());
        //clicking on the logo based on x coordinate and y coordinate
        //you will be redirecting to the home page of softwaretestingmaterial.com
        action.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN).build().perform();
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].click()", select);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", select);
        Thread.sleep(500);
//        action.moveToElement(select, xcord, ycord+50).click().build().perform();

//        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].click()", select);
//        Actions builder = new Actions(getDriver());
        action.moveToElement(select, 10, 50).click().build().perform();
//        action.moveToElement(select).moveByOffset(10,100).click().perform();
//        Select dropdown = new Select(getDriver().findElement(By.xpath("//div[contains(@class,'select-skills-tags')]")));
//        dropdown.selectByVisibleText("Native");
        Thread.sleep(6000);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    @Then("I add and delete qualifying questions REQ")
    public void iAddAndDeleteAllQualifyingQuestionsREQ() throws AWTException, Throwable {
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Qualifying Questions')]")));
        getDriver().findElement(By.xpath("//span[contains(text(),'Add qualifying questions')]")).click();
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//div[contains(@class,'asc-survey-qualifying-select')]")).click();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);

        try {
            int j = getDriver().findElements(By.xpath("//span[@class='asc-survey-question__title asc-statement-tile__title']")).size();
            for (int i = 1; i <= j; i++) {
                getDriver().findElement(By.xpath("(//span[@class='asc-survey-question__title asc-statement-tile__title'])[" + i + "]")).click();
                Thread.sleep(2000);
                getDriver().findElement(By.xpath("(//i[@class='fa fa-times asc-survey-question__remove asc-statement-tile__remove'])[" + i + "]")).click();
                Thread.sleep(3000);
            }


            while (getDriver().findElement(By.xpath("//span[@class='asc-survey-question__title asc-statement-tile__title']")).isDisplayed()) {
                getDriver().findElement(By.xpath("//span[@class='asc-survey-question__title asc-statement-tile__title']")).click();
                getDriver().findElement(By.xpath("//i[@class='fa fa-times asc-survey-question__remove asc-statement-tile__remove']")).click();
                Thread.sleep(3000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("I add and delete screening questions REQ")
    public void iAddAndDeleteScreeningQuestionsREQ() throws AWTException, Throwable {
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Screening Questions')]")));
        getDriver().findElement(By.xpath("//span[contains(text(),'Add screening questions')]")).click();
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
        getDriver().findElement(By.xpath("//div[contains(@class,'asc-survey-screening-select')]")).click();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);

        try {
            int j = getDriver().findElements(By.xpath("//span[@class='asc-survey-question__title asc-statement-tile__title']")).size();
            for (int i = 1; i <= j; i++) {
                getDriver().findElement(By.xpath("(//span[@class='asc-survey-question__title asc-statement-tile__title'])[" + i + "]")).click();
                Thread.sleep(2000);
                getDriver().findElement(By.xpath("(//i[@class='fa fa-times asc-survey-question__remove asc-statement-tile__remove'])[" + i + "]")).click();
                getDriver().findElement(By.xpath("(//i[@class='fa fa-times asc-survey-question__remove asc-statement-tile__remove'])[" + i + "]")).click();
                Thread.sleep(3000);
            }

            while (getDriver().findElement(By.xpath("//span[@class='asc-survey-question__title asc-statement-tile__title']")).isDisplayed()) {
                getDriver().findElement(By.xpath("//span[@class='asc-survey-question__title asc-statement-tile__title']")).click();
                getDriver().findElement(By.xpath("//i[@class='fa fa-times asc-survey-question__remove asc-statement-tile__remove']")).click();
                Thread.sleep(3000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("I edit and save intake form REQ")
    public void iAddAndDeleteIntakeFormREQ() throws Throwable {
        getDriver().findElement(By.xpath("//div[@class='asc-survey-question']")).click();

        java.util.List<WebElement> radio = getDriver().findElements(By.xpath("//div[@class='asc-survey-question-answer-radio'][1]//input[@type='radio']"));
        for (WebElement element : radio) {
            try {
                element.click();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Thread.sleep(1000);
        }

        java.util.List<WebElement> text = getDriver().findElements(By.xpath("//input[@class='asc-survey-question-answer']"));
        for (WebElement element : text) {
            String uuid = UUID.randomUUID().toString();
            try {
                element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
                element.sendKeys(Keys.BACK_SPACE);
                element.sendKeys(uuid);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Thread.sleep(1000);
        }

        try {
            java.util.List<WebElement> reqans = getDriver().findElements(By.xpath("//input[@class='asc-survey-question-answer required']"));
            for (WebElement element : reqans) {
                String uuid = UUID.randomUUID().toString();
                element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
                element.sendKeys(Keys.BACK_SPACE);
                element.sendKeys(uuid);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            int j = getDriver().findElements(By.xpath("//a[contains(@class,'chosen-single chosen-default')]")).size();
            for (int i = 1; i <= j; i++) {
                if (getDriver().findElement(By.xpath("(//a[contains(@class,'chosen-single chosen-default')])[" + i + "]")).isDisplayed()) {
                    getDriver().findElement(By.xpath("(//a[contains(@class,'chosen-single chosen-default')])[" + i + "]")).click();
                    Robot robot = new Robot();
                    robot.keyPress(KeyEvent.VK_BACK_SPACE);
                    robot.keyRelease(KeyEvent.VK_BACK_SPACE);
                    robot.keyPress(KeyEvent.VK_DOWN);
                    robot.keyRelease(KeyEvent.VK_DOWN);
                    robot.keyPress(KeyEvent.VK_DOWN);
                    robot.keyRelease(KeyEvent.VK_DOWN);
                    robot.keyPress(KeyEvent.VK_ENTER);
                    robot.keyRelease(KeyEvent.VK_ENTER);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        int w = 0;
        w = getDriver().findElements(By.xpath("//div[contains(@id,'asc_question_csvq_')]")).size();
        for (int k = 1; k <= w; k++) {
            try {
                getDriver().findElement(By.xpath("(//div[contains(@id,'asc_question_csvq_')])[" + k + "]")).click();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_BACK_SPACE);
            robot.keyRelease(KeyEvent.VK_BACK_SPACE);
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        }


        try {
            if (getDriver().findElement(By.xpath("//textarea[@class='asc-survey-question-answer']")).isDisplayed()) {
                int l = getDriver().findElements(By.xpath("//textarea[@class='asc-survey-question-answer']")).size();
                for (int k = 1; k <= l; k++) {
                    String uuid = UUID.randomUUID().toString();
                    getDriver().findElement(By.xpath("(//textarea[@class='asc-survey-question-answer'])[" + k + "]")).click();
                    getDriver().findElement(By.xpath("(//textarea[@class='asc-survey-question-answer'])[" + k + "]")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
                    getDriver().findElement(By.xpath("(//textarea[@class='asc-survey-question-answer'])[" + k + "]")).sendKeys(Keys.BACK_SPACE);
                    getDriver().findElement(By.xpath("(//textarea[@class='asc-survey-question-answer'])[" + k + "]")).sendKeys(uuid);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (getDriver().findElement(By.xpath("//input[@class='asc-survey-question-answer asc-survey-question-answer-date required hasDatepicker']")).isDisplayed()) {
                getDriver().findElement(By.xpath("//input[@class='asc-survey-question-answer asc-survey-question-answer-date required hasDatepicker']")).click();
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            List<WebElement> me = getDriver().findElements(By.xpath("//div[@id='asc-staff-aboutme-one']//label[1]"));
            for (WebElement element : me) {
                String uuid = UUID.randomUUID().toString();
                element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
                element.sendKeys(Keys.BACK_SPACE);
                element.sendKeys(uuid);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            int f = getDriver().findElements(By.xpath("//iframe[contains(@title,'Rich Text Editor')]")).size();
            for (int g = 1; g <= f; g++) {
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("(//iframe[contains(@title,'Rich Text Editor')])[" + g + "]")));
                String uuid = UUID.randomUUID().toString();
                getDriver().findElement(By.cssSelector("body")).click();
                getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
                Thread.sleep(1000);
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_BACK_SPACE);
                robot.keyRelease(KeyEvent.VK_BACK_SPACE);
                getDriver().findElement(By.cssSelector("body")).sendKeys(uuid);
                Thread.sleep(1000);
                getDriver().switchTo().defaultContent();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='rating__container']")));
            if (getDriver().findElement(By.xpath("//div[@class='rating__container']")).isDisplayed()) {
                getDriver().findElement(By.xpath("(//label[@class='rating--dark '])[3]")).click();
                Thread.sleep(1000);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        getDriver().switchTo().defaultContent();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='asc-dynamic-save-button']")));
        getDriver().findElement(By.xpath("//button[@id='asc-dynamic-save-button']")).click();
        Thread.sleep(4000);
    }

    @Then("I check all the activities REQ")
    public void checkAllTheActivitiesREQ() throws Throwable {
        int sections = getDriver().findElements(By.xpath("//ul[@id='asc-user-expanded-tabs-sub']//li")).size();
        for (int a = 1; a <= sections; a = a + 2) {
            Thread.sleep(200);
            getDriver().findElement(By.xpath("(//ul[@id='asc-user-expanded-tabs-sub']//li)[" + a + "]")).click();
            Thread.sleep(2000);
            getDriver().findElement(By.xpath("//div[@class='asc-note-timer']")).isDisplayed();
            Thread.sleep(2000);
        }
    }

    @Then("I add and delete private and public notes REQ")
    public void iAddAndDeletePrivateAndPublicNotes() throws Throwable {
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='asc-note-comment']")));
        getDriver().findElement(By.xpath("//textarea[@id='asc-note-comment']")).sendKeys("Public Note");
        getDriver().findElement(By.xpath("//input[@id='asc-note-share']")).sendKeys("Hiral");
        Thread.sleep(4000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        getDriver().findElement(By.xpath("//button[@id='asc-note-save-btn']")).click();
        Thread.sleep(5000);

        getDriver().findElement(By.xpath("//textarea[@id='asc-note-comment']")).sendKeys("Private Note");
        getDriver().findElement(By.xpath("//input[@id='private']")).click();
        getDriver().findElement(By.xpath("//input[@id='asc-note-share']")).sendKeys("Jason");
        Thread.sleep(4000);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        getDriver().findElement(By.xpath("//button[@id='asc-note-save-btn']")).click();
        Thread.sleep(4000);

        int j = getDriver().findElements(By.xpath("//div[contains(@class,'pull-right asc-trash btn-danger')]")).size();
        for (int i = 1; i <= j; i++) {
            getDriver().findElement(By.xpath("(//div[contains(@class,'pull-right asc-trash btn-danger')])[" + i + "]")).click();
            getDriver().findElement(By.xpath("(//div[contains(@class,'pull-right asc-trash btn-danger')])[" + i + "]")).click();
            getDriver().findElement(By.xpath("(//div[contains(@class,'pull-right asc-trash btn-danger')])[" + i + "]")).click();
            Thread.sleep(2000);
            getDriver().findElement(By.xpath("(//button[contains(text(),'Confirm')])[" + i + "]")).click();
        }
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//div[@id='asc-note-comment-null-msg']")).isDisplayed();
    }

    @Then("I add and delete workflow statuses REQ")
    public void iAddAndDeleteWorkflowStatusesREQ() throws AWTException, Throwable {
        Thread.sleep(2000);
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[contains(@class,'fa fa-times icon')]")));
        getDriver().findElement(By.xpath("//div[@class='folder__header']")).click();
        getDriver().findElement(By.xpath("//i[contains(@class,'fa fa-times icon')]")).click();
        Thread.sleep(4000);

        WebElement select = getDriver().findElement(By.xpath("//*[contains(text(),'Select a Workflow')]"));
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].click()", select);

        Thread.sleep(2000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
        try {
            while (getDriver().findElement(By.xpath("//button[contains(@class,'modal__button modal__button--submit btn btn-primary')]")).isDisplayed()) {
                getDriver().findElement(By.xpath("//button[contains(@class,'modal__button modal__button--submit btn btn-primary')]")).click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Thread.sleep(4000);
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[contains(@class,'fa fa-trash-o action-icon icon')])[1]")));
        getDriver().findElement(By.xpath("(//i[contains(@class,'fa fa-trash-o action-icon icon')])[1]")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("(//button[contains(text(),'Confirm')])[1]")).click();
        Thread.sleep(4000);
    }

    @Then("I add and send approval request REQ")
    public void iAddAndSendApprovalRequestREQ() throws AWTException, Throwable {
        try {
            if (getDriver().findElement(By.xpath("//input[@id='add-approver']")).isDisplayed()) {
                getDriver().findElement(By.xpath("//input[@id='add-approver']")).sendKeys("Email Verification");
                Thread.sleep(4000);
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_DOWN);
                robot.keyRelease(KeyEvent.VK_DOWN);
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                Thread.sleep(2000);
                getDriver().findElement(By.xpath("//input[@id='seq-routing-chk']")).click();
                getDriver().findElement(By.xpath("//a[@id='asc-launch-approval-btn']")).click();
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='link']")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//a[@class='link']")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Reminder Email was sent')]")));
        getDriver().findElement(By.xpath("//li[contains(text(),'Reminder Email was sent')]")).isDisplayed();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//a[@id='asc-restart-approval-btn']")).click();
        getDriver().findElement(By.xpath("//button[@class='btn btn-xs btn-success asc-confirm-btn']")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='asc-trash highlight']")));
        getDriver().findElement(By.xpath("//div[@class='asc-trash highlight']")).click();
        getDriver().findElement(By.xpath("//button[@class='btn btn-xs btn-danger asc-del-confirm']")).click();
        Thread.sleep(2000);
    }
}