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


    @Ignore
    @Test
    public void t1_signIn() {
        System.out.println("executing signIn");
        Web.ascendify.signIn
                .inputEmail("tatyana@ascendify.com")
                .inputPassword("test12345")
                .clickSignin()
                .confirmSignin();
    }


    @Test
    public void forgot_password() throws InterruptedException {
        System.out.println("executing fyp");
        Web.ascendify.forgotYourPassword
                .clickSignin()
                .confirmClickSignin()
                .clickForgotPassword()
                .confirmClickForgotPassword()
                .inputEmail("qa.ascendify@gmail.com")
                .clickRecoverPasword()
                .confirmClickRecoverPassword();

    }


    @Test
    public void gmail() throws InterruptedException {
        Web.ascendify.gmailForgotYourPasswordEmail
                .goToGmail()
                .confirmGoToGmail()
                .insertEmail("qa.ascendify@gmail.com")
                .clickNext()
                .confirmClickNext()
                .insertPasswordAndClickEnter("Testing12345")
                .confirmSignin()
                .waitForPasswordResetEmail()
                .confirmInsidePasswordResetEmail()
                .clickPasswordResetLinkWorks();

        Web.ascendify.forgotYourPassword
                .resetNewPasswordWorks("Testing123");
                //.confirmNewPassword("Testing123")
                //.clickChangePassword();
        Web.ascendify.gmailForgotYourPasswordEmail
                .confirmSignin()
                //.waitForPasswordResetEmail()
                //.clickPasswordResetLink()
                .clickMoreSettings()
                .clickMoreSettingsDelete();
    }

    @Ignore
    @Test
    public void testTrashIcon() throws InterruptedException {
        Web.ascendify.gmailForgotYourPasswordEmail
                .goToGmail()
                .confirmGoToGmail()
                .insertEmail("qa.ascendify@gmail.com")
                .clickNext()
                .confirmClickNext()
                .insertPasswordAndClickEnter("Testing12345")
                .confirmSignin()
                .waitForPasswordResetEmail()
                //.clickPasswordResetLink()
                //.clickTrashIcon()
                .clickMoreSettings()
                .clickMoreSettingsDelete()
                .confirmNoEmails();
    }

    @Ignore
    @Test
    public void t3_signOut() {
        System.out.println("executing signOut");
        Web.ascendify.signOut
                .clickProfileDropdown()
                .clickSignout()
                .confirmSignout();
    }

}
