package tests.web;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import webui.model.Ascendify.Ascendify;
import webui.model.Web;

public class ForgotYourPasswordTCWorks {

    @BeforeClass
    public static void setUp() {
        Web.ascendify.openTalentCommunityWorks();
    }

//    @AfterClass
//    public static void tearDown() {
//        System.out.println("closing the Driver");
//        Ascendify.getDriver().quit();
//    }

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

//        Web.ascendify.gmailForgotYourPasswordEmail
//                .goToGmail()
//                .confirmGoToGmail()
//                .insertEmail("qa.ascendify@gmail.com")
//                .clickNext()
//                .confirmClickNext()
//                .insertPasswordAndClickEnter("Testing12345")
//                .confirmSignin()
//                .waitForPasswordResetEmail()
//                .confirmInsidePasswordResetEmail()
//                .clickPasswordResetLinkWorks();
//
//        Web.ascendify.forgotYourPassword
//                .resetNewPasswordWorks("Testing123");
//
//        Web.ascendify.gmailForgotYourPasswordEmail
//                .confirmSignin()
//                .clickMoreSettings()
//                .clickMoreSettingsDelete()
//                .confirmNoEmails();
//        Thread.sleep(1000);

        Web.ascendify.openTalentCommunityWorksSingin();

        Web.ascendify.signIn
                .inputEmail("qa.ascendify@gmail.com")
                .inputPassword("Testing123")
                .clickSignin()
                .confirmSigninTC();
        Thread.sleep(2000);

        //Ascendify.getDriver().navigate().refresh();


        //Web.ascendify.forgotYourPassword.confirmSignin();
    }
}

