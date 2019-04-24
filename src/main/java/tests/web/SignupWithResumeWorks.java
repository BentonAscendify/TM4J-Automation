package tests.web;

import org.junit.BeforeClass;
import org.junit.Test;
import webui.model.Web;

public class SignupWithResumeWorks {

    @BeforeClass
    public static void setUp() {
        Web.ascendify.openTalentCommunityWorks();
    }

    @Test
    public void signUp() {
        Web.ascendify.signupWithResume
                .clickJoinOurTeam()
                .clickDragResumeIcon()
                .confirmDragResume()
                .inputFirstLastName()
                .inputEmail()
                .inputPassword()
                .drawSignature()
                .clickSubmit();

        Web.ascendify.signIn
                .confirmSigninTC();

        Web.ascendify.signupWithResume
                .clickProfiletab()
                .confirmClickProfiletab()
                .clickDocumentstab()
                .confirmClickDocumentstab()
                .clickPersonaltab()
                .confirmClickPersonaltab();

        Web.ascendify.signOut
                .clickTCProfileImage()
                .clickSignout();

        Web.ascendify.signupWithResume
                .clickJoinOurTeam();
    }
}
