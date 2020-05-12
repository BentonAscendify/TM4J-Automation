package cucumber.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static cucumber.support.TestContext.*;

public class MainMenuStepDefs {
    @Given("I navigate to {string} page MM")
    public void iNavigateToPage(String arg0) {
        getDriver().get("https://testcommunity.ascendify.com/");
    }

    @When("I sign in as super admin with credentials {string} and {string} MM")
    public void iSignInAsSuperAdminWithCredentialsAnd(String arg0, String arg1) {
        getDriver().findElement(By.xpath("//input[@id='id_username']")).click();
        getDriver().findElement(By.xpath("//input[@id='id_username']")).sendKeys(arg0);
        getDriver().findElement(By.xpath("//input[@id='id_password']")).click();
        getDriver().findElement(By.xpath("//input[@id='id_password']")).sendKeys(arg1);
        getDriver().findElement(By.xpath("//button[@id='asc-signin-btn']")).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Main Menu tab')]")));
        getDriver().findElement(By.xpath("//span[contains(text(),'Main Menu tab')]")).isDisplayed();
    }

    @And("I check whether {string} is loading properly MM")
    public void iCheckWhetherIsLoadingProperly(String arg0) throws Throwable {
        if (arg0.equalsIgnoreCase("Main Menu Teb")) {
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='grid']")));
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='main_menu_anc']")));
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='asc-reminder-tile-heading asc-list-tile']")));
        } else if (arg0.equalsIgnoreCase("Admin Console")) {
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[contains(@class,'fa fa-caret-down')]")));
            getDriver().findElement(By.xpath("//i[contains(@class,'fa fa-caret-down')]")).click();
            Thread.sleep(1000);
            getDriver().findElement(By.xpath("//li[contains(text(),'Admin Console')]")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//aside[@id='left-system-panel']")));
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='user-accounts']")));
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='sections-toggle']")));
            getDriver().findElement(By.xpath("//div[@id='sections-toggle']")).click();
        } else if (arg0.equalsIgnoreCase("Talent Matching Tab")) {
            Thread.sleep(1000);
            WebElement element = getDriver().findElement(By.xpath("//ul[contains(@class,'sections-menu nav navbar-nav')]"));
            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
            jse.executeScript("arguments[0].scrollIntoView();", element);
            getDriver().findElement(By.xpath("//a[@href='/talent-matching']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='DefaultFilter']")));
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='main-content clearfix']")));
            getDriver().findElement(By.xpath("//div[@id='sections-toggle']")).click();
        } else if (arg0.equalsIgnoreCase("Dashboard Tab")) {
            WebElement element = getDriver().findElement(By.xpath("//ul[contains(@class,'sections-menu nav navbar-nav')]"));
            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
            jse.executeScript("arguments[0].scrollIntoView();", element);
            getDriver().findElement(By.xpath("//a[@href='/dashboard']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='asc-dashboard-hr']")));
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='left-system-panel']")));
            getDriver().findElement(By.xpath("//div[@class='section-tab']")).click();
        } else if (arg0.equalsIgnoreCase("Career Navigator Tab")) {
            Thread.sleep(2000);
            WebElement element = getDriver().findElement(By.xpath("//ul[contains(@class,'sections-menu nav navbar-nav')]"));
            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
            jse.executeScript("arguments[0].scrollIntoView();", element);
            getDriver().findElement(By.xpath("//a[@href='/careernavigator']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='filter-bar']")));
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='main-content clearfix']")));
            getDriver().findElement(By.xpath("//div[@id='sections-toggle']")).click();
        } else if (arg0.equalsIgnoreCase("Analytics Tab")) {
            WebElement element = getDriver().findElement(By.xpath("//ul[contains(@class,'sections-menu nav navbar-nav')]"));
            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
            jse.executeScript("arguments[0].scrollIntoView();", element);
            getDriver().findElement(By.xpath("//a[@href='/analytics']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='left-system-panel']")));
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='asc-system-report']")));
            getDriver().findElement(By.xpath("//div[@class='section-tab']")).click();
        } else if (arg0.equalsIgnoreCase("Collections Tab")) {
            Thread.sleep(2000);
            WebElement element = getDriver().findElement(By.xpath("//ul[contains(@class,'sections-menu nav navbar-nav')]"));
            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
            jse.executeScript("arguments[0].scrollIntoView();", element);
            getDriver().findElement(By.xpath("//a[@href='/collections']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='left-system-panel']")));
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='right-system-panel']")));
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='middle-system-panel']")));
            getDriver().findElement(By.xpath("//i[@class='ascendicon-chevron-down']")).click();
        } else if (arg0.equalsIgnoreCase("Community Tab")) {
            Thread.sleep(2000);
            WebElement element = getDriver().findElement(By.xpath("//ul[contains(@class,'sections-menu nav navbar-nav')]"));
            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
            jse.executeScript("arguments[0].scrollIntoView();", element);
            try {
                if (getDriver().findElement(By.xpath("//a[@href='/community']")).isDisplayed()) {
                    getDriver().findElement(By.xpath("//a[@href='/community']")).click();
                } else {
                    getDriver().findElement(By.xpath("//i[@class='ascendicon-chevron-down']")).click();
                    Thread.sleep(2000);
                    getDriver().findElement(By.xpath("//a[@href='/community']")).click();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='left-system-panel']")));
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='right-system-panel']")));
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='middle-system-panel']")));
            getDriver().findElement(By.xpath("//div[@class='section-tab']")).click();
        } else if (arg0.equalsIgnoreCase("Candidate Review Tab")) {
            Thread.sleep(2000);
            WebElement element = getDriver().findElement(By.xpath("//ul[contains(@class,'sections-menu nav navbar-nav')]"));
            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
            jse.executeScript("arguments[0].scrollIntoView();", element);
            getDriver().findElement(By.xpath("//a[@href='/hiring']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='bar__stats bar__row']")));
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'bar__row left-side')]")));
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='table']")));
            getDriver().findElement(By.xpath("//div[@id='sections-toggle']")).click();
        } else if (arg0.equalsIgnoreCase("Pipelines Tab")) {
            WebElement element = getDriver().findElement(By.xpath("//ul[contains(@class,'sections-menu nav navbar-nav')]"));
            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
            jse.executeScript("arguments[0].scrollIntoView();", element);
            getDriver().findElement(By.xpath("//a[@href='/pipelines']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='asc-sub-menu-holder']")));
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='right-system-panel']")));
            getDriver().findElement(By.xpath("//div[@class='section-tab']")).click();
        } else if (arg0.equalsIgnoreCase("Opportunities Tab")) {
            Thread.sleep(2000);
            WebElement element = getDriver().findElement(By.xpath("//ul[contains(@class,'sections-menu nav navbar-nav')]"));
            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
            jse.executeScript("arguments[0].scrollIntoView();", element);
            getDriver().findElement(By.xpath("//a[@href='/opportunities']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='left-system-panel']")));
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='right-system-panel']")));
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='middle-system-panel']")));
            getDriver().findElement(By.xpath("//div[@class='section-tab']")).click();
        } else if (arg0.equalsIgnoreCase("Organizations")) {
            WebElement element = getDriver().findElement(By.xpath("//ul[contains(@class,'sections-menu nav navbar-nav')]"));
            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
            jse.executeScript("arguments[0].scrollIntoView();", element);
            getDriver().findElement(By.xpath("//a[@href='/organizations']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='left-system-panel']")));
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='right-system-panel']")));
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='middle-system-panel']")));
            getDriver().findElement(By.xpath("//div[@class='section-tab']")).click();
        } else if (arg0.equalsIgnoreCase("People Tab")) {
            Thread.sleep(2000);
            WebElement element = getDriver().findElement(By.xpath("//ul[contains(@class,'sections-menu nav navbar-nav')]"));
            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
            jse.executeScript("arguments[0].scrollIntoView();", element);
            getDriver().findElement(By.xpath("//a[@href='/people']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='left-system-panel']")));
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='right-system-panel']")));
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='middle-system-panel']")));
            getDriver().findElement(By.xpath("//div[@class='section-tab']")).click();
        } else if (arg0.equalsIgnoreCase("Requisitions Tab")) {
            Thread.sleep(2000);
            WebElement element = getDriver().findElement(By.xpath("//ul[contains(@class,'sections-menu nav navbar-nav')]"));
            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
            jse.executeScript("arguments[0].scrollIntoView();", element);
            getDriver().findElement(By.xpath("//a[@href='/requisitions']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='left-system-panel']")));
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='right-system-panel']")));
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='middle-system-panel']")));
            getDriver().findElement(By.xpath("//div[@class='section-tab']")).click();
        } else if (arg0.equalsIgnoreCase("Succession Planning Tab")) {
            Thread.sleep(2000);
            WebElement element = getDriver().findElement(By.xpath("//ul[contains(@class,'sections-menu nav navbar-nav')]"));
            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
            jse.executeScript("arguments[0].scrollIntoView();", element);
            try {
                if (getDriver().findElement(By.xpath("//a[@href='/succession-planning']")).isDisplayed()) {
                    getDriver().findElement(By.xpath("//a[@href='/succession-planning']")).click();
                } else {
                    getDriver().findElement(By.xpath("//div[@class='section-tab']")).click();
                    Thread.sleep(2000);
                    getDriver().findElement(By.xpath("//a[@href='/succession-planning']")).click();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            Thread.sleep(2000);
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='main-content__header bar-1']")));
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='main-content__header bar-2']")));
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='bar__unit bar__job-role row expanded successor--ready']")));
            getDriver().findElement(By.xpath("//div[@id='sections-toggle']")).click();
        } else if (arg0.equalsIgnoreCase("Campaigns Tab")) {
            WebElement element = getDriver().findElement(By.xpath("//ul[contains(@class,'sections-menu nav navbar-nav')]"));
            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
            jse.executeScript("arguments[0].scrollIntoView();", element);
            getDriver().findElement(By.xpath("//a[@href='/campaigns']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='left-system-panel']")));
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='asc-campaigns']")));
            getDriver().findElement(By.xpath("//div[@class='section-tab']")).click();
        } else if (arg0.equalsIgnoreCase("Referrals Tab")) {
            WebElement element = getDriver().findElement(By.xpath("//ul[contains(@class,'sections-menu nav navbar-nav')]"));
            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
            jse.executeScript("arguments[0].scrollIntoView();", element);
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/referralcenter']")));
            getDriver().findElement(By.xpath("//a[@href='/referralcenter']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='left-system-panel']")));
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='right-system-panel']")));
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='middle-system-panel']")));
            getDriver().findElement(By.xpath("//div[@class='section-tab']")).click();
        } else if (arg0.equalsIgnoreCase("Assessments Tab")) {
            WebElement element = getDriver().findElement(By.xpath("//ul[contains(@class,'sections-menu nav navbar-nav')]"));
            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
            jse.executeScript("arguments[0].scrollIntoView();", element);
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/assessments']")));
            getDriver().findElement(By.xpath("//a[@href='/assessments']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'talent__profile__container')]/div/div[1]")));
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'talent__profile__container')]/div/div[2]")));
            getDriver().findElement(By.xpath("//div[@id='sections-toggle']")).click();
        } else if (arg0.equalsIgnoreCase("Learning Repository Tab")) {
            Thread.sleep(2000);
            WebElement element = getDriver().findElement(By.xpath("//ul[contains(@class,'sections-menu nav navbar-nav')]"));
            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
            jse.executeScript("arguments[0].scrollIntoView();", element);
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/learningrepository']")));
            Thread.sleep(2000);
            getDriver().findElement(By.xpath("//a[@href='/learningrepository']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='repository-filters']")));
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='main-content main-details course']")));
            getDriver().findElement(By.xpath("//div[@class='section-tab']")).click();
        } else if (arg0.equalsIgnoreCase("Reporting Tab")) {
            WebElement element = getDriver().findElement(By.xpath("//ul[contains(@class,'sections-menu nav navbar-nav')]"));
            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
            jse.executeScript("arguments[0].scrollIntoView();", element);
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/reporting']")));
            getDriver().findElement(By.xpath("//a[@href='/reporting']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='filter-drawer']")));
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'bar__filter row expanded open')]")));
            getDriver().findElement(By.xpath("//div[@id='sections-toggle']")).click();
        } else if (arg0.equalsIgnoreCase("Insights Tab")) {
            Thread.sleep(2000);
            WebElement element = getDriver().findElement(By.xpath("//ul[contains(@class,'sections-menu nav navbar-nav')]"));
            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
            jse.executeScript("arguments[0].scrollIntoView();", element);
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/insights']")));
            getDriver().findElement(By.xpath("//a[@href='/insights']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='insights__menu']")));
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='insights__container']/div[@class='insights__view']")));
            getDriver().findElement(By.xpath("//div[@id='sections-toggle']")).click();
        } else if (arg0.equalsIgnoreCase("Marketplace Tab")) {
            Thread.sleep(2000);
            WebElement element = getDriver().findElement(By.xpath("//ul[contains(@class,'sections-menu nav navbar-nav')]"));
            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
            jse.executeScript("arguments[0].scrollIntoView();", element);
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/talent_marketplace']")));
            getDriver().findElement(By.xpath("//a[@href='/talent_marketplace']")).click();
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='bar__filter-spreadsheet']")));
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='icon--add test']")));
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='inputGlobal']")));
        }
    }
}
