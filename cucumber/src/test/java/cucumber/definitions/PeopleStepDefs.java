package cucumber.definitions;

import cucumber.support.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
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
import java.util.NoSuchElementException;
import java.util.UUID;

import static cucumber.support.TestContext.getDriver;

public class PeopleStepDefs {

    @Given("I navigate to {string} page PT")
    public void iNavigateToPage(String arg0) {
        TestContext.getDriver().get("https://testcommunity.ascendify.com/");
    }

    @When("I sign in PT")
    public void iSignIn() {
        TestContext.getDriver().findElement(By.xpath("//input[@id='id_username']")).sendKeys("tessy.anicattumathew@ascendify.com");
        TestContext.getDriver().findElement(By.xpath("//input[@id='id_password']")).sendKeys("Mac123q!");
        TestContext.getDriver().findElement(By.xpath("//button[@id='asc-signin-btn']")).click();
    }

    @And("I click on {string} button PT")
    public void iClickOnButton(String arg0) throws Throwable {
        if (arg0.equalsIgnoreCase("New")) {
            TestContext.getDriver().findElement(By.xpath("//span[@id='asc-add-candidate']")).click();
        } else if (arg0.equalsIgnoreCase("Import")) {
            Thread.sleep(2000);
            TestContext.getDriver().findElement(By.xpath("//button[contains(text(),'Import')]")).click();
        } else if (arg0.equalsIgnoreCase("Add Profiles")) {
            TestContext.getDriver().findElement(By.xpath("//button[@id='asc-add-user-btn']")).click();
        }
    }

    @Then("{string} page is displayed PT")
    public void pageIsDisplayed(String arg0) throws Throwable {
        if (arg0.equalsIgnoreCase("Main Menu")) {
            Thread.sleep(8000);
            new WebDriverWait(TestContext.getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Main Menu tab')]")));
            TestContext.getDriver().findElement(By.xpath("//span[contains(text(),'Main Menu tab')]")).isDisplayed();
        } else if (arg0.equalsIgnoreCase("Data Mapping")) {
            Thread.sleep(20000);
            TestContext.getDriver().findElement(By.xpath("//h3[@class='asc-admin-header']")).isDisplayed();
        }
    }

    @And("I click on {string} tab PT")
    public void iClickOnTa(String arg0) throws Throwable {
        if (arg0.equalsIgnoreCase("People")) {
            Thread.sleep(2000);
            TestContext.getDriver().findElement(By.xpath("//div[contains(text(),'People')]")).click();
        } else if (arg0.equalsIgnoreCase("Responses")) {
            Thread.sleep(2000);
            new WebDriverWait(TestContext.getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='tab-staff-aboutme-one']")));
            TestContext.getDriver().findElement(By.xpath("//li[@id='tab-staff-aboutme-one']")).click();
        }
    }

    @And("I navigate to {string} PT")
    public void iNavigateTo(String arg0) throws Throwable {
        Thread.sleep(2000);
        if (arg0.equalsIgnoreCase("Upload a CSV file")) {
            TestContext.getDriver().findElement(By.xpath("//a[@id='asc-add-candidate-csv']")).click();
        } else if (arg0.equalsIgnoreCase("Bulk Add")) {
            TestContext.getDriver().findElement(By.xpath("//a[@id='asc-add-bulk-candidate-manually']")).click();
        }
    }

    @And("I choose my file to be uploaded by clicking {string} button PT")
    public void iChooseMyFileToBeUploadedByClickingButton(String arg0) throws AWTException, Throwable, InterruptedException {
        Thread.sleep(2000);
        try {
            if (arg0.equalsIgnoreCase("Upload a File")) {
                Actions actions = new Actions(TestContext.getDriver());
                actions.moveToElement(TestContext.getDriver().findElement(By.id("asc-bulk-upload-div")));
                TestContext.getDriver().findElement(By.id("asc-bulk-upload-div")).click();
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
                Actions actions = new Actions(TestContext.getDriver());
                actions.moveToElement(TestContext.getDriver().findElement(By.id("asc-bulk-upload-users-form")));
                TestContext.getDriver().findElement(By.id("asc-bulk-upload-users-form")).click();
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
                WebElement ONE = TestContext.getDriver().findElement(By.xpath("//select[@name='mapfield[" + i + "]']"));
                String textInsideONE = ONE.getAttribute("value");
                if (textInsideONE.isEmpty()) {
                    String selBoxNAME = "'mapfield[" + i + "]'";
                    String partialText = TestContext.getDriver().findElement(By.xpath("//div[@id='right-system-panel']//tr[" + (i + 2) + "]//td[1]")).getText();
                    TestContext.getDriver().findElement(By.xpath("//select[@name=" + selBoxNAME + "]")).click();
                    TestContext.getDriver().findElement(By.xpath("//select[@name=" + selBoxNAME + "]//option[" + (i + 2) + "]")).click();
                    Thread.sleep(1000);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        new WebDriverWait(TestContext.getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//select[contains(@name,'ascendify[client_user_partner_org]')]")));
        TestContext.getDriver().findElement(By.xpath("//select[contains(@name,'ascendify[client_user_partner_org]')]")).click();
        TestContext.getDriver().findElement(By.xpath("//select[contains(@name,'ascendify[client_user_partner_org]')]//option[contains(text(),'Ascendify')]")).click();
    }

    @Then("{string} message is displayed PT")
    public void messageIsDisplayed(String arg0) throws Throwable {
        if (arg0.equalsIgnoreCase("CSV processing")) {
            Thread.sleep(4000);
            TestContext.getDriver().findElement(By.xpath("//li[contains(text(),'Your file has been queued for processing.  You will get an email when the process is complete.')]")).isDisplayed();
        } else if (arg0.equalsIgnoreCase("Bulk Add processing")) {
            Thread.sleep(2000);
            TestContext.getDriver().findElement(By.xpath("//li[contains(text(),'New users are being processed.')]")).isDisplayed();
        }
    }

    @And("I fill in empty fields PT")
    public void iFillInEmptyFields() throws Throwable {

        Thread.sleep(2000);
        WebElement Status = TestContext.getDriver().findElement(By.xpath("//select[@id='asc-client-crm-status-field']"));
        String textInsideStatus = Status.getAttribute("value");
        if (textInsideStatus.isEmpty()) {
            TestContext.getDriver().findElement(By.xpath("//select[@id='asc-client-crm-status-field']")).click();
            TestContext.getDriver().findElement(By.xpath("//select[@id='asc-client-crm-status-field']//option[contains(text(),'New')]")).click();
            Thread.sleep(2000);
        }

        TestContext.getDriver().findElement(By.xpath("//div[@id='asc_group_select_chosen']")).click();
        TestContext.getDriver().findElement(By.xpath("//div[@id='asc_group_select_chosen']//input")).sendKeys("Candidate", Keys.ENTER);
        Thread.sleep(2000);

        WebElement Source = TestContext.getDriver().findElement(By.xpath("//select[@id='asc-basic-source-field']"));
        String textInsideSource = Source.getAttribute("value");
        if (textInsideSource.isEmpty()) {
            TestContext.getDriver().findElement(By.xpath("//select[@id='asc-basic-source-field']")).click();
            TestContext.getDriver().findElement(By.xpath("//select[@id='asc-basic-source-field']//option[contains(text(),'Employee Referrals')]")).click();
        }
        WebElement Recruit = TestContext.getDriver().findElement(By.xpath("//select[@id='asc-basic-recruiter-field']"));
        String textInsideRecruit = Recruit.getAttribute("value");
        if (textInsideRecruit.isEmpty()) {
            TestContext.getDriver().findElement(By.xpath("//select[@id='asc-basic-recruiter-field']")).click();
            TestContext.getDriver().findElement(By.xpath("//select[@id='asc-basic-recruiter-field']//option[contains(text(),'Alex Selenium1')]")).click();
            Thread.sleep(2000);
        }

        TestContext.getDriver().findElement(By.xpath("//input[@id='asc-add-user-quick-comment']")).sendKeys("Excellent Candidates");
        Thread.sleep(2000);

        WebElement Org = TestContext.getDriver().findElement(By.xpath("//select[@id='asc-basic-recruiter-field']"));
        String textInsideOrg = Org.getAttribute("value");
        if (textInsideOrg.isEmpty()) {
            TestContext.getDriver().findElement(By.xpath("//select[contains(@name,'ascendify[client_user_partner_org]')]")).click();
            TestContext.getDriver().findElement(By.xpath("//select[contains(@name,'ascendify[client_user_partner_org]')]//option[contains(text(),'Test Community!')]")).click();
            Thread.sleep(2000);
            TestContext.getDriver().findElement(By.xpath("//a[@id='asc-add-new-org-text-box']")).click();
            TestContext.getDriver().findElement(By.xpath("//select[contains(@name,'ascendify[client_user_partner_org]')]")).click();
            TestContext.getDriver().findElement(By.xpath("//select[contains(@name,'ascendify[client_user_partner_org]')]//option[contains(text(),'Tessy's Org')]")).click();
            Thread.sleep(2000);
        }
        TestContext.getDriver().findElement(By.xpath("//input[@id='asc-add-user-tag-input']")).sendKeys("Hire");
        TestContext.getDriver().findElement(By.xpath("//button[@id='asc-asd-user-tag-btn']")).click();
        Thread.sleep(2000);

    }

    @And("I click on the right arrow of a candidate PT")
    public void iClickOnTheRightArrowOfACandidate() {
        TestContext.getDriver().findElement(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")).click();
    }

    @And("I consider for new opportunity PT")
    public void iConsiderForNewOpportunity() throws Throwable {

        Thread.sleep(6000);
        new WebDriverWait(TestContext.getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='right-system-panel']")));
        new WebDriverWait(TestContext.getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='asc-show-next-opportunity-btn']")));
        TestContext.getDriver().findElement(By.xpath("//span[@id='asc-show-next-opportunity-btn']")).click();
        new WebDriverWait(TestContext.getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='asc-next-opp-select']")));
        TestContext.getDriver().findElement(By.xpath("//select[@id='asc-next-opp-select']")).click();
        new WebDriverWait(TestContext.getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='asc-next-opp-select']//option[2]")));
        TestContext.getDriver().findElement(By.xpath("//select[@id='asc-next-opp-select']//option[2]")).click();
        TestContext.getDriver().findElement(By.xpath("//a[@id='asc-next-opp-btn']")).click();
    }

    @Then("candidate has been {string} PT")
    public void candidateHasBeen(String arg0) throws Throwable {
        Thread.sleep(8000);
        new WebDriverWait(TestContext.getDriver(), 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Move Forward')]")));
        TestContext.getDriver().findElement(By.xpath("//span[contains(text(),'Move Forward')]")).isDisplayed();
    }

    @And("I move the candidate through different hiring status PT")
    public void iMoveTheCandidateThroughDifferentHiringStatus() throws Throwable {
        Thread.sleep(2000);
        TestContext.getDriver().findElement(By.xpath("//span[contains(text(),'Move Forward')]")).click();
        Thread.sleep(2000);
        new WebDriverWait(TestContext.getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Preliminary Phone Screen')]")));
        TestContext.getDriver().findElement(By.xpath("//a[contains(text(),'Preliminary Phone Screen')]")).click();
        new WebDriverWait(TestContext.getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Current step: Preliminary Phone Screen')]")));
        TestContext.getDriver().findElement(By.xpath("//span[contains(text(),'Current step: Preliminary Phone Screen')]")).isDisplayed();
        Thread.sleep(2000);

        TestContext.getDriver().findElement(By.xpath("//span[contains(text(),'Move Forward')]")).click();
        Thread.sleep(2000);
        new WebDriverWait(TestContext.getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'In-Person Meeting')]")));
        TestContext.getDriver().findElement(By.xpath("//a[contains(text(),'In-Person Meeting')]")).click();
        new WebDriverWait(TestContext.getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Current step: In-Person Meeting')]")));
        TestContext.getDriver().findElement(By.xpath("//span[contains(text(),'Current step: In-Person Meeting')]")).isDisplayed();
        Thread.sleep(2000);
    }

    @And("I drag and drop candidates to folder PT")
    public void iDragAndDropCandidatesToFolder() throws Throwable {
        try {
            String BefCount = TestContext.getDriver().findElement(By.xpath("(//a[@class='link clearfix  ui-droppable'])[1]/..//span[@class='link-count']")).getText();
            int InitialCount = Integer.parseInt(BefCount);

            String FirstCount = TestContext.getDriver().findElement(By.xpath("(//a[@class='link clearfix  ui-droppable'])[1]/..//span[@class='link-count']")).getText();
            System.out.println("Initial Count = " + FirstCount);

            TestContext.getDriver().findElement(By.xpath("(//div[@class='asc-list-middle-inner-div'])[1]")).click();
            TestContext.getDriver().findElement(By.xpath("(//div[@class='asc-list-move-tab ui-draggable-handle']//span[@class='asc-multi-box'])[1]")).click();
            TestContext.getDriver().findElement(By.xpath("(//div[@class='asc-list-middle-inner-div'])[2]")).click();
            TestContext.getDriver().findElement(By.xpath("(//div[@class='asc-list-move-tab ui-draggable-handle']//span[@class='asc-multi-box'])[2]")).click();
            TestContext.getDriver().findElement(By.xpath("//span[contains(@class,'asc-multi-box')]//i[contains(@class,'fa fa-check')]")).isDisplayed();

            WebElement From = TestContext.getDriver().findElement(By.xpath("(//i[@class='fa fa-ellipsis-v'])[2]"));
            WebElement To = TestContext.getDriver().findElement(By.xpath("(//a[@class='link clearfix  ui-droppable'])[1]"));
            Actions act = new Actions(TestContext.getDriver());
            act.dragAndDrop(From, To).build().perform();

            Thread.sleep(8000);
            TestContext.getDriver().navigate().refresh();
            String AftCount = TestContext.getDriver().findElement(By.xpath("(//a[@class='link clearfix  ui-droppable'])[1]/..//span[@class='link-count']")).getText();
            int UpdatedCount = Integer.parseInt(AftCount);
            TestContext.getDriver().navigate().refresh();
            System.out.println("Updated Count = " + AftCount);

//        Cleanup
            if (UpdatedCount != InitialCount) {
                TestContext.getDriver().findElement(By.xpath("(//a[@class='link clearfix  ui-droppable'])[1]")).click();
                Thread.sleep(2000);
                TestContext.getDriver().findElement(By.xpath("//span[@id='asc-sort-by-div']")).click();
                Thread.sleep(2000);
                TestContext.getDriver().findElement(By.xpath("//a[@data-field='client_users.created DESC']")).click();
                Thread.sleep(2000);
                TestContext.getDriver().findElement(By.xpath("(//div[@class='asc-list-middle-inner-div'])[1]")).click();
                TestContext.getDriver().findElement(By.xpath("(//div[@class='asc-list-move-tab ui-draggable-handle']//span[@class='asc-multi-box'])[1]")).click();
                TestContext.getDriver().findElement(By.xpath("(//div[@class='asc-list-middle-inner-div'])[2]")).click();
                TestContext.getDriver().findElement(By.xpath("(//div[@class='asc-list-move-tab ui-draggable-handle']//span[@class='asc-multi-box'])[2]")).click();
                TestContext.getDriver().findElement(By.xpath("//span[contains(@class,'asc-multi-box')]//i[contains(@class,'fa fa-check')]")).isDisplayed();
                new WebDriverWait(TestContext.getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='asc-action-div']")));
                TestContext.getDriver().findElement(By.xpath("//span[@id='asc-action-div']")).click();
                TestContext.getDriver().findElement(By.xpath("//a[@class='ascbulk-remove-from-list']")).click();
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                Thread.sleep(8000);
                new WebDriverWait(TestContext.getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Your records are being removed and your changes will be reflected soon')]")));
            } else {
                System.out.println("Those candidates are already present in this folder");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("I edit and save all questions PT")
    public void iEditAndSaveAllQuestions() throws Throwable {

        int sections = TestContext.getDriver().findElements(By.xpath("//ul[@id='asc-responses-expanded-tabs-sub']//li")).size();
        for (int a = 1; a <= sections; a = a + 2) {
            try {
                Thread.sleep(200);
                TestContext.getDriver().findElement(By.xpath("(//ul[@id='asc-responses-expanded-tabs-sub']//li)[" + a + "]")).click();
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                TestContext.getDriver().findElement(By.xpath("//body/div[@id='wrap']/div[@id='container']/div[@id='right-system-panel']/div[@id='inner-right-system-panel']/div[@id='asc-app-record-profile-view']/div[@id='asc-job-maindata']/div[@id='asc-extended-tabs-output-holder']/div[@id='asc-staff-aboutme-one']/div[@id='personal-sub-tab']/div[@id='asc-user-custom-data']/div[@class='asc-edit-block-inner']/div[@class='asc-edit-div']/div[@class='asc-edit-readonly']/div[1]")).click();
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                List<WebElement> radio = TestContext.getDriver().findElements(By.xpath("//div[@class='asc-survey-question-answer-radio'][1]//input[@type='radio']"));
                for (WebElement element : radio) {
                    element.click();
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                List<WebElement> text = TestContext.getDriver().findElements(By.xpath("//input[@class='asc-survey-question-answer']"));
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
                List<WebElement> text = TestContext.getDriver().findElements(By.xpath("//input[@class='asc-survey-question-answer required']"));
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
                int j = TestContext.getDriver().findElements(By.xpath("//a[contains(@class,'chosen-single chosen-default')]")).size();
                for (int i = 1; i <= j; i++) {
                    if (TestContext.getDriver().findElement(By.xpath("(//a[contains(@class,'chosen-single chosen-default')])[" + i + "]")).isDisplayed()) {
                        TestContext.getDriver().findElement(By.xpath("(//a[contains(@class,'chosen-single chosen-default')])[" + i + "]")).click();
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
                l = TestContext.getDriver().findElements(By.xpath("//div[contains(@id,'asc_question_csvq_')]")).size();
                for (int k = 1; k <= l; k++) {
                    TestContext.getDriver().findElement(By.xpath("(//div[contains(@id,'asc_question_csvq_')])[" + k + "]")).click();
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
                if (TestContext.getDriver().findElement(By.xpath("//textarea[@class='asc-survey-question-answer']")).isDisplayed()) {
                    int l = TestContext.getDriver().findElements(By.xpath("//textarea[@class='asc-survey-question-answer']")).size();
                    for (int k = 1; k <= l; k++) {
                        String uuid = UUID.randomUUID().toString();
                        TestContext.getDriver().findElement(By.xpath("(//textarea[@class='asc-survey-question-answer'])[" + k + "]")).click();
                        TestContext.getDriver().findElement(By.xpath("(//textarea[@class='asc-survey-question-answer'])[" + k + "]")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
                        TestContext.getDriver().findElement(By.xpath("(//textarea[@class='asc-survey-question-answer'])[" + k + "]")).sendKeys(Keys.BACK_SPACE);
                        TestContext.getDriver().findElement(By.xpath("(//textarea[@class='asc-survey-question-answer'])[" + k + "]")).sendKeys(uuid);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                if (TestContext.getDriver().findElement(By.xpath("//input[@class='asc-survey-question-answer asc-survey-question-answer-date  hasDatepicker']")).isDisplayed()) {
                    TestContext.getDriver().findElement(By.xpath("//input[@class='asc-survey-question-answer asc-survey-question-answer-date  hasDatepicker']")).click();
                    Robot robot = new Robot();
                    robot.keyPress(KeyEvent.VK_ENTER);
                    robot.keyRelease(KeyEvent.VK_ENTER);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                int x = 0;
                x = TestContext.getDriver().findElements(By.xpath("//div[contains(@id,'asc_question_csvq_')]")).size();
                for (int y = 1; y <= x; y++) {
                    TestContext.getDriver().findElement(By.xpath("(//div[contains(@id,'asc_question_csvq_')])[" + y + "]")).click();
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
                List<WebElement> me = TestContext.getDriver().findElements(By.xpath("//div[@id='asc-staff-aboutme-one']//label[1]"));
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
                if (TestContext.getDriver().findElement(By.xpath("//div[@id='asc-staff-aboutme-one']")).isDisplayed()) {
                    int b = TestContext.getDriver().findElements(By.xpath("//div[@id='asc-staff-aboutme-one']")).size();
                    for (int c = 1; c <= b; c++) {
                        TestContext.getDriver().findElement(By.xpath("(//div[@id='asc-staff-aboutme-one']//label[3])[" + c + "]")).click();
                        Thread.sleep(1000);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                int f = TestContext.getDriver().findElements(By.xpath("//iframe[contains(@title,'Rich Text Editor')]")).size();
                for (int g = 1; g <= f; g++) {
                    new WebDriverWait(TestContext.getDriver(), 20).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("(//iframe[contains(@title,'Rich Text Editor')])[" + g + "]")));
                    String uuid = UUID.randomUUID().toString();
                    TestContext.getDriver().findElement(By.cssSelector("body")).click();
                    TestContext.getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
                    Thread.sleep(1000);
                    Robot robot = new Robot();
                    robot.keyPress(KeyEvent.VK_BACK_SPACE);
                    robot.keyRelease(KeyEvent.VK_BACK_SPACE);
                    TestContext.getDriver().findElement(By.cssSelector("body")).sendKeys(uuid);
                    Thread.sleep(1000);
                    TestContext.getDriver().switchTo().defaultContent();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                TestContext.getDriver().switchTo().defaultContent();
                new WebDriverWait(TestContext.getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='asc-dynamic-save-button']")));
                TestContext.getDriver().findElement(By.xpath("//button[@id='asc-dynamic-save-button']")).click();
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
            new WebDriverWait(TestContext.getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success']")));

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
            new WebDriverWait(TestContext.getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success']")));
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
            new WebDriverWait(TestContext.getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success']")));

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
            new WebDriverWait(TestContext.getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success']")));
        }
    }
}