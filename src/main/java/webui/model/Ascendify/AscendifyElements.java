package webui.model.Ascendify;

/**
 * This class will contain all needed web elements.
 * It is a good practice to follow the name convention, e.g. hometab_dropdown, signin_button etc.
 */
public class AscendifyElements {
    public static final String
            signin_emailfield = "input[id=id_username]",
            signin_passfield = "input[id=id_password]",
            signin_button = "button[id=asc-signin-btn]",
            mainmenu_profileimage = "asc-my-profile-logo-container",
            signout_button = "a[id=asc-sign-out-button]",
            profileimage_dropdown = "img[id=asc-my-account-image]";

    public static final String
            mainmenu_dropdown = "asc-main-menu-auto",
            mainmenu_peopletab = "//div[text()='People Tab']",
            mainmenu_requisitionstab = "//div[text()='Requisitions']",
            mainmenu_announcementitle = "//span[text()='Announcements']",
            mainmenu_assessmentstab = "//div[text()='Assessments']",
            peopletab_selectall = "div[id=asc-select-all]",
            peopletab_statusdropdown = "asc-crm-status-text",
            peopletab_showingcount = "span[id=asc-showing-count]",
            requisitionstab_resetfilters = "div[id=asc-show-all]",
            assessmentstab_assessmentschart = "div[class=chart__assessment]";

    public static final String
            tc_signin_button = "a[id=menu_sign_in]",
            tc_forgotyourpassowrd_link = "a[class=forgot]",
            tc_createaccount_button = "div[id=asc-init-signin]",
            tc_forgotyourpassword_emailfield = "input[type=email]",
            tc_recoverpassword_button = "button[id = asc-signin-btn1]",
            tc_forgotyourpassword_confirmation = "ul[id=asc-msg]",
            tc_newpassword_field = "input[id=new_password]",
            tc_confirmnewpassword_field = "input[name='confirm_password']",
            tc_changepassword_button = "button[id=asc-signin-btn1]",
            tc_menudropdown = "a[id=asc-main-user-menu]",
            tc_alertmessage="ul[id=asc-msg]";

    public static final String
            gmail_emailfield = "input[type=email]",
            gmail_nextbutton = "div[id=identifierNext]",
            gmail_passfield = "input[name=password]",
            gmail_inboxfolder = "div[data-tooltip='Inbox']",
            //unread email
            gmail_passwordreset_email = "//tr[@class='zA zE']",
            //opened email
            //gmail_passwordreset_email = "//tr[@class='zA yO']",


            gmail_passwordteset_link_prod = "//a[text()='signin/change_password/']",
            gmail_passwordteset_link_works = "//a[text()='http://master.client.']",
            gmail_moresettings = "//div[@aria-label='More']",
            gmail_moresettings_delete = "//*[contains(text(), 'Delete this message')]",
            gmail_noemail_text = "td[class=TC]";
}
