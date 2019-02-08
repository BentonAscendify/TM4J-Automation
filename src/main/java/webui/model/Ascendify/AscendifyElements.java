package webui.model.Ascendify;

/**
 * This class will contain all needed web elements.
 * It is a good practice to follow the name convention, e.g. hometab_dropdown, signin_button etc.
 */
public class AscendifyElements {
    public static final String
            signin_emailF = "input[id=id_username]",
            signin_passF = "input[id=id_password]",
            signin_button = "button[id=asc-signin-btn]",
            profile_image = "asc-my-profile-logo-container",
            signout_button = "a[id=asc-sign-out-button]",
            profile_image_dropdown = "img[id=asc-my-account-image]";

    public static final String
            hometab_dropdown = "asc-main-menu-auto",
            hometab_peopletab = "//div[text()='People Tab']",
            hometab_requisitionstab = "//div[text()='Requisitions']",
            hometab_announcementitle = "//span[text()='Announcements']",
            hometab_assessmentstab = "//div[text()='Assessments']",
            peopletab_selectall = "div[id=asc-select-all]",
            peopletab_statusdropdown = "asc-crm-status-text",
            peopletab_showingcount = "span[id=asc-showing-count]",
            requisitionstab_resetfilters = "div[id=asc-show-all]",
            assessments_assessmentschart_ = "div[class=chart__assessment]";


}
