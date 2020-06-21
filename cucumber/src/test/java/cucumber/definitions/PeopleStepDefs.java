package cucumber.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static cucumber.support.AbstractContext.getConfig;
import static cucumber.support.TestContext.getDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class PeopleStepDefs {

    private static String randomEmail() {
        return "tessymathew+" + UUID.randomUUID().toString() + "@gmail.com";
    }

    @And("I click on {string} button PT")
    public void iClickOnButton(String arg0) throws Throwable {
        if (arg0.equalsIgnoreCase("New")) {
            getDriver().findElement(By.xpath("//span[@id='asc-add-candidate']")).click();
        } else if (arg0.equalsIgnoreCase("Import")) {
            Thread.sleep(2000);
            getDriver().findElement(By.xpath("//button[contains(text(),'Import')]")).click();
        } else if (arg0.equalsIgnoreCase("Add Profile")) {
            getDriver().findElement(By.xpath("//button[@id='asc-add-user-btn']")).click();
        }
    }

    String name;

    @Then("{string} page is displayed PT")
    public void pageIsDisplayed(String arg0) throws Throwable {
        if (arg0.equalsIgnoreCase("Main Menu")) {
            Thread.sleep(8000);
            new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Main Menu')]")));
            getDriver().findElement(By.xpath("//span[contains(text(),'Main Menu')]")).isDisplayed();
            name = getDriver().findElement(By.xpath("//div[@class='middle-tile']//div[@class='asc-list-name highlight']//a")).getText();
        } else if (arg0.equalsIgnoreCase("Data Mapping")) {
            Thread.sleep(20000);
            getDriver().findElement(By.xpath("//h3[@class='asc-admin-header']")).isDisplayed();
        }
    }

    @And("I click on {string} tab PT")
    public void iClickOnTa(String arg0) throws Throwable {
        if (arg0.equalsIgnoreCase("People")) {
            Thread.sleep(2000);
            try {
                String handle = getDriver().getWindowHandle();
                getDriver().switchTo().window(handle);
            } catch (Exception e) {
                e.printStackTrace();
            }
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='section-tab']")));
            getDriver().findElement(By.xpath("//div[@class='section-tab']")).click();
            while (getDriver().findElement(By.xpath("//ul[@class='sections-menu nav navbar-nav']")).isDisplayed() == false) {
                try {
                    getDriver().findElement(By.xpath("//div[@class='section-tab']")).click();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Thread.sleep(2000);
            }
            WebElement cancel = getDriver().findElement(By.xpath("//a[@href='/people']"));
            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", cancel);
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/people']")));
            getDriver().findElement(By.xpath("//a[@href='/people']")).click();
            try {
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (getDriver().findElements(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")).size() == 0) {
                getDriver().findElement(By.xpath("//button[@id='candidate-status-filter-btn']")).click();
                getDriver().findElement(By.xpath("//input[@id='asc-all']")).click();
                getDriver().findElement(By.xpath("//div[@id='asc-show-all']")).click();
            }
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")));
        } else if (arg0.equalsIgnoreCase("Responses")) {
            Thread.sleep(2000);
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='tab-staff-aboutme-one']")));
            getDriver().findElement(By.xpath("//li[@id='tab-staff-aboutme-one']")).click();
            while (getDriver().findElement(By.xpath("//div[@class='list-inline-wrapper']")).isDisplayed() == false) {
                getDriver().findElement(By.xpath("//li[@id='tab-staff-aboutme-one']")).click();
                Thread.sleep(2000);
            }
        }
    }

    @And("I navigate to {string} PT")
    public void iNavigateTo(String arg0) throws Throwable {
        Thread.sleep(2000);
        if (arg0.equalsIgnoreCase("Upload a CSV file")) {
            getDriver().findElement(By.xpath("//a[@id='asc-add-candidate-csv']")).click();
        } else if (arg0.equalsIgnoreCase("Bulk Add")) {
            getDriver().findElement(By.xpath("//a[@id='asc-add-bulk-candidate-manually']")).click();
        } else if (arg0.equalsIgnoreCase("Add Manually")) {
            getDriver().findElement(By.xpath("//a[@id='asc-add-candidate-manually']")).click();
        }
    }

    String email;
    String list;
    String LN;
    String uuid = UUID.randomUUID().toString();

    @Then("I manually add new user's profile PT")
    public void iManuallyAddNewUserSProfilePT() throws Throwable {
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Add New Profile')]")));
        getDriver().findElement(By.xpath("//input[@id='asc-firstname']")).sendKeys("Manual");
        getDriver().findElement(By.xpath("//input[@id='asc-lastname']")).sendKeys(uuid);
        LN = uuid;
        final String randomEmail = randomEmail();
        getDriver().findElement(By.xpath("//input[@id='asc-email']")).sendKeys(randomEmail);
        email = randomEmail;
        System.out.println("Manual Added User Email = " + randomEmail);
        getDriver().findElement(By.xpath("//input[@id='asc-cellphone']")).sendKeys("610-852-8288");
        getDriver().findElement(By.xpath("//input[@id='asc-phone']")).sendKeys("609-602-2709");
        getDriver().findElement(By.xpath("//input[@id='user-address1']")).sendKeys("4144  Filbert Street");
        getDriver().findElement(By.xpath("//input[@id='user-address2']")).sendKeys("877  Westfall Avenue");
        getDriver().findElement(By.xpath("//input[@id='user-city']")).sendKeys("WILDWOOD");
        getDriver().findElement(By.xpath("//input[@id='user-state']")).sendKeys("New Jersey");
        getDriver().findElement(By.xpath("//input[@id='user-zipcode']")).sendKeys("08260");
        getDriver().findElement(By.xpath("//div[@id='asc_personal_country_chosen']//a[@class='chosen-single chosen-default']")).click();
        while (getDriver().findElement(By.xpath("//div[@id='asc_personal_country_chosen']//a[@class='chosen-single chosen-default']/..//li[2]")).isDisplayed() == false) {
            getDriver().findElement(By.xpath("//div[@id='asc_personal_country_chosen']//a[@class='chosen-single chosen-default']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='asc_personal_country_chosen']//a[@class='chosen-single chosen-default']/..//li[2]")));
        }
        getDriver().findElement(By.xpath("//div[@id='asc_personal_country_chosen']//a[@class='chosen-single chosen-default']/..//li[2]")).click();
        getDriver().findElement(By.xpath("//input[@id='asc-site-site_linkedin']")).sendKeys("https://www.linkedin.com/in/tessy-anicattu-mathew-4b407119a/");
        getDriver().findElement(By.xpath("//select[@id='asc-client-crm-status-field']")).click();
        getDriver().findElement(By.xpath("//select[@id='asc-client-crm-status-field']//option[2]")).click();
        getDriver().findElement(By.xpath("//div[@id='asc_group_select_chosen']//input")).click();
        getDriver().findElement(By.xpath("//div[@id='asc_group_select_chosen']//ul[@class='chosen-results']//li[2]")).click();
        getDriver().findElement(By.xpath("//select[@id='asc-basic-source-field']")).click();
        getDriver().findElement(By.xpath("//select[@id='asc-basic-source-field']//optgroup[2]//option[1]")).click();
        getDriver().findElement(By.xpath("//select[@id='asc-basic-recruiter-field']")).click();
        getDriver().findElement(By.xpath("//select[@id='asc-basic-recruiter-field']//option[2]")).click();
        getDriver().findElement(By.xpath("//input[@id='asc-add-user-quick-comment']")).sendKeys("This is a quick comment");
        getDriver().findElement(By.xpath("//a[@id='asc-add-new-org-text-box']")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[contains(@name,'ascendify[client_user_partner_org]')])[2]")));
        getDriver().findElement(By.xpath("(//select[contains(@name,'ascendify[client_user_partner_org]')])[2]")).click();
        getDriver().findElement(By.xpath("(//select[contains(@name,'ascendify[client_user_partner_org]')])[2]//option[2]")).click();
        getDriver().findElement(By.xpath("//span[@class='trash-can']")).click();
        getDriver().findElement(By.xpath("//button[@class='btn btn-xs btn-danger asc-del-confirm']")).click();
        getDriver().findElement(By.xpath("//input[@id='asc-add-user-tag-input']")).sendKeys("Tag One");
        getDriver().findElement(By.xpath("//button[@id='asc-asd-user-tag-btn']")).click();
        getDriver().findElement(By.xpath("//i[@class='link asc-skills-close asc-icons-close fa fa-times']")).click();

        getDriver().findElement(By.xpath("//a[@class='asc-add-user-summary-link'][contains(text(),'My List')]")).click();
        if (getDriver().findElements(By.xpath("//select[@id='folder-list']//option[1]")).size() != 0) {
            getDriver().findElement(By.xpath("//select[@id='folder-list']//option[1]")).click();
            getDriver().findElement(By.xpath("//span//a[@class='reset-select'][contains(text(),'Clear')]")).click();
            getDriver().findElement(By.xpath("//select[@id='folder-list']//option[1]")).click();
        }
        getDriver().findElement(By.xpath("//div[@class='asc-new-user-new-folder']//a[contains(text(),'New')]")).click();
        String uuid = UUID.randomUUID().toString();
        getDriver().findElement(By.xpath("//div[@class='asc-new-user-new-folder-text-div']//input[@placeholder='Name your list']")).sendKeys(uuid);
        list = uuid;

        if (getDriver().findElements(By.xpath("//a[contains(text(),'My Open Requisitions')]")).size() != 0) {
            getDriver().findElement(By.xpath("//a[contains(text(),'My Open Requisitions')]")).click();
            if (getDriver().findElements(By.xpath("//select[@id='asc-add-user-to-req-select']//option[1]")).size() != 0) {
                getDriver().findElement(By.xpath("//select[@id='asc-add-user-to-req-select']//option[1]")).click();
                getDriver().findElement(By.xpath("//a[contains(text(),'My Open Requisitions')]/../..//a[@class='reset-select'][contains(text(),'Clear')]")).click();
                getDriver().findElement(By.xpath("//select[@id='asc-add-user-to-req-select']//option[1]")).click();
            }
        }

        if (getDriver().findElements(By.xpath("//a[contains(text(),'My Open Resume Collections')]")).size() != 0) {
            getDriver().findElement(By.xpath("//a[contains(text(),'My Open Resume Collections')]")).click();
            if (getDriver().findElements(By.xpath("//a[contains(text(),'My Open Resume Collections')]/../..//select//option[1]")).size() != 0) {
                getDriver().findElement(By.xpath("//a[contains(text(),'My Open Resume Collections')]/../..//select//option[1]")).click();
                getDriver().findElement(By.xpath("//a[contains(text(),'My Open Resume Collections')]/../..//a[@class='reset-select'][contains(text(),'Clear')]")).click();
                getDriver().findElement(By.xpath("//a[contains(text(),'My Open Resume Collections')]/../..//select//option[1]")).click();
            }
        }

        if (getDriver().findElements(By.xpath("//a[contains(text(),'My Pipeline')]")).size() != 0) {
            getDriver().findElement(By.xpath("//a[contains(text(),'My Pipeline')]")).click();
            if (getDriver().findElements(By.xpath("//a[contains(text(),'My Pipeline')]/../..//select//optgroup[1]//option[1]")).size() != 0) {
                getDriver().findElement(By.xpath("//a[contains(text(),'My Pipeline')]/../..//select//optgroup[1]//option[1]")).click();
                getDriver().findElement(By.xpath("//a[contains(text(),'My Pipeline')]/../..//a[@class='reset-select'][contains(text(),'Clear')]")).click();
                getDriver().findElement(By.xpath("//a[contains(text(),'My Pipeline')]/../..//select//optgroup[1]//option[1]")).click();
            }
        }
    }

    @And("I make sure that Organize functions in the form are working as expected PT")
    public void iMakeSureThatOrganizeFunctionsInTheFormAreWorkingAsExpected() {
        if (getDriver().findElements(By.xpath("//span[contains(text(),'My List')]/..//span[contains(@class,'show-all link fa fa-ellipsis-h')]")).size() != 0) {
            getDriver().findElement(By.xpath("//span[contains(text(),'My List')]/..//span[contains(@class,'show-all link fa fa-ellipsis-h')]")).click();
        }
        getDriver().findElement(By.xpath("//div[contains(@class,'link-text')][contains(text(),'" + list + "')]")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='asc-sort-by-div']")));
        getDriver().findElement(By.xpath("//span[@id='asc-sort-by-div']")).click();
        getDriver().findElement(By.xpath("//*[@data-field='client_users.created DESC']")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")));
        getDriver().findElement(By.xpath("(//div[@class='asc-list-inner-div'])[1]//div[@class='link asc-list-name highlight'][contains(text(),'Manual " + LN + "')]")).isDisplayed();

        if (getDriver().findElements(By.xpath("//span[contains(text(),'My List')]/../..//li[1]//a[1]")).size() != 0) {
            getDriver().findElement(By.xpath("//span[contains(text(),'My List')]/../..//li[1]//a[1]")).click();
            try {
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='asc-sort-by-div']")));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (getDriver().findElement(By.xpath("//span[@id='asc-sort-by-div']")).isDisplayed() == true) {
                getDriver().findElement(By.xpath("//span[@id='asc-sort-by-div']")).click();
                getDriver().findElement(By.xpath("//*[@data-field='client_users.created DESC']")).click();
            }
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")));
            getDriver().findElement(By.xpath("(//div[@class='asc-list-inner-div'])[1]//div[@class='link asc-list-name highlight'][contains(text(),'Manual " + LN + "')]")).isDisplayed();
        }

        if (getDriver().findElements(By.xpath("//span[contains(text(),'My Open Requisitions')]/../..//li[1]//a[1]")).size() != 0) {
            getDriver().findElement(By.xpath("//span[contains(text(),'My Open Requisitions')]/../..//li[1]//a[1]")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='asc-sort-by-div']")));
            getDriver().findElement(By.xpath("//span[@id='asc-sort-by-div']")).click();
            getDriver().findElement(By.xpath("//a[@id='asc-sort-folder-created']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")));
            getDriver().findElement(By.xpath("(//div[@class='asc-list-inner-div'])[1]//div[@class='link asc-list-name highlight'][contains(text(),'Manual " + LN + "')]")).isDisplayed();
        }

        if (getDriver().findElements(By.xpath("//span[contains(text(),'My Open Resume Collections')]/../..//li[1]//a[1]")).size() != 0) {
            getDriver().findElement(By.xpath("//span[contains(text(),'My Open Resume Collections')]/../..//li[1]//a[1]")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='asc-sort-by-div']")));
            getDriver().findElement(By.xpath("//span[@id='asc-sort-by-div']")).click();
            getDriver().findElement(By.xpath("//a[@id='asc-sort-folder-created']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")));
            getDriver().findElement(By.xpath("(//div[@class='asc-list-inner-div'])[1]//div[@class='link asc-list-name highlight'][contains(text(),'Manual " + LN + "')]")).isDisplayed();
        }

        if (getDriver().findElements(By.xpath("(//span[contains(text(),'My Pipeline')]/../..//a[1]/..//ul[1]//li[1]//a[1])[1]")).size() != 0) {
            getDriver().findElement(By.xpath("(//span[contains(text(),'My Pipeline')]/../..//a[1]/..//ul[1]//li[1]//a[1])[1]")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")));
            getDriver().findElement(By.xpath("//span[@id='asc-sort-by-div']")).click();
            getDriver().findElement(By.xpath("//*[@data-field='client_users.created DESC']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")));
            getDriver().findElement(By.xpath("(//div[@class='asc-list-inner-div'])[1]//div[@class='link asc-list-name highlight'][contains(text(),'Manual " + LN + "')]")).isDisplayed();
        }
    }

    @And("I choose my file to be uploaded by clicking {string} button PT")
    public void iChooseMyFileToBeUploadedByClickingButton(String arg0) throws AWTException, Throwable, InterruptedException {
        Thread.sleep(2000);
        if (arg0.equalsIgnoreCase("Upload a File")) {
            Actions actions = new Actions(getDriver());
            actions.moveToElement(getDriver().findElement(By.id("asc-bulk-upload-div")));

            URL resumeUrl = getClass().getClassLoader().getResource("resumes/profiles-import.csv");
            if (resumeUrl != null) {
                File resumeFile = new File(resumeUrl.getFile());
                getDriver().findElement(By.xpath("//input[@name='asc-csv']")).sendKeys(resumeFile.getAbsolutePath());
                Thread.sleep(2000);
            } else {
                throw new Exception("Failed to find csv absolute path");
            }
            Thread.sleep(2000);
        } else if (arg0.equalsIgnoreCase("Drop Files")) {
            Actions actions = new Actions(getDriver());
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.id("asc-bulk-upload-users-form")));
            actions.moveToElement(getDriver().findElement(By.id("asc-bulk-upload-users-form")));

            URL resumeUrl1 = getClass().getClassLoader().getResource("resumes/Records/Profile(1).pdf");
            URL resumeUrl2 = getClass().getClassLoader().getResource("resumes/Records/Profile(2).pdf");
            URL resumeUrl3 = getClass().getClassLoader().getResource("resumes/Records/Profile(3).pdf");
            URL resumeUrl4 = getClass().getClassLoader().getResource("resumes/Records/Profile(4).pdf");
            URL resumeUrl5 = getClass().getClassLoader().getResource("resumes/Records/Profile(5).pdf");
            URL resumeUrl6 = getClass().getClassLoader().getResource("resumes/Records/Profile(6).pdf");
            URL resumeUrl7 = getClass().getClassLoader().getResource("resumes/Records/Profile(7).pdf");
            URL resumeUrl8 = getClass().getClassLoader().getResource("resumes/Records/Profile(8).pdf");
            URL resumeUrl9 = getClass().getClassLoader().getResource("resumes/Records/Profile(9).pdf");
            URL resumeUrl10 = getClass().getClassLoader().getResource("resumes/Records/Profile(10).pdf");
            URL resumeUrl11 = getClass().getClassLoader().getResource("resumes/Records/Profile(11).pdf");
            URL resumeUrl12 = getClass().getClassLoader().getResource("resumes/Records/Profile(12).pdf");
            URL resumeUrl13 = getClass().getClassLoader().getResource("resumes/Records/Profile(13).pdf");
            URL resumeUrl14 = getClass().getClassLoader().getResource("resumes/Records/Profile(14).pdf");
            URL resumeUrl15 = getClass().getClassLoader().getResource("resumes/Records/Profile(15).pdf");
            URL resumeUrl16 = getClass().getClassLoader().getResource("resumes/Records/Profile(16).pdf");
            URL resumeUrl17 = getClass().getClassLoader().getResource("resumes/Records/Profile(17).pdf");
            URL resumeUrl18 = getClass().getClassLoader().getResource("resumes/Records/Profile(18).pdf");
            URL resumeUrl19 = getClass().getClassLoader().getResource("resumes/Records/Profile(19).pdf");
            URL resumeUrl20 = getClass().getClassLoader().getResource("resumes/Records/Profile(20).pdf");
            URL resumeUrl21 = getClass().getClassLoader().getResource("resumes/Records/Profile(21).pdf");
            URL resumeUrl22 = getClass().getClassLoader().getResource("resumes/Records/Profile(22).pdf");
            URL resumeUrl23 = getClass().getClassLoader().getResource("resumes/Records/Profile(23).pdf");
            URL resumeUrl24 = getClass().getClassLoader().getResource("resumes/Records/Profile(24).pdf");
            URL resumeUrl25 = getClass().getClassLoader().getResource("resumes/Records/Profile(25).pdf");
            URL resumeUrl26 = getClass().getClassLoader().getResource("resumes/Records/Profile(26).pdf");
            URL resumeUrl27 = getClass().getClassLoader().getResource("resumes/Records/Profile(27).pdf");
            URL resumeUrl28 = getClass().getClassLoader().getResource("resumes/Records/Profile(28).pdf");
            URL resumeUrl29 = getClass().getClassLoader().getResource("resumes/Records/Profile(29).pdf");
            URL resumeUrl30 = getClass().getClassLoader().getResource("resumes/Records/Profile(30).pdf");
            URL resumeUrl31 = getClass().getClassLoader().getResource("resumes/Records/Profile(31).pdf");
            URL resumeUrl32 = getClass().getClassLoader().getResource("resumes/Records/Profile(32).pdf");
            URL resumeUrl33 = getClass().getClassLoader().getResource("resumes/Records/Profile(33).pdf");
            URL resumeUrl34 = getClass().getClassLoader().getResource("resumes/Records/Profile(34).pdf");
            URL resumeUrl35 = getClass().getClassLoader().getResource("resumes/Records/Profile(35).pdf");
            URL resumeUrl36 = getClass().getClassLoader().getResource("resumes/Records/Profile(36).pdf");
            URL resumeUrl37 = getClass().getClassLoader().getResource("resumes/Records/Profile(37).pdf");
            URL resumeUrl38 = getClass().getClassLoader().getResource("resumes/Records/Profile(38).pdf");
            URL resumeUrl39 = getClass().getClassLoader().getResource("resumes/Records/Profile(39).pdf");
            URL resumeUrl40 = getClass().getClassLoader().getResource("resumes/Records/Profile(40).pdf");
            URL resumeUrl41 = getClass().getClassLoader().getResource("resumes/Records/Profile(41).pdf");
            URL resumeUrl42 = getClass().getClassLoader().getResource("resumes/Records/Profile(42).pdf");
            URL resumeUrl43 = getClass().getClassLoader().getResource("resumes/Records/Profile(43).pdf");
            URL resumeUrl44 = getClass().getClassLoader().getResource("resumes/Records/Profile(44).pdf");
            URL resumeUrl45 = getClass().getClassLoader().getResource("resumes/Records/Profile(45).pdf");
            URL resumeUrl46 = getClass().getClassLoader().getResource("resumes/Records/Profile(46).pdf");
            URL resumeUrl47 = getClass().getClassLoader().getResource("resumes/Records/Profile(47).pdf");
            URL resumeUrl48 = getClass().getClassLoader().getResource("resumes/Records/Profile(48).pdf");
            URL resumeUrl49 = getClass().getClassLoader().getResource("resumes/Records/Profile(49).pdf");
            URL resumeUrl50 = getClass().getClassLoader().getResource("resumes/Records/Profile(50).pdf");
            if (resumeUrl1 != null) {
                File resumeFile1 = new File(resumeUrl1.getFile());
                File resumeFile2 = new File(resumeUrl2.getFile());
                File resumeFile3 = new File(resumeUrl3.getFile());
                File resumeFile4 = new File(resumeUrl4.getFile());
                File resumeFile5 = new File(resumeUrl5.getFile());
                File resumeFile6 = new File(resumeUrl6.getFile());
                File resumeFile7 = new File(resumeUrl7.getFile());
                File resumeFile8 = new File(resumeUrl8.getFile());
                File resumeFile9 = new File(resumeUrl9.getFile());
                File resumeFile10 = new File(resumeUrl10.getFile());
                File resumeFile11 = new File(resumeUrl11.getFile());
                File resumeFile12 = new File(resumeUrl12.getFile());
                File resumeFile13 = new File(resumeUrl13.getFile());
                File resumeFile14 = new File(resumeUrl14.getFile());
                File resumeFile15 = new File(resumeUrl15.getFile());
                File resumeFile16 = new File(resumeUrl16.getFile());
                File resumeFile17 = new File(resumeUrl17.getFile());
                File resumeFile18 = new File(resumeUrl18.getFile());
                File resumeFile19 = new File(resumeUrl19.getFile());
                File resumeFile20 = new File(resumeUrl20.getFile());
                File resumeFile21 = new File(resumeUrl21.getFile());
                File resumeFile22 = new File(resumeUrl22.getFile());
                File resumeFile23 = new File(resumeUrl23.getFile());
                File resumeFile24 = new File(resumeUrl24.getFile());
                File resumeFile25 = new File(resumeUrl25.getFile());
                File resumeFile26 = new File(resumeUrl26.getFile());
                File resumeFile27 = new File(resumeUrl27.getFile());
                File resumeFile28 = new File(resumeUrl28.getFile());
                File resumeFile29 = new File(resumeUrl29.getFile());
                File resumeFile30 = new File(resumeUrl30.getFile());
                File resumeFile31 = new File(resumeUrl31.getFile());
                File resumeFile32 = new File(resumeUrl32.getFile());
                File resumeFile33 = new File(resumeUrl33.getFile());
                File resumeFile34 = new File(resumeUrl34.getFile());
                File resumeFile35 = new File(resumeUrl35.getFile());
                File resumeFile36 = new File(resumeUrl36.getFile());
                File resumeFile37 = new File(resumeUrl37.getFile());
                File resumeFile38 = new File(resumeUrl38.getFile());
                File resumeFile39 = new File(resumeUrl39.getFile());
                File resumeFile40 = new File(resumeUrl40.getFile());
                File resumeFile41 = new File(resumeUrl41.getFile());
                File resumeFile42 = new File(resumeUrl42.getFile());
                File resumeFile43 = new File(resumeUrl43.getFile());
                File resumeFile44 = new File(resumeUrl44.getFile());
                File resumeFile45 = new File(resumeUrl45.getFile());
                File resumeFile46 = new File(resumeUrl46.getFile());
                File resumeFile47 = new File(resumeUrl47.getFile());
                File resumeFile48 = new File(resumeUrl48.getFile());
                File resumeFile49 = new File(resumeUrl49.getFile());
                File resumeFile50 = new File(resumeUrl50.getFile());

                getDriver().findElement(By.xpath("//input[@class='dz-hidden-input']")).sendKeys(resumeFile1.getAbsolutePath() + "\n" + resumeFile2.getAbsolutePath() + "\n" + resumeFile3.getAbsolutePath() + "\n" + resumeFile4.getAbsolutePath() + "\n" + resumeFile5.getAbsolutePath() + "\n" + resumeFile6.getAbsolutePath() + "\n" + resumeFile7.getAbsolutePath() + "\n" + resumeFile8.getAbsolutePath() + "\n" + resumeFile9.getAbsolutePath() + "\n" + resumeFile10.getAbsolutePath() + "\n" + resumeFile11.getAbsolutePath() + "\n" + resumeFile12.getAbsolutePath() + "\n" + resumeFile13.getAbsolutePath() + "\n" + resumeFile14.getAbsolutePath() + "\n" + resumeFile15.getAbsolutePath() + "\n" + resumeFile16.getAbsolutePath() + "\n" + resumeFile17.getAbsolutePath() + "\n" + resumeFile18.getAbsolutePath() + "\n" + resumeFile19.getAbsolutePath() + "\n" + resumeFile20.getAbsolutePath() + "\n" + resumeFile21.getAbsolutePath() + "\n" + resumeFile22.getAbsolutePath() + "\n" + resumeFile23.getAbsolutePath() + "\n" + resumeFile24.getAbsolutePath() + "\n" + resumeFile25.getAbsolutePath() + "\n" + resumeFile26.getAbsolutePath() + "\n" + resumeFile27.getAbsolutePath() + "\n" + resumeFile28.getAbsolutePath() + "\n" + resumeFile29.getAbsolutePath() + "\n" + resumeFile30.getAbsolutePath() + "\n" + resumeFile31.getAbsolutePath() + "\n" + resumeFile32.getAbsolutePath() + "\n" + resumeFile33.getAbsolutePath() + "\n" + resumeFile34.getAbsolutePath() + "\n" + resumeFile35.getAbsolutePath() + "\n" + resumeFile36.getAbsolutePath() + "\n" + resumeFile37.getAbsolutePath() + "\n" + resumeFile38.getAbsolutePath() + "\n" + resumeFile39.getAbsolutePath() + "\n" + resumeFile40.getAbsolutePath() + "\n" + resumeFile41.getAbsolutePath() + "\n" + resumeFile42.getAbsolutePath() + "\n" + resumeFile43.getAbsolutePath() + "\n" + resumeFile44.getAbsolutePath() + "\n" + resumeFile45.getAbsolutePath() + "\n" + resumeFile46.getAbsolutePath() + "\n" + resumeFile47.getAbsolutePath() + "\n" + resumeFile48.getAbsolutePath() + "\n" + resumeFile49.getAbsolutePath() + "\n" + resumeFile50.getAbsolutePath());
                Thread.sleep(2000);
            } else {
                throw new Exception("Failed to find resumes' absolute path");
            }
            while (getDriver().findElements(By.xpath("//div[@class='dz-preview dz-file-preview dz-processing dz-success']")).size() != 50) {
                Thread.sleep(2000);
                if (getDriver().findElements(By.xpath("//a[text()='Cancel upload']")).size() == 0) {
                    break;
                }
            }
        } else if (arg0.equalsIgnoreCase("Cloud Icon")) {
            Actions actions = new Actions(getDriver());
            actions.moveToElement(getDriver().findElement(By.id("asc-add-file-mini-div")));

            URL resumeUrl = getClass().getClassLoader().getResource("resumes/Records/Profile(1).pdf");
            if (resumeUrl != null) {
                File resumeFile = new File(resumeUrl.getFile());
                getDriver().findElement(By.xpath("//input[@name='asc_resume']")).sendKeys(resumeFile.getAbsolutePath());
                Thread.sleep(2000);
            } else {
                throw new Exception("Failed to find resume's absolute path");
            }
            Thread.sleep(2000);
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
        getDriver().findElement(By.xpath("//select[contains(@name,'ascendify[client_user_partner_org]')]//option[2]")).click();
    }

    @Then("{string} message is displayed PT")
    public void messageIsDisplayed(String arg0) throws Throwable {
        if (arg0.equalsIgnoreCase("CSV processing")) {
            Thread.sleep(4000);
            getDriver().findElement(By.xpath("//li[contains(text(),'Your file has been queued for processing.  You will get an email when the process is complete.')]")).isDisplayed();
        } else if (arg0.equalsIgnoreCase("Bulk Add processing")) {
            new WebDriverWait(getDriver(), 100).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'New users are being processed.')]")));
            getDriver().findElement(By.xpath("//li[contains(text(),'New users are being processed.')]")).isDisplayed();
        } else if (arg0.equalsIgnoreCase("New manual user was added")) {
            new WebDriverWait(getDriver(), 100).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'New user was added.')]")));
            new WebDriverWait(getDriver(), 100).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='asc-candidate-expanded-name']")));
            getDriver().findElement(By.xpath("//a[@class='view-all btn btn-primary btn-block']")).click();
            try {
                new WebDriverWait(getDriver(), 100).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (getDriver().findElements(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")).size() == 0) {
                getDriver().findElement(By.xpath("//button[@id='candidate-status-filter-btn']")).click();
                getDriver().findElement(By.xpath("//input[@id='asc-all']")).click();
                getDriver().findElement(By.xpath("//div[@id='asc-show-all']")).click();
            }
            int retry = 0;
            while ((getDriver().findElements(By.xpath("//div[@class='link asc-list-name highlight'][contains(text(),'Manual " + LN + "')]")).size() == 0)) {
                Thread.sleep(1000);
                getDriver().findElement(By.xpath("//a[@class='view-all btn btn-primary btn-block']")).click();
                new WebDriverWait(getDriver(), 100).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")));
                Thread.sleep(1000);
                if (retry > 12) {
                    break;
                }
                retry++;
            }
        } else if (arg0.equalsIgnoreCase("New resume user was added")) {
            new WebDriverWait(getDriver(), 100).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'New user was added.')]")));
            new WebDriverWait(getDriver(), 100).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='asc-candidate-expanded-name']")));
            getDriver().findElement(By.xpath("//a[@class='view-all btn btn-primary btn-block']")).click();
            try {
                new WebDriverWait(getDriver(), 100).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (getDriver().findElements(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")).size() == 0) {
                getDriver().findElement(By.xpath("//button[@id='candidate-status-filter-btn']")).click();
                getDriver().findElement(By.xpath("//input[@id='asc-all']")).click();
                getDriver().findElement(By.xpath("//div[@id='asc-show-all']")).click();
            }
            int retry = 0;
            while ((getDriver().findElements(By.xpath("//div[@class='link asc-list-name highlight'][contains(text(),'Narendra Modi')]")).size() == 0)) {
                Thread.sleep(1000);
                getDriver().findElement(By.xpath("//a[@class='view-all btn btn-primary btn-block']")).click();
                new WebDriverWait(getDriver(), 100).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")));
                Thread.sleep(1000);
                if (retry > 12) {
                    break;
                }
                retry++;
            }
        }
    }

    @And("I fill in empty fields PT")
    public void iFillInEmptyFields() throws Throwable {

        Thread.sleep(2000);
        WebElement Status = getDriver().findElement(By.xpath("//select[@id='asc-client-crm-status-field']"));
        String textInsideStatus = Status.getAttribute("value");
        if (textInsideStatus.isEmpty()) {
            getDriver().findElement(By.xpath("//select[@id='asc-client-crm-status-field']")).click();
            getDriver().findElement(By.xpath("//select[@id='asc-client-crm-status-field']//option[2]")).click();
            Thread.sleep(2000);
        }

        while (getDriver().findElements(By.xpath("//div[@id='asc_group_select_chosen']//a[@class='search-choice-close']")).size() == 0) {
            getDriver().findElement(By.xpath("//div[@id='asc_group_select_chosen']")).click();
            Thread.sleep(2000);
            getDriver().findElement(By.xpath("//div[@id='asc_group_select_chosen']//input")).sendKeys("Candidate", Keys.ENTER);
            Thread.sleep(2000);
        }

        getDriver().findElement(By.xpath("//input[@id='asc-add-user-tag-input']")).sendKeys("Hire");
        getDriver().findElement(By.xpath("//button[@id='asc-asd-user-tag-btn']")).click();
        Thread.sleep(2000);

        WebElement Source = getDriver().findElement(By.xpath("//select[@id='asc-basic-source-field']"));
        String textInsideSource = Source.getAttribute("value");
        if (textInsideSource.isEmpty()) {
            getDriver().findElement(By.xpath("//div[@id='asc-basic-source-div']//label[contains(text(),'Source')]")).click();
            getDriver().findElement(By.xpath("//select[@id='asc-basic-source-field']")).click();
            getDriver().findElement(By.xpath("(//select[@id='asc-basic-source-field']//option[2])[1]")).click();
        }
        WebElement Recruit = getDriver().findElement(By.xpath("//select[@id='asc-basic-recruiter-field']"));
        String textInsideRecruit = Recruit.getAttribute("value");
        if (textInsideRecruit.isEmpty()) {
            getDriver().findElement(By.xpath("//select[@id='asc-basic-recruiter-field']")).click();
            getDriver().findElement(By.xpath("//select[@id='asc-basic-recruiter-field']//option[2]")).click();
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
            getDriver().findElement(By.xpath("//select[contains(@name,'ascendify[client_user_partner_org]')]//option[2]")).click();
            Thread.sleep(2000);
        }
    }

    @And("I click on the right arrow of a candidate PT")
    public void iClickOnTheRightArrowOfACandidate() {
        getDriver().findElement(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")).click();
    }

    int opps;

    @And("I consider for new opportunity PT")
    public void iConsiderForNewOpportunity() throws Throwable {
        Thread.sleep(6000);
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='right-system-panel']")));
        Thread.sleep(5000);
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='asc-show-next-opportunity-btn']")));
        getDriver().findElement(By.xpath("//span[@id='asc-show-next-opportunity-btn']")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='asc-next-opp-select']")));
        getDriver().findElement(By.xpath("//select[@id='asc-next-opp-select']")).click();
        opps = getDriver().findElements(By.xpath("//select[@id='asc-next-opp-select']//option")).size();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='asc-next-opp-select']//option[2]")));
        getDriver().findElement(By.xpath("//select[@id='asc-next-opp-select']//option[2]")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='asc-next-opp-btn']")));
        getDriver().findElement(By.xpath("//a[@id='asc-next-opp-btn']")).click();
    }

    @Then("candidate has been {string} PT")
    public void candidateHasBeen(String arg0) throws Throwable {
        Thread.sleep(4000);
        new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Move Forward')]")));
        getDriver().findElement(By.xpath("//span[contains(text(),'Move Forward')]")).isDisplayed();
    }

    @And("I move the candidate through different hiring status to Onsite Interview PT")
    public void iMoveTheCandidateThroughDifferentHiringStatus() throws Throwable {
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//span[contains(text(),'Move Forward')]")).click();
        Thread.sleep(2000);

        int retry = 0;
        while (getDriver().findElements(By.xpath("//a[@class='asc-move-forward-status']/../..//li[1]")).size() == 0) {
            System.out.println("No Workflow present for this opportunity");
            for (int i = 3; i <= opps; i++) {
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='right-system-panel']")));
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='asc-show-next-opportunity-btn']")));
                getDriver().findElement(By.xpath("//span[@id='asc-show-next-opportunity-btn']")).click();
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='asc-next-opp-select']")));
                getDriver().findElement(By.xpath("//select[@id='asc-next-opp-select']")).click();
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='asc-next-opp-select']//option[" + i + "]")));
                getDriver().findElement(By.xpath("//select[@id='asc-next-opp-select']//option[" + i + "]")).click();
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='asc-next-opp-btn']")));
                getDriver().findElement(By.xpath("//a[@id='asc-next-opp-btn']")).click();
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Move Forward')]")));
                getDriver().findElement(By.xpath("//span[contains(text(),'Move Forward')]")).click();
                Thread.sleep(2000);
            }
            if (retry > 5) {
                break;
            }
            retry++;
        }

        int size = getDriver().findElements(By.xpath("//a[@class='asc-move-forward-status']/../..//li")).size();
        getDriver().findElement(By.xpath("//span[contains(text(),'Move Forward')]")).click();
        for (int i = 1; i <= size; i++) {
            getDriver().findElement(By.xpath("//span[contains(text(),'Move Forward')]")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='asc-move-forward-status']/../..//li[" + i + "]")));
            String text = getDriver().findElement(By.xpath("//a[@class='asc-move-forward-status']/../..//li[" + i + "]")).getText();
            getDriver().findElement(By.xpath("//a[@class='asc-move-forward-status']/../..//li[" + i + "]")).click();
            Thread.sleep(1000);
            try {
                WebElement cancel = getDriver().findElement(By.xpath("//button[@id='asc-cancel-msg-btn']"));
                JavascriptExecutor jse = (JavascriptExecutor) getDriver();
                jse.executeScript("arguments[0].click()", cancel);
                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", cancel);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (getDriver().findElements(By.xpath("//button[@id='asc-cancel-msg-btn']")).size() != 0) {
                getDriver().findElement(By.xpath("//button[@id='asc-cancel-msg-btn']")).click();
            }
            Thread.sleep(500);
            new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),\"Current step: " + text + "\")]")));
            try {
                if (getDriver().findElement(By.xpath("//li[@id='tab-interview']")).isDisplayed()) {
                    i = size + 1;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Total number of workflow statuses = " + size);
            System.out.println("I am on Workflow status no. " + i);
        }
    }

    @And("I drag and drop candidates to folder PT")
    public void iDragAndDropCandidatesToFolder() throws Throwable {
        String BefCount = getDriver().findElement(By.xpath("(//a[@class='link clearfix  ui-droppable'])[1]/..//span[@class='link-count']")).getText();
        int InitialCount = Integer.parseInt(BefCount);

        String FirstCount = getDriver().findElement(By.xpath("(//a[@class='link clearfix  ui-droppable'])[1]/..//span[@class='link-count']")).getText();
        System.out.println("Initial Count = " + FirstCount);

        getDriver().findElement(By.xpath("//button[@id='candidate-status-filter-btn']")).click();
        getDriver().findElement(By.xpath("//input[@id='asc-all']")).click();
        getDriver().findElement(By.xpath("//div[@id='asc-show-all']")).click();
        new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")));

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
            Thread.sleep(2000);
            Alert alert = getDriver().switchTo().alert();
            alert.accept();
            new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Your records are being removed and your changes will be reflected soon')]")));
        } else {
            System.out.println("Those candidates are already present in this folder");
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

            while (getDriver().findElements(By.xpath("//body/div[@id='wrap']/div[@id='container']/div[@id='right-system-panel']/div[@id='inner-right-system-panel']/div[@id='asc-app-record-profile-view']/div[@id='asc-job-maindata']/div[@id='asc-extended-tabs-output-holder']/div[@id='asc-staff-aboutme-one']/div[@id='personal-sub-tab']/div[@id='asc-user-custom-data']/div[@class='asc-edit-block-inner']/div[@class='asc-edit-div']/div[@class='asc-edit-readonly']/div[1]")).size() == 0) {
                a = a + 2;
                if (a <= sections) {
                    new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[@id='asc-responses-expanded-tabs-sub']//li)[" + a + "]")));
                    getDriver().findElement(By.xpath("(//ul[@id='asc-responses-expanded-tabs-sub']//li)[" + a + "]")).click();
                    try {
                        getDriver().findElement(By.xpath("//body/div[@id='wrap']/div[@id='container']/div[@id='right-system-panel']/div[@id='inner-right-system-panel']/div[@id='asc-app-record-profile-view']/div[@id='asc-job-maindata']/div[@id='asc-extended-tabs-output-holder']/div[@id='asc-staff-aboutme-one']/div[@id='personal-sub-tab']/div[@id='asc-user-custom-data']/div[@class='asc-edit-block-inner']/div[@class='asc-edit-div']/div[@class='asc-edit-readonly']/div[1]")).click();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (getDriver().findElements(By.xpath("//div[@class='screening-msg-link no-question-message']")).size() != 0) {
                    break;
                }
            }

            if (getDriver().findElements(By.xpath("//div[@id='asc-staff-aboutme-one']")).size() != 0) {
                int x = getDriver().findElements(By.xpath("//div[@id='asc-staff-aboutme-one']")).size();
                for (int y = 1; y <= x; y++) {
                    try {
                        getDriver().findElement(By.xpath("//div[@id='asc-staff-aboutme-one']//li[" + y + "]//a[1]")).click();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
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

            if (getDriver().findElements(By.xpath("//a[@class='search-choice-close']")).size() != 0) {
                int i = getDriver().findElements(By.xpath("//a[@class='search-choice-close']")).size();
                for (int j = 1; j <= i; j++) {
                    try {
                        getDriver().findElement(By.xpath("(//a[@class='search-choice-close'])[" + j + "]")).click();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
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

            if (getDriver().findElements(By.xpath("//a[contains(@class,'chosen-single chosen-default')]")).size() != 0) {
                int j = getDriver().findElements(By.xpath("//a[contains(@class,'chosen-single chosen-default')]")).size();
                for (int i = 1; i <= j; i++) {
                    try {
                        getDriver().findElement(By.xpath("(//a[contains(@class,'chosen-single chosen-default')])[" + i + "]")).click();
                        getDriver().findElement(By.xpath("(//a[contains(@class,'chosen-single chosen-default')])[" + i + "]/..//li[2]")).click();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            if (getDriver().findElements(By.xpath("//div[contains(@id,'asc_question_csvq_')]")).size() != 0) {
                int l = 0;
                l = getDriver().findElements(By.xpath("//div[contains(@id,'asc_question_csvq_')]")).size();
                for (int k = 1; k <= l; k++) {
                    try {
                        getDriver().findElement(By.xpath("(//div[contains(@id,'asc_question_csvq_')])[" + k + "]")).click();
                        while (getDriver().findElement(By.xpath("(//div[contains(@id,'asc_question_csvq')]//div[@class='chosen-drop'])[" + k + "]")).isDisplayed() == false) {
                            getDriver().findElement(By.xpath("(//div[contains(@id,'asc_question_csvq_')])[" + k + "]")).click();
                            Thread.sleep(2000);
                        }
                        getDriver().findElement(By.xpath("(//div[contains(@id,'asc_question_csvq')]//div[@class='chosen-drop'])[" + k + "]//li[2]")).click();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
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
                    getDriver().findElement(By.xpath("//input[@class='asc-survey-question-answer asc-survey-question-answer-date  hasDatepicker']")).sendKeys(Keys.ENTER);
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
                    getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
                    Thread.sleep(1000);
                    getDriver().findElement(By.cssSelector("body")).sendKeys(uuid);
                    Thread.sleep(1000);
                    getDriver().switchTo().defaultContent();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                getDriver().switchTo().defaultContent();
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='asc-dynamic-save-button']")));
            } catch (Exception e) {
                e.printStackTrace();
            }
            Thread.sleep(4000);
            if (getDriver().findElements(By.xpath("//button[@id='asc-dynamic-save-button']")).size() != 0) {
                getDriver().findElement(By.xpath("//button[@id='asc-dynamic-save-button']")).click();
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='asc-user-custom-data']//button[@class='btn btn-primary asc-edit-icon btn-sm'][contains(text(),'Edit')]")));
            } else if (getDriver().findElements(By.xpath("//div[contains(@class,'no-question-message')]")).size() != 0) {
                System.out.println("No Screening questions are associated with this opportunity.");
            }
        }

    }

    @And("I clean up {string} PT")
    public void iCleanUpPT(String arg0) throws Throwable {
        getDriver().findElement(By.xpath("//div[@class='nav__user']")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//li[contains(text(),'Admin Console')]")).click();
        Thread.sleep(2000);
        try {
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='user-search']")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (getDriver().findElements(By.xpath("//input[@id='user-search']")).size() == 0) {
            getDriver().findElement(By.xpath("//div[@id='sections-toggle']")).click();
            while (getDriver().findElement(By.xpath("//div[@id='sections-dropdown']")).isDisplayed() == false) {
                getDriver().findElement(By.xpath("//div[@id='sections-toggle']")).click();
            }
            getDriver().findElement(By.xpath("//a[@href='/main_menu']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//i[contains(@class,'fa fa-caret-down')]")));
            getDriver().findElement(By.xpath("//i[contains(@class,'fa fa-caret-down')]")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(),'Admin Console')]")));
            getDriver().findElement(By.xpath("//li[contains(text(),'Admin Console')]")).click();
            try {
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='user-search']")));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (arg0.equalsIgnoreCase("Bulk")) {
            for (int i = 1; i <= 50; i++) {
                getDriver().findElement(By.xpath("//input[@id='user-search']")).sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
                getDriver().findElement(By.xpath("//input[@id='user-search']")).sendKeys("Narendra Modi", Keys.ENTER);
                Thread.sleep(4000);
                getDriver().findElement(By.xpath("//th[contains(text(),'Created Date')]")).click();
                try {
                    new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Narendra Modi')]/../..//i[@class='fa fa-chevron-down']")));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                int retry = 0;
                while (getDriver().findElements(By.xpath("//i[@class='fa fa-chevron-down']")).size() == 0) {
                    getDriver().findElement(By.xpath("//input[@id='user-search']")).sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
                    getDriver().findElement(By.xpath("//input[@id='user-search']")).sendKeys("Narendra Modi", Keys.ENTER);
                    Thread.sleep(4000);
                    if (retry > 20) {
                        System.out.println("Error: All resumes were not uploaded");
                        break;
                    }
                    retry++;
                }
                if (getDriver().findElements(By.xpath("(//a[contains(text(),'Narendra Modi')]/../..//i[@class='fa fa-chevron-down'])[1]")).size() == 0) {
                    System.out.println("Only " + (i - 1) + " out of 50 resumes were uploaded");
                }
                getDriver().findElement(By.xpath("(//a[contains(text(),'Narendra Modi')]/../..//i[@class='fa fa-chevron-down'])[1]")).click();
                int trial = 0;
                while (getDriver().findElement(By.xpath("(//a[@class='action-call-deleteUser'])[1]")).isDisplayed() == false) {
                    getDriver().findElement(By.xpath("(//a[contains(text(),'Narendra Modi')]/../..//i[@class='fa fa-chevron-down'])[1]")).click();
                    Thread.sleep(2000);
                    if (trial > 10) {
                        break;
                    }
                    trial++;
                }
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='action-call-deleteUser'])[1]")));
                getDriver().findElement(By.xpath("(//a[@class='action-call-deleteUser'])[1]")).click();
                Thread.sleep(2000);
                new WebDriverWait(getDriver(), 30).until(alertIsPresent());
                if (alertIsPresent() == null) {
                    getDriver().findElement(By.xpath("(//a[@class='action-call-deleteUser'])[1]")).click();
                }
                Alert alert = getDriver().switchTo().alert();
                alert.accept();
                Thread.sleep(2000);
                try {
                    new WebDriverWait(getDriver(), 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success']")));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (arg0.equalsIgnoreCase("Manual User")) {
            getDriver().findElement(By.xpath("//input[@id='user-search']")).sendKeys(email, Keys.ENTER);
            Thread.sleep(2000);
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Manual " + LN + "')]/../..//i[@class='fa fa-chevron-down']")));
            getDriver().findElement(By.xpath("//a[contains(text(),'Manual " + LN + "')]/../..//i[@class='fa fa-chevron-down']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='action-call-deleteUser']")));
            getDriver().findElement(By.xpath("//a[@class='action-call-deleteUser']")).click();
            Thread.sleep(500);
            Alert alert = getDriver().switchTo().alert();
            alert.accept();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success']")));

            getDriver().findElement(By.xpath("//div[@id='sections-toggle']")).click();
            while (getDriver().findElements(By.xpath("//ul[@class='header_menu__sections-menu nav navbar-nav']")).size() == 0) {
                getDriver().findElement(By.xpath("//div[@id='sections-toggle']")).click();
            }
            getDriver().findElement(By.xpath("//a[@href='/people']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")));
            if (getDriver().findElements(By.xpath("//span[contains(text(),'My List')]/..//span[contains(@class,'show-all link fa fa-ellipsis-h')]")).size() != 0) {
                getDriver().findElement(By.xpath("//span[contains(text(),'My List')]/..//span[contains(@class,'show-all link fa fa-ellipsis-h')]")).click();
            }
            getDriver().findElement(By.xpath("//div[contains(@class,'link-text')][contains(text(),'" + list + "')]")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='asc-del-folder-del']")));
            getDriver().findElement(By.xpath("//div[@id='asc-del-folder-del']")).click();
            getDriver().findElement(By.xpath("//button[@id='asc-del-collection']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")));
        } else if (arg0.equalsIgnoreCase("Cloud User")) {
            getDriver().findElement(By.xpath("//input[@id='user-search']")).sendKeys(email, Keys.ENTER);
            Thread.sleep(2000);
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Narendra Modi')]/../..//i[@class='fa fa-chevron-down']")));
            getDriver().findElement(By.xpath("//a[contains(text(),'Narendra Modi')]/../..//i[@class='fa fa-chevron-down']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='action-call-deleteUser']")));
            getDriver().findElement(By.xpath("//a[@class='action-call-deleteUser']")).click();
            Thread.sleep(500);
            Alert alert = getDriver().switchTo().alert();
            alert.accept();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success']")));

            getDriver().findElement(By.xpath("//div[@id='sections-toggle']")).click();
            while (getDriver().findElements(By.xpath("//ul[@class='header_menu__sections-menu nav navbar-nav']")).size() == 0) {
                getDriver().findElement(By.xpath("//div[@id='sections-toggle']")).click();
            }
            getDriver().findElement(By.xpath("//a[@href='/people']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")));
            if (getDriver().findElements(By.xpath("//span[contains(text(),'My List')]/..//span[contains(@class,'show-all link fa fa-ellipsis-h')]")).size() != 0) {
                getDriver().findElement(By.xpath("//span[contains(text(),'My List')]/..//span[contains(@class,'show-all link fa fa-ellipsis-h')]")).click();
            }
            getDriver().findElement(By.xpath("//div[contains(@class,'link-text')][contains(text(),'" + list + "')]")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='asc-del-folder-del']")));
            getDriver().findElement(By.xpath("//div[@id='asc-del-folder-del']")).click();
            getDriver().findElement(By.xpath("//button[@id='asc-del-collection']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")));
        }
    }

    @And("I clean up {string} as system admin PT")
    public void iCleanUpAsSystemAdminPT(String arg0) throws Throwable {
        if (arg0.equalsIgnoreCase("CSV")) {
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='hovicon btn-primary']//a[@href='/people']")));
            getDriver().findElement(By.xpath("//div[@class='hovicon btn-primary']//a[@href='/people']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='inputGlobal']")));
            if (getDriver().findElements(By.xpath("//div[@class='link asc-list-name highlight'][contains(text(),'Megan Terry')]/../../../../..//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")).size() == 0) {
                Thread.sleep(300000);
                getDriver().findElement(By.xpath("//input[@id='inputGlobal']")).sendKeys("donald@gmail.com", Keys.ENTER);
//            getDriver().findElement(By.xpath("//input[@id='inputGlobal']")).sendKeys(Keys.ENTER);
                Thread.sleep(4000);
//                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")));
                int retry = 0;
                while (getDriver().findElements(By.xpath("//div[@class='link asc-list-name highlight'][contains(text(),'Megan Terry')]/../../../../..//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")).size() == 0) {
                    getDriver().findElement(By.xpath("//input[@id='inputGlobal']")).sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
                    getDriver().findElement(By.xpath("//input[@id='inputGlobal']")).sendKeys("donald@gmail.com", Keys.ENTER);
                    Thread.sleep(4000);
                    if (retry > 10) {
                        System.out.println("Error: CSV Files are not uploaded");
                        break;
                    }
                    retry++;
                }
            }

            getDriver().findElement(By.xpath("//div[contains(text(),'Megan Terry')]/..//i[@class='fa fa-link doNotContactHide']")).click();
            getDriver().findElement(By.xpath("//div[contains(text(),'donald@gmail.com')]")).isDisplayed();
            getDriver().findElement(By.xpath("//div[contains(text(),'Megan Terry')]/../../../../..//div[@class='asc-dropdown-button']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='asc-tile-menu-item asc-list-delete-profile link']")));
            getDriver().findElement(By.xpath("//a[@class='asc-tile-menu-item asc-list-delete-profile link']")).click();
            Thread.sleep(2000);
            Alert alert = getDriver().switchTo().alert();
            alert.accept();
            new WebDriverWait(getDriver(), 30).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='link asc-list-name highlight'][contains(text(),'Megan Terry')]/../../../../..//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")));
            Thread.sleep(4000);

            getDriver().findElement(By.xpath("//input[@id='inputGlobal']")).click();
            getDriver().findElement(By.xpath("//input[@id='inputGlobal']")).sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
            getDriver().findElement(By.xpath("//input[@id='inputGlobal']")).sendKeys("trump@gmail.com", Keys.ENTER);
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='link asc-list-name highlight'][contains(text(),'Grayson Martin')]/../../../../..//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")));
            getDriver().findElement(By.xpath("//div[contains(text(),'Grayson Martin')]/..//i[@class='fa fa-link doNotContactHide']")).click();
            getDriver().findElement(By.xpath("//div[contains(text(),'trump@gmail.com')]")).isDisplayed();
            getDriver().findElement(By.xpath("//div[contains(text(),'Grayson Martin')]/../../../../..//div[@class='asc-dropdown-button']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='asc-tile-menu-item asc-list-delete-profile link']")));
            getDriver().findElement(By.xpath("//a[@class='asc-tile-menu-item asc-list-delete-profile link']")).click();
            Thread.sleep(2000);
            getDriver().switchTo().alert();
            alert.accept();
            new WebDriverWait(getDriver(), 30).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='link asc-list-name highlight'][contains(text(),'Grayson Martin')]/../../../../..//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")));
            Thread.sleep(4000);
        }
    }

    String org;

    @And("I go to my profile to find my organization PT")
    public void iGoToMyProfileToFindMyOrganization() throws Throwable {
        new WebDriverWait(getDriver(), 60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='nav__user']")));
        getDriver().findElement(By.xpath("//div[@class='nav__user']")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//a[contains(text(),'View Profile')]")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='tab-personal']")));
        getDriver().findElement(By.xpath("//li[@id='tab-profile']")).click();
        getDriver().findElement(By.xpath("//li[@id='tab-personal']")).click();
        String organization = getDriver().findElement(By.xpath("(//div[@class='asc-read-org'])[1]")).getText();
        org = organization.replace(" *", "");
        System.out.println("Organization is " + org);
    }

    String req;
    int j;

    @And("I find an opportunity associated with my organization PT")
    public void iFindAnOpportunityAssociatedWithMyOrganization() throws Throwable {
        getDriver().findElement(By.xpath("//div[@class='section-tab']")).click();
        new WebDriverWait(getDriver(), 50).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/requisitions']")));
        getDriver().findElement(By.xpath("//a[@href='/requisitions']")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")));
        getDriver().findElement(By.xpath("//div[@id='asc-show-all']")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")));
        int i = getDriver().findElements(By.xpath("//div[contains(text(),'" + org + "')]/..//div[@class='asc-job-status']/../../../..//i[contains(@class,'fa fa-chevron-circle-right asc-list-more-information-arrow')]")).size();
        for (j = 1; j <= i; j++) {
            getDriver().findElement(By.xpath("(//div[contains(text(),'" + org + "')]/..//div[@class='asc-job-status']/../../../..//i[contains(@class,'fa fa-chevron-circle-right asc-list-more-information-arrow')])[" + j + "]")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='asc-candidate-expanded-header-outer-info']")));

            getDriver().findElement(By.xpath("//li[@id='tab-workflows']")).click();
            try {
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='asc-workflow-container']//div[@class='folder__title']")));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (getDriver().findElements(By.xpath("//div[@id='asc-workflow-container']//div[@class='folder__title']")).size() == 0) {
                getDriver().findElement(By.xpath("//li[@id='tab-info']")).click();
                Thread.sleep(2000);
                getDriver().findElement(By.xpath("//li[@id='tab-workflows']")).click();
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='asc-workflow-container']//div[@class='folder__title']")));
            }
            if ((getDriver().findElements(By.xpath("//div[@id='asc-workflow-container']//div[@class='folder__title']")).size() == 2) || (getDriver().findElements(By.xpath("//i[@class='fa fa-times icon']")).size() != 0)) {
                break;
            }
        }

        String status = getDriver().findElement(By.xpath("//span[@id='status-name']")).getText();
        if (status != "Open") {
            getDriver().findElement(By.xpath("//button[@id='asc-status-btn']")).click();
            getDriver().findElement(By.xpath("//li//a[text()='Open']")).click();
        }
    }

    @And("I make sure workflow status is selected for this opportunity PT")
    public void iMakeSureWorkflowStatusIsSelectedForThisOpportunityPT() throws Throwable {

        if (getDriver().findElements(By.xpath("//div[@id='asc-workflow-container']//div[@class='folder__title']")).size() == 2) {
            System.out.println("Workflow status is selected for this opportunity");
            req = getDriver().findElement(By.xpath("//div[@id='asc-job-name']")).getText();
            System.out.println("Requisition is " + req);
        } else if (getDriver().findElements(By.xpath("//i[@class='fa fa-times icon']")).size() != 0) {
            getDriver().findElement(By.xpath("//i[contains(@class,'fa fa-times icon')]")).click();
            Thread.sleep(4000);
            WebElement select = getDriver().findElement(By.xpath("//*[contains(text(),'Select a Workflow')]"));
            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
            jse.executeScript("arguments[0].click()", select);
            int option = getDriver().findElements(By.xpath("//div[@id='modal-dialog-replace-workflow']//select//option")).size();
            getDriver().findElement(By.xpath("//select[@class='chosen required']//option[2]")).click();
            Thread.sleep(2000);
            while (getDriver().findElement(By.xpath("//button[contains(@class,'modal__button modal__button--submit btn btn-primary')]")).isDisplayed()) {
                getDriver().findElement(By.xpath("//button[contains(@class,'modal__button modal__button--submit btn btn-primary')]")).click();
                Thread.sleep(2000);
            }
            for (int i = 3; i <= option; i++) {
                while (getDriver().findElements(By.xpath("//div[@id='asc-workflow-container']//div[@class='folder__title']")).size() != 2) {
                    if (getDriver().findElements(By.xpath("//i[@class='fa fa-times icon']")).size() != 0) {
                        getDriver().findElement(By.xpath("//i[contains(@class,'fa fa-times icon')]")).click();
                        Thread.sleep(4000);
                        getDriver().findElement(By.xpath("//div[@id='modal-dialog-replace-workflow']//select")).click();
                        getDriver().findElement(By.xpath("//select[@class='chosen required']//option[" + i + "]")).click();
                        Thread.sleep(2000);
                        while (getDriver().findElement(By.xpath("//button[contains(@class,'modal__button modal__button--submit btn btn-primary')]")).isDisplayed()) {
                            getDriver().findElement(By.xpath("//button[contains(@class,'modal__button modal__button--submit btn btn-primary')]")).click();
                            Thread.sleep(2000);
                        }
                    }
                }
            }
            req = getDriver().findElement(By.xpath("//div[@id='asc-job-name']")).getText();
            System.out.println("Requisition is " + req);
        }
    }

    @And("I make sure skills are assigned to this opportunity PT")
    public void iMakeSureSkillsAreAssignedToThisOpportunityPT() throws Throwable {
        getDriver().findElement(By.xpath("//li[@id='tab-capabilities']")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'btn-primary')]")));
        while (getDriver().findElements(By.xpath("//div[@class='btn-copy-capabilities-from-job-role btn-primary']")).size() != 0) {
            getDriver().findElement(By.xpath("//div[@class='btn-copy-capabilities-from-job-role btn-primary']")).click();
            try {
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='btn-detele-all-capabilities btn-primary']")));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (getDriver().findElements(By.xpath("//div[contains(text(),'No skills have been assigned to the job role.')]")).size() != 0) {
                System.out.println("No skills have been assigned to the job role.");
                break;
            }
        }

        while (getDriver().findElements(By.xpath("//div[contains(text(),'No skills have been assigned to the job role.')]")).size() != 0) {
            int i = getDriver().findElements(By.xpath("//div[contains(text(),'" + org + "')]/..//div[@class='asc-job-status']/../../../..//i[contains(@class,'fa fa-chevron-circle-right asc-list-more-information-arrow')]")).size();
            for (j = (j + 1); j <= i; j++) {
                getDriver().findElement(By.xpath("(//div[contains(text(),'" + org + "')]/..//div[@class='asc-job-status']/../../../..//i[contains(@class,'fa fa-chevron-circle-right asc-list-more-information-arrow')])[" + j + "]")).click();
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='asc-candidate-expanded-header-outer-info']")));

                getDriver().findElement(By.xpath("//li[@id='tab-workflows']")).click();
                try {
                    new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='asc-workflow-container']//div[@class='folder__title']")));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (getDriver().findElements(By.xpath("//div[@id='asc-workflow-container']//div[@class='folder__title']")).size() == 0) {
                    getDriver().findElement(By.xpath("//li[@id='tab-info']")).click();
                    Thread.sleep(2000);
                    getDriver().findElement(By.xpath("//li[@id='tab-workflows']")).click();
                    new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='asc-workflow-container']//div[@class='folder__title']")));
                }
                if ((getDriver().findElements(By.xpath("//div[@id='asc-workflow-container']//div[@class='folder__title']")).size() == 2) || (getDriver().findElements(By.xpath("//i[@class='fa fa-times icon']")).size() != 0)) {
                    break;
                }
            }

            String status = getDriver().findElement(By.xpath("//span[@id='status-name']")).getText();
            if (status.equals("Open") == false) {
                getDriver().findElement(By.xpath("//button[@id='asc-status-btn']")).click();
                getDriver().findElement(By.xpath("//li//a[text()='Open']")).click();
            }

            if (getDriver().findElements(By.xpath("//div[@id='asc-workflow-container']//div[@class='folder__title']")).size() == 2) {
                System.out.println("Workflow status is selected for this opportunity");
                req = getDriver().findElement(By.xpath("//div[@id='asc-job-name']")).getText();
                System.out.println("Requisition is " + req);
            } else if (getDriver().findElements(By.xpath("//i[@class='fa fa-times icon']")).size() != 0) {
                getDriver().findElement(By.xpath("//i[contains(@class,'fa fa-times icon')]")).click();
                Thread.sleep(4000);
                WebElement select = getDriver().findElement(By.xpath("//*[contains(text(),'Select a Workflow')]"));
                JavascriptExecutor jse = (JavascriptExecutor) getDriver();
                jse.executeScript("arguments[0].click()", select);
                int option = getDriver().findElements(By.xpath("//div[@id='modal-dialog-replace-workflow']//select//option")).size();
                getDriver().findElement(By.xpath("//select[@class='chosen required']//option[2]")).click();
                Thread.sleep(2000);
                while (getDriver().findElement(By.xpath("//button[contains(@class,'modal__button modal__button--submit btn btn-primary')]")).isDisplayed()) {
                    getDriver().findElement(By.xpath("//button[contains(@class,'modal__button modal__button--submit btn btn-primary')]")).click();
                    Thread.sleep(2000);
                }
                for (int k = 3; k <= option; k++) {
                    while (getDriver().findElements(By.xpath("//div[@id='asc-workflow-container']//div[@class='folder__title']")).size() != 2) {
                        if (getDriver().findElements(By.xpath("//i[@class='fa fa-times icon']")).size() != 0) {
                            getDriver().findElement(By.xpath("//i[contains(@class,'fa fa-times icon')]")).click();
                            Thread.sleep(4000);
                            getDriver().findElement(By.xpath("//div[@id='modal-dialog-replace-workflow']//select")).click();
                            getDriver().findElement(By.xpath("//select[@class='chosen required']//option[" + i + "]")).click();
                            Thread.sleep(2000);
                            while (getDriver().findElement(By.xpath("//button[contains(@class,'modal__button modal__button--submit btn btn-primary')]")).isDisplayed()) {
                                getDriver().findElement(By.xpath("//button[contains(@class,'modal__button modal__button--submit btn btn-primary')]")).click();
                                Thread.sleep(2000);
                            }
                        }
                    }
                }
                req = getDriver().findElement(By.xpath("//div[@id='asc-job-name']")).getText();
                System.out.println("Requisition is " + req);
            }
            getDriver().findElement(By.xpath("//li[@id='tab-capabilities']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'btn-primary')]")));
            if (getDriver().findElements(By.xpath("//div[@class='btn-copy-capabilities-from-job-role btn-primary']")).size() != 0) {
                getDriver().findElement(By.xpath("//div[@class='btn-copy-capabilities-from-job-role btn-primary']")).click();
                try {
                    new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='btn-detele-all-capabilities btn-primary']")));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @And("I make sure interview is setup for this opportunity PT")
    public void iMakeSureInterviewIsSetupForThisOpportunityPT() throws Throwable {
        getDriver().findElement(By.xpath("//li[@id='tab-team']")).click();
        getDriver().findElement(By.xpath("//li[@id='tab-team']")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[@class='jrt-interview-tab--title']")));
        String handle = getDriver().getWindowHandle();
        System.out.println(handle);

        Thread.sleep(3000);
        WebElement title = getDriver().findElement(By.xpath("//strong[@class='jrt-interview-tab--title']"));
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].click()", title);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", title);
        getDriver().findElement(By.xpath("//strong[@class='jrt-interview-tab--title']")).isDisplayed();
        try {
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='interview-team team-list asc-list-tile scheduling']")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        getDriver().findElement(By.xpath("//div[contains(text(),'" + org + "')]/..//div[@class='asc-job-status'][contains(text(),'Open')]/../../../..//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow highlight']")).click();
        new WebDriverWait(getDriver(), 100).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='asc-candidate-expanded-header-outer-info']")));
        getDriver().findElement(By.xpath("//li[@id='tab-team']")).click();
        try {
            new WebDriverWait(getDriver(), 50).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='interview-team team-list asc-list-tile scheduling']")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (getDriver().findElements(By.xpath("//ul[@class='interview-team team-list asc-list-tile scheduling']")).size() != 0) {
            System.out.println("Interview Team is already setup for this opportunity");
        } else {
            getDriver().findElement(By.xpath("//div[contains(text(),'" + org + "')]/..//div[@class='asc-job-status']/../../../..//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow highlight']")).click();
            new WebDriverWait(getDriver(), 50).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='tab-team']")));
            getDriver().findElement(By.xpath("//li[@id='tab-team']")).click();
            try {
                new WebDriverWait(getDriver(), 100).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='interview-team team-list asc-list-tile scheduling']")));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        if (getDriver().findElements(By.xpath("//ul[@class='interview-team team-list asc-list-tile scheduling']")).size() != 0) {
            System.out.println("Interview Team is already setup for this opportunity");
        }

        if (getDriver().findElements(By.xpath("//ul[@class='interview-team team-list asc-list-tile scheduling']")).size() == 0) {
            getDriver().findElement(By.xpath("//button[@id='asc-interview-setup-btn']")).click();

            Set handles = getDriver().getWindowHandles();
            System.out.println(handles);

            for (String handle1 : getDriver().getWindowHandles()) {
                System.out.println(handle1);
                getDriver().switchTo().window(handle1);
            }

            new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='title']")));
            Thread.sleep(5000);
            if (getDriver().findElements(By.xpath("//div[@id='mui-component-select-Interview Location']")).size() != 0) {
                getDriver().findElement(By.xpath("//div[@id='mui-component-select-Interview Location']")).click();
                if (getDriver().findElements(By.xpath("//div[contains(@class,'Component-menuDropdown')]//li[1]")).size() != 0) {
                    getDriver().findElement(By.xpath("//div[contains(@class,'Component-menuDropdown')]//li[1]")).click();
                }
                if (getDriver().findElements(By.xpath("//div[contains(@class,'MuiPaper-root MuiMenu-paper asc-prod')]//li[1]")).size() != 0) {
                    getDriver().findElement(By.xpath("//div[contains(@class,'MuiPaper-root MuiMenu-paper asc-prod')]//li[1]")).click();
                }
                if (getDriver().findElements(By.xpath("//textarea[@id='webLocation-']")).size() != 0) {
                    getDriver().findElement(By.xpath("//textarea[@id='webLocation-']")).sendKeys("Text Area");
                }
                if (getDriver().findElements(By.xpath("//input[@id='phoneLocation']")).size() != 0) {
                    getDriver().findElement(By.xpath("//input[@id='phoneLocation']")).sendKeys("202-555-0153");
                }
                if (getDriver().findElements(By.xpath("//input[@id='otherLocation-']")).size() != 0) {
                    getDriver().findElement(By.xpath("//input[@id='otherLocation-']")).sendKeys("Office");
                }
                if (getDriver().findElements(By.xpath("//div[@id='mui-component-select-Room']")).size() != 0) {
                    getDriver().findElement(By.xpath("//div[@id='mui-component-select-Room']")).click();
                    getDriver().findElement(By.xpath("//ul[@class='MuiList-root MuiMenu-list MuiList-padding']//li[1]")).click();
                }
                WebElement interview = getDriver().findElement(By.xpath("//div[contains(text(),'No Interview Type Selected')]"));
                jse.executeScript("arguments[0].click()", interview);
                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", interview);
                getDriver().findElement(By.xpath("//div[contains(text(),'No Interview Type Selected')]")).click();
                if (getDriver().findElements(By.xpath("//div[contains(@class,'Component-menuDropdown')]//li[1]")).size() != 0) {
                    getDriver().findElement(By.xpath("//div[contains(@class,'Component-menuDropdown')]//li[1]")).click();
                }
                if (getDriver().findElements(By.xpath("//div[contains(@class,'MuiPaper-root MuiMenu-paper asc-prod')]//li[1]")).size() != 0) {
                    getDriver().findElement(By.xpath("//div[contains(@class,'MuiPaper-root MuiMenu-paper asc-prod')]//li[1]")).click();
                }
                Thread.sleep(2000);
                getDriver().findElement(By.xpath("//input[contains(@id,'autocomplete-input')]")).sendKeys("Bahu Bali");
                new WebDriverWait(getDriver(), 100).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id,'autocomplete-input')]/../../../../..//div[contains(text(),'Bahu Bali')]")));
                getDriver().findElement(By.xpath("//input[contains(@id,'autocomplete-input')]/../../../../..//div[contains(text(),'Bahu Bali')]")).click();
                Thread.sleep(4000);
                getDriver().findElement(By.xpath("//p[contains(text(),'Save')]")).click();
                new WebDriverWait(getDriver(), 100).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Data has been saved')]")));
            }
            new WebDriverWait(getDriver(), 100).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Close')]")));
            getDriver().findElement(By.xpath("//p[contains(text(),'Close')]")).click();
            getDriver().switchTo().window(handle);
        }
    }

    @And("I make sure I haven't applied to that opportunity PT")
    public void iMakeSureIHavenTAppliedToThatOpportunityPT() throws Throwable {
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")));
        if (getDriver().findElements(By.xpath("//div[@class='jobs']//span[@class='show-all link fa fa-ellipsis-h']")).size() != 0) {
            getDriver().findElement(By.xpath("//div[@class='jobs']//span[@class='show-all link fa fa-ellipsis-h']")).click();
        }
        getDriver().findElement(By.xpath("//div[@class='jobs']//div[@class='link-text'][contains(text(),'" + req + "')]")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")));
        if (getDriver().findElements(By.xpath("//div[@class='link asc-list-name highlight'][contains(text(),'" + name + "')]")).size() != 0) {
            int x = getDriver().findElements(By.xpath("//div[@class='link asc-list-name highlight'][contains(text(),'" + name + "')]")).size();
            for (int y = 1; y <= x; y++) {
                getDriver().findElement(By.xpath("(//div[@class='link asc-list-name highlight'][contains(text(),'" + name + "')]/..//i[@class='fa fa-link doNotContactHide'])[" + y + "]")).click();
                String loginemail = getConfig().get("superAdminUsername").toString();
                if (getDriver().findElements(By.xpath("//div[contains(text(),'" + loginemail + "')]")).size() != 0) {
                    getDriver().findElement(By.xpath("(//div[@class='link asc-list-name highlight'][contains(text(),'" + name + "')]/..//i[@class='fa fa-link doNotContactHide'])[" + y + "]")).click();
                    getDriver().findElement(By.xpath("(//div[@class='link asc-list-name highlight'][contains(text(),'" + name + "')])[" + y + "]/../../../../..//div[@class='asc-dropdown-button']")).click();
                    getDriver().findElement(By.xpath("(//div[@class='link asc-list-name highlight'][contains(text(),'" + name + "')])[" + y + "]/../../../../..//a[@class='asc-list-remove-fav link']")).click();
                    Thread.sleep(2000);
                    Alert alert = getDriver().switchTo().alert();
                    alert.accept();
                    break;
                }
                getDriver().findElement(By.xpath("(//div[@class='link asc-list-name highlight'][contains(text(),'" + name + "')]/..//i[@class='fa fa-link doNotContactHide'])[" + y + "]")).click();
            }
        }
        getDriver().findElement(By.xpath("//a[@class='view-all btn btn-primary btn-block']")).click();
    }

    String candidate;

    @And("I choose a person who is associated with the same organization as mine PT")
    public void iChooseAPersonWhoIsAssociatedWithTheSameOrganizationAsMine() throws Throwable {
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")));

        int x = getDriver().findElements(By.xpath("//div[contains(text(),'" + org + "')]/../../../..//i[contains(@class,'fa fa-chevron-circle-right asc-list-more-information-arrow')]")).size();
        for (int y = 1; y <= x; y++) {
            getDriver().findElement(By.xpath("(//div[contains(text(),'" + org + "')]/../../../..//i[contains(@class,'fa fa-chevron-circle-right asc-list-more-information-arrow')])[" + y + "]")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='right-system-panel']")));
            try {
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='asc-show-next-opportunity-btn']")));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (getDriver().findElements(By.xpath("//span[@id='asc-show-next-opportunity-btn']")).size() != 0) {
                y = x;
                break;
            }
        }
        candidate = getDriver().findElement(By.xpath("//div[@id='asc-candidate-expanded-name']")).getText();
        System.out.println("Candidate is " + candidate);
    }

    @And("I consider for same opportunity PT")
    public void iConsiderForSameOpportunityPT() throws Throwable {
        getDriver().findElement(By.xpath("//span[@id='asc-show-next-opportunity-btn']")).click();
        Thread.sleep(2000);
        int trial = 0;
        if (getDriver().findElements(By.xpath("//*[@id='asc_next_opp_select_chosen']")).size() != 0) {
            while ((getDriver().findElement(By.xpath("//*[@id='asc_next_opp_select_chosen']")).isDisplayed() == false)) {
                getDriver().findElement(By.xpath("//div[contains(text(),'" + org + "')]/../../../..//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow highlight']")).click();
                Thread.sleep(2000);
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='right-system-panel']")));
                Thread.sleep(2000);
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='asc-show-next-opportunity-btn']")));
                getDriver().findElement(By.xpath("//span[@id='asc-show-next-opportunity-btn']")).click();
                Thread.sleep(2000);
                if (trial > 2) {
                    break;
                }
                trial++;
            }
        }
        int retry = 0;
        if (getDriver().findElements(By.xpath("//select[@id='asc-next-opp-select']")).size() != 0) {
            while (getDriver().findElement(By.xpath("//select[@id='asc-next-opp-select']")).isDisplayed() == false) {
                getDriver().findElement(By.xpath("//div[contains(text(),'" + org + "')]/../../../..//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow highlight']")).click();
                Thread.sleep(2000);
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='right-system-panel']")));
                Thread.sleep(2000);
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='asc-show-next-opportunity-btn']")));
                getDriver().findElement(By.xpath("//span[@id='asc-show-next-opportunity-btn']")).click();
                Thread.sleep(2000);
                if (retry > 2) {
                    break;
                }
                retry++;
            }
        }
        if (getDriver().findElement(By.xpath("//select[@id='asc-next-opp-select']")).isDisplayed() == true) {
            getDriver().findElement(By.xpath("//select[@id='asc-next-opp-select']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='asc-next-opp-select']//option[contains(text(),'" + req + "')]")));
            try {
                getDriver().findElement(By.xpath("//select[@id='asc-next-opp-select']//option[text()='" + req + "']")).click();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (getDriver().findElements(By.xpath("//select[@id='asc-next-opp-select']//option[text()='" + req + "']")).size() == 0) {
                getDriver().findElement(By.xpath("//select[@id='asc-next-opp-select']//option[contains(text(),'" + req + "')]")).click();
            }
        } else if (getDriver().findElement(By.xpath("//*[@id='asc_next_opp_select_chosen']")).isDisplayed() == true) {
            getDriver().findElement(By.xpath("//*[@id='asc_next_opp_select_chosen']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='asc_next_opp_select_chosen']/div/ul/li[contains(text(),'" + req + "')]")));
            getDriver().findElement(By.xpath("//*[@id='asc_next_opp_select_chosen']/div/ul/li[contains(text(),'" + req + "')]")).click();
        }
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='asc-next-opp-btn']")));
        getDriver().findElement(By.xpath("//a[@id='asc-next-opp-btn']")).click();
    }

    @Then("candidate of same org has been {string} PT")
    public void candidateOfSameOrgHasBeenPT(String arg0) throws Throwable {
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Move Forward')]")));
        getDriver().findElement(By.xpath("//span[contains(text(),'Move Forward')]")).isDisplayed();
    }

    @And("I go to Interview tab to set up Interview kit PT")
    public void iGoToInterviewTabToSetUpInterviewKit() throws Throwable {
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='tab-interview']")));
        getDriver().findElement(By.xpath("//li[@id='tab-interview']")).click();
        Thread.sleep(2000);
        try {
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='asc-interview-subtab-team']")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String handle = getDriver().getWindowHandle();
        System.out.println(handle);
        if (getDriver().findElements(By.xpath("//a[contains(text(),'opportunity.')]")).size() != 0) {
            getDriver().findElement(By.xpath("//a[contains(text(),'opportunity.')]")).click();
            new WebDriverWait(getDriver(), 100).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")));
            getDriver().findElement(By.xpath("//div[contains(text(),'" + org + "')]/../../../..//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")).click();
            new WebDriverWait(getDriver(), 100).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='tab-team']")));
            getDriver().findElement(By.xpath("//li[@id='tab-team']")).click();
            try {
                new WebDriverWait(getDriver(), 100).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[@class='jrt-interview-tab--title']")));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (getDriver().findElements(By.xpath("//strong[@class='jrt-interview-tab--title']")).size() == 0) {
                getDriver().findElement(By.xpath("//li[@id='tab-team']")).click();
            }
            new WebDriverWait(getDriver(), 100).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='asc-interview-setup-btn']")));
            if (getDriver().findElements(By.xpath("//button[@id='archive-interview-btn']")).size() != 0) {
                getDriver().findElement(By.xpath("//button[@id='archive-interview-btn']")).click();
                Thread.sleep(2000);
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='schedule-interview-btn']")));
            }
            getDriver().findElement(By.xpath("//button[@id='asc-interview-setup-btn']")).click();

            Set handles = getDriver().getWindowHandles();
            System.out.println(handles);

            for (String handle1 : getDriver().getWindowHandles()) {
                System.out.println(handle1);
                getDriver().switchTo().window(handle1);
            }

            new WebDriverWait(getDriver(), 100).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='title']")));
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
            getDriver().findElement(By.xpath("//div[@id='menu-Interview Type']//ul//li[2]")).click();
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
    }

    @And("I do the Interview setup PT")
    public void iDoTheInterviewSetupPT() throws Throwable {
        String handle = getDriver().getWindowHandle();
        System.out.println(handle);

        getDriver().findElement(By.xpath("//li[@id='tab-profile']")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//li[@id='tab-interview']")).click();

        WebElement button = getDriver().findElement(By.xpath("//button[@id='schedule-interview-btn']"));
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].click()", button);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", button);

        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='schedule-interview-btn']")));
        getDriver().findElement(By.xpath("//button[@id='schedule-interview-btn']")).click();
        Thread.sleep(2000);

        ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
        while (tabs.size() == 1) {
            getDriver().findElement(By.xpath("//button[@id='schedule-interview-btn']")).click();
            Thread.sleep(2000);
        }

        Set handles = getDriver().getWindowHandles();
        System.out.println(handles);

        for (String handle1 : getDriver().getWindowHandles()) {
            System.out.println(handle1);
            getDriver().switchTo().window(handle1);
        }

        new WebDriverWait(getDriver(), 100).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'MuiStepper-horizontal')]")));
        try {
            new WebDriverWait(getDriver(), 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'EDIT')]")));
            WebElement edit = getDriver().findElement(By.xpath("//p[contains(text(),'EDIT')]"));
            jse.executeScript("arguments[0].click()", edit);
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", edit);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (getDriver().findElements(By.xpath("//p[contains(text(),'Add Interview')]")).size() != 0) {
            getDriver().findElement(By.xpath("//p[contains(text(),'Add Interview')]")).click();
            new WebDriverWait(getDriver(), 100).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'No Interview Type Selected')]")));
            int type = getDriver().findElements(By.xpath("//div[contains(text(),'No Interview Type Selected')]")).size();
            getDriver().findElement(By.xpath("(//div[contains(text(),'No Interview Type Selected')])[" + type + "]")).click();
            getDriver().findElement(By.xpath("//div[@id='menu-Interview Type']//ul//li[2]")).click();
            int size = 0;
            size = getDriver().findElements(By.xpath("//input[contains(@id,'autocomplete-input')]")).size();
            Thread.sleep(2000);
            getDriver().findElement(By.xpath("(//input[contains(@id,'autocomplete-input')])[" + size + "]")).sendKeys("Chandler Bing");
            new WebDriverWait(getDriver(), 100).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[contains(@id,'autocomplete-input')])[" + size + "]/../../../../..//div[contains(text(),'Chandler Bing')]")));
            getDriver().findElement(By.xpath("(//input[contains(@id,'autocomplete-input')])[" + size + "]/../../../../..//div[contains(text(),'Chandler Bing')]")).click();
            Thread.sleep(4000);
            getDriver().findElement(By.xpath("//p[contains(text(),'NEXT')]")).click();
            new WebDriverWait(getDriver(), 100).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Data has been saved')]")));
        } else if (getDriver().findElements(By.xpath("//span[contains(text(),'Reschedule')]")).size() != 0) {
            getDriver().findElement(By.xpath("//span[contains(text(),'Reschedule')]")).click();
            getDriver().findElement(By.xpath("//p[contains(text(),'Accept')]")).click();
        }
        try {
            new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'MuiAvatar-root MuiAvatar-circle MuiAvatar-colorDefault asc-prod')]")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (getDriver().findElements(By.xpath("//div[contains(@class, 'MuiAvatar-root MuiAvatar-circle MuiAvatar-colorDefault asc-prod')]")).size() != 0) {
            getDriver().findElement(By.xpath("(//div[contains(@class, 'MuiAvatar-root MuiAvatar-circle MuiAvatar-colorDefault asc-prod')])[1]")).click();
            new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Schedule Now')]")));
            WebElement schedule = getDriver().findElement(By.xpath("//p[contains(text(),'Schedule Now')]"));
            jse.executeScript("arguments[0].click()", schedule);
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", schedule);
            getDriver().findElement(By.xpath("//p[contains(text(),'Schedule Now')]")).click();
            try {
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Send')]")));
            } catch (Exception e) {
                e.printStackTrace();
            }
            Thread.sleep(2000);
            if (getDriver().findElements(By.xpath("//p[contains(text(),'Send')]")).size() == 0) {
                getDriver().findElement(By.xpath("//p[contains(text(),'Schedule Now')]")).click();
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Send')]")));
            }
            Thread.sleep(2000);
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Send')]")));
            getDriver().findElement(By.xpath("//p[contains(text(),'Send')]")).click();
            new WebDriverWait(getDriver(), 60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Email sent to candidate')]")));
        }

        try {
            new WebDriverWait(getDriver(), 60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='MuiIconButton-label']")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (getDriver().findElements(By.xpath("//span[contains(text(),'Select All')]")).size() != 0) {
            WebElement button2 = getDriver().findElement(By.xpath("//span[contains(text(),'Select All')]"));
            jse.executeScript("arguments[0].click()", button2);
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", button2);
            getDriver().findElement(By.xpath("//span[contains(text(),'Select All')]")).click();
            getDriver().findElement(By.xpath("//p[contains(text(),'NEXT')]")).click();
            new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Data has been saved')]")));
            if (getDriver().findElements(By.xpath("//p[contains(text(),'NEXT')]")).size() != 0) {
                getDriver().findElement(By.xpath("//p[contains(text(),'NEXT')]")).click();
                new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Data has been saved')]")));
                new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Scheduled Interview')]")));
            }
            if (getDriver().findElements(By.xpath("//p[contains(text(),'Resend')]")).size() != 0) {
                WebElement resend = getDriver().findElement(By.xpath("//p[contains(text(),'Resend')]"));
                jse.executeScript("arguments[0].click()", resend);
                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", resend);
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'Resend')]")));
            }
        }

        try {
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Send')]")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (getDriver().findElements(By.xpath("//p[contains(text(),'Send')]")).size() != 0) {
            WebElement send = getDriver().findElement(By.xpath("//p[contains(text(),'Send')]"));
            jse.executeScript("arguments[0].click()", send);
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", send);
            try {
                new WebDriverWait(getDriver(), 100).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='MuiDialogActions-root MuiDialogActions-spacing']//p[contains(text(),'Send')]")));
                getDriver().findElement(By.xpath("//div[@class='MuiDialogActions-root MuiDialogActions-spacing']//p[contains(text(),'Send')]")).click();
                new WebDriverWait(getDriver(), 100).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Interview information has been sent')]")));
                if (getDriver().findElements(By.xpath("//*[contains(text(),'Interview information has been sent')]")).size() != 0) {
                    System.out.println("Interview information has been sent");
                } else {
                    System.out.println("Failed to send Interview Information");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        getDriver().findElement(By.xpath("//p[contains(text(),'CLOSE')]")).click();
        getDriver().switchTo().window(handle);
    }

    int interviewers;
    int newInterviewers;

    @Then("I make sure the new interviewers are added as Team Members PT")
    public void iMakeSureTheNewInterviewersAreAddedAsTeamMembersPT() throws Throwable {
        try {
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='interview-team team-list asc-list-tile scheduling']")));
            interviewers = getDriver().findElements(By.xpath("//ul[contains(@class,'interview-team approved-interviewers-list')]")).size();
        } catch (Exception e) {
            e.printStackTrace();
        }
        getDriver().findElement(By.xpath("//div[contains(text(),'" + candidate + "')]/../../../../..//i[contains(@class,'fa fa-chevron-circle-right asc-list-more-information-arrow')]")).click();
        new WebDriverWait(getDriver(), 200).until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='tab-interview']")));
        getDriver().findElement(By.xpath("//i[@class='fa fa-tag']")).click();
        getDriver().findElement(By.xpath("//li[@id='tab-interview']")).click();
        try {
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@class,'interview-team approved-interviewers-list')]")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (getDriver().findElements(By.xpath("//ul[contains(@class,'interview-team approved-interviewers-list')]")).size() == 0) {
            getDriver().findElement(By.xpath("//i[@class='fa fa-tag']")).click();
            getDriver().findElement(By.xpath("//li[@id='tab-interview']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@class,'interview-team approved-interviewers-list')]")));
        }
        newInterviewers = getDriver().findElements(By.xpath("//ul[contains(@class,'interview-team approved-interviewers-list')]")).size();
        System.out.println("Number of Interviewers = " + interviewers);
        System.out.println("Number of Updated Interviewers = " + newInterviewers);
        if (newInterviewers > interviewers) {
            System.out.println("New Interviewers are added to the Team Members List");
        } else {
            System.out.println("New Interviewers are NOT added to the Team Members List");
        }
        WebElement archive = getDriver().findElement(By.xpath("//button[@id='archive-interview-btn']"));
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].click()", archive);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", archive);
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='tab-interview']")));
        getDriver().findElement(By.xpath("//li[@id='tab-interview']")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='schedule-interview-btn']")));
    }

    @Then("I search for user by email in the global bar at top PT")
    public void iSearchForUserByEmailInTheGlobalBarAtTopPT() throws Throwable {
        getDriver().findElement(By.xpath("//input[@id='inputGlobal']")).sendKeys(email, Keys.ENTER);
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='link asc-list-name highlight'][contains(text(),'Manual " + LN + "')]")));
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='link asc-list-name highlight'][contains(text(),'Manual " + LN + "')]/../../../../..//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")));
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//div[@class='link asc-list-name highlight'][contains(text(),'Manual " + LN + "')]/../../../../..//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='asc-candidate-expanded-name'][contains(text(),'Manual " + LN + "')]")));
    }

    @Then("I fill in empty fields for the profile PT")
    public void iFillInEmptyFieldsForTheProfilePT() {
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Add New Profile')]")));
        final String randomEmail = randomEmail();
        getDriver().findElement(By.xpath("//input[@id='asc-email']")).sendKeys(randomEmail);
        email = randomEmail;
        System.out.println("Manual Added User Email = " + randomEmail);
        getDriver().findElement(By.xpath("//input[@id='asc-cellphone']")).sendKeys("610-852-8288");
        getDriver().findElement(By.xpath("//input[@id='asc-phone']")).sendKeys("609-602-2709");
        getDriver().findElement(By.xpath("//input[@id='user-address1']")).sendKeys("4144  Filbert Street");
        getDriver().findElement(By.xpath("//input[@id='user-address2']")).sendKeys("877  Westfall Avenue");
        getDriver().findElement(By.xpath("//input[@id='user-city']")).sendKeys("WILDWOOD");
        getDriver().findElement(By.xpath("//input[@id='user-state']")).sendKeys("New Jersey");
        getDriver().findElement(By.xpath("//input[@id='user-zipcode']")).sendKeys("08260");
        getDriver().findElement(By.xpath("//div[@id='asc_personal_country_chosen']//a[@class='chosen-single chosen-default']")).click();
        while (getDriver().findElement(By.xpath("//div[@id='asc_personal_country_chosen']//a[@class='chosen-single chosen-default']/..//li[2]")).isDisplayed() == false) {
            getDriver().findElement(By.xpath("//div[@id='asc_personal_country_chosen']//a[@class='chosen-single chosen-default']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='asc_personal_country_chosen']//a[@class='chosen-single chosen-default']/..//li[2]")));
        }
        getDriver().findElement(By.xpath("//div[@id='asc_personal_country_chosen']//a[@class='chosen-single chosen-default']/..//li[2]")).click();
        getDriver().findElement(By.xpath("//input[@id='asc-site-site_linkedin']")).sendKeys("https://www.linkedin.com/in/tessy-anicattu-mathew-4b407119a/");
        getDriver().findElement(By.xpath("//select[@id='asc-client-crm-status-field']")).click();
        getDriver().findElement(By.xpath("//select[@id='asc-client-crm-status-field']//option[2]")).click();
        getDriver().findElement(By.xpath("//div[@id='asc_group_select_chosen']//input")).click();
        getDriver().findElement(By.xpath("//div[@id='asc_group_select_chosen']//ul[@class='chosen-results']//li[2]")).click();
        getDriver().findElement(By.xpath("//select[@id='asc-basic-source-field']")).click();
        getDriver().findElement(By.xpath("//select[@id='asc-basic-source-field']//optgroup[2]//option[1]")).click();
        getDriver().findElement(By.xpath("//select[@id='asc-basic-recruiter-field']")).click();
        getDriver().findElement(By.xpath("//select[@id='asc-basic-recruiter-field']//option[2]")).click();
        getDriver().findElement(By.xpath("//input[@id='asc-add-user-quick-comment']")).sendKeys("This is a quick comment");
        getDriver().findElement(By.xpath("//a[@id='asc-add-new-org-text-box']")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[contains(@name,'ascendify[client_user_partner_org]')])[2]")));
        getDriver().findElement(By.xpath("(//select[contains(@name,'ascendify[client_user_partner_org]')])[2]")).click();
        getDriver().findElement(By.xpath("(//select[contains(@name,'ascendify[client_user_partner_org]')])[2]//option[2]")).click();
        getDriver().findElement(By.xpath("//span[@class='trash-can']")).click();
        getDriver().findElement(By.xpath("//button[@class='btn btn-xs btn-danger asc-del-confirm']")).click();
        getDriver().findElement(By.xpath("//input[@id='asc-add-user-tag-input']")).sendKeys("Tag One");
        getDriver().findElement(By.xpath("//button[@id='asc-asd-user-tag-btn']")).click();
        getDriver().findElement(By.xpath("//i[@class='link asc-skills-close asc-icons-close fa fa-times']")).click();

        getDriver().findElement(By.xpath("//a[@class='asc-add-user-summary-link'][contains(text(),'My List')]")).click();
        if (getDriver().findElements(By.xpath("//select[@id='folder-list']//option[1]")).size() != 0) {
            getDriver().findElement(By.xpath("//select[@id='folder-list']//option[1]")).click();
            getDriver().findElement(By.xpath("//span//a[@class='reset-select'][contains(text(),'Clear')]")).click();
            getDriver().findElement(By.xpath("//select[@id='folder-list']//option[1]")).click();
        }
        getDriver().findElement(By.xpath("//div[@class='asc-new-user-new-folder']//a[contains(text(),'New')]")).click();
        String uuid = UUID.randomUUID().toString();
        getDriver().findElement(By.xpath("//div[@class='asc-new-user-new-folder-text-div']//input[@placeholder='Name your list']")).sendKeys(uuid);
        list = uuid;

        if (getDriver().findElements(By.xpath("//a[contains(text(),'My Open Requisitions')]")).size() != 0) {
            getDriver().findElement(By.xpath("//a[contains(text(),'My Open Requisitions')]")).click();
            if (getDriver().findElements(By.xpath("//select[@id='asc-add-user-to-req-select']//option[1]")).size() != 0) {
                getDriver().findElement(By.xpath("//select[@id='asc-add-user-to-req-select']//option[1]")).click();
                getDriver().findElement(By.xpath("//a[contains(text(),'My Open Requisitions')]/../..//a[@class='reset-select'][contains(text(),'Clear')]")).click();
                getDriver().findElement(By.xpath("//select[@id='asc-add-user-to-req-select']//option[1]")).click();
            }
        }

        if (getDriver().findElements(By.xpath("//a[contains(text(),'My Open Resume Collections')]")).size() != 0) {
            getDriver().findElement(By.xpath("//a[contains(text(),'My Open Resume Collections')]")).click();
            if (getDriver().findElements(By.xpath("//a[contains(text(),'My Open Resume Collections')]/../..//select//option[1]")).size() != 0) {
                getDriver().findElement(By.xpath("//a[contains(text(),'My Open Resume Collections')]/../..//select//option[1]")).click();
                getDriver().findElement(By.xpath("//a[contains(text(),'My Open Resume Collections')]/../..//a[@class='reset-select'][contains(text(),'Clear')]")).click();
                getDriver().findElement(By.xpath("//a[contains(text(),'My Open Resume Collections')]/../..//select//option[1]")).click();
            }
        }

        if (getDriver().findElements(By.xpath("//a[contains(text(),'My Pipeline')]")).size() != 0) {
            getDriver().findElement(By.xpath("//a[contains(text(),'My Pipeline')]")).click();
            if (getDriver().findElements(By.xpath("//a[contains(text(),'My Pipeline')]/../..//select//optgroup[1]//option[1]")).size() != 0) {
                getDriver().findElement(By.xpath("//a[contains(text(),'My Pipeline')]/../..//select//optgroup[1]//option[1]")).click();
                getDriver().findElement(By.xpath("//a[contains(text(),'My Pipeline')]/../..//a[@class='reset-select'][contains(text(),'Clear')]")).click();
                getDriver().findElement(By.xpath("//a[contains(text(),'My Pipeline')]/../..//select//optgroup[1]//option[1]")).click();
            }
        }
    }
}