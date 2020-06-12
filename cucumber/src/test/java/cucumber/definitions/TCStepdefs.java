package cucumber.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static cucumber.support.AbstractContext.getConfig;
import static cucumber.support.TestContext.getDriver;

public class TCStepdefs<session> {

    private static String randomEmail() {
        return "tessymathew+" + UUID.randomUUID().toString() + "@gmail.com";
    }

    @When("I click on {string} button TC")
    public void iClickOnButton(String arg0) throws Throwable {
        if (arg0.equalsIgnoreCase("Join Our Team")) {
            getDriver().findElement(By.xpath("//a[contains(text(),'Join Our Team »')]")).click();
        } else if (arg0.equalsIgnoreCase("Submit")) {
            getDriver().findElement(By.xpath("//button[@id='asc-signup-main-button']")).click();
            Thread.sleep(4000);
        } else if (arg0.equalsIgnoreCase("Apply Now")) {
            new WebDriverWait(getDriver(), 200).until(ExpectedConditions.elementToBeClickable(By.id("asc-job-apply-btn")));
            getDriver().findElement(By.xpath("//button[@id='asc-job-apply-btn']")).click();
        } else if (arg0.equalsIgnoreCase("Submit Application")) {
            if (getDriver().findElements(By.xpath("//button[@id='asc-job-application-survey-btn']")).size() != 0) {
                getDriver().findElement(By.xpath("//button[@id='asc-job-application-survey-btn']")).click();
            }
            if (getDriver().findElements(By.xpath("//button[@id='asc-job-apply-confirm-btn']")).size() != 0) {
                getDriver().findElement(By.xpath("//button[@id='asc-job-apply-confirm-btn']")).click();
            }
        } else if (arg0.equalsIgnoreCase("Upload Your Resume")) {
            getDriver().findElement(By.xpath("//span[@class='browse-btn']")).click();
        } else if (arg0.equalsIgnoreCase("Apply with LinkedIn")) {
            Thread.sleep(2000);
            getDriver().manage().window().maximize();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[contains(@src,'https://www.linkedin.com')]")));
            getDriver().findElement(By.xpath("//button")).isDisplayed();
            new WebDriverWait(getDriver(), 200).until(ExpectedConditions.elementToBeClickable(By.xpath("//button")));
            getDriver().findElement(By.xpath("//button[@name='awli-button-member']")).click();
            Thread.sleep(2000);
            Alert alert = getDriver().switchTo().alert();
            Thread.sleep(2000);
            alert.accept();
            Thread.sleep(2000);
            getDriver().switchTo().defaultContent();
            Thread.sleep(16000);
        }
    }

    @And("I click on link text {string} TC")
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
        } else if (arg0.equalsIgnoreCase("Opportunity under Tessy's Org")) {
            new WebDriverWait(getDriver(), 200).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),\"Opportunity under Tessy's Org\")]")));
            getDriver().findElement(By.xpath("//a[contains(text(),\"Opportunity under Tessy's Org\")]")).click();
        }
    }

    @Then("{string} page is displayed TC")
    public void pageIsDisplayed(String arg0) throws Throwable {
        if (arg0.equalsIgnoreCase("Application")) {
            new WebDriverWait(getDriver(), 30).until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[contains(text(),'Information')]")));
            getDriver().findElement(By.xpath("//h2[contains(text(),'Information')]")).isDisplayed();
        } else if (arg0.equalsIgnoreCase("Dashboard")) {
            try {
                if (getDriver().findElement(By.xpath("//input[@id='id_username']")).isDisplayed()) {
                    getDriver().findElement(By.xpath("//input[@id='id_username']")).sendKeys(Keys.CONTROL, "a");
                    getDriver().findElement(By.xpath("//input[@id='id_username']")).sendKeys(Keys.BACK_SPACE);
                    getDriver().findElement(By.xpath("//input[@id='id_username']")).sendKeys(getConfig().get("candidateUsername").toString());

                    getDriver().findElement(By.xpath("//input[@id='id_password']")).sendKeys(Keys.CONTROL, "a");
                    getDriver().findElement(By.xpath("//input[@id='id_password']")).sendKeys(Keys.BACK_SPACE);
                    getDriver().findElement(By.xpath("//input[@id='id_password']")).sendKeys(getConfig().get("candidatePassword").toString());
                    getDriver().findElement(By.xpath("//button[@id='asc-signin-btn']")).click();
                    Thread.sleep(2000);
                } else {
                    new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.id("tab-profile-dashboard")));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (getDriver().findElements(By.id("tab-profile-dashboard")).size() == 0) {
                getDriver().get(getConfig().get("talentCommunityLogin").toString());
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='asc-main-user-menu']")));
                getDriver().findElement(By.xpath("//a[@id='asc-main-user-menu']")).click();
                getDriver().findElement(By.xpath("//a[@id='asc-profile-btn']")).click();
            }

            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.id("tab-profile-dashboard")));
            getDriver().findElement(By.xpath("//*[@id='tab-profile-dashboard']")).isDisplayed();
            getDriver().findElement(By.id("tab-profile-dashboard")).isDisplayed();
            getDriver().findElement(By.xpath("//li[@id='tab-profile-dashboard']")).click();
        } else if (arg0.equalsIgnoreCase("Sign In")) {
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.id("asc-signin-container")));
        }
    }

    String email;

    @And("I fill in {string} fields TC")
    public void iFillInFields(String arg0) throws Throwable {
        if (arg0.equalsIgnoreCase("Your Information")) {
            WebElement FN = getDriver().findElement(By.xpath("//*[@id='asc-signup-firstname']"));
            String textInsideFN = FN.getAttribute("value");
            if (textInsideFN.isEmpty()) {
                getDriver().findElement(By.xpath("//*[@id='asc-signup-firstname']")).sendKeys("Tessy");
            }

            WebElement LN = getDriver().findElement(By.xpath("//*[@id='asc-signup-lastname']"));
            String textInsideLN = LN.getAttribute("value");
            if (textInsideLN.isEmpty()) {
                getDriver().findElement(By.xpath("//*[@id='asc-signup-lastname']")).sendKeys("Mathew");
            }

            WebElement EM = getDriver().findElement(By.xpath("//input[@id='asc-signup-email2']"));
            String textInsideEM = EM.getAttribute("value");
            if (textInsideEM.isEmpty()) {
                final String randomEmail = randomEmail();
                getDriver().findElement(By.xpath("//input[@id='asc-signup-email2']")).sendKeys(randomEmail);
                if (getDriver().findElements(By.xpath("//input[@id='asc-signup-email1']")).size() != 0) {
                    getDriver().findElement(By.xpath("//input[@id='asc-signup-email1']")).sendKeys(randomEmail);
                }
                email = randomEmail;
                System.out.println("Email = " + randomEmail);
            }

            Thread.sleep(2000);

            WebElement PWD = getDriver().findElement(By.xpath("//input[@id='password1']"));
            String textInsidePWD = PWD.getAttribute("value");
            if (textInsidePWD.isEmpty()) {
                getDriver().findElement(By.xpath("//input[@id='password1']")).sendKeys("Ascendify246!");
                getDriver().findElement(By.xpath("//input[@id='password2']")).sendKeys("Ascendify246!");
            }
        } else if (arg0.equalsIgnoreCase("Additional Information")) {
            try {
                WebElement CPN = getDriver().findElement(By.xpath("//input[@id='asc-signup-cellphonenumber']"));
                String textInsideCPN = CPN.getAttribute("value");
                if (textInsideCPN.isEmpty()) {
                    getDriver().findElement(By.xpath("//input[@id='asc-signup-cellphonenumber']")).sendKeys("610-852-8288");
                }

                WebElement PN = getDriver().findElement(By.xpath("//input[@id='asc-signup-phonenumber']"));
                String textInsidePN = PN.getAttribute("value");
                if (textInsidePN.isEmpty()) {
                    getDriver().findElement(By.xpath("//input[@id='asc-signup-phonenumber']")).sendKeys(Keys.CONTROL, "a");
                    getDriver().findElement(By.xpath("//input[@id='asc-signup-phonenumber']")).sendKeys(Keys.BACK_SPACE);
                    getDriver().findElement(By.xpath("//input[@id='asc-signup-phonenumber']")).sendKeys("609-602-2709");
                }

                getDriver().findElement(By.xpath("//input[@id='asc-signup-address1']")).sendKeys("4144  Filbert Street");
                getDriver().findElement(By.xpath("//input[@id='asc-signup-city']")).sendKeys("WILDWOOD");
                getDriver().findElement(By.xpath("//input[@id='asc-signup-state']")).sendKeys("New Jersey");
                getDriver().findElement(By.xpath("//input[@id='asc-signup-postal_code']")).sendKeys("08260");
                getDriver().findElement(By.xpath("//select[@id='asc-personal-country']/option[contains(text(),'India')]")).click();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (getDriver().findElements(By.xpath("//select")).size() != 0) {
                int select = getDriver().findElements(By.xpath("//select")).size();
                for (int i = 1; i <= select; i++) {
                    try {
                        getDriver().findElement(By.xpath("(//select)[" + i + "]")).click();
                        getDriver().findElement(By.xpath("(//select)[" + i + "]//option[2]")).click();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Thread.sleep(3000);
                }
            }
            if (getDriver().findElements(By.xpath("//textarea")).size() != 0) {
                int textarea = getDriver().findElements(By.xpath("//textarea")).size();
                for (int i = 1; i <= textarea; i++) {
                    try {
                        getDriver().findElement(By.xpath("(//textarea)[" + i + "]")).sendKeys("Textarea");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } else if (arg0.equalsIgnoreCase("Profile Information")) {
            try {
                getDriver().findElement(By.xpath("//input[@id='ct_sms']")).click();
                getDriver().findElement(By.xpath("//input[@name='ascendify[communication_preference][automated_sms_sys_msg]']")).click();
                getDriver().findElement(By.xpath("//input[@name='ascendify[communication_preference][receive_email_news_info_career_event]']")).click();
                getDriver().findElement(By.xpath("//a[@class='chosen-single chosen-default']//div//b")).click();
                getDriver().findElement(By.xpath("//div[@class='chosen-search']//input")).sendKeys("Masters Degree", Keys.ENTER);
                getDriver().findElement(By.xpath("//li[contains(@class,'search-field')]")).click();
                getDriver().findElement(By.xpath("//li[contains(@class,'search-field')]//input")).sendKeys("California", Keys.ENTER);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (getDriver().findElements(By.xpath("//input[@type='radio']")).size() != 0) {
                int yes = getDriver().findElements(By.xpath("//input[contains(@id,'asc-question-csvq')][@type='radio']")).size();
                for (int i = 1; i <= yes; i++) {
                    try {
                        WebElement radio = getDriver().findElement(By.xpath("(//input[contains(@id,'asc-question-csvq')][@type='radio']/../..//div[1])[" + i + "]//input"));
                        Actions actions = new Actions(getDriver());
                        actions.moveToElement(radio).click().perform();
                        Thread.sleep(2000);
                        getDriver().findElement(By.xpath("(//input[contains(@id,'asc-question-csvq')][@type='radio']/../..//div[1])[" + i + "]//input")).click();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        } else if (arg0.equalsIgnoreCase("Automatic Routing to Pipelines")) {
            if (getDriver().findElements(By.xpath("//div//div//div//div//div//div//div//div//div//div[4]//div[1]//input[1]")).size() != 0) {
                getDriver().findElement(By.xpath("//div//div//div//div//div//div//div//div//div//div[4]//div[1]//input[1]")).click();
            }
        }
    }

    @And("I fill in empty fields TC")
    public void iFillInEmptyFields() throws Throwable {
        WebElement FN = getDriver().findElement(By.xpath("//input[@id='asc-signup-firstname']"));
        String textInsideFN = FN.getAttribute("value");
        if (textInsideFN.isEmpty()) {
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='asc-signup-firstname']")));
            getDriver().findElement(By.xpath("//input[@id='asc-signup-firstname']")).sendKeys("Tessy");
        }
        WebElement LN = getDriver().findElement(By.xpath("//input[@id='asc-signup-lastname']"));
        String textInsideLN = LN.getAttribute("value");
        if (textInsideLN.isEmpty()) {
            getDriver().findElement(By.xpath("//input[@id='asc-signup-lastname']")).sendKeys("Mathew");
        }
        WebElement Email = getDriver().findElement(By.xpath("//input[@id='asc-signup-email2']"));
        String textInsideEmail = Email.getAttribute("value");
        email = textInsideEmail;
        if (textInsideEmail.isEmpty()) {
            final String randomEmail = randomEmail();
            getDriver().findElement(By.xpath("//input[@id='asc-signup-email2']")).sendKeys(randomEmail);
            if (getDriver().findElements(By.xpath("//input[@id='asc-signup-email1']")).size() != 0) {
                getDriver().findElement(By.xpath("//input[@id='asc-signup-email1']")).sendKeys(randomEmail);
            }
            getDriver().findElement(By.xpath("//input[@id='asc-signup-email2']")).click();
            email = randomEmail;
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

        if (getDriver().findElements(By.xpath("//input[@id='asc-signup-phonenumber']")).size() != 0) {
            getDriver().findElement(By.xpath("//input[@id='asc-signup-phonenumber']")).sendKeys(Keys.CONTROL, "a");
            getDriver().findElement(By.xpath("//input[@id='asc-signup-phonenumber']")).sendKeys(Keys.BACK_SPACE);
            getDriver().findElement(By.xpath("//input[@id='asc-signup-phonenumber']")).sendKeys("202-555-0184");
        }

        if (getDriver().findElements(By.xpath("//input[@id='asc-signup-address1']")).size() != 0) {
            WebElement Adrs = getDriver().findElement(By.xpath("//input[@id='asc-signup-address1']"));
            String textInsideAdrs = Adrs.getAttribute("value");
            if (textInsideAdrs.isEmpty()) {
                getDriver().findElement(By.xpath("//input[@id='asc-signup-address1']")).sendKeys("4144  Filbert Street");
            }
        }

        if (getDriver().findElements(By.xpath("//input[@id='asc-signup-city']")).size() != 0) {
            WebElement City = getDriver().findElement(By.xpath("//input[@id='asc-signup-city']"));
            String textInsideCity = City.getAttribute("value");
            if (textInsideCity.isEmpty()) {
                getDriver().findElement(By.xpath("//input[@id='asc-signup-city']")).sendKeys("WILDWOOD");
            }
        }

        if (getDriver().findElements(By.xpath("//input[@id='asc-signup-state']")).size() != 0) {
            WebElement State = getDriver().findElement(By.xpath("//input[@id='asc-signup-state']"));
            String textInsideState = State.getAttribute("value");
            if (textInsideState.isEmpty()) {
                getDriver().findElement(By.xpath("//input[@id='asc-signup-state']")).sendKeys("New Jersey");
            }
        }

        if (getDriver().findElements(By.xpath("//input[@id='asc-signup-postal_code']")).size() != 0) {
            WebElement zip = getDriver().findElement(By.xpath("//input[@id='asc-signup-postal_code']"));
            String textInsidezip = zip.getAttribute("value");
            if (textInsidezip.isEmpty()) {
                getDriver().findElement(By.xpath("//input[@id='asc-signup-postal_code']")).sendKeys("08260");
            }
        }

        if (getDriver().findElements(By.xpath("//input[@id='asc-signup-school']")).size() != 0) {
            WebElement Sch = getDriver().findElement(By.xpath("//input[@id='asc-signup-school']"));
            String textInsideSch = Sch.getAttribute("value");
            if (textInsideSch.isEmpty()) {
                getDriver().findElement(By.xpath("//input[@id='asc-signup-school']")).sendKeys("Bellevue University");
            }
        }

        try {
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='asc-signup-grad-year']")));
            WebElement Year = getDriver().findElement(By.xpath("//select[@id='asc-signup-grad-year']"));
            String textInsideYear = Year.getAttribute("value");
            if (textInsideYear.isEmpty()) {
                getDriver().findElement(By.xpath("//select[@id='asc-signup-grad-year']/option[contains(text(),'2000')]")).click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (getDriver().findElements(By.xpath("//input[@id='asc-signup-degree-type']")).size() != 0) {
            WebElement DT = getDriver().findElement(By.xpath("//input[@id='asc-signup-degree-type']"));
            String textInsideDT = DT.getAttribute("value");
            if (textInsideDT.isEmpty()) {
                getDriver().findElement(By.xpath("//input[@id='asc-signup-degree-type']")).sendKeys("Management Information Systems");
            }
        }

        if (getDriver().findElements(By.xpath("//input[@id='asc-signup-degree']")).size() != 0) {
            WebElement Deg = getDriver().findElement(By.xpath("//input[@id='asc-signup-degree']"));
            String textInsideDeg = Deg.getAttribute("value");
            if (textInsideDeg.isEmpty()) {
                getDriver().findElement(By.xpath("//input[@id='asc-signup-degree']")).sendKeys("MBA");
            }
        }

        if (getDriver().findElements(By.xpath("//input[@id='ct_sms']")).size() != 0) {
            try {
                getDriver().findElement(By.xpath("//input[@id='ct_sms']")).click();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (getDriver().findElements(By.xpath("//input[@name='ascendify[communication_preference][automated_sms_sys_msg]']")).size() != 0) {
            try {
                getDriver().findElement(By.xpath("//input[@name='ascendify[communication_preference][automated_sms_sys_msg]']")).click();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        if (getDriver().findElements(By.xpath("//a[@class='chosen-single chosen-default']")).size() != 0) {
            getDriver().findElement(By.xpath("//a[@class='chosen-single chosen-default']")).click();
            getDriver().findElement(By.xpath("//div[@class='chosen-search']//input")).sendKeys("abc", Keys.ENTER);
            Thread.sleep(3000);
        }

        if (getDriver().findElements(By.xpath("//select")).size() != 0) {
            int x = getDriver().findElements(By.xpath("//select")).size();
            for (int y = 1; y <= x; y++) {
                try {
                    getDriver().findElement(By.xpath("(//select)[" + y + "]")).click();
                    getDriver().findElement(By.xpath("((//select)[" + y + "]//option[2])[1]")).click();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (getDriver().findElements(By.xpath("//textarea[@id='asc-signup-blurb']")).size() != 0) {
                    getDriver().findElement(By.xpath("//textarea[@id='asc-signup-blurb']")).sendKeys("This is my headline.");
                }
            }
        }
    }

    @And("I fill in empty fields except Name TC")
    public void iFillInEmptyFieldsExceptNameTC() throws Throwable {
        WebElement Email = getDriver().findElement(By.xpath("//input[@id='asc-signup-email2']"));
        String textInsideEmail = Email.getAttribute("value");
        email = textInsideEmail;
        if (textInsideEmail.isEmpty()) {
            final String randomEmail = randomEmail();
            getDriver().findElement(By.xpath("//input[@id='asc-signup-email2']")).sendKeys(randomEmail);
            if (getDriver().findElements(By.xpath("//input[@id='asc-signup-email1']")).size() != 0) {
                getDriver().findElement(By.xpath("//input[@id='asc-signup-email1']")).sendKeys(randomEmail);
            }
            getDriver().findElement(By.xpath("//input[@id='asc-signup-email2']")).click();
            email = randomEmail;
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

        if (getDriver().findElements(By.xpath("//input[@id='asc-signup-phonenumber']")).size() != 0) {
            getDriver().findElement(By.xpath("//input[@id='asc-signup-phonenumber']")).sendKeys(Keys.CONTROL, "a");
            getDriver().findElement(By.xpath("//input[@id='asc-signup-phonenumber']")).sendKeys(Keys.BACK_SPACE);
            getDriver().findElement(By.xpath("//input[@id='asc-signup-phonenumber']")).sendKeys("202-555-0184");
        }

        if (getDriver().findElements(By.xpath("//input[@id='asc-signup-address1']")).size() != 0) {
            WebElement Adrs = getDriver().findElement(By.xpath("//input[@id='asc-signup-address1']"));
            String textInsideAdrs = Adrs.getAttribute("value");
            if (textInsideAdrs.isEmpty()) {
                getDriver().findElement(By.xpath("//input[@id='asc-signup-address1']")).sendKeys("4144  Filbert Street");
            }
        }

        if (getDriver().findElements(By.xpath("//input[@id='asc-signup-city']")).size() != 0) {
            WebElement City = getDriver().findElement(By.xpath("//input[@id='asc-signup-city']"));
            String textInsideCity = City.getAttribute("value");
            if (textInsideCity.isEmpty()) {
                getDriver().findElement(By.xpath("//input[@id='asc-signup-city']")).sendKeys("WILDWOOD");
            }
        }

        if (getDriver().findElements(By.xpath("//input[@id='asc-signup-state']")).size() != 0) {
            WebElement State = getDriver().findElement(By.xpath("//input[@id='asc-signup-state']"));
            String textInsideState = State.getAttribute("value");
            if (textInsideState.isEmpty()) {
                getDriver().findElement(By.xpath("//input[@id='asc-signup-state']")).sendKeys("New Jersey");
            }
        }

        if (getDriver().findElements(By.xpath("//input[@id='asc-signup-postal_code']")).size() != 0) {
            WebElement zip = getDriver().findElement(By.xpath("//input[@id='asc-signup-postal_code']"));
            String textInsidezip = zip.getAttribute("value");
            if (textInsidezip.isEmpty()) {
                getDriver().findElement(By.xpath("//input[@id='asc-signup-postal_code']")).sendKeys("08260");
            }
        }

        if (getDriver().findElements(By.xpath("//input[@id='asc-signup-school']")).size() != 0) {
            WebElement Sch = getDriver().findElement(By.xpath("//input[@id='asc-signup-school']"));
            String textInsideSch = Sch.getAttribute("value");
            if (textInsideSch.isEmpty()) {
                getDriver().findElement(By.xpath("//input[@id='asc-signup-school']")).sendKeys("Bellevue University");
            }
        }

        try {
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='asc-signup-grad-year']")));
            WebElement Year = getDriver().findElement(By.xpath("//select[@id='asc-signup-grad-year']"));
            String textInsideYear = Year.getAttribute("value");
            if (textInsideYear.isEmpty()) {
                getDriver().findElement(By.xpath("//select[@id='asc-signup-grad-year']/option[contains(text(),'2000')]")).click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (getDriver().findElements(By.xpath("//input[@id='asc-signup-degree-type']")).size() != 0) {
            WebElement DT = getDriver().findElement(By.xpath("//input[@id='asc-signup-degree-type']"));
            String textInsideDT = DT.getAttribute("value");
            if (textInsideDT.isEmpty()) {
                getDriver().findElement(By.xpath("//input[@id='asc-signup-degree-type']")).sendKeys("Management Information Systems");
            }
        }

        if (getDriver().findElements(By.xpath("//input[@id='asc-signup-degree']")).size() != 0) {
            WebElement Deg = getDriver().findElement(By.xpath("//input[@id='asc-signup-degree']"));
            String textInsideDeg = Deg.getAttribute("value");
            if (textInsideDeg.isEmpty()) {
                getDriver().findElement(By.xpath("//input[@id='asc-signup-degree']")).sendKeys("MBA");
            }
        }

        if (getDriver().findElements(By.xpath("//input[@id='ct_sms']")).size() != 0) {
            try {
                getDriver().findElement(By.xpath("//input[@id='ct_sms']")).click();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (getDriver().findElements(By.xpath("//input[@name='ascendify[communication_preference][automated_sms_sys_msg]']")).size() != 0) {
            try {
                getDriver().findElement(By.xpath("//input[@name='ascendify[communication_preference][automated_sms_sys_msg]']")).click();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        if (getDriver().findElements(By.xpath("//a[@class='chosen-single chosen-default']")).size() != 0) {
            getDriver().findElement(By.xpath("//a[@class='chosen-single chosen-default']")).click();
            getDriver().findElement(By.xpath("//div[@class='chosen-search']//input")).sendKeys("abc", Keys.ENTER);
            Thread.sleep(3000);
        }

        if (getDriver().findElements(By.xpath("//select")).size() != 0) {
            int x = getDriver().findElements(By.xpath("//select")).size();
            for (int y = 1; y <= x; y++) {
                try {
                    getDriver().findElement(By.xpath("(//select)[" + y + "]")).click();
                    getDriver().findElement(By.xpath("((//select)[" + y + "]//option[2])[1]")).click();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (getDriver().findElements(By.xpath("//textarea[@id='asc-signup-blurb']")).size() != 0) {
                    getDriver().findElement(By.xpath("//textarea[@id='asc-signup-blurb']")).sendKeys("This is my headline.");
                }
            }
        }
    }

    @And("I type {string} as {string} TC")
    public void iType(String arg0, String arg1) throws Throwable {
        if (arg0.equalsIgnoreCase("Degree Type")) {
            getDriver().findElement(By.xpath("//input[@id='asc-signup-degree-type']")).sendKeys(arg1);
        } else if (arg0.equalsIgnoreCase("Degree")) {
            getDriver().findElement(By.xpath("//input[@id='asc-signup-degree']")).sendKeys(arg1);
        }
    }

    @And("I type password {string} on {string} page TC")
    public void iTypePasswordOnPage(String arg0, String arg1) throws Throwable {
        if (arg1.equalsIgnoreCase("Sign Up")) {
            Thread.sleep(2000);
            getDriver().findElement(By.xpath("//input[@id='password1']")).sendKeys(arg0);
            getDriver().findElement(By.xpath("//input[@id='password2']")).sendKeys(arg0);
        }
    }

    @And("I click and agree to Privacy Policy TC")
    public void iClickAndAgreeToPrivacyPolicy() throws Throwable {
        if (getDriver().findElements(By.xpath("//ul[contains(@class,'chosen-choices')]")).size() != 0) {
            int a = getDriver().findElements(By.xpath("//ul[contains(@class,'chosen-choices')]")).size();
            for (int b = 1; b <= a; b++) {
                Thread.sleep(2000);
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[contains(@class,'chosen-choices')])[" + b + "]")));
                getDriver().findElement(By.xpath("(//ul[contains(@class,'chosen-choices')])[" + b + "]")).click();
                getDriver().findElement(By.xpath("(//ul[contains(@class,'chosen-choices')])[" + b + "]/..//ul[contains(@class,'chosen-results')]//li[2]")).click();
            }
        }

        if (getDriver().findElements(By.xpath("//a[contains(@class,'chosen-single chosen-default')]")).size() != 0) {
            int x = getDriver().findElements(By.xpath("//a[contains(@class,'chosen-single chosen-default')]")).size();
            for (int y = 1; y <= x; y++) {
                Thread.sleep(2000);
                try {
                    getDriver().findElement(By.xpath("(//a[contains(@class,'chosen-single chosen-default')])[" + y + "]")).click();
                    new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='chosen-drop'])[" + y + "]")));
                    getDriver().findElement(By.xpath("(//div[@class='chosen-drop'])[" + y + "]//ul//li[2]")).click();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        if (getDriver().findElements(By.xpath("//div[@class='asc-survey-question-group asc-dynamic-picklist']")).size() != 0) {
            int i = getDriver().findElements(By.xpath("//div[@class='asc-survey-question-group asc-dynamic-picklist']")).size();
            for (int j = 1; j <= i; j++) {
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//div[@class='asc-survey-question-group asc-dynamic-picklist'])[" + j + "]//input[@class='asc-survey-question-answer-radio__input '])[1]")));
                getDriver().findElement(By.xpath("((//div[@class='asc-survey-question-group asc-dynamic-picklist'])[" + j + "]//input[@class='asc-survey-question-answer-radio__input '])[1]")).click();
            }
        }

        if (getDriver().findElements(By.xpath("//input[contains(@id,'asc-question-csvq')][@type='text']")).size() != 0) {
            int u = getDriver().findElements(By.xpath("//input[contains(@id,'asc-question-csvq')][@type='text']")).size();
            for (int v = 1; v <= u; v++) {
                String uuid = UUID.randomUUID().toString();
                getDriver().findElement(By.xpath("(//input[contains(@id,'asc-question-csvq')][@type='text'])[" + v + "]")).sendKeys(uuid);
            }
        }

        if (getDriver().findElements(By.xpath("//input[@id='asc-signup-disclosure-ck']")).size() != 0) {
            getDriver().findElement(By.xpath("//input[@id='asc-signup-disclosure-ck']")).click();
        }
        Thread.sleep(2000);
    }

    @When("I click on {string} button on {string} page TC")
    public void iClickOnButtonOnPage(String arg0, String arg1) throws Throwable {
        if (arg1.equalsIgnoreCase("Home")) {
            getDriver().findElement(By.xpath("//a[@id='menu_sign_in']")).click();
        } else if (arg1.equalsIgnoreCase("Sign In")) {
            getDriver().findElement(By.xpath("//button[@id='asc-signin-btn']")).click();
            Thread.sleep(2000);
            Thread.sleep(2000);
        } else if (arg1.equalsIgnoreCase("LinkedIn Sign In")) {
            getDriver().findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
        } else if (arg1.equalsIgnoreCase("LinkedIn 2nd Sign In")) {
            getDriver().findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search']")));
        } else if (arg1.equalsIgnoreCase("BrowserStack")) {
            getDriver().findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
        }
    }

    @And("I search for {string} in search box TC")
    public void iSearchForInSearchBox(String arg0) throws Throwable {
        getDriver().findElement(By.xpath("//input[@id='asc-map-primary-search']")).click();
        getDriver().findElement(By.xpath("//input[@id='asc-map-primary-search']")).sendKeys(arg0);
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']")));
        getDriver().findElement(By.xpath("//i[@class='header-search-action-btn fa fa-search header-icon highlight-bg fa fa-search']")).click();
        Thread.sleep(2000);
    }

    @And("I make sure I haven't applied to that job already TC")
    public void iMakeSureIHavenTAppliedToThatJobAlready() throws Throwable {
        if (getDriver().findElements(By.xpath("//a[contains(text(),'Tessy QA')]/../../..//a[@class='asc-withdraw pull-right link']")).size() != 0) {
            int retry = 0;
            while (getDriver().findElements(By.xpath("//a[contains(text(),'Tessy QA')]/../../..//a[@class='asc-withdraw pull-right link']")).size() != 0) {
                getDriver().findElement(By.xpath("//a[contains(text(),'Tessy QA')]/../../..//a[@class='asc-withdraw pull-right link']")).click();
                Thread.sleep(4000);
                if (retry > 10) {
                    System.out.println("Withdraw link is not working");
                    break;
                }
                retry++;
            }
        }
        getDriver().navigate().refresh();
        getDriver().findElement(By.xpath("//li[@id='tab-profile-dashboard']")).click();
        try {
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Tessy QA')]/../../..//a[@class='asc-withdraw pull-right link']")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("I sign to confirm TC")
    public void iSignToConfirm() {
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
    }

    @Then("success message is displayed TC")
    public void successMessageIsDisplayed() throws Throwable {
        new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'You have successfully submitted your information')]")));
        getDriver().findElement(By.xpath("//li[contains(text(),'You have successfully submitted your information')]")).isDisplayed();
    }

    @And("I choose my file to be uploaded by clicking {string} button TC")
    public void iChooseMyFileToBeUploadedByClickingButton(String arg0) throws AWTException, Throwable, InterruptedException {
        if (arg0.equalsIgnoreCase("Upload Your Resume")) {
            Actions actions = new Actions(getDriver());
            actions.moveToElement(getDriver().findElement(By.id("asc-alt-upload-resume")));
            URL resumeUrl = getClass().getClassLoader().getResource("resumes/Profile.pdf");
            if (resumeUrl != null) {
                File resumeFile = new File(resumeUrl.getFile());
                getDriver().findElement(By.xpath("//input[@name='asc_resume']")).sendKeys(resumeFile.getAbsolutePath());
                Thread.sleep(2000);
            } else {
                throw new Exception("Failed to find resume absolute path");
            }
        } else if (arg0.equalsIgnoreCase("Google Drive")) {
            String handle = getDriver().getWindowHandle();
            System.out.println(handle);
            getDriver().findElement(By.xpath("//img[@class='social-icons-image']")).click();
            Set handles = getDriver().getWindowHandles();
            System.out.println(handles);

            for (String handle1 : getDriver().getWindowHandles()) {
                System.out.println(handle1);
                getDriver().switchTo().window(handle1);
            }

            try {
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Email']")));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (getDriver().findElements(By.xpath("//input[@id='Email']")).size() != 0) {
                getDriver().findElement(By.xpath("//input[@id='Email']")).sendKeys("ascendifyautomation@gmail.com");
                getDriver().findElement(By.xpath("//input[@id='next']")).click();
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
                getDriver().findElement(By.xpath("//input[@type='password']")).sendKeys("Ascendify246!");
                getDriver().findElement(By.xpath("//input[@type='submit']")).click();
            } else if (getDriver().findElements(By.xpath("//input[@id='identifierId']")).size() != 0) {
                getDriver().findElement(By.xpath("//input[@id='identifierId']")).sendKeys("ascendifyautomation@gmail.com");
                getDriver().findElement(By.xpath("//div[@id='identifierNext']")).click();
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
                getDriver().findElement(By.xpath("//input[@type='password']")).sendKeys("Ascendify246!");
                getDriver().findElement(By.xpath("//div[@id='passwordNext']")).click();
            }

            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@class='picker-frame picker-dialog-frame']")));
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text']")));
            getDriver().findElement(By.xpath("//input[@type='text']")).sendKeys("Resume");
            Thread.sleep(4000);
            getDriver().findElement(By.xpath("//span[contains(text(),'Resume')]")).click();
            getDriver().findElement(By.xpath("//div[@role='button'][contains(text(),'Select')]")).click();
            getDriver().switchTo().window(handle);
        } else if (arg0.equalsIgnoreCase("Dropbox")) {
            String handle = getDriver().getWindowHandle();
            System.out.println(handle);
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@id='dropbox-frame']")));
            getDriver().findElement(By.xpath("//iframe[@id='dropbox-frame']")).click();
            Set handles = getDriver().getWindowHandles();
            System.out.println(handles);

            for (String handle1 : getDriver().getWindowHandles()) {
                System.out.println(handle1);
                getDriver().switchTo().window(handle1);
            }

            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Sign in with Google')]")));
            getDriver().findElement(By.xpath("//div[contains(text(),'Sign in with Google')]")).click();

            try {
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Email']")));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (getDriver().findElements(By.xpath("//input[@id='Email']")).size() != 0) {
                getDriver().findElement(By.xpath("//input[@id='Email']")).sendKeys("ascendifyautomation@gmail.com");
                getDriver().findElement(By.xpath("//input[@id='next']")).click();
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
                getDriver().findElement(By.xpath("//input[@type='password']")).sendKeys("Ascendify246!");
                getDriver().findElement(By.xpath("//input[@type='submit']")).click();
            } else if (getDriver().findElements(By.xpath("//input[@id='identifierId']")).size() != 0) {
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='identifierId']")));
                getDriver().findElement(By.xpath("//input[@id='identifierId']")).sendKeys("ascendifyautomation@gmail.com");
                getDriver().findElement(By.xpath("//span[contains(text(),'Next')]")).click();
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
                getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys("Ascendify246!");
                getDriver().findElement(By.xpath("//span[contains(text(),'Next')]")).click();
            }
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Profile')]/../../../../../../..//input[@type='checkbox']")));
            Thread.sleep(2000);
            getDriver().findElement(By.xpath("//span[contains(text(),'Profile')]")).click();
            getDriver().findElement(By.xpath("//span[contains(text(),'Choose')]")).click();
            getDriver().switchTo().window(handle);
        } else if (arg0.equalsIgnoreCase("OneDrive")) {
            String handle = getDriver().getWindowHandle();
            System.out.println(handle);
            getDriver().findElement(By.xpath("//iframe[@id='onedrive-frame']")).click();
            Set handles = getDriver().getWindowHandles();
            System.out.println(handles);

            for (String handle1 : getDriver().getWindowHandles()) {
                System.out.println(handle1);
                getDriver().switchTo().window(handle1);
            }

            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
            getDriver().findElement(By.xpath("//input[@type='email']")).sendKeys("ascendifyautomation@gmail.com");
            getDriver().findElement(By.xpath("//input[@id='idSIButton9']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='passwd']")));
            getDriver().findElement(By.xpath("//input[@name='passwd']")).sendKeys("Ascendify246!");
            getDriver().findElement(By.xpath("//input[@type='submit']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Profile.pdf')]")));
            getDriver().findElement(By.xpath("//span[contains(text(),'Profile.pdf')]/../../../../../..//span[@role='checkbox']")).click();
            getDriver().findElement(By.xpath("//span[contains(text(),'Open')]")).click();
            Thread.sleep(2000);
            try {
                while (getDriver().findElement(By.xpath("//span[contains(text(),'Open')]")).isDisplayed()) {
                    getDriver().findElement(By.xpath("//span[contains(text(),'Open')]")).click();
                    Thread.sleep(2000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            getDriver().switchTo().window(handle);
        }
    }

    @And("I click on {string} tab TC")
    public void iClickOnTab(String arg0) {
        if (arg0.equalsIgnoreCase("Profile")) {
            getDriver().findElement(By.xpath("//li[@id='tab-profile']")).click();
        } else if (arg0.equalsIgnoreCase("Personal Info")) {
            getDriver().navigate().refresh();
            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
            jse.executeScript("window.scrollBy(0,-540)");
            getDriver().findElement(By.xpath("//li[@id='tab-personal']")).click();
        }
    }

    @And("I make sure my opportunities are visible in Dashboard TC")
    public void iMakeSureMyOpportunitiesAreVisibleInDashboard() throws Throwable {
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='asc-main-user-menu']")));
        getDriver().findElement(By.xpath("//a[@id='asc-main-user-menu']")).click();
        getDriver().findElement(By.xpath("//a[@class='asc-settings-link-a']")).click();
        try {
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Tessy QA')]/../../..//a[@class='asc-withdraw pull-right link']")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (getDriver().findElements(By.xpath("//a[contains(text(),'Tessy QA')]/../../..//a[@class='asc-withdraw pull-right link']")).size() == 0) {
            getDriver().findElement(By.xpath("//a[contains(text(),'Search Careers')]")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='asc-map-primary-search']")));
            getDriver().findElement(By.xpath("//input[@id='asc-map-primary-search']")).sendKeys("Tessy QA");
            getDriver().findElement(By.xpath("//i[@class='header-search-action-btn fa fa-search header-icon highlight-bg fa fa-search']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='asc-job-left-activate highlight'][text()='Tessy QA']")));
            getDriver().findElement(By.xpath("//a[@class='asc-job-left-activate highlight'][text()='Tessy QA']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='asc-job-apply-btn']")));
            getDriver().findElement(By.xpath("//button[@id='asc-job-apply-btn']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Submit Application')]")));
            if (getDriver().findElements(By.xpath("//a[@class='chosen-single chosen-default']")).size() != 0) {
                getDriver().findElement(By.xpath("//a[@class='chosen-single chosen-default']")).click();
                getDriver().findElement(By.xpath("//div[@class='chosen-drop']//ul//li[2]")).click();
            }
            if (getDriver().findElements(By.xpath("//input[@id='asc-signup-disclosure-ck']")).size() != 0) {
                getDriver().findElement(By.xpath("//input[@id='asc-signup-disclosure-ck']")).click();
            }
            Thread.sleep(2000);
            if (getDriver().findElements(By.xpath("//button[@id='asc-job-application-survey-btn']")).size() != 0) {
                getDriver().findElement(By.xpath("//button[@id='asc-job-application-survey-btn']")).click();
            }
            if (getDriver().findElements(By.xpath("//button[@id='asc-job-apply-confirm-btn']")).size() != 0) {
                getDriver().findElement(By.xpath("//button[@id='asc-job-apply-confirm-btn']")).click();
            }
            new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'You have successfully submitted your information')]")));
            getDriver().findElement(By.xpath("//li[contains(text(),'You have successfully submitted your information')]")).isDisplayed();
            getDriver().findElement(By.xpath("//a[@id='asc-main-user-menu']")).click();
            getDriver().findElement(By.xpath("//a[@class='asc-settings-link-a']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Tessy QA')]/../../..//a[@class='asc-withdraw pull-right link']")));
        }
    }

    @And("I add {string} info TC")
    public void iAdd(String arg0) throws Throwable {

        if (arg0.equalsIgnoreCase("Profile")) {
            getDriver().findElement(By.xpath("//li[@id='tab-profile']")).click();

            if (getDriver().findElements(By.xpath("//div[@id='asc-profile-skills-holder']")).size() != 0) {
                try {
                    while (getDriver().findElement(By.xpath("//div[@id='asc-profile']//div[contains(text(),'Java')]/..//div/..//i")).isDisplayed()) {
                        getDriver().findElement(By.xpath("//div[@id='asc-profile']//div[contains(text(),'Java')]/..//div/..//i")).click();
                        Thread.sleep(2000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            int retry = 0;
            while (getDriver().findElements(By.xpath("//button[contains(text(),'Remove')]")).size() != 0) {
                try {
                    getDriver().findElement(By.xpath("//button[contains(text(),'Remove')]")).click();
                    Thread.sleep(4000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (retry > 26) {
                    break;
                }
                retry++;
            }

            getDriver().navigate().refresh();
            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
            jse.executeScript("window.scrollBy(0,-250)");
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='tab-profile']")));
            getDriver().findElement(By.xpath("//li[@id='tab-profile']")).click();

            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='asc-objective']//button[contains(text(),'Add')]")));
            Thread.sleep(2000);
            getDriver().findElement(By.xpath("//div[@id='asc-objective']//button[contains(text(),'Add')]")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='asc-objective']//textarea[@id='asc_blurb']")));
            getDriver().findElement(By.xpath("//div[@id='asc-objective']//textarea[@id='asc_blurb']")).sendKeys("Seeking a challenging career with an MNC.");
            getDriver().findElement(By.xpath("//button[@id='asc-dynamic-save-button']")).click();

            if (getDriver().findElements(By.xpath("//input[@id='asc-profile-skills-text']")).size() != 0) {
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='asc-profile-skills-text']")));
                getDriver().findElement(By.xpath("//input[@id='asc-profile-skills-text']")).sendKeys("Java");
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']//li[1]")));
                getDriver().findElement(By.xpath("//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']//li[1]")).click();
            }

            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='asc-summary']//button[contains(text(),'Add')]")));
            Thread.sleep(2000);
            getDriver().findElement(By.xpath("//div[@id='asc-summary']//button[contains(text(),'Add')]")).click();
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

            //            try {
            getDriver().findElement(By.xpath("//button[@id='asc-add-educ']")).click();
            getDriver().findElement(By.xpath("//input[@id='asc-school']")).sendKeys("Mount Bethany");
            getDriver().findElement(By.xpath("//form[@id='asc-add-educations-form']//input[@placeholder='Location']")).sendKeys("India");
            getDriver().findElement(By.xpath("//input[@placeholder='Degree Type']")).sendKeys("Masters");
            getDriver().findElement(By.xpath("//input[@id='asc-degree']")).sendKeys("M.Tech");
            getDriver().findElement(By.xpath("//div[@class='clearfix asc-education-dates']//select[@name='ascendify[month]']/option[contains(text(),'Jun')]")).click();
            getDriver().findElement(By.xpath("//div[@class='clearfix asc-education-dates']//div//select[@name='ascendify[year]']/option[contains(text(),'2011')]")).click();
            getDriver().findElement(By.xpath("//form[@id='asc-add-educations-form']//textarea[@id='asc-detail']")).sendKeys("GPA: 3.6/4.0", Keys.ENTER, "Intro to Graphic Design, AP Art, Yearbook, Computer Applications", Keys.ENTER, "Member of the National Honors Society and National Art Education Association");
            getDriver().findElement(By.xpath("//button[@id='asc-add-educations-btn']")).click();

            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='asc-add-cert']")));
            getDriver().findElement(By.xpath("//button[@id='asc-add-cert']")).click();
            if (getDriver().findElement(By.xpath("//form[@id='asc-add-certifications-form']")).isDisplayed() == false) {
                getDriver().findElement(By.xpath("//button[@id='asc-add-cert']")).click();
            }
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='asc-add-certifications-form']//input[@id='asc-title']")));
            getDriver().findElement(By.xpath("//form[@id='asc-add-certifications-form']//input[@id='asc-title']")).sendKeys("ASTQB Expert Level Test Manager – Managing the Test Team");
            getDriver().findElement(By.xpath("//div[@class='clearfix asc-cert-dates']//div//select[@name='ascendify[start_month]']/option[contains(text(),'Jan')]")).click();
            getDriver().findElement(By.xpath("//div[@class='clearfix asc-cert-dates']//div//select[@name='ascendify[start_year]']/option[contains(text(),'2020')]")).click();
            getDriver().findElement(By.xpath("//input[@name='ascendify[still_valid]']")).click();
            getDriver().findElement(By.xpath("//form[@id='asc-add-certifications-form']//textarea[@id='asc-detail']")).sendKeys("The certification process helped me grow tremendously as a software tester, which led to my current position as a Product Manager.");
            getDriver().findElement(By.xpath("//button[@id='asc-add-certifications-btn']")).click();
            try {
                if (getDriver().findElement(By.xpath("//div[@class='clearfix asc-cert-dates']//div//select[@name='ascendify[start_month]']")).isDisplayed() == false) {
                    getDriver().findElement(By.xpath("//button[@id='asc-add-cert']")).click();
                }
                getDriver().findElement(By.xpath("//div[@class='clearfix asc-cert-dates']//div//select[@name='ascendify[start_month]']")).click();
                while (getDriver().findElement(By.xpath("//div[@class='clearfix asc-cert-dates']//div//select[@name='ascendify[start_month]']/option[contains(text(),'Mar')]")).isDisplayed() == false) {
                    getDriver().findElement(By.xpath("//div[@class='clearfix asc-cert-dates']//div//select[@name='ascendify[start_month]']")).click();
                    Thread.sleep(2000);
                }
                getDriver().findElement(By.xpath("//div[@class='clearfix asc-cert-dates']//div//select[@name='ascendify[start_month]']/option[contains(text(),'Mar')]")).click();
                getDriver().findElement(By.xpath("//div[@class='clearfix asc-cert-dates']//div//select[@name='ascendify[start_year]']/option[contains(text(),'2018')]")).click();
            } catch (Exception e) {
                e.printStackTrace();
            }

            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='asc-add-awd']")));
            getDriver().findElement(By.xpath("//button[@id='asc-add-awd']")).click();
            if (getDriver().findElement(By.xpath("//form[@id='asc-add-awards-form']")).isDisplayed() == false) {
                getDriver().findElement(By.xpath("//button[@id='asc-add-awd']")).click();
            }
            getDriver().findElement(By.xpath("//form[@id='asc-add-awards-form']//input[@id='asc-title']")).click();
            getDriver().findElement(By.xpath("//form[@id='asc-add-awards-form']//input[@id='asc-title']")).sendKeys("National Merit Award");
            getDriver().findElement(By.xpath("//div[@class='clearfix asc-awards-dates']//div//select[@name='ascendify[month]']")).click();
            getDriver().findElement(By.xpath("//div[@class='clearfix asc-awards-dates']//div//select[@name='ascendify[month]']/option[contains(text(),'Jul')]")).click();
            getDriver().findElement(By.xpath("//div[@class='clearfix asc-awards-dates']//div//select[@name='ascendify[year]']")).click();
            getDriver().findElement(By.xpath("//div[@class='clearfix asc-awards-dates']//div//select[@name='ascendify[year]']/option[contains(text(),'2019')]")).click();
            getDriver().findElement(By.xpath("//form[@id='asc-add-awards-form']//textarea[@id='asc-detail']")).sendKeys("Awarded first place in national competition with over 10,000 participants.");
            getDriver().findElement(By.xpath("//button[@id='asc-add-awards-btn']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='asc-award-remove asc-remove-item btn btn-sm btn-danger']")));

            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='asc-add-mbr']")));
            getDriver().findElement(By.xpath("//button[@id='asc-add-mbr']")).click();
            if (getDriver().findElement(By.xpath("//form[@id='asc-add-memberships-form']")).isDisplayed() == false) {
                getDriver().findElement(By.xpath("//button[@id='asc-add-mbr']")).click();
            }
            getDriver().findElement(By.xpath("//form[@id='asc-add-memberships-form']//input[@id='asc-title']")).sendKeys("National Association of Sales Professionals");
            getDriver().findElement(By.xpath("//div[@class='clearfix asc-memberships-dates']//div//select[@name='ascendify[start_month]']/option[contains(text(),'Apr')]")).click();
            getDriver().findElement(By.xpath("//div[@class='clearfix asc-memberships-dates']//div//select[@name='ascendify[start_year]']/option[contains(text(),'2015')]")).click();
            getDriver().findElement(By.xpath("//div[@id='asc-membership-enddate']//div//select[@name='ascendify[end_month]']/option[contains(text(),'May')]")).click();
            getDriver().findElement(By.xpath("//div[@id='asc-membership-enddate']//div//select[@name='ascendify[end_year]']/option[contains(text(),'2017')]")).click();
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
            } catch (Exception e) {
                e.printStackTrace();
            }

            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='asc-add-trn']")));
            getDriver().findElement(By.xpath("//button[@id='asc-add-trn']")).click();
            if (getDriver().findElement(By.xpath("//form[@id='asc-add-trainings-form']")).isDisplayed() == false) {
                getDriver().findElement(By.xpath("//button[@id='asc-add-trn']")).click();
            }
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='asc-add-trainings-form']//input[@id='asc-title']")));
            getDriver().findElement(By.xpath("//form[@id='asc-add-trainings-form']//input[@id='asc-title']")).sendKeys("Customer service and relationship building");
            getDriver().findElement(By.xpath("//div[@class='clearfix asc-trainings-dates']//div//select[@name='ascendify[start_month]']/option[contains(text(),'Aug')]")).click();
            getDriver().findElement(By.xpath("//div[@class='clearfix asc-trainings-dates']//div//select[@name='ascendify[start_year]']/option[contains(text(),'2013')]")).click();
            getDriver().findElement(By.xpath("//form[@id='asc-add-trainings-form']//textarea[@id='asc-detail']")).sendKeys("Senior training professionals partnering with top leadership on workforce development and skill-up strategies.");
            getDriver().findElement(By.xpath("//button[@id='asc-add-trainings-btn']")).click();

            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='asc-abilities']")));
            getDriver().findElement(By.xpath("//div[@id='asc-abilities']")).click();
            getDriver().findElement(By.xpath("//div[@id='asc-abilities']//textarea[@id='asc_blurb']")).sendKeys("Communication", Keys.ENTER, "Teamwork", Keys.ENTER, "Adaptability", Keys.ENTER, "Problem Solving", Keys.ENTER, "Creativity");
            getDriver().findElement(By.xpath("//button[@id='asc-dynamic-save-button']")).click();

            try {
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='asc-additional']//button[contains(text(),'Add')]")));
                getDriver().findElement(By.xpath("//div[@id='asc-additional']//button[contains(text(),'Add')]")).click();
                getDriver().findElement(By.xpath("//div[@id='asc-additional']//textarea[@id='asc_blurb']")).sendKeys("Exceptional familiarity with organization management principles");
                getDriver().findElement(By.xpath("//div[@id='asc-additional']//button[@id='asc-dynamic-save-button']")).click();
            } catch (Exception e) {
                e.printStackTrace();
            }

            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='asc-volunteer']")));
            getDriver().findElement(By.xpath("//div[@id='asc-volunteer']")).click();
            getDriver().findElement(By.xpath("//div[@id='asc-volunteer']//textarea[@id='asc_blurb']")).sendKeys("Highly committed and dedicated Church Volunteer with a strong spiritual service record and an extraordinary work ethic.");
            getDriver().findElement(By.xpath("//button[@id='asc-dynamic-save-button']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='asc-volunteer']//button[@class='asc-blob-remove asc-remove-item btn btn-sm btn-plain btn-danger'][contains(text(),'Remove')]")));
        } else if (arg0.equalsIgnoreCase("Personal")) {
            getDriver().navigate().refresh();
            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
            jse.executeScript("window.scrollBy(0,-540)");
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='tab-personal']")));
            getDriver().findElement(By.xpath("//li[@id='tab-personal']")).click();

            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//h4[contains(text(),'Headline')]")));
            getDriver().findElement(By.xpath("//h4[contains(text(),'Headline')]")).click();
            getDriver().findElement(By.xpath("//textarea[@id='asc-blurb']")).sendKeys(Keys.CONTROL, "a", Keys.DELETE);
            getDriver().findElement(By.xpath("//textarea[@id='asc-blurb']")).sendKeys("Award-Winning Editor Skilled in Web Design.");
            getDriver().findElement(By.xpath("//button[@id='asc-dynamic-save-button']")).click();

            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//h4[contains(text(),'Contact Data')]")));
            getDriver().findElement(By.xpath("//h4[contains(text(),'Contact Data')]")).click();
            getDriver().findElement(By.xpath("//input[@id='asc-firstname']")).sendKeys(Keys.CONTROL, "a", Keys.DELETE);
            getDriver().findElement(By.xpath("//input[@id='asc-firstname']")).sendKeys("Tessy");
            getDriver().findElement(By.xpath("//input[@id='asc-lastname']")).sendKeys(Keys.CONTROL, "a", Keys.DELETE);
            getDriver().findElement(By.xpath("//input[@id='asc-lastname']")).sendKeys("Mathew");
            getDriver().findElement(By.xpath("//input[@id='asc-email']")).sendKeys(Keys.CONTROL, "a", Keys.DELETE);
            getDriver().findElement(By.xpath("//input[@id='asc-email']")).sendKeys("tessy@gmail.com");
            getDriver().findElement(By.xpath("//input[@id='asc-cellphone']")).sendKeys(Keys.CONTROL, "a", Keys.DELETE);
            getDriver().findElement(By.xpath("//input[@id='asc-cellphone']")).sendKeys("610-852-8288");
            getDriver().findElement(By.xpath("//input[@id='asc-phone']")).sendKeys(Keys.CONTROL, "a", Keys.DELETE);
            getDriver().findElement(By.xpath("//input[@id='asc-phone']")).sendKeys("609-602-2709");
            getDriver().findElement(By.xpath("//input[@id='user-address1']")).sendKeys(Keys.CONTROL, "a", Keys.DELETE);
            getDriver().findElement(By.xpath("//input[@id='user-address1']")).sendKeys("4144  Filbert Street");
            getDriver().findElement(By.xpath("//input[@id='user-address2']")).sendKeys(Keys.CONTROL, "a", Keys.DELETE);
            getDriver().findElement(By.xpath("//input[@id='user-address2']")).sendKeys("2553  Richison Drive");
            getDriver().findElement(By.xpath("//input[@id='user-city']")).sendKeys(Keys.CONTROL, "a", Keys.DELETE);
            getDriver().findElement(By.xpath("//input[@id='user-city']")).sendKeys("WILDWOOD");
            getDriver().findElement(By.xpath("//input[@id='user-state']")).sendKeys(Keys.CONTROL, "a", Keys.DELETE);
            getDriver().findElement(By.xpath("//input[@id='user-state']")).sendKeys("New Jersey");
            getDriver().findElement(By.xpath("//input[@id='user-zipcode']")).sendKeys(Keys.CONTROL, "a", Keys.DELETE);
            getDriver().findElement(By.xpath("//input[@id='user-zipcode']")).sendKeys("08260");
            getDriver().findElement(By.xpath("//div[@id='asc_personal_country_chosen']")).click();
            getDriver().findElement(By.xpath("//div[@id='asc_personal_country_chosen']//input")).sendKeys("United States of America");
            getDriver().findElement(By.xpath("//input[@id='asc-site-site_linkedin']")).sendKeys(Keys.CONTROL, "a", Keys.DELETE);
            getDriver().findElement(By.xpath("//input[@id='asc-site-site_linkedin']")).sendKeys("https://www.linkedin.com/in/tessy-anicattu-mathew-4b407119a/");
            getDriver().findElement(By.xpath("//button[@id='asc-dynamic-save-button']")).click();
            Thread.sleep(2000);

            if (getDriver().findElements(By.xpath("//h4[contains(text(),'Profile Information')]")).size() != 0) {
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//h4[contains(text(),'Profile Information')]")));
                getDriver().findElement(By.xpath("//div[@id='asc-user-custom-data']")).click();

                if (getDriver().findElements(By.xpath("//h4[contains(text(),'Profile Information')]/../..//div[contains(@id,'asc_question_csvq')]")).size() != 0) {
                    int x = getDriver().findElements(By.xpath("//h4[contains(text(),'Profile Information')]/../..//div[contains(@id,'asc_question_csvq')]")).size();
                    for (int y = 1; y <= x; y++) {
                        try {
                            getDriver().findElement(By.xpath("(//h4[contains(text(),'Profile Information')]/../..//div[contains(@id,'asc_question_csvq')])[" + y + "]")).click();
                            getDriver().findElement(By.xpath("(//h4[contains(text(),'Profile Information')]/../..//div[contains(@id,'asc_question_csvq')])[" + y + "]/..//option[2]")).click();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

                if (getDriver().findElements(By.xpath("//h4[contains(text(),'Profile Information')]/../..//div[contains(@id,'asc_question_csvq')]")).size() != 0) {
                    int x = getDriver().findElements(By.xpath("//h4[contains(text(),'Profile Information')]/../..//div[contains(@id,'asc_question_csvq')]")).size();
                    for (int y = 1; y <= x; y++) {
                        try {
                            getDriver().findElement(By.xpath("(//h4[contains(text(),'Profile Information')]/../..//div[contains(@id,'asc_question_csvq')])[" + y + "]")).click();
                            getDriver().findElement(By.xpath("(//h4[contains(text(),'Profile Information')]/../..//div[contains(@id,'asc_question_csvq')])[" + y + "]//ul[@class='chosen-results']//li[2]")).click();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

                if (getDriver().findElements(By.xpath("//div[@id='asc-user-custom-data']//input[contains(@id,'asc-question-csvq')][@type='text']")).size() != 0) {
                    int x = getDriver().findElements(By.xpath("//div[@id='asc-user-custom-data']//input[contains(@id,'asc-question-csvq')][@type='text']")).size();
                    for (int y = 1; y <= x; y++) {
                        try {
                            String uuid = UUID.randomUUID().toString();
                            getDriver().findElement(By.xpath("(//div[@id='asc-user-custom-data']//input[contains(@id,'asc-question-csvq')][@type='text'])[" + y + "]")).sendKeys(Keys.CONTROL, "a");
                            getDriver().findElement(By.xpath("(//div[@id='asc-user-custom-data']//input[contains(@id,'asc-question-csvq')][@type='text'])[" + y + "]")).sendKeys(Keys.BACK_SPACE, uuid);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

                if (getDriver().findElements(By.xpath("//div[@class='asc-survey-question-group asc-dynamic-picklist']//div[@class='asc-survey-question-answer-radio']//input[1]/../..//div[1]//input[1]")).size() != 0) {
                    int y = getDriver().findElements(By.xpath("//div[@class='asc-survey-question-group asc-dynamic-picklist']//div[@class='asc-survey-question-answer-radio']//input[1]/../..//div[1]//input[1]")).size();
                    for (int x = 1; x <= y; x++) {
                        try {
                            getDriver().findElement(By.xpath("(//div[@class='asc-survey-question-group asc-dynamic-picklist']//div[@class='asc-survey-question-answer-radio']//input[1]/../..//div[1]//input[1])[" + x + "]")).click();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

                if (getDriver().findElements(By.xpath("//input[@class='asc-survey-question-answer asc-survey-question-answer-date  hasDatepicker']")).size() != 0) {
                    try {
                        getDriver().findElement(By.xpath("//input[@class='asc-survey-question-answer asc-survey-question-answer-date  hasDatepicker']")).click();
                        getDriver().findElement(By.xpath("//input[@class='asc-survey-question-answer asc-survey-question-answer-date  hasDatepicker']")).sendKeys(Keys.ENTER);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                getDriver().findElement(By.xpath("//div[@id='asc-user-custom-data']")).click();
                getDriver().findElement(By.xpath("//div[@id='asc-user-custom-data']//button[@id='asc-dynamic-save-button']")).click();
            }

            if (getDriver().findElements(By.xpath("//div[@id='asc-personal']//div[@id='asc-user-custom-data']//div[contains(@id,'asc_question_csvq')]")).size() != 0) {
                int x = getDriver().findElements(By.xpath("//div[@id='asc-personal']//div[@id='asc-user-custom-data']//div[contains(@id,'asc_question_csvq')]")).size();
                for (int y = 1; y <= x; y++) {
                    try {
                        getDriver().findElement(By.xpath("(//div[@id='asc-personal']//div[@id='asc-user-custom-data']//div[contains(@id,'asc_question_csvq')])[" + y + "]")).click();
                        getDriver().findElement(By.xpath("(//div[@id='asc-personal']//div[@id='asc-user-custom-data']//div[contains(@id,'asc_question_csvq')])[" + y + "]/..//option[2]")).click();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            if (getDriver().findElements(By.xpath("//div[@class='asc-survey-question-group asc-dynamic-picklist']//div[@class='asc-survey-question-answer-radio']//input[1]/../..//div[1]//input[1]")).size() != 0) {
                int y = getDriver().findElements(By.xpath("//div[@class='asc-survey-question-group asc-dynamic-picklist']//div[@class='asc-survey-question-answer-radio']//input[1]/../..//div[1]//input[1]")).size();
                for (int x = 1; x <= y; x++) {
                    try {
                        getDriver().findElement(By.xpath("(//div[@class='asc-survey-question-group asc-dynamic-picklist']//div[@class='asc-survey-question-answer-radio']//input[1]/../..//div[1]//input[1])[" + x + "]")).click();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            if (getDriver().findElements(By.xpath("//input[@class='asc-survey-question-answer asc-survey-question-answer-date  hasDatepicker']")).size() != 0) {
                try {
                    getDriver().findElement(By.xpath("//input[@class='asc-survey-question-answer asc-survey-question-answer-date  hasDatepicker']")).click();
                    getDriver().findElement(By.xpath("//input[@class='asc-survey-question-answer asc-survey-question-answer-date  hasDatepicker']")).sendKeys(Keys.ENTER);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (getDriver().findElements(By.xpath("//input[@class='asc-survey-question-answer']")).size() != 0) {
                int x = getDriver().findElements(By.xpath("//input[@class='asc-survey-question-answer']")).size();
                for (int y = 1; y <= x; y++) {
                    String uuid = UUID.randomUUID().toString();
                    try {
                        getDriver().findElement(By.xpath("(//input[@class='asc-survey-question-answer'])[" + y + "]")).sendKeys(Keys.CONTROL, "s");
                        getDriver().findElement(By.xpath("(//input[@class='asc-survey-question-answer'])[" + y + "]")).sendKeys(Keys.BACK_SPACE, uuid);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            if (getDriver().findElements(By.xpath("//div[@id='asc-user-cc305-data']")).size() != 0) {
                getDriver().findElement(By.xpath("//div[@id='asc-user-cc305-data']")).click();

                if (getDriver().findElements(By.xpath("//div[@id='asc-user-cc305-data']//div[contains(@id,'asc_question_csvq')]")).size() != 0) {
                    int x = getDriver().findElements(By.xpath("//div[@id='asc-user-cc305-data']//div[contains(@id,'asc_question_csvq')]")).size();
                    for (int y = 1; y <= x; y++) {
                        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='asc-user-cc305-data']//div[contains(@id,'asc_question_csvq')])[" + y + "]")));
                        getDriver().findElement(By.xpath("(//div[@id='asc-user-cc305-data']//div[contains(@id,'asc_question_csvq')])[" + y + "]")).click();
                        if (getDriver().findElements(By.xpath("(//div[@id='asc-user-cc305-data']//div[contains(@id,'asc_question_csvq')])[" + y + "]/..//li[2]")).size() != 0) {
                            try {
                                getDriver().findElement(By.xpath("(//div[@id='asc-user-cc305-data']//div[contains(@id,'asc_question_csvq')])[" + y + "]/..//li[2]")).click();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else if (getDriver().findElements(By.xpath("(//div[@id='asc-user-cc305-data']//div[contains(@id,'asc_question_csvq')])[" + y + "]/..//option[2]")).size() != 0) {
                            try {
                                getDriver().findElement(By.xpath("(//div[@id='asc-user-cc305-data']//div[contains(@id,'asc_question_csvq')])[" + y + "]/..//option[2]")).click();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }

                if (getDriver().findElements(By.xpath("//div[@id='asc-user-cc305-data']//input[@class='asc-survey-question-answer asc-survey-question-answer-date  hasDatepicker']")).size() != 0) {
                    getDriver().findElement(By.xpath("//div[@id='asc-user-cc305-data']//input[@class='asc-survey-question-answer asc-survey-question-answer-date  hasDatepicker']")).click();
                    getDriver().findElement(By.xpath("//div[@id='asc-user-cc305-data']//input[@class='asc-survey-question-answer asc-survey-question-answer-date  hasDatepicker']")).sendKeys(Keys.ENTER);
                }

                getDriver().findElement(By.xpath("//div[@id='asc-user-cc305-data']")).click();
                try {
                    getDriver().findElement(By.xpath("//div[@id='asc-user-cc305-data']//button[@id='asc-dynamic-save-button']")).click();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (getDriver().findElements(By.xpath("//h4[contains(text(),'Account Management')]")).size() != 0) {
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//h4[contains(text(),'Account Management')]")));
                getDriver().findElement(By.xpath("//span[contains(text(),'Change Password')]")).click();
                if (getDriver().findElements(By.xpath("//span[@id='asc-btn-reset-cancel']")).size() != 0) {
                    new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='asc-btn-reset-cancel']")));
                    getDriver().findElement(By.xpath("//span[@id='asc-btn-reset-cancel']")).click();
                } else if (getDriver().findElement(By.xpath("//button[@class='btn btn-default asc-cancel']")).isDisplayed() == true) {
                    new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//h4[contains(text(),'Account Management')]/../..//button[@class='btn btn-default asc-cancel']")));
                    getDriver().findElement(By.xpath("//h4[contains(text(),'Account Management')]/../..//button[@class='btn btn-default asc-cancel']")).click();
                }
            }

            if (getDriver().findElements(By.xpath("//h4[contains(text(),'EEO Information')]")).size() != 0) {
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//h4[contains(text(),'EEO Information')]")));
                getDriver().findElement(By.xpath("//div[@id='asc-personal']/div[@id='asc-user-eeoc-data']/div[@class='asc-edit-block-inner']/div[@class='asc-edit-div']/div[1]")).click();

                if (getDriver().findElements(By.xpath("//h4[contains(text(),'EEO Information')]/../..//div[contains(@id,'asc_question_csvq')]")).size() != 0) {
                    int x = getDriver().findElements(By.xpath("//h4[contains(text(),'EEO Information')]/../..//div[contains(@id,'asc_question_csvq')]")).size();
                    for (int y = 1; y <= x; y++) {
                        try {
                            getDriver().findElement(By.xpath("(//h4[contains(text(),'EEO Information')]/../..//div[contains(@id,'asc_question_csvq')])[" + y + "]")).click();
                            getDriver().findElement(By.xpath("(//h4[contains(text(),'EEO Information')]/../..//div[contains(@id,'asc_question_csvq')])[" + y + "]/..//option[2]")).click();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

                if (getDriver().findElements(By.xpath("//div[@id='asc-user-vevraa-data']")).size() != 0) {
                    getDriver().findElement(By.xpath("//div[@id='asc-user-vevraa-data']")).click();
                    if (getDriver().findElements(By.xpath("//div[@id='asc-user-vevraa-data']//div[contains(@id,'asc_question_csvq')]//a[@class='chosen-single']")).size() != 0) {
                        int g = getDriver().findElements(By.xpath("//div[@id='asc-user-vevraa-data']//div[contains(@id,'asc_question_csvq')]//a[@class='chosen-single']")).size();
                        for (int f = 1; f <= g; f++) {
                            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='asc-user-vevraa-data']//div[contains(@id,'asc_question_csvq')]//a[@class='chosen-single'])[" + f + "]")));
                            getDriver().findElement(By.xpath("(//div[@id='asc-user-vevraa-data']//div[contains(@id,'asc_question_csvq')]//a[@class='chosen-single'])[" + f + "]")).click();
                            getDriver().findElement(By.xpath("(//div[@id='asc-user-vevraa-data']//div[contains(@id,'asc_question_csvq')]//a[@class='chosen-single'])[" + f + "]/..//li[2]")).click();
                        }
                    }
                }

                if (getDriver().findElements(By.xpath("//div[@id='asc-user-eeoc-data']//input[contains(@id,'asc-question-csvq')][@type='text']")).size() != 0) {
                    int x = getDriver().findElements(By.xpath("//div[@id='asc-user-eeoc-data']//input[contains(@id,'asc-question-csvq')][@type='text']")).size();
                    for (int y = 1; y <= x; y++) {
                        try {
                            String uuid = UUID.randomUUID().toString();
                            getDriver().findElement(By.xpath("(//div[@id='asc-user-eeoc-data']//input[contains(@id,'asc-question-csvq')][@type='text'])[" + y + "]")).sendKeys(Keys.CONTROL, "a");
                            getDriver().findElement(By.xpath("(//div[@id='asc-user-eeoc-data']//input[contains(@id,'asc-question-csvq')][@type='text'])[" + y + "]")).sendKeys(Keys.BACK_SPACE, uuid);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

                getDriver().findElement(By.xpath("//div[@id='asc-user-eeoc-data']")).click();
                getDriver().findElement(By.xpath("//div[@id='asc-user-eeoc-data']//button[@id='asc-dynamic-save-button']")).click();
            }

            if (getDriver().findElements(By.xpath("//h4[contains(text(),'Pipelines')]")).size() != 0) {
                getDriver().findElement(By.xpath("//div[@id='asc-personal-pipelineviews']//button[contains(text(),'Edit')]")).click();
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='select-pipelines']")));
                getDriver().findElement(By.xpath("//input[@id='select-pipelines']")).click();
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='asc-pipeline-template asc-asc-pipelineview-checkbox'])[1]")));
                getDriver().findElement(By.xpath("(//input[@class='asc-pipeline-template asc-asc-pipelineview-checkbox'])[1]")).click();
                getDriver().findElement(By.xpath("//div[@id='asc-personal-pipelineviews']//button[@id='asc-dynamic-save-button']")).click();
            }
        } else if (arg0.equalsIgnoreCase("Documents")) {
            getDriver().navigate().refresh();
            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
            jse.executeScript("window.scrollBy(0,-540)");
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(),'Documents')]")));
            getDriver().findElement(By.xpath("//li[contains(text(),'Documents')]")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-sm btn-primary add-document-btn']")));
            if (getDriver().findElements(By.xpath("//span[contains(text(),'Delete Resume')]")).size() != 0) {
                getDriver().findElement(By.xpath("//span[contains(text(),'Delete Resume')]")).click();
                getDriver().findElement(By.xpath("//button[@class='btn btn-danger asc-del-confirm']")).click();
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-sm btn-primary add-resume-btn']")));
            }
            getDriver().findElement(By.xpath("//button[@class='btn btn-sm btn-primary add-resume-btn']")).click();
            URL resumeUrl = getClass().getClassLoader().getResource("resumes/Profile.pdf");
            if (resumeUrl != null) {
                File resumeFile = new File(resumeUrl.getFile());
                getDriver().findElement(By.xpath("//input[@name='asc_resume']")).sendKeys(resumeFile.getAbsolutePath());
                Thread.sleep(2000);
            } else {
                throw new Exception("Failed to find resume absolute path");
            }
            new WebDriverWait(getDriver(), 60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='asc-resume']")));
            String handle = getDriver().getWindowHandle();
            System.out.println(handle);
            getDriver().findElement(By.xpath("//button[@class='btn btn-wide btn-primary pull-left']")).click();
            Thread.sleep(4000);
            Set handles = getDriver().getWindowHandles();
            System.out.println(handles);
            for (String handle1 : getDriver().getWindowHandles()) {
                System.out.println(handle1);
                getDriver().switchTo().window(handle1);
                Thread.sleep(4000);
            }
            getDriver().switchTo().window(handle);
            getDriver().findElement(By.xpath("//span[contains(text(),'Delete Resume')]")).click();
            getDriver().findElement(By.xpath("//button[@class='btn btn-danger asc-del-confirm']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-sm btn-primary add-resume-btn']")));

            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Add Document')]")));
            getDriver().findElement(By.xpath("//button[contains(text(),'Add Document')]")).click();
            URL documentUrl = getClass().getClassLoader().getResource("resumes/Profile.pdf");
            if (documentUrl != null) {
                File documentFile = new File(documentUrl.getFile());
                getDriver().findElement(By.xpath("//input[@name='asc_document']")).sendKeys(documentFile.getAbsolutePath());
                Thread.sleep(2000);
            } else {
                throw new Exception("Failed to find document absolute path");
            }
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='view-documents']")));
            getDriver().findElement(By.xpath("//a[@id='view-documents']")).click();
            String document = getDriver().findElement(By.xpath("//div[@class='asc-inline-text']")).getText();
            document = document.replaceAll("\\s", "");
            getDriver().findElement(By.xpath("//div[@class='asc-inline-text']")).click();
            for (String handle1 : getDriver().getWindowHandles()) {
                System.out.println(handle1);
                getDriver().switchTo().window(handle1);
                Thread.sleep(4000);
            }
            getDriver().switchTo().window(handle);
            while (getDriver().findElements(By.xpath("//div[contains(text(),'" + document + "')]/../..//i[@class='fa fa-trash-o link']")).size() != 0) {
                getDriver().findElement(By.xpath("//div[contains(text(),'" + document + "')]/../..//i[@class='fa fa-trash-o link']")).click();
                getDriver().findElement(By.xpath("//button[@class='btn btn-xs btn-danger asc-del-confirm']")).click();
                Thread.sleep(2000);
            }
        } else if (arg0.equalsIgnoreCase("Employee Questions")) {
            if (getDriver().findElements(By.xpath("//li[@id='tab-aboutme']")).size() != 0) {
                getDriver().findElement(By.xpath("//li[@id='tab-aboutme']")).click();
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='personal-sub-tab']//button[@class='btn btn-primary asc-edit-icon btn-sm'][contains(text(),'Edit')]")));
                getDriver().findElement(By.xpath("//div[@id='personal-sub-tab']//button[@class='btn btn-primary asc-edit-icon btn-sm'][contains(text(),'Edit')]")).click();

                if (getDriver().findElements(By.xpath("//fieldset")).size() != 0) {
                    int c = getDriver().findElements(By.xpath("//fieldset")).size();
                    for (int d = 1; c <= d; c++) {
                        try {
                            getDriver().findElement(By.xpath("(//fieldset)[" + d + "]//label[3]")).click();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (getDriver().findElements(By.xpath("//input[@class='asc-survey-question-answer'][@type='text']")).size() != 0) {
                    int x = getDriver().findElements(By.xpath("//input[@class='asc-survey-question-answer'][@type='text']")).size();
                    for (int y = 1; y <= x; y++) {
                        try {
                            String uuid = UUID.randomUUID().toString();
                            getDriver().findElement(By.xpath("(//input[@class='asc-survey-question-answer'][@type='text'])[" + y + "]")).sendKeys(Keys.CONTROL, "a");
                            getDriver().findElement(By.xpath("(//input[@class='asc-survey-question-answer'][@type='text'])[" + y + "]")).sendKeys(Keys.BACK_SPACE);
                            getDriver().findElement(By.xpath("(//input[@class='asc-survey-question-answer'][@type='text'])[" + y + "]")).sendKeys(uuid);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (getDriver().findElements(By.xpath("//textarea[@class='asc-survey-question-answer']")).size() != 0) {
                    int u = getDriver().findElements(By.xpath("//textarea[@class='asc-survey-question-answer']")).size();
                    for (int v = 1; v <= u; v++) {
                        try {
                            String uuid = UUID.randomUUID().toString();
                            getDriver().findElement(By.xpath("(//textarea[@class='asc-survey-question-answer'])[" + v + "]")).sendKeys(Keys.CONTROL, "a");
                            getDriver().findElement(By.xpath("(//textarea[@class='asc-survey-question-answer'])[" + v + "]")).sendKeys(Keys.BACK_SPACE);
                            getDriver().findElement(By.xpath("(//textarea[@class='asc-survey-question-answer'])[" + v + "]")).sendKeys(uuid);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (getDriver().findElements(By.xpath("//input[@class='asc-survey-question-answer asc-survey-question-answer-date  hasDatepicker']")).size() != 0) {
                    int i = getDriver().findElements(By.xpath("//input[@class='asc-survey-question-answer asc-survey-question-answer-date  hasDatepicker']")).size();
                    for (int j = 1; i <= j; i++) {
                        try {
                            getDriver().findElement(By.xpath("(//input[@class='asc-survey-question-answer asc-survey-question-answer-date  hasDatepicker'])[" + j + "]")).click();
                            getDriver().findElement(By.xpath("(//input[@class='asc-survey-question-answer asc-survey-question-answer-date  hasDatepicker'])[" + j + "]")).sendKeys(Keys.ENTER);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (getDriver().findElements(By.xpath("//a[@class='chosen-single chosen-default']")).size() != 0) {
                    int a = getDriver().findElements(By.xpath("//a[@class='chosen-single chosen-default']")).size();
                    for (int b = 1; b <= a; b++) {
                        try {
                            getDriver().findElement(By.xpath("(//a[@class='chosen-single chosen-default'])[" + b + "]")).click();
                            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='chosen-single chosen-default'])[" + b + "]/..//ul[@class='chosen-results']//li[2]")));
                            getDriver().findElement(By.xpath("(//a[@class='chosen-single chosen-default'])[" + b + "]/..//ul[@class='chosen-results']//li[2]")).click();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                getDriver().findElement(By.xpath("//button[@id='asc-dynamic-save-button']")).click();
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='personal-sub-tab']//button[@class='btn btn-primary asc-edit-icon btn-sm'][contains(text(),'Edit')]")));
            }
        } else if (arg0.equalsIgnoreCase("Onboarding")) {
            if (getDriver().findElements(By.xpath("//li[@id='tab-onboarding']")).size() != 0) {
                getDriver().navigate().refresh();
                JavascriptExecutor jse = (JavascriptExecutor) getDriver();
                jse.executeScript("window.scrollBy(0,-540)");
                new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(),'Documents')]")));
                getDriver().findElement(By.xpath("//li[@id='tab-onboarding']")).click();
                try {
                    new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'task-checklist-row')]//div[contains(@class,'col-xs-2 col-md-1 checkbox-icons')]//a[contains(@class,'')]")));
                    getDriver().findElement(By.xpath("(//div[contains(@id,'task-checklist-row')]//div[contains(@class,'col-xs-2 col-md-1 checkbox-icons')]//a[contains(@class,'')])[1]")).click();
                } catch (Exception e) {
                    e.printStackTrace();
                    if (getDriver().findElements(By.xpath("//div[contains(text(),'There are no onboarding tasks to display.')]")).size() != 0) {
                        System.out.println("There are no onboarding tasks to display.");
                    }
                }
            }
        }
    }

    @And("I clean up TC")
    public void iCleanUp() throws Throwable {
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[contains(@class,'fa fa-caret-down')]")));
        getDriver().findElement(By.xpath("//i[contains(@class,'fa fa-caret-down')]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//li[contains(text(),'Admin Console')]")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='user-search']")));
        getDriver().findElement(By.xpath("//input[@id='user-search']")).sendKeys(email, Keys.ENTER);
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//i[@class='fa fa-chevron-down']")).click();
        Thread.sleep(2000);
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='action-call-deleteUser']")));
        getDriver().findElement(By.xpath("//a[@class='action-call-deleteUser']")).click();
        Thread.sleep(3000);
        Alert alert = getDriver().switchTo().alert();
        Thread.sleep(3000);
        alert.accept();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success']")));
    }

    @And("I answer the survey questions TC")
    public void iAnswerTheSurveyQuestions() throws InterruptedException {
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
                element.sendKeys(uuid);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (getDriver().findElements(By.xpath("//a[@class='chosen-single chosen-default']//div//b")).size() != 0) {
            int x = 0;
            x = getDriver().findElements(By.xpath("//a[@class='chosen-single chosen-default']//div//b")).size();
            for (int y = 1; y <= x; y++) {
                try {
                    WebElement select = getDriver().findElement(By.xpath("(//a[@class='chosen-single chosen-default']//div//b)[" + y + "]"));
                    Actions actions = new Actions(getDriver());
                    actions.moveToElement(select).click().perform();
                    Thread.sleep(2000);
                    getDriver().findElement(By.xpath("(//a[@class='chosen-single chosen-default']//div//b)[" + y + "]")).click();
                    getDriver().findElement(By.xpath("(//a[@class='chosen-single chosen-default']//div//b)[" + y + "]/../../../../../..//li[2]")).click();
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        if (getDriver().findElements(By.xpath("//span[contains(text(),'Please Select')]")).size() != 0) {
            int select = getDriver().findElements(By.xpath("//span[contains(text(),'Please Select')]")).size();
            for (int i = 1; i <= select; i++) {
                try {

                    WebElement drop = getDriver().findElement(By.xpath("(//span[contains(text(),'Please Select')])[" + i + "]"));
                    Actions actions = new Actions(getDriver());
                    actions.moveToElement(drop).click().perform();
                    Thread.sleep(2000);
                    getDriver().findElement(By.xpath("(//span[contains(text(),'Please Select')])[" + i + "]")).click();
                    getDriver().findElement(By.xpath("(//span[contains(text(),'Please Select')])[" + i + "]/../../..//option[2]")).click();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        if (getDriver().findElements(By.xpath("//span[contains(text(),'Please Select')]")).size() != 0) {
            int select = getDriver().findElements(By.xpath("//span[contains(text(),'Please Select')]")).size();
            for (int i = 1; i <= select; i++) {
                try {

                    WebElement choose = getDriver().findElement(By.xpath("(//span[contains(text(),'Please Select')])[" + i + "]"));
                    Actions actions = new Actions(getDriver());
                    actions.moveToElement(choose).click().perform();
                    Thread.sleep(2000);
                    getDriver().findElement(By.xpath("(//span[contains(text(),'Please Select')])[" + i + "]")).click();
                    getDriver().findElement(By.xpath("(//span[contains(text(),'Please Select')])[" + i + "]/../../..//li[2]")).click();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        int j = getDriver().findElements(By.xpath("//select")).size();
        for (int i = 1; i <= j; i++) {
            if (getDriver().findElement(By.xpath("(//select)[" + i + "]")).isDisplayed()) {
                try {

                    getDriver().findElement(By.xpath("(//select)[" + i + "]")).click();
                    getDriver().findElement(By.xpath("(//select)[" + i + "]//option[2]")).click();
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
                getDriver().findElement(By.cssSelector("body")).sendKeys(uuid);
                Thread.sleep(1000);
                getDriver().switchTo().defaultContent();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        getDriver().switchTo().defaultContent();
    }

    @And("I copy the LinkedIn email TC")
    public void iCopyTheLinkedInEmail() throws Throwable {
        email = getDriver().findElement(By.xpath("//input[@id='asc-signup-email2']")).getAttribute("value");
    }

    @And("I sign in to BrowserStack")
    public void iSignInToBrowserStack() throws Throwable {
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Sign in')]")));
        getDriver().findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='user_email_login']")));
        getDriver().findElement(By.xpath("//input[@id='user_password']")).sendKeys("A$cendify");
        getDriver().findElement(By.xpath("//input[@id='user_email_login']")).sendKeys("johnny@ascendify.com");
        if (getDriver().findElements(By.xpath("//*[@id='accept-cookie-notification-cross']")).size() != 0) {
            getDriver().findElement(By.xpath("//*[@id='accept-cookie-notification-cross']")).click();
        }
        Thread.sleep(4000);
        if (getDriver().findElements(By.xpath("//form[@id='signin_signup_form']//input[@id='user_submit']")).size() != 0) {
            try {
                getDriver().findElement(By.xpath("//form[@id='signin_signup_form']//input[@id='user_submit']")).click();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (getDriver().findElements(By.xpath("//div[@class='input-placeholder col-lg-6 col-center google-login-button']//a[@class='btn btn-primary col-center oauth-btn'][contains(text(),'Login')]")).size() != 0) {
            getDriver().findElement(By.xpath("//div[@class='input-placeholder col-lg-6 col-center google-login-button']//a[@class='btn btn-primary col-center oauth-btn'][contains(text(),'Login')]")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Sign in with Google')]")));
            getDriver().navigate().back();
            getDriver().findElement(By.xpath("//input[@id='user_password']")).sendKeys("A$cendify");
            getDriver().findElement(By.xpath("//form[@id='signin_signup_form']//input[@id='user_submit']")).click();
        }
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='dashboard']")));
    }
}