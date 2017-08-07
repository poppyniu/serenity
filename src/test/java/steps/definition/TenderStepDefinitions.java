package steps.definition;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;
import serenity.TenderSteps;

import java.util.List;

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

    @And("^user save the PR info$")
    public void user_save_the_PR_info(){
        tenderSteps.save_PRInfo();
    }

    @And("^user save the tender$")
    public void user_save_the_tender(){
        tenderSteps.saveTender();
    }

    @And("^user goes to items/services tab$")
    public void user_goes_to_items_services_tab(){
        tenderSteps.click_itemsServices_tab();
    }

    @And("^user at section ([^\"]*) input section tile$")
    public void user_input_section_title(String index){
        tenderSteps.input_sectionTitle(Integer.parseInt(index));
    }

    @And("^user at section ([^\"]*) choose the action ([^\"]*) from section drop down menu$")
    public void user_choose_the_action_from_section_options(String index, String action){
        tenderSteps.click_sectionAction(Integer.parseInt(index),action);
    }

    @Then("^([^\"]*) sections should be existing$")
    public void check_section_number(String number){
        tenderSteps.check_sectionsQuantity(Integer.parseInt(number));
    }

    @Then("^([^\"]*) items should be existing under section ([^\"]*)$")
    public void check_items_numer_in_section(String itemsNumer, String sectionIndex){
        tenderSteps.check_itemsQuantity(Integer.parseInt(itemsNumer), Integer.parseInt(sectionIndex));
    }

    @And("^user at section ([^\"]*) item ([^\"]*) choose the action ([^\"]*) from item drop down menu$")
    public void user_choose_the_action_from_item_options(String sectionIndex, String itemIndex, String action){
        tenderSteps.click_itemAction(Integer.parseInt(sectionIndex), Integer.parseInt(itemIndex), action);
    }

    @And("^user add ([^\"]*) more sections$")
    public void user_add_more_sections(String sectionQuantity){
        tenderSteps.add_sections(Integer.parseInt(sectionQuantity));
    }

    @And("^user at section ([^\"]*) add ([^\"]*) more items$" )
    public void user_at_section_add_more_items(String sectionIndex, String itemsQuantity){
        tenderSteps.add_items(Integer.parseInt(sectionIndex), Integer.parseInt(itemsQuantity));
    }

    @And("^user input Description, QTY and UNIT for every line item$")
    public void user_input_item_info(final DataTable dataTable){
        List<List<String>> data= dataTable.raw();
        for(int i=1; i<data.size();i++){
            tenderSteps.input_ItemInfo(Integer.parseInt(data.get(i).get(0)), Integer.parseInt(data.get(i).get(1)));
        }
    }

    @Then("^([^\"]*) options should be existing under section ([^\"]*) item ([^\"]*)$")
    public void check_options_number_under_section_item(String optionNumber, String sectionIndex, String itemIndex){
        tenderSteps.check_optionsQuantity(Integer.parseInt(optionNumber), Integer.parseInt(sectionIndex), Integer.parseInt(itemIndex));
    }

    @And("^user at section ([^\"]*) item ([^\"]*) option ([^\"]*) input option description$")
    public void user_input_option_description(String sectionIndex, String itemIndex, String optionIndex){
        tenderSteps.input_optionDescriptioin(Integer.parseInt(sectionIndex), Integer.parseInt(itemIndex), Integer.parseInt(optionIndex));
    }

    @And("^user at section ([^\"]*) item ([^\"]*) option ([^\"]*) choose the action ([^\"]*) from option drop down menu")
    public void user_choose_the_action_from_option_menu(String sectionIndex, String itemIndex, String optionIndex, String action){
        tenderSteps.click_optionAction(Integer.parseInt(sectionIndex), Integer.parseInt(itemIndex), Integer.parseInt(optionIndex), action);
    }
}
