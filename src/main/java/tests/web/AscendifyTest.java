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
                .inputPassword("test12345")
                .clickSignin()
                .confirmSignin();
    }

    @Ignore
    @Test
    public void forgot_password() {
        System.out.println("executing fyp");
        Web.ascendify.forgotYourPassword
                .clickSignin()
                .confirmClickSignin();
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
