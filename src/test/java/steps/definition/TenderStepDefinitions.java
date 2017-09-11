package steps.definition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;
import serenity.DashboardPageSteps;
import serenity.TenderSteps;

/**
 * Created by Poppy_Zhang on 2017/6/21.
 */
public class TenderStepDefinitions {
    @Steps
    TenderSteps tenderSteps;
    @Steps
    DashboardPageSteps dashboardPageSteps;

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

    @And("^user upload attachments and input description ([^\"]*)$")
    public void upload_attachments_and_input_description(String description) throws  Throwable{
        tenderSteps.upload_attachments(description);
    }

    @And("^Submit the new tender for approve$")
    public void submit_the_new_tender_for_approve() throws Throwable {
        tenderSteps.submit_tender_for_approve();
    }

    @And("^preview and submit the tender$")
    public void preview_and_submit_the_tender(){
        tenderSteps.preview_and_submit_tender();
    }

    @And("^Change tender personInCharge in db$")
    public void change_tender_personInCharge_in_db() throws Throwable {
        tenderSteps.change_tender_personInCharge_in_db();
    }

    @And("^HKLD Admin login to approve tender$")
    public void hkld_Admin_login_to_approve_tender() throws Throwable {
        tenderSteps.admin_approve();
    }

    @And("^the manager approve the tender of PR number ([^\"]*)$")
    public void user_gets_approval(String prNumber){
        dashboardPageSteps.click_specifiedTender(prNumber);
        tenderSteps.manager_approve_tender();
    }

    @And("^HKLD engineer login to issue tender$")
    public void hkld_engineer_login_to_issue_tender() throws Throwable {
        tenderSteps.engineer_issue();
    }

    @And("^user issue the tender of PR number ([^\"]*)$")
    public void user_issue_tender(String prNumber){
        dashboardPageSteps.click_specifiedTender(prNumber);
        tenderSteps.issue_tender();
    }

    @And("^HKLD engineer login to check if contractor has submitted tender$")
    public void hkld_engineer_login_to_check_if_contractor_has_submitted_tender() throws Throwable {
        tenderSteps.check_vendor_submit_status();
    }

    @And("^Change tender status in db by ([^\"]*)$")
    public void change_tender_status_in_db(String prNo) throws Throwable {
        tenderSteps.change_tender_status_in_db(prNo);
    }

    @And("^HKLD engineer check current tender status$")
    public void hkld_engineer_check_current_tender_status() throws Throwable {
        tenderSteps.check_tender_status();
    }

    @And("^([^\"]*) login to submit tender$")
    public void contractor_login_to_submit_tender(String tenderType) throws Throwable {
        tenderSteps.contractor_submit(tenderType);
    }

    @Then("^Clear tender test data in db$")
    public void clear_tender_test_data_in_db() throws Throwable {
        tenderSteps.clear_tender_from_db();
    }

    @And("^clear tender data of the PR number ([^\"]*)$")
    public void clear_specified_tender(String prNumber) throws Throwable{
        tenderSteps.clear_specified_tender_fromDB(prNumber);
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

    @And("^user at section #([^\"]*) choose the action ([^\"]*) from section drop down menu$")
    public void user_choose_the_action_from_section_options(String index, String action){
        tenderSteps.click_sectionAction(Integer.parseInt(index),action);
    }

    @Then("^([^\"]*) sections should be existing$")
    public void check_section_number(String number){
        tenderSteps.check_sectionsQuantity(Integer.parseInt(number));
    }

    @Then("^([^\"]*) items should be existing under section #([^\"]*)$")
    public void check_items_numer_in_section(String itemsNumer, String sectionIndex){
        tenderSteps.check_itemsQuantity(Integer.parseInt(itemsNumer), Integer.parseInt(sectionIndex));
    }

    @And("^user at section #([^\"]*) item #([^\"]*) choose the action ([^\"]*) from item drop down menu$")
    public void user_choose_the_action_from_item_options(String sectionIndex, String itemIndex, String action){
        tenderSteps.click_itemAction(Integer.parseInt(sectionIndex), Integer.parseInt(itemIndex), action);
    }

    @And("^user add ([^\"]*) more sections$")
    public void user_add_more_sections(String sectionQuantity){
        tenderSteps.add_sections(Integer.parseInt(sectionQuantity));
    }

    @And("^user at section #([^\"]*) add ([^\"]*) more items$" )
    public void user_at_section_add_more_items(String sectionIndex, String itemsQuantity){
        tenderSteps.add_items(Integer.parseInt(sectionIndex), Integer.parseInt(itemsQuantity));
    }

    @And("^user add ([^\"]*) more sections and at every section add ([^\"]*) more items and input value for all$")
    public void user_add_items_services_and_input_value(String sectionsQuantity, String itemsQuantity){
        tenderSteps.add_SectionsItems_And_InputValue(Integer.parseInt(sectionsQuantity), Integer.parseInt(itemsQuantity));
    }

    @Then("^([^\"]*) options should be existing under section #([^\"]*) item #([^\"]*)$")
    public void check_options_number_under_section_item(String optionNumber, String sectionIndex, String itemIndex){
        tenderSteps.check_optionsQuantity(Integer.parseInt(optionNumber), Integer.parseInt(sectionIndex), Integer.parseInt(itemIndex));
    }

    @And("^user at section #([^\"]*) item #([^\"]*) option #([^\"]*) input option description$")
    public void user_input_option_description(String sectionIndex, String itemIndex, String optionIndex){
        tenderSteps.input_optionDescriptioin(Integer.parseInt(sectionIndex), Integer.parseInt(itemIndex), Integer.parseInt(optionIndex));
    }

    @And("^user at section #([^\"]*) item #([^\"]*) option #([^\"]*) choose the action ([^\"]*) from option drop down menu")
    public void user_choose_the_action_from_option_menu(String sectionIndex, String itemIndex, String optionIndex, String action){
        tenderSteps.click_optionAction(Integer.parseInt(sectionIndex), Integer.parseInt(itemIndex), Integer.parseInt(optionIndex), action);
    }

    @And("^user run analysis and get analysis table$")
    public void user_run_analysis_and_get_analysis_table() throws Exception{
        tenderSteps.runAnalysisFromReview();
    }

    @And("^contractor fill in tender info and submit$")
    public void contractor_fill_in_tender_info_and_submit(){
        tenderSteps.click_itemsServices_tab();
        tenderSteps.vendor_inputRateForItemsLine();
        tenderSteps.vendor_inputTermsAndSubmit();
    }

    @And("^Click view all tenders button$")
    public void click_view_all_tenders_button() throws Throwable {
        tenderSteps.click_view_all_tenders_button();
    }

    @Then("^Check view all tenders page search function$")
    public void check_view_all_tenders_page_search_function() throws Throwable {
        tenderSteps.view_all_page_search();
    }

    @And("^Open the new created dashboard tender item$")
    public void open_the_new_created_dashboard_tender_item() throws Throwable {
        tenderSteps.click_tender_item();
    }

    @Then("^Cancel this tender and check cancel result$")
    public void cancel_this_tender() throws Throwable {
        tenderSteps.cancel_tender();
    }

    @And("^HKLD Admin login to reject tender$")
    public void hkld_Admin_login_to_reject_tender() throws Throwable {
        tenderSteps.reject_tender();
    }

    @Then("^HKLD engineer to check tender ([^\"]*)$")
    public void hkld_engineer_to_check_tender_is_rejected(String status) throws Throwable {
        tenderSteps.engineer_check_tender_status(status);
    }

    @And("^HKLD Admin login to reset tender to draft$")
    public void hkld_Admin_login_to_reset_tender_to_draft() throws Throwable {
        tenderSteps.reset_to_draft();
    }

    @And("^user input sample info for items and services$")
    public void user_input_sample_info_for_items_and_services() {
        tenderSteps.input_SampleItemsServices(4, 2);
    }

    @And("^HKLD engineer do tender addendum$")
    public void hkld_engineer_do_tender_addendum() throws Throwable {
        tenderSteps.do_addendum();
    }

    @And("^the contractor decline the bid with decline reason ([^\"]*)$")
    public void the_contractor_decline_the_bid(String declineReason){
        tenderSteps.vendor_decline_bid(declineReason);
    }
}
