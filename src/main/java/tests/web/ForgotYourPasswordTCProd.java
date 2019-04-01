package tests.web;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import webui.model.Ascendify.Ascendify;
import webui.model.Web;

public class ForgotYourPasswordTCProd {

//    @BeforeClass
//    public static void setUp() {
//        Web.ascendify.openTalentCommunityProd();
//    }

    @AfterClass
    public static void tearDown() {
        System.out.println("closing the Driver");
        Ascendify.getDriver().quit();
    }

    @Test
    public void forgot_password() throws InterruptedException {
        System.out.println("executing fyp");

        Web.ascendify.gmailGlobal
                .goToGmail()
                .confirmGoToGmail()
                .insertEmail("qa.ascendify@gmail.com")
                .clickNext()
                .confirmClickNext()
                .insertPasswordAndClickEnter("Testing12345")
                .confirmSignin()
                .deleteAllInbox()
                .confirmNoEmails();
        Thread.sleep(5000);

        Ascendify.getDriver().navigate().refresh();

        Web.ascendify.openTalentCommunityProd();

        Web.ascendify.forgotYourPassword
                .clickSignin()
                .confirmClickSignin()
                .clickForgotPassword()
                .confirmClickForgotPassword()
                .inputEmail("qa.ascendify@gmail.com")
                .clickRecoverPasword()
                .confirmClickRecoverPassword();

        Web.ascendify.gmailGlobal
                .goToGmail()
                .confirmSignin();

        Web.ascendify.gmailForgotYourPasswordEmail
                .waitForPasswordResetEmail()
                .confirmInsidePasswordResetEmail()
                .clickPasswordResetLinkProd();

        Web.ascendify.forgotYourPassword
                .resetNewPasswordProd("Testing123");

        Web.ascendify.gmailGlobal
                .confirmSignin()
                .clickMoreSettings()
                .clickMoreSettingsDelete()
                .confirmNoEmails();
    }
}

