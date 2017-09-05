package serenity;

import constants.SampleTenderInfo;
import net.thucydides.core.annotations.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import pages.TenderPage;

/**
 * Created by Poppy_Zhang on 2017/6/21.
 */
public class TenderSteps {
    TenderPage tenderPage;

    @Step
    public void click_create_tender() throws Exception {
        tenderPage.clickCreateTender();
    }

    @Step
    public void input_general_tab_info(String Description, String Location, String ProjectStart, String Duration, String WorkingHours1, String WorkingHours2, String WorkingHours3, String WorkingHours4, String Period, String Retention, String DefectsLiabilityPeriod, String LiquidatedDamages, String SuretyBond, String PRNumber) throws Exception {
        tenderPage.inputGeneralTabInfo(Description,Location,ProjectStart,Duration,WorkingHours1,WorkingHours2,WorkingHours3,WorkingHours4,Period,Retention,DefectsLiabilityPeriod,LiquidatedDamages,SuretyBond,PRNumber);
    }

    @Step
    public void input_scope_of_work_tab_info(String GeneralDescriptionofWork, String GeneralSpecifications, String ParticularSpecifications) throws Exception {
        tenderPage.inputScopeOfWorkTabInfo(GeneralDescriptionofWork,GeneralSpecifications,ParticularSpecifications);
    }

    @Step
    public void input_items_services_tab_info(String SectionTitle1, String DescriptionofWork1,String QTY1,String UNIT1) throws Exception {
        tenderPage.inputItemsServicesTabInfo(SectionTitle1,DescriptionofWork1,QTY1,UNIT1);
    }

    @Step
    public void input_attachments_tab_info(String ProjectDescription) throws Exception {
        tenderPage.inputAttachmentsTabInfo(ProjectDescription);
    }

    @Step
    public void upload_attachments(String description) throws Exception {
        tenderPage.uploadAttachments(description);
    }

    @Step
    public void submit_tender_for_approve() throws Exception {
        tenderPage.submitTenderForApprove();
    }

    @Step
    public void preview_and_submit_tender(){
        tenderPage.previewAndSubmitTender();
    }

    @Step
    public void change_tender_personInCharge_in_db() throws Exception {
        tenderPage.changeTenderPersonInChargeInDB();
    }

    @Step
    public void admin_approve() throws Exception {
        tenderPage.adminApprove();
    }

    @Step
    public void manager_approve_tender(){
        tenderPage.approveTender();
    }

    @Step
    public void engineer_issue() throws Exception {
        tenderPage.engineerIssueTender();
    }

    @Step
    public void issue_tender(){
        tenderPage.issueTender();
    }

    @Step
    public void check_vendor_submit_status() throws Exception {
        tenderPage.checkVendorSubmitStatus();
    }

    @Step
    public void change_tender_status_in_db(String prNo) throws Exception {
        tenderPage.changeTenderStatusInDB(prNo);
    }

    @Step
    public void check_tender_status() throws Exception {
        tenderPage.checkTenderStatus();
    }


    @Step
    public void contractor_submit(String tenderType) throws Exception {
        tenderPage.contractorSubmitTender(tenderType);
    }

    @Step
    public void clear_tender_from_db() throws Exception {
        tenderPage.clearTenderFromDb();
    }

    @Step
    public void clear_specified_tender_fromDB(String prNumber) throws Exception {
        tenderPage.deleteSpecifiedTenderFromDB(prNumber);
    }

    @Step
    public void input_PRNumber(String prNumber){
        tenderPage.inputPRNumber(prNumber);
    }

    @Step
    public void save_PRInfo(){
        tenderPage.clickPRInfoSaveBtn();
    }

    @Step
    public void saveTender(){
        tenderPage.clickSaveBtn();
    }

    @Step
    public void validate_HeaderMessage(String expectedMsg){
        tenderPage.validateHeaderMessage(expectedMsg);
    }

    @Step
    public void click_itemsServices_tab(){
        tenderPage.clickItemsServicesTab();
    }

    @Step
    public void add_SectionsItems_And_InputValue(int sectionQty, int itemQty){
        add_sections(sectionQty);
        for(int sectionIndex = 1; sectionIndex<=(sectionQty+1); sectionIndex++){
            String sectionTitle = "Section "+sectionIndex+" Test";
            tenderPage.inputSectionTitle(sectionIndex, sectionTitle);
            add_items(sectionIndex, itemQty);
            for(int itemIndex = 1; itemIndex<=(itemQty+1); itemIndex++){
                String randomDescription = "Section "+sectionIndex+" Item "+itemIndex+"\n"+RandomStringUtils.randomAlphabetic(10);
                input_ItemInfo(sectionIndex, itemIndex, randomDescription);
            }
        }
    }

    @Step
    /* Need to make sure SampleTenderInfo has enough sectionTitles and items*/
    public void input_SampleItemsServices(int sectionAddQty, int itemAddQty){
        int i = 0;
        add_sections(sectionAddQty);
        for(int sectionIndex = 1; sectionIndex<=(sectionAddQty+1); sectionIndex++){
            tenderPage.inputSectionTitle(sectionIndex, SampleTenderInfo.sectionTitles[sectionIndex-1]);
            add_items(sectionIndex, itemAddQty);
            for(int itemIndex = 1; itemIndex<=(itemAddQty+1); itemIndex++){
                input_ItemInfo(sectionIndex, itemIndex, SampleTenderInfo.items[i]);
                i=i+1;
            }
        }
    }

    @Step
    public void input_ItemInfo(int sectionIndex, int itemIndex, String sampleItemInfo){
        int randomQTY = (int)Math.round(Math.random()*98+1);
        tenderPage.inputItemDescription(sectionIndex, itemIndex, sampleItemInfo);
        tenderPage.inputItemQty(sectionIndex, itemIndex, Integer.toString(randomQTY));
        tenderPage.selectItemUnit(sectionIndex, itemIndex);
    }

    @Step
    public void click_sectionAction(int index, String action){
        tenderPage.clickSectionAction(index,action);
    }

    @Step
    public void add_sections(int quantity){
        for(int i=1; i<=quantity; i++){
            tenderPage.clickSectionAction(1, "Add Section");
        }
    }

    @Step
    public void add_items(int sectionIndex, int itemQuantity){
        for(int i=1; i<=itemQuantity; i++){
            tenderPage.clickItemAction(sectionIndex, 1, "Add Line");
        }
    }

    @Step
    public void check_itemsQuantity(int itemsNumber, int sectionIndex){
        Assert.assertEquals(itemsNumber, tenderPage.itemsQuantity(sectionIndex));
    }

    @Step
    public void check_sectionsQuantity(int number){
        Assert.assertEquals(number, tenderPage.sectionsQuantity());
    }

    @Step
    public void click_itemAction(int sectionIndex, int itemIndex, String action){
        tenderPage.clickItemAction(sectionIndex, itemIndex, action);
    }

    @Step
    public void check_optionsQuantity(int number, int sectionIndex, int itemIndex){
        Assert.assertEquals(number, tenderPage.OptionQuantity(sectionIndex, itemIndex));
    }

    @Step
    public void input_optionDescriptioin(int sectionIndex, int itemIndex, int optionIndex){
        String randomDescription = String.format("Section "+sectionIndex+" Item "+itemIndex+" Option "+optionIndex+"\n"+RandomStringUtils.randomAlphabetic(10));
        tenderPage.inputOptionDescription(sectionIndex, itemIndex, optionIndex, randomDescription);
    }

    @Step
    public void click_optionAction(int sectionIndex, int itemIndex, int optionIndex, String action){
        tenderPage.clickOptionAction(sectionIndex, itemIndex, optionIndex, action);
    }

    @Step
    public String get_prAmountFromGeneralTab(){
        return tenderPage.getPRAmountFromGeneralTab().replace("$", "");
    }

    @Step
    public void runAnalysisFromReview() throws Exception{
        tenderPage.runAnalysis();
    }

    @Step
    public void vendor_inputRateForItemsLine(){
        tenderPage.vendorInputRateForItemsServices();
    }

    @Step
    public void vendor_inputTermsAndSubmit(){
        tenderPage.vendorInputTermsInfo();
        tenderPage.vendorClickSubmitButton();
    }

    @Step
    public void click_view_all_tenders_button()throws Exception{
        tenderPage.clickViewAllTendersBtn();
    }

    @Step
    public void view_all_page_search()throws Exception{
        tenderPage.viewAllPageSearch();
    }

    @Step
    public void click_tender_item()throws Exception{
        tenderPage.clickTenderItem();
    }

    @Step
    public void cancel_tender()throws Exception{
        tenderPage.cancelTender();
    }

    @Step
    public void reject_tender()throws Exception{
        tenderPage.rejectTender();
    }

    @Step
    public void engineer_check_tender_status(String status)throws Exception{
        tenderPage.checkTenderStatus(status);
    }

    @Step
    public void reset_to_draft()throws Exception{
        tenderPage.resetToDraft();
    }

    public void Verifytenderhistory(int i, String Status, String UserName, String Date) throws Exception {
        tenderPage.clickTenderHistoryStates(i, Status, UserName, Date);
    }

    public void ClickStatus() {
        tenderPage.clickStatus();
    }
        @Step
    public void do_addendum()throws Exception{
        tenderPage.doAddendum();
    }


}
