package steps.definition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import serenity.ITQSteps;

/**
 * Created by Poppy_Zhang on 2017/6/21.
 */
public class ITQStepDefinitions {
    @Steps
    ITQSteps itqSteps;


    @Then("^Click create itq button and crate a itq$")
    public void click_create_itq_button_and_crate_a_itq() throws Throwable {
        itqSteps.click_create_itq();
    }

}
