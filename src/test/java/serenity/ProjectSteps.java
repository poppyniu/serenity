package serenity;

import net.thucydides.core.annotations.Step;
import pages.ITQPage;
import pages.ProjectPage;

/**
 * Created by Poppy_Zhang on 2017/6/21.
 */
public class ProjectSteps {
    ProjectPage projectPage;

    @Step
    public void create_project(String poNo) throws Exception {
        projectPage.createProject(poNo);
    }

    @Step
    public void create_project1(String poNo) throws Exception {
        projectPage.createProject1(poNo);
    }

    @Step
    public void first_submission(String completionAmount) throws Exception {
        projectPage.firstSubmission(completionAmount);
    }

    @Step
    public void engineer_approve_submission() throws Exception {
        projectPage.engineerApproveSubmission();
    }

    @Step
    public void second_submission(String completionAmount1) throws Exception {
        projectPage.secondSubmission(completionAmount1);
    }

    @Step
    public void engineer_approve_second_submission() throws Exception {
        projectPage.engineerApproveSecondSubmission();
    }

    @Step
    public void third_final_submission(String completionAmount2) throws Exception {
        projectPage.thirdFinalSubmission(completionAmount2);
    }

    @Step
    public void check_remind_upload_doc() throws Exception {
        projectPage.checkUploadDocInfo();
    }

    @Step
    public void vendor_upload_docs_submit() throws Exception {
        projectPage.uploadDocsAndSubmit();
    }

    @Step
    public void engineer_approve_third_submission() throws Exception {
        projectPage.engineerApproveThirdSubmission();
    }

    @Step
    public void remind_approve_doc() throws Exception {
        projectPage.remindApproveDoc();
    }

    @Step
    public void approve_doc_check_status() throws Exception {
        projectPage.approveDocCheckStatus();
    }

    @Step
    public void clear_project_in_db(String poNo) throws Exception {
        projectPage.clearProjectTable(poNo);
    }

    @Step
    public void full_submission(String amount) throws Exception {
        projectPage.fullSubmission(amount);
    }

    @Step
    public void reject_Submission() throws Exception {
        projectPage.rejectSubmission();
    }

    @Step
    public void vendor_check_project_status() throws Exception {
        projectPage.vendorCheckProjectStatus();
    }

    @Step
    public void vendor_check_amount(String amount) throws Exception {
        projectPage.vendorCheckAmount(amount);
    }

    @Step
    public void do_po_validation() throws Exception {
        projectPage.poValidation();
    }

    @Step
    public void do_request_change() throws Exception {
        projectPage.poRequestChange();
    }

    @Step
    public void vendor_can_edit_last_submission() throws Exception {
        projectPage.vendorCheckCanEditSubmission();
    }


}
