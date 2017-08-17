package steps.definition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import serenity.DashboardPageSteps;

/**
 * Created by Maggie_Ping on 7/25/2017.
 */
public class DashboardStepDefinitions {
    @Steps
    DashboardPageSteps dashboardPageSteps;

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
    public void the_tender_of_PR_number_shows_parameters_as(String prNumber, String parameterValue){
        dashboardPageSteps.check_TenderParameterValue(prNumber, parameterValue);
    }

    @And("^user select the tender of PR number ([^\"]*) from the dashboard")
    public void select_the_tender_of_PR_number_from_the_dashboard(String prNumber){
        dashboardPageSteps.click_specifiedTender(prNumber);
    }
}
