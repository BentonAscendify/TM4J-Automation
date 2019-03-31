package tests.web;

import org.junit.BeforeClass;
import org.junit.Test;
import webui.model.Web;

public class ForgotYourPasswordTCProd {

    @BeforeClass
    public static void setUp() {
        Web.ascendify.openTalentCommunityProd();
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
//
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
//                .clickPasswordResetLinkProd();
//
//        Web.ascendify.forgotYourPassword
//                .resetNewPasswordProd("Testing123");
//
//        Web.ascendify.gmailForgotYourPasswordEmail
//                .confirmSignin()
//                .clickMoreSettings()
//                .clickMoreSettingsDelete()
//                .confirmNoEmails();
    }
}

