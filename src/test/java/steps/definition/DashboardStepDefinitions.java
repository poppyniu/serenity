package steps.definition;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import serenity.DashboardPageSteps;
import serenity.TenderSteps;

import java.util.List;

/**
 * Created by Maggie_Ping on 7/25/2017.
 */
public class DashboardStepDefinitions {
    @Steps
    DashboardPageSteps dashboardPageSteps;

    @Steps
    TenderSteps tenderSteps;

    @When("^user click hamburger icon$")
    public void user_click_hamburger_icon(){
        dashboardPageSteps.click_humburgerIcon();
    }

    @And("^user access settings page$")
    public void user_access_setting_page(){
        dashboardPageSteps.click_settingLink();
    }

    @Then("^the setting link ([^\"]*) displayed in hamburger menu")
    public void check_setting_link_displayed_or_not(String expected){
        dashboardPageSteps.checkSettingLinkVisible(expected);
    }

    @And("^user go back to dashboard page$")
    public void use_go_back_to_dashboard_page(){
        dashboardPageSteps.click_HKLDLogo();
    }

    @And("^user logs out ETender$")
    public void user_logs_out_ETender(){
        dashboardPageSteps.user_Logout();
    }

    @Then("^the tender of PR number ([^\"]*) ([^\"]*) existing in the dashboard$")
    public void the_tender_of_PR_number_existing_in_the_dashboard(String prNumber, String expectedResult){
        dashboardPageSteps.checkSpecifiedTenderVisible(prNumber, expectedResult);
    }

    @Then("^the bubble number of ([^\"]*) is correct on the top of the dashboard$")
    public void the_bubble_number_of_tender_is_equal_to_the_tender_number_on_the_dashboard(String type){
        dashboardPageSteps.check_BubbleNumber(type);
    }

    @Then("^the Hello Name shown on dashboard is ([^\"]*)$")
    public void the_hello_name_shown_on_dashboard_is(String expectedName){
        dashboardPageSteps.check_HelloNameOnDashboard(expectedName);
    }

    @Then("^the Hello Name shown on hamburger is ([^\"]*)$")
    public void the_hello_name_shown_on_hamburger_is(String expectedName){
        dashboardPageSteps.check_HelloNameOnHamburger(expectedName);
    }

    @Then("^the tender of PR number ([^\"]*) shows the status as ([^\"]*)$")
    public void the_tender_of_PR_number_shows_parameters_as(String prNumber, String statusValue){
        dashboardPageSteps.check_TenderParameterValue(prNumber, statusValue);
    }

    @Then("^the tender of PR number ([^\"]*) shows correct amount on the dashboard")
    public void the_tender_of_PR_number_shows_correct_amount(String prNumber){
        String expectedAmount = tenderSteps.get_prAmountFromGeneralTab();
        dashboardPageSteps.click_HKLDLogo();
        dashboardPageSteps.check_TenderParameterValue(prNumber, expectedAmount);
    }

    @And("^user select the tender of PR number ([^\"]*) from the dashboard")
    public void select_the_tender_of_PR_number_from_the_dashboard(String prNumber){
        dashboardPageSteps.click_specifiedTender(prNumber);
    }
    @When("^User click Review status$")
    public void user_click_Review_status() throws Throwable {
        tenderSteps.ClickStatus();

    }

    @When("^Verify the tender information Status Comment Username and Date$")
    public void verify_the_tender_information_Status_Comment_Username_and_Date(final DataTable dataTable) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        List<List<String>> data = dataTable.raw();
        for (int i = 1; i < data.size(); i++) {
            System.out.println(i +" Size "+data.size());
            System.out.println(data.get(i).get(0)+data.get(i).get(1)+data.get(i).get(2));
            int a=i-1;
            System.out.println("a"+a);
            tenderSteps.Verifytenderhistory(a,data.get(i).get(0), data.get(i).get(1), data.get(i).get(2));

        }
    }

}
