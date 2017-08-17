package steps.definition;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.jruby.RubyProcess;
import serenity.SettingsSteps;

import java.util.List;

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

    @When("^user add new locations with Location Short Form, Description and HKL Company$")
    public void user_add_a_new_location(final DataTable dataTable){
        List<List<String>> data= dataTable.raw();
        for(int i=1; i<data.size();i++){
            settingsSteps.addNewLocation(data.get(i).get(0), data.get(i).get(1), data.get(i).get(2));
        }
    }

    @When("^user add new security groups with Group Name and Group Description$")
    public void user_add_a_new_security_group(final DataTable dataTable){
        List<List<String>> data= dataTable.raw();
        for(int i=1; i<data.size();i++){
            settingsSteps.addNewSecurityGroup(data.get(i).get(0), data.get(i).get(1));
        }
    }

    @When("^he selects the user ([^\"]*) from the user list$")
    public void he_selects_a_user_name_from_the_user_list(String userName){
        settingsSteps.clickUserFromUserList(userName);
    }

    @When("^he clicks Edit button for the single user$")
    public void he_clicks_Edit_button_for_single_user(){
        settingsSteps.clickEditBtnForSingleUserDetails();
    }

    @When("^he add attribute ([^\"]*) for the single user$")
    public void he_add_attributes_for_user(String attribute){
        settingsSteps.addAttributeOnUserDetails(attribute);
    }

    @When("^he removes attribute ([^\"]*) for the single user$")
    public void he_removes_attribute_for_user(String attribute){
        settingsSteps.removeAttributeOnUserDetails(attribute);
    }

    @When("^he saves the attributes for the single user$")
    public void user_save_attributes_for_single_user(){
        settingsSteps.clickSaveBtnForSingleUserDetails();
    }

    @And("^clear roles table from Database$")
    public void clear_roles_table_from_DB() throws Exception{
        settingsSteps.clearRolesDataFromDB();
    }

    @And("^clear locations table from Database$")
    public void clear_locations_table_from_DB() throws Exception{
        settingsSteps.clearLocationDataFromDB();
    }

    @And("^user set threshold value as ([^\"]*)$")
    public void set_threshold_value(String value){
        settingsSteps.setThresholdValue(value);
    }

    @And("^user add a new contractor with details info ([^\"]*), ([^\"]*), ([^\"]*), ([^\"]*), ([^\"]*), ([^\"]*), ([^\"]*), ([^\"]*), ([^\"]*) and ([^\"]*)$")
    public void user_add_a_new_contractor(String vendorID, String fullName, String shortName, String addressLine1, String addressLine2, String addressLine3, String companyPhoneNumber,
                                          String contactAdmin, String contactPhoneNumber, String emailAddress){
        System.out.println("vendorID is " + vendorID);
        System.out.println("Full name is " + fullName);
        settingsSteps.addNewContractor(vendorID, fullName, shortName, addressLine1, addressLine2, addressLine3, companyPhoneNumber, contactAdmin, contactPhoneNumber, emailAddress);
    }
}
