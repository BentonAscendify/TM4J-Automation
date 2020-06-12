package cucumber.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.UUID;

import static cucumber.support.TestContext.getDriver;

public class OrgStepDefs {

    private static String randomEmail() {
        return "tessymathew+" + UUID.randomUUID().toString() + "@gmail.com";
    }

    @Then("{string} page is displayed ORG")
    public void pageIsDisplayedORG(String arg0) {
        if (arg0.equalsIgnoreCase("Main Menu")) {
            new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Main Menu')]")));
            getDriver().findElement(By.xpath("//span[contains(text(),'Main Menu')]")).isDisplayed();
        }
    }

    @And("I go to {string} Tab ORG")
    public void iGoToTabORG(String arg0) {
        if (arg0.equalsIgnoreCase("Organizations")) {
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='hovicon btn-primary']//i[@class='ascendicon-organizations']")));
            getDriver().findElement(By.xpath("//div[@class='hovicon btn-primary']//a[@id='header-organ']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'asc-list-cpog')]//i[contains(@class,'fa fa-chevron-circle-right asc-list-more-information-arrow')]")));
        } else if (arg0.equalsIgnoreCase("Hiring Team")) {
            getDriver().findElement(By.xpath("//li[@id='tab-team']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='asc-add-employeer']")));
        }
    }

    @And("I choose an organization ORG")
    public void iChooseAnOrganizationORG() {
        getDriver().findElement(By.xpath("(//div[contains(@id,'asc-list-cpog')]//i[contains(@class,'fa fa-chevron-circle-right asc-list-more-information-arrow')])[1]")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='tab-team']")));
    }

    String email;
    String list;

    @Then("I manually add new user's profile ORG")
    public void iManuallyAddNewUserSProfileORG() {
        getDriver().findElement(By.xpath("//button[@id='asc-add-employeer']")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='asc-firstname']")));
        getDriver().findElement(By.xpath("//input[@id='asc-firstname']")).sendKeys("Manual");
        getDriver().findElement(By.xpath("//input[@id='asc-lastname']")).sendKeys("User");
        final String randomEmail = randomEmail();
        getDriver().findElement(By.xpath("//input[@id='asc-email']")).sendKeys(randomEmail);
        email = randomEmail;
        System.out.println("Manual Added User Email = " + randomEmail);
        getDriver().findElement(By.xpath("//input[@id='asc-cellphone']")).sendKeys("610-852-8288");
        getDriver().findElement(By.xpath("//input[@id='asc-phone']")).sendKeys("609-602-2709");
        getDriver().findElement(By.xpath("//input[@id='user-address1']")).sendKeys("1150  Dale Avenue");
        getDriver().findElement(By.xpath("//input[@id='user-address2']")).sendKeys("1521  Rivendell Drive");
        getDriver().findElement(By.xpath("//input[@id='user-city']")).sendKeys("WILDWOOD");
        getDriver().findElement(By.xpath("//input[@id='user-state']")).sendKeys("New Jersey");
        getDriver().findElement(By.xpath("//input[@id='user-zipcode']")).sendKeys("44681");

        getDriver().findElement(By.xpath("//div[@id='asc_personal_country_chosen']//a[@class='chosen-single chosen-default']")).click();
        if (getDriver().findElement(By.xpath("//div[@id='asc_personal_country_chosen']//ul[@class='chosen-results']")).isDisplayed() == false) {
            getDriver().findElement(By.xpath("//div[@id='asc_personal_country_chosen']//a[@class='chosen-single chosen-default']")).click();
        }
        getDriver().findElement(By.xpath("//div[@id='asc_personal_country_chosen']//a[@class='chosen-single chosen-default']/../..//li[2]")).click();

        getDriver().findElement(By.xpath("//input[@id='asc-site-site_linkedin']")).sendKeys("https://www.linkedin.com/in/tessy-anicattu-mathew-4b407119a/");
        getDriver().findElement(By.xpath("//select[@id='asc-client-crm-status-field']")).click();
        getDriver().findElement(By.xpath("//select[@id='asc-client-crm-status-field']//option[2]")).click();
        getDriver().findElement(By.xpath("//ul[@class='chosen-choices']")).click();
        getDriver().findElement(By.xpath("//ul[@class='chosen-choices']/..//li[2]")).click();
        getDriver().findElement(By.xpath("//select[@id='asc-basic-source-field']")).click();
        getDriver().findElement(By.xpath("(//select[@id='asc-basic-source-field']//option[2])[1]")).click();
        getDriver().findElement(By.xpath("//select[@id='asc-basic-recruiter-field']")).click();
        getDriver().findElement(By.xpath("//select[@id='asc-basic-recruiter-field']//option[2]")).click();
        getDriver().findElement(By.xpath("//input[@id='asc-add-user-quick-comment']")).sendKeys("This is a quick note");
        getDriver().findElement(By.xpath("//select[contains(@name,'ascendify[client_user_partner_org]')]")).click();
        getDriver().findElement(By.xpath("//select[contains(@name,'ascendify[client_user_partner_org]')]//option[2]")).click();
        getDriver().findElement(By.xpath("//input[@id='asc-add-user-tag-input']")).sendKeys("This is a tag");
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

    @And("I click on {string} button ORG")
    public void iClickOnButton(String arg0) throws Throwable {
        if (arg0.equalsIgnoreCase("Add Profile")) {
            while (getDriver().findElements(By.xpath("//button[@id='asc-add-user-btn']")).size() != 0) {
                getDriver().findElement(By.xpath("//button[@id='asc-add-user-btn']")).click();
                Thread.sleep(500);
            }
        }
    }

    @Then("{string} message is displayed ORG")
    public void messageIsDisplayed(String arg0) throws Throwable {
        if (arg0.equalsIgnoreCase("New user was added")) {
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'New user was added.')]")));
            getDriver().findElement(By.xpath("//div[@class='section-tab']")).click();
            while (getDriver().findElement(By.xpath("//ul[@class='sections-menu nav navbar-nav']")).isDisplayed() == false) {
                getDriver().findElement(By.xpath("//div[@class='section-tab']")).click();
                try {
                    new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/people']")));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            getDriver().findElement(By.xpath("//a[@href='/people']")).click();
            try {
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='link asc-list-name highlight'][contains(text(),'Manual User')]")));
            } catch (Exception e) {
                e.printStackTrace();
            }
            while (getDriver().findElements(By.xpath("//div[@class='link asc-list-name highlight'][contains(text(),'Manual User')]")).size() == 0) {
                getDriver().navigate().refresh();
                try {
                    new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='link asc-list-name highlight'][contains(text(),'Manual User')]")));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @And("I make sure that Organize functions in the form are working as expected ORG")
    public void iMakeSureThatOrganizeFunctionsInTheFormAreWorkingAsExpected() {
        if (getDriver().findElements(By.xpath("//span[contains(text(),'My List')]/..//span[contains(@class,'show-all link fa fa-ellipsis-h')]")).size() != 0) {
            getDriver().findElement(By.xpath("//span[contains(text(),'My List')]/..//span[contains(@class,'show-all link fa fa-ellipsis-h')]")).click();
        }
        int retry = 0;
        while (getDriver().findElements(By.xpath("//div[contains(@class,'link-text')][contains(text(),'" + list + "')]")).size() != 0) {
            getDriver().navigate().refresh();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")));
            if (getDriver().findElements(By.xpath("//span[contains(text(),'My List')]/..//span[contains(@class,'show-all link fa fa-ellipsis-h')]")).size() != 0) {
                getDriver().findElement(By.xpath("//span[contains(text(),'My List')]/..//span[contains(@class,'show-all link fa fa-ellipsis-h')]")).click();
            }
            if (retry < 10) {
                break;
            }
            retry++;
        }
        getDriver().findElement(By.xpath("//div[contains(@class,'link-text')][contains(text(),'" + list + "')]")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='asc-sort-by-div']")));
        getDriver().findElement(By.xpath("//span[@id='asc-sort-by-div']")).click();
        getDriver().findElement(By.xpath("//*[@data-field='client_users.created DESC']")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")));
        getDriver().findElement(By.xpath("(//div[@class='asc-list-inner-div'])[1]//div[@class='link asc-list-name highlight'][contains(text(),'Manual User')]")).isDisplayed();

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
            if (getDriver().findElement(By.xpath("//span[@id='asc-sort-by-div']")).isDisplayed() == true) {
                try {
                    getDriver().findElement(By.xpath("//span[@id='asc-sort-by-div']")).click();
                    getDriver().findElement(By.xpath("//*[@data-field='client_users.created DESC']")).click();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")));
            getDriver().findElement(By.xpath("(//div[@class='asc-list-inner-div'])[1]//div[@class='link asc-list-name highlight'][contains(text(),'Manual User')]")).isDisplayed();
        }
    }

    @And("I clean up {string} ORG")
    public void iCleanUpPT(String arg0) throws Throwable {
        getDriver().findElement(By.xpath("//i[contains(@class,'fa fa-caret-down')]")).click();
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

        if (arg0.equalsIgnoreCase("Manual User")) {
            getDriver().findElement(By.xpath("//input[@id='user-search']")).sendKeys(email, Keys.ENTER);
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Manual User')]/../..//i[@class='fa fa-chevron-down']")));
            getDriver().findElement(By.xpath("//a[contains(text(),'Manual User')]/../..//i[@class='fa fa-chevron-down']")).click();
            while (getDriver().findElement(By.xpath("//a[@class='action-call-deleteUser']")).isDisplayed() == false) {
                getDriver().findElement(By.xpath("//a[contains(text(),'Manual User')]/../..//i[@class='fa fa-chevron-down']")).click();
            }
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='action-call-deleteUser']")));
            getDriver().findElement(By.xpath("//a[@class='action-call-deleteUser']")).click();
            Thread.sleep(500);
            Alert alert = getDriver().switchTo().alert();
            alert.accept();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success']")));

            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='sections-toggle']")));
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
}
