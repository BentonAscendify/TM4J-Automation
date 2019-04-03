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
            assessmentstab_assessmentschart_ = "div[class=chart__assessment]",
            requistion_new = "asc-dropdown-button-menu",
            requisition_addmanually = "a[id=asc-add-req-manually]",
            requisition_selectOrg = "span[id=asc-organization]",
            requisition_selectTemplate = "asc-pipeline-template",
            requisition_addTitle = "input[id=asc-title]",
            requisition_addPosting = "input[id=asc-posting-title]",
            requisition_addLocation = "input[id=asc-job-location]",
            requisition_selectIndustry = "span[id=asc-job-cat]",
            requisition_addPrimaryhiring = "input[id=hiring_manager]",
            requisition_clickButton = "asc-add-user-button",
            requisition_editDescription = "btn btn-primary asc-edit-icon btn-sm",
            requisition_addDescription = "cke_358_contents",
            requisition_clickSave = "asc-dynamic-save-button",
            requisition_editResponsbilities = "btn btn-primary asc-edit-icon btn-sm",
            requisition_addResponsbilities = "cke_44_contents",
            requisition_clickSaveR = "asc-dynamic-save-button",
            requisition_clickTeam = "id=tab-team",
            requisition_addSourcer = "input[id = add-group-member-aclg_8d2ca0469d-primary-sourcer]",
            requisition_clickQualifying = "tab-questions",
            requisition_addQualifying = "asc-job-qualifying-questions-select",
            requisition_turnOn = "input[id=auto-reject-toggle]",
            requisition_selectDecline = "auto-reject-email",
            requisition_clickSaveQ = "knock-out-save-button",
            requisition_clickScreening = "tab-screening",
            requisition_addScreening = "asc-job-screening-questions-select",
            requisition_clickIntake = "tab-intake",
            requisition_clickNotes = "tab-notes",
            requisition_addnotes = "asc-note-comment",
            requisition_clickSavenotes = "asc-note-save-btn",
            requisition_clickWorkflow = "tab-workflows",
            requisition_selectworkflow = "asc-workflow-holder",
            requisition_saveworkflow = "modal__button modal__button--submit btn btn-primary",
            requisition_clickApprovals = "tab-approvals",
            requisition_selectApproval = "input[id=add-approver]",
            requisition_beginRouting = "asc-launch-approval-btn",
            requisition_changeStatus = "asc-status-btn",
            requisition_viewAll = "view_all",
            requisition_Myrequisition = "fav-link",
            requisition_Recentviewd = "view_recently",
            requisition_Recenlyadded = "view_added",
            requisition_Recruiterlist = "recruiters",
            requisition_Openstatuses = "job-status-folder",
            requisition_Org = "job-organizations",
            requisition_Selectreq = "input[id=full-header-search-input]",
            requisition_CandidateReport = "candidate-info-reg-job",
            requisition_Talentmatching = "talent-matching",
            requisition_Totalcandidate = "candidate-folder-link link";

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
