package tests.web;

import org.junit.BeforeClass;
import org.junit.Test;
import webui.model.Web;

public class SigninWithLIProd {

    @BeforeClass
    public static void setUp() {
        Web.ascendify.openTalentCommunityProd();
    }

    @Test
    public void signinWithLI() {
        Web.ascendify.forgotYourPassword
                .clickSignin()
        ;

        Web.ascendify.signinWithLI
                .clickSigninWithLI()
                .swithToLI()
                .inputLIEmail()
                .inputLIPassword()
                .cickSignin();


    }

}
