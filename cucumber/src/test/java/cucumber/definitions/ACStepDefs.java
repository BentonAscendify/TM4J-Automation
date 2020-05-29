package cucumber.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.UUID;

import static cucumber.support.TestContext.getDriver;

public class ACStepDefs {

    private static String randomEmail() {
        return "tessymathew+" + UUID.randomUUID().toString() + "@gmail.com";
    }

    @Then("{string} page is displayed AC")
    public void pageIsDisplayedAC(String arg0) throws Throwable {
        if (arg0.equalsIgnoreCase("Main Menu")) {
            Thread.sleep(8000);
            new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Main Menu')]")));
            getDriver().findElement(By.xpath("//span[contains(text(),'Main Menu')]")).isDisplayed();
        }
    }

    @And("I go to Admin Console AC")
    public void iGoToAdminConsoleAC() throws Throwable {
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[contains(@class,'fa fa-caret-down')]")));
        getDriver().findElement(By.xpath("//i[contains(@class,'fa fa-caret-down')]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//li[contains(text(),'Admin Console')]")).click();
        Thread.sleep(2000);
        while (getDriver().findElements(By.xpath("//input[@id='user-search']")).size() == 0) {
            getDriver().navigate().refresh();
            try {
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='user-search']")));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @And("I click on {string} button AC")
    public void iClickOnButton(String arg0) throws Throwable {
        if (arg0.equalsIgnoreCase("New")) {
            getDriver().findElement(By.xpath("//div[@id='asc-admin-add-user-btn']")).click();
        } else if (arg0.equalsIgnoreCase("Save")) {
            getDriver().findElement(By.xpath("//button[@class='btn btn-primary btn-save']")).click();
        }
    }

    String email;

    @Then("I manually add new user's profile AC")
    public void iManuallyAddNewUserSProfilePT() throws Throwable {
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='First Name']")));
        getDriver().findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Manual");
        getDriver().findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("User");
        final String randomEmail = randomEmail();
        getDriver().findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(randomEmail);
        email = randomEmail;
        System.out.println("Manual Added User Email = " + randomEmail);
        getDriver().findElement(By.xpath("//input[@id='asc-signup-cellphonenumber']")).sendKeys("610-852-8288");
        getDriver().findElement(By.xpath("//input[@id='asc-signup-phonenumber']")).sendKeys("609-602-2709");
        getDriver().findElement(By.xpath("//input[@placeholder='City']")).sendKeys("WILDWOOD");
        getDriver().findElement(By.xpath("//input[@placeholder='State or Province']")).sendKeys("New Jersey");
        getDriver().findElement(By.xpath("//input[@id='site_linkedin']")).sendKeys("https://www.linkedin.com/in/tessy-anicattu-mathew-4b407119a/");
        getDriver().findElement(By.xpath("//select[@name='ascendify[client_crm_status_id]']")).click();
        getDriver().findElement(By.xpath("//select[@name='ascendify[client_crm_status_id]']//option[2]")).click();
        getDriver().findElement(By.xpath("//input[@placeholder='Role(s)']")).click();
        getDriver().findElement(By.xpath("//select[@name='acl_group_id[]']//option[2]")).click();
        getDriver().findElement(By.xpath("//span[contains(text(),'Primary Source')]")).click();
        getDriver().findElement(By.xpath("//select[@name='ascendify[client_user_source_id]']//optgroup[2]//option[1]")).click();

        WebElement recruiter = getDriver().findElement(By.xpath("//select[@name='ascendify[recruiter]']"));
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].click()", recruiter);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", recruiter);
        getDriver().findElement(By.xpath("//select[@name='ascendify[recruiter]']")).click();
        getDriver().findElement(By.xpath("//select[@name='ascendify[recruiter]']//option[2]")).click();

        getDriver().findElement(By.xpath("//input[@placeholder='Add quick note']")).sendKeys("This is a quick note");
        getDriver().findElement(By.xpath("//select[@name='ascendify[client_user_partner_org][org1][client_partner_org_id]']")).click();
        getDriver().findElement(By.xpath("//select[@name='ascendify[client_user_partner_org][org1][client_partner_org_id]']//option[1]")).click();
        getDriver().findElement(By.xpath("//a[@id='add-new-org']")).click();

        if (getDriver().findElement(By.xpath("//select[@name='ascendify[careers][total_tenure][month]']")).isDisplayed() == true) {
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='ascendify[careers][total_tenure][month]']")));
            getDriver().findElement(By.xpath("//select[@name='ascendify[careers][total_tenure][month]']")).click();
            getDriver().findElement(By.xpath("//select[@name='ascendify[careers][total_tenure][month]']//option[2]")).click();
        }
        if (getDriver().findElement(By.xpath("//span[@id='select2-career_total_tenure_year-container']")).isDisplayed() == true) {
            getDriver().findElement(By.xpath("//span[@id='select2-career_total_tenure_year-container']")).click();
            getDriver().findElement(By.xpath("//span[@class='select2-search select2-search--dropdown']/..//li[2]")).click();
        }
        if (getDriver().findElement(By.xpath("//select[@name='ascendify[careers][job_tenure][month]']")).isDisplayed() == true) {
            getDriver().findElement(By.xpath("//select[@name='ascendify[careers][job_tenure][month]']")).click();
            getDriver().findElement(By.xpath("//select[@name='ascendify[careers][job_tenure][month]']//option[3]")).click();
        }
        if (getDriver().findElement(By.xpath("//span[@id='select2-career_job_tenure_year-container']")).isDisplayed() == true) {
            getDriver().findElement(By.xpath("//span[@id='select2-career_job_tenure_year-container']")).click();
            getDriver().findElement(By.xpath("//span[@class='select2-search select2-search--dropdown']/..//li[3]")).click();
        }

        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='ascendify[client_user_partner_org][org1][client_partner_org_id]']")));
        getDriver().findElement(By.xpath("//select[@name='ascendify[client_user_partner_org][org1][client_partner_org_id]']")).click();
        getDriver().findElement(By.xpath("//select[@name='ascendify[client_user_partner_org][org1][client_partner_org_id]']//option[2]")).click();
        getDriver().findElement(By.xpath("//i[@class='fa fa-trash-o action-icon icon']")).click();
        getDriver().findElement(By.xpath("//input[@id='tag-input']")).sendKeys("Tag One");
        getDriver().findElement(By.xpath("//button[@id='tag-submit']")).click();
        getDriver().findElement(By.xpath("//span[@class='badge badge--addOn']")).click();

        getDriver().findElement(By.xpath("//a[contains(text(),'My List')]")).click();
        new WebDriverWait(getDriver(), 100).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='mylist']//div[@class='Organize_Folder']//select[contains(@name,'ascendify[folders]')]")));
        if (getDriver().findElements(By.xpath("//div[@id='mylist']//div[@class='Organize_Folder']//select[contains(@name,'ascendify[folders]')]//option[1]")).size() != 0) {
            getDriver().findElement(By.xpath("//div[@id='mylist']//div[@class='Organize_Folder']//select[contains(@name,'ascendify[folders]')]//option[1]")).click();
        }
        getDriver().findElement(By.xpath("//a[@class='pull-right addToList']")).click();
        getDriver().findElement(By.xpath("//input[@placeholder='Name your list']")).sendKeys("New List");

        getDriver().findElement(By.xpath("//a[contains(text(),'My Open Requisitions')]")).click();
        if (getDriver().findElements(By.xpath("//div[@id='openRequisitions']//div[@class='Organize_Folder']//select[contains(@name,'ascendify[folders]')]//option[1]")).size() != 0) {
            getDriver().findElement(By.xpath("//div[@id='openRequisitions']//div[@class='Organize_Folder']//select[contains(@name,'ascendify[folders]')]//option[1]")).click();
        }

        if (getDriver().findElements(By.xpath("//a[contains(text(),'My Open Collections')]")).size() != 0) {
            getDriver().findElement(By.xpath("//a[contains(text(),'My Open Collections')]")).click();
            if (getDriver().findElements(By.xpath("//div[@id='openCollections']//div[@class='Organize_Folder']//select[contains(@name,'ascendify[folders]')]//option[1]")).size() != 0) {
                getDriver().findElement(By.xpath("//div[@id='openCollections']//div[@class='Organize_Folder']//select[contains(@name,'ascendify[folders]')]//option[1]")).click();
            }
        }

        if (getDriver().findElements(By.xpath("//a[contains(text(),'My Pipeline')]")).size() != 0) {
            getDriver().findElement(By.xpath("//a[contains(text(),'My Pipeline')]")).click();
            if (getDriver().findElements(By.xpath("//div[@id='pipelines']//div[@class='Organize_Folder']//select[contains(@name,'ascendify[folders]')]//optgroup[1]//option[1]")).size() != 0) {
                getDriver().findElement(By.xpath("//div[@id='pipelines']//div[@class='Organize_Folder']//select[contains(@name,'ascendify[folders]')]//optgroup[1]//option[1]")).click();
            }
        }
    }

    @Then("{string} message is displayed AC")
    public void messageIsDisplayed(String arg0) throws Throwable {
        if (arg0.equalsIgnoreCase("User saved")) {
            new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='alerts'][contains(text(),'User saved.')]")));
        }
    }

    @And("I click on {string} tab AC")
    public void iClickOnTa(String arg0) throws Throwable {
        if (arg0.equalsIgnoreCase("People")) {
            getDriver().findElement(By.xpath("//div[@id='sections-toggle']")).click();
            if (getDriver().findElements(By.xpath("//ul[@class='header_menu__sections-menu nav navbar-nav']")).size() == 0) {
                getDriver().findElement(By.xpath("//div[@id='sections-toggle']")).click();
            }
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
        }
    }

    @And("I make sure that new user is visible in People tab AC")
    public void iMakeSureThatNewUserIsVisibleInPeopleTabAC() throws Throwable {
        while (getDriver().findElements(By.xpath("//div[@class='link asc-list-name highlight'][contains(text(),'Manual User')]")).size() == 0) {
            Thread.sleep(1000);
            getDriver().findElement(By.xpath("//button[@id='candidate-status-filter-btn']")).click();
            getDriver().findElement(By.xpath("//input[@id='asc-all']")).click();
            getDriver().findElement(By.xpath("//div[@id='asc-show-all']")).click();
            new WebDriverWait(getDriver(), 100).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")));
            Thread.sleep(1000);
        }

        if (getDriver().findElements(By.xpath("//span[contains(text(),'My List')]/..//span[contains(@class,'show-all link fa fa-ellipsis-h')]")).size() != 0) {
            getDriver().findElement(By.xpath("//span[contains(text(),'My List')]/..//span[contains(@class,'show-all link fa fa-ellipsis-h')]")).click();
        }
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'link-text')][contains(text(),'New List')]")));
        getDriver().findElement(By.xpath("//div[contains(@class,'link-text')][contains(text(),'New List')]")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='asc-sort-by-div']")));
        getDriver().findElement(By.xpath("//span[@id='asc-sort-by-div']")).click();
        getDriver().findElement(By.xpath("//*[@data-field='client_users.created DESC']")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")));
        getDriver().findElement(By.xpath("(//div[@class='asc-list-inner-div'])[1]//div[@class='link asc-list-name highlight'][contains(text(),'Manual User')]")).isDisplayed();

        if (getDriver().findElements(By.xpath("//span[contains(text(),'My List')]/../..//li[1]//a[1]")).size() != 0) {
            getDriver().findElement(By.xpath("//span[contains(text(),'My List')]/../..//li[1]//a[1]")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='asc-sort-by-div']")));
            getDriver().findElement(By.xpath("//span[@id='asc-sort-by-div']")).click();
            getDriver().findElement(By.xpath("//*[@data-field='client_users.created DESC']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")));
            getDriver().findElement(By.xpath("(//div[@class='asc-list-inner-div'])[1]//div[@class='link asc-list-name highlight'][contains(text(),'Manual User')]")).isDisplayed();
        }

        if (getDriver().findElements(By.xpath("//span[contains(text(),'My Open Requisitions')]/../..//li[1]//a[1]")).size() != 0) {
            getDriver().findElement(By.xpath("//span[contains(text(),'My Open Requisitions')]/../..//li[1]//a[1]")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='asc-sort-by-div']")));
            getDriver().findElement(By.xpath("//span[@id='asc-sort-by-div']")).click();
            getDriver().findElement(By.xpath("//a[@id='asc-sort-folder-created']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")));
            getDriver().findElement(By.xpath("(//div[@class='asc-list-inner-div'])[1]//div[@class='link asc-list-name highlight'][contains(text(),'Manual User')]")).isDisplayed();
        }

        if (getDriver().findElements(By.xpath("//span[contains(text(),'My Open Resume Collections')]/../..//li[1]//a[1]")).size() != 0) {
            getDriver().findElement(By.xpath("//span[contains(text(),'My Open Resume Collections')]/../..//li[1]//a[1]")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='asc-sort-by-div']")));
            getDriver().findElement(By.xpath("//span[@id='asc-sort-by-div']")).click();
            getDriver().findElement(By.xpath("//a[@id='asc-sort-folder-created']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")));
            getDriver().findElement(By.xpath("(//div[@class='asc-list-inner-div'])[1]//div[@class='link asc-list-name highlight'][contains(text(),'Manual User')]")).isDisplayed();
        }

        if (getDriver().findElements(By.xpath("(//span[contains(text(),'My Pipeline')]/../..//a[1]/..//ul[1]//li[1]//a[1])[1]")).size() != 0) {
            getDriver().findElement(By.xpath("(//span[contains(text(),'My Pipeline')]/../..//a[1]/..//ul[1]//li[1]//a[1])[1]")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")));
            getDriver().findElement(By.xpath("//span[@id='asc-sort-by-div']")).click();
            getDriver().findElement(By.xpath("//*[@data-field='client_users.created DESC']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")));
            getDriver().findElement(By.xpath("(//div[@class='asc-list-inner-div'])[1]//div[@class='link asc-list-name highlight'][contains(text(),'Manual User')]")).isDisplayed();
        }
    }

    @And("I clean up {string} AC")
    public void iCleanUpPT(String arg0) throws Throwable {
        getDriver().findElement(By.xpath("//i[contains(@class,'fa fa-caret-down')]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//li[contains(text(),'Admin Console')]")).click();
        Thread.sleep(2000);
        while (getDriver().findElements(By.xpath("//input[@id='user-search']")).size() == 0) {
            getDriver().navigate().refresh();
            try {
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='user-search']")));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (arg0.equalsIgnoreCase("CSV")) {
            Thread.sleep(180000);
            getDriver().findElement(By.xpath("//input[@id='user-search']")).sendKeys("donald@gmail.com", Keys.ENTER);
            Thread.sleep(4000);

            while (getDriver().findElements(By.xpath("//i[@class='fa fa-chevron-down']")).size() == 0) {
                getDriver().findElement(By.xpath("//input[@id='user-search']")).sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
                getDriver().findElement(By.xpath("//input[@id='user-search']")).sendKeys("donald@gmail.com", Keys.ENTER);
                Thread.sleep(4000);
                long startTime = System.currentTimeMillis();
                if ((System.currentTimeMillis() - startTime) == 200000)
                    System.out.println("Error: CSV Files are not uploaded");
                break;
            }

            getDriver().findElement(By.xpath("//a[contains(text(),'Megan Terry')]/../..//i[@class='fa fa-chevron-down']")).click();
            Thread.sleep(2000);
            getDriver().findElement(By.xpath("//a[@class='action-call-deleteUser']")).click();
            Thread.sleep(2000);
            Alert alert = getDriver().switchTo().alert();
            alert.accept();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success']")));

            getDriver().findElement(By.xpath("//input[@id='user-search']")).click();
            getDriver().findElement(By.xpath("//input[@id='user-search']")).sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
            getDriver().findElement(By.xpath("//input[@id='user-search']")).sendKeys("trump@gmail.com", Keys.ENTER);
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Grayson Martin')]/../..//i[@class='fa fa-chevron-down']")));
            getDriver().findElement(By.xpath("//a[contains(text(),'Grayson Martin')]/../..//i[@class='fa fa-chevron-down']")).click();
            Thread.sleep(2000);
            getDriver().findElement(By.xpath("//a[@class='action-call-deleteUser']")).click();
            alert.accept();
            Thread.sleep(2000);
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success']")));
        } else if (arg0.equalsIgnoreCase("Bulk")) {
            getDriver().findElement(By.xpath("//input[@id='user-search']")).sendKeys("Donald Trump", Keys.ENTER);
            Thread.sleep(4000);
            getDriver().findElement(By.xpath("//th[contains(text(),'Created Date')]")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Donald Trump')]/../..//i[@class='fa fa-chevron-down']")));
            getDriver().findElement(By.xpath("//a[contains(text(),'Donald Trump')]/../..//i[@class='fa fa-chevron-down']")).click();
            Thread.sleep(2000);
            getDriver().findElement(By.xpath("//a[@class='action-call-deleteUser']")).click();
            Thread.sleep(2000);
            Alert alert = getDriver().switchTo().alert();
            alert.accept();
            Thread.sleep(2000);
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success']")));

            getDriver().findElement(By.xpath("//input[@id='user-search']")).click();
            getDriver().findElement(By.xpath("//input[@id='user-search']")).sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
            getDriver().findElement(By.xpath("//input[@id='user-search']")).sendKeys("Narendra Modi", Keys.ENTER);
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Narendra Modi')]/../..//i[@class='fa fa-chevron-down']")));
            getDriver().findElement(By.xpath("//a[contains(text(),'Narendra Modi')]/../..//i[@class='fa fa-chevron-down']")).click();
            Thread.sleep(2000);
            getDriver().findElement(By.xpath("//a[@class='action-call-deleteUser']")).click();
            Thread.sleep(2000);
            alert.accept();
            Thread.sleep(2000);
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success']")));
        } else if (arg0.equalsIgnoreCase("Manual User")) {
            getDriver().findElement(By.xpath("//input[@id='user-search']")).sendKeys(email, Keys.ENTER);
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Manual User')]/../..//i[@class='fa fa-chevron-down']")));
            getDriver().findElement(By.xpath("//a[contains(text(),'Manual User')]/../..//i[@class='fa fa-chevron-down']")).click();
            while (getDriver().findElement(By.xpath("//a[@class='action-call-deleteUser']")).isDisplayed() == false) {
                getDriver().findElement(By.xpath("//a[contains(text(),'Manual User')]/../..//i[@class='fa fa-chevron-down']")).click();
                try {
                    new WebDriverWait(getDriver(), 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='action-call-deleteUser']")));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
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
            try {
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (getDriver().findElements(By.xpath("//span[contains(text(),'My List')]/..//span[contains(@class,'show-all link fa fa-ellipsis-h')]")).size() != 0) {
                getDriver().findElement(By.xpath("//span[contains(text(),'My List')]/..//span[contains(@class,'show-all link fa fa-ellipsis-h')]")).click();
            }
            getDriver().findElement(By.xpath("//div[contains(@class,'link-text')][contains(text(),'New List')]")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='asc-del-folder-del']")));
            getDriver().findElement(By.xpath("//div[@id='asc-del-folder-del']")).click();
            getDriver().findElement(By.xpath("//button[@id='asc-del-collection']")).click();
            try {
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
