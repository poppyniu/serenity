package steps.definition;

import constants.UserAttributeDTO;
import cucumber.api.DataTable;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import serenity.SettingsSteps;

/**
 * Created by Maggie_Ping on 7/25/2017.
 */
public class SettingsStepDefinitions {
    @Steps
    SettingsSteps settingsSteps;

    @When("^user access ([^\"]*) setting$")
    public void user_access_settings(String option){
        settingsSteps.selectSettingsOption(option);
    }

    @When("^user add a new location with ([^\"]*) and ([^\"]*) and ([^\"]*)$")
    public void user_add_a_new_location(String locationCode, String description, String company){
        settingsSteps.addNewLocation(locationCode,description,company);
    }

    @When("^user add a new security group with ([^\"]*) and ([^\"]*)$")
    public void user_add_a_new_security_group(String groupName, String groupDescription){
        settingsSteps.addNewSecurityGroup(groupName, groupDescription);
    }

    @When("^he selects a user name ([^\"]*) from the user list$")
    public void he_selects_a_user_name_from_the_user_list(String userName){
        System.out.println(userName);
        settingsSteps.clickUserFromUserList(userName);
    }

    @When("^he clicks Edit button for the single user$")
    public void he_clicks_Edit_button_for_single_user(){
        settingsSteps.clickEditBtnForSingleUserDetails();
    }

    @When("^he add attribute for the single user$")
    public void he_add_attribute_for_user(final DataTable dataTable){
        for(final UserAttributeDTO attributeDTO : dataTable.asList(UserAttributeDTO.class)){
            settingsSteps.addAttributeOnUserDetails(attributeDTO);
        }
    }

    @When("^he removes attribute for the single user$")
    public void he_removes_attribute_for_user(final DataTable dataTable){
        for(final UserAttributeDTO attributeDTO : dataTable.asList(UserAttributeDTO.class)){
            settingsSteps.removeAttributeOnUserDetails(attributeDTO);
        }
    }

    @When("^he saves the attributes for the single user$")
    public void user_save_attributes_for_single_user(){
        settingsSteps.clickSaveBtnForSingleUserDetails();
    }
}
