package steps.definition;

import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import serenity.DashboardPageSteps;

/**
 * Created by Maggie_Ping on 7/25/2017.
 */
public class DashboardStepDefinitions {
    @Steps
    DashboardPageSteps dashboardPageSteps;

    @When("^user access settings page$")
    public void user_access_setting_page(){
        dashboardPageSteps.click_settingLink();
    }
}
