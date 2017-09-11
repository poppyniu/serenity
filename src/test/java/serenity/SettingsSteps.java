package serenity;

import constants.DBHelper;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import pages.SettingsPage;

import java.util.Arrays;
import java.util.List;

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
                Assert.fail("Unexpected setting option: " + option);
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
    public void addAttributeOnUserDetails(String attribute){
        List<String> attributeList = Arrays.asList(attribute.split(","));
        for(String subAttribute : attributeList) {
            settingsPage.addAttribute(subAttribute);
        }
    }

    @Step
    public void removeAttributeOnUserDetails(String attribute){
        List<String> attributeList = Arrays.asList(attribute.split(","));
        for(String subAttribute : attributeList) {
            settingsPage.removeAttribute(subAttribute);
        }
    }

    @Step
    public void clickSaveBtnForSingleUserDetails(){
        settingsPage.clickUserDetailsSaveBtn();
        settingsPage.clickBackLinkOnUserDetails();
    }

    @Step
    public void clearRolesDataFromDB() throws Exception {
        DBHelper.clearRolesTableFromDB();
    }

    @Step
    public void clearLocationDataFromDB() throws Exception{
        DBHelper.clearDataFromDB("locations");
    }

    @Step
    public void setThresholdValue(String value){
        settingsPage.inputThresholdValue(value);
    }

    @Step
    public void addNewContractor(String vendorID, String fullName, String shortName, String addressLine1, String addressLine2, String addressLine3, String companyPhoneNumber,
                                 String contactAdmin, String contactPhoneNumber, String emailAddress){
        settingsPage.clickContractorTab();
        settingsPage.clickAddBtnUnderContractorTab();
        settingsPage.inputNewVendorInfo(vendorID, fullName, shortName, addressLine1, addressLine2, addressLine3, companyPhoneNumber, contactAdmin, contactPhoneNumber, emailAddress);
    }

    @Step
    public void setActionsForSecurityGroup(String securityGroup, String authorityActions){
        List<String> actionsList = Arrays.asList(authorityActions.split(","));
        settingsPage.addAuthority(securityGroup, actionsList);
    }

}
