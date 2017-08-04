package steps.definition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;
import serenity.TenderSteps;

/**
 * Created by Poppy_Zhang on 2017/6/21.
 */
public class TenderStepDefinitions {
    @Steps
    TenderSteps tenderSteps;

    @And("^Click create tender button and create a tender$")
    public void click_create_tender_button_and_create_a_tender() throws Throwable {
        tenderSteps.click_create_tender();
    }

    @And("^Input general tab info ([^\"]*) ([^\"]*) ([^\"]*) ([^\"]*) ([^\"]*) ([^\"]*) ([^\"]*) ([^\"]*) ([^\"]*) ([^\"]*) ([^\"]*) ([^\"]*) ([^\"]*) ([^\"]*)$")
    public void input_general_tab_info(String Description, String Location, String ProjectStart, String Duration, String WorkingHours1, String WorkingHours2, String WorkingHours3, String WorkingHours4, String Period, String Retention, String DefectsLiabilityPeriod, String LiquidatedDamages, String SuretyBond, String PRNumber) throws Throwable {
        tenderSteps.input_general_tab_info(Description, Location, ProjectStart, Duration, WorkingHours1, WorkingHours2, WorkingHours3, WorkingHours4, Period, Retention, DefectsLiabilityPeriod, LiquidatedDamages, SuretyBond, PRNumber);
    }

    @And("^Input scope of work tab info ([^\"]*) ([^\"]*) ([^\"]*)$")
    public void input_scope_of_work_tab_info(String GeneralDescriptionofWork, String GeneralSpecifications, String ParticularSpecifications) throws Throwable {
        tenderSteps.input_scope_of_work_tab_info(GeneralDescriptionofWork, GeneralSpecifications, ParticularSpecifications);
    }

    @And("^Input items services tab info ([^\"]*) ([^\"]*) ([^\"]*) ([^\"]*)$")
    public void input_items_services_tab_info(String SectionTitle1, String DescriptionofWork1, String QTY1, String UNIT1) throws Throwable {
        tenderSteps.input_items_services_tab_info(SectionTitle1, DescriptionofWork1, QTY1, UNIT1);
    }

    @And("^Input attachments tab info ([^\"]*) and save tender$")
    public void input_attachments_tab_info_test(String ProjectDescription) throws Throwable {
        tenderSteps.input_attachments_tab_info(ProjectDescription);
    }

    @And("^Submit the new tender for approve$")
    public void submit_the_new_tender_for_approve() throws Throwable {
        tenderSteps.submit_tender_for_approve();
    }

    @And("^HKLD Admin login to approve tender$")
    public void hkld_Admin_login_to_approve_tender() throws Throwable {
        tenderSteps.admin_approve();
    }

    @And("^HKLD engineer login to issue tender$")
    public void hkld_engineer_login_to_issue_tender() throws Throwable {
        tenderSteps.engineer_issue();
    }

    @And("^HKLD engineer login to check if contractor has submitted tender$")
    public void hkld_engineer_login_to_check_if_contractor_has_submitted_tender() throws Throwable {
        tenderSteps.check_vendor_submit_status();
    }

    @And("^Change tender status in db$")
    public void change_tender_status_in_db() throws Throwable {
        tenderSteps.change_tender_status_in_db();
    }

    @And("^HKLD engineer check current tender status$")
    public void hkld_engineer_check_current_tender_status() throws Throwable {
        tenderSteps.check_tender_status();
    }

    @And("^Contractor login to submit tender$")
    public void contractor_login_to_submit_tender() throws Throwable {
        tenderSteps.contractor_submit();
    }

    @Then("^Clear tender test data in db$")
    public void clear_tender_test_data_in_db() throws Throwable {
        tenderSteps.clear_tender_from_db();
    }

    @And("^user input PR number ([^\"]*)$")
    public void user_input_PR_number(String prNumber){
        tenderSteps.input_PRNumber(prNumber);
    }

    @Then("^user gets the expected header message ([^\"]*)$")
    public void user_gets_the_expected_header_message(String Expectedmessage){
        tenderSteps.validate_HeaderMessage(Expectedmessage);
    }

}
