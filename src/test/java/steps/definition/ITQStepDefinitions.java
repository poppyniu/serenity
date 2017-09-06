package steps.definition;

import cucumber.api.java.en.And;
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


    @Then("^Click create itq button and create a itq$")
    public void click_create_itq_button_and_crate_a_itq() throws Throwable {
        itqSteps.click_create_itq();
    }

    @And("^HKLD engineer preview and issue itq")
    public void hkld_engineer_preview_and_issue_itq() throws Throwable {
        itqSteps.preview_and_issue_itq();
    }

    @And("^HKLD engineer login to check if contractor has submitted itq")
    public void hkld_engineer_login_to_check_if_contractor_has_submitted_itq() throws Throwable {
        itqSteps.check_vendor_submit_status();
    }
}
