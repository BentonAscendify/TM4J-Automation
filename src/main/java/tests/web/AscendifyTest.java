package tests.web;

import org.junit.*;
import org.junit.runners.MethodSorters;
import webui.model.Ascendify.Ascendify;
import webui.model.Web;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class AscendifyTest {


    @BeforeClass
    public static void setUp() {
        Web.ascendify.openTalentCommunityWorks();
    }
//
//    @AfterClass
//    public static void tearDown() {
//        System.out.println("closing the Driver");
//        Ascendify.getDriver().quit();
//    }


    @Test
    public void t1_signIn() {
        System.out.println("executing signIn");
        Web.ascendify.signIn
                .inputEmail("hiral@ascendify.com")
                .inputPassword("testing12345")
                .clickSignin()
                .confirmSignin();
    }

    @Test
    public void t2_requisition() {
        System.out.println("requisition tab");
        Web.ascendify.requisition.goToRequisitionWorks();


    }

    @Test
    public void t3_requisition() throws InterruptedException {
        System.out.println("requisition");
        Web.ascendify.requisition.Selectreq().Totalcandidate();


    }

   /* @Test
    public void t4_people() throws InterruptedException {
        System.out.println(("people"));
        Web.ascendify.people.clickPeople().addResume();
    }*/


    @Ignore
    @Test
    public void forgot_password() {
        System.out.println("executing fyp");
        Web.ascendify.forgotYourPassword
                .clickSignin()
                .confirmClickSignin();
    }

}
