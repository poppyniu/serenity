package steps.definition;

import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;
import serenity.tenderSteps;

/**
 * Created by Poppy_Zhang on 2017/6/21.
 */
public class tenderStepDefinitions {
    @Steps
    tenderSteps tendersteps;

    @Then("^Click create tender button and crate a tender$")
    public void click_create_tender_button_and_crate_a_tender() throws Throwable {
        tendersteps.click_create_tender();
    }

    @Then("^Input general tab info ([^\"]*) ([^\"]*) ([^\"]*) ([^\"]*) ([^\"]*) ([^\"]*) ([^\"]*) ([^\"]*) ([^\"]*) ([^\"]*) ([^\"]*) ([^\"]*) ([^\"]*) ([^\"]*)$")
    public void input_general_tab_info(String Description, String Location, String ProjectStart, String Duration, String WorkingHours1, String WorkingHours2, String WorkingHours3, String WorkingHours4, String Period, String Retention, String DefectsLiabilityPeriod, String LiquidatedDamages, String SuretyBond, String PRNumber) throws Throwable {
        tendersteps.input_general_tab_info(Description, Location, ProjectStart, Duration, WorkingHours1, WorkingHours2, WorkingHours3, WorkingHours4, Period, Retention, DefectsLiabilityPeriod, LiquidatedDamages, SuretyBond, PRNumber);
    }

    @Then("^Input scope of work tab info ([^\"]*) ([^\"]*) ([^\"]*)$")
    public void input_scope_of_work_tab_info(String GeneralDescriptionofWork, String GeneralSpecifications, String ParticularSpecifications) throws Throwable {
        tendersteps.input_scope_of_work_tab_info(GeneralDescriptionofWork, GeneralSpecifications, ParticularSpecifications);
    }

    @Then("^Input items services tab info ([^\"]*) ([^\"]*) ([^\"]*) ([^\"]*)$")
    public void input_items_services_tab_info(String SectionTitle1, String DescriptionofWork1, String QTY1, String UNIT1) throws Throwable {
        tendersteps.input_items_services_tab_info(SectionTitle1, DescriptionofWork1, QTY1, UNIT1);
    }

    @Then("^Input attachments tab info ([^\"]*)$")
    public void input_attachments_tab_info_test(String ProjectDescription) throws Throwable {
        tendersteps.input_attachments_tab_info(ProjectDescription);
    }

    @Then("^Clear tender test data in db$")
    public void clear_tender_test_data_in_db() throws Throwable {
        tendersteps.clear_tender_from_db();
    }


}
