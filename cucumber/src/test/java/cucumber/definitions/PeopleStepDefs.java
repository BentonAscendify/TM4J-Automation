package cucumber.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static cucumber.support.TestContext.getDriver;

public class PeopleStepDefs {

    @Given("I navigate to {string} page PT")
    public void iNavigateToPage(String arg0) {
        getDriver().get("https://testcommunity.ascendify.com/");
    }

    @When("I sign in PT")
    public void iSignIn() {
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='id_username']")));
        getDriver().findElement(By.xpath("//input[@id='id_username']")).sendKeys("tessy.anicattumathew@ascendify.com");
        getDriver().findElement(By.xpath("//input[@id='id_password']")).sendKeys("Mac123q!");
        getDriver().findElement(By.xpath("//button[@id='asc-signin-btn']")).click();
    }

    @And("I click on {string} button PT")
    public void iClickOnButton(String arg0) throws Throwable {
        if (arg0.equalsIgnoreCase("New")) {
            getDriver().findElement(By.xpath("//span[@id='asc-add-candidate']")).click();
        } else if (arg0.equalsIgnoreCase("Import")) {
            Thread.sleep(2000);
            getDriver().findElement(By.xpath("//button[contains(text(),'Import')]")).click();
        } else if (arg0.equalsIgnoreCase("Add Profiles")) {
            getDriver().findElement(By.xpath("//button[@id='asc-add-user-btn']")).click();
        }
    }

    @Then("{string} page is displayed PT")
    public void pageIsDisplayed(String arg0) throws Throwable {
        if (arg0.equalsIgnoreCase("Main Menu")) {
            Thread.sleep(8000);
            new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Main Menu tab')]")));
            getDriver().findElement(By.xpath("//span[contains(text(),'Main Menu tab')]")).isDisplayed();
        } else if (arg0.equalsIgnoreCase("Data Mapping")) {
            Thread.sleep(20000);
            getDriver().findElement(By.xpath("//h3[@class='asc-admin-header']")).isDisplayed();
        }
    }

    @And("I click on {string} tab PT")
    public void iClickOnTa(String arg0) throws Throwable {
        if (arg0.equalsIgnoreCase("People")) {
            Thread.sleep(2000);
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'People')]")));
            getDriver().findElement(By.xpath("//div[contains(text(),'People')]")).click();
        } else if (arg0.equalsIgnoreCase("Responses")) {
            Thread.sleep(2000);
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='tab-staff-aboutme-one']")));
            getDriver().findElement(By.xpath("//li[@id='tab-staff-aboutme-one']")).click();
        }
    }

    @And("I navigate to {string} PT")
    public void iNavigateTo(String arg0) throws Throwable {
        Thread.sleep(2000);
        if (arg0.equalsIgnoreCase("Upload a CSV file")) {
            getDriver().findElement(By.xpath("//a[@id='asc-add-candidate-csv']")).click();
        } else if (arg0.equalsIgnoreCase("Bulk Add")) {
            getDriver().findElement(By.xpath("//a[@id='asc-add-bulk-candidate-manually']")).click();
        }
    }

    @And("I choose my file to be uploaded by clicking {string} button PT")
    public void iChooseMyFileToBeUploadedByClickingButton(String arg0) throws AWTException, Throwable, InterruptedException {
        Thread.sleep(2000);
        try {
            if (arg0.equalsIgnoreCase("Upload a File")) {
                Actions actions = new Actions(getDriver());
                actions.moveToElement(getDriver().findElement(By.id("asc-bulk-upload-div")));
                getDriver().findElement(By.id("asc-bulk-upload-div")).click();
                Thread.sleep(2000);
                URL resumeUrl = getClass().getClassLoader().getResource("resumes/profiles-import.csv");
                if (resumeUrl != null) {
                    File resumeFile = new File(resumeUrl.getFile());
                    uploadFile(resumeFile.getAbsolutePath());
                    Thread.sleep(2000);
                } else {
                    throw new Exception("Failed to find resume absolute path");
                }
                Thread.sleep(2000);
            } else if (arg0.equalsIgnoreCase("Drop Files")) {
                Actions actions = new Actions(getDriver());
                actions.moveToElement(getDriver().findElement(By.id("asc-bulk-upload-users-form")));
                getDriver().findElement(By.id("asc-bulk-upload-users-form")).click();
                Thread.sleep(2000);
                URL resumeUrl = getClass().getClassLoader().getResource("resumes/Records");
                if (resumeUrl != null) {
                    File resumeFile = new File(resumeUrl.getFile());
                    uploadFile(resumeFile.getAbsolutePath());
                    Thread.sleep(2000);
                } else {
                    throw new Exception("Failed to find resume absolute path");
                }
                Thread.sleep(2000);
            }
        } catch (Exception exp) {
            exp.printStackTrace();
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

            robot.mouseMove(250, 250);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_A);
            robot.keyRelease(KeyEvent.VK_A);
            Thread.sleep(2000);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    @And("I map the fields in the .CSV file to the appropriate fields in the application PT")
    public void iMapTheFieldsInTheCSVFileToTheAppropriateFieldsInTheApplication() throws Throwable {
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
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//select[contains(@name,'ascendify[client_user_partner_org]')]")));
        getDriver().findElement(By.xpath("//select[contains(@name,'ascendify[client_user_partner_org]')]")).click();
        getDriver().findElement(By.xpath("//select[contains(@name,'ascendify[client_user_partner_org]')]//option[contains(text(),'Ascendify')]")).click();
    }

    @Then("{string} message is displayed PT")
    public void messageIsDisplayed(String arg0) throws Throwable {
        if (arg0.equalsIgnoreCase("CSV processing")) {
            Thread.sleep(4000);
            getDriver().findElement(By.xpath("//li[contains(text(),'Your file has been queued for processing.  You will get an email when the process is complete.')]")).isDisplayed();
        } else if (arg0.equalsIgnoreCase("Bulk Add processing")) {
            Thread.sleep(2000);
            getDriver().findElement(By.xpath("//li[contains(text(),'New users are being processed.')]")).isDisplayed();
        }
    }

    @And("I fill in empty fields PT")
    public void iFillInEmptyFields() throws Throwable {

        Thread.sleep(2000);
        WebElement Status = getDriver().findElement(By.xpath("//select[@id='asc-client-crm-status-field']"));
        String textInsideStatus = Status.getAttribute("value");
        if (textInsideStatus.isEmpty()) {
            getDriver().findElement(By.xpath("//select[@id='asc-client-crm-status-field']")).click();
            getDriver().findElement(By.xpath("//select[@id='asc-client-crm-status-field']//option[contains(text(),'New')]")).click();
            Thread.sleep(2000);
        }

        getDriver().findElement(By.xpath("//div[@id='asc_group_select_chosen']")).click();
        getDriver().findElement(By.xpath("//div[@id='asc_group_select_chosen']//input")).sendKeys("Candidate", Keys.ENTER);
        Thread.sleep(2000);

        WebElement Source = getDriver().findElement(By.xpath("//select[@id='asc-basic-source-field']"));
        String textInsideSource = Source.getAttribute("value");
        if (textInsideSource.isEmpty()) {
            getDriver().findElement(By.xpath("//select[@id='asc-basic-source-field']")).click();
            getDriver().findElement(By.xpath("//select[@id='asc-basic-source-field']//option[contains(text(),'Employee Referrals')]")).click();
        }
        WebElement Recruit = getDriver().findElement(By.xpath("//select[@id='asc-basic-recruiter-field']"));
        String textInsideRecruit = Recruit.getAttribute("value");
        if (textInsideRecruit.isEmpty()) {
            getDriver().findElement(By.xpath("//select[@id='asc-basic-recruiter-field']")).click();
            getDriver().findElement(By.xpath("//select[@id='asc-basic-recruiter-field']//option[contains(text(),'Alex Selenium1')]")).click();
            Thread.sleep(2000);
        }

        getDriver().findElement(By.xpath("//input[@id='asc-add-user-quick-comment']")).sendKeys("Excellent Candidates");
        Thread.sleep(2000);

        WebElement Org = getDriver().findElement(By.xpath("//select[@id='asc-basic-recruiter-field']"));
        String textInsideOrg = Org.getAttribute("value");
        if (textInsideOrg.isEmpty()) {
            getDriver().findElement(By.xpath("//select[contains(@name,'ascendify[client_user_partner_org]')]")).click();
            getDriver().findElement(By.xpath("//select[contains(@name,'ascendify[client_user_partner_org]')]//option[contains(text(),'Test Community!')]")).click();
            Thread.sleep(2000);
            getDriver().findElement(By.xpath("//a[@id='asc-add-new-org-text-box']")).click();
            getDriver().findElement(By.xpath("//select[contains(@name,'ascendify[client_user_partner_org]')]")).click();
            getDriver().findElement(By.xpath("//select[contains(@name,'ascendify[client_user_partner_org]')]//option[contains(text(),'Tessy's Org')]")).click();
            Thread.sleep(2000);
        }
        getDriver().findElement(By.xpath("//input[@id='asc-add-user-tag-input']")).sendKeys("Hire");
        getDriver().findElement(By.xpath("//button[@id='asc-asd-user-tag-btn']")).click();
        Thread.sleep(2000);

    }

    @And("I click on the right arrow of a candidate PT")
    public void iClickOnTheRightArrowOfACandidate() {
        getDriver().findElement(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")).click();
    }

    @And("I consider for new opportunity PT")
    public void iConsiderForNewOpportunity() throws Throwable {
        Thread.sleep(6000);
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='right-system-panel']")));
        Thread.sleep(5000);
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='asc-show-next-opportunity-btn']")));
        getDriver().findElement(By.xpath("//span[@id='asc-show-next-opportunity-btn']")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='asc-next-opp-select']")));
        getDriver().findElement(By.xpath("//select[@id='asc-next-opp-select']")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='asc-next-opp-select']//option[2]")));
        getDriver().findElement(By.xpath("//select[@id='asc-next-opp-select']//option[2]")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='asc-next-opp-btn']")));
        getDriver().findElement(By.xpath("//a[@id='asc-next-opp-btn']")).click();
    }

    @Then("candidate has been {string} PT")
    public void candidateHasBeen(String arg0) throws Throwable {
        Thread.sleep(4000);
        try {
            new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Move Forward')]")));
            getDriver().findElement(By.xpath("//span[contains(text(),'Move Forward')]")).isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
        }

        getDriver().findElement(By.xpath("//div[contains(text(),'" + org + "')]/../../../..//i[contains(@class,'fa fa-chevron-circle-right asc-list-more-information-arrow')]")).click();
        Thread.sleep(6000);
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='right-system-panel']")));
        Thread.sleep(5000);
        new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='asc-show-next-opportunity-btn']")));
        getDriver().findElement(By.xpath("//span[@id='asc-show-next-opportunity-btn']")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//select[@id='asc-next-opp-select']")).click();
        Thread.sleep(2000);
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='asc-next-opp-select']//option[contains(text(),'" + req + "')]")));
        getDriver().findElement(By.xpath("//select[@id='asc-next-opp-select']//option[contains(text(),'" + req + "')]")).click();
        Thread.sleep(2000);
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='asc-next-opp-btn']")));
        getDriver().findElement(By.xpath("//a[@id='asc-next-opp-btn']")).click();
        new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Move Forward')]")));
        getDriver().findElement(By.xpath("//span[contains(text(),'Move Forward')]")).isDisplayed();
    }

    @And("I move the candidate through different hiring status to Onsite Interview PT")
    public void iMoveTheCandidateThroughDifferentHiringStatus() throws Throwable {
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//span[contains(text(),'Move Forward')]")).click();
        Thread.sleep(2000);
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Preliminary Phone Screen')]")));
        getDriver().findElement(By.xpath("//a[contains(text(),'Preliminary Phone Screen')]")).click();
        new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Current step: Preliminary Phone Screen')]")));
        getDriver().findElement(By.xpath("//span[contains(text(),'Current step: Preliminary Phone Screen')]")).isDisplayed();
        Thread.sleep(2000);

        getDriver().findElement(By.xpath("//span[contains(text(),'Move Forward')]")).click();
        Thread.sleep(2000);
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Onsite Interview')]")));
        getDriver().findElement(By.xpath("//a[contains(text(),'Onsite Interview')]")).click();
        new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Current step: Onsite Interview')]")));
        getDriver().findElement(By.xpath("//span[contains(text(),'Current step: Onsite Interview')]")).isDisplayed();
        Thread.sleep(2000);
        try {
            if (getDriver().findElement(By.xpath("//button[@id='asc-cancel-msg-btn']")).isDisplayed()) {
                getDriver().findElement(By.xpath("//button[@id='asc-cancel-msg-btn']")).click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Thread.sleep(2000);
    }

    @And("I drag and drop candidates to folder PT")
    public void iDragAndDropCandidatesToFolder() throws Throwable {
        try {
            String BefCount = getDriver().findElement(By.xpath("(//a[@class='link clearfix  ui-droppable'])[1]/..//span[@class='link-count']")).getText();
            int InitialCount = Integer.parseInt(BefCount);

            String FirstCount = getDriver().findElement(By.xpath("(//a[@class='link clearfix  ui-droppable'])[1]/..//span[@class='link-count']")).getText();
            System.out.println("Initial Count = " + FirstCount);

            getDriver().findElement(By.xpath("(//div[@class='asc-list-middle-inner-div'])[1]")).click();
            getDriver().findElement(By.xpath("(//div[@class='asc-list-move-tab ui-draggable-handle']//span[@class='asc-multi-box'])[1]")).click();
            getDriver().findElement(By.xpath("(//div[@class='asc-list-middle-inner-div'])[2]")).click();
            getDriver().findElement(By.xpath("(//div[@class='asc-list-move-tab ui-draggable-handle']//span[@class='asc-multi-box'])[2]")).click();
            getDriver().findElement(By.xpath("//span[contains(@class,'asc-multi-box')]//i[contains(@class,'fa fa-check')]")).isDisplayed();

            WebElement From = getDriver().findElement(By.xpath("(//i[@class='fa fa-ellipsis-v'])[2]"));
            WebElement To = getDriver().findElement(By.xpath("(//a[@class='link clearfix  ui-droppable'])[1]"));
            Actions act = new Actions(getDriver());
            act.dragAndDrop(From, To).build().perform();

            Thread.sleep(8000);
            getDriver().navigate().refresh();
            String AftCount = getDriver().findElement(By.xpath("(//a[@class='link clearfix  ui-droppable'])[1]/..//span[@class='link-count']")).getText();
            int UpdatedCount = Integer.parseInt(AftCount);
            getDriver().navigate().refresh();
            System.out.println("Updated Count = " + AftCount);

//        Cleanup
            if (UpdatedCount != InitialCount) {
                getDriver().findElement(By.xpath("(//a[@class='link clearfix  ui-droppable'])[1]")).click();
                Thread.sleep(2000);
                getDriver().findElement(By.xpath("//span[@id='asc-sort-by-div']")).click();
                Thread.sleep(2000);
                getDriver().findElement(By.xpath("//a[@data-field='client_users.created DESC']")).click();
                Thread.sleep(2000);
                getDriver().findElement(By.xpath("(//div[@class='asc-list-middle-inner-div'])[1]")).click();
                getDriver().findElement(By.xpath("(//div[@class='asc-list-move-tab ui-draggable-handle']//span[@class='asc-multi-box'])[1]")).click();
                getDriver().findElement(By.xpath("(//div[@class='asc-list-middle-inner-div'])[2]")).click();
                getDriver().findElement(By.xpath("(//div[@class='asc-list-move-tab ui-draggable-handle']//span[@class='asc-multi-box'])[2]")).click();
                getDriver().findElement(By.xpath("//span[contains(@class,'asc-multi-box')]//i[contains(@class,'fa fa-check')]")).isDisplayed();
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='asc-action-div']")));
                getDriver().findElement(By.xpath("//span[@id='asc-action-div']")).click();
                getDriver().findElement(By.xpath("//a[@class='ascbulk-remove-from-list']")).click();
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                Thread.sleep(8000);
                new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Your records are being removed and your changes will be reflected soon')]")));
            } else {
                System.out.println("Those candidates are already present in this folder");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("I edit and save all questions PT")
    public void iEditAndSaveAllQuestions() throws Throwable {

        int sections = getDriver().findElements(By.xpath("//ul[@id='asc-responses-expanded-tabs-sub']//li")).size();
        for (int a = 1; a <= sections; a = a + 2) {
            try {
                Thread.sleep(200);
                getDriver().findElement(By.xpath("(//ul[@id='asc-responses-expanded-tabs-sub']//li)[" + a + "]")).click();
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                getDriver().findElement(By.xpath("//body/div[@id='wrap']/div[@id='container']/div[@id='right-system-panel']/div[@id='inner-right-system-panel']/div[@id='asc-app-record-profile-view']/div[@id='asc-job-maindata']/div[@id='asc-extended-tabs-output-holder']/div[@id='asc-staff-aboutme-one']/div[@id='personal-sub-tab']/div[@id='asc-user-custom-data']/div[@class='asc-edit-block-inner']/div[@class='asc-edit-div']/div[@class='asc-edit-readonly']/div[1]")).click();
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                List<WebElement> radio = getDriver().findElements(By.xpath("//div[@class='asc-survey-question-answer-radio'][1]//input[@type='radio']"));
                for (WebElement element : radio) {
                    element.click();
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                List<WebElement> text = getDriver().findElements(By.xpath("//input[@class='asc-survey-question-answer']"));
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
                List<WebElement> text = getDriver().findElements(By.xpath("//input[@class='asc-survey-question-answer required']"));
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
                    getDriver().findElement(By.xpath("//input[@class='asc-survey-question-answer asc-survey-question-answer-date  hasDatepicker']")).click();
                    Robot robot = new Robot();
                    robot.keyPress(KeyEvent.VK_ENTER);
                    robot.keyRelease(KeyEvent.VK_ENTER);
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
                if (getDriver().findElement(By.xpath("//div[@id='asc-staff-aboutme-one']")).isDisplayed()) {
                    int b = getDriver().findElements(By.xpath("//div[@id='asc-staff-aboutme-one']")).size();
                    for (int c = 1; c <= b; c++) {
                        getDriver().findElement(By.xpath("(//div[@id='asc-staff-aboutme-one']//label[3])[" + c + "]")).click();
                        Thread.sleep(1000);
                    }
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
                getDriver().switchTo().defaultContent();
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='asc-dynamic-save-button']")));
                getDriver().findElement(By.xpath("//button[@id='asc-dynamic-save-button']")).click();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @And("I clean up {string} PT")
    public void iCleanUpPT(String arg0) throws Throwable {
        getDriver().findElement(By.xpath("//i[contains(@class,'fa fa-caret-down')]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//li[contains(text(),'Admin Console')]")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='user-search']")));

        if (arg0.equalsIgnoreCase("CSV")) {
            getDriver().findElement(By.xpath("//input[@id='user-search']")).sendKeys("donald@gmail.com");
            Thread.sleep(168440);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(4000);

            getDriver().findElement(By.xpath("//i[@class='fa fa-chevron-down']")).click();
            Thread.sleep(2000);
            getDriver().findElement(By.xpath("//a[@class='action-call-deleteUser']")).click();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(2000);
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success']")));

            getDriver().findElement(By.xpath("//input[@id='user-search']")).click();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_A);
            robot.keyRelease(KeyEvent.VK_A);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_BACK_SPACE);
            robot.keyRelease(KeyEvent.VK_BACK_SPACE);
            getDriver().findElement(By.xpath("//input[@id='user-search']")).sendKeys("trump@gmail.com");
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(4000);
            getDriver().findElement(By.xpath("//i[@class='fa fa-chevron-down']")).click();
            Thread.sleep(2000);
            getDriver().findElement(By.xpath("//a[@class='action-call-deleteUser']")).click();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(2000);
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success']")));
        } else if (arg0.equalsIgnoreCase("Bulk")) {
            getDriver().findElement(By.xpath("//input[@id='user-search']")).sendKeys("Donald Trump");
            Thread.sleep(4000);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(4000);
            getDriver().findElement(By.xpath("//th[contains(text(),'Created Date')]")).click();
            Thread.sleep(2000);
            getDriver().findElement(By.xpath("//i[@class='fa fa-chevron-down']")).click();
            Thread.sleep(2000);
            getDriver().findElement(By.xpath("//a[@class='action-call-deleteUser']")).click();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(2000);
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success']")));

            getDriver().findElement(By.xpath("//input[@id='user-search']")).click();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_A);
            robot.keyRelease(KeyEvent.VK_A);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_BACK_SPACE);
            robot.keyRelease(KeyEvent.VK_BACK_SPACE);
            getDriver().findElement(By.xpath("//input[@id='user-search']")).sendKeys("Narendra Modi");
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(4000);
            getDriver().findElement(By.xpath("//i[@class='fa fa-chevron-down']")).click();
            Thread.sleep(2000);
            getDriver().findElement(By.xpath("//a[@class='action-call-deleteUser']")).click();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(2000);
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success']")));
        }
    }

    String org;

    @And("I go to my profile to find my organization PT")
    public void iGoToMyProfileToFindMyOrganization() throws Throwable {
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-caret-down']")));
        getDriver().findElement(By.xpath("//i[@class='fa fa-caret-down']")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//a[contains(text(),'View Profile')]")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='tab-personal']")));
        getDriver().findElement(By.xpath("//li[@id='tab-personal']")).click();
        String organization = getDriver().findElement(By.xpath("(//div[@class='asc-read-org'])[1]")).getText();
        org = organization.replace(" *", "");
        System.out.println("Organization is " + org);
    }

    String req;

    @And("I find an opportunity associated with my organization PT")
    public void iFindAnOpportunityAssociatedWithMyOrganization() {
        getDriver().get("https://testcommunity.ascendify.com/requisitions");
        new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")));
        getDriver().findElement(By.xpath("//div[contains(text(),'" + org + "')]/..//div[@class='asc-job-status'][contains(text(),'Open')]/../../../..//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")).click();
        new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='asc-candidate-expanded-header-outer-info']")));
        req = getDriver().findElement(By.xpath("//div[@id='asc-job-name']")).getText();
        System.out.println("Requisition is " + req);
    }

    @And("I make sure interview is setup for this opportunity PT")
    public void iMakeSureInterviewIsSetupForThisOpportunityPT() throws Throwable {
        getDriver().findElement(By.xpath("//li[@id='tab-team']")).click();
        getDriver().findElement(By.xpath("//li[@id='tab-team']")).click();
        String handle = getDriver().getWindowHandle();
        System.out.println(handle);

        Thread.sleep(3000);
        WebElement title = getDriver().findElement(By.xpath("//strong[@class='jrt-interview-tab--title']"));
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].click()", title);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", title);
        getDriver().findElement(By.xpath("//strong[@class='jrt-interview-tab--title']")).isDisplayed();
//            new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[@class='setup-title']")));
        try {
            if (getDriver().findElement(By.xpath("//ul[@class='interview-team team-list asc-list-tile scheduling']")).isDisplayed()) {
                System.out.println("Interview Team is already setup for this opportunity");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (getDriver().findElement(By.xpath("//h5[contains(text(),'Set up the interview for Test Req')]")).isDisplayed()) {
//                String handle = getDriver().getWindowHandle();
//                System.out.println(handle);

                getDriver().findElement(By.xpath("//button[@id='asc-interview-setup-btn']")).click();

//            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='schedule-interview-btn']")));
//            getDriver().findElement(By.xpath("//button[@id='schedule-interview-btn']")).click();

                Set handles = getDriver().getWindowHandles();
                System.out.println(handles);

                for (String handle1 : getDriver().getWindowHandles()) {
                    System.out.println(handle1);
                    getDriver().switchTo().window(handle1);
                }

                new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='title']")));
                Thread.sleep(5000);

                getDriver().findElement(By.xpath("//div[@id='mui-component-select-Interview Location']")).click();
                getDriver().findElement(By.xpath("(//li)[5]")).click();
                getDriver().findElement(By.xpath("//div[@id='mui-component-select-Room']")).click();
                getDriver().findElement(By.xpath("(//li)[1]")).click();
                WebElement interview = getDriver().findElement(By.xpath("//div[contains(text(),'No Interview Type Selected')]"));
                jse.executeScript("arguments[0].click()", interview);
                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", interview);
                getDriver().findElement(By.xpath("//div[contains(text(),'No Interview Type Selected')]")).click();
                Thread.sleep(2000);
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_DOWN);
                robot.keyRelease(KeyEvent.VK_DOWN);
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                getDriver().findElement(By.xpath("//input[contains(@id,'autocomplete-input')]")).sendKeys("Bahu Bali");
                new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id,'autocomplete-input')]/../../../../..//div[contains(text(),'Bahu Bali')]")));
                getDriver().findElement(By.xpath("//input[contains(@id,'autocomplete-input')]/../../../../..//div[contains(text(),'Bahu Bali')]")).click();
                Thread.sleep(4000);
                getDriver().findElement(By.xpath("//p[contains(text(),'Save')]")).click();
                new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Data has been saved')]")));
                new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Close')]")));
                getDriver().findElement(By.xpath("//p[contains(text(),'Close')]")).click();
                getDriver().switchTo().window(handle);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String candidate;

    @And("I choose a person who is associated with the same organization as mine PT")
    public void iChooseAPersonWhoIsAssociatedWithTheSameOrganizationAsMine() throws Throwable {
        getDriver().get("https://testcommunity.ascendify.com/people");
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")));
        getDriver().findElement(By.xpath("//div[contains(text(),'" + org + "')]/../../../..//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")).click();
        Thread.sleep(6000);
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='right-system-panel']")));
        Thread.sleep(5000);
        new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='asc-show-next-opportunity-btn']")));
        candidate = getDriver().findElement(By.xpath("//div[@id='asc-candidate-expanded-name']")).getText();
        System.out.println("Candidate is " + candidate);
    }

    @And("I consider for same opportunity PT")
    public void iConsiderForSameOpportunityPT() throws Throwable {
        getDriver().findElement(By.xpath("//span[@id='asc-show-next-opportunity-btn']")).click();
        Thread.sleep(2000);
        try {
            if (getDriver().findElement(By.xpath("//select[@id='asc-next-opp-select']")).isDisplayed()) {
                getDriver().findElement(By.xpath("//select[@id='asc-next-opp-select']")).click();
                Thread.sleep(2000);
            } else {
                getDriver().findElement(By.xpath("//div[contains(text(),'" + org + "')]/../../../..//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")).click();
                Thread.sleep(6000);
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='right-system-panel']")));
                Thread.sleep(5000);
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='asc-show-next-opportunity-btn']")));
                getDriver().findElement(By.xpath("//span[@id='asc-show-next-opportunity-btn']")).click();
                Thread.sleep(2000);
                getDriver().findElement(By.xpath("//select[@id='asc-next-opp-select']")).click();
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='asc-next-opp-select']//option[contains(text(),'" + req + "')]")));
        getDriver().findElement(By.xpath("//select[@id='asc-next-opp-select']//option[contains(text(),'" + req + "')]")).click();
        Thread.sleep(2000);
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='asc-next-opp-btn']")));
        getDriver().findElement(By.xpath("//a[@id='asc-next-opp-btn']")).click();
    }

    @And("I go to Interview tab to set up Interview kit PT")
    public void iGoToInterviewTabToSetUpInterviewKit() throws Throwable {
        getDriver().findElement(By.xpath("//li[@id='tab-interview']")).click();
        Thread.sleep(9000);
        String handle = getDriver().getWindowHandle();
        System.out.println(handle);
        try {
            if (getDriver().findElement(By.xpath("//a[contains(text(),'opportunity.')]")).isDisplayed()) {
                getDriver().findElement(By.xpath("//a[contains(text(),'opportunity.')]")).click();
                new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")));
                getDriver().findElement(By.xpath("//div[contains(text(),'" + org + "')]/../../../..//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")).click();
                new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='tab-team']")));
                getDriver().findElement(By.xpath("//li[@id='tab-team']")).click();
                new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='asc-interview-setup-btn']")));
                getDriver().findElement(By.xpath("//button[@id='asc-interview-setup-btn']")).click();

                Set handles = getDriver().getWindowHandles();
                System.out.println(handles);

                for (String handle1 : getDriver().getWindowHandles()) {
                    System.out.println(handle1);
                    getDriver().switchTo().window(handle1);
                }

                new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='title']")));
                Thread.sleep(5000);

                getDriver().findElement(By.xpath("//div[@id='mui-component-select-Interview Location']")).click();
                getDriver().findElement(By.xpath("(//li)[5]")).click();
                getDriver().findElement(By.xpath("//div[@id='mui-component-select-Room']")).click();
                getDriver().findElement(By.xpath("(//li)[1]")).click();
                WebElement interview = getDriver().findElement(By.xpath("//div[contains(text(),'No Interview Type Selected')]"));
                JavascriptExecutor jse = (JavascriptExecutor) getDriver();
                jse.executeScript("arguments[0].click()", interview);
                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", interview);
                getDriver().findElement(By.xpath("//div[contains(text(),'No Interview Type Selected')]")).click();
                Thread.sleep(2000);
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_DOWN);
                robot.keyRelease(KeyEvent.VK_DOWN);
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                getDriver().findElement(By.xpath("//input[contains(@id,'autocomplete-input')]")).sendKeys("Bahu Bali");
                new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id,'autocomplete-input')]/../../../../..//div[contains(text(),'Bahu Bali')]")));
                getDriver().findElement(By.xpath("//input[contains(@id,'autocomplete-input')]/../../../../..//div[contains(text(),'Bahu Bali')]")).click();
                Thread.sleep(4000);
                getDriver().findElement(By.xpath("//p[contains(text(),'Save')]")).click();
                new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Data has been saved')]")));
                new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Close')]")));
                getDriver().findElement(By.xpath("//p[contains(text(),'Close')]")).click();
                getDriver().switchTo().window(handle);
            } else if (getDriver().findElement(By.xpath("//button[@id='schedule-interview-btn']")).isDisplayed()) {
                Thread.sleep(4000);
                getDriver().findElement(By.xpath("//button[@id='schedule-interview-btn']")).click();
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Interview')]")));
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("I do the Interview setup PT")
    public void iDoTheInterviewSetupPT() throws Throwable {
        String handle = getDriver().getWindowHandle();
        System.out.println(handle);

        new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='schedule-interview-btn']")));
        getDriver().findElement(By.xpath("//button[@id='schedule-interview-btn']")).click();

        Set handles = getDriver().getWindowHandles();
        System.out.println(handles);

        for (String handle1 : getDriver().getWindowHandles()) {
            System.out.println(handle1);
            getDriver().switchTo().window(handle1);
        }

        new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='title']")));
        Thread.sleep(5000);
        try {
            if (getDriver().findElement(By.xpath("//p[contains(text(),'EDIT')]")).isDisplayed()) {
                WebElement edit = getDriver().findElement(By.xpath("//p[contains(text(),'EDIT')]"));
                JavascriptExecutor jse = (JavascriptExecutor) getDriver();
                jse.executeScript("arguments[0].click()", edit);
                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", edit);
                Thread.sleep(500);
                getDriver().findElement(By.xpath("//p[contains(text(),'Add Interview')]")).click();
                Thread.sleep(2000);
                getDriver().findElement(By.xpath("//div[contains(text(),'No Interview Type Selected')]")).click();
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_DOWN);
                robot.keyRelease(KeyEvent.VK_DOWN);
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                int size = 0;
                size = getDriver().findElements(By.xpath("//input[contains(@id,'autocomplete-input')]")).size();
                getDriver().findElement(By.xpath("(//input[contains(@id,'autocomplete-input')])[" + size + "]")).sendKeys("Chandler Bing");
                new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[contains(@id,'autocomplete-input')])[" + size + "]/../../../../..//div[contains(text(),'Chandler Bing')]")));
                getDriver().findElement(By.xpath("(//input[contains(@id,'autocomplete-input')])[" + size + "]/../../../../..//div[contains(text(),'Chandler Bing')]")).click();
                Thread.sleep(4000);
                getDriver().findElement(By.xpath("//p[contains(text(),'NEXT')]")).click();
                new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Data has been saved')]")));
            } else if (getDriver().findElement(By.xpath("//span[contains(text(),'Reschedule')]")).isDisplayed()) {
                getDriver().findElement(By.xpath("//span[contains(text(),'Reschedule')]")).click();
                getDriver().findElement(By.xpath("//p[contains(text(),'Accept')]")).click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'MuiAvatar-root MuiAvatar-circle MuiAvatar-colorDefault asc-prod')]")));
        getDriver().findElement(By.xpath("(//div[contains(@class, 'MuiAvatar-root MuiAvatar-circle MuiAvatar-colorDefault asc-prod')])[1]")).click();
        new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Schedule Now')]")));
        WebElement schedule = getDriver().findElement(By.xpath("//p[contains(text(),'Schedule Now')]"));
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].click()", schedule);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", schedule);
        getDriver().findElement(By.xpath("//p[contains(text(),'Schedule Now')]")).click();
        getDriver().findElement(By.xpath("//p[contains(text(),'Schedule Now')]")).click();
        new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Send')]")));
        getDriver().findElement(By.xpath("//p[contains(text(),'Send')]")).click();
        new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Email sent to candidate')]")));
        new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='MuiIconButton-label']")));
        WebElement checkbox = getDriver().findElement(By.xpath("//span[@class='MuiIconButton-label']"));
        jse.executeScript("arguments[0].click()", checkbox);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", checkbox);
        int size = 0;
        size = getDriver().findElements(By.xpath("//span[@class='MuiIconButton-label']")).size();
        for (int i = 1; i <= size; i++) {
            getDriver().findElement(By.xpath("(//span[@class='MuiIconButton-label'])[" + i + "]")).click();
        }
        getDriver().findElement(By.xpath("//p[contains(text(),'NEXT')]")).click();
        new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Data has been saved')]")));
        new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Scheduled Interview')]")));
        WebElement resend = getDriver().findElement(By.xpath("//p[contains(text(),'Resend')]"));
        jse.executeScript("arguments[0].click()", resend);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", resend);
        new WebDriverWait(getDriver(), 200).until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'Resend')]")));
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//p[contains(text(),'Send')]")).click();
        Thread.sleep(2000);
        new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Interview information has been sent')]")));
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//p[contains(text(),'CLOSE')]")).click();
        Thread.sleep(2000);
        getDriver().switchTo().window(handle);
    }

    int interviewers;
    int newInterviewers;

    @Then("I make sure the new interviewers are added as Team Members PT")
    public void iMakeSureTheNewInterviewersAreAddedAsTeamMembersPT() throws Throwable {
        Thread.sleep(2000);
        new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@class,'interview-team team-list asc-list-tile scheduling')]")));
        interviewers = getDriver().findElements(By.xpath("//ul[contains(@class,'interview-team team-list asc-list-tile scheduling')]")).size();
        System.out.println("No. of Interviewers = " + interviewers);
        getDriver().findElement(By.xpath("//div[contains(text(),'" + candidate + "')]/../../../../..//i[contains(@class,'fa fa-chevron-circle-right asc-list-more-information-arrow')]")).click();
        new WebDriverWait(getDriver(), 200).until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='tab-interview']")));
        getDriver().findElement(By.xpath("//li[@id='tab-interview']")).click();
        getDriver().findElement(By.xpath("//li[@id='tab-interview']")).click();
        getDriver().findElement(By.xpath("//li[@id='tab-interview']")).click();
        new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@class,'interview-team approved-interviewers-list')]")));
        newInterviewers = getDriver().findElements(By.xpath("//ul[contains(@class,'interview-team approved-interviewers-list')]")).size();
        System.out.println("Number of Updated Interviewers = " + newInterviewers);
        if (newInterviewers > interviewers) {
            System.out.println("New Interviewers are added to the Team Members List");
        } else {
            System.out.println("New Interviewers are NOT added to the Team Members List");
        }
    }
}