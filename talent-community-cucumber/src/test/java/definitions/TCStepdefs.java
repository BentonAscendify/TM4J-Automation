package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.id.Ketika;
import cucumber.api.java8.Th;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.util.UUID;

import static support.TestContext.getDriver;

public class TCStepdefs<session> {

    private static String randomEmail() {
        return "tessymathew+" + UUID.randomUUID().toString() + "@gmail.com";
    }

    @Given("I navigate to {string} page")
    public void iNavigateToPage(String arg0) {
        if (arg0.equalsIgnoreCase("TC Login")) {
            getDriver().get("https://master.ascendify.net/");
        }else if (arg0.equalsIgnoreCase("LinkedIn")){
            getDriver().get("https://www.linkedin.com/");
        }
    }

    @When("I click on {string} button")
    public void iClickOnButton(String arg0) throws Throwable {
        if (arg0.equalsIgnoreCase("Join Our Team")) {
            getDriver().findElement(By.xpath("//a[contains(text(),'Join Our Team »')]")).click();
        } else if (arg0.equalsIgnoreCase("Submit")) {
            getDriver().findElement(By.xpath("//button[@id='asc-signup-main-button']")).click();
            Thread.sleep(2000);
            Thread.sleep(2000);
            Thread.sleep(2000);
            Thread.sleep(2000);
            Thread.sleep(2000);
            Thread.sleep(2000);
            Thread.sleep(2000);
        } else if (arg0.equalsIgnoreCase("Apply Now")) {
            new WebDriverWait(getDriver(), 200).until(ExpectedConditions.elementToBeClickable(By.id("asc-job-apply-btn")));
            getDriver().findElement(By.xpath("//button[@id='asc-job-apply-btn']")).click();
        } else if (arg0.equalsIgnoreCase("Submit Application")) {
            getDriver().findElement(By.xpath("//button[@id='asc-job-application-survey-btn']")).click();
            Thread.sleep(38000);
        } else if (arg0.equalsIgnoreCase("Upload Your Resume")){
            getDriver().findElement(By.xpath("//span[@class='browse-btn']")).click();
        } else if (arg0.equalsIgnoreCase("Apply with LinkedIn")){
            Thread.sleep(2000);
            getDriver().manage().window().maximize();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[contains(@src,'https://www.linkedin.com')]")));
            getDriver().findElement(By.xpath("//button")).isDisplayed();
            new WebDriverWait(getDriver(), 200).until(ExpectedConditions.elementToBeClickable(By.xpath("//button")));
            getDriver().findElement(By.xpath("//button[@name='awli-button-member']")).click();
            Thread.sleep(2000);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(2000);
            getDriver().switchTo().defaultContent();
            Thread.sleep(16000);

            try {
                while (getDriver().findElement(By.xpath("//iframe[contains(@src,'https://www.linkedin.com')]")).isDisplayed()) {
                    new WebDriverWait(getDriver(), 20).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[contains(@src,'https://www.linkedin.com')]")));
                    getDriver().findElement(By.xpath("//button[@name='awli-button-member']")).click();
                    Thread.sleep(2000);
                    robot.keyPress(KeyEvent.VK_ENTER);
                    robot.keyRelease(KeyEvent.VK_ENTER);
//                Thread.sleep(2000);
                    getDriver().switchTo().defaultContent();
                    Thread.sleep(16000);
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @And("I click on link text {string}")
    public void iClickOnLinkText(String arg0) {
        if (arg0.equalsIgnoreCase("email address")) {
            getDriver().findElement(By.xpath("//*[contains(text(),'email address')]")).click();
        } else if (arg0.equalsIgnoreCase("Search Careers")) {
            new WebDriverWait(getDriver(), 200).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Search Careers')]")));
            getDriver().findElement(By.xpath("//*[contains(text(),'Search Careers')]")).click();
        } else if (arg0.equalsIgnoreCase("Tessy QA")) {
            new WebDriverWait(getDriver(), 200).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Tessy QA')]")));
            getDriver().findElement(By.xpath("//*[contains(text(),'Tessy QA')]")).click();
        } else if (arg0.equalsIgnoreCase("Sign In")) {
            getDriver().findElement(By.xpath("//a[@class='asc-signin']")).click();
        }else if (arg0.equalsIgnoreCase("Opportunity under Tessy's Org")) {
            new WebDriverWait(getDriver(), 200).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),\"Opportunity under Tessy's Org\")]")));
            getDriver().findElement(By.xpath("//a[contains(text(),\"Opportunity under Tessy's Org\")]")).click();
        }
    }

    @Then("{string} page is displayed")
    public void pageIsDisplayed(String arg0) throws Throwable {
        if (arg0.equalsIgnoreCase("Application")){
            Thread.sleep(2000);
            getDriver().findElement(By.xpath("//h2[contains(text(),'Profile Information')]")).isDisplayed();}
        else if (arg0.equalsIgnoreCase("Dashboard")) {
//            Thread.sleep(2000);
//            Thread.sleep(6000);
            try {
                if (getDriver().findElement(By.xpath("//input[@id='id_username']")).isDisplayed()) {
                    getDriver().findElement(By.xpath("//input[@id='id_username']")).sendKeys("tessy@gmail.com");
                    getDriver().findElement(By.xpath("//input[@id='id_password']")).sendKeys("Ascendify246!");
                    getDriver().findElement(By.xpath("//button[@id='asc-signin-btn']")).click();
                    Thread.sleep(2000);
                } else {
                    new WebDriverWait(getDriver(), 200).until(ExpectedConditions.elementToBeClickable(By.id("tab-profile-dashboard")));
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            new WebDriverWait(getDriver(), 200).until(ExpectedConditions.elementToBeClickable(By.id("tab-profile-dashboard")));
            getDriver().findElement(By.xpath("//*[@id='tab-profile-dashboard']")).isDisplayed();
            getDriver().findElement(By.id("tab-profile-dashboard")).isDisplayed();
        }

        else if (arg0.equalsIgnoreCase("Sign In")){
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.id("asc-signin-container")));
        }
    }

    @And("I fill in {string} fields")
    public void iFillInFields(String arg0) throws Throwable{
        if (arg0.equalsIgnoreCase("Your Information")) {
            WebElement FN = getDriver().findElement(By.xpath("//*[@id='asc-signup-firstname']"));
            String textInsideFN = FN.getAttribute("value");
            if(textInsideFN.isEmpty())
            {
                getDriver().findElement(By.xpath("//*[@id='asc-signup-firstname']")).sendKeys("Tessy");
            }

            WebElement LN = getDriver().findElement(By.xpath("//*[@id='asc-signup-lastname']"));
            String textInsideLN = LN.getAttribute("value");
            if(textInsideLN.isEmpty())
            {
                getDriver().findElement(By.xpath("//*[@id='asc-signup-lastname']")).sendKeys("Mathew");
            }

            WebElement EM = getDriver().findElement(By.xpath("//input[@id='asc-signup-email2']"));
            String textInsideEM = EM.getAttribute("value");
            if(textInsideEM.isEmpty())
            {
                final String randomEmail = randomEmail();
                getDriver().findElement(By.xpath("//input[@id='asc-signup-email2']")).sendKeys(randomEmail);
                getDriver().findElement(By.xpath("//input[@id='asc-signup-email1']")).sendKeys(randomEmail);
            }

            Thread.sleep(2000);

            WebElement PWD = getDriver().findElement(By.xpath("//input[@id='password1']"));
            String textInsidePWD = PWD.getAttribute("value");
            if(textInsidePWD.isEmpty())
            {
                getDriver().findElement(By.xpath("//input[@id='password1']")).sendKeys("Ascendify246!");
                getDriver().findElement(By.xpath("//input[@id='password2']")).sendKeys("Ascendify246!");
            }
        }

        else if(arg0.equalsIgnoreCase("Additional Information")){
            try {
                WebElement CPN = getDriver().findElement(By.xpath("//input[@id='asc-signup-cellphonenumber']"));
                String textInsideCPN = CPN.getAttribute("value");
                if(textInsideCPN.isEmpty())
                {
                    getDriver().findElement(By.xpath("//input[@id='asc-signup-cellphonenumber']")).sendKeys("610-852-8288");
                }

                WebElement PN = getDriver().findElement(By.xpath("//input[@id='asc-signup-phonenumber']"));
                String textInsidePN = PN.getAttribute("value");
                if(textInsidePN.isEmpty())
                {
                    getDriver().findElement(By.xpath("//input[@id='asc-signup-phonenumber']")).sendKeys("609-602-2709");
                }

                getDriver().findElement(By.xpath("//input[@id='asc-signup-address1']")).sendKeys("4144  Filbert Street");
                getDriver().findElement(By.xpath("//input[@id='asc-signup-city']")).sendKeys("WILDWOOD");
                getDriver().findElement(By.xpath("//input[@id='asc-signup-state']")).sendKeys("New Jersey");
                getDriver().findElement(By.xpath("//input[@id='asc-signup-postal_code']")).sendKeys("08260");
                getDriver().findElement(By.xpath("//select[@id='asc-personal-country']/option[contains(text(),'India')]")).click();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(arg0.equalsIgnoreCase("Profile Information")){
            try {
                getDriver().findElement(By.xpath("//input[@id='ct_sms']")).click();
                getDriver().findElement(By.xpath("//input[@name='ascendify[communication_preference][automated_sms_sys_msg]']")).click();
                getDriver().findElement(By.xpath("//input[@name='ascendify[communication_preference][receive_email_news_info_career_event]']")).click();
                getDriver().findElement(By.xpath("//a[@class='chosen-single chosen-default']//div//b")).click();
                getDriver().findElement(By.xpath("//div[@class='chosen-search']//input")).sendKeys("Masters Degree", Keys.ENTER);
                getDriver().findElement(By.xpath("//input[@id='asc-question-csvq_f5c1390946'][@value='Yes']")).click();
                getDriver().findElement(By.xpath("//input[@id='asc-question-csvq_26b1390947'][@value='Yes']")).click();
                getDriver().findElement(By.xpath("//input[@id='asc-question-csvq_b761390948'][@value='Yes']")).click();
                //getDriver().findElement(By.xpath("//ul[contains(@class,'chosen-choices')]")).click();
                getDriver().findElement(By.xpath("//li[contains(@class,'search-field')]")).click();
                getDriver().findElement(By.xpath("//li[contains(@class,'search-field')]//input")).sendKeys("California", Keys.ENTER);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(arg0.equalsIgnoreCase("Automatic Routing to Pipelines")){
            getDriver().findElement(By.xpath("//div//div//div//div//div//div//div//div//div//div[4]//div[1]//input[1]")).click();
        }
    }

    @And("I fill in empty fields")
    public void iFillInEmptyFields() throws Throwable{
        WebElement FN = getDriver().findElement(By.xpath("//input[@id='asc-signup-firstname']"));
        String textInsideFN = FN.getAttribute("value");
        if(textInsideFN.isEmpty())
        {
            getDriver().findElement(By.xpath("//input[@id='asc-signup-firstname']")).sendKeys("Tessy");
        }
        WebElement LN = getDriver().findElement(By.xpath("//input[@id='asc-signup-lastname']"));
        String textInsideLN = LN.getAttribute("value");
        if(textInsideLN.isEmpty())
        {
            getDriver().findElement(By.xpath("//input[@id='asc-signup-lastname']")).sendKeys("Mathew");
        }
        WebElement Email = getDriver().findElement(By.xpath("//input[@id='asc-signup-email2']"));
        String textInsideEmail = Email.getAttribute("value");
        if(textInsideEmail.isEmpty())
        {
            final String randomEmail = randomEmail();
            getDriver().findElement(By.xpath("//input[@id='asc-signup-email2']")).sendKeys(randomEmail);
            getDriver().findElement(By.xpath("//input[@id='asc-signup-email1']")).sendKeys(randomEmail);
        }
        WebElement PWD = getDriver().findElement(By.xpath("//input[@id='password1']"));
        String textInsidePWD = PWD.getAttribute("value");
        if(textInsidePWD.isEmpty())
        {
            getDriver().findElement(By.xpath("//input[@id='password1']")).sendKeys("Ascendify246!");
            getDriver().findElement(By.xpath("//input[@id='password2']")).sendKeys("Ascendify246!");
        }
        WebElement PN = getDriver().findElement(By.xpath("//input[@id='asc-signup-cellphonenumber']"));
        String textInsidePN = PN.getAttribute("value");
        if(textInsidePN.isEmpty())
        {
            getDriver().findElement(By.xpath("//input[@id='asc-signup-cellphonenumber']")).sendKeys("610-852-8288");
        }
        WebElement Adrs = getDriver().findElement(By.xpath("//input[@id='asc-signup-address1']"));
        String textInsideAdrs = Adrs.getAttribute("value");
        if(textInsideAdrs.isEmpty())
        {
            getDriver().findElement(By.xpath("//input[@id='asc-signup-address1']")).sendKeys("4144  Filbert Street");
        }
        WebElement City = getDriver().findElement(By.xpath("//input[@id='asc-signup-city']"));
        String textInsideCity = City.getAttribute("value");
        if(textInsideCity.isEmpty())
        {
            getDriver().findElement(By.xpath("//input[@id='asc-signup-city']")).sendKeys("WILDWOOD");
        }
        WebElement State = getDriver().findElement(By.xpath("//input[@id='asc-signup-state']"));
        String textInsideState = State.getAttribute("value");
        if(textInsideState.isEmpty())
        {
            getDriver().findElement(By.xpath("//input[@id='asc-signup-state']")).sendKeys("New Jersey");
        }
        WebElement zip = getDriver().findElement(By.xpath("//input[@id='asc-signup-postal_code']"));
        String textInsidezip = zip.getAttribute("value");
        if(textInsidezip.isEmpty())
        {
            getDriver().findElement(By.xpath("//input[@id='asc-signup-postal_code']")).sendKeys("08260");
        }

        try{
            WebElement Sch = getDriver().findElement(By.xpath("//input[@id='asc-signup-school']"));
            String textInsideSch = Sch.getAttribute("value");
            if(textInsideSch.isEmpty())
            {
                getDriver().findElement(By.xpath("//input[@id='asc-signup-school']")).sendKeys("Bellevue University");
            }
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='asc-signup-grad-year']")));
            WebElement Year = getDriver().findElement(By.xpath("//select[@id='asc-signup-grad-year']"));
            String textInsideYear = Year.getAttribute("value");
            if(textInsideYear.isEmpty())
            {
                getDriver().findElement(By.xpath("//select[@id='asc-signup-grad-year']/option[contains(text(),'2000')]")).click();
            }
            WebElement DT = getDriver().findElement(By.xpath("//input[@id='asc-signup-degree-type']"));
            String textInsideDT = DT.getAttribute("value");
            if(textInsideDT.isEmpty())
            {
                getDriver().findElement(By.xpath("//input[@id='asc-signup-degree-type']")).sendKeys("Management Information Systems");
            }
            WebElement Deg = getDriver().findElement(By.xpath("//input[@id='asc-signup-degree']"));
            String textInsideDeg = Deg.getAttribute("value");
            if(textInsideDeg.isEmpty())
            {
                getDriver().findElement(By.xpath("//input[@id='asc-signup-degree']")).sendKeys("MBA");
            }
//        try {
            getDriver().findElement(By.xpath("//input[@id='ct_sms']")).click();
            getDriver().findElement(By.xpath("//input[@name='ascendify[communication_preference][automated_sms_sys_msg]']")).click();
            //getDriver().findElement(By.xpath("//input[@name='ascendify[communication_preference][receive_email_news_info_career_event]']")).click();
            getDriver().findElement(By.xpath("//a[@class='chosen-single chosen-default']")).click();
            getDriver().findElement(By.xpath("//div[@class='chosen-search']//input")).sendKeys("abc", Keys.ENTER);
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("I type {string} as {string}")
    public void iType(String arg0, String arg1) throws Throwable{
        if (arg0.equalsIgnoreCase("email")) {
            getDriver().findElement(By.xpath("//input[@id='id_username']")).sendKeys(arg1);
        }
        else if (arg0.equalsIgnoreCase("Degree Type")){
            getDriver().findElement(By.xpath("//input[@id='asc-signup-degree-type']")).sendKeys(arg1);
        }
        else if (arg0.equalsIgnoreCase("Degree")){
            getDriver().findElement(By.xpath("//input[@id='asc-signup-degree']")).sendKeys(arg1);
        } else if (arg0.equalsIgnoreCase("LinkedIn email")){
            Thread.sleep(2000);
            getDriver().findElement(By.xpath("//input[@id='username']")).sendKeys(arg1);
        }
    }

//    @And("I type an unused email")
//    public void iTypeAnUnusedEmail() {
//        final String randomEmail = randomEmail();
//        getDriver().findElement(By.xpath("//input[@id='asc-signup-email2']")).sendKeys(randomEmail);
//        getDriver().findElement(By.xpath("//input[@id='asc-signup-email1']")).sendKeys(randomEmail);
//    }

    @And("I type password {string} on {string} page")
    public void iTypePasswordOnPage(String arg0, String arg1) throws Throwable {
        if (arg1.equalsIgnoreCase("Sign Up")) {
            Thread.sleep(2000);
            getDriver().findElement(By.xpath("//input[@id='password1']")).sendKeys(arg0);
            getDriver().findElement(By.xpath("//input[@id='password2']")).sendKeys(arg0);
        } else if (arg1.equalsIgnoreCase("Sign In")) {
            Thread.sleep(2000);
            getDriver().findElement(By.xpath("//input[@id='id_password']")).sendKeys(arg0);
        } else if (arg1.equalsIgnoreCase("LinkedIn Sign In")){
            Thread.sleep(2000);
            getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys(arg0);
        }
    }

    @And("I click and agree to Privacy Policy")
    public void iClickAndAgreeToPrivacyPolicy() throws Throwable {
        getDriver().findElement(By.xpath("//input[@id='asc-signup-disclosure-ck']")).click();
        Thread.sleep(2000);
    }

    @When("I click on {string} button on {string} page")
    public void iClickOnButtonOnPage(String arg0, String arg1) throws Throwable {
        if (arg1.equalsIgnoreCase("Home")) {
            getDriver().findElement(By.xpath("//a[@id='menu_sign_in']")).click();
        } else if (arg1.equalsIgnoreCase("Sign In")) {
            getDriver().findElement(By.xpath("//button[@id='asc-signin-btn']")).click();
            Thread.sleep(2000);
            Thread.sleep(2000);
        } else if (arg1.equalsIgnoreCase("LinkedIn Sign In")) {
            getDriver().findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
        }  else if (arg1.equalsIgnoreCase("LinkedIn 2nd Sign In")) {
            getDriver().findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
            Thread.sleep(2000);
            Thread.sleep(2000);
            Thread.sleep(2000);
        }
    }

    @And("I search for {string} in search box")
    public void iSearchForInSearchBox(String arg0) throws Throwable {
        getDriver().findElement(By.xpath("//input[@id='asc-map-primary-search']")).click();
        getDriver().findElement(By.xpath("//input[@id='asc-map-primary-search']")).sendKeys(arg0);
        getDriver().findElement(By.xpath("//i[@class='header-search-action-btn fa fa-search header-icon highlight-bg fa fa-search']")).click();
        Thread.sleep(2000);
    }

    @And("I make sure I haven't applied to that job already")
    public void iMakeSureIHavenTAppliedToThatJobAlready() {
        try {
            if (getDriver().findElement(By.xpath("//a[@class='asc-withdraw pull-right link']")).isDisplayed()) {
                getDriver().findElement(By.xpath("//a[@class='asc-withdraw pull-right link']")).click();
            }
            else {
                System.out.println("Not applied to this job before");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("I sign to confirm")
    public void iSignToConfirm() {
        try {
            WebElement canvasElement = getDriver().findElement(By.id("asc-esign__canvas"));
            Actions builder = new Actions(getDriver());
//        int getTopLeftY = ((canvasElement.getSize().getHeight()/2) - canvasElement.getSize().getHeight());
//        int getTopLeftX =  (canvasElement.getSize().getWidth()/2) - canvasElement.getSize().getWidth();
            Action drawAction = builder.moveToElement(canvasElement, 20, 20)
                    .clickAndHold()
                    .moveByOffset(100, 100)
                    .moveByOffset(200, 200)
                    .release()
                    .build();
            drawAction.perform();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("success message is displayed")
    public void successMessageIsDisplayed() throws Throwable{
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//li[contains(text(),'You have successfully submitted your information')]")).isDisplayed();
    }

    @And("I choose my file to be uploaded by clicking {string} button")
    public void iChooseMyFileToBeUploadedByClickingButton(String arg0) throws AWTException, Throwable, InterruptedException{
        try {
            Actions actions = new Actions(getDriver());
            actions.moveToElement(getDriver().findElement(By.id("asc-alt-upload-resume")));
            getDriver().findElement(By.id("asc-alt-upload-resume")).click();
            Thread.sleep(2000);
            uploadFile("C:\\Users\\tessy\\OneDrive\\Desktop\\Profile.pdf");
            Thread.sleep(2000);
        }
        catch (Exception exp) {
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
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    @And("I click on {string} tab")
    public void iClickOnTab(String arg0) {
        if (arg0.equalsIgnoreCase("Profile")) {
            getDriver().findElement(By.xpath("//li[@id='tab-profile']")).click();
        } else if (arg0.equalsIgnoreCase("Personal Info")) {
            getDriver().navigate().refresh();
            JavascriptExecutor jse = (JavascriptExecutor)getDriver();
            jse.executeScript("window.scrollBy(0,-540)");
            getDriver().findElement(By.xpath("//li[@id='tab-personal']")).click();
        }
    }

    @And("I add {string} info")
    public void iAdd(String arg0) throws Throwable{

        if (arg0.equalsIgnoreCase("Profile")) {
            getDriver().findElement(By.xpath("//li[@id='tab-profile']")).click();
            try {
                while (getDriver().findElement(By.xpath("//button[contains(text(),'Remove')]")).isDisplayed()) {
                    getDriver().findElement(By.xpath("//button[contains(text(),'Remove')]")).click();
                    Thread.sleep(4000);
                }
                getDriver().navigate().refresh();
                JavascriptExecutor jse = (JavascriptExecutor)getDriver();
                jse.executeScript("window.scrollBy(0,-250)");
                getDriver().findElement(By.xpath("//li[@id='tab-profile']")).click();
            }
            catch (Exception e) {
                e.printStackTrace();
            }

            getDriver().navigate().refresh();
            JavascriptExecutor jse = (JavascriptExecutor)getDriver();
            jse.executeScript("window.scrollBy(0,-250)");
            getDriver().findElement(By.xpath("//li[@id='tab-profile']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='asc-objective']//button[contains(text(),'Add')]")));
            getDriver().findElement(By.xpath("//div[@id='asc-objective']//button[contains(text(),'Add')]")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='asc-objective']//textarea[@id='asc_blurb']")));
            getDriver().findElement(By.xpath("//div[@id='asc-objective']//textarea[@id='asc_blurb']")).sendKeys("Seeking a challenging career with an MNC.");
            getDriver().findElement(By.xpath("//button[@id='asc-dynamic-save-button']")).click();

            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='asc-summary']//button[contains(text(),'Add')]")));
            getDriver().findElement(By.xpath("//div[@id='asc-summary']//button[contains(text(),'Add')]")).click();;
            getDriver().findElement(By.xpath("//div[@id='asc-summary']//textarea[@id='asc_blurb']")).sendKeys("Accomplished search engine optimization specialist with over 12 years of experience in digital marketing.");
            getDriver().findElement(By.xpath("//button[@id='asc-dynamic-save-button']")).click();

            getDriver().findElement(By.xpath("//button[@id='asc-add-exp']")).click();
            getDriver().findElement(By.xpath("//input[@placeholder='Company']")).sendKeys("Ascendify");
            Thread.sleep(100);
            getDriver().findElement(By.xpath("//form[@id='asc-add-exp-form']//input[@placeholder='Location']")).sendKeys("SFO");
            getDriver().findElement(By.xpath("//form[@id='asc-add-exp-form']//input[@placeholder='Title']")).sendKeys("QA Engineer");
            getDriver().findElement(By.xpath("//div[@class='clearfix asc-start-pos-div']//select[@name='ascendify[start_month]']/option[contains(text(),'Feb')]")).click();
            getDriver().findElement(By.xpath("//div[@class='clearfix asc-start-pos-div']//select[@name='ascendify[start_year]']/option[contains(text(),'2020')]")).click();
            getDriver().findElement(By.xpath("//input[@name='ascendify[current]']")).click();
            getDriver().findElement(By.xpath("//form[@id='asc-add-exp-form']//textarea[@placeholder='Describe your role, responsibilities and accomplishments of this position.']")).sendKeys("For the last two years, I’ve worked as a lead project manager on the redesigning of a trading platform used by 4,000 investment managers at MegaInvestments.");
            getDriver().findElement(By.xpath("//button[@id='asc-add-experience-btn']")).click();

            try {
                getDriver().findElement(By.xpath("//button[@id='asc-add-educ']")).click();
                getDriver().findElement(By.xpath("//input[@id='asc-school']")).sendKeys("Mount Bethany");
                getDriver().findElement(By.xpath("//form[@id='asc-add-educations-form']//input[@placeholder='Location']")).sendKeys("India");
                getDriver().findElement(By.xpath("//input[@placeholder='Degree Type']")).sendKeys("Masters");
                getDriver().findElement(By.xpath("//input[@id='asc-degree']")).sendKeys("M.Tech");
                getDriver().findElement(By.xpath("//div[@class='clearfix asc-education-dates']//select[@name='ascendify[month]']/option[contains(text(),'Jun')]")).click();
                getDriver().findElement(By.xpath("//div[@class='clearfix asc-education-dates']//div//select[@name='ascendify[year]']/option[contains(text(),'2011')]")).click();
                getDriver().findElement(By.xpath("//form[@id='asc-add-educations-form']//textarea[@id='asc-detail']")).sendKeys("GPA: 3.6/4.0", Keys.ENTER, "Intro to Graphic Design, AP Art, Yearbook, Computer Applications", Keys.ENTER, "Member of the National Honors Society and National Art Education Association");
                getDriver().findElement(By.xpath("//button[@id='asc-add-educations-btn']")).click();
            }
            catch (Exception e) {
                e.printStackTrace();
            }

            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='asc-add-cert']")));
            getDriver().findElement(By.xpath("//button[@id='asc-add-cert']")).click();
            getDriver().findElement(By.xpath("//form[@id='asc-add-certifications-form']//input[@id='asc-title']")).sendKeys("ASTQB Expert Level Test Manager – Managing the Test Team");
            getDriver().findElement(By.xpath("//div[@class='clearfix asc-cert-dates']//div//select[@name='ascendify[start_month]']/option[contains(text(),'Jan')]")).click();
            getDriver().findElement(By.xpath("//div[@class='clearfix asc-cert-dates']//div//select[@name='ascendify[start_year]']/option[contains(text(),'2020')]")).click();
            getDriver().findElement(By.xpath("//input[@name='ascendify[still_valid]']")).click();
            getDriver().findElement(By.xpath("//form[@id='asc-add-certifications-form']//textarea[@id='asc-detail']")).sendKeys("The certification process helped me grow tremendously as a software tester, which led to my current position as a Product Manager.");
            getDriver().findElement(By.xpath("//button[@id='asc-add-certifications-btn']")).click();

            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='asc-add-awd']")));
            getDriver().findElement(By.xpath("//button[@id='asc-add-awd']")).click();
            getDriver().findElement(By.xpath("//form[@id='asc-add-awards-form']//input[@id='asc-title']")).click();
            getDriver().findElement(By.xpath("//form[@id='asc-add-awards-form']//input[@id='asc-title']")).sendKeys("National Merit Award");
            getDriver().findElement(By.xpath("//div[@class='clearfix asc-cert-dates']//div//select[@name='ascendify[start_month]']/option[contains(text(),'Mar')]")).click();
            getDriver().findElement(By.xpath("//div[@class='clearfix asc-cert-dates']//div//select[@name='ascendify[start_year]']/option[contains(text(),'2018')]")).click();
            getDriver().findElement(By.xpath("//form[@id='asc-add-awards-form']//textarea[@id='asc-detail']")).sendKeys("Awarded first place in national competition with over 10,000 participants.");
            getDriver().findElement(By.xpath("//button[@id='asc-add-awards-btn']")).click();

            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='asc-add-mbr']")));
            getDriver().findElement(By.xpath("//button[@id='asc-add-mbr']")).click();
            getDriver().findElement(By.xpath("//form[@id='asc-add-memberships-form']//input[@id='asc-title']")).sendKeys("National Association of Sales Professionals");
            getDriver().findElement(By.xpath("//div[@class='clearfix asc-memberships-dates']//div//select[@name='ascendify[start_month]']/option[contains(text(),'Apr')]")).click();
            getDriver().findElement(By.xpath("//div[@class='clearfix asc-memberships-dates']//div//select[@name='ascendify[start_year]']/option[contains(text(),'2015')]")).click();
            getDriver().findElement(By.xpath("//div[@id='asc-membership-enddate']//div//select[@name='ascendify[end_month]']/option[contains(text(),'May')]")).click();
            getDriver().findElement(By.xpath("//div[@id='asc-membership-enddate']//div//select[@name='ascendify[end_year]']/option[contains(text(),'2017')]")).click();
            //getDriver().findElement(By.xpath("//form[@id='asc-add-memberships-form']//textarea[@id='asc-detail']")).click();
            getDriver().findElement(By.xpath("//form[@id='asc-add-memberships-form']//textarea[@id='asc-detail']")).sendKeys("Served in several leadership positions for this all-volunteer association.");
            getDriver().findElement(By.xpath("//button[@id='asc-add-memberships-btn']")).click();

            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='asc-add-mil']")));
            getDriver().findElement(By.xpath("//button[@id='asc-add-mil']")).click();
            getDriver().findElement(By.xpath("//input[@id='asc-branch']")).sendKeys("Air Force");
            getDriver().findElement(By.xpath("//input[@id='asc-location']")).sendKeys("Edwards, CA");
            getDriver().findElement(By.xpath("//input[@id='asc-position']")).sendKeys("General of the Air Force");
            getDriver().findElement(By.xpath("//div[@class='clearfix asc-military-dates']//div//select[@name='ascendify[start_month]']/option[contains(text(),'May')]")).click();
            getDriver().findElement(By.xpath("//div[@class='clearfix asc-military-dates']//div//select[@name='ascendify[start_year]']/option[contains(text(),'1990')]")).click();
            getDriver().findElement(By.xpath("//div[@class='clearfix asc-military-dates']//div//select[@name='ascendify[end_month]']/option[contains(text(),'Jun')]")).click();
            getDriver().findElement(By.xpath("//div[@class='clearfix asc-military-dates']//div//select[@name='ascendify[end_year]']/option[contains(text(),'2000')]")).click();
            getDriver().findElement(By.xpath("//form[@id='asc-add-militaries-form']//textarea[@id='asc-detail']")).sendKeys("Physicist and Nuclear Engineer managing programs and projects of technical operations and intelligence.");
            getDriver().findElement(By.xpath("//button[@id='asc-add-militaries-btn']")).click();

            try {
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='asc-add-pub']")));
                getDriver().findElement(By.xpath("//button[@id='asc-add-pub']")).click();
                getDriver().findElement(By.xpath("//form[@id='asc-add-publications-form']//input[@placeholder='Title']")).sendKeys("Speaker: “Web Design with SEO in Mind,” Covalence Conference");
                getDriver().findElement(By.xpath("//input[@placeholder='Publisher']")).sendKeys("Poulin Publishing");
                getDriver().findElement(By.xpath("//input[@placeholder='Link']")).sendKeys("https://issuu.com/brooklyntweed/docs/lbk_btf17_v1.0_issuu/28");
                getDriver().findElement(By.xpath("//div[@class='clearfix asc-publications-dates']//div//select[@name='ascendify[month]']/option[contains(text(),'Jul')]")).click();
                getDriver().findElement(By.xpath("//select[@name='ascendify[day]']/option[contains(text(),'14')]")).click();
                getDriver().findElement(By.xpath("//div[@class='clearfix asc-publications-dates']//div//select[@name='ascendify[year]']/option[contains(text(),'2019')]")).click();
                getDriver().findElement(By.xpath("//form[@id='asc-add-publications-form']//textarea[@id='asc-detail']")).sendKeys("Our work has shown that, to maximize performance, AI in embodied systems must be optimized for the specific sensors and actuators of each individual body: not just as designed, but as they work in reality.");
                getDriver().findElement(By.xpath("//button[@id='asc-add-publications-btn']")).click();
            }
            catch (Exception e) {
                e.printStackTrace();
            }

            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='asc-add-trn']")));
            getDriver().findElement(By.xpath("//button[@id='asc-add-trn']")).click();
            getDriver().findElement(By.xpath("//form[@id='asc-add-trainings-form']//input[@id='asc-title']")).sendKeys("Customer service and relationship building");
            getDriver().findElement(By.xpath("//div[@class='clearfix asc-trainings-dates']//div//select[@name='ascendify[start_month]']/option[contains(text(),'Aug')]")).click();
            getDriver().findElement(By.xpath("//div[@class='clearfix asc-trainings-dates']//div//select[@name='ascendify[start_year]']/option[contains(text(),'2013')]")).click();
            getDriver().findElement(By.xpath("//form[@id='asc-add-trainings-form']//textarea[@id='asc-detail']")).sendKeys("Senior training professionals partnering with top leadership on workforce development and skill-up strategies.");
            getDriver().findElement(By.xpath("//button[@id='asc-add-trainings-btn']")).click();

            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='asc-abilities']//button[contains(text(),'Add')]")));
            getDriver().findElement(By.xpath("//div[@id='asc-abilities']//button[contains(text(),'Add')]")).click();
            getDriver().findElement(By.xpath("//div[@id='asc-abilities']//textarea[@id='asc_blurb']")).sendKeys("Communication",Keys.ENTER,"Teamwork",Keys.ENTER,"Adaptability",Keys.ENTER,"Problem Solving",Keys.ENTER,"Creativity");
            getDriver().findElement(By.xpath("//button[@id='asc-dynamic-save-button']")).click();

            try {
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='asc-additional']//button[contains(text(),'Add')]")));
                getDriver().findElement(By.xpath("//div[@id='asc-additional']//button[contains(text(),'Add')]")).click();
                getDriver().findElement(By.xpath("//div[@id='asc-additional']//textarea[@id='asc_blurb']")).sendKeys("Exceptional familiarity with organization management principles");
                getDriver().findElement(By.xpath("//div[@id='asc-additional']//button[@id='asc-dynamic-save-button']")).click();
            }
            catch (Exception e) {
                e.printStackTrace();
            }

            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='asc-volunteer']//button[contains(text(),'Add')]")));
            getDriver().findElement(By.xpath("//div[@id='asc-volunteer']//button[contains(text(),'Add')]")).click();
            getDriver().findElement(By.xpath("//div[@id='asc-volunteer']//textarea[@id='asc_blurb']")).sendKeys("Highly committed and dedicated Church Volunteer with a strong spiritual service record and an extraordinary work ethic.");
            getDriver().findElement(By.xpath("//button[@id='asc-dynamic-save-button']")).click();
        }

        else if (arg0.equalsIgnoreCase("Personal")) {
            getDriver().navigate().refresh();
            JavascriptExecutor jse = (JavascriptExecutor)getDriver();
            jse.executeScript("window.scrollBy(0,-540)");
            getDriver().findElement(By.xpath("//li[@id='tab-personal']")).click();

            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//h4[contains(text(),'Headline')]")));
            getDriver().findElement(By.xpath("//h4[contains(text(),'Headline')]")).click();
            getDriver().findElement(By.xpath("//textarea[@id='asc-blurb']")).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
            getDriver().findElement(By.xpath("//textarea[@id='asc-blurb']")).sendKeys("Award-Winning Editor Skilled in Web Design.");
            getDriver().findElement(By.xpath("//button[@id='asc-dynamic-save-button']")).click();

            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//h4[contains(text(),'Contact Data')]")));
            getDriver().findElement(By.xpath("//h4[contains(text(),'Contact Data')]")).click();
            getDriver().findElement(By.xpath("//input[@id='asc-firstname']")).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
            getDriver().findElement(By.xpath("//input[@id='asc-firstname']")).sendKeys("Tessy");
            getDriver().findElement(By.xpath("//input[@id='asc-lastname']")).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
            getDriver().findElement(By.xpath("//input[@id='asc-lastname']")).sendKeys("Mathew");
            getDriver().findElement(By.xpath("//input[@id='asc-email']")).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
            getDriver().findElement(By.xpath("//input[@id='asc-email']")).sendKeys("tessy@gmail.com");
            getDriver().findElement(By.xpath("//input[@id='asc-cellphone']")).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
            getDriver().findElement(By.xpath("//input[@id='asc-cellphone']")).sendKeys("610-852-8288");
            getDriver().findElement(By.xpath("//input[@id='asc-phone']")).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
            getDriver().findElement(By.xpath("//input[@id='asc-phone']")).sendKeys("609-602-2709");
            getDriver().findElement(By.xpath("//input[@id='user-address1']")).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
            getDriver().findElement(By.xpath("//input[@id='user-address1']")).sendKeys("4144  Filbert Street");
            getDriver().findElement(By.xpath("//input[@id='user-address2']")).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
            getDriver().findElement(By.xpath("//input[@id='user-address2']")).sendKeys("2553  Richison Drive");
            getDriver().findElement(By.xpath("//input[@id='user-city']")).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
            getDriver().findElement(By.xpath("//input[@id='user-city']")).sendKeys("WILDWOOD");
            getDriver().findElement(By.xpath("//input[@id='user-state']")).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
            getDriver().findElement(By.xpath("//input[@id='user-state']")).sendKeys("New Jersey");
            getDriver().findElement(By.xpath("//input[@id='user-zipcode']")).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
            getDriver().findElement(By.xpath("//input[@id='user-zipcode']")).sendKeys("08260");
            getDriver().findElement(By.xpath("//div[@id='asc_personal_country_chosen']")).click();
            getDriver().findElement(By.xpath("//div[@id='asc_personal_country_chosen']//input")).sendKeys("United States of America");
            getDriver().findElement(By.xpath("//input[@id='asc-site-site_linkedin']")).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
            getDriver().findElement(By.xpath("//input[@id='asc-site-site_linkedin']")).sendKeys("https://www.linkedin.com/in/tessy-anicattu-mathew-4b407119a/");
            getDriver().findElement(By.xpath("//button[@id='asc-dynamic-save-button']")).click();
            Thread.sleep(2000);

            try {
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//h4[contains(text(),'Profile Information')]")));
                getDriver().findElement(By.xpath("//div[@id='asc-user-custom-data']//button[@class='btn btn-primary asc-edit-icon btn-sm'][contains(text(),'Edit')]")).click();
                getDriver().findElement(By.xpath("//div[@id='asc_question_csvq_a571390945_chosen']")).click();
                getDriver().findElement(By.xpath("//div[@id='asc_question_csvq_a571390945_chosen']")).click();
                Thread.sleep(4000);
                getDriver().findElement(By.xpath("//div[@id='asc_question_csvq_a571390945_chosen']//div[@class='chosen-search']")).click();
                getDriver().findElement(By.xpath("//div[@id='asc_question_csvq_a571390945_chosen']//div[@class='chosen-search']")).sendKeys("Masters Degree", Keys.ENTER);
                getDriver().findElement(By.cssSelector("input#asc-question-csvq_f5c1390946[value='Yes']")).click();
                getDriver().findElement(By.cssSelector("input#asc-question-csvq_26b1390947[value='Yes']")).click();
                getDriver().findElement(By.cssSelector("input#asc-question-csvq_b761390948[value='Yes']")).click();
                getDriver().findElement(By.xpath("//li[@class='search-field']")).click();
                getDriver().findElement(By.xpath("//li[@class='search-field']//input")).sendKeys("California",Keys.ENTER);
                getDriver().findElement(By.xpath("//button[@id='asc-dynamic-save-button']")).click();
            }
            catch (Exception e) {
                e.printStackTrace();
            }

            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='asc-user-cc305-data']//button[contains(text(),'Edit')]")));
            getDriver().findElement(By.xpath("//div[@id='asc-user-cc305-data']//button[contains(text(),'Edit')]")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='asc_question_csvq_3441121494_chosen']")));
            getDriver().findElement(By.xpath("//div[@id='asc_question_csvq_3441121494_chosen']")).click();
            getDriver().findElement(By.xpath("//div[@id='asc_question_csvq_3441121494_chosen']//input")).sendKeys("NO, I DON'T HAVE A DISABILITY",Keys.ENTER);
            getDriver().findElement(By.xpath("//div[@id='asc-user-cc305-data']//button[@id='asc-dynamic-save-button']")).click();

            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//h4[contains(text(),'EEO Information')]")));
            getDriver().findElement(By.xpath("//div[@id='asc-user-eeoc-data']//button[@class='btn btn-primary asc-edit-icon btn-sm'][contains(text(),'Edit')]")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='asc_question_csvq_ddd1121493_chosen']")));
            getDriver().findElement(By.xpath("//div[@id='asc_question_csvq_ddd1121493_chosen']")).click();
            getDriver().findElement(By.xpath("//div[@id='asc_question_csvq_ddd1121493_chosen']//input")).sendKeys("Asian",Keys.ENTER);
            getDriver().findElement(By.xpath("//div[@id='asc_question_csvq_d621121492_chosen']")).click();
            getDriver().findElement(By.xpath("//div[@id='asc_question_csvq_d621121492_chosen']//input")).sendKeys("Female",Keys.ENTER);
            getDriver().findElement(By.xpath("//div[@id='asc_question_csvq_fb71121491_chosen']")).click();
            getDriver().findElement(By.xpath("//div[@id='asc_question_csvq_fb71121491_chosen']//input")).sendKeys("I identify as one or more of the classifications of protected veteran listed above",Keys.ENTER);
            getDriver().findElement(By.xpath("//div[@id='asc-user-eeoc-data']//button[@id='asc-dynamic-save-button']")).click();

            try {
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//h4[contains(text(),'Account Management')]")));
                getDriver().findElement(By.xpath("//span[contains(text(),'Change Password')]")).click();
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='button-holder']//button[contains(text(),'Cancel')]")));
                getDriver().findElement(By.xpath("//div[@id='button-holder']//button[contains(text(),'Cancel')]")).click();
            } catch (Exception e) {
                e.printStackTrace();
            }

            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//h4[contains(text(),'Pipelines')]")));
            getDriver().findElement(By.xpath("//div[@id='asc-personal-pipelineviews']//button[contains(text(),'Edit')]")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='select-pipelines']")));
            getDriver().findElement(By.xpath("//input[@id='select-pipelines']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Software testing')]")));
            getDriver().findElement(By.xpath("//input[@id='asc-pipeline-pipe_f32b1000000000011081']")).click();
            getDriver().findElement(By.xpath("//div[@id='asc-personal-pipelineviews']//button[@id='asc-dynamic-save-button']")).click();
        }
    }
}