package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java8.Th;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.util.UUID;

import static support.TestContext.getDriver;

public class ReqStepDefs {
    @Given("I navigate to {string} page")
    public void iNavigateToPage(String arg0) {
        if (arg0.equalsIgnoreCase("Test Community login")) {
            getDriver().get("https://testcommunity.ascendify.com/");
        } else if (arg0.equalsIgnoreCase("TC Login")) {
            getDriver().get("https://master.ascendify.net/");
        }
    }

    @When("I sign in as super admin")
    public void iSignInAsSuperAdmin() throws Throwable {
        getDriver().findElement(By.xpath("//input[@id='id_username']")).click();
        getDriver().findElement(By.xpath("//input[@id='id_username']")).sendKeys("tessy.anicattumathew@ascendify.com");
        getDriver().findElement(By.xpath("//input[@id='id_password']")).click();
        getDriver().findElement(By.xpath("//input[@id='id_password']")).sendKeys("Mac123q!");
        getDriver().findElement(By.xpath("//button[@id='asc-signin-btn']")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Main Menu tab')]")));
        getDriver().findElement(By.xpath("//span[contains(text(),'Main Menu tab')]")).isDisplayed();
    }

    @And("I create a person's profile with role Recruiter")
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

    @Then("I sign in as the new Recruiter")
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

    @And("I create a new requisition")
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
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        getDriver().findElement(By.xpath("//input[@id='recruiter']")).sendKeys("New Recruiter");

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

    @And("I change status to Open")
    public void iChangeStatusToOpen() throws Throwable {
        getDriver().findElement(By.xpath("//button[@id='asc-status-btn']")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//a[text()='Open']")).click();
        Thread.sleep(6000);
    }

    @And("I sign out")
    public void iSignOut() throws Throwable {
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//div[@id='global-profile-dropdown-widget-container']")).click();
        Thread.sleep(1000);
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='asc-sign-out-button']")));
        getDriver().findElement(By.xpath("//li[@id='asc-sign-out-button']")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='id_username']")));
    }

    @And("I sign out from Talent Community")
    public void iSignOutFromTalentCommunity() {
        getDriver().findElement(By.xpath("//a[@class='dropdown-toggle asc-user-menu-link']")).click();
        getDriver().findElement(By.xpath("//a[@class='btn btn-danger']")).click();
        new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-default safari_redirect_link']")));
    }

    @And("I search for that requisition")
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

    @And("I apply for that requisition")
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

    @And("I go to my new requisition")
    public void iGoToMyRequisition() {
        getDriver().findElement(By.xpath("//div[@class='hovicon btn-primary']//a[@id='header-requisitions']")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='asc-add-candidate']")));
    }

    @And("make sure the new applicant is visible")
    public void makeSureTheNewApplicantIsVisible() {
        getDriver().findElement(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Interested!!!')]")));
        getDriver().findElement(By.xpath("//a[contains(text(),'Interested!!!')]")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ascendicon-people']")));
        getDriver().findElement(By.xpath("//div[contains(text(),'New Applicant')]")).isDisplayed();
    }

    @Then("I delete the new requisition")
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

    @And("I delete the new applicant")
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

    @And("I delete the new Recruiter")
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
    }
}
