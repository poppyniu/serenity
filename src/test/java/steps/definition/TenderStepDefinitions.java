package steps.definition;

import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;
import serenity.TenderSteps;

/**
 * Created by Poppy_Zhang on 2017/6/21.
 */
public class TenderStepDefinitions {
    @Steps
    TenderSteps tenderSteps;

    @Then("^Click create tender button and crate a tender$")
    public void click_create_tender_button_and_crate_a_tender() throws Throwable {
        tenderSteps.click_create_tender();
    }

    @Then("^Input general tab info ([^\"]*) ([^\"]*) ([^\"]*) ([^\"]*) ([^\"]*) ([^\"]*) ([^\"]*) ([^\"]*) ([^\"]*) ([^\"]*) ([^\"]*) ([^\"]*) ([^\"]*) ([^\"]*)$")
    public void input_general_tab_info(String Description, String Location, String ProjectStart, String Duration, String WorkingHours1, String WorkingHours2, String WorkingHours3, String WorkingHours4, String Period, String Retention, String DefectsLiabilityPeriod, String LiquidatedDamages, String SuretyBond, String PRNumber) throws Throwable {
        tenderSteps.input_general_tab_info(Description, Location, ProjectStart, Duration, WorkingHours1, WorkingHours2, WorkingHours3, WorkingHours4, Period, Retention, DefectsLiabilityPeriod, LiquidatedDamages, SuretyBond, PRNumber);
    }

    @Then("^Input scope of work tab info ([^\"]*) ([^\"]*) ([^\"]*)$")
    public void input_scope_of_work_tab_info(String GeneralDescriptionofWork, String GeneralSpecifications, String ParticularSpecifications) throws Throwable {
        tenderSteps.input_scope_of_work_tab_info(GeneralDescriptionofWork, GeneralSpecifications, ParticularSpecifications);
    }

    @Then("^Input items services tab info ([^\"]*) ([^\"]*) ([^\"]*) ([^\"]*)$")
    public void input_items_services_tab_info(String SectionTitle1, String DescriptionofWork1, String QTY1, String UNIT1) throws Throwable {
        tenderSteps.input_items_services_tab_info(SectionTitle1, DescriptionofWork1, QTY1, UNIT1);
    }

    @Then("^Input attachments tab info ([^\"]*) and save tender$")
    public void input_attachments_tab_info_test(String ProjectDescription) throws Throwable {
        tenderSteps.input_attachments_tab_info(ProjectDescription);
    }

    @Then("^Submit the new tender for approve$")
    public void submit_the_new_tender_for_approve() throws Throwable {
        tenderSteps.submit_tender_for_approve();
    }

    @Then("^HKLD Admin login to approve tender$")
    public void hkld_Admin_login_to_approve_tender() throws Throwable {
        tenderSteps.admin_approve();
    }

    @Then("^HKLD engineer login to issue tender$")
    public void hkld_engineer_login_to_issue_tender() throws Throwable {
        tenderSteps.engineer_issue();
    }

    @Then("^Clear tender test data in db$")
    public void clear_tender_test_data_in_db() throws Throwable {
        tenderSteps.clear_tender_from_db();
    }




}