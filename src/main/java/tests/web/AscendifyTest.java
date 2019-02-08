package tests.web;

import org.junit.*;
import org.junit.runners.MethodSorters;
import webui.model.Ascendify.Ascendify;
import webui.model.Web;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class AscendifyTest {

    @BeforeClass
    public static void setUp() {
        Web.ascendify.openAscendifyWorks();
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("closing the Driver");
        Ascendify.getDriver().quit();
    }

    @Test
    public void t1_signIn() {
        System.out.println("executing signIn");
        Web.ascendify.signIn
                .inputEmail("tatyana@ascendify.com")
                .inputPassword("testing123")
                .clickSignin()
                .confirmSignin();
    }

    @Ignore
    @Test
    public void t2_peopleTab() {
        System.out.println("executing peopleTab");
        Web.ascendify.peopleTab.goToPeopleTab();
    }

    @Ignore
    @Test
    public void t3_hometab() {
        System.out.println("clicking on People tab, Requisitions tab, Assessments tab and confirming");
        Web.ascendify.hometab
                .clickPeopletab()
                .confirmClickPeopletab()
                .goToHometab()
                .confirmGoToHometab()
                .clickRequisitionstab()
                .confirmClickRequisitionstab()
                .goToHometab()
                .confirmGoToHometab()
                .clickAssessmentstab()
                .confirmClickAssessmentstab();
    }

    @Test
    public void t3_signOut() {
        System.out.println("executing signOut");
        Web.ascendify.signOut
                .clickProfileDropdown()
                .clickSignout()
                .confirmSignout();
    }

}
