package tests.web;

import org.junit.Test;
import webui.model.Web;

public class GmailTest {

    @Test
    public void checkInbox() {
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
    }

}
