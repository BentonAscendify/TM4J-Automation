package cucumber.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static cucumber.support.TestContext.getDriver;
import static cucumber.support.TestContext.getConfig;


public class CommonStepDef {

    @Given("I navigate to {string} page")
    public void iNavigateToPage(String arg0) {

        if (arg0.equalsIgnoreCase("Test Community login")) {
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
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Main Menu')]")));
        getDriver().findElement(By.xpath("//span[contains(text(),'Main Menu')]")).isDisplayed();
    }

    @When("I sign in to TestCommunity")
    public void iSignInToTest() {
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='id_username']")));

        getDriver().findElement(By.xpath("//input[@id='id_username']")).sendKeys(getConfig().get("superAdminUsername").toString());
        getDriver().findElement(By.xpath("//input[@id='id_password']")).sendKeys(getConfig().get("superAdminPassword").toString());

        getDriver().findElement(By.xpath("//button[@id='asc-signin-btn']")).click();
    }

    @When("I sign in to TalentCommunity as a candidate")
    public void iSignInToTalent() {
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='id_username']")));

        getDriver().findElement(By.xpath("//input[@id='id_username']")).sendKeys(getConfig().get("candidateUsername").toString());
        getDriver().findElement(By.xpath("//input[@id='id_password']")).sendKeys(getConfig().get("candidatePassword").toString());
    }

    @And("I sign in to LinkedIn")
    public void iSignInToLinkedIn() throws Throwable {
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//input[@id='username']")).sendKeys(getConfig().get("linkedInUsername").toString());
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys(getConfig().get("linkedInPassword").toString());
    }

}
