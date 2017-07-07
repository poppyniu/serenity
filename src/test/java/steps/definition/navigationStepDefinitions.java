package steps.definition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import serenity.navigationSteps;

/**
 * Created by Poppy_Zhang on 2017/6/14.
 */
public class navigationStepDefinitions {
    @Steps
    navigationSteps navigationSteps;

    @Given("^Open ETender home page with Browser$")
    public void open_ETender_home_page_with_Browser() throws Throwable {
        navigationSteps.opens_home_page();
    }
    @When("^Click hamburger button and click ITQ/Tenders$")
    public void click_hamburger_button_and_click_ITQ_Tenders() throws Throwable {
        navigationSteps.clickHamburger();
    }

    @Then("^Navigate to ITQ/Tenders page$")
    public void navigate_to_ITQ_Tenders_page() throws Throwable {
        navigationSteps.navigateITQTenders();
    }

}
