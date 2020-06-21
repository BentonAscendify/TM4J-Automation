package cucumber.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

import static cucumber.support.TestContext.getDriver;

public class TMStepdefs {
    @And("I click on {string} tab TM")
    public void iClickOnTabTM(String arg0) {
        if (arg0.equalsIgnoreCase("Talent Matching")) {
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='hovicon btn-primary']//a[@href='/talent-matching']")));
            getDriver().findElement(By.xpath("//div[@class='hovicon btn-primary']//a[@href='/talent-matching']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='MuiFormGroup-root MuiFormGroup-row']")));
        }
    }

    String req;

    @And("I select a requisition TM")
    public void iSelectARequisitionTM() throws Throwable {
        getDriver().findElement(By.xpath("//span[contains(text(),'Requisitions')]/..//span[contains(@class,'MuiButtonBase-root MuiIconButton-root asc-prod')]//span[@class='MuiIconButton-label']")).click();
        getDriver().findElement(By.xpath("//label[@id='Requisitions-autocomplete-label']/..//div[contains(@class,'MuiInputBase-root MuiFilledInput-root asc-prod')]")).click();
        req = getDriver().findElement(By.xpath("(//ul[@id='Requisitions-autocomplete-popup']//li[1]//div[contains(@class,'asc-prod')])[1]")).getText();
        int li = getDriver().findElements(By.xpath("//ul[@id='Requisitions-autocomplete-popup']//li")).size();
        System.out.println("Number of Requisitions = " + li);
        getDriver().findElement(By.xpath("//ul[@id='Requisitions-autocomplete-popup']//li[1]")).click();
        Thread.sleep(2000);
        for (int i = 2; i <= li; i++) {
            while ((getDriver().findElements(By.xpath("//p[contains(@class,'MuiTypography-root asc-prod')][contains(text(),'No results :( Try again!')]")).size() != 0) || (getDriver().findElements(By.xpath("//span[contains(text(),'An error has occured while fetching default job filters data.')]")).size() != 0)) {
                getDriver().findElement(By.xpath("//label[@id='Requisitions-autocomplete-label']/..//div[contains(@class,'MuiInputBase-root MuiFilledInput-root asc-prod')]//span[@class='MuiIconButton-label']//*[local-name()='svg']")).click();
                req = getDriver().findElement(By.xpath("(//ul[@id='Requisitions-autocomplete-popup']//li[" + i + "]//div[contains(@class,'asc-prod')])[1]")).getText();
                getDriver().findElement(By.xpath("//ul[@id='Requisitions-autocomplete-popup']//li[" + i + "]")).click();
                Thread.sleep(2000);
            }
        }
        System.out.println("Requisition is " + req);
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button//span[contains(text(),'Add')]")));
    }

    String candidate;

    @And("I add a person to the job folder TM")
    public void iAddAPersonToTheJobFolderTM() {
        candidate = getDriver().findElement(By.xpath("(//div[@class='media__obj']/div[@class='media__obj__info']/div/div[1])[1]")).getText();
        System.out.println("Candidate is " + candidate);
        getDriver().findElement(By.xpath("//button//span[contains(text(),'Add')]")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='MuiDialogContent-root']")));
        getDriver().findElement(By.xpath("//input[@placeholder='Recruiter']")).sendKeys("Chandler Bing", Keys.DOWN, Keys.ENTER);
        getDriver().findElement(By.xpath("//input[@placeholder='Add Tags...']")).sendKeys("This is a tag");
        getDriver().findElement(By.xpath("//textarea[@placeholder='Quick Note']")).sendKeys("This is a Quick Note");
        getDriver().findElement(By.xpath("//p[contains(text(),'Add')]")).click();
        getDriver().findElement(By.xpath("//button//span[text()='Adding']")).isDisplayed();
        new WebDriverWait(getDriver(), 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),' has been added and is now in the Talent Network tab')]")));
    }

    @Then("a new account is created for that person TM")
    public void aNewAccountIsCreatedForThatPersonTM() {
        String handle = getDriver().getWindowHandle();
        System.out.println(handle);
        getDriver().findElement(By.xpath("//a[contains(text(),'View Profile')]")).click();
        Set handles = getDriver().getWindowHandles();
        System.out.println(handles);

        for (String handle1 : getDriver().getWindowHandles()) {
            System.out.println(handle1);
            getDriver().switchTo().window(handle1);
        }
        getDriver().findElement(By.xpath("//div[@id='asc-candidate-expanded-name'][text()='" + candidate + "']")).isDisplayed();
    }

    @And("I make sure that person is added to the job folder TM")
    public void iMakeSureThatPersonIsAddedToTheJobFolderTM() {
        getDriver().findElement(By.xpath("//div[@class='section-tab']")).click();
        getDriver().findElement(By.xpath("//div[@class='sections-container']")).isDisplayed();
        getDriver().findElement(By.xpath("//a[@href='/requisitions']")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='full-header-search-input']")));
        getDriver().findElement(By.xpath("//input[@id='full-header-search-input']")).sendKeys(req, Keys.ENTER);
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow'])[1]")));
        getDriver().findElement(By.xpath("//div[text()='" + req + "']/../../../..//i[@class='fa fa-chevron-circle-right asc-list-more-information-arrow']")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Total')]")));
        getDriver().findElement(By.xpath("//a[contains(text(),'Total')]")).click();
        new WebDriverWait(getDriver(), 60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='link asc-list-name highlight']")));
        getDriver().findElement(By.xpath("//div[@class='link asc-list-name highlight'][contains(text(),'" + candidate + "')]")).isDisplayed();
    }

    @And("I clean up {string} TM")
    public void iCleanUpTM(String arg0) throws Throwable {
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='header_bar']//i[contains(@class,'fa fa-caret-down')]")));
        getDriver().findElement(By.xpath("//div[@id='header_bar']//i[contains(@class,'fa fa-caret-down')]")).click();
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

        if (arg0.equalsIgnoreCase("PDL User")) {
            getDriver().findElement(By.xpath("//input[@id='user-search']")).sendKeys(candidate, Keys.ENTER);
            Thread.sleep(2000);
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + candidate + "')]/../..//i[@class='fa fa-chevron-down']")));
            if (getDriver().findElements(By.xpath("//a[contains(text(),'" + candidate + "')]/../..//i[@class='fa fa-chevron-down']")).size() > 1) {
                getDriver().findElement(By.xpath("//th[contains(text(),'Created Date')]")).click();
                Thread.sleep(4000);
            }
            getDriver().findElement(By.xpath("(//a[contains(text(),'" + candidate + "')]/../..//i[@class='fa fa-chevron-down'])[1]")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(text(),'" + candidate + "')]/../..//i[@class='fa fa-chevron-down'])[1]/../..//a[@class='action-call-deleteUser']")));
            getDriver().findElement(By.xpath("//a[@class='action-call-deleteUser']")).click();
            Thread.sleep(500);
            Alert alert = getDriver().switchTo().alert();
            alert.accept();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success']")));
        }
    }
}
