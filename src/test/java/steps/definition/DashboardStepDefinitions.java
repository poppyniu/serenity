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
}
