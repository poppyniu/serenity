package steps.definition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import serenity.itqSteps;
import serenity.navigationSteps;

/**
 * Created by Poppy_Zhang on 2017/6/21.
 */
public class itqStepDefinitions {
    @Steps
    itqSteps itqsteps;

    @When("^Click create new button and click enter$")
    public void click_create_new_button_and_click_enter() throws Throwable {
        itqsteps.create_new_itq();
    }

    @Then("^Navigate to create ITQ page$")
    public void navigate_to_create_ITQ_page() throws Throwable {
        itqsteps.navigate_create_itq();
    }

    @Then("^Select a dropdownlist$")
    public void select_dropdownlist() throws Throwable {
        itqsteps.select_dropdownlist();
    }
}
