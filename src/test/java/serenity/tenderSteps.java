package serenity;

import net.thucydides.core.annotations.Step;
import pages.loginPage;
import pages.tenderPage;

/**
 * Created by Poppy_Zhang on 2017/6/21.
 */
public class tenderSteps {
    tenderPage tenderpage;

    @Step
    public void click_create_tender() throws Exception {
        tenderpage.clickCreateTender();
    }

    @Step
    public void input_general_tab_info(String Description, String Location, String ProjectStart, String Duration, String WorkingHours1, String WorkingHours2, String WorkingHours3, String WorkingHours4, String Period, String Retention, String DefectsLiabilityPeriod, String LiquidatedDamages, String SuretyBond, String PRNumber) throws Exception {
        tenderpage.inputGeneralTabInfo(Description,Location,ProjectStart,Duration,WorkingHours1,WorkingHours2,WorkingHours3,WorkingHours4,Period,Retention,DefectsLiabilityPeriod,LiquidatedDamages,SuretyBond,PRNumber);
    }

    @Step
    public void input_scope_of_work_tab_info(String GeneralDescriptionofWork, String GeneralSpecifications, String ParticularSpecifications) throws Exception {
        tenderpage.inputScopeOfWorkTabInfo(GeneralDescriptionofWork,GeneralSpecifications,ParticularSpecifications);
    }

    @Step
    public void input_items_services_tab_info(String SectionTitle1, String DescriptionofWork1,String QTY1,String UNIT1) throws Exception {
        tenderpage.inputItemsServicesTabInfo(SectionTitle1,DescriptionofWork1,QTY1,UNIT1);
    }

    @Step
    public void input_attachments_tab_info(String ProjectDescription) throws Exception {
        tenderpage.inputAttachmentsTabInfo(ProjectDescription);
    }

    @Step
    public void clear_tender_from_db() throws Exception {
        tenderpage.clearTenderFromDb();
    }



}
