package serenity;

import constants.UserAttributeDTO;
import net.thucydides.core.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.SettingsPage;

/**
 * Created by Maggie_Ping on 7/25/2017.
 */
public class SettingsSteps {
    SettingsPage settingsPage;

    @Step
    public void selectSettingsOption(String option){
        settingsPage.clickSettingDropDown();
        switch (option){
            case "Users":
                settingsPage.selectUserOption();
                break;
            case "Location":
                settingsPage.selectLocationOption();
                break;
            case "Security Groups":
                settingsPage.selectSecurityGroupOption();
                break;
            case "Threshold":
                settingsPage.selectThresholdOption();
                break;
            default:
                LOGGER.warn(("Unexpected setting option: " + option));
        }
    }


    @Step
    public void addNewLocation(String locationCode, String description, String company){
        settingsPage.clickLocationAddBtn();
        settingsPage.inputNewLocationInfo(locationCode, description, company);
    }

    @Step
    public void addNewSecurityGroup(String groupName, String groupDescription){
        settingsPage.clickSecurityGroupAddBtn();
        settingsPage.inputNewSecurityGroupInfo(groupName,groupDescription);
    }

    @Step
    public void clickUserFromUserList(String userName){
        settingsPage.clickUserName(userName);
    }

    @Step
    public void clickEditBtnForSingleUserDetails(){
        settingsPage.clickUserDetailsEditBtn();
    }

    @Step
    public void addAttributeOnUserDetails(final UserAttributeDTO attributeDTO){
        //settingsPage.clickAttributeCheckbox(attributeDTO.getAttribute());
        settingsPage.addAttribute(attributeDTO.getAttribute());
    }

    @Step
    public void removeAttributeOnUserDetails(final UserAttributeDTO attributeDTO){
        settingsPage.removeAttribute(attributeDTO.getAttribute());
    }

    @Step
    public void clickSaveBtnForSingleUserDetails(){
        settingsPage.clickUserDetailsSaveBtn();
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(SettingsSteps.class);
}
