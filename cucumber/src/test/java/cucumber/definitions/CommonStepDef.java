package cucumber.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static cucumber.support.TestContext.getConfig;
import static cucumber.support.TestContext.getDriver;


public class CommonStepDef {

    @Given("I navigate to {string} page")
    public void iNavigateToPage(String arg0) {
        if (arg0.equalsIgnoreCase("CRM login")) {
            getDriver().get(getConfig().get("testCommunityLogin").toString());
        } else if (arg0.equalsIgnoreCase("TC Login")) {
            getDriver().get(getConfig().get("talentCommunityLogin").toString());
        } else if (arg0.equalsIgnoreCase("LinkedIn")) {
            getDriver().get(getConfig().get("linkedInLogin").toString());
        }
    }

    @When("I sign in as super admin")
    public void iSignInAsSuperAdminMM() throws Throwable {
        Thread.sleep(4000);
        if (getDriver().findElements(By.xpath("//i[contains(@class,'fa fa-caret-down')]")).size() != 0) {
            getDriver().findElement(By.xpath("//i[contains(@class,'fa fa-caret-down')]")).click();
            Thread.sleep(1000);
            getDriver().findElement(By.xpath("//li[@id='asc-sign-out-button']")).click();
        }
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='id_username']")));
        getDriver().findElement(By.xpath("//input[@id='id_username']")).click();

        getDriver().findElement(By.xpath("//input[@id='id_username']")).sendKeys(getConfig().get("superAdminUsername").toString());
        getDriver().findElement(By.xpath("//input[@id='id_password']")).click();
        getDriver().findElement(By.xpath("//input[@id='id_password']")).sendKeys(getConfig().get("superAdminPassword").toString());

        getDriver().findElement(By.xpath("//button[@id='asc-signin-btn']")).click();
        try {
            new WebDriverWait(getDriver(), 60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Main Menu')]")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (getDriver().findElements(By.xpath("//span[contains(text(),'Main Menu')]")).size() == 0) {
            getDriver().findElement(By.xpath("//div[@class='section-tab']")).click();
            getDriver().findElement(By.xpath("//div[@class='sections-container']")).isDisplayed();
            getDriver().findElement(By.xpath("//a[@id='header-main-menu']")).click();
            new WebDriverWait(getDriver(), 60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Main Menu')]")));
        }
    }

    @When("I sign in as system admin")
    public void iSignInAsSystemAdminMM() throws Throwable {
        Thread.sleep(4000);
        if (getDriver().findElements(By.xpath("//div[@class='nav__user']")).size() != 0) {
            getDriver().findElement(By.xpath("//div[@class='nav__user']")).click();
            Thread.sleep(1000);
            getDriver().findElement(By.xpath("//li[@id='asc-sign-out-button']")).click();
        }
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='id_username']")));
        getDriver().findElement(By.xpath("//input[@id='id_username']")).click();

        getDriver().findElement(By.xpath("//input[@id='id_username']")).sendKeys(getConfig().get("systemAdminUsername").toString());
        getDriver().findElement(By.xpath("//input[@id='id_password']")).click();
        getDriver().findElement(By.xpath("//input[@id='id_password']")).sendKeys(getConfig().get("systemAdminPassword").toString());

        getDriver().findElement(By.xpath("//button[@id='asc-signin-btn']")).click();
        try {
            new WebDriverWait(getDriver(), 60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Main Menu')]")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (getDriver().findElements(By.xpath("//span[contains(text(),'Main Menu')]")).size() == 0) {
            getDriver().findElement(By.xpath("//div[@class='section-tab']")).click();
            getDriver().findElement(By.xpath("//div[@class='sections-container']")).isDisplayed();
            getDriver().findElement(By.xpath("//a[@id='header-main-menu']")).click();
            new WebDriverWait(getDriver(), 60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Main Menu')]")));
        }
    }

    @When("I sign in to CRM")
    public void iSignInToTest() {
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='id_username']")));

        getDriver().findElement(By.xpath("//input[@id='id_username']")).sendKeys(getConfig().get("superAdminUsername").toString());
        getDriver().findElement(By.xpath("//input[@id='id_password']")).sendKeys(getConfig().get("superAdminPassword").toString());
//        getDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
        getDriver().findElement(By.xpath("//button[@id='asc-signin-btn']")).click();
    }

    @When("I sign in to TalentCommunity as a candidate")
    public void iSignInToTalent() {
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='id_username']")));

        getDriver().findElement(By.xpath("//input[@id='id_username']")).sendKeys(getConfig().get("candidateUsername").toString());
        getDriver().findElement(By.xpath("//input[@id='id_password']")).sendKeys(getConfig().get("candidatePassword").toString());
    }

    @And("I sign in to TalentCommunity as an Internal User")
    public void iSignInToTalentCommunityAsAnInternalUser() {
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='id_username']")));

        getDriver().findElement(By.xpath("//input[@id='id_username']")).sendKeys(getConfig().get("internalUsername").toString());
        getDriver().findElement(By.xpath("//input[@id='id_password']")).sendKeys(getConfig().get("internalPassword").toString());
    }

    @And("I sign in to LinkedIn")
    public void iSignInToLinkedIn() throws Throwable {
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//input[@id='username']")).sendKeys(getConfig().get("linkedInUsername").toString());
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys(getConfig().get("linkedInPassword").toString());
    }

    @And("I add the URL of my Ascendify app")
    public void iAddTheURLOfMyAscendifyApp() {
        getDriver().findElement(By.xpath("//input[@id='web-address-input']")).sendKeys(getConfig().get("testCommunityLogin").toString());
        getDriver().findElement(By.xpath("//button//span[contains(text(),'Save')]")).click();
    }

    @And("sign in to Ascendify Sidekick")
    public void signInToAscendifySidekick() {
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email-input']")));

        getDriver().findElement(By.xpath("//input[@id='email-input']")).sendKeys(getConfig().get("superAdminUsername").toString());
        getDriver().findElement(By.xpath("//input[@id='password-input']")).sendKeys(getConfig().get("superAdminPassword").toString());
        getDriver().findElement(By.xpath("//button//span[contains(text(),'Sign In')]")).click();

        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button//span[contains(text(),'Create Record')]")));

    }
}
