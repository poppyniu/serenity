package serenity;

import net.thucydides.core.annotations.Step;
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
    public void submit_tender_for_approve() throws Exception {
        tenderPage.submitTenderForApprove();
    }

    @Step
    public void admin_approve() throws Exception {
        tenderPage.adminApprove();
    }

    @Step
    public void engineer_issue() throws Exception {
        tenderPage.engineerIssueTender();
    }

    @Step
    public void check_vendor_submit_status() throws Exception {
        tenderPage.checkVendorSubmitStatus();
    }

    @Step
    public void change_tender_status_in_db() throws Exception {
        tenderPage.changeTenderStatusInDB();
    }

    @Step
    public void check_tender_status() throws Exception {
        tenderPage.checkTenderStatus();
    }


    @Step
    public void contractor_submit() throws Exception {
        tenderPage.contractorSubmitTender();
    }

    @Step
    public void clear_tender_from_db() throws Exception {
        tenderPage.clearTenderFromDb();
    }

    public void input_PRNumber(String prNumber){
        tenderPage.inputPRNumber(prNumber);
    }

    @Step
    public void validate_HeaderMessage(String expectedMsg){
        tenderPage.validateHeaderMessage(expectedMsg);
    }
}
