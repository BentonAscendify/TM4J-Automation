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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import static support.TestContext.getDriver;

public class PeopleStepDefs {

    @Given("I navigate to {string} page")
    public void iNavigateToPag(String arg0) {
        getDriver().get("https://testcommunity.ascendify.com/");
    }

    @When("I type {string} as {string}")
    public void iTypeAs(String arg0, String arg1) {
        if(arg0.equalsIgnoreCase("email")){
            getDriver().findElement(By.xpath("//input[@id='id_username']")).click();
            getDriver().findElement(By.xpath("//input[@id='id_username']")).sendKeys(arg1);
        } else if(arg0.equalsIgnoreCase("password")){
            getDriver().findElement(By.xpath("//input[@id='id_password']")).click();
            getDriver().findElement(By.xpath("//input[@id='id_password']")).sendKeys(arg1);
        }
    }

    @And("I click on {string} button")
    public void iClickOnButton(String arg0) throws Throwable{
        if(arg0.equalsIgnoreCase("Sign In")) {
            getDriver().findElement(By.xpath("//button[@id='asc-signin-btn']")).click();
        }else if(arg0.equalsIgnoreCase("New")){
            getDriver().findElement(By.xpath("//span[@id='asc-add-candidate']")).click();
        }else if(arg0.equalsIgnoreCase("Import")){
            Thread.sleep(2000);
            getDriver().findElement(By.xpath("//button[contains(text(),'Import')]")).click();
        }else if(arg0.equalsIgnoreCase("Add Profiles")){
            getDriver().findElement(By.xpath("//button[@id='asc-add-user-btn']")).click();
        }
    }

    @Then("{string} page is displayed")
    public void pageIsDisplayed(String arg0) throws Throwable{
        if (arg0.equalsIgnoreCase("Main Menu")) {
            Thread.sleep(8000);
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Main Menu tab')]")));
            getDriver().findElement(By.xpath("//span[contains(text(),'Main Menu tab')]")).isDisplayed();
        } else if (arg0.equalsIgnoreCase("Data Mapping")) {
            Thread.sleep(20000);
            getDriver().findElement(By.xpath("//h3[@class='asc-admin-header']")).isDisplayed();
        }
    }

    @And("I click on {string} tab")
    public void iClickOnTa(String arg0) throws Throwable{
        if(arg0.equalsIgnoreCase("People")) {
            Thread.sleep(2000);
            getDriver().findElement(By.xpath("//div[contains(text(),'People')]")).click();
        }else if(arg0.equalsIgnoreCase("Responses")){
            Thread.sleep(2000);
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='tab-staff-aboutme-one']")));
            getDriver().findElement(By.xpath("//li[@id='tab-staff-aboutme-one']")).click();
        }
    }

    @And("I navigate to {string}")
    public void iNavigateTo(String arg0) throws Throwable{
        Thread.sleep(2000);
        if(arg0.equalsIgnoreCase("Upload a CSV file")){
            getDriver().findElement(By.xpath("//a[@id='asc-add-candidate-csv']")).click();
        }else if(arg0.equalsIgnoreCase("Bulk Add")){
            getDriver().findElement(By.xpath("//a[@id='asc-add-bulk-candidate-manually']")).click();
        }
    }

    @And("I choose my file to be uploaded by clicking {string} button")
    public void iChooseMyFileToBeUploadedByClickingButton(String arg0) throws AWTException, Throwable, InterruptedException {
        Thread.sleep(2000);
        try {
            if(arg0.equalsIgnoreCase("Upload a File")) {
                Actions actions = new Actions(getDriver());
                actions.moveToElement(getDriver().findElement(By.id("asc-bulk-upload-div")));
                getDriver().findElement(By.id("asc-bulk-upload-div")).click();
                Thread.sleep(2000);
                uploadFile("C:\\Users\\tessy\\OneDrive\\Desktop\\profiles-import");
                Thread.sleep(2000);
            } else if(arg0.equalsIgnoreCase("Drop Files")){
                Actions actions = new Actions(getDriver());
                actions.moveToElement(getDriver().findElement(By.id("asc-bulk-upload-users-form")));
                getDriver().findElement(By.id("asc-bulk-upload-users-form")).click();
                Thread.sleep(2000);
                uploadFile("C:\\Users\\tessy\\OneDrive\\Desktop\\Records");
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

            robot.mouseMove(250,250);
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

    @And("I map the fields in the .CSV file to the appropriate fields in the application")
    public void iMapTheFieldsInTheCSVFileToTheAppropriateFieldsInTheApplication() throws Throwable{
        try {
            for (int i=0; i<=10; i++) {
                WebElement ONE = getDriver().findElement(By.xpath("//select[@name='mapfield[" + i + "]']"));
                String textInsideONE = ONE.getAttribute("value");
                if (textInsideONE.isEmpty()) {
                    String selBoxNAME = "'mapfield[" + i + "]'";
                    String partialText = getDriver().findElement(By.xpath("//div[@id='right-system-panel']//tr[" + (i + 2) + "]//td[1]")).getText();
                    getDriver().findElement(By.xpath("//select[@name=" + selBoxNAME + "]")).click();
                    getDriver().findElement(By.xpath("//select[@name=" + selBoxNAME + "]//option["+(i+2)+"]")).click();
                    Thread.sleep(1000);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        getDriver().findElement(By.xpath("//select[contains(@name,'ascendify[client_user_partner_org]')]")).click();
        getDriver().findElement(By.xpath("//select[contains(@name,'ascendify[client_user_partner_org]')]//option[contains(text(),'Ascendify')]")).click();
    }

    @Then("{string} message is displayed")
    public void messageIsDisplayed(String arg0) throws Throwable{
        if(arg0.equalsIgnoreCase("CSV processing")) {
            Thread.sleep(4000);
            getDriver().findElement(By.xpath("//li[contains(text(),'Your file has been queued for processing.  You will get an email when the process is complete.')]")).isDisplayed();
        }else if(arg0.equalsIgnoreCase("Bulk Add processing")){
            Thread.sleep(2000);
            getDriver().findElement(By.xpath("//li[contains(text(),'New users are being processed.')]")).isDisplayed();
        }
    }

    @And("I fill in empty fields")
    public void iFillInEmptyFields() throws Throwable{

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

    @And("I click on the right arrow of a candidate")
    public void iClickOnTheRightArrowOfACandidate() {
        getDriver().findElement(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")).click();
    }

    @And("I consider for new opportunity")
    public void iConsiderForNewOpportunity() throws Throwable{

        Thread.sleep(6000);
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='right-system-panel']")));
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='asc-show-next-opportunity-btn']")));
        getDriver().findElement(By.xpath("//span[@id='asc-show-next-opportunity-btn']")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='asc-next-opp-select']")));
        getDriver().findElement(By.xpath("//select[@id='asc-next-opp-select']")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='asc-next-opp-select']//option[2]")));
        getDriver().findElement(By.xpath("//select[@id='asc-next-opp-select']//option[2]")).click();
        getDriver().findElement(By.xpath("//a[@id='asc-next-opp-btn']")).click();
    }

    @Then("candidate has been {string}")
    public void candidateHasBeen(String arg0) throws Throwable{
        Thread.sleep(8000);
        new WebDriverWait(getDriver(), 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Move Forward')]")));
        getDriver().findElement(By.xpath("//span[contains(text(),'Move Forward')]")).isDisplayed();
    }

    @And("I move the candidate through different hiring status")
    public void iMoveTheCandidateThroughDifferentHiringStatus() throws Throwable{
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//span[contains(text(),'Move Forward')]")).click();
        Thread.sleep(2000);
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Preliminary Phone Screen')]")));
        getDriver().findElement(By.xpath("//a[contains(text(),'Preliminary Phone Screen')]")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Current step: Preliminary Phone Screen')]")));
        getDriver().findElement(By.xpath("//span[contains(text(),'Current step: Preliminary Phone Screen')]")).isDisplayed();
        Thread.sleep(2000);

        getDriver().findElement(By.xpath("//span[contains(text(),'Move Forward')]")).click();
        Thread.sleep(2000);
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'In-Person Meeting')]")));
        getDriver().findElement(By.xpath("//a[contains(text(),'In-Person Meeting')]")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Current step: In-Person Meeting')]")));
        getDriver().findElement(By.xpath("//span[contains(text(),'Current step: In-Person Meeting')]")).isDisplayed();
        Thread.sleep(2000);
    }

    @And("I drag and drop candidates to folder")
    public void iDragAndDropCandidatesToFolder() throws Throwable{
        try {
            String BefCount=getDriver().findElement(By.xpath("(//a[@class='link clearfix  ui-droppable'])[1]/..//span[@class='link-count']")).getText();
            int InitialCount= Integer.parseInt(BefCount);

            String FirstCount=getDriver().findElement(By.xpath("(//a[@class='link clearfix  ui-droppable'])[1]/..//span[@class='link-count']")).getText();
            System.out.println("Initial Count = "+FirstCount);

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
            String AftCount=getDriver().findElement(By.xpath("(//a[@class='link clearfix  ui-droppable'])[1]/..//span[@class='link-count']")).getText();
            int UpdatedCount = Integer.parseInt(AftCount);
            System.out.println("Updated Count = "+AftCount);

//        Cleanup
            if (UpdatedCount == InitialCount + 2){
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
                Thread.sleep(4000);
            } else {
                System.out.println("Those candidates are already present in this folder");
            }
        }   catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("I edit and save all questions")
    public void iEditAndSaveAllQuestions() throws Throwable{

        int sections = getDriver().findElements(By.xpath("//ul[@id='asc-responses-expanded-tabs-sub']//li")).size();
        for (int a=1;a<=sections;a=a+2){
            try {
                Thread.sleep(200);
                getDriver().findElement(By.xpath("(//ul[@id='asc-responses-expanded-tabs-sub']//li)[" + a + "]")).click();
                Thread.sleep(2000);
            }catch (Exception e) {
                e.printStackTrace();
            }

            try {
                getDriver().findElement(By.xpath("//body/div[@id='wrap']/div[@id='container']/div[@id='right-system-panel']/div[@id='inner-right-system-panel']/div[@id='asc-app-record-profile-view']/div[@id='asc-job-maindata']/div[@id='asc-extended-tabs-output-holder']/div[@id='asc-staff-aboutme-one']/div[@id='personal-sub-tab']/div[@id='asc-user-custom-data']/div[@class='asc-edit-block-inner']/div[@class='asc-edit-div']/div[@class='asc-edit-readonly']/div[1]")).click();
            }catch (Exception e) {
                e.printStackTrace();
            }

            try {
                List<WebElement> radio = getDriver().findElements(By.xpath("//div[@class='asc-survey-question-answer-radio'][1]//input[@type='radio']"));
                for (WebElement element : radio) {
                    element.click();
                    Thread.sleep(1000);
                }
            }catch (Exception e) {
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
            }catch (Exception e) {
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
            }catch (Exception e) {
                e.printStackTrace();
            }

            try{
                int j = getDriver().findElements(By.xpath("//a[contains(@class,'chosen-single chosen-default')]")).size();
                for(int i=1; i<=j; i++)
                {
                    if(getDriver().findElement(By.xpath("(//a[contains(@class,'chosen-single chosen-default')])["+i+"]")).isDisplayed()){
                        getDriver().findElement(By.xpath("(//a[contains(@class,'chosen-single chosen-default')])["+i+"]")).click();
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
            }catch (Exception e) {
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
            }catch (Exception e) {
                e.printStackTrace();
            }

            try{
                if(getDriver().findElement(By.xpath("//textarea[@class='asc-survey-question-answer']")).isDisplayed()){
                    int l = getDriver().findElements(By.xpath("//textarea[@class='asc-survey-question-answer']")).size();
                    for(int k=1; k<=l; k++)
                    {
                        String uuid = UUID.randomUUID().toString();
                        getDriver().findElement(By.xpath("(//textarea[@class='asc-survey-question-answer'])["+k+"]")).click();
                        getDriver().findElement(By.xpath("(//textarea[@class='asc-survey-question-answer'])["+k+"]")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
                        getDriver().findElement(By.xpath("(//textarea[@class='asc-survey-question-answer'])["+k+"]")).sendKeys(Keys.BACK_SPACE);
                        getDriver().findElement(By.xpath("(//textarea[@class='asc-survey-question-answer'])["+k+"]")).sendKeys(uuid);
                    }
                }
            }catch (Exception e) {
                e.printStackTrace();
            }

            try{
                if(getDriver().findElement(By.xpath("//input[@class='asc-survey-question-answer asc-survey-question-answer-date  hasDatepicker']")).isDisplayed()) {
                    getDriver().findElement(By.xpath("//input[@class='asc-survey-question-answer asc-survey-question-answer-date  hasDatepicker']")).click();
                    Robot robot = new Robot();
                    robot.keyPress(KeyEvent.VK_ENTER);
                    robot.keyRelease(KeyEvent.VK_ENTER);
                }
            }catch (Exception e) {
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
            }catch (Exception e) {
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
            }catch (Exception e) {
                e.printStackTrace();
            }

            try {
                if(getDriver().findElement(By.xpath("//div[@id='asc-staff-aboutme-one']")).isDisplayed())
                {
                    int b = getDriver().findElements(By.xpath("//div[@id='asc-staff-aboutme-one']")).size();
                    for (int c=1;c<=b;c++){
                        getDriver().findElement(By.xpath("(//div[@id='asc-staff-aboutme-one']//label[3])["+c+"]")).click();
                        Thread.sleep(1000);
                    }
                }
            }catch (Exception e) {
                e.printStackTrace();
            }

            try {
                int f = getDriver().findElements(By.xpath("//iframe[contains(@title,'Rich Text Editor')]")).size();
                for (int g=1;g<=f;g++){
                    new WebDriverWait(getDriver(), 20).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("(//iframe[contains(@title,'Rich Text Editor')])["+g+"]")));
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
            }catch (Exception e) {
                e.printStackTrace();
            }

            try {
                getDriver().switchTo().defaultContent();
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='asc-dynamic-save-button']")));
                getDriver().findElement(By.xpath("//button[@id='asc-dynamic-save-button']")).click();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}