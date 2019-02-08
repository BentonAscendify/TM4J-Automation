package webui.model.Ascendify.peopletab;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import webui.model.Ascendify.Ascendify;
import webui.model.WebPage;

public class PeopleTab extends WebPage {


    public static void goToPeopleTab() {
        Ascendify.getDriver().get("https://testcommunity.ascendify.works/people");
    }
}
